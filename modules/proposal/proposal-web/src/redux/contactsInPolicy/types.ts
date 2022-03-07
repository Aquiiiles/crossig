import * as constants from "../../constants/RolesOnPolicy";

export type contactInPolicy = {
  [constants.EXT_NUMBER_KEY]: number;
  [constants.OIB_KEY]: string;
  [constants.SUB_KEY]: string;
  [constants.NAME_KEY]: string;
  [constants.ROLES_KEY]: Array<string>;
};
