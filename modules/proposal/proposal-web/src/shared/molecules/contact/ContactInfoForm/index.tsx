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
import { actions as basicInfoActions } from "../../../../redux/basicInfoSlice";
import { actions as addressActions } from "../../../../redux/addressSlice";
import LinkWrapper from "../../../atoms/contact/LinkWrapper";
import { useHistory } from "react-router-dom";

type propsType = {
  countries: Array<Country>,
  operation: string,
  enableSave?: () => void
}

const ContactInfoForm: React.FC<propsType> = ({
  countries,
  enableSave,
  operation,
}:propsType) => {
  const history = useHistory();
  const dispatcher = useContactDispatch();

  const dispatch = (action: any) => {
    enableSave && enableSave();
    dispatcher(action);
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

    dispatch(setEmailAddresses(currentEmails));
  };

  const handlePhoneChange = (index: number, e: any, property: string) => {
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
  };

  const addEmailAddressInput = () => {
    const currentEmails = [...emailAddresses];

    const shouldAddInput =
      currentEmails.length < MAXIMUM_EMAIL_ADDRESSES && !isLegalEntity();

    if (shouldAddInput) {
      currentEmails.push("");
      dispatch(setEmailAddresses(currentEmails));
    }
  };

  const addMobilePhoneInput = () => {
    const currentMobilePhones = [...mobilePhones];

    const shouldAddInput =
      currentMobilePhones.length < MAXIMUM_MOBILE_PHONES &&
      !isLegalEntity();

    if (shouldAddInput) {
      currentMobilePhones.push(createEmptyPhoneNumber(FIXED));
      dispatch(setMobilePhones(currentMobilePhones));
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

  const shouldPadEmailLabel = (index: number) => {
    return !(index === 0);
  };

  const isLegalEntity = () => {
    return contactType === contactTypes.Legal_Entity;
  };

  const isUpdate = () => {
    return operation === "update";
  }

  return (
    <Fragment>
      <FormSection title={CONTACT_INFO.TITLE}>
        <ClayForm.Group>
          {emailAddresses.map((_email, index) => (
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
              disableLink={isLegalEntity()}
              disableInput={isLegalEntity() && isUpdate()}
            />
          </ClayForm.Group>
        </Row>
      </FormSection>

      <FormSection>
        <ClayForm.Group>
          <SubtitledLabel
            title={CONTACT_INFO.MAIN_MOBILE}
            subTitle={CONTACT_INFO.MAIN_MOBILE_SUBTITLE}
            padded={false}
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
        </ClayForm.Group>
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
