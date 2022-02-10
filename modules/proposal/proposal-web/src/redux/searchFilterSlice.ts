import { createSlice, PayloadAction } from "@reduxjs/toolkit";

const initialState = {
  city: "",
  street: "",
  countryCode: "",
  areaCode: "",
  phoneNumber: "",
  email: "",
};

const searchFilterSlice = createSlice({
  name: "searchFilter",
  initialState,
  reducers: {
    setCity(state, action: PayloadAction<string>) {
      state.city = action.payload;
    },
    setStreet(state, action: PayloadAction<string>) {
      state.street = action.payload;
    },
    setCountryCode(state, action: PayloadAction<string>) {
      state.countryCode = action.payload;
    },
    setAreaCode(state, action: PayloadAction<string>) {
      state.areaCode = action.payload;
    },
    setPhoneNumber(state, action: PayloadAction<string>) {
      state.phoneNumber = action.payload;
    },
    setEmail(state, action: PayloadAction<string>) {
      state.email = action.payload;
    },
    clearFilterValues(state) {
      state.city = "";
      state.street = "";
      state.countryCode = "";
      state.areaCode = "";
      state.phoneNumber = "";
      state.email = "";
    },
  },
});

export const actions = searchFilterSlice.actions;

export default searchFilterSlice.reducer;
