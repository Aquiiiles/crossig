import React from "react";
import Step from "../../../shared/atoms/Stepper/Step";
import useStepper from "./hooks/useStepper";
import { Wrapper } from "./styles";

interface props {
  /** The step index as seen in the website/mockup (not 0 based) */
  currentStep: number;
}

const Stepper: React.FC<props> = ({ currentStep }) => {
  const [steps] = useStepper(currentStep);

  return (
    <Wrapper>
      {steps.map((step, index) => (
        <Step key={index} stepIndex={index + 1} step={step} />
      ))}
    </Wrapper>
  );
};

export default Stepper;
