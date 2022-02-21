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
import { initialState } from "../../redux/searchFilterSlice";

const contactsLimit = 20;
const contactsTotalResultLimit = 100;

const ContactSearch: React.FC = () => {
  const [data, setData] = useState([]);
  const { state: searchResultData, fetchData: fetchSearchResultData } =
    useFetchData();
  const [
    currentPage,
    pages,
    { goToNextPage, goToPrevPage, goToPage },
    handleNewTotal,
    totalPages,
  ] = usePagination(contactsLimit);
  const filterState=  useContactSelector(state => state.searchFilter);
  const {
    OIB,
    firstName,
    lastName,
    areaCode,
    phoneNumber,
    email,
    street,
    city,
    countryCode,
    selectedContactType,
    selectedCity,
    sortOrder,
    sortedBy,
  } = filterState;
  const idle = searchResultData.status === IDLE;
  const loading = searchResultData.status === PENDING;

  useEffect(()=>{
    if(filterState !== initialState){
      fetchData();
    }
  },[]);

  const fetchData: FetchContactsFunction = () => {
    const payload = {
      finderKey: 1,
      identifierType: 1000000,
      identityNumber: /^\d+/.test(OIB) ? OIB : undefined,
      firstName: /^[A-Za-z\s]+/.test(firstName) ? firstName : undefined,
      name: /^[A-Za-z\s]+/.test(lastName) ? lastName : undefined,
      cityName:
        selectedCity !== "" ? selectedCity : city !== "" ? city : undefined,
      assetStreetName: street !== "" ? street : undefined,
      telephoneCountryCode: countryCode !== "" ? countryCode : undefined,
      telephonePrefix: areaCode !== "" ? areaCode : undefined,
      telphoneNumber: phoneNumber !== "" ? phoneNumber : undefined,
      email: email !== "" ? email : undefined,
      accountType:
        selectedContactType !== "" ? Number(selectedContactType) : undefined,
    };

    const urlParams = new URLSearchParams({
      startIndex: ((currentPage - 1) * contactsLimit).toString(),
      count: contactsLimit.toString(),
      sortBy: sortedBy,
      sortOrder,
    }).toString();

    fetchSearchResultData("POST", `${SEARCH_URL}?${urlParams}`, {}, payload);
  };

  const fetchNewData = () => {
    if (currentPage === 1 && !idle) {
      fetchData();
    } else {
      goToPage(1);
    }
  };

  useEffect(() => {
    const result = searchResultData.response.data[0]?.contactInListIVO;
    if (result != null) {
      setData(result);
      handleNewTotal(result.length);
    }
  }, [searchResultData, handleNewTotal]);

  useEffect(() => {
    if (!idle) {
      fetchData();
    }
  }, [currentPage]);

  useEffect(() => {
    fetchNewData();
  }, [selectedContactType, selectedCity]);

  useEffect(() => {
    fetchNewData();
  }, [sortOrder, sortedBy]);

  return (
    <Wrapper>
      <Stepper />

      <Content>
        <h5>{CONTACT_SEARCH_TITLE}</h5>
        <p className="body-small" style={{ marginBottom: "2.5rem" }}>
          {CONTACT_SEARCH_SUBTITLE}
        </p>
        <SearchField
          currentPage={currentPage}
          goToPage={goToPage}
          fetchData={fetchData}
        />
        {!idle ? (
          <>
            <SearchResult
              data={data}
              loading={loading}
              paginationData={{
                lowerRange: (currentPage - 1) * contactsLimit + 1,
                upperRange: Math.min(
                  (currentPage - 1) * contactsLimit + contactsLimit,
                  data.length
                ),
                currentPage,
                pages,
                goToNextPage,
                goToPrevPage,
                goToPage,
                handleNewTotal,
                totalPages,
              }}
              contactsTotalLimit={contactsTotalResultLimit}
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
