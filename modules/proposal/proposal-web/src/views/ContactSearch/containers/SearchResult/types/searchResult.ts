import * as constants from "../constants/searchResult";

export type responseType = {
  [constants.OIB_KEY]: string;
  [constants.SUB_KEY]: string;
  [constants.DOB_KEY]: string;
  [constants.NAME_KEY]: string;
  [constants.STREET_KEY]: string;
  [constants.CITY_KEY]: string;
  [constants.TYPE_KEY]: string;
};

export type addressType = {
  street_address: string;
  city: string;
};

export type providedDataType = {
  [constants.OIB_KEY]: string;
  [constants.DOB_KEY]: string;
  [constants.NAME_KEY]: string;
  [constants.TYPE_KEY]: { desc: string; id: string };
  address: string;
};
