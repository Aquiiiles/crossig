import React from "react";
import { Wrapper } from "./style";
import SectionTitle from "./components/atoms/SectionTitle";
import { CREATE_NEW_CONTACT_BASIC_INFO_TITLE } from "../../../../constants/languageKeys";

const ContactInfo: React.FC = () => {
  return (
    <Wrapper>
      <SectionTitle title={CREATE_NEW_CONTACT_BASIC_INFO_TITLE} />
    </Wrapper>
  );
};

export default ContactInfo;
