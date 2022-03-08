import { createSlice, PayloadAction } from "@reduxjs/toolkit";
import { initialState } from "./constants";

const addressSlice = createSlice({
  name: "address",
  initialState,
  reducers: {
    setCountry(state, action: PayloadAction<string>) {
      state.country = action.payload;
    },
    setDispatchCountry(state, action: PayloadAction<string>) {
      state.dispatchCountry = action.payload;
    },
    setCity(state, action: PayloadAction<string>) {
      state.city = action.payload;
    },
    setDispatchCity(state, action: PayloadAction<string>) {
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
    resetFields() {
      return initialState;
    },
  },
});

export const actions = addressSlice.actions;

export default addressSlice.reducer;
