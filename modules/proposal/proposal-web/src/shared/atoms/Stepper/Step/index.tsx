import React from "react";
import { ActiveBar, Wrapper, Text, InnerWrapper } from "./style";
import { Step as StepType } from "../../../types";

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
    <>
      <Wrapper>
        {isSubStep ? <span></span> : <ActiveBar state={step.state} />}
        <InnerWrapper>
          {isSubStep ? (
            <span></span>
          ) : (
            <Text state={step.state} onClick={() => handleClick(stepIndex)}>
              {stepIndex}
            </Text>
          )}
          <Text
            state={step.state}
            className="h10"
            style={
              step.state === "COMPLETE"
                ? { textDecoration: "underline" }
                : undefined
            }
            onClick={() => handleClick(stepIndex)}
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
              handleClick={handleClick}
            />
          ))
        : null}
    </>
  );
};

export default Step;
