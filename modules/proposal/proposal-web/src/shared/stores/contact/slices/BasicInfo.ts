import { createSlice, PayloadAction } from "@reduxjs/toolkit";
import { contactTypes } from "../../../../constants/contactConstants";

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

const BasicInfo = createSlice({
  name: "BasicInfo",
  initialState,
  reducers: {
    setType(state, action: PayloadAction<string>) {
      state.contactType = action.payload;
    },
    setFirstName(state, action: PayloadAction<string>) {
      state.firstName = action.payload;
    },
    setLastName(state, action: PayloadAction<string>) {
      state.lastName = action.payload;
    },
    setDateDay(state, action: PayloadAction<string>) {
      if (!isNaN(Number(action.payload)) && action.payload.length <= 2) {
        state.dateDay = action.payload;
      }
    },
    setDateMonth(state, action: PayloadAction<string>) {
      if (!isNaN(Number(action.payload)) && action.payload.length <= 2) {
        state.dateMonth = action.payload;
      }
    },
    setDateYear(state, action: PayloadAction<string>) {
      if (!isNaN(Number(action.payload)) && action.payload.length <= 4) {
        state.dateYear = action.payload;
      }
    },
    setOIB(state, action: PayloadAction<string>) {
      if (!isNaN(Number(action.payload)) && action.payload.length <= 11) {
        state.oib = action.payload;
      }
    },
    toggleForeignerStatus(state) {
      state.foreignerStatus = !state.foreignerStatus;
    },
    setForeignerStatus(state, action: PayloadAction<boolean>) {
      state.foreignerStatus = action.payload;
    },
    setCompanyName(state, action: PayloadAction<string>) {
      state.companyName = action.payload;
    },
    setSubsidiaryNumber(state, action: PayloadAction<string>) {
      state.subsidiaryNumber = action.payload;
    },
  },
});

export const actions = BasicInfo.actions;

export default BasicInfo.reducer;
