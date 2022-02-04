import { createSlice, PayloadAction } from "@reduxjs/toolkit";

const initialState = {
  contactType: "1",
  firstName: "",
  lastName: "",
  dateOfBirth: "",
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
    setDateOfBirth(state, action: PayloadAction<string>) {
      state.dateOfBirth = action.payload;
    },
    setOIB(state, action: PayloadAction<string>) {
      state.oib = action.payload;
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
