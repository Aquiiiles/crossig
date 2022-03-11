import React from "react";
import { useHistory } from "react-router-dom";
import Step from "../../../shared/atoms/Stepper/Step";
import DisplayPolicyInfo from "../../../shared/atoms/DisplayPolicyInfo";
import MobileStep from "../../../shared/atoms/Stepper/MobileStep";
import useStepper from "./hooks/useStepper";
import { Wrapper, MobileWrapper } from "./styles";
import { StepsLookupTableKeys } from "../../../constants/steps";
import ClayIcon from "@clayui/icon";
import spritemap from "@clayui/css/lib/images/icons/icons.svg";

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

  const history = useHistory();

  const canNavigateToStep = (stepState: string) => {
    return !["ACTIVE", "INACTIVE"].includes(stepState);
  };

  const handleStepClick = (targetStepIndex: number) => {
    const targetStep = steps.at(targetStepIndex - 1);

    if (targetStep && canNavigateToStep(targetStep.state)) {
      const route = targetStep.route;
      history.replace({ pathname: route, state: { doSearch: true } });
    }
  };

  return (
    <Wrapper>
      <MobileWrapper>
        {steps.map((step, index) => (
          <>
            <div className="desktop-stepper">
              <Step
                key={step.name}
                stepIndex={index + 1}
                step={step}
                subSteps={index + 1 === currentStep ? subSteps : []}
                handleClick={handleStepClick}
              />
            </div>
            <div className="mobile-stepper">
              <MobileStep
                key={step.name}
                stepIndex={index + 1}
                step={step}
                subSteps={index + 1 === currentStep ? subSteps : []}
                handleClick={handleStepClick}
              />
            </div>
          </>
        ))}
        <ClayIcon symbol="times" spritemap={spritemap} />
      </MobileWrapper>
      <div className="desktop-stepper">
        {currentStep > 1 && <DisplayPolicyInfo />}
        {children}
      </div>
    </Wrapper>
  );
};

export default Stepper;
