import { useEffect, useState } from "react";
import { useHistory } from "react-router-dom";
import { getSteps } from "../../../../constants/steps";
import { StepsLookupTableKeys } from "../../../../constants/types";
import { Step } from "../../../types";

export default function useStepper(
  currentStep: number,
  subCategory?: { name: StepsLookupTableKeys; currentStep: number }
) {
  const [steps, setSteps] = useState(getSteps("MAIN"));
  const [subSteps, setSubSteps] = useState(
    subCategory != null ? getSteps(subCategory.name) : []
  );
  const history = useHistory();

  const deriveStepState = (stepArray: Step[], index: number): Step[] => {
    if (index > stepArray.length) {
      throw new Error("Current stepper index out of bounds.");
    } else {
      const newArr = [...stepArray];
      newArr.splice(index, 1, { ...stepArray[index], state: "ACTIVE" });
      newArr.splice(
        0,
        index,
        ...newArr.slice(0, index).map((step) => {
          return { ...step, state: "COMPLETE" } as typeof step;
        })
      );

      return newArr;
    }
  };

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

  useEffect(() => {
    setSteps(deriveStepState(steps, currentStep - 1));
  }, [currentStep]);

  useEffect(() => {
    if (subCategory) {
      setSubSteps(deriveStepState(subSteps, subCategory.currentStep - 1));
    }
  }, [subCategory?.currentStep]);

  return [steps, subSteps, { handleStepClick }] as const;
}
