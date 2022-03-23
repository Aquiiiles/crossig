import { ValidatorFunction } from "../hooks/types";
import { VALIDATOR_MESSAGE } from "../../constants/languageKeys";

const validateOib: ValidatorFunction = (value) => {
  if (value.length < 11) return;
  if (value.length > 11) return VALIDATOR_MESSAGE.OIB.INVALID_LENGTH;
  if (isNaN(Number(value))) return VALIDATOR_MESSAGE.OIB.INVALID_CHARACTERS;

  const firstDigit = Number(value.charAt(0));
  let result = firstDigit + 10;

  for (let index = 0; index < value.length - 1; index++) {
    result = result % 10;
    if (result === 0) {
      result = 10;
    }
    result = result * 2;
    result = result % 11;
    if (index + 1 !== value.length - 1) {
      result += Number(value.charAt(index + 1));
    } else {
      if (result === 1) {
        result = 0;
      } else {
        result = 11 - result;
      }
    }
  }

  if (result === Number(value.charAt(value.length - 1))) {
    return;
  }

  return VALIDATOR_MESSAGE.OIB.INVALID;
};

export { validateOib };
