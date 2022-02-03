import React from "react";
import { Wrapper } from "./style";
import BasicInfo from "./components/molecules/BasicInfo";
import { Provider as ContactInfoProvider } from "react-redux";
import store from "./contactStore";

const ContactInfo: React.FC = () => {
  return (
    <ContactInfoProvider store={store}>
      <Wrapper id="ContactInfo-main-container">
        <BasicInfo />
      </Wrapper>
    </ContactInfoProvider>
  );
};

export default ContactInfo;
