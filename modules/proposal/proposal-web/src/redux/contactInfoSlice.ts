import { createSlice, PayloadAction } from "@reduxjs/toolkit";
import { MOBILE } from "../constants/contactConstants";
import { PhoneNumber } from "../shared/types";
import { createEmptyPhoneNumber } from "../shared/util/createEmptyPhoneNumber";

const initialState = {
  emailAddresses: [""],
  mobilePhones: [createEmptyPhoneNumber(MOBILE)],
};

const contactInfoSlice = createSlice({
  name: "contactInfo",
  initialState,
  reducers: {
    setEmailAddresses(state, action: PayloadAction<Array<string>>) {
      state.emailAddresses = action.payload;
    },

    setAreaCode(state, action: PayloadAction<[number, string]>) {
      const index = action.payload[0];
      const newState = [...state.mobilePhones];
      newState[index].areaCode = action.payload[1];
      state.mobilePhones = newState;
    },

    setCountryCode(state, action: PayloadAction<[number, string]>) {
      const index = action.payload[0];
      const newState = [...state.mobilePhones];
      newState[index].countryCode = action.payload[1];
      state.mobilePhones = newState;
    },
    setPhoneNumber(state, action: PayloadAction<[number, string]>) {
      const index = action.payload[0];
      const newState = [...state.mobilePhones];
      newState[index].phoneNumber = action.payload[1];
      state.mobilePhones = newState;
    },
    setType(state, action: PayloadAction<[number, string]>) {
      const index = action.payload[0];
      const newState = [...state.mobilePhones];
      newState[index].type = action.payload[1];
      state.mobilePhones = newState;
    },
    setMobilePhones(state, action: PayloadAction<Array<PhoneNumber>>) {
      state.mobilePhones = action.payload;
    },
  },
});

export const actions = contactInfoSlice.actions;

export default contactInfoSlice.reducer;
