import React from "react";
import languageKeys from "../../../constants/Language";
import { LineWrapper } from "./styles";

const { POLICY_HOLDER } = languageKeys;

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
