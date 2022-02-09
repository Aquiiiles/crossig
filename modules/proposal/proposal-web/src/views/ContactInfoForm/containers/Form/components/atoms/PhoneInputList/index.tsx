import React, {
  MouseEventHandler,
  useCallback,
  useEffect,
  useState
} from "react";
import { ClayInput, ClaySelectWithOption } from "@clayui/form";
import { 
  CONTACT_INFO_ADD_MOBILE_PHONE,
  CONTACT_INFO_PHONE_NUMBER
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
    return props.phoneNumbers.length == MAXIMUM_MOBILE_PHONES;
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

  return (
    <StyledFormGroup>
      <label className={'phone-label'}>
        {CONTACT_INFO_PHONE_NUMBER}
      </label>
      <OrderedListWrapper>
        {props.phoneNumbers.map((phoneNumber, index) => {
          return <li key={`phoneInputList${index}`}>
                   <PhoneNumberWrapper>
                     <ClaySelectWithOption
                        id={`countryCodeSelect${index}`}
                        className="country-code"
                        onChange={e => handleChange(index, e, "countryCode")}
                        value={phoneNumber.countryCode}
                        options={createOptionsWithFlags()}>
                    </ClaySelectWithOption>

                     <ClaySelectWithOption
                       id={`areaCodeSelect${index}`}
                       className="area-code"
                       onChange={e => handleChange(index, e, "areaCode")}
                       value={phoneNumber.areaCode}
                       options={props.areaCodeOptions}
                     />

                     <ClayInput 
                       id={`phoneNumber${index}`}
                       className="phone-number"
                       type="number"
                       onChange={e => handleChange(index, e, "phoneNumber")}
                       value={phoneNumber.phoneNumber}
                     />
                   </PhoneNumberWrapper>
                 </li>;
          })}
      </OrderedListWrapper>
      {hasSomeInvalidPhone && <Error>{"Phone number must be 4 to 7 digits"}</Error>}
      <LinkWrapper 
        title={CONTACT_INFO_ADD_MOBILE_PHONE}
        handleClick={props.addPhoneInput}
        disabled={shouldDisableLink()}
      />
    </StyledFormGroup>
  );
};
  
export default PhoneInputList;