import React, { MouseEventHandler, useEffect, useState } from "react";
import { ClayInput } from "@clayui/form";
import { CONTACT_INFO } from "../../../../constants/languageKeys";
import {
  Error,
  OrderedListWrapper,
  PhoneNumberWrapper,
  StyledFormGroup,
} from "./styles";
import LinkWrapper from "../../LinkWrapper";
import { countryCodes } from "../../../../constants/defaultCountryConfiguration";
import AreaCodeSelect from "../../../atoms/contact/AreaCodeSelect";
import CountryCodeSelect from "../../../atoms/contact/CountryCodeSelect";
import { PhoneNumber } from "../../../types";
import { MAXIMUM_MOBILE_PHONES } from "../../../../constants/contactConstants";
import { shouldDisableInput } from "../../../util/commonFunctions";
import { Country } from "../../../../shared/types";

type propsType = {
  phoneNumbers: Array<PhoneNumber>;
  handleChange: (index: number, e: React.ChangeEvent, property: string) => void;
  addPhoneInput: MouseEventHandler;
  countries: Array<Country>;
  disableLink?: boolean;
  disableInput?: boolean;
  phoneTypeSelect?: (index: number) => React.ReactNode;
};

const PhoneInputList: React.FC<propsType> = (props: propsType) => {
  const [hasSomeInvalidPhone, setSomeInvalidPhone] = useState(false);

  useEffect(() => {
    validatePhones();
  }, [props.phoneNumbers]);

  const shouldDisableLink = () => {
    let valid = props.phoneNumbers.length === MAXIMUM_MOBILE_PHONES;

    if (props.disableLink) {
      valid = valid || props.disableLink;
    }

    return valid;
  };

  const validatePhones = () => {
    const invalidityChecks = props.phoneNumbers
      .filter((phone) => phone.countryCode === countryCodes.label)
      .map((phone) => {
        if (phone.phoneNumber === "") {
          return false;
        }

        const valid =
          phone.phoneNumber.length >= 4 && phone.phoneNumber.length <= 7;

        return !valid;
      });

    setSomeInvalidPhone(
      invalidityChecks.filter((item) => item === true).length > 0
    );
  };

  const isCroatia = (index: number) => {
    const phone = props.phoneNumbers[index];
    return phone.countryCode && phone.countryCode === countryCodes.value;
  };

  const moreThanSevenNumbers = (e: any, property: string) => {
    return property === "phoneNumber" && e.target.value.toString().length > 7;
  };

  const handleChange = (index: number, e: any, property: string) => {
    if (isCroatia(index) && moreThanSevenNumbers(e, property)) {
      return;
    }

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
            <>
              {index > 0 &&
                props.phoneTypeSelect &&
                props.phoneTypeSelect(index)}
              <li key={`phoneInputList${index}`}>
                <label>{CONTACT_INFO.PHONE_NUMBER}</label>
                <PhoneNumberWrapper>
                  <CountryCodeSelect
                    id={`countryCodeSelect${index}`}
                    className="country-code"
                    handleChange={(e) => handleChange(index, e, "countryCode")}
                    entity={phoneNumber.countryCode}
                    countries={props.countries}
                    disabled={shouldDisableInput(props)}
                  />

                  <AreaCodeSelect
                    id={`areaCodeSelect${index}`}
                    className={displayAreaCode(phoneNumber.countryCode)}
                    entity={phoneNumber.areaCode}
                    disabled={shouldDisableInput(props)}
                    handleChange={(e) => handleChange(index, e, "areaCode")}
                  />

                  <ClayInput
                    id={`phoneNumber${index}`}
                    className={handlePhoneInputWidth(phoneNumber.countryCode)}
                    type="number"
                    onChange={(e) => handleChange(index, e, "phoneNumber")}
                    value={phoneNumber.phoneNumber}
                    disabled={shouldDisableInput(props)}
                  />
                </PhoneNumberWrapper>
              </li>
            </>
          );
        })}
      </OrderedListWrapper>
      {hasSomeInvalidPhone && <Error>{CONTACT_INFO.PHONE_NUMBER_ERROR}</Error>}
      <LinkWrapper
        title={CONTACT_INFO.ADD_MOBILE_PHONE}
        handleClick={props.addPhoneInput}
        disabled={shouldDisableLink()}
      />
    </StyledFormGroup>
  );
};

export default PhoneInputList;
