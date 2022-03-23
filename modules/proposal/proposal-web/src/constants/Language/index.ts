import { CONTACT_RESULTS_TABLE } from "./Contact/contactResultsTable";
import { CONTACT_INFO } from "./Contact/contactInfo";
import { CREATE_NEW_CONTACT } from "./Contact/createNewContact";
import { UPDATE_CONTACT } from "./Contact/updateContact";
import { VALIDATOR_MESSAGE } from "./Validation/validation";
import { INSURANCE_PRODUCT } from "./InsuranceProduct/insuranceProduct";
import { PREMIUM } from "./Premium/premium";
import { PROPOSAL } from "./Proposal/proposal";
import { COVERAGE_PLAN } from "./CoveragePlan/coveragePlan";
import * as contactSearchLanguageKeys from "./Contact/contactSearch";
import * as rolesLanguageKeys from "./RolesOnPolicy/rolesOnPolicy";
import * as vesselLanguageKeys from "./Vessels/vessels";
import * as stepperLanguageKeys from "./Stepper/stepper";

const languageKeys = {
  CONTACT_SEARCH: contactSearchLanguageKeys.CONTACT_SEARCH,
  CONTACT_RESULTS_TABLE,
  ROLES_ON_POLICY: rolesLanguageKeys.ROLES_ON_POLICY,
  ROLES_TABLE: rolesLanguageKeys.ROLES_TABLE,
  CONTACT_INFO,
  CREATE_NEW_CONTACT,
  UPDATE_CONTACT,
  VALIDATOR_MESSAGE,
  INSURANCE_PRODUCT,
  VESSEL: vesselLanguageKeys.VESSEL,
  VESSEL_LOOKUP: vesselLanguageKeys.VESSEL_LOOKUP,
  VESSEL_LOOKUP_TABLE: vesselLanguageKeys.VESSEL_LOOKUP_TABLE,
  STEPPER_STEP: stepperLanguageKeys.STEPPER_STEP,
  STEPPER_INSURED_OBJECT_DETAILS_STEP:
    stepperLanguageKeys.STEPPER_INSURED_OBJECT_DETAILS_STEP,
  POLICY_HOLDER: rolesLanguageKeys.POLICY_HOLDER,
  PREMIUM,
  PROPOSAL,
  TOO_MANY_SEARCH_RESULTS: contactSearchLanguageKeys.TOO_MANY_SEARCH_RESULTS,
  COVERAGE_PLAN,
};

export default languageKeys;
