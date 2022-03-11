import React from "react";
import {
  CONTACT_RESULTS_TABLE,
  CONTACT_SEARCH_RESULT_CONTACTS_FOUND,
  CONTACT_SEARCH_RESULT_NO_CONTACTS_FOUND,
} from "../../../../../../../constants/languageKeys";
import { Wrapper, FieldWrapper, Header } from "./styles";
import ClayDropDown from "@clayui/drop-down";
import { ClaySelect, ClaySelectWithOption } from "@clayui/form";
import { filterTypeOptions } from "../../../../../../../constants/contactConstants";
import useSearchResultState from "../../../../../hooks/useSearchResultState";
import * as constants from "../../../../../constants/searchResult";
import useSort from "../../../../../../../shared/hooks/useSort";
import spritemap from "@clayui/css/lib/images/icons/icons.svg";
import ClayIcon from "@clayui/icon";
import SortButton from "../../../../../../../shared/atoms/SortButton";

interface Props {
  data: any[];
}

const ResultsHeaderMobile: React.FC<Props> = ({ data }) => {
  const [
    {
      filteredData,
      foundContacts,
      citySearch,
      selectedCity,
      selectedContactType,
      cities,
      showCountryDropdown,
      showSortDropdown,
    },
    {
      setShowCountryDropdown,
      setCitySearch,
      setSelectedCity,
      setSelectedContactType,
      setShowSortDropdown,
    },
    dispatch,
  ] = useSearchResultState(data);
  const [{ sortedBy, sortOrder }, { handleSort }] = useSort("searchFilter");

  const arrowIcon = (
    <ClayIcon
      spritemap={spritemap}
      symbol={sortOrder === "asc" ? "order-arrow-up" : "order-arrow-down"}
    />
  );

  return (
    <Wrapper>
      <h6 className="h9">
        {foundContacts
          ? `${filteredData.length} ${CONTACT_SEARCH_RESULT_CONTACTS_FOUND}`
          : `${CONTACT_SEARCH_RESULT_NO_CONTACTS_FOUND}`}
      </h6>
      <Header>
        <FieldWrapper>
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
        </FieldWrapper>
        <ClayDropDown
          trigger={<SortButton />}
          active={showSortDropdown}
          onActiveChange={setShowSortDropdown}
        >
          <ClayDropDown.Group>
            <ClayDropDown.Item onClick={() => handleSort(constants.OIB_KEY)}>
              {constants.OIB_NAME}
              {sortedBy === constants.OIB_KEY ? arrowIcon : null}
            </ClayDropDown.Item>
            <ClayDropDown.Item onClick={() => handleSort(constants.SUB_KEY)}>
              {constants.SUB_NAME}
              {sortedBy === constants.SUB_KEY ? arrowIcon : null}
            </ClayDropDown.Item>
            <ClayDropDown.Item onClick={() => handleSort(constants.DOB_KEY)}>
              {constants.DOB_NAME}
              {sortedBy === constants.DOB_KEY ? arrowIcon : null}
            </ClayDropDown.Item>
            <ClayDropDown.Item onClick={() => handleSort(constants.NAME_KEY)}>
              {constants.NAME_NAME}
              {sortedBy === constants.NAME_KEY ? arrowIcon : null}
            </ClayDropDown.Item>
            <ClayDropDown.Item onClick={() => handleSort(constants.STREET_KEY)}>
              {constants.STREET_NAME}
              {sortedBy === constants.STREET_KEY ? arrowIcon : null}
            </ClayDropDown.Item>
            <ClayDropDown.Item onClick={() => handleSort(constants.CITY_KEY)}>
              {constants.CITY_NAME}
              {sortedBy === constants.CITY_KEY ? arrowIcon : null}
            </ClayDropDown.Item>
            <ClayDropDown.Item onClick={() => handleSort(constants.TYPE_KEY)}>
              {constants.TYPE_NAME}
              {sortedBy === constants.TYPE_KEY ? arrowIcon : null}
            </ClayDropDown.Item>
          </ClayDropDown.Group>
        </ClayDropDown>
      </Header>
    </Wrapper>
  );
};

export default ResultsHeaderMobile;
