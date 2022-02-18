import React, { Fragment, MouseEventHandler, useState } from "react";
import { ClayInput } from "@clayui/form";
import {
  CONTACT_INFO_ADD_EMAIL_ADDRESS,
  CONTACT_INFO_EMAIL_ADDRESS,
  CONTACT_INFO_INVALID_EMAIL_MESSAGE,
} from "../../../../../../../constants/languageKeys";
import { MAXIMUM_EMAIL_ADDRESSES } from "../../../../../../../constants/contactConstants";
import LinkWrapper from "../LinkWrapper";
import { StyledFormGroup, Error } from "./styles";

interface props {
  emails: Array<string>;
  handleChange: (index: number, e: React.ChangeEvent) => void;
  addEmailInput: MouseEventHandler;
}

const EmailListInput: React.FC<props> = props => {
  const [hasSomeInvalidEmail, setSomeInvalidEmail] = useState(false);

  const shouldDisableLink = () => {
    return props.emails.length === MAXIMUM_EMAIL_ADDRESSES;
  };

  const validateEmails = () => {
    setSomeInvalidEmail(false);
    const regex = /\S+@\S+\.\S+/;

    props.emails.forEach(email => {
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
            <label>{CONTACT_INFO_EMAIL_ADDRESS}</label>
            <ClayInput
              key={`emailInputKey${index}`}
              id={`emailInput${index}`}
              type="text"
              onChange={e => handleChange(index, e)}
              value={email.toString()}
            />
          </Fragment>
        );
      })}
      {hasSomeInvalidEmail && (
        <Error>{CONTACT_INFO_INVALID_EMAIL_MESSAGE}</Error>
      )}
      <LinkWrapper
        title={CONTACT_INFO_ADD_EMAIL_ADDRESS}
        handleClick={props.addEmailInput}
        disabled={shouldDisableLink()}
      />
    </StyledFormGroup>
  );
};

export default EmailListInput;
