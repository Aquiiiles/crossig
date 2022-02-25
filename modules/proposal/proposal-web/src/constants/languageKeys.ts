declare const Liferay: {
  Language: {
    get: (languageKey: string) => string;
  }
};

export const CONTACT_INFO = {
  ADD_EMAIL_ADDRESS: Liferay.Language.get('contact-info-add-email-address'),
  ADD_MOBILE_PHONE: Liferay.Language.get('contact-info-add-mobile-phone'),
  AREA_CODE: Liferay.Language.get('contact-info-area-code'),
  CANCEL: Liferay.Language.get('contact-info-cancel'),
  COUNTRY_CODE: Liferay.Language.get('contact-info-country-code'),
  CREATE_CONTACT: Liferay.Language.get('contact-info-create-contact'),
  UPDATE_CONTACT: Liferay.Language.get('contact-info-update-contact'),
  PHONE_NUMBER: Liferay.Language.get('contact-info-phone-number'),
  PHONE_NUMBER_ERROR: Liferay.Language.get('contact-info-phone-number-error'),
  TITLE: Liferay.Language.get('contact-info-title'),
  MAIN_EMAIL: Liferay.Language.get('contact-info-main-email'),
  MAIN_EMAIL_SUBTITLE: Liferay.Language.get('contact-info-main-email-subtitle'),
  EMAIL_ADDRESS: Liferay.Language.get('contact-info-email-address'),
  MAIN_MOBILE: Liferay.Language.get('contact-info-main-mobile'),
  MAIN_MOBILE_SUBTITLE: Liferay.Language.get('contact-info-main-mobile-subtitle'),
  OTHER_EMAIL_ADDRESSES: Liferay.Language.get('contact-info-other-email-addresses'),
  OTHER_EMAIL_ADDRESSES_SUBTITLE: Liferay.Language.get('contact-info-other-email-addresses-subtitle'),
  OTHER_MOBILE_PHONES_FIXED: Liferay.Language.get('contact-info-other-mobile-phones-fixed'),
  OTHER_MOBILE_PHONES_MOBILE: Liferay.Language.get('contact-info-other-mobile-phones-mobile'),
  PHONE_TYPE: Liferay.Language.get('contact-info-phone-type'),
  INVALID_EMAIL_MESSAGE: Liferay.Language.get('contact-info-invalid-email-message')
}

export const CONTACT_SEARCH_TITLE = Liferay.Language.get('contact-search-title');
export const CONTACT_SEARCH_SUBTITLE = Liferay.Language.get('contact-search-subtitle');
export const CONTACT_SEARCH_ACTION_BUTTON = Liferay.Language.get('contact-search-action-button');
export const CONTACT_SEARCH_FIELD_NAME_OR_OIB = Liferay.Language.get('contact-search-field-name-or-oib');
export const CONTACT_SEARCH_FIELD_OIB = Liferay.Language.get('contact-search-field-oib');
export const CONTACT_SEARCH_FIELD_LAST_NAME_COMPANY_NAME_SE_NAME = Liferay.Language.get('contact-search-field-last-name-company-name-se-name');
export const CONTACT_SEARCH_FIELD_FIRST_NAME = Liferay.Language.get('contact-search-field-first-name');
export const CONTACT_SEARCH_FIELD_CITY = Liferay.Language.get('contact-search-field-city');
export const CONTACT_SEARCH_FIELD_STREET_ADDRESS = Liferay.Language.get('contact-search-field-street-address');
export const CONTACT_SEARCH_FIELD_COUNTRY_CODE = Liferay.Language.get('contact-search-field-country-code');
export const CONTACT_SEARCH_FIELD_AREA_CODE = Liferay.Language.get('contact-search-field-area-code');
export const CONTACT_SEARCH_FIELD_PHONE_NUMBER = Liferay.Language.get('contact-search-field-phone-number');
export const CONTACT_SEARCH_FIELD_EMAIL_ADDRESS = Liferay.Language.get('contact-search-field-email-address');
export const CONTACT_SEARCH_CREATE_NEW_CONTACT = Liferay.Language.get('contact-search-create-new-contact');
export const CONTACT_SEARCH_TABLE_VIEW_DETAILS = Liferay.Language.get('contact-search-table-view-details');
export const CONTACT_SEARCH_TABLE_USE_CONTACT = Liferay.Language.get('contact-search-table-use-contact');
export const CONTACT_SEARCH_RESULT_CONTACTS_FOUND = Liferay.Language.get('contact-search-result-contacts-found');
export const CONTACT_SEARCH_RESULT_NO_CONTACTS_FOUND = Liferay.Language.get('contact-search-result-no-contacts-found');
export const CONTACT_SEARCH_RESULT_TOO_MANY_SEARCH_RESULTS = Liferay.Language.get('contact-search-result-too-many-search-results');
export const CONTACT_SEARCH_MORE_SEARCH_OPTIONS = Liferay.Language.get('contact-search-more-search-options');
export const CONTACT_SEARCH_RESULT_EMAIL_NOT_VALIDATED= Liferay.Language.get('contact-search-result-email-not-validated');
export const CONTACT_SEARCH_RESULT_PHONE_NOT_VALIDATED= Liferay.Language.get('contact-search-result-phone-not-validated');
export const CONTACT_SEARCH_RESULT_EMAIL_AND_PHONE_NOT_VALIDATED= Liferay.Language.get('contact-search-result-email-and-phone-not-validated');

