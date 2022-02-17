import { configureStore } from "@reduxjs/toolkit";
import { TypedUseSelectorHook, useDispatch, useSelector } from "react-redux";
import contactinfoReducer from "./contactInfoSlice";
import basicInfoReducer from "./basicInfoSlice";
import searchFilterReducer from "./searchFilterSlice";

const store = configureStore({
  reducer: {
    basicInfo: basicInfoReducer,
    searchFilter: searchFilterReducer,
    contactInfo: contactinfoReducer,
  },
});

export type ContactRootState = ReturnType<typeof store.getState>;
export type ContactDispatch = typeof store.dispatch;

export const useContactDispatch = () => useDispatch<ContactDispatch>();
export const useContactSelector: TypedUseSelectorHook<ContactRootState> =
  useSelector;

export default store;
