import React, { MouseEventHandler } from "react";
import ClayForm, { ClayInput, ClaySelectWithOption } from "@clayui/form";
import { PhoneNumberWrapper } from "./styles";
import LinkWrapper from "../LinkWrapper";
import { 
  CONTACT_INFO_ADD_MOBILE_PHONE,
  CONTACT_INFO_AREA_CODE,
  CONTACT_INFO_COUNTRY_CODE,
  CONTACT_INFO_PHONE_NUMBER
} from "../../../../../../../constants/languageKeys";


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


const PhoneInputList: React.FC<props> = (props) => {
  return (
    <ClayForm.Group>
      {/* <ClayForm.Group style={{justifyContent: "space-between", display: "flex", flexDirection: "row"}}>
        <label style={{width: "max-content"}}>{CONTACT_INFO_COUNTRY_CODE}</label>
        <label style={{width: "31%"}}>{CONTACT_INFO_AREA_CODE}</label>
        <label style={{width: "max-content"}}>{CONTACT_INFO_PHONE_NUMBER}</label>
      </ClayForm.Group> */}
      <ClayForm.Group >
        <label>{CONTACT_INFO_COUNTRY_CODE}</label>
        <label>{CONTACT_INFO_AREA_CODE}</label>
        <label>{CONTACT_INFO_PHONE_NUMBER}</label>
      </ClayForm.Group>

      <ol>
        {props.phoneNumbers.map((phoneNumber, index) => {
          return <li key={`phoneInputList${index}`}>
                  <PhoneNumberWrapper>
                       <ClaySelectWithOption
                         aria-label="Select Label"
                         id={`countryCodeSelect${index}`}
                         onChange={e => props.handleChange(index, e, "countryCode")}
                         value={phoneNumber.countryCode}
                         options={props.countryCodeOptions}
                       />

                       <ClaySelectWithOption
                        aria-label="Select Label"
                        id={`areaCodeSelect${index}`}
                        onChange={e => props.handleChange(index, e, "areaCode")}
                        value={phoneNumber.areaCode}
                        options={props.areaCodeOptions}
                      />

                      <ClayInput 
                        id={`phoneNumber${index}`}
                        type="text"
                        onChange={e => props.handleChange(index, e, "phoneNumber")}
                        value={phoneNumber.phoneNumber}
                      />
                  </PhoneNumberWrapper>
                </li>;
        })}
      </ol>
      <LinkWrapper 
        title={CONTACT_INFO_ADD_MOBILE_PHONE}
        handleClick={props.addPhoneInput}
      />
    </ClayForm.Group>
  );
};
  
export default PhoneInputList;



