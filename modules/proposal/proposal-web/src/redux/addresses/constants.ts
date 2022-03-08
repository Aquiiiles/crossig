import { countryNames } from "../../constants/defaultCountryConfiguration";

export const initialState = {
  country: countryNames.value,
  dispatchCountry: countryNames.value,
  city: "",
  dispatchCity: "",
  cityName: "",
  dispatchCityName: "",
  isSameAddress: true,
  postalCode: "",
  dispatchPostalCode: "",
  street: "",
  dispatchStreet: "",
  houseNumber: "",
  dispatchHouseNumber: "",
};

export const MAIN_ADDRESS = "mainAddress";
export const DISPATCH_ADDRESS = "dispatchAddress";
