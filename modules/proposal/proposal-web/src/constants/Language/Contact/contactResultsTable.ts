import { LiferayLanguageType } from "../types";

declare const Liferay: LiferayLanguageType;

export const CONTACT_RESULTS_TABLE = {
  HEADER: {
    OIB: Liferay.Language.get("contact-results-table-header-oib"),
    SUB: Liferay.Language.get("contact-results-table-header-sub"),
    DOB: Liferay.Language.get("contact-results-table-header-dob"),
    NAME: Liferay.Language.get("contact-results-table-header-name"),
    STREET: Liferay.Language.get("contact-results-table-header-street"),
    CITY: Liferay.Language.get("contact-results-table-header-city"),
    TYPE: Liferay.Language.get("contact-results-table-header-type"),
  },
};
