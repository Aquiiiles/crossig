import { createSlice, PayloadAction } from "@reduxjs/toolkit";
import { Product } from "../views/InsuranceProduct/types/product";

const initialState = {
  insuranceProduct: {
    active: false,
    category: "",
    description: "",
    externalId: 0,
    name: "",
    productId: 0,
  },
};

const InsuranceProduct = createSlice({
  name: "InsuranceProduct",
  initialState,
  reducers: {
    setInsuranceProduct(state, action: PayloadAction<Product>) {
      state.insuranceProduct = action.payload;
    },
    resetFields(state) {
      state.insuranceProduct = initialState.insuranceProduct;
    },
  },
});

export const actions = InsuranceProduct.actions;

export default InsuranceProduct.reducer;
