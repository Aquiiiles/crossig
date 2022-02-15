import { createSlice, PayloadAction } from "@reduxjs/toolkit";

const initialState = {
  OIB: "",
  firstName: "",
  lastName: "",
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
    setOIB(state, action: PayloadAction<string>) {
      state.OIB = action.payload;
    },
    setFirstName(state, action: PayloadAction<string>) {
      state.firstName = action.payload;
    },
    setLastName(state, action: PayloadAction<string>) {
      state.lastName = action.payload;
    },
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
