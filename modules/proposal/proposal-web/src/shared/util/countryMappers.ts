import { countryNames, countryCodes } from "../../constants/defaultCountryConfiguration";

import { Country } from "../../views/NewContact/containers/ContactInfo/components/atoms/PhoneInputList";

export const mapToCountryNames = (countriesArray: Array<any>) => {
  const countries = countriesArray
    .map((country) => {
      return {
        label: country.nameCurrentValue,
        value: country.countryId,
      };
    })
    .filter((country) => country.label !== countryNames.label);
  countries.unshift(countryNames);

  return countries;
};

export const mapToCountryCodeCountries = (countriesArray: Array<any>) => {
  const countries = countriesArray
    .map((country) => {
      return {
        label: country.idd,
        value: country.idd,
        flagKey: country.a2,
      } as Country;
    })
    .filter(
      (country) => country.label !== countryCodes.label
    );
  countries.unshift(countryCodes);

  return countries;
};
