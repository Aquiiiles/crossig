import React from "react";
import {
  CONTACT_RESULTS_TABLE,
  CONTACT_SEARCH_RESULT_CONTACTS_FOUND,
  CONTACT_SEARCH_RESULT_NO_CONTACTS_FOUND,
} from "../../../../../../../constants/languageKeys";
import { Wrapper, FieldWrapper, Header, FilterButton } from "./styles";
import ClayDropDown from "@clayui/drop-down";
import { ClaySelect, ClaySelectWithOption } from "@clayui/form";
import { filterTypeOptions } from "../../../../../../../constants/contactConstants";
import useSearchResultState from "../../../../../hooks/useSearchResultState";
import { ReactComponent as FilterIcon } from "../../../../../../../assets/filterIcon.svg";
import * as constants from "../../../../../constants/searchResult";
import useSort from "../../../../../hooks/useSort";
import spritemap from "@clayui/css/lib/images/icons/icons.svg";
import ClayIcon from "@clayui/icon";

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
  const [{ sortedBy, sortOrder }, { setSortedBy, setSortOrder, decideOrder }] =
    useSort();

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
          trigger={
            <FilterButton displayType="unstyled">
              <FilterIcon />
            </FilterButton>
          }
          active={showSortDropdown}
          onActiveChange={setShowSortDropdown}
        >
          <ClayDropDown.Group>
            <ClayDropDown.Item
              onClick={() => {
                dispatch(setSortedBy(constants.OIB_KEY));
                dispatch(setSortOrder(decideOrder(constants.OIB_KEY)));
              }}
            >
              {constants.OIB_NAME}
              {sortedBy === constants.OIB_KEY ? arrowIcon : null}
            </ClayDropDown.Item>
            <ClayDropDown.Item
              onClick={() => {
                dispatch(setSortedBy(constants.SUB_KEY));
                dispatch(setSortOrder(decideOrder(constants.SUB_KEY)));
              }}
            >
              {constants.SUB_NAME}
              {sortedBy === constants.SUB_KEY ? arrowIcon : null}
            </ClayDropDown.Item>
            <ClayDropDown.Item
              onClick={() => {
                dispatch(setSortedBy(constants.DOB_KEY));
                dispatch(setSortOrder(decideOrder(constants.DOB_KEY)));
              }}
            >
              {constants.DOB_NAME}
              {sortedBy === constants.DOB_KEY ? arrowIcon : null}
            </ClayDropDown.Item>
            <ClayDropDown.Item
              onClick={() => {
                dispatch(setSortedBy(constants.NAME_KEY));
                dispatch(setSortOrder(decideOrder(constants.NAME_KEY)));
              }}
            >
              {constants.NAME_NAME}
              {sortedBy === constants.NAME_KEY ? arrowIcon : null}
            </ClayDropDown.Item>
            <ClayDropDown.Item
              onClick={() => {
                dispatch(setSortedBy(constants.STREET_KEY));
                dispatch(setSortOrder(decideOrder(constants.STREET_KEY)));
              }}
            >
              {constants.STREET_NAME}
              {sortedBy === constants.STREET_KEY ? arrowIcon : null}
            </ClayDropDown.Item>
            <ClayDropDown.Item
              onClick={() => {
                dispatch(setSortedBy(constants.CITY_KEY));
                dispatch(setSortOrder(decideOrder(constants.CITY_KEY)));
              }}
            >
              {constants.CITY_NAME}
              {sortedBy === constants.CITY_KEY ? arrowIcon : null}
            </ClayDropDown.Item>
            <ClayDropDown.Item
              onClick={() => {
                dispatch(setSortedBy(constants.TYPE_KEY));
                dispatch(setSortOrder(decideOrder(constants.TYPE_KEY)));
              }}
            >
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
