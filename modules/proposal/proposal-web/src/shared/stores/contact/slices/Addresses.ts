import { createSlice, PayloadAction } from "@reduxjs/toolkit";
import { WritableDraft } from "immer/dist/internal";
import { Address } from "../../../types/contact";
import { countryNames } from "../../../../constants/defaultCountryConfiguration";

const blankAddress = {
  country: countryNames.value,
  city: 0,
  postalCode: "",
  street: "",
  houseNumber: "",
} as Address;

const initialState = {
  idAddress: blankAddress,
  dispatchAddress: blankAddress,
  areAddressesEqual: true,
};

type StateType = {
  idAddress: Address;
  dispatchAddress: Address;
  areAddressesEqual: boolean;
};

const shouldSetMainAddress = (action: PayloadAction<[string, string]>) => {
  return "idAddress" === action.payload[0];
};

const getStateReference = (
  state: WritableDraft<StateType>,
  action: PayloadAction<[string, any]>
) => {
  return shouldSetMainAddress(action) ? state.idAddress : state.dispatchAddress;
};

const AddressesSlice = createSlice({
  name: "addresses",
  initialState,
  reducers: {
    setCountry(state, action: PayloadAction<[string, string]>) {
      getStateReference(state, action).country = action.payload[1];
    },
    setCity(state, action: PayloadAction<[string, number]>) {
      getStateReference(state, action).city = action.payload[1];
    },
    setPostalCode(state, action: PayloadAction<[string, string]>) {
      getStateReference(state, action).postalCode = action.payload[1];
    },
    setStreet(state, action: PayloadAction<[string, string]>) {
      getStateReference(state, action).street = action.payload[1];
    },
    setHouseNumber(state, action: PayloadAction<[string, string]>) {
      getStateReference(state, action).houseNumber = action.payload[1];
    },
    toggleEqualAddresses(state) {
      state.areAddressesEqual = !state.areAddressesEqual;
      if (state.areAddressesEqual) {
        state.dispatchAddress = state.idAddress;
      } else {
        state.dispatchAddress = blankAddress;
      }
    },
  },
});

export const actions = AddressesSlice.actions;

export default AddressesSlice.reducer;
