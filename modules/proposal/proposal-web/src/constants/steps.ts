import { STEPPER_STEP_NAME } from "./languageKeys";
import { Step } from "../shared/types/stepper";

export const steps: Step[] = Object.keys(STEPPER_STEP_NAME).map((key) => {
  return {
    name: STEPPER_STEP_NAME[key as keyof typeof STEPPER_STEP_NAME],
    state: "INACTIVE",
  };
});
