import { contactTypes } from "../../../../constants/contactConstants";
import { PhoneNumber } from "../../../../shared/types";
import { AnyAction, Dispatch } from "@reduxjs/toolkit";

export const createBasicInfoDTO = (store: any) => {
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

export const createAddressesDTO = (store: any) => {
  const state = store.getState().addresses;

  const address = {
    cityId: state.city,
    cityName: state.cityName,
    country: { desc: state.country },
    zipCode: state.postalCode,
    streetName: state.street,
    houseNr: state.houseNumber,
    isPreferredDeliveryAddress: state.isSameAddress,
  };

  if (state.isSameAddress) {
    return { addresses: [address] };
  }

  const dispatchAddress = {
    city: state.dispatchCity,
    cityName: state.dispatchCityName,
    country: { desc: state.dispatchCountry },
    zipCode: state.dispatchPostalCode,
    streetName: state.dispatchStreet,
    houseNr: state.dispatchHouseNumber,
    isPreferredDeliveryAddress: !state.isSameAddress,
  };

  return { addresses: [address, dispatchAddress] };
};

export const createContactInfoDTO = (store: any) => {
  const state = store.getState().contactInfo;

  const emailDTOs = state.emailAddresses.map((emailString: string) => {
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

export const setBasicInfoFields = (
  data: any,
  dispatch: Dispatch<AnyAction>,
  actions: any
) => {
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

export const setAddressFields = (
  data: any,
  dispatch: Dispatch<AnyAction>,
  actions: any
) => {
  const address = data.addresses[0];
  const isSameAddress = address.isPreferredDeliveryAddress;
  actions.setIsSameAddress(isSameAddress);

  const country = address.country.desc;
  const city = parseInt(address.cityId);
  const cityName = address.cityName;
  const postalCode = address.zipCode;
  const street = address.streetName;
  const houseNumber = address.houseNr;

  dispatch(actions.setCountry(country));
  dispatch(actions.setCity(city));
  dispatch(actions.setCityName(cityName));
  dispatch(actions.setPostalCode(postalCode));
  dispatch(actions.setStreet(street));
  dispatch(actions.setHouseNumber(houseNumber));

  if (!isSameAddress) {
    const dispatchAddress = data.addresses[1];

    const country = dispatchAddress.country.desc;
    const city = parseInt(dispatchAddress.cityId);
    const postalCode = dispatchAddress.zipCode;
    const street = dispatchAddress.streetName;
    const houseNumber = dispatchAddress.houseNr;

    dispatch(actions.setDispatchCountry(country));
    dispatch(actions.setDispatchCity(city));
    dispatch(actions.setDispatchPostalCode(postalCode));
    dispatch(actions.setDispatchStreet(street));
    dispatch(actions.setDispatchHouseNumber(houseNumber));
  }
};

export const setContactInfoFields = (
  data: any,
  dispatch: Dispatch<AnyAction>,
  actions: any
) => {
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

  dispatch(actions.setEmailAddresses(emailAddresses));
  dispatch(actions.setMobilePhones(mobilePhones));
};