export const CREATE_NEW_CONTACT = {
    TITLE: Liferay.Language.get('create-new-contact-title'),
    SUBTITLE: Liferay.Language.get('create-new-contact-subtitle'),
    BASIC_INFO_TITLE: Liferay.Language.get('create-new-contact-basic-info-title'),
    TYPE: Liferay.Language.get('create-new-contact-type'),
    ADDRESS_TITLE : Liferay.Language.get('create-new-contact-address-title'),
    ID_ADDRESS : Liferay.Language.get('create-new-contact-id-address'),
    REGISTERED_OFFICE_ADDRESS : Liferay.Language.get('create-new-contact-registered-office-address'),
    DISPATCH_ADDRESS : Liferay.Language.get('create-new-contact-dispatch-address'),
    NO_RESULTS_FOUND: Liferay.Language.get('create-new-contact-no-results-found'),
    CREATE_LEGAL_ENTITY: Liferay.Language.get('create-new-contact-create-legal-entity'),
    SUBMIT_BUTTON: Liferay.Language.get('create-new-contact-submit-button'),
    BACKOFFICE_NOTIFICATION: Liferay.Language.get('create-new-contact-backoffice-notification'),
    CREATE_CONTACT_FAILURE: Liferay.Language.get('create-new-contact-create-contact-failure'),
    FIELD: {
        CONTACT_TYPE: {
            INDIVIDUAL: Liferay.Language.get('create-new-contact-field-contact-type-individual'),
            SELF_EMPLOYED: Liferay.Language.get('create-new-contact-field-contact-type-self-employed'),
            LEGAL_ENTITY: Liferay.Language.get('create-new-contact-field-contact-type-legal-entity'),
        },
        FIRST_NAME: Liferay.Language.get('create-new-contact-field-first-name'),
        LAST_NAME: Liferay.Language.get('create-new-contact-field-last-name'),
        BIRTH_DATE: Liferay.Language.get('create-new-contact-field-birth-date'),
        OIB: Liferay.Language.get('create-new-contact-field-oib'),
        FOREIGNER_STATUS: Liferay.Language.get('create-new-contact-field-foreigner-status'),
        COMPANY_NAME: Liferay.Language.get('create-new-contact-field-company-name'),
        SUBSIDIARY_NUMBER: Liferay.Language.get('create-new-contact-field-subsidiary-number'),
        COUNTRY: Liferay.Language.get('create-new-contact-field-country'),
        CITY: Liferay.Language.get('create-new-contact-field-city'),
        POSTAL_CODE: Liferay.Language.get('create-new-contact-field-postal-code'),
        STREET_ADDRESS: Liferay.Language.get('create-new-contact-field-street-address'),
        HOUSE_NUMBER: Liferay.Language.get('create-new-contact-field-house-number'),
        DISPATCH_ADDRESS: Liferay.Language.get('create-new-contact-field-dispatch-address'),
    },
}

