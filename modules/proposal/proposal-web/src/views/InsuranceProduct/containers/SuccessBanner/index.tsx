import React, { useEffect, useState } from "react";
import ClayAlert from "@clayui/alert";
import { contactTypes } from "../../../../constants/contactConstants";
import { useContactDispatch } from "../../../../redux/store";
import { actions as addressInfoActions } from "../../../../redux/addressSlice";
import { actions as contactInfoActions } from "../../../../redux/contactInfoSlice";
import { actions as basicInfoActions } from "../../../../redux/basicInfoSlice";
import { INSURANCE_PRODUCT } from "../../../../constants/languageKeys";

interface props {
  contact: {
    type: string;
    firstName: string;
    lastName: string;
    companyName: string;
    mainEmail?: string;
    mainMobile?: {
      countryCode: string;
      areaCode: string;
      number: string;
    };
  };
}

const SuccessBanner: React.FC<props> = ({ contact }) => {
  const dispatch = useContactDispatch();
  const [showBanner, setShowBanner] = useState(true);

  const message = (): string => {
    let mainMessage = "";
    let optionalMessage = "";

    switch (contact.type) {
      case contactTypes.Individual:
        mainMessage = `${INSURANCE_PRODUCT.BANNER.CONTACT} ${contact.firstName} ${contact.lastName} ${INSURANCE_PRODUCT.BANNER.CREATED_SUCCESSFULLY}`;
        break;
      case contactTypes.Legal_Entity:
      case contactTypes.Self_Employed:
        mainMessage = `${INSURANCE_PRODUCT.BANNER.CONTACT} ${contact.companyName} ${INSURANCE_PRODUCT.BANNER.CREATED_SUCCESSFULLY}`;
        break;
      default:
        console.error(`Unknown contact type! ${contact.type}`);
    }

    if (contact.mainEmail || contact.mainMobile) {
      optionalMessage = `${INSURANCE_PRODUCT.BANNER.VERIFICATION_LINK_HAS_BEEN_SENT}`;

      if (contact.mainEmail && contact.mainMobile) {
        optionalMessage = `${optionalMessage} ${contact.mainEmail} ${INSURANCE_PRODUCT.BANNER.AND} ${contact.mainMobile}.`;
      } else if (contact.mainEmail) {
        optionalMessage = `${optionalMessage} ${contact.mainEmail}.`;
      } else if (contact.mainMobile) {
        const phone = `+${contact.mainMobile.countryCode} ${contact.mainMobile.areaCode} ${contact.mainMobile.number}`;
        optionalMessage = `${optionalMessage} ${phone}.`;
      }
    }

    return `${mainMessage} ${optionalMessage}`;
  };

  useEffect(() => {
    const clearContactData = () => {
      [addressInfoActions, contactInfoActions, basicInfoActions].forEach(
        action => dispatch(action["resetFields"]())
      );
    };

    const timeout = setTimeout(() => {
      setShowBanner(false);
      clearContactData();
    }, 30000);

    return () => {
      clearTimeout(timeout);
      setShowBanner(false);
      clearContactData();
    };
  }, []);

  if (showBanner) {
    return <ClayAlert displayType="info">{message()}</ClayAlert>;
  } else {
    return null;
  }
};

export default SuccessBanner;
