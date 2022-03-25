/* eslint-disable @typescript-eslint/no-empty-function */
import React, { useEffect, useState } from "react";
import SearchField from "./containers/SearchField";
import {
  InnerWrapper,
  Wrapper,
  LinkWrapper,
  Content,
  EmptySpace,
} from "./styles";
import Stepper from "../../shared/molecules/Stepper";
import GoBackHeader from "../../shared/molecules/GoBackHeader";
import languageKeys from "../../constants/Language";
import { useHttpRequest } from "../../api/hooks/useHttpRequest";
import SearchResult from "./containers/SearchResult";
import { PENDING, IDLE } from "../../api/reducers/constants";
import { Link, useLocation } from "react-router-dom";
import usePagination from "./hooks/usePagination";
import { SEARCH_URL } from "../../api/constants/routes";
import { useSelector } from "../../redux/store";
import { FetchContactsFunction } from "./types";
import { initialState } from "../../redux/searchFilter/searchFilterSlice";

interface stateType {
  doSearch: boolean;
}

type PropsType = {
  proposalState?: any;
  embedded: boolean;
};

const contactsLimit = 20;
const contactsTotalResultLimit = 100;
const { CONTACT_SEARCH } = languageKeys;

const ContactSearch: React.FC<PropsType> = ({ proposalState, embedded }) => {
  const [showResults, setShowResults] = useState(false);
  const [data, setData] = useState([]);
  const location = useLocation<stateType>();
  const [searchResultResponse, { fetchData: fetchSearchResultData }] =
    useHttpRequest();
  const [
    currentPage,
    pages,
    { goToNextPage, goToPrevPage, goToPage },
    handleNewTotal,
    totalPages,
  ] = usePagination(contactsLimit);
  const filterState = useSelector((state) => state.searchFilter);
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
  const idle = searchResultResponse.status === IDLE;
  const loading = searchResultResponse.status === PENDING;

  useEffect(() => {
    if (filterState !== initialState) {
      fetchData();
    }
  }, []);

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
      telephoneNumber: phoneNumber !== "" ? phoneNumber : undefined,
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
    const result = searchResultResponse.response.data[0]?.contactInListIVO;
    if (result != null) {
      setData(result);
      handleNewTotal(result.length);
    }
  }, [searchResultResponse, handleNewTotal]);

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

  useEffect(() => {
    if (location.state?.doSearch) {
      fetchData();
    }
  }, []);

  return (
    <Wrapper embedded={embedded}>
      {!embedded ? <Stepper currentStep={1} /> : <GoBackHeader />}

      <InnerWrapper embedded={embedded}>
        <Content embedded={embedded}>
          <div className="tablet-padding">
            <h5>{CONTACT_SEARCH.TITLE}</h5>
            {!embedded ? (
              <p className="body-small content-subtitle">
                {CONTACT_SEARCH.SUBTITLE}
              </p>
            ) : null}
            <SearchField
              currentPage={currentPage}
              goToPage={goToPage}
              fetchData={() => {
                fetchData();
                setShowResults(true);
              }}
            />
          </div>
          {!idle && (!embedded || showResults) ? (
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
                embedded={embedded}
              />
            </>
          ) : embedded ? (
            <EmptySpace />
          ) : null}
        </Content>
        {!idle && !embedded ? (
          <LinkWrapper>
            <Link to="new_contact">{CONTACT_SEARCH.CREATE_NEW_CONTACT}</Link>
          </LinkWrapper>
        ) : null}
      </InnerWrapper>
    </Wrapper>
  );
};

export default ContactSearch;
