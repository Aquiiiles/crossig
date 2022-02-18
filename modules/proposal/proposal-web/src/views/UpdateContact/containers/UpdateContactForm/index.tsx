import React, { useState, useEffect, useCallback } from "react";
import { Wrapper, ButtonWrapper } from "./styles";
import BasicInfo from "../../../../shared/molecules/contact/BasicInfo";
import Addresses from "../../../../shared/molecules/contact/Addresses";
import ContactInfoForm from "../../../../shared/molecules/contact/ContactInfoForm";
import {
  CONTACT_INFO,
  UPDATE_CONTACT,
} from "../../../../constants/languageKeys";
import {
  mapToCountryNames,
  mapToCountryCodes,
} from "../../../../shared/util/countryMappers";
import { actions as basicInfoActions } from "../../../../redux/basicInfoSlice";
import { actions as addressesSetters } from "../../../../redux/addressesSlice";
import { actions as contactInfoSetters } from "../../../../redux/contactInfoSlice";
import store, { useContactDispatch } from "../../../../redux/store";
import { PhoneNumber } from "../../../../shared/types/contact";
import { contactTypes } from "../../../../constants/contactConstants";
import LinkWrapper from "../../../../shared/atoms/contact/LinkWrapper";
import ContactButton from "../../../../shared/atoms/contact/ContactButton";
import API from "../../../../api";
import { CONTACT_URL, COUNTRIES_URL } from "../../../../api/constants/routes";
import { useFetchData } from "../../../../api/hooks/useFetchData";
import { RESOLVED } from "../../../../api/reducers/constants";
import { useHistory } from "react-router-dom";

