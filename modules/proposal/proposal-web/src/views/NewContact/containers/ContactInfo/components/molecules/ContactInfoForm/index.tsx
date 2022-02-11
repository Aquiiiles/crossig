import React, { Fragment } from "react";
import { useHistory } from "react-router-dom";
import ClayForm from "@clayui/form";
import CreateContactButton from "../../atoms/CreateContactButton";
import EmailInputList from "../../atoms/EmailInputList";
import FormSection from "../../../../../../../shared/atoms/FormSection";
import PhoneInputList, { createEmptyPhoneNumber } from "../../atoms/PhoneInputList";
import LinkWrapper from "../../atoms/LinkWrapper";
import Row from "../../../../../../../shared/atoms/Row";
import SubtitledLabel from "../../atoms/SubtitledLabel";
import PhoneTypeSelect from "../../atoms/PhoneTypeSelect";
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
  CONTACT_INFO_PHONE_TYPE
} from "../../../../../../../constants/languageKeys";
import { 
  FIXED,
  MAXIMUM_EMAIL_ADDRESSES,
  MAXIMUM_MOBILE_PHONES,
} from "../../../../../constants/index";

import { actions } from "./slice/contactInfoSlice";
import { useContactDispatch, useContactSelector } from "../../../contactStore";

const ContactInfoForm: React.FC = () =>  {
  const history = useHistory();
  const dispatch = useContactDispatch();

  const {
		emailAddresses,
    mobilePhones
	} = useContactSelector((state) => state.contactInfo);

  const {
    setEmailAddresses,
    setAreaCode,
    setCountryCode,
    setPhoneNumber,
    setType,
    setMobilePhones
	} = actions;

  const handleEmailChange = (index:number, e:any) => {
    let currentEmails = [...emailAddresses];
    currentEmails[index] = e.target.value.toString();

    dispatch(setEmailAddresses(currentEmails));
  }

  const handlePhoneChange = (index:number, e:any, property:string) => {
    const value = e.target.value.toString();

    switch (property) {
      case "areaCode": {
        dispatch(setAreaCode([index, value]));
        break;
      }
      case "countryCode": {
        dispatch(setCountryCode([index, value]));

        if (value === "385") {
          dispatch(setAreaCode([index, ""]));
        }

        break;
      }
      case "phoneNumber": {
        dispatch(setPhoneNumber([index, value]));
        break;
      }
      case "type": {
        dispatch(setType([index, value]));
        break;
      }
    }
  }

  const addEmailAddressInput = () => {
    let currentEmails = [...emailAddresses];

    if (currentEmails.length < MAXIMUM_EMAIL_ADDRESSES) {
      currentEmails.push("");
      dispatch(setEmailAddresses(currentEmails));
    }
  }

  const addMobilePhoneInput = () => {
    let currentMobilePhones = [...mobilePhones];

    if (currentMobilePhones.length < MAXIMUM_MOBILE_PHONES) {
      currentMobilePhones.push(createEmptyPhoneNumber(FIXED));
      dispatch(setMobilePhones(currentMobilePhones));
    }
  }

  const getEmailLabelTitle = (index:number) => {
    return index === 0 ? CONTACT_INFO_MAIN_EMAIL : CONTACT_INFO_OTHER_EMAIL_ADDRESSES;
  }

  const getEmailLabelSubtitle = (index:number) => {
    return index === 0 ? CONTACT_INFO_MAIN_EMAIL_SUBTITLE : CONTACT_INFO_OTHER_EMAIL_ADDRESSES_SUBTITLE;
  }

  const shouldPadEmailLabel = (index:number) => {
    return !(index === 0);
  }

  const options = [
    {
      label: "Fixed",
      value: "fixed"
    },
    {
      label: "Mobile",
      value: "mobile"
    }
  ];

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
              <PhoneTypeSelect
                key={"phone-label-" + ++index}
                index={++index}
                title={CONTACT_INFO_PHONE_TYPE}
                handleChange={handlePhoneChange}
                entity={mobilePhones}
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

export default ContactInfoForm;