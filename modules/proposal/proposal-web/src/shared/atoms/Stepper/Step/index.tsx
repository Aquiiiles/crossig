import React from "react";
import { ActiveBar, Wrapper, Text, InnerWrapper } from "./style";
import { Step as StepType } from "../../../types/stepper";

interface props {
  step: StepType;
  stepIndex: number;
}

const Step: React.FC<props> = ({ step, stepIndex }) => {
  return (
    <Wrapper>
      <ActiveBar state={step.state} />
      <InnerWrapper>
        <Text state={step.state}>{stepIndex}</Text>
        <Text
          state={step.state}
          className="h10"
          style={
            step.state === "COMPLETE"
              ? { textDecoration: "underline" }
              : undefined
          }
        >
          {step.name}
        </Text>
      </InnerWrapper>
    </Wrapper>
  );
};

export default Step;
