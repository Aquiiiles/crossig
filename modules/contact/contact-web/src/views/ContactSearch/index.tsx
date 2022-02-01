import React, { useEffect } from "react";
import SearchField from "./containers/SearchField";
import { Content, Wrapper } from "./styles";
import Stepper from "./containers/Stepper";
import {CONTACT_SEARCH_SUBTITLE, CONTACT_SEARCH_TITLE} from "../../constants/languageKeys";

const ContactSearch: React.FC = () => {
  return (
    <Wrapper>
      <Stepper />

      <Content>
        <h1>{CONTACT_SEARCH_TITLE}</h1>
        <p style={{marginBottom:'1.875rem'}}>
            {CONTACT_SEARCH_SUBTITLE}
        </p>
        <SearchField />
      </Content>
    </Wrapper>
  );
};

export default ContactSearch;
