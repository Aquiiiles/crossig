import React, { useState, useEffect, useCallback, useRef } from "react";
import { ButtonWrapper, Wrapper } from "./style";
import BasicInfo from "../../../../shared/molecules/contact/BasicInfo";
import Addresses from "../../../../shared/molecules/contact/Addresses";
import ContactInfoForm from "../../../../shared/molecules/contact/ContactInfoForm";
import {
  CONTACT_INFO,
  CREATE_NEW_CONTACT,
} from "../../../../constants/languageKeys";
import {
  mapToCountryNames,
  mapToCountryCodes,
} from "../../../../shared/util/countryMappers";
import {
  useContactDispatch,
  useContactSelector,
} from "../../../../redux/store";
import { valuesToISOString } from "./utils/dateUtils";
import { emailListToData } from "./utils/emailUtils";
import { phoneObjectToData } from "./utils/phoneUtils";
import { CONTACT_URL } from "../../../../api/constants/routes";
import { createContactStore } from "../../../../redux/store";
import { COUNTRIES_URL } from "../../../../api/constants/routes";
import { useFetchData } from "../../../../api/hooks/useFetchData";
import { RESOLVED } from "../../../../api/reducers/constants";
import LinkWrapper from "../../../../shared/atoms/contact/LinkWrapper";
import ContactButton from "../../../../shared/atoms/contact/ContactButton";
import { useHistory } from "react-router-dom";
import { actions as contactInfoActions } from "../../../../redux/contactInfoSlice";
import { actions as basicInfoActions } from "../../../../redux/basicInfoSlice";
import { actions as addressesActions } from "../../../../redux/addressesSlice";

const ContactInfo: React.FC = () => {
  const basicInfoData = useContactSelector((state) => state.basicInfo);
  const addressData = useContactSelector((state) => state.addresses);
  const contactInfoData = useContactSelector((state) => state.contactInfo);
  const { fetchData: API } = useFetchData();
  const formRef = useRef<HTMLFormElement>(null);
  const { state, get } = useFetchData();
  const [countries, setCountries] = useState<Array<any> | null>(null);

  const history = useHistory();
  const dispatch = useContactDispatch();

  useEffect(() => {
    get(COUNTRIES_URL);
  }, []);

  useEffect(() => {
    if (state.status === RESOLVED) {
      setCountries(state.response.data);
    }
  });

  useEffect(() => {
    createContactStore();
  }, []);

  const hasFormErrors = () => {
    if (formRef.current) {
      const errors = formRef.current.querySelectorAll(".has-error").length;
      if (errors > 0) {
        alert("There are errors in the form. Please fix them and try again.");
        return true;
      }
      return false;
    }
  };

  const createContact = () => {
    if (!hasFormErrors()) {
      const { dateDay, dateMonth, dateYear } = basicInfoData;
      const { contactType } = basicInfoData;
      const address = {
        zipCode: addressData.postalCode,
        country: {
          id: Number(addressData.country),
        },
        apartmentNr: "",
        addressType: {
          id: addressData.isSameAddress ? 1000002 : 1000000,
        },
        streetName: addressData.street,
        cityName: addressData.city,
        houseNr: addressData.houseNumber,
        isPreferredDeliveryAddress: addressData.isSameAddress,
      };
      let addresses = [address];

      if (!addressData.isSameAddress) {
        addresses = [
          ...addresses,
          {
            ...address,
            zipCode: addressData.dispatchPostalCode,
            country: {
              id: Number(addressData.dispatchCountry),
            },
            streetName: addressData.dispatchStreet,
            cityName: addressData.dispatchCity,
            houseNr: addressData.dispatchHouseNumber,
          },
        ];
      } else {
        addresses.push(address);
      }

      const payload = {
        dateOfBirth:
          contactType === "1"
            ? valuesToISOString(dateDay, dateMonth, dateYear)
            : undefined,
        firstName: basicInfoData.firstName,
        name:
          contactType === "1"
            ? basicInfoData.lastName
            : basicInfoData.companyName,
        middleName: "",
        identifiers: [
          {
            idType: {
              id: 1000000,
            },
            idValue: basicInfoData.oib,
          },
        ],
        entityType: {
          id: Number(basicInfoData.contactType),
        },
        addresses,
        emails: emailListToData(contactInfoData.emailAddresses),
        telephones: phoneObjectToData(contactInfoData.mobilePhones),
      };

      API("POST", CONTACT_URL, {}, payload);
    }
  };

  return (
    <Wrapper
      id="contact-info-main-container"
      ref={formRef}
      onSubmit={(event) => {
        event.preventDefault();
        createContact();
      }}
    >
      <h3>{CREATE_NEW_CONTACT.TITLE}</h3>
      <p style={{ marginBottom: "1.875rem" }}>{CREATE_NEW_CONTACT.SUBTITLE}</p>
      <BasicInfo operation="create" />
      {countries && (
        <Addresses
          countries={mapToCountryNames(countries)}
          operation="create"
        />
      )}
      {countries && (
        <ContactInfoForm
          countries={mapToCountryCodes(countries)}
          operation="create"
        />
      )}
      <ButtonWrapper>
        <LinkWrapper
          title={CONTACT_INFO.CANCEL}
          handleClick={() => {
            [basicInfoActions, addressesActions, contactInfoActions].forEach(
              (action) => dispatch(action["resetFields"]())
            );
            history.replace({ pathname: "/", state: { doSearch: true } });
          }}
          disabled={false}
        />
        <ContactButton
          handleClick={createContact}
          label={CONTACT_INFO.CREATE_CONTACT}
        />
      </ButtonWrapper>
    </Wrapper>
  );
};

export default ContactInfo;
