import React, { useState, useEffect, useCallback, useRef } from "react";
import { Wrapper } from "./style";
import BasicInfo from "./components/molecules/BasicInfo";
import Addresses from "./components/molecules/Addresses";
import ContactInfoForm from "./components/molecules/ContactInfoForm";
import { CREATE_NEW_CONTACT } from "../../../../constants/languageKeys";
import {
  mapToCountryNames,
  mapToCountryCodes,
} from "../../../../shared/util/countryMappers";
import { useContactSelector } from "../../../../redux/store";
import { valuesToISOString } from "./utils/dateUtils";
import { useFetchData } from "../../../../api/hooks/useFetchData";
import { CONTACT_URL } from "../../../../api/constants/routes";

declare const Liferay: any;

const ContactInfo: React.FC = () => {
  const basicInfoData = useContactSelector(state => state.basicInfo);
  const addressData = useContactSelector(state => state.address);
  const contactInfoData = useContactSelector(state => state.contactInfo);
  const { fetchData: API } = useFetchData();
  const [countries, setCountries] = useState(null);
  const formRef = useRef<HTMLFormElement>(null);

  const loadCountries = useCallback(() => {
    Liferay.Service(
      "/country/get-countries",
      {
        active: true,
      },
      (countriesArray: any) => {
        setCountries(countriesArray);
      }
    );
  }, []);

  useEffect(() => {
    loadCountries();
  }, [loadCountries]);

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
        dateOfBirth: valuesToISOString(dateDay, dateMonth, dateYear),
        firstName: basicInfoData.firstName,
        name: basicInfoData.lastName,
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
      };

      API("POST", CONTACT_URL, {}, payload);
    }
  };

  return (
    <Wrapper
      id="ContactInfo-main-container"
      ref={formRef}
      onSubmit={event => {
        event.preventDefault();
        createContact();
      }}
    >
      <h3>{CREATE_NEW_CONTACT.TITLE}</h3>
      <p style={{ marginBottom: "1.875rem" }}>{CREATE_NEW_CONTACT.SUBTITLE}</p>
      <BasicInfo />
      {countries && <Addresses countries={mapToCountryNames(countries)} />}
      {countries && (
        <ContactInfoForm countries={mapToCountryCodes(countries)} />
      )}
    </Wrapper>
  );
};

export default ContactInfo;