export const CONTACT_RESULTS_TABLE = {
    HEADER: {
      OIB: Liferay.Language.get('contact-results-table-header-oib'),
      SUB: Liferay.Language.get('contact-results-table-header-sub'),
      DOB: Liferay.Language.get('contact-results-table-header-dob'),
      NAME: Liferay.Language.get('contact-results-table-header-name'),
      STREET: Liferay.Language.get('contact-results-table-header-street'),
      CITY: Liferay.Language.get('contact-results-table-header-city'),
      TYPE: Liferay.Language.get('contact-results-table-header-type'),
    }
}

export const UPDATE_CONTACT = {
  BACKOFFICE_WILL_GET_NOTIFIED: Liferay.Language.get("update-contact-backoffice-will-get-notified"),
  CREATE_A_TASK: Liferay.Language.get("update-contact-create-a-task"),
  EDIT_LEGAL_ENTITY: Liferay.Language.get("update-contact-edit-legal-entity"),
  TITLE: Liferay.Language.get("update-contact-title"),
  SUBTITLE: Liferay.Language.get("update-contact-subtitle"),
  SUBMIT_BUTTON: Liferay.Language.get("update-contact-submit-button"),
  SUCCESS: Liferay.Language.get("update-contact-update-success"),
  FAILURE: Liferay.Language.get("update-contact-update-failure"),
  USE_CONTACT: Liferay.Language.get("update-contact-use-contact")
}

export const VALIDATOR_MESSAGE = {
  INVALID_BIRTH_DAY: Liferay.Language.get("validator-message-invalid-birth-day"),
  INVALID_BIRTH_DAY_FEB: {
    LEAP_YEAR: Liferay.Language.get("validator-message-invalid-birth-day-feb-leap-year"),
    NO_LEAP_YEAR: Liferay.Language.get("validator-message-invalid-birth-day-feb-no-leap-year"),
  },
  INVALID_BIRTH_MONTH: Liferay.Language.get("validator-message-invalid-birth-month"),
  INVALID_BIRTH_YEAR: Liferay.Language.get("validator-message-invalid-birth-year"),
  OIB: {
    INVALID_LENGTH: Liferay.Language.get("validator-message-oib-invalid-length"),
    INVALID_CHARACTERS: Liferay.Language.get("validator-message-oib-invalid-characters"),
    INVALID: Liferay.Language.get("validator-message-oib-invalid"),
  },
  REQUIRED_FIELD_LEFT_EMPTY: Liferay.Language.get("validator-message-required-field-left-empty"),
}

export const INSURANCE_PRODUCT = {
  TITLE: Liferay.Language.get('insurance-product-title'),
  SUBTITLE: Liferay.Language.get('insurance-product-subtitle'),
  PRODUCT: {
    SELECT: Liferay.Language.get('insurance-product-product-select'),
  },
  BANNER: {
    CONTACT: Liferay.Language.get('insurance-product-banner-contact'),
    CREATED_SUCCESSFULLY: Liferay.Language.get('insurance-product-banner-contact-created-successfully'),
    VERIFICATION_LINK_HAS_BEEN_SENT: Liferay.Language.get('insurance-product-banner-verification-link-has-been-sent'),
    AND: Liferay.Language.get('insurance-product-banner-and'),
  }
}

export const PROPOSAL = {
  LINK_BACK: Liferay.Language.get('proposal-link-back'),
  BUTTON_CONTINUE: Liferay.Language.get('proposal-button-continue'),
}

export const ROLES_ON_POLICY = {
  TITLE: Liferay.Language.get('roles-on-policy-title'),
  SUBTITLE: Liferay.Language.get('roles-on-policy-subtitle'),
  INSURED_ROLE_MISSING: Liferay.Language.get('roles-on-policy-insured-role-missing'),
}

export const ROLES_TABLE = {
  HEADER:{
    OIB: Liferay.Language.get('roles-table-header-oib'),
    SUB: Liferay.Language.get('roles-table-header-sub'),
    NAME: Liferay.Language.get('roles-table-header-name'),
    ROLES: Liferay.Language.get('roles-table-header-roles'),
  }
}