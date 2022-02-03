import { createSlice } from "@reduxjs/toolkit";

const initialState = {
  type: "Individual",
  firstName: "",
  lastName: "",
  dateOfBirth: "",
  oib: "",
  foreignerStatus: false,
};

const basicInfoSlice = createSlice({
  name: "basicInfo",
  initialState,
  reducers: {
    setType(state, action) {
      state.type = action.payload;
    },
    setFirstName(state, action) {
      state.firstName = action.payload;
    },
    setLastName(state, action) {
      state.lastName = action.payload;
    },
    setDateOfBirth(state, action) {
      state.dateOfBirth = action.payload;
    },
    setOIB(state, action) {
      state.oib = action.payload;
    },
    toggleForeignerStatus(state) {
      state.foreignerStatus = !state.foreignerStatus;
    },
  },
});

export const actionsBag = basicInfoSlice.actions;

export default basicInfoSlice.reducer;
