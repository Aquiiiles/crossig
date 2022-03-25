import { createSlice, PayloadAction } from "@reduxjs/toolkit";
import { MOBILE } from "../../constants/contactConstants";
import { PhoneNumber } from "../../shared/types";
import { createEmptyPhoneNumber } from "../../shared/util/commonFunctions";

const initialState = {
  emailAddresses: [""],
  mobilePhones: [createEmptyPhoneNumber(MOBILE)],
};

const ContactInfo = createSlice({
  name: "ContactInfo",
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
    setType(state, action: PayloadAction<[number, number]>) {
      const index = action.payload[0];
      const newState = [...state.mobilePhones];
      newState[index].type = action.payload[1];
      state.mobilePhones = newState;
    },
    setMobilePhones(state, action: PayloadAction<Array<PhoneNumber>>) {
      state.mobilePhones = action.payload;
    },
    resetFields(state) {
      state.emailAddresses = initialState.emailAddresses;
      state.mobilePhones = initialState.mobilePhones;
    },
  },
});

export const actions = ContactInfo.actions;

export default ContactInfo.reducer;
