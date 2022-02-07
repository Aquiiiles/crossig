import React, { MouseEventHandler } from "react";
import ClayForm, { ClayInput, ClaySelectWithOption } from "@clayui/form";
import ClayLink from '@clayui/link';
import { LinkWrapper, PhoneNumberWrapper } from "./styles";

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
      <label>Country Code</label>
      <label>Area Code</label>
      <label>Phone Number</label>

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
      <LinkWrapper>
        <ClayLink onClick={props.addPhoneInput}>Add Mobile Phone</ClayLink>
      </LinkWrapper>
    </ClayForm.Group>
  );
};
  
export default PhoneInputList;



