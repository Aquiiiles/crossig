import { createSlice, PayloadAction } from "@reduxjs/toolkit";
import { countryNames } from "../constants/defaultCountryConfiguration";

export const MAIN_ADDRESS = "mainAddress";
export const DISPATCH_ADDRESS = "dispatchAddress";

const initialState = {
  country: countryNames.value,
  dispatchCountry: countryNames.value,
  city: 0,
  dispatchCity: 0,
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

const addressSlice = createSlice({
  name: "address",
  initialState,
  reducers: {
    setCountry(state, action: PayloadAction<string>) {
      state.country = action.payload;
    },
    setDispatchCountry(state, action: PayloadAction<string>) {
      state.country = action.payload;
    },
    setCity(state, action: PayloadAction<number>) {
      state.city = action.payload;
    },
    setDispatchCity(state, action: PayloadAction<number>) {
      state.dispatchCity = action.payload;
    },
    setCityName(state, action: PayloadAction<string>) {
      state.cityName = action.payload;
    },
    setDispatchCityName(state, action: PayloadAction<string>) {
      state.dispatchCityName = action.payload;
    },
    setStreet(state, action: PayloadAction<string>) {
      state.street = action.payload;
    },
    setDispatchStreet(state, action: PayloadAction<string>) {
      state.dispatchStreet = action.payload;
    },
    setIsSameAddress(state, action: PayloadAction<boolean>) {
      state.isSameAddress = action.payload;
    },
    setPostalCode(state, action: PayloadAction<string>) {
      state.postalCode = action.payload;
    },
    setDispatchPostalCode(state, action: PayloadAction<string>) {
      state.dispatchPostalCode = action.payload;
    },
    setHouseNumber(state, action: PayloadAction<string>) {
      state.houseNumber = action.payload;
    },
    setDispatchHouseNumber(state, action: PayloadAction<string>) {
      state.dispatchHouseNumber = action.payload;
    },
    resetFields(state) {
      state.city = initialState.city;
      state.cityName = initialState.cityName;
      state.country = initialState.country;
      state.dispatchCity = initialState.dispatchCity;
      state.dispatchCountry = initialState.dispatchCountry;
      state.dispatchPostalCode = initialState.dispatchPostalCode;
      state.isSameAddress = initialState.isSameAddress;
      state.postalCode = initialState.postalCode;
      state.street = initialState.street;
      state.dispatchStreet = initialState.dispatchStreet;
      state.dispatchPostalCode = initialState.dispatchPostalCode;
      state.houseNumber = initialState.houseNumber;
      state.dispatchHouseNumber = initialState.dispatchHouseNumber;
    },
  },
});

export const actions = addressSlice.actions;

export default addressSlice.reducer;
