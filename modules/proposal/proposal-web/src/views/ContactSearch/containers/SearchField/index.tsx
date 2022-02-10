/* eslint-disable @typescript-eslint/no-empty-function */
import React, { useEffect, useState, useRef, useCallback } from "react";
import ClayForm, { ClayInput } from "@clayui/form";
import ClayDropDown from "@clayui/drop-down";
import SearchFilters from "./components/molecules/SearchFilters";
import ArrowButton from "./components/atoms/ArrowButton";
import { CONTACT_SEARCH_FIELD_NAME_OR_OIB } from "../../../../constants/languageKeys";
import { mapToCountryCodes } from "../../../../shared/util/countryMappers";

import { Wrapper, SearchWrapper } from "./styles";
import { SEARCH_URL } from "../../../../api/constants/routes";
import { useContactSelector } from "../../../../redux/store";
import { FetchDataFunction } from "../../../../api/hooks/useFetchData";

interface props {
  fetchSearchResultData: FetchDataFunction;
}

declare const Liferay: any;

const SearchField: React.FC<props> = ({ fetchSearchResultData }: props) => {
  const [disabled, setDisabled] = useState(false);
  const [expand, setExpand] = useState(false);
  const [fieldWidth, setFieldWidth] = useState(0);
  const [name, setName] = useState("");
  const triggerElementRef = useRef<HTMLInputElement>(null);
  const menuElementRef = useRef<HTMLDivElement>(null);
  const [countries, setCountries] = useState<Array<any>>([]);
  const { city, street, countryCode, areaCode, phoneNumber, email } =
    useContactSelector(state => state.searchFilter);

  const loadCountries = useCallback(() => {
    Liferay.Service(
      "/country/get-countries",
      {
        active: true,
      },
      (countriesArray: Array<any>) => {
        setCountries(countriesArray);
      }
    );
  }, []);

  useEffect(() => {
    loadCountries();
  }, [loadCountries]);

  const fetchData = () => {
    const searchString = new URLSearchParams({
      nameOrOIB: name,
      city: city,
      streetAdress: street,
      phoneCountryCode: countryCode,
      phoneAreaCode: areaCode,
      phoneNumber: phoneNumber,
      email: email,
    });

    fetchSearchResultData("GET", `${SEARCH_URL}?${searchString.toString()}`);
  };

  const handleExpand = () => {
    setExpand(!expand);
  };

  useEffect(() => {
    if (name.length >= 3 || phoneNumber.length > 0 || email.length > 0) {
      setDisabled(false);
    } else {
      setDisabled(true);
    }
  }, [name, phoneNumber, email]);
  const fieldSize = { width: fieldWidth, maxWidth: fieldWidth };

  useEffect(() => {
    if (triggerElementRef.current) {
      setFieldWidth(triggerElementRef.current.offsetWidth);
    }
  }, [triggerElementRef]);

  return (
    <Wrapper>
      <SearchWrapper>
        <ClayForm.Group style={{ marginBottom: "0" }}>
          <label className="body-small" htmlFor="basicInputText">
            {CONTACT_SEARCH_FIELD_NAME_OR_OIB}
          </label>
          <ClayInput
            id="basicInputText"
            type="text"
            ref={triggerElementRef}
            value={name}
            onChange={e => setName(e.target.value)}
          />
          <ArrowButton onClick={handleExpand} />
        </ClayForm.Group>
        <ClayButton
          displayType="primary"
          disabled={disabled}
          onClick={fetchData}
        >
          SEARCH
        </ClayButton>
      </SearchWrapper>
      <ClayDropDown.Menu
        ref={menuElementRef}
        style={fieldSize}
        active={expand}
        alignElementRef={triggerElementRef}
        onSetActive={() => {}}
      >
        <SearchFilters
          fetchData={() => {
            fetchData();
            handleExpand();
          }}
          countries={mapToCountryCodes(countries)}
          searchDisabled={disabled}
        />
      </ClayDropDown.Menu>
      <div></div>
    </Wrapper>
  );
};

export default SearchField;
