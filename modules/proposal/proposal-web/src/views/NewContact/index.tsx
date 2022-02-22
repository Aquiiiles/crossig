import React from "react";
import { Content, Wrapper } from "./styles";
import ContactInfo from "./containers/ContactInfo";
import { resetState } from "../../redux/store";

const NewContact: React.FC = () => {
  resetState();
  return (
    <Wrapper>
      <Content id="NewContact-main-container">
        <ContactInfo />
      </Content>
    </Wrapper>
  );
};

export default NewContact;
