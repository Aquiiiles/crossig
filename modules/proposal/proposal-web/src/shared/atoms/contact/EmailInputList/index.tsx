import React, { Fragment, MouseEventHandler, useState } from "react";
import { ClayInput } from "@clayui/form";
import { CONTACT_INFO } from "../../../../constants/languageKeys";
import LinkWrapper from "../../LinkWrapper";
import { StyledFormGroup, Error } from "./styles";
import { MAXIMUM_EMAIL_ADDRESSES } from "../../../../constants/contactConstants";
import { shouldDisableInput } from "../../../util/commonFunctions";
import { InnerTitle } from "../../../molecules/contact/ContactInfoForm/styles";

interface props {
  emails: Array<string>;
  handleChange: (index: number, e: React.ChangeEvent) => void;
  addEmailInput: MouseEventHandler;
  disableLink?: boolean;
  disableInput?: boolean;
}

const EmailListInput: React.FC<props> = (props) => {
  const [hasSomeInvalidEmail, setSomeInvalidEmail] = useState(false);

  const shouldDisableLink = () => {
    let valid = props.emails.length === MAXIMUM_EMAIL_ADDRESSES;
    if (props.disableLink) {
      valid = valid || props.disableLink;
    }

    return valid;
  };

  const validateEmails = () => {
    setSomeInvalidEmail(false);
    const regex = /\S+@\S+\.\S+/;

    props.emails.forEach((email) => {
      if (!regex.test(email)) {
        setSomeInvalidEmail(true);
        return;
      }
    });
  };

  const handleChange = (index: number, e: React.ChangeEvent) => {
    props.handleChange(index, e);
    validateEmails();
  };

  return (
    <StyledFormGroup>
      {props.emails.map((email, index) => {
        return (
          <Fragment key={`emailFragmentInputKey${index}`}>
            {index === 1 && (
              <InnerTitle className="tablet-only">
                <strong>{CONTACT_INFO.OTHER_EMAIL_ADDRESSES}</strong>
                <small>{CONTACT_INFO.OTHER_EMAIL_ADDRESSES_SUBTITLE}</small>
              </InnerTitle>
            )}
            <label>{CONTACT_INFO.EMAIL_ADDRESS}</label>
            <ClayInput
              key={`emailInputKey${index}`}
              id={`emailInput${index}`}
              type="text"
              onChange={(e) => handleChange(index, e)}
              value={email.toString()}
              disabled={shouldDisableInput(props)}
            />
          </Fragment>
        );
      })}
      {hasSomeInvalidEmail && (
        <Error>{CONTACT_INFO.INVALID_EMAIL_MESSAGE}</Error>
      )}
      <LinkWrapper
        title={CONTACT_INFO.ADD_EMAIL_ADDRESS}
        handleClick={props.addEmailInput}
        disabled={shouldDisableLink()}
      />
    </StyledFormGroup>
  );
};

export default EmailListInput;
