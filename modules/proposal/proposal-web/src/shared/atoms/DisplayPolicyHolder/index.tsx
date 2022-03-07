import React from "react";
import { POLICY_HOLDER } from "../../../constants/languageKeys";
import { useContactSelector } from "../../../redux/store";
import { LineWrapper } from "./styles";
  
const DisplayPolicyHolder = () => {
  const { contactsInPolicy } = useContactSelector(
    (state) => state.contactsInPolicy
  );
  const policyHolder = contactsInPolicy.length > 0 ? contactsInPolicy[0] : null;

  return (
    policyHolder != null ?
      <LineWrapper>
          <span className="span-small">
            {POLICY_HOLDER.POLICY_HOLDER}
          </span>
          <br/>
          <span className="span-base">
            {policyHolder.name}
          </span>
      </LineWrapper> : null
  );
};

export default DisplayPolicyHolder;
