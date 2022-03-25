import languageKeys from "./Language";
import { Step } from "../shared/types";
import { ROUTES } from "./routes";
import { StepsLookupTableKeys } from "./types";

const { STEPPER_STEP, STEPPER_INSURED_OBJECT_DETAILS_STEP } = languageKeys;

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
  CONTACT_LOOKUP: ROUTES.CONTACT_SEARCH,
  PRODUCT: ROUTES.PRODUCT,
  ROLES: ROUTES.ROLES,
  COVERAGE_PLAN: ROUTES.COVERAGE_PLAN,
  OBJECT_DETAILS: "",
  PREMIUM: ROUTES.PREMIUM,
};
