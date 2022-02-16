import { configureStore } from "@reduxjs/toolkit";
import { TypedUseSelectorHook, useDispatch, useSelector } from "react-redux";
import AddressesReducer from "./slices/Addresses";
import BasicInfoReducer from "./slices/BasicInfo";
import ContactInfoReducer from "./slices/ContactInfo";

export const getInitialState = () => {
  return configureStore({
    reducer: {
      basicInfo: BasicInfoReducer,
      addresses: AddressesReducer,
      contactInfo: ContactInfoReducer,
    },
  });
};

const store = getInitialState();

export type ContactRootState = ReturnType<typeof store.getState>;
export type ContactDispatch = typeof store.dispatch;

export const useContactDispatch = () => useDispatch<ContactDispatch>();
export const useContactSelector: TypedUseSelectorHook<ContactRootState> =
  useSelector;

export default store;