import React from "react";
import { POLICY_HOLDER } from "../../../constants/languageKeys";
import { LineWrapper } from "./styles";

interface PropsType {
  policyHolderName: string;
}

const DisplayPolicyInfo: React.FC<PropsType> = ({ policyHolderName }) => {
  const hasPolicyHolder = policyHolderName.length > 0;

  return (
    <>
      {hasPolicyHolder && (
        <LineWrapper>
          <span className="span-small">{POLICY_HOLDER.POLICY_HOLDER}</span>
          <br />
          <span className="span-base">{policyHolderName}</span>
        </LineWrapper>
      )}
    </>
  );
};

export default DisplayPolicyInfo;
