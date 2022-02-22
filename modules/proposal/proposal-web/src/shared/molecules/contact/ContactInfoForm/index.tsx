import React, { Fragment } from "react";
import ClayForm from "@clayui/form";
import EmailInputList from "../../../atoms/contact/EmailInputList";
import FormSection from "../../../atoms/contact/FormSection";
import PhoneInputList from "../../../atoms/contact/PhoneInputList";
import Row from "../../../atoms/contact/Row";
import SubtitledLabel from "../../../atoms/contact/SubtitledLabel";
import PhoneTypeSelect from "../../../atoms/contact/PhoneTypeSelect";
import { CONTACT_INFO } from "../../../../constants/languageKeys";
import {
  contactTypes,
  FIXED,
  MAXIMUM_EMAIL_ADDRESSES,
  MAXIMUM_MOBILE_PHONES,
} from "../../../../constants/contactConstants";
import {
  useContactDispatch,
  useContactSelector,
} from "../../../../redux/store";
import { Country } from "../../../types/contact";
import { createEmptyPhoneNumber } from "../../../util/commonFunctions";
import { actions as contactInfoActions } from "../../../../redux/contactInfoSlice";
import { StyledLabelFormGroup, StyledPhoneTypeFormGroup } from "./styles";

type propsType = {
  countries: Array<Country>;
  operation: string;
  enableSave?: () => void;
  setUpdatedValues?: (value: string) => void;
};

const ContactInfoForm: React.FC<propsType> = ({
  countries,
  enableSave,
  operation,
  setUpdatedValues,
}: propsType) => {
  const dispatcher = useContactDispatch();

  const dispatch = (action: any, updatedValue: string) => {
    enableSave && enableSave();
    dispatcher(action);
    setUpdatedValues && setUpdatedValues(updatedValue);
  };
  const { emailAddresses, mobilePhones } = useContactSelector(
    (state) => state.contactInfo
  );

  const { contactType } = useContactSelector((state) => state.basicInfo);

  const {
    setEmailAddresses,
    setAreaCode,
    setCountryCode,
    setPhoneNumber,
    setType,
    setMobilePhones,
  } = contactInfoActions;

  const handleEmailChange = (index: number, e: any) => {
    const currentEmails = [...emailAddresses];
    currentEmails[index] = e.target.value.toString();

    dispatch(setEmailAddresses(currentEmails), CONTACT_INFO.EMAIL_ADDRESS);
  };

  const handlePhoneChange = (index: number, e: any, property: string) => {
    const value = e.target.value.toString();

    switch (property) {
      case "areaCode": {
        dispatch(setAreaCode([index, value]), CONTACT_INFO.PHONE_NUMBER);
        break;
      }
      case "countryCode": {
        dispatch(setCountryCode([index, value]), CONTACT_INFO.PHONE_NUMBER);

        if (value === "385") {
          dispatch(setAreaCode([index, ""]), CONTACT_INFO.PHONE_NUMBER);
        }

        break;
      }
      case "phoneNumber": {
        dispatch(setPhoneNumber([index, value]), CONTACT_INFO.PHONE_NUMBER);
        break;
      }
      case "type": {
        dispatch(setType([index, value]), CONTACT_INFO.PHONE_NUMBER);
        break;
      }
    }
  };

  const addEmailAddressInput = () => {
    const currentEmails = [...emailAddresses];

    const legalEntityUpdate = isLegalEntity() && isUpdate();
    const shouldAddInput =
      currentEmails.length < MAXIMUM_EMAIL_ADDRESSES && !legalEntityUpdate;

    if (shouldAddInput) {
      currentEmails.push("");
      dispatch(setEmailAddresses(currentEmails), CONTACT_INFO.EMAIL_ADDRESS);
    }
  };

  const addMobilePhoneInput = () => {
    const currentMobilePhones = [...mobilePhones];

    const legalEntityUpdate = isLegalEntity() && isUpdate();
    const shouldAddInput =
      currentMobilePhones.length < MAXIMUM_MOBILE_PHONES && !legalEntityUpdate;

    if (shouldAddInput) {
      currentMobilePhones.push(createEmptyPhoneNumber(FIXED));
      dispatch(setMobilePhones(currentMobilePhones), CONTACT_INFO.PHONE_NUMBER);
    }
  };

  const getEmailLabelTitle = (index: number) => {
    return index === 0
      ? CONTACT_INFO.MAIN_EMAIL
      : CONTACT_INFO.OTHER_EMAIL_ADDRESSES;
  };

  const getEmailLabelSubtitle = (index: number) => {
    return index === 0
      ? CONTACT_INFO.MAIN_EMAIL_SUBTITLE
      : CONTACT_INFO.OTHER_EMAIL_ADDRESSES_SUBTITLE;
  };

  const isLegalEntity = () => {
    return contactType === contactTypes.Legal_Entity;
  };

  const isUpdate = () => {
    return operation === "update";
  };

  return (
    <Fragment>
      <FormSection title={CONTACT_INFO.TITLE}>
        <StyledLabelFormGroup>
          {emailAddresses.map((_email, index) => (
            <SubtitledLabel
              key={"email-label-" + index}
              title={getEmailLabelTitle(index)}
              subTitle={getEmailLabelSubtitle(index)}
            />
          ))}
        </StyledLabelFormGroup>
        <Row>
          <ClayForm.Group>
            <EmailInputList
              emails={emailAddresses}
              handleChange={handleEmailChange}
              addEmailInput={addEmailAddressInput}
              disableLink={isLegalEntity() && isUpdate()}
              disableInput={isLegalEntity() && isUpdate()}
            />
          </ClayForm.Group>
        </Row>
      </FormSection>

      <FormSection>
        <StyledPhoneTypeFormGroup>
          <SubtitledLabel
            title={CONTACT_INFO.MAIN_MOBILE}
            subTitle={CONTACT_INFO.MAIN_MOBILE_SUBTITLE}
          />
          {mobilePhones.slice(1).map((_phone, index) => (
            <PhoneTypeSelect
              key={"phone-label-" + ++index}
              index={++index}
              title={CONTACT_INFO.PHONE_TYPE}
              handleChange={handlePhoneChange}
              entity={mobilePhones}
              disableInput={isLegalEntity() && isUpdate()}
            />
          ))}
        </StyledPhoneTypeFormGroup>
        <Row>
          <ClayForm.Group>
            <PhoneInputList
              phoneNumbers={mobilePhones}
              handleChange={handlePhoneChange}
              addPhoneInput={addMobilePhoneInput}
              countries={countries}
              disableLink={isLegalEntity() && isUpdate()}
              disableInput={isLegalEntity() && isUpdate()}
            />
          </ClayForm.Group>
        </Row>
      </FormSection>
    </Fragment>
  );
};

export default ContactInfoForm;
