/* eslint-disable @typescript-eslint/no-empty-function */
import React, { useEffect, useState, useRef, useCallback } from "react";
import ClayForm, { ClayInput } from "@clayui/form";
import ClayButton from "@clayui/button";
import ClayDropDown from "@clayui/drop-down";
import SearchFilters from "./components/molecules/SearchFilters";
import { mapToCountryCodes } from "../../../../shared/util/countryMappers";
import { getActiveCountries } from "../../../../api/services/liferay";
import { Wrapper, SearchWrapper } from "./styles";
import {
  CONTACT_SEARCH_ACTION_BUTTON,
  CONTACT_SEARCH_FIELD_OIB,
  CONTACT_SEARCH_FIELD_LAST_NAME_COMPANY_NAME_SE_NAME,
  CONTACT_SEARCH_FIELD_FIRST_NAME,
  CONTACT_SEARCH_MORE_SEARCH_OPTIONS,
} from "../../../../constants/languageKeys";
import {
  useContactSelector,
  useContactDispatch,
} from "../../../../redux/store";
import { actions } from "../../../../redux/searchFilterSlice";
import { PageIndex } from "../../hooks/usePagination";
import useOnClickOutside from "../../../../shared/hooks/useOnClickOutside";
import { useFetchData } from "../../../../api/hooks/useFetchData";
import { COUNTRIES_URL } from "../../../../api/constants/routes";
import { RESOLVED } from "../../../../api/reducers/constants";

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
  const { state, get } = useFetchData();
  const dispatch = useContactDispatch();
  const [disabled, setDisabled] = useState(false);
  const [expand, setExpand] = useState(false);
  const [fieldWidth, setFieldWidth] = useState(0);
  const triggerElementRef = useRef<HTMLButtonElement>(null);
  const menuElementRef = useRef<HTMLDivElement>(null);
  const arrowButtonRef = useRef<HTMLButtonElement>(null);

  const { firstName, OIB, lastName, phoneNumber, areaCode, email } =
    useContactSelector((state) => state.searchFilter);

  const [countries, setCountries] = useState<Array<any> | null>(null);

  const { setFirstName, setOIB, setLastName } = actions;

  useOnClickOutside<HTMLDivElement>(
    menuElementRef,
    useCallback(() => setExpand(false), []),
    arrowButtonRef
  );

  useEffect(() => {
    get(COUNTRIES_URL);
  }, []);

  useEffect(() => {
    if (state.status === RESOLVED) {
      setCountries(state.response.data);
    }
  });

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

  return (
    <Wrapper>
      <SearchWrapper>
        <ClayForm.Group style={{ marginBottom: "0" }}>
          <ClayInput.Group>
            <ClayInput.GroupItem>
              <label className="body-small" htmlFor="oibInputText">
                {CONTACT_SEARCH_FIELD_OIB}
              </label>
              <ClayInput
                id="oibInputText"
                type="text"
                value={OIB}
                onChange={({ target: { value } }) => dispatch(setOIB(value))}
              />
            </ClayInput.GroupItem>
            <ClayInput.GroupItem>
              <label className="body-small" htmlFor="lastNameInputText">
                {CONTACT_SEARCH_FIELD_LAST_NAME_COMPANY_NAME_SE_NAME}
              </label>
              <ClayInput
                id="lastNameInputText"
                type="text"
                value={lastName}
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
                  dispatch(setFirstName(value))
                }
              />
            </ClayInput.GroupItem>
          </ClayInput.Group>
          <br></br>
          <ClayButton.Group>
            <ClayButton
              displayType="primary"
              disabled={disabled}
              onClick={() => {
                if (currentPage === 1) {
                  fetchData();
                } else {
                  goToPage(1);
                }
              }}
            >
              {CONTACT_SEARCH_ACTION_BUTTON}
            </ClayButton>
            <ClayButton
              displayType="link"
              ref={triggerElementRef}
              onClick={handleExpand}
            >
              {CONTACT_SEARCH_MORE_SEARCH_OPTIONS}
            </ClayButton>
          </ClayButton.Group>
        </ClayForm.Group>
        <ClayDropDown.Menu
          ref={menuElementRef}
          style={fieldSize}
          active={expand}
          alignElementRef={triggerElementRef}
          onSetActive={() => {}}
        >
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
            />
          )}
        </ClayDropDown.Menu>
      </SearchWrapper>
      <div></div>
    </Wrapper>
  );
};

export default SearchField;
