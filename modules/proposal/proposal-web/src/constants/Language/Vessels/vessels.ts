import LiferayLanguageType from "../types";

declare const Liferay: LiferayLanguageType;

export const VESSEL = {
  TYPE: {
    BOAT: Liferay.Language.get("vessel-type-boat"),
    YATCH: Liferay.Language.get("vessel-type-yatch"),
    BIG_YATCH: Liferay.Language.get("vessel-type-big-yatch"),
    RIVERBOAT: Liferay.Language.get("vessel-type-riverboat"),
  },
};

export const VESSEL_LOOKUP = {
  TITLE: Liferay.Language.get("vessel-lookup-title"),
  SUBTITLE: Liferay.Language.get("vessel-lookup-subtitle"),
  BUTTON_SEARCH_VESSEL: Liferay.Language.get(
    "vessel-lookup-button-search-vessel"
  ),
  BUTTON_CREATE_NEW_VESSEL: Liferay.Language.get(
    "vessel-lookup-button-create-new-vessel"
  ),
  LINK_BACK: Liferay.Language.get("vessel-lookup-link-back"),
  VESSELS_FOUND: Liferay.Language.get("vessel-lookup-result-vessels-found"),
  NO_VESSELS_FOUND: Liferay.Language.get(
    "vessel-lookup-result-no-vessels-found"
  ),
  TOO_MANY_SEARCH_RESULTS: Liferay.Language.get(
    "vessel-lookup-result-too-many-search-results"
  ),
  FIELD: {
    SELECT: Liferay.Language.get("vessel-lookup-field-select"),
    TYPE: Liferay.Language.get("vessel-lookup-field-type"),
    NAME: Liferay.Language.get("vessel-lookup-field-name"),
    REGISTRATION_MARK: Liferay.Language.get(
      "vessel-lookup-field-registration-mark"
    ),
    NIB: Liferay.Language.get("vessel-lookup-field-nib"),
    FLEET_NAME: Liferay.Language.get("vessel-lookup-field-fleet-name"),
  },
};

export const VESSEL_LOOKUP_TABLE = {
  CHOOSE_AND_CONTINUE: Liferay.Language.get(
    "vessel-lookup-result-choose-and-continue"
  ),
  NIB: Liferay.Language.get("vessel-lookup-results-table-header-nib"),
  REGISTRATION_MARK: Liferay.Language.get(
    "vessel-lookup-results-table-header-registration-mark"
  ),
  VESSEL_NAME: Liferay.Language.get(
    "vessel-lookup-results-table-header-vessel-name"
  ),
  FLEET_NAME: Liferay.Language.get(
    "vessel-lookup-results-table-header-fleet-name"
  ),
  POLICY_HOLDER: Liferay.Language.get(
    "vessel-lookup-results-table-header-policy-holder"
  ),
  USE_VESSEL: Liferay.Language.get("vessel-lookup-table-use-vessel"),
  VIEW_DETAILS: Liferay.Language.get("vessel-lookup-table-view-details"),
};
