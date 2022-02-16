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
  CONTACT_SEARCH_FIELD_OIB,
  CONTACT_SEARCH_FIELD_LAST_NAME_COMPANY_NAME_SE_NAME,
  CONTACT_SEARCH_FIELD_FIRST_NAME,
  CONTACT_SEARCH_MORE_SEARCH_OPTIONS
} from "../../../../constants/languageKeys";
import {
  useContactSelector,
  useContactDispatch,
} from "../../../../redux/store";
import { actions } from "../../../../redux/searchFilterSlice";
import { PageIndex } from "../../hooks/usePagination";
import { Console } from "console";

interface props {
  currentPage: number;
  goToPage: (pageIndex: PageIndex) => void;
  fetchData: () => void;
}

declare const Liferay: any;

const SearchField: React.FC<props> = ({
  currentPage,
  goToPage,
  fetchData,
}: props) => {
  const dispatch = useContactDispatch();
  const [disabled, setDisabled] = useState(false);
  const [expand, setExpand] = useState(false);
  const [fieldWidth, setFieldWidth] = useState(0);
  const triggerElementRef = useRef<HTMLButtonElement>(null);
  const menuElementRef = useRef<HTMLDivElement>(null);
  const arrowButtonRef = useRef<HTMLButtonElement>(null);
  const [countries, setCountries] = useState<Array<any>>([]);
  const { firstName, OIB, lastName, phoneNumber, areaCode, email } = useContactSelector(
    state => state.searchFilter
  );
  const { setFirstName, setOIB, setLastName } = actions;

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
      (OIB.length >= 3 || lastName.length >= 3 || firstName.length >= 3) ||
      (phoneNumber.length > 0 && areaCode !== "") ||
      emailRegex.test(email)
    ) {
      setDisabled(false);
    } else {
      setDisabled(true);
    }
  }, [firstName, OIB, lastName, phoneNumber, email, areaCode]);
  const fieldSize = { width: fieldWidth, maxWidth: fieldWidth };
  const fieldWidthMultiplier = 3;

  useEffect(() => {
    if (triggerElementRef.current) {
      setFieldWidth(triggerElementRef.current.offsetWidth * fieldWidthMultiplier);
    }
  }, [triggerElementRef]);

  return (
    <Wrapper>
      <ClayForm.Group>
        <ClayInput.Group>
          <ClayInput.GroupItem>
            <label htmlFor="oibInputText">{CONTACT_SEARCH_FIELD_OIB}</label>
            <ClayInput
              id="oibInputText"
              type="text"
              value={oib}
              onChange={(e) => setOib(e.target.value)}
            />
          </ClayInput.GroupItem>
          <ClayInput.GroupItem>
            <label htmlFor="lastCompanySeNameInputText">{CONTACT_SEARCH_FIELD_LAST_NAME_COMPANY_NAME_SE_NAME}</label>
            <ClayInput
              id="lastCompanySeNameInputText"
              type="text"
              value={lastCompanySeName}
              onChange={(e) => setLastCompanySeName(e.target.value)}
            />
          </ClayInput.GroupItem>
          <ClayInput.GroupItem>
            <label htmlFor="firstNameInputText">{CONTACT_SEARCH_FIELD_FIRST_NAME}</label>
            <ClayInput
              id="firstNameInputText"
              type="text"
              value={firstName}
              onChange={(e) => setFirstName(e.target.value)}
            />
          </ClayInput.GroupItem>
        </ClayInput.Group>
      </ClayForm.Group>
      <ClayForm.Group>
        <ClayButton.Group>
          <ClayButton displayType="primary" disabled={disabled} onClick={() => { }}>{CONTACT_SEARCH_BUTTON_SEARCH}</ClayButton>
          <ClayButton displayType="link" ref={triggerElementRef} onClick={handleExpand}>{CONTACT_SEARCH_MORE_SEARCH_OPTIONS}</ClayButton>
        </ClayButton.Group>
      </ClayForm.Group>
      <ClayDropDown.Menu
        ref={menuElementRef}
        style={fieldSize}
        active={expand}
        alignElementRef={triggerElementRef}
        closeOnClickOutside
        onSetActive={() => { }}
      >
        <SearchFilters
          fetchData={() => {
            if (currentPage === 1) {
              fetchData();
            } else {
              goToPage(1);
            }
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
