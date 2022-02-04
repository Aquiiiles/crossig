import React, { useEffect } from "react";
import SearchField from "./containers/SearchField";
import { Content, Wrapper } from "./styles";
import Stepper from "./containers/Stepper";
import {CONTACT_SEARCH_SUBTITLE, CONTACT_SEARCH_TITLE} from "../../constants/languageKeys";
import {useFetchData} from "../../shared/hooks/useFetchData";
import { SEARCH_CONTACTS_URL } from "./constants/contacts";

const ContactSearch: React.FC = () => {

  const { state, fetchData } =
    useFetchData();

    useEffect(() => {
      fetchData(SEARCH_CONTACTS_URL, {})
        .then()
        .catch((_e) => {});
    }, [fetchData]);
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
