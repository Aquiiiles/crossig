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
        <FilterButton displayType="unstyled">
          <FilterIcon />
        </FilterButton>
      </Header>
    </Wrapper>
  );
};

export default ResultsHeaderMobile;
