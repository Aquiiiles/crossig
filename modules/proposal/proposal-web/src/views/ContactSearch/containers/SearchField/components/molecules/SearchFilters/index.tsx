import React, { useEffect } from "react";
import ClayForm, {
  ClayInput,
  ClaySelect,
} from "@clayui/form";
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
import CountryCodeSelect from "../../../../../../../shared/atoms/CountryCodeSelect";
import { countryCodes as croatia } from "../../../../../../../constants/defaultCountryConfiguration";
import { Country } from "../../../../../../../shared/types/index";
import { useFetchData } from "../../../../../../../api/hooks/useFetchData";
import { AREA_CODE_URL } from "../../../../../../../api/constants/routes";
import {
  useContactDispatch,
  useContactSelector,
} from "../../../../../../../redux/store";
import { actions } from "../../../../../../../redux/searchFilterSlice";

type AreaCodeType = {
  area_name: string;
  area_code: number;
};
interface State {
  status: string;
  response: {
    data: {
      area_codes: Array<AreaCodeType>;
    };
  };
  statusMessage: string;
  statusCode: string;
}

interface props {
  fetchData: () => void;
  searchDisabled: boolean;
  countries: Array<Country>;
}

const SearchFilters: React.FC<props> = ({ countries, fetchData, searchDisabled }) => {
  const { state, get: getAreaCode } = useFetchData();
  const areaCodeData = state as State;

  useEffect(() => {
    getAreaCode(AREA_CODE_URL, {});
  }, []);

  const dispatch = useContactDispatch();
  const { city, street, countryCode, areaCode, phoneNumber, email } =
    useContactSelector(state => state.searchFilter);
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
          onChange={({ target: { value } }) => dispatch(setCity(value))}
          value={city}
        />
      </ClayForm.Group>
      <ClayForm.Group>
        <label htmlFor="streetInput">
          {CONTACT_SEARCH_FIELD_STREET_ADDRESS}
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
          <label htmlFor="areaInput">{CONTACT_SEARCH_FIELD_AREA_CODE}</label>
          {areaCodeData.response.data?.area_codes && (
            <ClaySelect
              aria-label={CONTACT_SEARCH_FIELD_AREA_CODE}
              id="areaInput"
              onChange={e => handleAreaCodeChange(e)}
              value={areaCode}
            >
              {areaCodeData.response.data.area_codes.map(
                (item: AreaCodeType) => (
                  <ClaySelect.Option
                    selected={areaCode === item.area_code.toString()}
                    key={item.area_code}
                    label={item.area_code.toString()}
                    value={item.area_code}
                  />
                )
              )}
            </ClaySelect>
          )}
        </ClayForm.Group>
        <ClayForm.Group>
          <label htmlFor="phoneNumber">
            {CONTACT_SEARCH_FIELD_PHONE_NUMBER}
          </label>
          <ClayInput
            id="phoneNumber"
            type="text"
            onChange={({ target: { value } }) =>
              dispatch(setPhoneNumber(value))
            }
            value={phoneNumber}
          />
        </ClayForm.Group>
      </InputWrappers>
      <ClayForm.Group>
        <label htmlFor="emailInput">{CONTACT_SEARCH_FIELD_EMAIL_ADDRESS}</label>
        <ClayInput
          id="emailInput"
          type="text"
          onChange={({ target: { value } }) => dispatch(setEmail(value))}
          value={email}
        />
      </ClayForm.Group>
      <ButtonsWrapper>
        <ClayButton
          displayType="link"
          onClick={() => dispatch(clearFilterValues())}
        >
          Clear
        </ClayButton>
        <ClayButton
          displayType="primary"
          disabled={searchDisabled}
          onClick={fetchData}
        >
          Search
        </ClayButton>
      </ButtonsWrapper>
      </Wrapper>
    );
};

export default SearchFilters;
