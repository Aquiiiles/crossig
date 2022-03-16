import React, { Fragment, useState, useEffect } from "react";
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
  contactOperations,
} from "../../../../constants/contactConstants";
import { useDispatch, useSelector } from "../../../../redux/store";
import { Country } from "../../../types/contact";
import { createEmptyPhoneNumber } from "../../../util/commonFunctions";
import { actions } from "../../../../redux";
import {
  InnerTitle,
  StyledLabelFormGroup,
  StyledPhoneTypeFormGroup,
  Wrapper,
} from "./styles";
import FormSectionMobile from "../../../atoms/contact/FormSectionMobile";

type propsType = {
  countries: Array<Country>;
  operation: number;
  enableSave?: () => void;
  setUpdatedValues?: (value: string) => void;
};

const ContactInfoForm: React.FC<propsType> = ({
  countries,
  enableSave,
  operation,
  setUpdatedValues,
}: propsType) => {
  const [disableFields, setDisableFields] = useState(false);

  const dispatcher = useDispatch();
  const dispatch = (action: any, updatedValue: string) => {
    enableSave && enableSave();
    dispatcher(action);
    setUpdatedValues && setUpdatedValues(updatedValue);
  };
  const { emailAddresses, mobilePhones } = useSelector(
    (state) => state.contactInfo
  );

  const { contactType } = useSelector((state) => state.basicInfo);

  const {
    setEmailAddresses,
    setAreaCode,
    setCountryCode,
    setPhoneNumber,
    setType,
    setMobilePhones,
  } = actions.contactInfo;

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

    const shouldAddInput =
      currentEmails.length < MAXIMUM_EMAIL_ADDRESSES && !disableFields;

    if (shouldAddInput) {
      currentEmails.push("");
      dispatch(setEmailAddresses(currentEmails), CONTACT_INFO.EMAIL_ADDRESS);
    }
  };

  const addMobilePhoneInput = () => {
    const currentMobilePhones = [...mobilePhones];

    const shouldAddInput =
      currentMobilePhones.length < MAXIMUM_MOBILE_PHONES && !disableFields;

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

  useEffect(() => {
    setDisableFields(
      (contactType === contactTypes.Legal_Entity &&
        operation !== contactOperations.create) ||
        operation === contactOperations.updateReadOnly
    );
  }, [contactType]);

  return (
    <Wrapper>
      <FormSection className="desktop-only" title={CONTACT_INFO.TITLE}>
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
              disableLink={disableFields}
              disableInput={disableFields}
            />
          </ClayForm.Group>
        </Row>
      </FormSection>

      <FormSection className="desktop-only">
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
              disableInput={disableFields}
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
              disableLink={disableFields}
              disableInput={disableFields}
            />
          </ClayForm.Group>
        </Row>
      </FormSection>
      <FormSectionMobile className="tablet-only" title={CONTACT_INFO.TITLE}>
        <InnerTitle>
          <strong>{getEmailLabelTitle(0)}</strong>
          <small>{getEmailLabelSubtitle(0)}</small>
        </InnerTitle>
        <Row>
          <EmailInputList
            emails={emailAddresses}
            handleChange={handleEmailChange}
            addEmailInput={addEmailAddressInput}
            disableLink={disableFields}
            disableInput={disableFields}
          />
        </Row>
      </FormSectionMobile>
      <FormSectionMobile className="tablet-only">
        <InnerTitle>
          <strong>{CONTACT_INFO.MAIN_MOBILE}</strong>
          <small>{CONTACT_INFO.MAIN_MOBILE_SUBTITLE}</small>
        </InnerTitle>
        <Row>
          <PhoneInputList
            phoneTypeSelect={(index) => (
              <PhoneTypeSelect
                key={index}
                index={index}
                title={CONTACT_INFO.PHONE_TYPE}
                handleChange={handlePhoneChange}
                entity={mobilePhones}
                disableInput={disableFields}
              />
            )}
            phoneNumbers={mobilePhones}
            handleChange={handlePhoneChange}
            addPhoneInput={addMobilePhoneInput}
            countries={countries}
            disableLink={disableFields}
            disableInput={disableFields}
          />
        </Row>
      </FormSectionMobile>
    </Wrapper>
  );
};

export default ContactInfoForm;
