import React from "react";
import Form from "./containers/Form";
import { Content, Wrapper } from "./styles";

const ContactInfo: React.FC = () => {
  return (
    <Wrapper>
      <Content>
        <Form />
      </Content>
    </Wrapper>
  );
};

export default ContactInfo;
