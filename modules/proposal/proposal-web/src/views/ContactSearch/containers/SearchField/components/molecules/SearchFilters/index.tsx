import React from "react";
import ClayForm, {ClayInput } from "@clayui/form";
import ClayButton from "@clayui/button";
import { ButtonsWrapper, InputWrappers, Wrapper } from "./styles";
import {
  CONTACT_SEARCH_FIELD_AREA_CODE,
  CONTACT_SEARCH_FIELD_CITY,
  CONTACT_SEARCH_FIELD_COUNTRY_CODE,
  CONTACT_SEARCH_FIELD_EMAIL_ADDRESS,
  CONTACT_SEARCH_FIELD_PHONE_NUMBER,
  CONTACT_SEARCH_FIELD_STREET_ADDRESS,
} from "../../../../../../../constants/languageKeys";
import AreaCodeSelect from "../../../../../../../shared/atoms/AreaCodeSelect";
import CountryCodeSelect from "../../../../../../../shared/atoms/CountryCodeSelect";
import { countryCodes as croatia } from "../../../../../../../constants/defaultCountryConfiguration";
import { Country } from "../../../../../../../shared/types/index";
import { useContactDispatch, useContactSelector } from "../../../../../../../redux/store";
import { actions } from "../../../../../../../redux/searchFilterSlice";

interface props {
  fetchData: () => void;
  searchDisabled: boolean;
  countries: Array<Country>;
}

const SearchFilters: React.FC<props> = ({
  countries,
  fetchData,
  searchDisabled,
}) => {
  const dispatch = useContactDispatch();
  const {
    city,
    street,
    countryCode,
    areaCode,
    phoneNumber,
    email,
  } = useContactSelector(state => state.searchFilter);
  const {
    setCity,
    setStreet,
    setCountryCode,
    setAreaCode,
    setPhoneNumber,
    setEmail,
    clearFilterValues,
  } = actions;

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
        <label htmlFor="cityInput">{CONTACT_SEARCH_FIELD_CITY}</label>
        <ClayInput
          id="cityInput"
          type="text"
          onChange={({target: {value}}) => dispatch(setCity(value))} value={city}
        />
      </ClayForm.Group>
      <ClayForm.Group>
        <label htmlFor="streetInput">{CONTACT_SEARCH_FIELD_STREET_ADDRESS}</label>
        <ClayInput
          id="streetInput"
          type="text"
          onChange={({target: {value}}) => dispatch(setStreet(value))} value={street}
        />
      </ClayForm.Group>
      <InputWrappers>
        <ClayForm.Group>
          <label htmlFor="countryInput">{CONTACT_SEARCH_FIELD_COUNTRY_CODE}</label>
          <CountryCodeSelect
            id={"countryInput"}
            className={""}
            countries={countries}
            entity={countryCode}
            handleChange={e => handleCountryCodeChange(e)}
          />
        </ClayForm.Group>
        <ClayForm.Group>
          <label htmlFor="areaCodeInput">
            {CONTACT_SEARCH_FIELD_AREA_CODE}
          </label>
          <AreaCodeSelect
            id="areaCodeInput"
            className={""}
            disabled={disableAreaCode()}
            entity={areaCode}
            handleChange={e => handleAreaCodeChange(e)}
          />
        </ClayForm.Group>
        <ClayForm.Group>
          <label htmlFor="phoneNumber">{CONTACT_SEARCH_FIELD_PHONE_NUMBER}</label>
          <ClayInput
            id="phoneNumber"
            type="text"
            onChange={({target: {value}}) => dispatch(setPhoneNumber(value))} value={phoneNumber}
          />
        </ClayForm.Group>
      </InputWrappers>
      <ClayForm.Group>
        <label htmlFor="emailInput">{CONTACT_SEARCH_FIELD_EMAIL_ADDRESS}</label>
        <ClayInput
          id="emailInput"
          type="text"
          onChange={({target: {value}}) => dispatch(setEmail(value))} value={email}
        />
      </ClayForm.Group>
      <ButtonsWrapper>
        <ClayButton displayType="link" onClick={() => dispatch(clearFilterValues())}>
          Clear
        </ClayButton>
        <ClayButton displayType="primary" disabled={searchDisabled} onClick={fetchData}>Search</ClayButton>
      </ButtonsWrapper>
      </Wrapper>
    );
};

export default SearchFilters;
