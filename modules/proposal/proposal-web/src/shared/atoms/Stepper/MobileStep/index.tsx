import React from "react";
import { Wrapper } from "./styles";
import { Step as StepType } from "../../../types";
import ClayIcon from "@clayui/icon";
import spritemap from "@clayui/css/lib/images/icons/icons.svg";

interface props {
  step: StepType;
  stepIndex: number;
  subSteps: StepType[];
  isSubStep?: boolean;
  handleClick: (targetStep: number) => void;
}

const Step: React.FC<props> = ({ step, stepIndex, handleClick }) => {
  const isActive = step.state === "ACTIVE";
  const isComplete = step.state === "COMPLETE";

  return (
    <Wrapper onClick={() => handleClick(stepIndex)} state={step.state} className="step-icon">
      <ClayIcon
          className="step-icon"
        symbol={isComplete ? "check-circle-full" : isActive ? "radio-button" : "simple-circle"}
        spritemap={spritemap} />
    </Wrapper>
  );
};

export default Step;
