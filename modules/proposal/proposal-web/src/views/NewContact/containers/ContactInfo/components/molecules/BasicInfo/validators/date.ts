type ValidatorReturn = string | undefined;
export type ValidatorFunction = (value: string) => ValidatorReturn;
type ValidatorFunctionDay = (
  value: string,
  dateMonth: string,
  dateYear: string
) => ValidatorReturn;

const isLeapYear = (year: number) =>
  year % 4 === 0 && !(year % 100 === 0 && year % 400 !== 0);

const validateDay: ValidatorFunctionDay = (value, dateMonth, dateYear) => {
  const number = Number(value);
  const year = Number(dateYear);
  if (value === "") return;
  if (isLeapYear(year) && Number(dateMonth) === 2 && number > 29)
    return "Please enter a valid birth-date from 1 to 29.";
  if (!isLeapYear(year) && Number(dateMonth) === 2 && number > 28)
    return "Please enter a valid birth-date from 1 to 28";
  if (number < 1 || number > 31)
    return "Please enter a valid birth-date from 1 to 31.";
};

const validateMonth: ValidatorFunction = value => {
  const number = Number(value);
  if (value === "") return;
  if (number < 1 || number > 12)
    return "Please enter a valid birth-month from 1 to 12.";
};

const validateYear: ValidatorFunction = value => {
  const number = Number(value);
  if (value === "") return;
  if (number < 1) return "Please enter a valid birth-year.";
};

export { validateDay, validateMonth, validateYear };
