import React from "react";
import { Wrapper } from "./styles";
import { Step as StepType } from "../../../types";

interface props {
  step: StepType;
  stepIndex: number;
  subSteps: StepType[];
  isSubStep?: boolean;
  handleClick: (targetStep: number) => void;
}

const Step: React.FC<props> = ({ step, stepIndex, handleClick }) => {
  const isActive = step.state === "ACTIVE";

  return (
    <Wrapper onClick={() => handleClick(stepIndex)} active={isActive}>
      {isActive ? <span className="outter" /> : null}
      <span className={isActive ? "active" : "not-active"} />
    </Wrapper>
  );
};

export default Step;
