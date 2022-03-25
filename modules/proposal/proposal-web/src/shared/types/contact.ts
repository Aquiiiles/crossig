import * as constants from "../../constants/RolesOnPolicy";
export interface Country {
  label: string;
  value: string;
  flagKey: string;
}

export interface PhoneNumber {
  type: number;
  countryCode: string;
  areaCode: string;
  phoneNumber: string;
}

export interface Address {
  country: string;
  city: number;
  postalCode: string;
  street: string;
  houseNumber: string;
}

export type ContactInPolicy = {
  [constants.EXT_NUMBER_KEY]: number;
  [constants.OIB_KEY]: string;
  [constants.SUB_KEY]: string;
  [constants.NAME_KEY]: string;
  [constants.ROLES_KEY]: Array<string>;
};
