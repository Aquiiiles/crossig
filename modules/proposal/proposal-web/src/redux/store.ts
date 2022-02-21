import { configureStore } from "@reduxjs/toolkit";
import { TypedUseSelectorHook, useDispatch, useSelector } from "react-redux";
import basicInfoReducer from "./basicInfoSlice";
import searchFilterReducer from "./searchFilterSlice";
import contactInfoReducer from "./contactInfoSlice";
import addressesReducer from "./addressesSlice";

export const createContactStore = () => {
  return configureStore({
    reducer: {
      basicInfo: basicInfoReducer,
      addresses: addressesReducer,
      searchFilter: searchFilterReducer,
      contactInfo: contactInfoReducer,
    },
  });
};

const store = createContactStore();

export type ContactRootState = ReturnType<typeof store.getState>;
export type ContactDispatch = typeof store.dispatch;

export const useContactDispatch = () => useDispatch<ContactDispatch>();
export const useContactSelector: TypedUseSelectorHook<ContactRootState> =
  useSelector;

export default store;
