const zeroPad = (value: number) => {
  let valueAsString = value.toString();

  if (valueAsString.length === 1) {
    valueAsString = "0" + valueAsString;
  }

  return valueAsString;
};

export const formatLastUpdate = (date: Date) => {
  const day = zeroPad(date.getDay());
  const month = zeroPad(date.getMonth() + 1);
  const year = date.getFullYear();

  return day + "/" + month + "/" + year;
};
