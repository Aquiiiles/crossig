import { configureStore } from "@reduxjs/toolkit";
import { TypedUseSelectorHook, useDispatch, useSelector } from "react-redux";
import addressReducer from "./addressSlice";
import basicInfoReducer from "./basicInfoSlice";
import searchFilterReducer from "./searchFilterSlice";
import contactInfoReducer from "./contactInfoSlice";

export const getInitialState = () => {
  return configureStore({
    reducer: {
      searchFilter: searchFilterReducer,
      basicInfo: basicInfoReducer,
      address: addressReducer,
      contactInfo: contactInfoReducer,
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
