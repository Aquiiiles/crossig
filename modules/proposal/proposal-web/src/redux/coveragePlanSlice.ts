import { createSlice, PayloadAction } from "@reduxjs/toolkit";
import { CoveragePlan } from "../views/CoveragePlan/types/coveragePlan";

const initialState = {
  coveragePlan: {
    category: "",
    coveragePlanId: 0,
    description: "",
    name: "",
  },
};

const CoveragePlan = createSlice({
  name: "CoveragePlan",
  initialState,
  reducers: {
    setCoveragePlan(state, action: PayloadAction<CoveragePlan>) {
      state.coveragePlan = action.payload;
    },
    resetFields(state) {
      state.coveragePlan = initialState.coveragePlan;
    },
  },
});

export const actions = CoveragePlan.actions;

export default CoveragePlan.reducer;
