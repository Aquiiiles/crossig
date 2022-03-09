import React, { useState, useEffect, useRef } from "react";
import { useHistory } from "react-router-dom";
import { ButtonWrapper, Wrapper } from "./style";
import BasicInfo from "../../../../shared/molecules/contact/BasicInfo";
import Addresses from "../../../../shared/molecules/contact/Addresses";
import ContactInfoForm from "../../../../shared/molecules/contact/ContactInfoForm";
import LinkWrapper from "../../../../shared/atoms/contact/LinkWrapper";
import ContactButton from "../../../../shared/atoms/contact/ContactButton";
import Modal from "../../../../shared/atoms/contact/Modal";
import useFormState from "../../../../shared/hooks/useFormState";
import {
  mapToCountryNames,
  mapToCountryCodes,
} from "../../../../shared/util/countryMappers";
import {
  CONTACT_INFO,
  CREATE_NEW_CONTACT,
  ROLES_ON_POLICY,
} from "../../../../constants/languageKeys";
import { useSelector, useDispatch } from "../../../../redux/store";
import { valuesToISOString } from "./utils/dateUtils";
import { emailListToData } from "./utils/emailUtils";
import { phoneObjectToData } from "./utils/phoneUtils";
import API from "../../../../api";
import { CONTACT_URL } from "../../../../api/constants/routes";
import { COUNTRIES_URL } from "../../../../api/constants/routes";
import { useFetchData } from "../../../../api/hooks/useFetchData";
import { RESOLVED } from "../../../../api/reducers/constants";
import { SUCCESS_CODE } from "../../../../api/reducers/constants";
import ClayForm from "@clayui/form";
import * as constants from "../../../ContactSearch/constants/searchResult";
import { contactTypes } from "../../../../constants/contactConstants";
import { actions } from "../../../../redux";

const ContactInfo: React.FC = () => {
  const dispatch = useDispatch();
  const basicInfoData = useSelector((state) => state.basicInfo);
  const addressData = useSelector((state) => state.addresses);
  const contactInfoData = useSelector((state) => state.contactInfo);
  const formRef = useRef<HTMLFormElement>(null);
  const { state, get } = useFetchData();
  const [countries, setCountries] = useState<Array<any> | null>(null);
  const { contactType } = useSelector((state) => state.basicInfo);
  const [showModal, setShowModal] = useState(false);
  const [isCreateSuccessful, setCreateSuccess] = useState(false);
  const [canSubmit] = useFormState([
    ...Object.values(basicInfoData),
    ...Object.values(addressData),
  ]);

  const history = useHistory();

  useEffect(() => {
    get(COUNTRIES_URL);
  }, []);

  useEffect(() => {
    if (state.status === RESOLVED) {
      setCountries(state.response.data);
    }
  });

  const isLegalEntity = () => {
    return contactType === contactTypes.Legal_Entity;
  };

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

      const response = API.post(CONTACT_URL, payload);
      window.scrollTo(0, 0);

      response
        .then(() => {
          setCreateSuccess(true);
          dispatch(actions.contactsInPolicy.resetFields());
          dispatch(
            actions.contactsInPolicy.setPolicyHolder({
              [constants.EXT_NUMBER_KEY]: 1,
              [constants.OIB_KEY]: basicInfoData.oib,
              [constants.SUB_KEY]: basicInfoData.subsidiaryNumber,
              [constants.NAME_KEY]:
                basicInfoData.firstName + basicInfoData.lastName,
              [constants.ROLES_KEY]: [ROLES_ON_POLICY.INSURED],
            })
          );
        })
        .catch(() => {
          setCreateSuccess(false);
          setShowModal(true);
        });
    }
  };

  useEffect(() => {
    if (isCreateSuccessful) {
      history.push("/product?success=true");
    }
  }, [isCreateSuccessful]);

  return (
    <Wrapper
      id="contact-info-main-container"
      ref={formRef}
      onSubmit={(event) => {
        event.preventDefault();
        createContact();
      }}
    >
      <Modal
        visible={showModal && !isCreateSuccessful}
        onClose={() => setShowModal(false)}
        title={CREATE_NEW_CONTACT.TITLE}
        body={CREATE_NEW_CONTACT.CREATE_CONTACT_FAILURE}
        timeOut={5000}
      />

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
      <ButtonWrapper className={isLegalEntity() ? "standard-wrapper" : ""}>
        <LinkWrapper
          title={CONTACT_INFO.CANCEL}
          handleClick={() => {
            [actions.basicInfo, actions.addresses, actions.contactInfo].forEach(
              (action) => dispatch(action["resetFields"]())
            );
            history.replace({ pathname: "/", state: { doSearch: true } });
          }}
          disabled={false}
        />
        {isLegalEntity() ? (
          <ClayForm.Group
            className={isLegalEntity() ? "legal-entity-form" : ""}
          >
            <ContactButton
              handleClick={() => {
                return;
              }}
              label={CREATE_NEW_CONTACT.SUBMIT_BUTTON}
            />
            <div>{CREATE_NEW_CONTACT.BACKOFFICE_NOTIFICATION}</div>
          </ClayForm.Group>
        ) : (
          <ContactButton
            disabled={!canSubmit}
            handleClick={createContact}
            label={CONTACT_INFO.CREATE_CONTACT}
          />
        )}
      </ButtonWrapper>
    </Wrapper>
  );
};

export default ContactInfo;
