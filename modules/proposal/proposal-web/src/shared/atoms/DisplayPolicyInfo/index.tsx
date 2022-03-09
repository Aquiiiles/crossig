import React from "react";
import { POLICY_HOLDER } from "../../../constants/languageKeys";
import { useSelector } from "../../../redux/store";
import { LineWrapper } from "./styles";
  
const DisplayPolicyInfo = () => {
  const { policyHolder } = useSelector(
    (state) => state.contactsInPolicy
  );

  const hasPolicyHolder = policyHolder.name.length > 0;

  return (
    <>
      { hasPolicyHolder && 
          <LineWrapper>
              <span className="span-small">
                {POLICY_HOLDER.POLICY_HOLDER}
              </span>
              <br/>
              <span className="span-base">
                {policyHolder.name}
              </span>
          </LineWrapper>
      }
    </>
  );
};

export default DisplayPolicyInfo;
