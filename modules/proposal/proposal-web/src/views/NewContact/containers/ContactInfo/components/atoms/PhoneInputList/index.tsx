import React, { MouseEventHandler, useEffect, useState } from "react";
import { ClayInput } from "@clayui/form";
import {
  CONTACT_INFO_ADD_MOBILE_PHONE,
  CONTACT_INFO_PHONE_NUMBER,
  CONTACT_INFO_PHONE_NUMBER_ERROR,
} from "../../../../../../../constants/languageKeys";
import { MAXIMUM_MOBILE_PHONES } from "../../../../../constants/index";
import {
  Error,
  OrderedListWrapper,
  PhoneNumberWrapper,
  StyledFormGroup,
} from "./styles";
import LinkWrapper from "../LinkWrapper";
import { countryCodes } from "../../../../../../../constants/defaultCountryConfiguration";

import AreaCodeSelect from "../../../../../../../shared/atoms/AreaCodeSelect";
import CountryCodeSelect from "../../../../../../../shared/atoms/CountryCodeSelect";

export interface PhoneNumber {
  type: string;
  countryCode: string;
  areaCode: string;
  phoneNumber: string;
}

type propsType = {
  phoneNumbers: Array<PhoneNumber>;
  handleChange: Function;
  addPhoneInput: MouseEventHandler;
  countries: Array<Country>;
  areaCodeOptions: Array<any>;
};
export interface Country {
  label: string;
  value: string;
  flagKey: string;
}

export const createEmptyPhoneNumber = (type: string) => {
  return {
    type: type,
    areaCode: "",
    countryCode: countryCodes.value,
    phoneNumber: "",
  } as PhoneNumber;
};

const PhoneInputList: React.FC<propsType> = (props: propsType) => {
  const [hasSomeInvalidPhone, setSomeInvalidPhone] = useState(false);

  useEffect(() => {
    validatePhones();
  }, [props.phoneNumbers]);

  const shouldDisableLink = () => {
    return props.phoneNumbers.length === MAXIMUM_MOBILE_PHONES;
  };

  const validatePhones = () => {
    const invalidityChecks = props.phoneNumbers
      .filter(phone => phone.countryCode === countryCodes.label)
      .map(phone => {
        if (phone.phoneNumber === "") {
          return false;
        }

        let valid =
          phone.phoneNumber.length >= 4 && phone.phoneNumber.length <= 7;

        return !valid;
      });

    setSomeInvalidPhone(
      invalidityChecks.filter(item => item === true).length > 0
    );
  };

  const handleChange = (index: number, e: any, property: string) => {
    props.handleChange(index, e, property);
  };

  const displayAreaCode = (countryCode: string) => {
    let style = "area-code";

    if (countryCode !== countryCodes.label) {
      style += " hidden-select";
    }

    return style;
  };

  const handlePhoneInputWidth = (countryCode: string) => {
    let style = "phone-number";
    if (countryCode !== countryCodes.label) {
      style += " stretch-phone-number";
    }

    return style;
  };

  return (
    <StyledFormGroup>
      <OrderedListWrapper>
        {props.phoneNumbers.map((phoneNumber, index) => {
          return (
            <li key={`phoneInputList${index}`}>
              <label>{CONTACT_INFO_PHONE_NUMBER}</label>
              <PhoneNumberWrapper>
                <CountryCodeSelect
                  id={`countryCodeSelect${index}`}
                  className="country-code"
                  handleChange={e => handleChange(index, e, "countryCode")}
                  entity={phoneNumber.countryCode}
                  countries={props.countries}
                />

                <AreaCodeSelect
                  id={`areaCodeSelect${index}`}
                  className={displayAreaCode(phoneNumber.countryCode)}
                  entity={phoneNumber.areaCode}
                  disabled={false}
                  handleChange={e => handleChange(index, e, "areaCode")}
                />

                <ClayInput
                  id={`phoneNumber${index}`}
                  className={handlePhoneInputWidth(phoneNumber.countryCode)}
                  type="number"
                  onChange={e => handleChange(index, e, "phoneNumber")}
                  value={phoneNumber.phoneNumber}
                />
              </PhoneNumberWrapper>
            </li>
          );
        })}
      </OrderedListWrapper>
      {hasSomeInvalidPhone && <Error>{CONTACT_INFO_PHONE_NUMBER_ERROR}</Error>}
      <LinkWrapper
        title={CONTACT_INFO_ADD_MOBILE_PHONE}
        handleClick={props.addPhoneInput}
        disabled={shouldDisableLink()}
      />
    </StyledFormGroup>
  );
};

export default PhoneInputList;
