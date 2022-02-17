import { createSlice, PayloadAction } from "@reduxjs/toolkit";

const initialState = {
  country: "",
  dispatchCountry: "",
  city: 0,
  dispatchCity: 0,
  isSameAddress: true,
  postalCode: "",
  dispatchPostalCode: "",
};

const addressSlice = createSlice({
  name: "address",
  initialState,
  reducers: {
    setCountry(state, action: PayloadAction<string>) {
      state.country = action.payload;
    },
    setDispatchCountry(state, action: PayloadAction<string>) {
      state.country = action.payload;
    },
    setCity(state, action: PayloadAction<number>) {
      state.city = action.payload;
    },
    setDispatchCity(state, action: PayloadAction<number>) {
      state.dispatchCity = action.payload;
    },
    setIsSameAddress(state, action: PayloadAction<boolean>) {
      state.isSameAddress = action.payload;
    },
    setPostalCode(state, action: PayloadAction<string>) {
      state.postalCode = action.payload;
    },
    setDispatchPostalCode(state, action: PayloadAction<string>) {
      state.dispatchPostalCode = action.payload;
    },
  },
});

export const actions = addressSlice.actions;

export default addressSlice.reducer;
