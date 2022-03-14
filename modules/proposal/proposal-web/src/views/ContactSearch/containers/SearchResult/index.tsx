import React from "react";
import Table from "./components/organisms/Table";
import Pagination from "./components/molecules/Pagination";
import { SearchResultsHeader, Wrapper } from "./styles";
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
import useSearchResultState from "../../hooks/useSearchResultState";
import ResultsHeaderMobile from "./components/molecules/ResultsHeaderMobile";
import ResultsMobile from "./components/organisms/ResultsMobile";

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
  embedded: boolean;
}

const SearchResult: React.FC<props> = ({
  data,
  loading,
  paginationData,
  contactsTotalLimit,
  embedded,
}: props) => {
  const [
    {
      filteredData,
      foundContacts,
      citySearch,
      selectedCity,
      selectedContactType,
      cities,
      showCountryDropdown,
    },
    {
      setShowCountryDropdown,
      setCitySearch,
      setSelectedCity,
      setSelectedContactType,
    },
    dispatch,
  ] = useSearchResultState(data);

  return (
    <>
      {!loading && filteredData.length <= contactsTotalLimit ? (
        <ResultsHeaderMobile data={data} />
      ) : null}
      <Wrapper>
        {!loading && filteredData.length <= contactsTotalLimit ? (
          <>
            <SearchResultsHeader className="desktop-only">
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
                        id="cityFiltablerField"
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
                <ResultsMobile data={filteredData} embedded={embedded} />
                <Table
                  loading={loading}
                  inputData={filteredData}
                  embedded={embedded}
                />
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
          <h6 className="h9">
            {CONTACT_SEARCH_RESULT_TOO_MANY_SEARCH_RESULTS}
          </h6>
        ) : (
          <ClayLoadingIndicator />
        )}
      </Wrapper>
    </>
  );
};

export default SearchResult;
