import * as constants from "./constants";

export type roleType = {
  [constants.OIB_KEY]: string;
  [constants.SUB_KEY]: string;
  [constants.NAME_KEY]: string;
  [constants.ROLES_KEY]: Array<string>;
};