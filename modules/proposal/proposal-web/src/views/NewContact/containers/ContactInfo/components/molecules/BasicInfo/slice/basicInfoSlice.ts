import { createSlice, PayloadAction } from "@reduxjs/toolkit";

const initialState = {
  contactType: "1",
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
