import React, { useEffect, useState } from "react";
import { contactTypes } from "../../../../constants/contactConstants";
import { useDispatch } from "../../../../redux/store";
import { actions } from "../../../../redux";
import { INSURANCE_PRODUCT } from "../../../../constants/languageKeys";
import { Banner } from "./style";
import Modal from "../../../../shared/atoms/contact/Modal";

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
  const dispatch = useDispatch();
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
        const phone = `+${contact.mainMobile.countryCode} ${contact.mainMobile.areaCode} ${contact.mainMobile.number}`;
        optionalMessage = `${optionalMessage} ${contact.mainEmail} ${INSURANCE_PRODUCT.BANNER.AND} ${phone}.`;
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
      [actions.addresses, actions.contactInfo, actions.basicInfo].forEach(
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
    return (
      <Modal
        visible={showBanner}
        onClose={() => setShowBanner(false)}
        title={`${INSURANCE_PRODUCT.BANNER.CONTACT} ${INSURANCE_PRODUCT.BANNER.CREATION}`}
        body={message()}
        timeOut={5000}
      />
    );
  } else {
    return null;
  }
};

export default SuccessBanner;
