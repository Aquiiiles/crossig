import { VESSEL_LOOKUP_TABLE } from "../../../../../constants/languageKeys";
import { headerCellType } from "../types/vesselLookupResult";

export const NIB: headerCellType = {
  key: "NIB",
  name: VESSEL_LOOKUP_TABLE.NIB,
  expanded: false,
  hasSpan: true,
};

export const REGISTRATION_MARK: headerCellType = {
  key: "registrationMark",
  name: VESSEL_LOOKUP_TABLE.REGISTRATION_MARK,
  expanded: false,
  hasSpan: false,
};

export const VESSEL_NAME: headerCellType = {
  key: "vesselName",
  name: VESSEL_LOOKUP_TABLE.VESSEL_NAME,
  expanded: false,
  hasSpan: false,
};

export const FLEET_NAME: headerCellType = {
  key: "fleetName",
  name: VESSEL_LOOKUP_TABLE.FLEET_NAME,
  expanded: true,
  hasSpan: false,
};

export const POLICY_HOLDER: headerCellType = {
  key: "policyHolder",
  name: VESSEL_LOOKUP_TABLE.POLICY_HOLDER,
  expanded: true,
  hasSpan: false,
};
