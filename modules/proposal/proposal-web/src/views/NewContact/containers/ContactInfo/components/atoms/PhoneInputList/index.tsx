import React, {
  MouseEventHandler,
  useCallback,
  useEffect,
  useState
} from "react";
import { ClayInput, ClaySelect, ClaySelectWithOption } from "@clayui/form";
import { 
  CONTACT_INFO_ADD_MOBILE_PHONE,
  CONTACT_INFO_PHONE_NUMBER,
  CONTACT_INFO_PHONE_NUMBER_ERROR
} from "../../../../../../../constants/languageKeys";
import { MAXIMUM_MOBILE_PHONES } from "../../../../../constants/index"; 
import {
  Error,
  OrderedListWrapper,
  PhoneNumberWrapper,
  StyledFormGroup
} from "./styles";
import LinkWrapper from "../LinkWrapper";

import getUnicodeFlagIcon from 'country-flag-icons/unicode'

declare var Liferay: any;

export interface PhoneNumber  {
  countryCode: string;
  areaCode: string;
  phoneNumber: string;
}
interface props {
  phoneNumbers: Array<PhoneNumber>;
  handleChange: Function;
  addPhoneInput: MouseEventHandler;
  countryCodeOptions: Array<any>;
  areaCodeOptions: Array<any>;
}

interface Country {
  label: string,
  value: string,
  flagKey: string
}

export const croatiaCountry = { 
  label: "385",
  value: "385",
  flagKey: "HR"
} as Country;

const PhoneInputList: React.FC<props> = (props) => {

  const [countries, setCountries] = useState<Array<Country>>([croatiaCountry]);
  const [hasSomeInvalidPhone, setSomeInvalidPhone] = useState(false);

  const defaultAreaCodeOption = {
    value: "",
    label: "Area Code",
  }

	const loadCountries = useCallback(() => {
		Liferay.Service(
			"/country/get-countries",
			{
				active: true
			},
			(countriesArray: Array<any>) => {
				const countries = countriesArray
					.map((country) => {
						return {
							label: country.idd,
							value: country.idd,
              flagKey: country.a2
						} as Country;
					})
					.filter((country) => country.label !== croatiaCountry.label);
        countries.unshift(croatiaCountry);
				setCountries(countries);
			}
		);
	}, []);

	useEffect(() => {
		loadCountries();
	}, [loadCountries]);
  
  const shouldDisableLink = () => {
    return props.phoneNumbers.length === MAXIMUM_MOBILE_PHONES;
  }

  const getFlagSVG = (country:Country) => {
    return getUnicodeFlagIcon(country.flagKey);
  }

  const createOptionsWithFlags = () => {
    return countries.map((country) => {
      return {
        label: getFlagSVG(country) + " " + country.label,
        value: country.value
      }
    });
  }

  const isCroatianPhoneValid = (phoneNumber:string) => {
    return phoneNumber.length >= 4 && phoneNumber.length <= 7;
  }

  const validatePhones = () => {
    setSomeInvalidPhone(false);

    props.phoneNumbers.forEach((phoneNumber) => {
      if (phoneNumber.countryCode === croatiaCountry.label &&
          !isCroatianPhoneValid(phoneNumber.phoneNumber)) {
          setSomeInvalidPhone(true);
          return;
      }
    });
  }

  const handleChange = (index:number, e:React.ChangeEvent, property:string) => {
    props.handleChange(index, e, property);
    validatePhones();
  }

  const displayAreaCode = (phoneNumber:PhoneNumber) => {
    let style = "area-code" ;
    
    if (phoneNumber.countryCode !== croatiaCountry.label) {
      style += " hidden-select"
      phoneNumber.areaCode = "";
    } 

    return style;
  }

  const handlePhoneInputWidth = (countryCode:string) => {
    let style = "phone-number" ;
    if (countryCode !== croatiaCountry.label) {
      style += " stretch-phone-number"
    } 

    return style;
  }

  return (
    <StyledFormGroup>
      <OrderedListWrapper>
        {props.phoneNumbers.map((phoneNumber, index) => {
          return <li key={`phoneInputList${index}`}>
                    <label>{CONTACT_INFO_PHONE_NUMBER}</label>
                    <PhoneNumberWrapper>
                      <ClaySelectWithOption
                          id={`countryCodeSelect${index}`}
                          className="country-code"
                          onChange={e => handleChange(index, e, "countryCode")}
                          value={phoneNumber.countryCode}
                          options={createOptionsWithFlags()}>
                      </ClaySelectWithOption>

                      <ClaySelect 
                        aria-label="Select Label"
                        id={`areaCodeSelect${index}`}
                        className={displayAreaCode(phoneNumber)}
                        onChange={e => handleChange(index, e, "areaCode")}
                        value={phoneNumber.areaCode}>
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
                 </li>;
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