import React, { useEffect } from "react";
import SearchField from "./containers/SearchField";
import { Content, Wrapper } from "./styles";
import Stepper from "./containers/Stepper";

const ContactSearch: React.FC = () => {
  return (
    <Wrapper>
      <Stepper />

      <Content>
        <h1>Contact Lookup</h1>
        <p style={{marginBottom:'1.875rem'}}>
          Ut enim ad minim veniam quis nostrud exercitation laboris nisi ut
          aliquip ex ea commodo consequat
        </p>
        <SearchField />
      </Content>
    </Wrapper>
  );
};

export default ContactSearch;
