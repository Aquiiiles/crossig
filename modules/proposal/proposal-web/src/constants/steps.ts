import {
  STEPPER_STEP,
  STEPPER_INSURED_OBJECT_DETAILS_STEP,
} from "./languageKeys";
import { Step } from "../shared/types/stepper";

export const getSteps = (key: StepsLookupTableKeys) => {
  const stepCategory = stepsLookupTable[key];
  return Object.keys(stepCategory).map((stepKey) => {
    return {
      name: stepCategory[stepKey as keyof typeof stepCategory],
      state: "INACTIVE",
    };
  }) as Step[];
};

export const stepsLookupTable = {
  MAIN: STEPPER_STEP,
  INSURED_OBJECT_DETAILS: STEPPER_INSURED_OBJECT_DETAILS_STEP,
};

export type StepsLookupTableKeys = keyof typeof stepsLookupTable;
