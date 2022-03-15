import { VESSEL_LOOKUP_TABLE } from "../../../../../constants/languageKeys";
import { HeaderCell } from "../../../../../shared/types/common";

export const NIB: HeaderCell = {
  key: "nib",
  name: VESSEL_LOOKUP_TABLE.NIB,
  expanded: false,
  hasSpan: true,
};

export const REGISTRATION_MARK: HeaderCell = {
  key: "registrationMark",
  name: VESSEL_LOOKUP_TABLE.REGISTRATION_MARK,
  expanded: false,
  hasSpan: false,
};

export const VESSEL_NAME: HeaderCell = {
  key: "vesselName",
  name: VESSEL_LOOKUP_TABLE.VESSEL_NAME,
  expanded: false,
  hasSpan: false,
};

export const FLEET_NAME: HeaderCell = {
  key: "fleetName",
  name: VESSEL_LOOKUP_TABLE.FLEET_NAME,
  expanded: true,
  hasSpan: false,
};

export const POLICY_HOLDER: HeaderCell = {
  key: "policyHolder",
  name: VESSEL_LOOKUP_TABLE.POLICY_HOLDER,
  expanded: true,
  hasSpan: false,
};

export const VESSEL_LOOKUP_HEADER = [
  NIB,
  REGISTRATION_MARK,
  VESSEL_NAME,
  FLEET_NAME,
  POLICY_HOLDER,
];
