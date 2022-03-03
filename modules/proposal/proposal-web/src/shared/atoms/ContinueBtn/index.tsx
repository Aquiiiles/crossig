import React from "react";
import ClayButton from "@clayui/button";
import { PROPOSAL } from "../../../constants/languageKeys";

const ContinueBtn: React.FC<{ disabled: boolean; onClick: () => void }> = ({
  disabled,
  onClick,
}) => {
  return (
    <ClayButton displayType="primary" disabled={disabled} onClick={onClick}>
      {PROPOSAL.BUTTON_CONTINUE}
    </ClayButton>
  );
};

export default ContinueBtn;
