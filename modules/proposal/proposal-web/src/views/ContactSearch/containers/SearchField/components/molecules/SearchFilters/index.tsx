import React, { useEffect } from "react";
import ClayForm, { ClayInput } from "@clayui/form";
import ClayButton from "@clayui/button";
import { ButtonsWrapper, InputWrappers, Wrapper } from "./styles";
import CountryCodeSelect from "../../../../../../../shared/atoms/contact/CountryCodeSelect";
import { countryCodes as croatia } from "../../../../../../../constants/defaultCountryConfiguration";
import { Country } from "../../../../../../../shared/types";
import { useHttpRequest } from "../../../../../../../api/hooks/useHttpRequest";
import { AREA_CODE_URL } from "../../../../../../../api/constants/routes";
import { actions } from "../../../../../../../redux";
import { numbersOnly } from "../../../../../../../shared/util/commonFunctions";
import { useDispatch, useSelector } from "../../../../../../../redux/store";
import AreaCodeSelect from "../../../../../../../shared/atoms/contact/AreaCodeSelect";
import languageKeys from "../../../../../../../constants/Language";

const { CONTACT_SEARCH } = languageKeys;

interface props {
  fetchData: () => void;
  searchDisabled: boolean;
  countries: Array<Country>;
  onDropdownCancel: () => void;
}

const SearchFilters: React.FC<props> = ({
  countries,
  fetchData,
  searchDisabled,
  onDropdownCancel,
}) => {
  const [, , { get: fetchAreaCodes }] = useHttpRequest();

  useEffect(() => {
    fetchAreaCodes(AREA_CODE_URL);
  }, []);

  const dispatch = useDispatch();
  const { city, street, countryCode, areaCode, phoneNumber, email } =
    useSelector((state) => state.searchFilter);
  const {
    setCity,
    setStreet,
    setCountryCode,
    setAreaCode,
    setPhoneNumber,
    setEmail,
    clearFilterValues,
  } = actions.searchFilter;

  const handleCountryCodeChange = (e: any) => {
    dispatch(setCountryCode(e.target.value));
    if (e.target.value.toString() !== croatia.label) {
      dispatch(setAreaCode(""));
    }
  };

  const handleAreaCodeChange = (e: any) => {
    dispatch(setAreaCode(e.target.value));
  };

  const disableAreaCode = () => {
    if (countryCode === "") {
      return false;
    } else if (countryCode === croatia.label) {
      return false;
    } else {
      return true;
    }
  };

  return (
    <Wrapper>
      <ClayForm.Group>
        <label htmlFor="cityInput">{CONTACT_SEARCH.FIELD.CITY}</label>
        <ClayInput
          id="cityInput"
          type="text"
          onChange={({ target: { value } }) => dispatch(setCity(value))}
          value={city}
        />
      </ClayForm.Group>
      <ClayForm.Group>
        <label htmlFor="streetInput">
          {CONTACT_SEARCH.FIELD.STREET_ADDRESS}
        </label>
        <ClayInput
          id="streetInput"
          type="text"
          onChange={({ target: { value } }) => dispatch(setStreet(value))}
          value={street}
        />
      </ClayForm.Group>
      <InputWrappers>
        <ClayForm.Group>
          <label htmlFor="countryInput">
            {CONTACT_SEARCH.FIELD.COUNTRY_CODE}
          </label>
          <CountryCodeSelect
            id={"countryInput"}
            className={""}
            countries={countries}
            entity={countryCode}
            handleChange={(e) => handleCountryCodeChange(e)}
          />
        </ClayForm.Group>
        <ClayForm.Group>
          <label htmlFor="areaCodeInput">
            {CONTACT_SEARCH.FIELD.AREA_CODE}
          </label>
          <AreaCodeSelect
            id="areaCodeInput"
            className={""}
            disabled={disableAreaCode()}
            entity={areaCode}
            handleChange={(e) => handleAreaCodeChange(e)}
          />
        </ClayForm.Group>
        <ClayForm.Group>
          <label htmlFor="phoneNumber">
            {CONTACT_SEARCH.FIELD.PHONE_NUMBER}
          </label>
          <ClayInput
            id="phoneNumber"
            type="text"
            className="straight-numbers"
            onChange={({ target: { value } }) =>
              dispatch(setPhoneNumber(numbersOnly(value)))
            }
            value={phoneNumber}
          />
        </ClayForm.Group>
      </InputWrappers>
      <ClayForm.Group>
        <label htmlFor="emailInput">{CONTACT_SEARCH.FIELD.EMAIL_ADDRESS}</label>
        <ClayInput
          id="emailInput"
          type="text"
          onChange={({ target: { value } }) => dispatch(setEmail(value))}
          value={email}
        />
      </ClayForm.Group>
      <ButtonsWrapper>
        <ClayButton.Group className="tablet-only" onClick={onDropdownCancel}>
          <ClayButton displayType="link">
            {CONTACT_SEARCH.FILTER.CANCEL}
          </ClayButton>
        </ClayButton.Group>
        <ClayButton.Group spaced>
          <ClayButton
            displayType="link"
            onClick={() => dispatch(clearFilterValues())}
          >
            {CONTACT_SEARCH.FILTER.CLEAR}
          </ClayButton>
          <ClayButton
            displayType="primary"
            disabled={searchDisabled}
            onClick={fetchData}
          >
            {CONTACT_SEARCH.FILTER.SEARCH}
          </ClayButton>
        </ClayButton.Group>
      </ButtonsWrapper>
    </Wrapper>
  );
};

export default SearchFilters;
