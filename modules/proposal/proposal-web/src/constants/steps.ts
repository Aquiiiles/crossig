import {
  STEPPER_STEP,
  STEPPER_INSURED_OBJECT_DETAILS_STEP,
} from "./languageKeys";
import { Step } from "../shared/types/stepper";

export const getSteps = (key: StepsLookupTableKeys) => {
  const stepCategory = stepsLookupTable[key];
  return Object.keys(stepCategory).map((stepKey) => {
    const key = stepKey as keyof typeof stepCategory;

    return {
      name: stepCategory[key],
      state: "INACTIVE",
      route: stepRoutesLookupTable[key],
    };
  }) as Step[];
};

export const stepsLookupTable = {
  MAIN: STEPPER_STEP,
  INSURED_OBJECT_DETAILS: STEPPER_INSURED_OBJECT_DETAILS_STEP,
};

export const stepRoutesLookupTable = {
  CONTACT_LOOKUP: "/",
  PRODUCT: "/product",
  ROLES: "/roles",
  COVERAGE_PLAN: "/coverage_plan",
  OBJECT_DETAILS: "",
  PREMIUM: "",
};

export type StepsLookupTableKeys = keyof typeof stepsLookupTable;
