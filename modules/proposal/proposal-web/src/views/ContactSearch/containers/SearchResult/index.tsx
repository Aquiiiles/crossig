import { useEffect, useState } from "react";
import Table from "./components/organisms/Table";
import Pagination from "./components/molecules/Pagination";
import { SearchResultsHeader, Wrapper } from "./styles";
import ClayForm, { ClaySelect, ClaySelectWithOption } from "@clayui/form";
import ClayDropDown from "@clayui/drop-down";
import ClayLoadingIndicator from "@clayui/loading-indicator";
import { contactTypeOptions } from "../../../../constants/contactConstants";
import {
  CONTACT_SEARCH_RESULT_CONTACTS_FOUND,
  CONTACT_SEARCH_RESULT_NO_CONTACTS_FOUND,
} from "../../../../constants/languageKeys";
import { PageIndex } from "../../hooks/usePagination";

import * as constants from "./constants/searchResult";

import { providedDataType, responseType } from "./types/searchResult";
import { FetchContactsFunction } from "../../types/fetchData";

interface props {
  data: Array<any>;
  loading: boolean;
  fetchData: FetchContactsFunction;
  paginationData: {
    lowerRange: number;
    currentPage: number;
    pages: Array<PageIndex>;
    goToNextPage: () => void;
    goToPrevPage: () => void;
    goToPage: (pageIndex: PageIndex) => void;
    handleNewTotal: (newTotal: number) => void;
  };
}

const SearchResult: React.FC<props> = ({
  data,
  loading,
  fetchData,
  paginationData,
}: props) => {
  const [showCountryDropdown, setShowCountryDropdown] = useState(false);
  const [citySearch, setCitySearch] = useState("");
  const [selectedCity, setSelectedCity] = useState("");
  const [selectedContactType, setSelectedContactType] = useState("");
  const formatedData = data.map((item: providedDataType) => {
    const responseObj: responseType = {
      [constants.OIB_KEY]: item[constants.OIB_KEY],
      [constants.SUB_KEY]: "",
      [constants.DOB_KEY]: item[constants.DOB_KEY],
      [constants.NAME_KEY]: item[constants.NAME_KEY],
      [constants.STREET_KEY]: "",
      [constants.CITY_KEY]: "",
      [constants.TYPE_KEY]: item[constants.TYPE_KEY].desc,
    };
    return responseObj;
  });
  const cities = new Set(
    data.map((item: providedDataType) => item["address"].split(",")[1].trim())
  );

  useEffect(() => {
    if (showCountryDropdown) {
      document.getElementById("searchContactInput")?.focus();
    } else {
      document.getElementById("cityFilterField")?.blur();
      setCitySearch("");
    }
  }, [showCountryDropdown]);

  const foundContacts = data.length > 0;

  return (
    <Wrapper>
      {!loading ? (
        <>
          <SearchResultsHeader>
            <h6 className="h9">
              {foundContacts
                ? `${data.length} ${CONTACT_SEARCH_RESULT_CONTACTS_FOUND}`
                : `${CONTACT_SEARCH_RESULT_NO_CONTACTS_FOUND}`}
            </h6>
            {foundContacts ? (
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
                          label={selectedCity !== "" ? selectedCity : "City"}
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
                    {Array.from(cities)
                      .filter(city =>
                        city.toLowerCase().includes(citySearch.toLowerCase())
                      )
                      .map(city => (
                        <ClayDropDown.Item
                          onClick={() => {
                            setSelectedCity(city);
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
                    { label: "Type", value: "" },
                    ...contactTypeOptions,
                  ]}
                  onChange={({ target: { value } }) => {
                    setSelectedContactType(value);
                  }}
                />
              </ClayForm.Group>
            ) : null}
          </SearchResultsHeader>
          {foundContacts ? (
            <>
              <Table
                loading={loading}
                inputData={formatedData}
                onTableSort={({ sortType, sortingKey }) => {
                  console.log(sortingKey);
                }}
              ></Table>
              <Pagination
                paginationData={{
                  upperRange: data.length,
                  total: data.length,
                  ...paginationData,
                }}
              />
            </>
          ) : null}
        </>
      ) : (
        <ClayLoadingIndicator />
      )}
    </Wrapper>
  );
};

export default SearchResult;
