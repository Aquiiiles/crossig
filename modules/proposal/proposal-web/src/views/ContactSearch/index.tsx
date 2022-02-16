/* eslint-disable @typescript-eslint/no-empty-function */
import React, { useEffect, useState } from "react";
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
import usePagination from "./hooks/usePagination";
import { SEARCH_URL } from "../../api/constants/routes";
import { useContactSelector } from "../../redux/store";
import { FetchContactsFunction } from "./types/fetchData";

const contactsLimit = 20;

const ContactSearch: React.FC = () => {
  const [data, setData] = useState([]);
  const { state: searchResultData, fetchData: fetchSearchResultData } =
    useFetchData();
  const [
    currentPage,
    pages,
    { goToNextPage, goToPrevPage, goToPage },
    handleNewTotal,
  ] = usePagination(contactsLimit);
  const { firstName, areaCode, phoneNumber, email, street, city, countryCode } =
    useContactSelector(state => state.searchFilter);
  const idle = searchResultData.status === IDLE;
  const loading = searchResultData.status === PENDING;

  const fetchData: FetchContactsFunction = ({ city, contactType }) => {
    const payload = {
      finderKey: 1,
      identifierType: 1000000,
      identityNumber: /^\d+/.test(firstName) ? firstName : undefined,
      name: /^[A-Za-z\s]+/.test(firstName) ? firstName : undefined,
      cityName: city != null && city !== "" ? city : undefined,
      assetStreetName: street !== "" ? street : undefined,
      telephoneCountryCode: countryCode !== "" ? countryCode : undefined,
      telephonePrefix: areaCode !== "" ? areaCode : undefined,
      telphoneNumber: phoneNumber !== "" ? phoneNumber : undefined,
      email: email !== "" ? email : undefined,
      accountType:
        contactType != null && contactType !== ""
          ? Number(contactType)
          : undefined,
    };

    const urlParams = new URLSearchParams({
      startIndex: ((currentPage - 1) * contactsLimit).toString(),
      count: contactsLimit.toString(),
    }).toString();

    fetchSearchResultData("POST", `${SEARCH_URL}?${urlParams}`, {}, payload);
  };

  useEffect(() => {
    let result = searchResultData.response.data[0]?.contactInListIVO;
    if (result != null) {
      setData(result);
      handleNewTotal(result.length);
    }
  }, [searchResultData, handleNewTotal]);

  return (
    <Wrapper>
      <Stepper />

      <Content>
        <h5>{CONTACT_SEARCH_TITLE}</h5>
        <p className="body-small" style={{ marginBottom: "2.5rem" }}>
          {CONTACT_SEARCH_SUBTITLE}
        </p>
        <SearchField fetchData={fetchData} />
        {!idle ? (
          <>
            <SearchResult
              data={data}
              loading={loading}
              fetchData={fetchData}
              paginationData={{
                lowerRange: (currentPage - 1) * contactsLimit + 1,
                currentPage,
                pages,
                goToNextPage,
                goToPrevPage,
                goToPage,
                handleNewTotal,
              }}
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
