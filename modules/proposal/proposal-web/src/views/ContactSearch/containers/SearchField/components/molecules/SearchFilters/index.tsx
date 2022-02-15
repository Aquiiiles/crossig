import React from "react";
import ClayForm, { ClayInput } from "@clayui/form";
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

const SearchFilters: React.FC<{ countries: Array<Country> }> = ({
  countries,
}) => {
  const [city, setCity] = React.useState("");
  const [street, setStreet] = React.useState("");
  const [countryCode, setCountryCode] = React.useState(croatia.label);
  const [areaCode, setAreaCode] = React.useState("");
  const [phoneNumber, setPhoneNumber] = React.useState("");
  const [email, setEmail] = React.useState("");

  const clearValues = () => {
    setCity("");
    setStreet("");
    setCountryCode("");
    setAreaCode("");
    setPhoneNumber("");
    setEmail("");
  };

  const handleCountryCodeChange = (e: any) => {
    setCountryCode(e.target.value);
    if (e.target.value.toString() !== croatia.label) {
      setAreaCode("");
    }
  };

  const handleAreaCodeChange = (e: any) => {
    setAreaCode(e.target.value);
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
          onChange={e => setCity(e.target.value.toString())}
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
          onChange={e => setStreet(e.target.value.toString())}
          value={street}
        />
      </ClayForm.Group>
      <InputWrappers>
        <ClayForm.Group>
          <label htmlFor="countryInput">
            {CONTACT_SEARCH_FIELD_COUNTRY_CODE}
          </label>
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
          <label htmlFor="phoneNumber">
            {CONTACT_SEARCH_FIELD_PHONE_NUMBER}
          </label>
          <ClayInput
            id="phoneNumber"
            type="text"
            onChange={e => setPhoneNumber(e.target.value.toString())}
            value={phoneNumber}
          />
        </ClayForm.Group>
      </InputWrappers>
      <ClayForm.Group>
        <label htmlFor="emailInput">{CONTACT_SEARCH_FIELD_EMAIL_ADDRESS}</label>
        <ClayInput
          id="emailInput"
          type="text"
          onChange={e => setEmail(e.target.value.toString())}
          value={email}
        />
      </ClayForm.Group>
      <ButtonsWrapper>
        <ClayButton displayType="link" onClick={clearValues}>
          Clear
        </ClayButton>
        <ClayButton displayType="primary">Search</ClayButton>
      </ButtonsWrapper>
    </Wrapper>
  );
};

export default SearchFilters;
