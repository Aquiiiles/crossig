import { createSlice, PayloadAction } from "@reduxjs/toolkit";
import {
  MAXIMUM_LENGTH_FOR_REGISTRATION_MARK,
  MAXIMUM_LENGTH_FOR_NIB,
} from "../constants/vesselConstants";

const initialState = {
  vesselType: "",
  vesselName: "",
  vesselRegistrationMark: "",
  vesselNib: "",
  vesselFleetName: "",
};

const vesselSearchSlice = createSlice({
  name: "vesselSearch",
  initialState,
  reducers: {
    setVesselType(state, action: PayloadAction<string>) {
      state.vesselType = action.payload;
    },
    setVesselName(state, action: PayloadAction<string>) {
      state.vesselName = action.payload;
    },
    setVesselRegistrationMark(state, action: PayloadAction<string>) {
      if (action.payload.length <= MAXIMUM_LENGTH_FOR_REGISTRATION_MARK) {
        state.vesselRegistrationMark = action.payload;
      }
    },
    setVesselNib(state, action: PayloadAction<string>) {
      if (action.payload.length <= MAXIMUM_LENGTH_FOR_NIB) {
        state.vesselNib = action.payload;
      }
    },
    setVesselFleetName(state, action: PayloadAction<string>) {
      state.vesselFleetName = action.payload;
    },
    clearValues(state) {
      state.vesselFleetName = initialState.vesselFleetName;
      state.vesselName = initialState.vesselName;
      state.vesselNib = initialState.vesselNib;
      state.vesselRegistrationMark = initialState.vesselRegistrationMark;
      state.vesselType = initialState.vesselType;
    },
  },
});

export const actions = vesselSearchSlice.actions;

export default vesselSearchSlice.reducer;
