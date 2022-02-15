/* eslint-disable @typescript-eslint/no-empty-function */
import React, { useEffect, useState, useRef, useCallback } from "react";
import {Link} from "react-router-dom";
import ClayForm, { ClayInput } from "@clayui/form";
import ClayDropDown from "@clayui/drop-down";
import SearchFilters from "./components/molecules/SearchFilters";
import ArrowButton from "./components/atoms/ArrowButton";
import SearchButton from "./components/atoms/SearchButton";
import { Wrapper } from "./styles";
import {
  CONTACT_SEARCH_FIELD_NAME_OR_OIB,
  CONTACT_SEARCH_CREATE_NEW_CONTACT,
} from "../../../../constants/languageKeys";
import { mapToCountryCodes } from "../../../../shared/util/countryMappers";

declare const Liferay: any;

const SearchField: React.FC = () => {
  const [name, setName] = useState("");
  const [disabled, setDisabled] = useState(false);
  const triggerElementRef = useRef<HTMLInputElement>(null);
  const [expand, setExpand] = useState(false);
  const [fieldWidth, setFieldWidth] = useState(0);
  const menuElementRef = useRef<HTMLDivElement>(null);
  const [countries, setCountries] = useState<Array<any>>([]);

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
    if (name.length > 0) {
      setDisabled(false);
    } else {
      setDisabled(true);
    }
  }, [name]);
  const fieldSize = { width: fieldWidth, maxWidth: fieldWidth };

  useEffect(() => {
    if (triggerElementRef.current) {
      setFieldWidth(triggerElementRef.current.offsetWidth);
    }
  }, [triggerElementRef]);

  return (
    <Wrapper>
      <ClayForm.Group>
        <label htmlFor="basicInputText">
          {CONTACT_SEARCH_FIELD_NAME_OR_OIB}
        </label>
        <ClayInput
          id="basicInputText"
          type="text"
          ref={triggerElementRef}
          value={name}
          onChange={e => setName(e.target.value)}
        />
        <SearchButton disabled={disabled} onClick={() => {}} />
        <ArrowButton onClick={handleExpand} />
      </ClayForm.Group>
      <ClayDropDown.Menu
        ref={menuElementRef}
        style={fieldSize}
        active={expand}
        alignElementRef={triggerElementRef}
        onSetActive={() => {}}
      >
        <SearchFilters countries={mapToCountryCodes(countries)} />
      </ClayDropDown.Menu>
      <div></div>
      <Link to="new_contact">{CONTACT_SEARCH_CREATE_NEW_CONTACT}</Link>
    </Wrapper>
  );
};

export default SearchField;
