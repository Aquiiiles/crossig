import { configureStore } from "@reduxjs/toolkit";
import { TypedUseSelectorHook, useDispatch, useSelector } from "react-redux";
import contactinfoReducer from "../views/NewContact/containers/ContactInfo/components/molecules/ContactInfoForm/slice/contactInfoSlice";
import basicInfoReducer from "./basicInfoSlice";

export const getInitialState = () => {
  return configureStore({
    reducer: {
      basicInfo: basicInfoReducer,
      contactInfo: contactinfoReducer,
    },
  });
}

const store = getInitialState();

export type ContactRootState = ReturnType<typeof store.getState>;
export type ContactDispatch = typeof store.dispatch;

export const useContactDispatch = () => useDispatch<ContactDispatch>();
export const useContactSelector: TypedUseSelectorHook<ContactRootState> =
  useSelector;

export default store;