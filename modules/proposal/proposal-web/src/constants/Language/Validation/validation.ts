import { LiferayLanguageType } from "../types";

declare const Liferay: LiferayLanguageType;

export const VALIDATOR_MESSAGE = {
  INVALID_BIRTH_DAY: Liferay.Language.get(
    "validator-message-invalid-birth-day"
  ),
  INVALID_BIRTH_DAY_FEB: {
    LEAP_YEAR: Liferay.Language.get(
      "validator-message-invalid-birth-day-feb-leap-year"
    ),
    NO_LEAP_YEAR: Liferay.Language.get(
      "validator-message-invalid-birth-day-feb-no-leap-year"
    ),
  },
  INVALID_BIRTH_MONTH: Liferay.Language.get(
    "validator-message-invalid-birth-month"
  ),
  INVALID_BIRTH_YEAR: Liferay.Language.get(
    "validator-message-invalid-birth-year"
  ),
  OIB: {
    INVALID_LENGTH: Liferay.Language.get(
      "validator-message-oib-invalid-length"
    ),
    INVALID_CHARACTERS: Liferay.Language.get(
      "validator-message-oib-invalid-characters"
    ),
    INVALID: Liferay.Language.get("validator-message-oib-invalid"),
  },
  REQUIRED_FIELD_LEFT_EMPTY: Liferay.Language.get(
    "validator-message-required-field-left-empty"
  ),
};
