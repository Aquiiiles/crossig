/* eslint-disable @typescript-eslint/no-empty-function */
import React, { useEffect } from "react";
import SearchField from "./containers/SearchField";
import { Content, Wrapper } from "./styles";
import Stepper from "./containers/Stepper";
import {
  CONTACT_SEARCH_SUBTITLE,
  CONTACT_SEARCH_TITLE,
} from "../../constants/languageKeys";
import { useFetchData } from "../../api/hooks/useFetchData";
import { SEARCH_URL } from "../../api/constants/routes";
import SearchResult from "./containers/SearchResult";
import { PENDING } from "../../api/reducers/constants";
import { Link } from "react-router-dom";
import { CONTACT_SEARCH_CREATE_NEW_CONTACT } from "../../constants/languageKeys";

const ContactSearch: React.FC = () => {
  const { state: searchResultData, fetchData: fetchSearchResultData } =
    useFetchData();

  useEffect(() => {
    fetchSearchResultData(SEARCH_URL, {})
      .then()
      .catch(_e => {});
  }, [fetchSearchResultData]);

  const loading = searchResultData.status === PENDING;
  const data = searchResultData.response.data.contactInListIVO;

  return (
    <Wrapper>
      <Stepper />

      <Content>
        <h5>{CONTACT_SEARCH_TITLE}</h5>
        <p className="body-small" style={{ marginBottom: "1.875rem" }}>
          {CONTACT_SEARCH_SUBTITLE}
        </p>
        <SearchField fetchSearchResultData={fetchSearchResultData} />
        <SearchResult data={data} loading={loading} />
        <LinkWrapper>
          <Link to="new_contact">{CONTACT_SEARCH_CREATE_NEW_CONTACT}</Link>
        </LinkWrapper>
      </Content>
    </Wrapper>
  );
};

export default ContactSearch;
