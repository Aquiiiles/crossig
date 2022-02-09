import React, { MouseEventHandler } from "react";
import { ClayInput } from "@clayui/form";
import {
  CONTACT_INFO_ADD_EMAIL_ADDRESS,
  CONTACT_INFO_EMAIL_ADDRESS
 } from "../../../../../../../constants/languageKeys";
import { MAXIMUM_EMAIL_ADDRESSES } from "../../../../../constants/index"; 
import LinkWrapper from "../LinkWrapper";
import { StyledFormGroup } from "./styles";

interface props {
  emails: Array<string>;
  handleChange: Function;
  addEmailInput: MouseEventHandler;
}

const EmailListInput: React.FC<props> = (props) => {

  const shouldDisableLink = () => {
    return props.emails.length == MAXIMUM_EMAIL_ADDRESSES;
  }

  return (
    <StyledFormGroup>
      <label className={'email-label'}>
        {CONTACT_INFO_EMAIL_ADDRESS}
      </label>
      {props.emails.map((email, index) => {
        return <ClayInput
                 key={`emailInputKey${index}`}
                 id={`emailInput${index}`}
                 type="text"
                 onChange={e => props.handleChange(index, e)}
                 value={email.toString()}
               />;
        })}
      <LinkWrapper 
        title={CONTACT_INFO_ADD_EMAIL_ADDRESS}
        handleClick={props.addEmailInput}
        disabled={shouldDisableLink()}
      />
    </StyledFormGroup>
  );
};

export default EmailListInput;