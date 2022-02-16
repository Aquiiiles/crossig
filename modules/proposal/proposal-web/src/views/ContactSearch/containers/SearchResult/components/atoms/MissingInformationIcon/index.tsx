import React from "react";
import ClayIcon from "@clayui/icon";
import spritemap from "@clayui/css/lib/images/icons/icons.svg";
import { ClayTooltipProvider } from "@clayui/tooltip";

const MissingInformationIcon: React.FC<{
  emailValidation: boolean;
  phoneValidation: boolean;
}> = ({ emailValidation, phoneValidation }) => {
  const validationMessage = `Main Email is ${
    emailValidation ? "" : "not"
  } validated and Main Phone is ${phoneValidation ? "" : "not"} validated`;

  return (
    <ClayTooltipProvider>
      {
        <button className="btn-unstyled" title={validationMessage}>
          <ClayIcon symbol="warning" spritemap={spritemap}/>
        </button>
      }
    </ClayTooltipProvider>
  );
};

export default MissingInformationIcon;
