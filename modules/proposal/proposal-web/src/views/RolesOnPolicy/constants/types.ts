import * as constants from "./constants";

export type roleType = {
  [constants.OIB_KEY]: string;
  [constants.SUB_KEY]: string;
  [constants.NAME_KEY]: string;
  [constants.ROLES_KEY]: Array<string>;
};

export const initialRoleType = {
  [constants.OIB_KEY]: "",
  [constants.SUB_KEY]: "",
  [constants.NAME_KEY]: "",
  [constants.ROLES_KEY]: [""],
};
