import { useEffect, useState } from "react";
import Table from "./components/organisms/Table";
import { SearchResultsHeader, Wrapper } from "./styles";
import ClayForm, { ClaySelect, ClaySelectWithOption } from "@clayui/form";
import ClayDropDown from "@clayui/drop-down";
import { contactTypeOptions } from "../../../../constants/contactConstants";
import { CONTACT_SEARCH_RESULT_CONTACTS_FOUND } from "../../../../constants/languageKeys";

import * as constants from "./constants/searchResult";

import { providedDataType, responseType } from "./types/searchResult";

interface props {
  data: Array<any>;
  loading: boolean;
  onCitySelection: (city: string) => void;
  onTypeSelection: (type: string) => void;
}

const SearchResult: React.FC<props> = ({
  data,
  loading,
  onCitySelection,
  onTypeSelection,
}: props) => {
  const [showCountryDropdown, setShowCountryDropdown] = useState(false);
  const [citySearch, setCitySearch] = useState("");
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

  useEffect(() => {
    if (showCountryDropdown) {
      document.getElementById("searchContactInput")?.focus();
    } else {
      document.getElementById("cityFilterField")?.blur();
      setCitySearch("");
    }
  }, [showCountryDropdown]);

  return (
    <Wrapper>
      <SearchResultsHeader>
        <h6 className="h9">
          {data.length} {CONTACT_SEARCH_RESULT_CONTACTS_FOUND}
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
                  <ClaySelect.Option label="City" value="" />
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
              {[
                { name: "ULICA OTONA IVEKOVIĆA 60" },
                { name: "TONŽINO 1" },
                { name: "ULICA MIROSLAVA KRLEŽE 11" },
              ]
                .filter(city =>
                  city.name.toLowerCase().includes(citySearch.toLowerCase())
                )
                .map(city => (
                  <ClayDropDown.Item
                    onClick={() => {
                      onCitySelection(city.name);
                      setShowCountryDropdown(false);
                    }}
                    key={city.name}
                  >
                    {city.name}
                  </ClayDropDown.Item>
                ))}
            </ClayDropDown.Group>
          </ClayDropDown>
          <ClaySelectWithOption
            id="TypeFilterField"
            options={[{ label: "Type", value: "" }, ...contactTypeOptions]}
            onChange={({ target: { value } }) => {
              onTypeSelection(value);
            }}
          />
        </ClayForm.Group>
      </SearchResultsHeader>
      <Table
        loading={loading}
        inputData={formatedData}
        onTableSort={({ sortType, sortingKey }) => {
          console.log(sortingKey);
        }}
      ></Table>
    </Wrapper>
  );
};

export default SearchResult;
