import LiferayLanguageType from "../types";

declare const Liferay: LiferayLanguageType;

export const STEPPER_STEP = {
  CONTACT_LOOKUP: Liferay.Language.get("stepper-step-contact-lookup"),
  PRODUCT: Liferay.Language.get("stepper-step-product"),
  ROLES: Liferay.Language.get("stepper-step-roles"),
  COVERAGE_PLAN: Liferay.Language.get("stepper-step-coverage-plan"),
  OBJECT_DETAILS: Liferay.Language.get("stepper-step-insured-object-details"),
  PREMIUM: Liferay.Language.get("stepper-step-premium"),
};

export const STEPPER_INSURED_OBJECT_DETAILS_STEP = {
  VESSEL_LOOKUP: Liferay.Language.get(
    "stepper-insured-object-details-step-vessel-lookup"
  ),
  PRIMARY_DETAILS: Liferay.Language.get(
    "stepper-insured-object-details-step-primary-details"
  ),
  ADDITIONAL_DETAILS: Liferay.Language.get(
    "stepper-insured-object-details-step-additional-details"
  ),
  VALUE: Liferay.Language.get("stepper-insured-object-details-step-value"),
};
