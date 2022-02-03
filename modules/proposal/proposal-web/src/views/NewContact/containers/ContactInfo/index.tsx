import React from "react";
import { Wrapper } from "./style";
import BasicInfo from "./components/molecules/BasicInfo";

const ContactInfo: React.FC = () => {
  return (
    <Wrapper id="ContactInfo-main-container">
      <BasicInfo />
    </Wrapper>
  );
};

export default ContactInfo;
