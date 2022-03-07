import React from "react";
import { contactTypes } from "../../../constants/contactConstants";
import { STEPPER_STEP } from "../../../constants/languageKeys";
import { useContactSelector } from "../../../redux/store";
import { LineWrapper } from "./styles";
  
const DisplayPolicyHolder = () => {
  const { contactsInPolicy } = useContactSelector(
    (state) => state.contactsInPolicy
  );
  console.log(contactsInPolicy);

  return (
    <LineWrapper>
        <p className="small">
            {STEPPER_STEP.POLICY_HOLDER}
        </p>
        <p className="base">
            {/* {message()} */}
        </p>
    </LineWrapper>
  );
};

export default DisplayPolicyHolder;
