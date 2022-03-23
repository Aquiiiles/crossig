import LiferayLanguageType from "../types";

declare const Liferay: LiferayLanguageType;

export const PREMIUM = {
  TITLE: Liferay.Language.get("premium-title"),
  SUBTITLE: Liferay.Language.get("premium-subtitle"),
  POLICY_PERIOD: {
    TITLE: Liferay.Language.get("premium-policy-period"),
    TERM_PERIOD: Liferay.Language.get("premium-policy-period-term-period"),
    START_DATE: Liferay.Language.get("premium-policy-period-start-date"),
    START_TIME: Liferay.Language.get("premium-policy-period-start-time"),
    END_DATE: Liferay.Language.get("premium-policy-period-end-date"),
    END_TIME: Liferay.Language.get("premium-policy-period-end-time"),
    ISSUE_DATE: Liferay.Language.get("premium-policy-period-issue-date"),
  },
  SAVE_AND_RESUME_BUTTON: Liferay.Language.get(
    "premium-save-and-resume-later-button"
  ),
  CONTINUE_BUTTON: Liferay.Language.get("premium-continue-button"),
  SUCCESS: Liferay.Language.get("premium-success"),
  FAILURE: Liferay.Language.get("premium-failure"),
};
