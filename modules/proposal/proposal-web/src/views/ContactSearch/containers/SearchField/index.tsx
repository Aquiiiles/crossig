/* eslint-disable @typescript-eslint/no-empty-function */
import React, { useEffect, useState, useRef, useCallback } from "react";
import ClayForm, { ClayInput } from "@clayui/form";
import ClayButton from "@clayui/button";
import ClayDropDown from "@clayui/drop-down";
import SearchFilters from "./components/molecules/SearchFilters";
import ArrowButton from "./components/atoms/ArrowButton";
import { mapToCountryCodes } from "../../../../shared/util/countryMappers";

import { Wrapper, SearchWrapper } from "./styles";
import {
  CONTACT_SEARCH_FIELD_NAME_OR_OIB,
  CONTACT_SEARCH_ACTION_BUTTON,
} from "../../../../constants/languageKeys";
import {
  useContactSelector,
  useContactDispatch,
} from "../../../../redux/store";
import { actions } from "../../../../redux/searchFilterSlice";
import { FetchContactsFunction } from "../../types/fetchData";

interface props {
  fetchData: FetchContactsFunction;
}

declare const Liferay: any;

const SearchField: React.FC<props> = ({ fetchData }: props) => {
  const dispatch = useContactDispatch();
  const [disabled, setDisabled] = useState(false);
  const [expand, setExpand] = useState(false);
  const [fieldWidth, setFieldWidth] = useState(0);
  const triggerElementRef = useRef<HTMLInputElement>(null);
  const menuElementRef = useRef<HTMLDivElement>(null);
  const [countries, setCountries] = useState<Array<any>>([]);
  const { firstName, phoneNumber, areaCode, email } = useContactSelector(
    state => state.searchFilter
  );
  const { setFirstName } = actions;

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

  const handleExpand = () => {
    setExpand(!expand);
  };

  useEffect(() => {
    const emailRegex = /\S+@\S+\.\S+/;
    if (
      firstName.length >= 3 ||
      (phoneNumber.length > 0 && areaCode !== "") ||
      emailRegex.test(email)
    ) {
      setDisabled(false);
    } else {
      setDisabled(true);
    }
  }, [firstName, phoneNumber, email, areaCode]);
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
            value={firstName}
            onChange={({ target: { value } }) => dispatch(setFirstName(value))}
          />
          <ArrowButton onClick={handleExpand} />
        </ClayForm.Group>
        <ClayButton
          displayType="primary"
          disabled={disabled}
          onClick={() => fetchData()}
        >
          {CONTACT_SEARCH_ACTION_BUTTON}
        </ClayButton>
      </SearchWrapper>
      <ClayDropDown.Menu
        ref={menuElementRef}
        style={fieldSize}
        active={expand}
        alignElementRef={triggerElementRef}
        closeOnClickOutside
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
