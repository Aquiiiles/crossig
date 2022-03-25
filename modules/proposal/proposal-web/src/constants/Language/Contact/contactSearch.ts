import { LiferayLanguageType } from "../types";

declare const Liferay: LiferayLanguageType;

export const CONTACT_SEARCH = {
  TITLE: Liferay.Language.get("contact-search-title"),
  SUBTITLE: Liferay.Language.get("contact-search-subtitle"),
  ACTION_BUTTON: Liferay.Language.get("contact-search-action-button"),
  CREATE_NEW_CONTACT: Liferay.Language.get("contact-search-create-new-contact"),
  MORE_SEARCH_OPTIONS: Liferay.Language.get(
    "contact-search-more-search-options"
  ),
  FIELD: {
    NAME_OR_OIB: Liferay.Language.get("contact-search-field-name-or-oib"),
    OIB: Liferay.Language.get("contact-search-field-oib"),
    LAST_NAME_COMPANY_NAME_SE_NAME: Liferay.Language.get(
      "contact-search-field-last-name-company-name-se-name"
    ),
    FIRST_NAME: Liferay.Language.get("contact-search-field-first-name"),
    LAST_NAME: Liferay.Language.get("contact-search-field-last-name"),
    CITY: Liferay.Language.get("contact-search-field-city"),
    STREET_ADDRESS: Liferay.Language.get("contact-search-field-street-address"),
    COUNTRY_CODE: Liferay.Language.get("contact-search-field-country-code"),
    AREA_CODE: Liferay.Language.get("contact-search-field-area-code"),
    PHONE_NUMBER: Liferay.Language.get("contact-search-field-phone-number"),
    EMAIL_ADDRESS: Liferay.Language.get("contact-search-field-email-address"),
  },
  TABLE: {
    VIEW_DETAILS: Liferay.Language.get("contact-search-table-view-details"),
    USE_CONTACT: Liferay.Language.get("contact-search-table-use-contact"),
    ADD_TO_POLICY: Liferay.Language.get("contact-search-table-add-to-policy"),
  },
  RESULT: {
    CONTACTS_FOUND: Liferay.Language.get(
      "contact-search-result-contacts-found"
    ),
    NO_CONTACTS_FOUND: Liferay.Language.get(
      "contact-search-result-no-contacts-found"
    ),
    TOO_MANY_SEARCH_RESULTS: Liferay.Language.get(
      "contact-search-result-too-many-search-results"
    ),
    EMAIL_NOT_VALIDATED: Liferay.Language.get(
      "contact-search-result-email-not-validated"
    ),
    PHONE_NOT_VALIDATED: Liferay.Language.get(
      "contact-search-result-phone-not-validated"
    ),
    EMAIL_AND_PHONE_NOT_VALIDATED: Liferay.Language.get(
      "contact-search-result-email-and-phone-not-validated"
    ),
  },
  FILTER: {
    CANCEL: Liferay.Language.get("contact-search-filter-cancel"),
    CLEAR: Liferay.Language.get("contact-search-filter-clear"),
    SEARCH: Liferay.Language.get("contact-search-filter-search"),
  },
};

export const TOO_MANY_SEARCH_RESULTS = Liferay.Language.get(
  "too-many-search-results"
);
