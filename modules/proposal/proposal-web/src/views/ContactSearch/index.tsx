/* eslint-disable @typescript-eslint/no-empty-function */
import React from "react";
import SearchField from "./containers/SearchField";
import { Content, Wrapper, LinkWrapper, EmptySpace } from "./styles";
import Stepper from "./containers/Stepper";
import {
  CONTACT_SEARCH_SUBTITLE,
  CONTACT_SEARCH_TITLE,
} from "../../constants/languageKeys";
import { useFetchData } from "../../api/hooks/useFetchData";
import SearchResult from "./containers/SearchResult";
import { PENDING, IDLE } from "../../api/reducers/constants";
import { Link } from "react-router-dom";
import { CONTACT_SEARCH_CREATE_NEW_CONTACT } from "../../constants/languageKeys";

const ContactSearch: React.FC = () => {
  let data = undefined;
  const { state: searchResultData, fetchData: fetchSearchResultData } =
    useFetchData();

  const loading = searchResultData.status === PENDING;
  try {
    data = searchResultData.response.data[0].contactInListIVO;
  } catch (error) {
    data = undefined;
  }

  return (
    <Wrapper>
      <Stepper />

      <Content>
        <h5>{CONTACT_SEARCH_TITLE}</h5>
        <p className="body-small" style={{ marginBottom: "2.5rem" }}>
          {CONTACT_SEARCH_SUBTITLE}
        </p>
        <SearchField fetchSearchResultData={fetchSearchResultData} />
        {data != null ? (
          <>
            <SearchResult
              data={data}
              loading={loading}
              onCitySelection={console.info}
              onTypeSelection={console.info}
            />
            <LinkWrapper>
              <Link to="new_contact">{CONTACT_SEARCH_CREATE_NEW_CONTACT}</Link>
            </LinkWrapper>
          </>
        ) : (
          <EmptySpace />
        )}
      </Content>
    </Wrapper>
  );
};

export default ContactSearch;
