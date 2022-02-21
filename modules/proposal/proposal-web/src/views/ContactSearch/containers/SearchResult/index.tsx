import React, { useEffect, useState } from "react";
import Table from "./components/organisms/Table";
import Pagination from "./components/molecules/Pagination";
import { SearchResultsHeader, Wrapper, Error } from "./styles";
import ClayForm, { ClaySelect, ClaySelectWithOption } from "@clayui/form";
import ClayDropDown from "@clayui/drop-down";
import ClayLoadingIndicator from "@clayui/loading-indicator";
import { filterTypeOptions } from "../../../../constants/contactConstants";
import {
  CONTACT_SEARCH_RESULT_CONTACTS_FOUND,
  CONTACT_SEARCH_RESULT_NO_CONTACTS_FOUND,
  CONTACT_SEARCH_RESULT_TOO_MANY_SEARCH_RESULTS,
  CONTACT_RESULTS_TABLE,
} from "../../../../constants/languageKeys";
import { PageIndex } from "../../hooks/usePagination";
import {
  useContactSelector,
  useContactDispatch,
} from "../../../../redux/store";
import { actions } from "../../../../redux/searchFilterSlice";

import * as constants from "./constants/searchResult";

import { providedDataType, responseType } from "./types/searchResult";
import { FetchContactsFunction } from "../../types/fetchData";

interface props {
  data: Array<any>;
  loading: boolean;
  paginationData: {
    lowerRange: number;
    upperRange: number;
    currentPage: number;
    pages: Array<PageIndex>;
    goToNextPage: () => void;
    goToPrevPage: () => void;
    goToPage: (pageIndex: PageIndex) => void;
    handleNewTotal: (newTotal: number) => void;
    totalPages: () => number;
  };
  contactsTotalLimit: number;
}

const SearchResult: React.FC<props> = ({
  data,
  loading,
  paginationData,
  contactsTotalLimit,
}: props) => {
  const dispatch = useContactDispatch();
  const [showCountryDropdown, setShowCountryDropdown] = useState(false);
  const [citySearch, setCitySearch] = useState("");
  const formatedData = data.map((item: providedDataType) => {
    const responseObj: responseType = {
      [constants.OIB_KEY]: item[constants.OIB_KEY],
      [constants.SUB_KEY]: "",
      [constants.DOB_KEY]: item[constants.DOB_KEY],
      [constants.NAME_KEY]: item[constants.NAME_KEY],
      [constants.STREET_KEY]: item[constants.STREET_KEY],
      [constants.CITY_KEY]: item[constants.CITY_KEY],
      [constants.TYPE_KEY]: item[constants.TYPE_KEY].desc,
      [constants.MAIL_VALIDATED_KEY]: item[constants.MAIL_VALIDATED_KEY],
      [constants.PHONE_NUMBER_VALIDATED_KEY]:
        item[constants.PHONE_NUMBER_VALIDATED_KEY],
    };
    return responseObj;
  });
  const [filteredData, setFilteredData] = useState(formatedData);
  const cities = new Set(
    data.map((item: providedDataType) => item["address"].split(",")[1].trim())
  );
  const { selectedContactType, selectedCity } = useContactSelector(
    (state) => state.searchFilter
  );
  const { setSelectedContactType, setSelectedCity } = actions;

  useEffect(() => {
    if (showCountryDropdown) {
      document.getElementById("searchContactInput")?.focus();
    } else {
      document.getElementById("cityFilterField")?.blur();
      setCitySearch("");
    }
  }, [showCountryDropdown]);

  useEffect(() => {
    setFilteredData(
      selectedContactType
        ? formatedData.filter(
            (item) => item[constants.TYPE_KEY] === selectedContactType
          )
        : formatedData
    );
  }, [selectedContactType, data]);

  const foundContacts = filteredData.length > 0;

  return (
    <Wrapper>
      {!loading && filteredData.length <= contactsTotalLimit ? (
        <>
          <SearchResultsHeader>
            <h6 className="h9">
              {foundContacts
                ? `${filteredData.length} ${CONTACT_SEARCH_RESULT_CONTACTS_FOUND}`
                : `${CONTACT_SEARCH_RESULT_NO_CONTACTS_FOUND}`}
            </h6>
            <ClayForm.Group>
              <ClayDropDown
                active={showCountryDropdown}
                onActiveChange={setShowCountryDropdown}
                trigger={
                  <div style={{ cursor: "pointer" }}>
                    <ClaySelect
                      style={{ pointerEvents: "none" }}
                      id="cityFilterField"
                      value=""
                    >
                      <ClaySelect.Option
                        label={
                          selectedCity !== ""
                            ? selectedCity
                            : CONTACT_RESULTS_TABLE.HEADER.CITY
                        }
                        value=""
                      />
                    </ClaySelect>
                  </div>
                }
              >
                <ClayDropDown.Search
                  value={citySearch}
                  onChange={({ target: { value } }) => setCitySearch(value)}
                  placeholder="Search"
                  id="searchContactInput"
                />
                <ClayDropDown.Group>
                  <ClayDropDown.Item
                    onClick={() => {
                      dispatch(setSelectedCity(""));
                      setShowCountryDropdown(false);
                    }}
                  >
                    {CONTACT_RESULTS_TABLE.HEADER.CITY}
                  </ClayDropDown.Item>
                  {Array.from(cities)
                    .filter((city) =>
                      city.toLowerCase().includes(citySearch.toLowerCase())
                    )
                    .map((city) => (
                      <ClayDropDown.Item
                        onClick={() => {
                          dispatch(setSelectedCity(city));
                          setShowCountryDropdown(false);
                        }}
                        key={city}
                      >
                        {city}
                      </ClayDropDown.Item>
                    ))}
                </ClayDropDown.Group>
              </ClayDropDown>
              <ClaySelectWithOption
                id="TypeFilterField"
                value={selectedContactType}
                options={[
                  { label: CONTACT_RESULTS_TABLE.HEADER.TYPE, value: "" },
                  ...filterTypeOptions,
                ]}
                onChange={({ target: { value } }) => {
                  dispatch(setSelectedContactType(value));
                }}
              />
            </ClayForm.Group>
          </SearchResultsHeader>
          {foundContacts ? (
            <>
              <Table loading={loading} inputData={filteredData}></Table>
              <Pagination
                paginationData={{
                  total: filteredData.length,
                  ...paginationData,
                }}
              />
            </>
          ) : null}
        </>
      ) : filteredData.length > contactsTotalLimit ? (
        <h6 className="h9">{CONTACT_SEARCH_RESULT_TOO_MANY_SEARCH_RESULTS}</h6>
      ) : (
        <ClayLoadingIndicator />
      )}
    </Wrapper>
  );
};

export default SearchResult;
