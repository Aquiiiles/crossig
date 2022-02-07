import ClayForm, { ClayInput } from "@clayui/form";
import React, { MouseEventHandler } from "react";
import LinkWrapper from "../LinkWrapper";
import {
  CONTACT_INFO_ADD_EMAIL_ADDRESS,
  CONTACT_INFO_EMAIL_ADDRESS
 } from "../../../../../../../constants/languageKeys";

interface props {
  emails: Array<string>;
  handleChange: Function;
  addEmailInput: MouseEventHandler;
}

const EmailListInput: React.FC<props> = (props) => {
  return (
    <ClayForm.Group>
      <ClayForm.Group>
        <label>{CONTACT_INFO_EMAIL_ADDRESS}</label>
      </ClayForm.Group>
      <ol>
        {props.emails.map((email, index) => {
          return <li key={`emailInputList${index}`}>
                    <ClayInput
                      id={`emailInput${index}`}
                      type="text"
                      onChange={e => props.handleChange(index, e)}
                      value={email.toString()}
                    />
                </li>;
        })}
      </ol>
      <LinkWrapper 
        title={CONTACT_INFO_ADD_EMAIL_ADDRESS}
        handleClick={props.addEmailInput}
      />
  </ClayForm.Group>
  );
};

export default EmailListInput;