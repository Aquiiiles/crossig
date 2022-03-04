import { useEffect, useState } from "react";
import { getSteps, StepsLookupTableKeys } from "../../../../constants/steps";
import { Step } from "../../../types/stepper";

export default function useStepper(
  currentStep: number,
  subCategory?: { name: StepsLookupTableKeys; currentStep: number }
) {
  const [steps, setSteps] = useState(getSteps("MAIN"));
  const [subSteps, setSubSteps] = useState(
    subCategory != null ? getSteps(subCategory.name) : []
  );

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

  useEffect(() => {
    setSteps(deriveStepState(steps, currentStep - 1));
  }, [currentStep]);

  useEffect(() => {
    if (subCategory) {
      setSubSteps(deriveStepState(subSteps, subCategory.currentStep - 1));
    }
  }, [subCategory?.currentStep]);

  return [steps, subSteps] as const;
}
