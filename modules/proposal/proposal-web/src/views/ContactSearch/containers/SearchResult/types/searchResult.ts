import * as constants from "../constants/searchResult";

export type responseType = {
  [constants.EXT_NUMBER_KEY]: number;
  [constants.OIB_KEY]: string;
  [constants.SUB_KEY]: string;
  [constants.DOB_KEY]: string;
  [constants.NAME_KEY]: string;
  [constants.STREET_KEY]: string;
  [constants.CITY_KEY]: string;
  [constants.TYPE_KEY]: string;
  [constants.MAIL_VALIDATED_KEY]: boolean;
  [constants.PHONE_NUMBER_VALIDATED_KEY]: boolean;
};

export type addressType = {
  street_address: string;
  city: string;
};

export type providedDataType = {
  [constants.EXT_NUMBER_KEY]: number;
  [constants.CITY_KEY]: string;
  [constants.OIB_KEY]: string;
  [constants.DOB_KEY]: string;
  [constants.FIRST_NAME_KEY]: string;
  [constants.NAME_KEY]: string;
  [constants.STREET_KEY]: string;
  [constants.TYPE_KEY]: { desc: string; id: string };
  address: string;
  [constants.MAIL_VALIDATED_KEY]: boolean;
  [constants.PHONE_NUMBER_VALIDATED_KEY]: boolean;
};
