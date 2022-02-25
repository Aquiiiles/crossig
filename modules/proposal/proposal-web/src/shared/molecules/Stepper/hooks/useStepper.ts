import { useEffect, useState } from "react";
import { steps as constantSteps } from "../../../../constants/steps";

export default function useStepper(currentStep: number) {
  const [steps, setSteps] = useState(constantSteps);
  const stepIndex = currentStep - 1;

  useEffect(() => {
    if (stepIndex > steps.length) {
      throw new Error("Current stepper index out of bounds.");
    } else {
      setSteps((prev) => {
        const newArr = [...prev];

        newArr.splice(stepIndex, 1, { ...steps[stepIndex], state: "ACTIVE" });
        newArr.splice(
          0,
          stepIndex,
          ...prev.slice(0, stepIndex).map((step) => {
            return { ...step, state: "COMPLETE" } as typeof step;
          })
        );

        return newArr;
      });
    }
  }, [stepIndex]);

  return [steps] as const;
}
