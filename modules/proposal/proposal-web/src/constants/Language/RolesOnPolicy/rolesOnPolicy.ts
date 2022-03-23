import { LiferayLanguageType } from "../types";

declare const Liferay: LiferayLanguageType;

export const ROLES_ON_POLICY = {
  TITLE: Liferay.Language.get("roles-on-policy-title"),
  SUBTITLE: Liferay.Language.get("roles-on-policy-subtitle"),
  INSURED_ROLE_MISSING: Liferay.Language.get(
    "roles-on-policy-insured-role-missing"
  ),
  ADD_ROLE: Liferay.Language.get("roles-on-policy-add-role"),
  NO_OPTIONS: Liferay.Language.get("roles-on-policy-no-options"),
  POLICY_HOLDER: Liferay.Language.get("roles-on-policy-policy-holder"),
  INSURED: Liferay.Language.get("roles-on-policy-insured"),
};

export const ROLES_TABLE = {
  HEADER: {
    OIB: Liferay.Language.get("roles-table-header-oib"),
    SUB: Liferay.Language.get("roles-table-header-sub"),
    NAME: Liferay.Language.get("roles-table-header-name"),
    ROLES: Liferay.Language.get("roles-table-header-roles"),
  },
};

export const POLICY_HOLDER = {
  POLICY_HOLDER: Liferay.Language.get("policy-holder-title"),
};
