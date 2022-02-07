import React, { useState } from "react";
import ClayForm, { ClayInput } from "@clayui/form";
import ClayLink from '@clayui/link';
import SectionTitle from "../../../../../../../shared/atoms/SectionTitle";
import SubtitledLabel from "../../atoms/SubtitledLabel";

import EmailInputList from "../../atoms/EmailInputList";
import PhoneInputList, { PhoneNumber } from "../../atoms/PhoneInputList";

import { Wrapper, InputWrapper } from "./styles";
import {
  CONTACT_INFO_TITLE,
  CONTACT_INFO_MAIN_EMAIL,
  CONTACT_INFO_MAIN_EMAIL_SUBTITLE,
  CONTACT_INFO_MAIN_MOBILE,
  CONTACT_INFO_MAIN_MOBILE_SUBTITLE
} from "../../../../../../../constants/languageKeys";


const ContactInfoFields: React.FC = () =>  {
  
  const createEmptyPhoneNumber = () => {
    return {
      areaCode: "",
      countryCode: "",
      phoneNumber: ""
    } as PhoneNumber;
  };

  let [emailAddresses, setEmailAddresses] = useState([""]);
  let [mobilePhones, setMobilePhones] = useState([createEmptyPhoneNumber()]);

  const handleEmailChange = (index:number, e:any) => {
    let newArray = [...emailAddresses];
    newArray[index] = e.target.value.toString();
  
    setEmailAddresses(newArray);
  }

  const handlePhoneChange = (index:number, e:any, property:string) => {
    let newArray = [...mobilePhones];

    switch (property) {
      case "areaCode": {
        newArray[index]["areaCode"] = e.target.value.toString();
        break;
      }
      case "countryCode": {
        newArray[index]["countryCode"] = e.target.value.toString();
        break;
      }
      case "phoneNumber": {
        newArray[index]["phoneNumber"] = e.target.value.toString();
        break;
      }
    }

    setMobilePhones(newArray);
  }

  const addEmailAddressInput = () => {
    let currentEmails = [...emailAddresses];
    currentEmails.push("");
    setEmailAddresses(currentEmails);
  }

  const addMobilePhoneInput = () => {
    let currentMobilePhones = [...mobilePhones];
    currentMobilePhones.push(createEmptyPhoneNumber());
    setMobilePhones(currentMobilePhones);
  }

  const options = [
    {
      label: "Option 1",
      value: "1"
    },
    {
      label: "Option 2",
      value: "2"
    }
  ];

  return (
    <Wrapper>
      <SectionTitle title={CONTACT_INFO_TITLE} />
      <InputWrapper>
          <ClayForm.Group>         
            <SubtitledLabel 
              title={CONTACT_INFO_MAIN_EMAIL} 
              subTitle={CONTACT_INFO_MAIN_EMAIL_SUBTITLE} 
            />
          </ClayForm.Group>

          <EmailInputList 
            emails={emailAddresses}
            handleChange={handleEmailChange}
            addEmailInput={addEmailAddressInput}
          />
       </InputWrapper>

      <InputWrapper>
        <ClayForm.Group>
          <SubtitledLabel 
            title={CONTACT_INFO_MAIN_MOBILE} 
            subTitle={CONTACT_INFO_MAIN_MOBILE_SUBTITLE} 
          />
        </ClayForm.Group>

        <PhoneInputList 
          phoneNumbers={mobilePhones} 
          handleChange={handlePhoneChange} 
          addPhoneInput={addMobilePhoneInput}
          countryCodeOptions={options} 
          areaCodeOptions={options}
        />
      </InputWrapper>
    </Wrapper>
  );
};

export default ContactInfoFields;
