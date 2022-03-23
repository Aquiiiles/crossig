import { ValidatorFunction } from "../hooks/types";
import languageKeys from "../../constants/Language";

const { VALIDATOR_MESSAGE } = languageKeys;

type ValidatorFunctionDay = (
  value: Parameters<ValidatorFunction>[0],
  dateMonth: string,
  dateYear: string
) => ReturnType<ValidatorFunction>;

const isLeapYear = (year: number) =>
  year % 4 === 0 && !(year % 100 === 0 && year % 400 !== 0);

const validateDay: ValidatorFunctionDay = (value, dateMonth, dateYear) => {
  const number = Number(value);
  const year = Number(dateYear);
  if (value === "") return;
  if (isLeapYear(year) && Number(dateMonth) === 2 && number > 29)
    return VALIDATOR_MESSAGE.INVALID_BIRTH_DAY_FEB.LEAP_YEAR;
  if (!isLeapYear(year) && Number(dateMonth) === 2 && number > 28)
    return VALIDATOR_MESSAGE.INVALID_BIRTH_DAY_FEB.NO_LEAP_YEAR;
  if (number < 1 || number > 31) return VALIDATOR_MESSAGE.INVALID_BIRTH_DAY;
};

const validateMonth: ValidatorFunction = (value) => {
  const number = Number(value);
  if (value === "") return;
  if (number < 1 || number > 12) return VALIDATOR_MESSAGE.INVALID_BIRTH_MONTH;
};

const validateYear: ValidatorFunction = (value) => {
  const number = Number(value);
  if (value === "") return;
  if (number < 1) return VALIDATOR_MESSAGE.INVALID_BIRTH_YEAR;
};

export { validateDay, validateMonth, validateYear };
