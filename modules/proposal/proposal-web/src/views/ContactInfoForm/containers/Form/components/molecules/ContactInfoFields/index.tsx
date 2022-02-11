import React, { Fragment, useState } from "react";
import { useHistory } from "react-router-dom";
import ClayForm from "@clayui/form";
import CreateContactButton from "../../atoms/CreateContactButton";
import EmailInputList from "../../atoms/EmailInputList";
import FormSection from "../../../../../../../shared/atoms/FormSection";
import PhoneInputList, { PhoneNumber, croatiaCountry } from "../../atoms/PhoneInputList";
import LinkWrapper from "../../atoms/LinkWrapper";
import Row from "../../../../../../../shared/atoms/Row";
import SubtitledLabel from "../../atoms/SubtitledLabel";
import SubtitledSelect from "../../atoms/SubtitledSelect";
import { ButtonWrapper } from "./styles";
import {
  CONTACT_INFO_CANCEL,
  CONTACT_INFO_TITLE,
  CONTACT_INFO_MAIN_EMAIL,
  CONTACT_INFO_MAIN_EMAIL_SUBTITLE,
  CONTACT_INFO_MAIN_MOBILE,
  CONTACT_INFO_MAIN_MOBILE_SUBTITLE,
  CONTACT_INFO_OTHER_EMAIL_ADDRESSES,
  CONTACT_INFO_OTHER_EMAIL_ADDRESSES_SUBTITLE,
  CONTACT_INFO_OTHER_MOBILE_PHONES_FIXED,
  CONTACT_INFO_OTHER_MOBILE_PHONES_MOBILE,
  CONTACT_INFO_PHONE_TYPE
} from "../../../../../../../constants/languageKeys";
import { 
  MAXIMUM_EMAIL_ADDRESSES,
  MAXIMUM_MOBILE_PHONES
} from "../../../../../constants/index";

const ContactInfoFields: React.FC = () =>  {
  const history = useHistory();
  
  const createEmptyPhoneNumber = () => {
    return {
      areaCode: "",
      countryCode: croatiaCountry.value,
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

    if (currentEmails.length < MAXIMUM_EMAIL_ADDRESSES) {
      currentEmails.push("");
      setEmailAddresses(currentEmails);
    }
  }

  const addMobilePhoneInput = () => {
    let currentMobilePhones = [...mobilePhones];

    if (currentMobilePhones.length < MAXIMUM_MOBILE_PHONES) {
      currentMobilePhones.push(createEmptyPhoneNumber());
      setMobilePhones(currentMobilePhones);
    }
  }

  const getEmailLabelTitle = (index:number) => {
    return index == 0 ? CONTACT_INFO_MAIN_EMAIL : CONTACT_INFO_OTHER_EMAIL_ADDRESSES;
  }

  const getEmailLabelSubtitle = (index:number) => {
    return index == 0 ? CONTACT_INFO_MAIN_EMAIL_SUBTITLE : CONTACT_INFO_OTHER_EMAIL_ADDRESSES_SUBTITLE;
  }

  const shouldPadEmailLabel = (index:number) => {
    return !(index == 0);
  }

  const options = [
    {
      label: CONTACT_INFO_OTHER_MOBILE_PHONES_FIXED,
      value: "1"
    },
    {
      label: CONTACT_INFO_OTHER_MOBILE_PHONES_MOBILE,
      value: "2"
    }
  ];

  const teste = (index:number) => {
    console.log(index)
    return index % 2 != 0
  }

  return (
      <Fragment>
        <FormSection title={CONTACT_INFO_TITLE}>
          <ClayForm.Group>
            {emailAddresses.map((email, index) => (
                <SubtitledLabel
                  key={"email-label-" + index}
                  title={getEmailLabelTitle(index)} 
                  subTitle={getEmailLabelSubtitle(index)}
                  padded={shouldPadEmailLabel(index)}
              />
            ))}
          </ClayForm.Group>
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
          <ClayForm.Group>
            <SubtitledLabel 
              title={CONTACT_INFO_MAIN_MOBILE} 
              subTitle={CONTACT_INFO_MAIN_MOBILE_SUBTITLE}
              padded={false}
            />
            {mobilePhones.slice(1).map((phone, index) => (
              <SubtitledSelect
                key={"phone-label-" + index}
                index={index}
                title={CONTACT_INFO_PHONE_TYPE}
                options={options}
                padded={teste(index)}
                />
            ))}
          </ClayForm.Group>
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
          disabled={false}
          />
        <CreateContactButton 
          handleClick={() => {return;}} 
        />
      </ButtonWrapper>
    </Fragment>
  );
};

export default ContactInfoFields;
