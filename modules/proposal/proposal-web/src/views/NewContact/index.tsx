import React from "react";
import { Content, Wrapper } from "./styles";
import { CREATE_NEW_CONTACT } from "../../constants/languageKeys";
import ContactInfo from "./containers/ContactInfo";

const NewContact: React.FC = () => {
  return (
    <Wrapper>
      <Content id="NewContact-main-container">
        <h3>{CREATE_NEW_CONTACT.TITLE}</h3>
        <p style={{ marginBottom: "1.875rem" }}>
          {CREATE_NEW_CONTACT.SUBTITLE}
        </p>
        <ContactInfo />
      </Content>
    </Wrapper>
  );
};

export default NewContact;
