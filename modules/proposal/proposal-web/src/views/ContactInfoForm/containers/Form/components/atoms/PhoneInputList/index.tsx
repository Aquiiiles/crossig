import React, { MouseEventHandler, useCallback, useEffect, useState } from "react";
import { ClayInput, ClaySelectWithOption } from "@clayui/form";
import { 
  CONTACT_INFO_ADD_MOBILE_PHONE,
  CONTACT_INFO_PHONE_NUMBER
} from "../../../../../../../constants/languageKeys";
import { MAXIMUM_MOBILE_PHONES } from "../../../../../constants/index"; 
import { OrderedListWrapper, PhoneNumberWrapper, StyledFormGroup } from "./styles";
import LinkWrapper from "../LinkWrapper";

import getUnicodeFlagIcon from 'country-flag-icons/unicode'
import * as flags from 'country-flag-icons/string/3x2';

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

const croatiaCountryObject = { label: "385", value: "70", flagKey: "HR" };

const PhoneInputList: React.FC<props> = (props) => {

  const [countries, setCountries] = useState<Array<Country>>([]);

	const loadCountries = useCallback(() => {
    console.log(Object.keys(flags));

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
							value: country.countryId,
              flagKey: country.a2
						} as Country;
					})
					.filter((country) => country.label !== croatiaCountryObject.label);
				countries.unshift(croatiaCountryObject);
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
                        aria-label="Select Label"
                        id={`countryCodeSelect${index}`}
                        className="country-code"
                        onChange={e => props.handleChange(index, e, "countryCode")}
                        value={phoneNumber.countryCode}
                        options={createOptionsWithFlags()}>
                    </ClaySelectWithOption>

                     <ClaySelectWithOption
                       aria-label="Select Label"
                       id={`areaCodeSelect${index}`}
                       className="area-code"
                       onChange={e => props.handleChange(index, e, "areaCode")}
                       value={phoneNumber.areaCode}
                       options={props.areaCodeOptions}
                     />

                     <ClayInput 
                       id={`phoneNumber${index}`}
                       className="phone-number"
                       type="text"
                       onChange={e => props.handleChange(index, e, "phoneNumber")}
                       value={phoneNumber.phoneNumber}
                     />
                   </PhoneNumberWrapper>
                 </li>;
          })}
      </OrderedListWrapper>
      <LinkWrapper 
        title={CONTACT_INFO_ADD_MOBILE_PHONE}
        handleClick={props.addPhoneInput}
        disabled={shouldDisableLink()}
      />
    </StyledFormGroup>
  );
};
  
export default PhoneInputList;