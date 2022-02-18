import React from "react";
import ClayIcon from "@clayui/icon";
import spritemap from "@clayui/css/lib/images/icons/icons.svg";
import { ClayTooltipProvider } from "@clayui/tooltip";
import { Button, Wrapper } from "./styles";
import {
  CONTACT_SEARCH_RESULT_EMAIL_NOT_VALIDATED,
  CONTACT_SEARCH_RESULT_EMAIL_VALIDATED,
  CONTACT_SEARCH_RESULT_PHONE_NOT_VALIDATED,
  CONTACT_SEARCH_RESULT_PHONE_VALIDATED,
  CONTACT_SEARCH_RESULT_AND,
} from "../../../../../../../constants/languageKeys";

const MissingInformationIcon: React.FC<{
  mailValidated: boolean;
  phoneNumberValidated: boolean;
}> = ({ mailValidated, phoneNumberValidated }) => {
  const validationMessage = `${
    mailValidated
      ? CONTACT_SEARCH_RESULT_EMAIL_VALIDATED
      : CONTACT_SEARCH_RESULT_EMAIL_NOT_VALIDATED
  } ${CONTACT_SEARCH_RESULT_AND} ${
    phoneNumberValidated
      ? CONTACT_SEARCH_RESULT_PHONE_VALIDATED
      : CONTACT_SEARCH_RESULT_PHONE_NOT_VALIDATED
  }`;

  return (
    <>
      {(!mailValidated || !phoneNumberValidated) && (
        <Wrapper>
          <ClayTooltipProvider>
            <Button title={validationMessage}>
              <ClayIcon symbol="warning" spritemap={spritemap} />
            </Button>
          </ClayTooltipProvider>
        </Wrapper>
      )}
    </>
  );
};

export default MissingInformationIcon;