const UpdateContactForm: React.FC<{ contactResponse: any }> = ({
  contactResponse,
}) => {
  const history = useHistory();
  const dispatch = useContactDispatch();
  const data = contactResponse[0];
  const { state, get } = useFetchData();
  const [countries, setCountries] = useState<Array<any> | null>(null);

  useEffect(() => {
    get(COUNTRIES_URL);
  }, []);

  useEffect(() => {
    if (state.status === RESOLVED) {
      setCountries(state.response.data);
    }
  });

  const setBasicInfoFields = () => {
    const actions = basicInfoActions;

    const type = data.entityType.id.toString();
    dispatch(actions.setContactType(type));

    if (contactTypes.Individual === type) {
      dispatch(actions.setFirstName(data.firstName));
      dispatch(actions.setLastName(data.name));

      const dateOfBirth = new Date(data.dateOfBirth);

      dispatch(actions.setDateDay(dateOfBirth.getDay().toString()));
      dispatch(actions.setDateMonth((dateOfBirth.getMonth() + 1).toString()));
      dispatch(actions.setDateYear(dateOfBirth.getFullYear().toString()));
    } else {
      dispatch(actions.setCompanyName(data.subscriptions[0].companyName));
      dispatch(
        actions.setSubsidiaryNumber(data.subscriptions[0].subsidiaryNumber)
      );
    }

    dispatch(actions.setOIB(data.identifiers[0].idValue));

    const foreignerStatus = Boolean(data.foreignCitizen).valueOf();
    dispatch(actions.setForeignerStatus(foreignerStatus));
  };

  const setContactInfoFields = () => {
    const emailAddresses = data.emails.map(
      (emailObject: any) => emailObject.email
    );

    const mobilePhones = data.telephones.map((telephoneObject: any) => {
      return {
        type: telephoneObject.telephoneType.id,
        countryCode: telephoneObject.countryDialCode.desc,
        areaCode: telephoneObject.telephoneAreaCode,
        phoneNumber: telephoneObject.telephoneNumber,
      } as PhoneNumber;
    });

    dispatch(contactInfoSetters.setEmailAddresses(emailAddresses));
    dispatch(contactInfoSetters.setMobilePhones(mobilePhones));
  };

  const setAddressFields = () => {
    const address = data.addresses[0];
    const isSameAddress = address.isPreferredDeliveryAddress;
    addressesSetters.setIsSameAddress(isSameAddress);

    const country = address.country.desc;
    const city = parseInt(address.cityId);
    const postalCode = address.zipCode;
    const street = address.streetName;
    const houseNumber = address.houseNr;

    dispatch(addressesSetters.setCountry(country));
    dispatch(addressesSetters.setCity(city));
    dispatch(addressesSetters.setPostalCode(postalCode));
    dispatch(addressesSetters.setStreet(street));
    dispatch(addressesSetters.setHouseNumber(houseNumber));

    if (!isSameAddress) {
      const dispatchAddress = data.addresses[1];

      const country = dispatchAddress.country.desc;
      const city = parseInt(dispatchAddress.cityId);
      const postalCode = dispatchAddress.zipCode;
      const street = dispatchAddress.streetName;
      const houseNumber = dispatchAddress.houseNr;
  
      dispatch(addressesSetters.setDispatchCountry(country));
      dispatch(addressesSetters.setDispatchCity(city));
      dispatch(addressesSetters.setDispatchPostalCode(postalCode));
      dispatch(addressesSetters.setDispatchStreet(street));
      dispatch(addressesSetters.setDispatchHouseNumber(houseNumber));
    }
  };

  useEffect(() => {
    setBasicInfoFields();
    setAddressFields();
    setContactInfoFields();
  }, []);

  const createBasicInfoDTO = () => {
    const state = store.getState().basicInfo;

    let payload = {
      entityType: {
        id: state.contactType,
      },
      identifiers: [
        {
          idValue: state.oib,
        },
      ],
      foreignCitizen: state.foreignerStatus,
    };

    if (contactTypes.Individual === state.contactType) {
      const year = parseInt(state.dateYear);
      const monthIndex = parseInt(state.dateMonth) - 1;
      const day = parseInt(state.dateDay);
      const dateOfBirth = new Date(year, monthIndex, day).toString();

      const individualData = {
        firstName: state.firstName,
        name: state.lastName,
        dateOfBirth: dateOfBirth,
      };

      payload = { ...payload, ...individualData };
    } else {
      const entityData = {
        subscriptions: [
          {
            companyName: state.companyName,
            subsidiaryNumber: state.subsidiaryNumber,
          },
        ],
      };

      payload = { ...payload, ...entityData };
    }

    return payload;
  };

  const createContactInfoDTO = () => {
    const state = store.getState().contactInfo;

    const emailDTOs = state.emailAddresses.map((emailString) => {
      return { email: emailString };
    });

    const telephoneDTOs = state.mobilePhones.map((phone: PhoneNumber) => {
      return {
        countryDialCode: {
          desc: phone.type,
        },
        telephoneType: {
          id: phone.type,
        },
        telephoneAreaCode: phone.areaCode,
        telephoneNumber: phone.phoneNumber,
      };
    });

    return {
      emails: emailDTOs,
      telephones: telephoneDTOs,
    };
  };

  const createContactDTO = () => {
    const basicInfoDTO = createBasicInfoDTO();
    const contactInfoDTO = createContactInfoDTO();
    return { ...basicInfoDTO, ...contactInfoDTO };
  };

  const handleUpdateContact = () => {
    const response = API.put(CONTACT_URL, createContactDTO());
    response.then((result) => {
      // message
    });
  };

  return (
    <Wrapper id="update-contact-form-main-container">
      <h3>{UPDATE_CONTACT.TITLE}</h3>
      <p className="subtitle">{UPDATE_CONTACT.SUBTITLE}</p>
      <BasicInfo key="update-contact-basic-info" />
      {countries && (
        <Addresses
          countries={mapToCountryNames(countries)}
          key="update-contact-addresses"
        />
      )}
      {countries && (
        <ContactInfoForm
          countries={mapToCountryCodes(countries)}
          key="update-contact-contact-info"
        />
      )}

      <ButtonWrapper>
        <LinkWrapper
          title={CONTACT_INFO.CANCEL}
          handleClick={() => {
            history.goBack();
          }}
          disabled={false}
        />
        <ContactButton
          handleClick={handleUpdateContact}
          label={UPDATE_CONTACT.SUBMIT_BUTTON}
        />
      </ButtonWrapper>
    </Wrapper>
  );
};

export default UpdateContactForm;
