/* eslint-disable @typescript-eslint/no-empty-function */
import React, { useEffect, useState, useRef, useCallback } from "react";
import ClayForm, { ClayInput } from "@clayui/form";
import ClayButton from "@clayui/button";
import SearchFilters from "./components/molecules/SearchFilters";
import { mapToCountryCodes } from "../../../../shared/util/countryMappers";
import { Wrapper, SearchWrapper, StyledClayDropdownMenu } from "./styles";
import {
  CONTACT_SEARCH_ACTION_BUTTON,
  CONTACT_SEARCH_FIELD_OIB,
  CONTACT_SEARCH_FIELD_LAST_NAME_COMPANY_NAME_SE_NAME,
  CONTACT_SEARCH_FIELD_FIRST_NAME,
  CONTACT_SEARCH_MORE_SEARCH_OPTIONS,
  CONTACT_SEARCH_FIELD_LAST_NAME,
} from "../../../../constants/languageKeys";
import { useSelector, useDispatch } from "../../../../redux/store";
import { actions } from "../../../../redux";
import { PageIndex } from "../../hooks/usePagination";
import useOnClickOutside from "../../../../shared/hooks/useOnClickOutside";
import { useHttpRequest } from "../../../../api/hooks/useHttpRequest";
import { COUNTRIES_URL } from "../../../../api/constants/routes";
import { RESOLVED } from "../../../../api/reducers/constants";
import {
  handleEnterKeyEvent,
  lettersOnly,
  numbersOnly,
} from "../../../../shared/util/commonFunctions";

interface props {
  currentPage: number;
  goToPage: (pageIndex: PageIndex) => void;
  fetchData: () => void;
}

const SearchField: React.FC<props> = ({
  currentPage,
  goToPage,
  fetchData,
}: props) => {
  const [coutryResponse, , { get: fetchCountries }] = useHttpRequest();
  const dispatch = useDispatch();
  const [disabled, setDisabled] = useState(false);
  const [expand, setExpand] = useState(false);
  const [fieldWidth, setFieldWidth] = useState(0);
  const triggerElementRef = useRef<HTMLButtonElement>(null);
  const menuElementRef = useRef<HTMLDivElement>(null);
  const arrowButtonRef = useRef<HTMLButtonElement>(null);

  const { firstName, OIB, lastName, phoneNumber, areaCode, email } =
    useSelector((state) => state.searchFilter);

  const [countries, setCountries] = useState<Array<any> | null>(null);

  const { setFirstName, setOIB, setLastName } = actions.searchFilter;

  useOnClickOutside<HTMLDivElement>(
    menuElementRef,
    useCallback(() => setExpand(false), []),
    arrowButtonRef
  );

  useEffect(() => {
    fetchCountries(COUNTRIES_URL);
  }, []);

  useEffect(() => {
    if (coutryResponse.status === RESOLVED) {
      setCountries(coutryResponse.response.data);
    }
  }, [coutryResponse]);

  const handleExpand = () => {
    setExpand(!expand);
  };

  useEffect(() => {
    const emailRegex = /\S+@\S+\.\S+/;

    if (
      OIB.length >= 3 ||
      lastName.length >= 3 ||
      firstName.length >= 3 ||
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
      setFieldWidth(
        triggerElementRef.current.offsetWidth * fieldWidthMultiplier
      );
    }
  }, [triggerElementRef]);

  const submitSearch = () => {
    if (currentPage === 1) {
      fetchData();
    } else {
      goToPage(1);
    }
  };

  return (
    <Wrapper>
      <SearchWrapper>
        <ClayForm.Group
          style={{ marginBottom: "0" }}
          onKeyDown={(e) => handleEnterKeyEvent(e, submitSearch)}
        >
          <ClayInput.Group className="searchFieldInputs">
            <ClayInput.GroupItem>
              <label className="body-small" htmlFor="oibInputText">
                {CONTACT_SEARCH_FIELD_OIB}
              </label>
              <ClayInput
                id="oibInputText"
                data-testid="oibInputText"
                type="text"
                className="straight-numbers"
                value={OIB}
                onChange={({ target: { value } }) =>
                  dispatch(setOIB(numbersOnly(value)))
                }
              />
            </ClayInput.GroupItem>
            <ClayInput.GroupItem>
              <label
                className="body-small desktop-only"
                htmlFor="lastNameInputText"
              >
                {CONTACT_SEARCH_FIELD_LAST_NAME_COMPANY_NAME_SE_NAME}
              </label>
              <label
                className="body-small tablet-only"
                htmlFor="lastNameInputText"
              >
                {CONTACT_SEARCH_FIELD_LAST_NAME}
              </label>
              <ClayInput
                id="lastNameInputText"
                type="text"
                value={lastName}
                className="straight-numbers"
                onChange={({ target: { value } }) =>
                  dispatch(setLastName(value))
                }
              />
            </ClayInput.GroupItem>
            <ClayInput.GroupItem>
              <label className="body-small" htmlFor="firstNameInputText">
                {CONTACT_SEARCH_FIELD_FIRST_NAME}
              </label>
              <ClayInput
                id="firstNameInputText"
                type="text"
                value={firstName}
                onChange={({ target: { value } }) =>
                  dispatch(setFirstName(lettersOnly(value)))
                }
              />
            </ClayInput.GroupItem>
          </ClayInput.Group>
          <br></br>
          <ClayButton.Group className="searchFieldButtonGroup">
            <span>
              <ClayButton
                displayType="primary"
                disabled={disabled}
                onClick={() => submitSearch()}
              >
                {CONTACT_SEARCH_ACTION_BUTTON}
              </ClayButton>
            </span>
            <ClayButton
              displayType="link"
              ref={triggerElementRef}
              onClick={handleExpand}
            >
              {CONTACT_SEARCH_MORE_SEARCH_OPTIONS}
            </ClayButton>
          </ClayButton.Group>
        </ClayForm.Group>
        <StyledClayDropdownMenu
          styledWidth={fieldSize.width}
          styledMaxWidth={fieldSize.maxWidth}
          ref={menuElementRef}
          active={expand}
          alignElementRef={triggerElementRef}
          onSetActive={() => {}}
          className="cap"
        >
          <div>
            {countries && (
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
                onDropdownCancel={() => setExpand(false)}
              />
            )}
          </div>
        </StyledClayDropdownMenu>
      </SearchWrapper>
      <div></div>
    </Wrapper>
  );
};

export default SearchField;
