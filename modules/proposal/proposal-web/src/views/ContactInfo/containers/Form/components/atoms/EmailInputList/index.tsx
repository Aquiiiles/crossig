import ClayForm, { ClayInput } from "@clayui/form";
import ClayLink from '@clayui/link';
import React, { MouseEventHandler } from "react";
import { LinkWrapper } from "./styles";
import { CONTACT_INFO_EMAIL_ADDRESS } from "../../../../../../../constants/languageKeys";

interface props {
  emails: Array<string>;
  handleChange: Function;
  addEmailInput: MouseEventHandler;
}

const EmailListInput: React.FC<props> = (props) => {
  return (
    <ClayForm.Group>
      <label>{CONTACT_INFO_EMAIL_ADDRESS}</label>
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
      <LinkWrapper>
        <ClayLink onClick={props.addEmailInput}>Add Email Address</ClayLink>
      </LinkWrapper>
  </ClayForm.Group>
  );
};

export default EmailListInput;