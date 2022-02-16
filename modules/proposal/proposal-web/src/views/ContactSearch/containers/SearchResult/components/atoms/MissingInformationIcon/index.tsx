import React from "react";
import ClayIcon from "@clayui/icon";
import spritemap from "@clayui/css/lib/images/icons/icons.svg";
import { ClayTooltipProvider } from "@clayui/tooltip";
import { Button } from "./styles";
import {
  CONTACT_SEARCH_RESULT_EMAIL_NOT_VALIDATED,
  CONTACT_SEARCH_RESULT_EMAIL_VALIDATED,
  CONTACT_SEARCH_RESULT_PHONE_NOT_VALIDATED,
  CONTACT_SEARCH_RESULT_PHONE_VALIDATED,
  CONTACT_SEARCH_RESULT_AND,
} from "../../../../../../../constants/languageKeys";

const MissingInformationIcon: React.FC<{
  emailValidated: boolean;
  phoneValidated: boolean;
}> = ({ emailValidated, phoneValidated }) => {
  const validationMessage = `${
    emailValidated
      ? CONTACT_SEARCH_RESULT_EMAIL_VALIDATED
      : CONTACT_SEARCH_RESULT_EMAIL_NOT_VALIDATED
  } ${CONTACT_SEARCH_RESULT_AND} ${
    phoneValidated
      ? CONTACT_SEARCH_RESULT_PHONE_VALIDATED
      : CONTACT_SEARCH_RESULT_PHONE_NOT_VALIDATED
  }`;

  return (
    <>
      {(!emailValidated || !phoneValidated) && (
        <ClayTooltipProvider>
          <Button title={validationMessage}>
            <ClayIcon symbol="warning" spritemap={spritemap} />
          </Button>
        </ClayTooltipProvider>
      )}
    </>
  );
};

export default MissingInformationIcon;
