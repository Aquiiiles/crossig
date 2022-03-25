import LiferayLanguageType from "../types";

declare const Liferay: LiferayLanguageType;

export const UPDATE_CONTACT = {
  BACKOFFICE_WILL_GET_NOTIFIED: Liferay.Language.get(
    "update-contact-backoffice-will-get-notified"
  ),
  CREATE_A_TASK: Liferay.Language.get("update-contact-create-a-task"),
  EDIT_LEGAL_ENTITY: Liferay.Language.get("update-contact-edit-legal-entity"),
  TITLE: Liferay.Language.get("update-contact-title"),
  SUBTITLE: Liferay.Language.get("update-contact-subtitle"),
  SUBMIT_BUTTON: Liferay.Language.get("update-contact-submit-button"),
  SUCCESS: Liferay.Language.get("update-contact-update-success"),
  FAILURE: Liferay.Language.get("update-contact-update-failure"),
  USE_CONTACT: Liferay.Language.get("update-contact-use-contact"),
};
