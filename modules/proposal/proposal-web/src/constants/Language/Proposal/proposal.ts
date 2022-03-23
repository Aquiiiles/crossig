import LiferayLanguageType from "../types";

declare const Liferay: LiferayLanguageType;

export const NEW_PROPOSAL_BUTTON = Liferay.Language.get(
  "dashboard-new-proposal-button"
);

export const PROPOSAL = {
  LINK_BACK: Liferay.Language.get("proposal-link-back"),
  BUTTON_CONTINUE: Liferay.Language.get("proposal-button-continue"),
};
