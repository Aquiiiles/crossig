import React from "react";
import Step from "../../../shared/atoms/Stepper/Step";
import useStepper from "./hooks/useStepper";
import { Wrapper } from "./styles";
import { StepsLookupTableKeys } from "../../../constants/steps";

interface props {
  /** The step index as seen in the website/mockup (not 0 based) */
  currentStep: number;
  children?: React.ReactNode;
  subCategory?: {
    name: StepsLookupTableKeys;
    currentStep: number;
  };
}

const Stepper: React.FC<props> = ({ currentStep, subCategory, children }) => {
  const [steps, subSteps] = useStepper(currentStep, subCategory);

  return (
    <Wrapper>
      {steps.map((step, index) => (
        <Step
          key={step.name}
          stepIndex={index + 1}
          step={step}
          subSteps={index + 1 === currentStep ? subSteps : []}
        />
      ))}
      {children}
    </Wrapper>
  );
};

export default Stepper;
