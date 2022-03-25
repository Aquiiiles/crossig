import { LiferayLanguageType } from "../types";

declare const Liferay: LiferayLanguageType;

export const CREATE_NEW_CONTACT = {
  TITLE: Liferay.Language.get("create-new-contact-title"),
  SUBTITLE: Liferay.Language.get("create-new-contact-subtitle"),
  BASIC_INFO_TITLE: Liferay.Language.get("create-new-contact-basic-info-title"),
  TYPE: Liferay.Language.get("create-new-contact-type"),
  ADDRESS_TITLE: Liferay.Language.get("create-new-contact-address-title"),
  ID_ADDRESS: Liferay.Language.get("create-new-contact-id-address"),
  REGISTERED_OFFICE_ADDRESS: Liferay.Language.get(
    "create-new-contact-registered-office-address"
  ),
  DISPATCH_ADDRESS: Liferay.Language.get("create-new-contact-dispatch-address"),
  NO_RESULTS_FOUND: Liferay.Language.get("create-new-contact-no-results-found"),
  CREATE_LEGAL_ENTITY: Liferay.Language.get(
    "create-new-contact-create-legal-entity"
  ),
  SUBMIT_BUTTON: Liferay.Language.get("create-new-contact-submit-button"),
  BACKOFFICE_NOTIFICATION: Liferay.Language.get(
    "create-new-contact-backoffice-notification"
  ),
  CREATE_CONTACT_FAILURE: Liferay.Language.get(
    "create-new-contact-create-contact-failure"
  ),
  FIELD: {
    CONTACT_TYPE: {
      INDIVIDUAL: Liferay.Language.get(
        "create-new-contact-field-contact-type-individual"
      ),
      SELF_EMPLOYED: Liferay.Language.get(
        "create-new-contact-field-contact-type-self-employed"
      ),
      LEGAL_ENTITY: Liferay.Language.get(
        "create-new-contact-field-contact-type-legal-entity"
      ),
    },
    FIRST_NAME: Liferay.Language.get("create-new-contact-field-first-name"),
    LAST_NAME: Liferay.Language.get("create-new-contact-field-last-name"),
    BIRTH_DATE: Liferay.Language.get("create-new-contact-field-birth-date"),
    OIB: Liferay.Language.get("create-new-contact-field-oib"),
    FOREIGNER_STATUS: Liferay.Language.get(
      "create-new-contact-field-foreigner-status"
    ),
    COMPANY_NAME: Liferay.Language.get("create-new-contact-field-company-name"),
    SUBSIDIARY_NUMBER: Liferay.Language.get(
      "create-new-contact-field-subsidiary-number"
    ),
    COUNTRY: Liferay.Language.get("create-new-contact-field-country"),
    CITY: Liferay.Language.get("create-new-contact-field-city"),
    POSTAL_CODE: Liferay.Language.get("create-new-contact-field-postal-code"),
    STREET_ADDRESS: Liferay.Language.get(
      "create-new-contact-field-street-address"
    ),
    HOUSE_NUMBER: Liferay.Language.get("create-new-contact-field-house-number"),
    DISPATCH_ADDRESS: Liferay.Language.get(
      "create-new-contact-field-dispatch-address"
    ),
  },
};
