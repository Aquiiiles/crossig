import React, { Fragment, useState } from "react";
import { useHistory } from "react-router-dom";
import ClayForm from "@clayui/form";
import CreateContactButton from "../../atoms/CreateContactButton";
import EmailInputList from "../../atoms/EmailInputList";
import FormSection from "../../../../../../../shared/atoms/FormSection";
import PhoneInputList, { PhoneNumber } from "../../atoms/PhoneInputList";
import LinkWrapper from "../../atoms/LinkWrapper";
import Row from "../../../../../../../shared/atoms/Row";
import SubtitledLabel from "../../atoms/SubtitledLabel";
import { ButtonWrapper } from "./styles";
import {
  CONTACT_INFO_CANCEL,
  CONTACT_INFO_TITLE,
  CONTACT_INFO_MAIN_EMAIL,
  CONTACT_INFO_MAIN_EMAIL_SUBTITLE,
  CONTACT_INFO_MAIN_MOBILE,
  CONTACT_INFO_MAIN_MOBILE_SUBTITLE
} from "../../../../../../../constants/languageKeys";


const ContactInfoFields: React.FC = () =>  {
  const history = useHistory();
  
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

  return (
      <Fragment>
        <FormSection title={CONTACT_INFO_TITLE}>
          <SubtitledLabel 
            title={CONTACT_INFO_MAIN_EMAIL} 
            subTitle={CONTACT_INFO_MAIN_EMAIL_SUBTITLE} 
          />
          <Row>
            <ClayForm.Group>         
              <EmailInputList 
                emails={emailAddresses}
                handleChange={handleEmailChange}
                addEmailInput={addEmailAddressInput}
              />
            </ClayForm.Group>
          </Row>
        </FormSection>

        <FormSection>
          <SubtitledLabel 
            title={CONTACT_INFO_MAIN_MOBILE} 
            subTitle={CONTACT_INFO_MAIN_MOBILE_SUBTITLE} 
          />
          <Row>
            <ClayForm.Group>
              <PhoneInputList 
                phoneNumbers={mobilePhones} 
                handleChange={handlePhoneChange} 
                addPhoneInput={addMobilePhoneInput}
                countryCodeOptions={[]} 
                areaCodeOptions={[]}
              />
            </ClayForm.Group>
          </Row>
      </FormSection>
      <ButtonWrapper>
        <LinkWrapper 
          title={CONTACT_INFO_CANCEL}
          handleClick={history.goBack}
          />
          
        <CreateContactButton 
          handleClick={() => {return;}} 
        />
      </ButtonWrapper>
    </Fragment>
  );
};

export default ContactInfoFields;
