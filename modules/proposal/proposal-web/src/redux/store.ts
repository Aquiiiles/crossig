import { configureStore } from "@reduxjs/toolkit";
import { TypedUseSelectorHook, useDispatch, useSelector } from "react-redux";
import contactinfoReducer from "./contactInfoSlice";
import basicInfoReducer from "./basicInfoSlice";
import searchFilterReducer from "./searchFilterSlice";
import addressReducer from "./addressSlice";

const store = configureStore({
  reducer: {
    searchFilter: searchFilterReducer,
    basicInfo: basicInfoReducer,
    address: addressReducer,
    contactInfo: contactinfoReducer,
  },
});

export type ContactRootState = ReturnType<typeof store.getState>;
export type ContactDispatch = typeof store.dispatch;

export const useContactDispatch = () => useDispatch<ContactDispatch>();
export const useContactSelector: TypedUseSelectorHook<ContactRootState> =
  useSelector;

export default store;
