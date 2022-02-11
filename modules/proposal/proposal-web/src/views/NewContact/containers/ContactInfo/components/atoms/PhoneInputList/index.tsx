import React, { MouseEventHandler, useEffect, useState } from "react";
import { ClayInput, ClaySelect, ClaySelectWithOption } from "@clayui/form";
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
import getUnicodeFlagIcon from "country-flag-icons/unicode";
import { croatiaContactInfoCountryObject } from "../../../../../../../constants/contactConstants";

export interface PhoneNumber {
  type: string;
  countryCode: string;
  areaCode: string;
  phoneNumber: string;
}

interface props {
  phoneNumbers: Array<PhoneNumber>;
  handleChange: Function;
  addPhoneInput: MouseEventHandler;
  countries: Array<Country>;
  areaCodeOptions: Array<any>;
}
export interface Country {
  label: string;
  value: string;
  flagKey: string;
}

export const createEmptyPhoneNumber = (type: string) => {
  return {
    type: type,
    areaCode: "",
    countryCode: croatiaContactInfoCountryObject.value,
    phoneNumber: "",
  } as PhoneNumber;
};

const PhoneInputList: React.FC<props> = props => {
  const [hasSomeInvalidPhone, setSomeInvalidPhone] = useState(false);

  const defaultAreaCodeOption = {
    value: "",
    label: "Area Code",
  };

  useEffect(() => {
    validatePhones();
  }, [props.phoneNumbers]);

  const shouldDisableLink = () => {
    return props.phoneNumbers.length === MAXIMUM_MOBILE_PHONES;
  };

  const getFlagSVG = (country: Country) => {
    return getUnicodeFlagIcon(country.flagKey);
  };

  const createOptionsWithFlags = () => {
    return props.countries.map(country => {
      return {
        label: getFlagSVG(country) + " " + country.label,
        value: country.value,
      };
    });
  };

  const validatePhones = () => {
    const invalidityChecks = props.phoneNumbers
      .filter(
        phone => phone.countryCode === croatiaContactInfoCountryObject.label
      )
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

    if (countryCode !== croatiaContactInfoCountryObject.label) {
      style += " hidden-select";
    }

    return style;
  };

  const handlePhoneInputWidth = (countryCode: string) => {
    let style = "phone-number";
    if (countryCode !== croatiaContactInfoCountryObject.label) {
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
                <ClaySelectWithOption
                  id={`countryCodeSelect${index}`}
                  className="country-code"
                  onChange={e => handleChange(index, e, "countryCode")}
                  value={phoneNumber.countryCode}
                  options={createOptionsWithFlags()}
                ></ClaySelectWithOption>

                <ClaySelect
                  aria-label="Select Label"
                  id={`areaCodeSelect${index}`}
                  className={displayAreaCode(phoneNumber.countryCode)}
                  onChange={e => handleChange(index, e, "areaCode")}
                  value={phoneNumber.areaCode}
                >
                  <ClaySelect.Option
                    className="area-code-default-option"
                    disabled={true}
                    key={defaultAreaCodeOption.value}
                    label={defaultAreaCodeOption.label}
                    value={defaultAreaCodeOption.value}
                  />
                  {props.areaCodeOptions.map(item => (
                    <ClaySelect.Option
                      className="area-code-option"
                      key={item.value}
                      label={item.label}
                      value={item.value}
                    />
                  ))}
                </ClaySelect>

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
