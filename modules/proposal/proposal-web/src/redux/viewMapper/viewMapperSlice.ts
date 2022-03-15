import { createSlice, PayloadAction } from "@reduxjs/toolkit";

const initialState = {
  currentView: "",
};

const ViewMapper = createSlice({
  name: "ViewMapper",
  initialState,
  reducers: {
    setCurrentView(state, action: PayloadAction<string>) {
      state.currentView = action.payload;
    },
  },
});

export const actions = ViewMapper.actions;

export default ViewMapper.reducer;
