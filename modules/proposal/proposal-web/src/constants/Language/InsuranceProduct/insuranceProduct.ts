import LiferayLanguageType from "../types";

declare const Liferay: LiferayLanguageType;

export const INSURANCE_PRODUCT = {
  TITLE: Liferay.Language.get("insurance-product-title"),
  SUBTITLE: Liferay.Language.get("insurance-product-subtitle"),
  COMING_SOON: Liferay.Language.get("insurance-product-coming-soon"),
  PRODUCT: {
    SELECT: Liferay.Language.get("insurance-product-product-select"),
  },
  BANNER: {
    CONTACT: Liferay.Language.get("insurance-product-banner-contact"),
    CREATION: Liferay.Language.get("insurance-product-banner-contact-creation"),
    CREATED_SUCCESSFULLY: Liferay.Language.get(
      "insurance-product-banner-contact-created-successfully"
    ),
    VERIFICATION_LINK_HAS_BEEN_SENT: Liferay.Language.get(
      "insurance-product-banner-verification-link-has-been-sent"
    ),
    AND: Liferay.Language.get("insurance-product-banner-and"),
  },
};
