import { createSlice, PayloadAction } from "@reduxjs/toolkit";
import { contactTypes } from "../constants/contactConstants";

const initialState = {
  contactType: contactTypes.Individual,
  firstName: "",
  lastName: "",
  dateDay: "",
  dateMonth: "",
  dateYear: "",
  oib: "",
  foreignerStatus: false,
  companyName: "",
  subsidiaryNumber: "",
};

const basicInfoSlice = createSlice({
  name: "basicInfo",
  initialState,
  reducers: {
    setType(state, action: PayloadAction<string>) {
      state.contactType = action.payload;
    },
    setFirstName(state, action: PayloadAction<string>) {
      state.firstName = action.payload.replaceAll(/\d/g, "");
    },
    setLastName(state, action: PayloadAction<string>) {
      state.lastName = action.payload.replaceAll(/\d/g, "");
    },
    setDateDay(state, action: PayloadAction<string>) {
      if (action.payload.length <= 2) {
        state.dateDay = action.payload.replaceAll(/\D/g, "");
      }
    },
    setDateMonth(state, action: PayloadAction<string>) {
      if (action.payload.length <= 2) {
        state.dateMonth = action.payload.replaceAll(/\D/g, "");
      }
    },
    setDateYear(state, action: PayloadAction<string>) {
      if (action.payload.length <= 4) {
        state.dateYear = action.payload.replaceAll(/\D/g, "");
      }
    },
    setOIB(state, action: PayloadAction<string>) {
      if (action.payload.length <= 11) {
        state.oib = action.payload.replaceAll(/\D/g, "");
      }
    },
    toggleForeignerStatus(state) {
      state.foreignerStatus = !state.foreignerStatus;
    },
    setCompanyName(state, action: PayloadAction<string>) {
      state.companyName = action.payload;
    },
    setSubsidiaryNumber(state, action: PayloadAction<string>) {
      state.subsidiaryNumber = action.payload;
    },
  },
});

export const actions = basicInfoSlice.actions;

export default basicInfoSlice.reducer;
