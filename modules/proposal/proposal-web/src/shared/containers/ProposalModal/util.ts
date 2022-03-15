import { viewsLookupTable } from "../../../constants/views";

const headerMarginLookupTable = {
  [viewsLookupTable.CONTACT_SEARCH]: true,
  [viewsLookupTable.COVERAGE_PLAN]: true,
  [viewsLookupTable.INSURANCE_PRODUCT]: true,
  [viewsLookupTable.NEW_CONTACT]: false,
  [viewsLookupTable.ROLES_ON_POLICY]: true,
  [viewsLookupTable.UPDATE_CONTACT]: false,
  [viewsLookupTable.VESSEL_SEARCH]: true,
};

export const hasMargin = (view: string) => {
  return headerMarginLookupTable[view];
};
