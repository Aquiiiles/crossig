import React from "react";
import { Content, Wrapper } from "./styles";
import ContactInfo from "./containers/ContactInfo";

const NewContact: React.FC = () => {
  return (
    <Wrapper>
      <Content id="NewContact-main-container">
        <ContactInfo />
      </Content>
    </Wrapper>
  );
};

export default NewContact;
