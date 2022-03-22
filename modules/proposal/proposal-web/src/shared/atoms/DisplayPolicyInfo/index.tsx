import React from "react";
import { POLICY_HOLDER } from "../../../constants/languageKeys";
import { useSelector } from "../../../redux/store";
import { LineWrapper } from "./styles";

const DisplayPolicyInfo = () => {
  const {
    policyHolder: { name },
  } = useSelector((state) => state.contactsInPolicy);

  const hasPolicyHolder = name.length > 0;

  return (
    <>
      {hasPolicyHolder && (
        <LineWrapper>
          <span className="span-small">{POLICY_HOLDER.POLICY_HOLDER}</span>
          <br />
          <span className="span-base">{name}</span>
        </LineWrapper>
      )}
    </>
  );
};

export default DisplayPolicyInfo;
