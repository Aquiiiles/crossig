import React from "react";
import { Wrapper, Dot, OutterDot } from "./styles";
import { Step as StepType } from "../../../types/stepper";

interface props {
  step: StepType;
  stepIndex: number;
  subSteps: StepType[];
  isSubStep?: boolean;
  handleClick: (targetStep: number) => void;
}

const Step: React.FC<props> = ({
  step,
  stepIndex,
  subSteps,
  isSubStep,
  handleClick,
}) => {
  return (
    <Wrapper onClick={() => handleClick(stepIndex)}>
      {step.state === "ACTIVE" ? <OutterDot /> : null}
      <Dot state={step.state} />
    </Wrapper>
  );
};

export default Step;
