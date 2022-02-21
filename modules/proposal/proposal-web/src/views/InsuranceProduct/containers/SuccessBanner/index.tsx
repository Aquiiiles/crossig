import React, { useEffect, useState } from "react";
import ClayAlert from "@clayui/alert";
import { contactTypes } from "../../../../constants/contactConstants";
import { useContactDispatch } from "../../../../redux/store";
import { actions as addressInfoActions } from "../../../../redux/addressSlice";
import { actions as contactInfoActions } from "../../../../redux/contactInfoSlice";
import { actions as basicInfoActions } from "../../../../redux/basicInfoSlice";

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
        mainMessage = `Contact ${contact.firstName} ${contact.lastName} has been created successfully.`;
        break;
      case contactTypes.Legal_Entity:
      case contactTypes.Self_Employed:
        mainMessage = `Contact ${contact.companyName} has been created successfully.`;
        break;
      default:
        console.error(`Unknown contact type! ${contact.type}`);
    }

    if (contact.mainEmail || contact.mainMobile) {
      optionalMessage = `Verification link has been sent to`;

      if (contact.mainEmail && contact.mainMobile) {
        optionalMessage = `${optionalMessage} ${contact.mainEmail} and ${contact.mainMobile}.`;
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
