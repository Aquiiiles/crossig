import { createSlice, PayloadAction } from "@reduxjs/toolkit";

import {
  MAXIMUM_LENGTH_FOR_NAME_OF_VESSEL,
  MAXIMUM_LENGTH_FOR_NAME_OF_FLEET,
  MAXIMUM_LENGTH_FOR_REGISTRATION_MARK,
  MAXIMUM_LENGTH_FOR_NIB,
} from "../../constants/vesselConstants";

export const initialState = {
  vesselType: "",
  vesselName: "",
  vesselRegistrationMark: "",
  vesselFleetName: "",
  vesselNIB: "",
  sortedBy: "id",
  sortOrder: "desc",
};

const vesselLookupReducer = createSlice({
  name: "vesselLookupFilter",
  initialState,
  reducers: {
    setVesselType(state, action: PayloadAction<string>) {
      state.vesselType = action.payload;
    },
    setVesselName(state, action: PayloadAction<string>) {
      if (action.payload.length <= MAXIMUM_LENGTH_FOR_NAME_OF_VESSEL) {
        state.vesselName = action.payload;
      }
    },
    setVesselRegistrationMark(state, action: PayloadAction<string>) {
      if (action.payload.length <= MAXIMUM_LENGTH_FOR_REGISTRATION_MARK) {
        state.vesselRegistrationMark = action.payload;
      }
    },
    setVesselFleetName(state, action: PayloadAction<string>) {
      if (action.payload.length <= MAXIMUM_LENGTH_FOR_NAME_OF_FLEET) {
        state.vesselFleetName = action.payload;
      }
    },
    setVesselNIB(state, action: PayloadAction<string>) {
      if (action.payload.length <= MAXIMUM_LENGTH_FOR_NIB) {
        state.vesselNIB = action.payload;
      }
    },
    setSortedBy(state, action: PayloadAction<string>) {
      state.sortedBy = action.payload;
    },
    setSortOrder(state, action: PayloadAction<"asc" | "desc">) {
      state.sortOrder = action.payload;
    },
    resetFields(state) {
      state.vesselFleetName = initialState.vesselFleetName;
      state.vesselName = initialState.vesselName;
      state.vesselNIB = initialState.vesselNIB;
      state.vesselRegistrationMark = initialState.vesselRegistrationMark;
      state.vesselType = initialState.vesselType;
    },
  },
});

export const actions = vesselLookupReducer.actions;

export default vesselLookupReducer.reducer;
