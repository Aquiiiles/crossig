import React from "react";
import {
  ActiveBar,
  Wrapper,
  Text,
  InnerWrapper,
  SubStepWrapper,
} from "./style";
import { Step as StepType } from "../../../types/stepper";

interface props {
  step: StepType;
  stepIndex: number;
  subSteps: StepType[];
  isSubStep?: boolean;
}

const Step: React.FC<props> = ({ step, stepIndex, subSteps, isSubStep }) => {
  return (
    <>
      <Wrapper>
        {isSubStep ? <span></span> : <ActiveBar state={step.state} />}
        <InnerWrapper>
          {isSubStep ? (
            <span></span>
          ) : (
            <Text state={step.state}>{stepIndex}</Text>
          )}
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
      {subSteps != null && subSteps.length > 0
        ? subSteps.map((subStep, index) => (
            <Step
              key={subStep.name}
              stepIndex={index + 1}
              step={subStep}
              subSteps={[]}
              isSubStep
            />
          ))
        : null}
    </>
  );
};

export default Step;
