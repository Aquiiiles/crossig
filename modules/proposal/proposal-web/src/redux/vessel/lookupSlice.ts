import { createSlice, PayloadAction } from "@reduxjs/toolkit";

export const initialState = {
  vesselType: "",
  vesselName: "",
  registrationMark: "",
  NIB: "",
  sortedBy: "id",
  sortOrder: "desc",
};

const lookupSlice = createSlice({
  name: "vesselLookupFilter",
  initialState,
  reducers: {
    setVesselType(state, action: PayloadAction<string>) {
      state.vesselType = action.payload;
    },
    setVesselName(state, action: PayloadAction<string>) {
      state.vesselName = action.payload;
    },
    setRegistrationMark(state, action: PayloadAction<string>) {
      state.registrationMark = action.payload;
    },
    setNIB(state, action: PayloadAction<string>) {
      state.NIB = action.payload;
    },
    setSortedBy(state, action: PayloadAction<string>) {
      state.sortedBy = action.payload;
    },
    setSortOrder(state, action: PayloadAction<"asc" | "desc">) {
      state.sortOrder = action.payload;
    },
    resetFields(state) {
      state.vesselType = "";
      state.vesselName = "";
      state.registrationMark = "";
      state.NIB = "";
    },
  },
});

export const actions = lookupSlice.actions;

export default lookupSlice.reducer;
