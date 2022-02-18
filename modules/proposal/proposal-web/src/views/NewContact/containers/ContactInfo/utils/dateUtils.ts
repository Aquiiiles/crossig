export const valuesToISOString = (
  day: string,
  month: string,
  year: string
): string => {
  return new Date(Number(year), Number(month) - 1, Number(day)).toISOString();
};
