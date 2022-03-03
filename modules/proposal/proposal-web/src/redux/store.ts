import { configureStore } from "@reduxjs/toolkit";
import { TypedUseSelectorHook, useDispatch, useSelector } from "react-redux";
import searchFilterReducer from "./searchFilterSlice";

import basicInfoReducer, {
  actions as basicInfoActions,
} from "./basicInfoSlice";

import contactInfoReducer, {
  actions as contactInfoActions,
} from "./contactInfoSlice";

import addressesReducer, {
  actions as addressesActions,
} from "./addressesSlice";

import contactsInPolicyReducer from "./contactsInPolicySlice";

export const createContactStore = () => {
  return configureStore({
    reducer: {
      basicInfo: basicInfoReducer,
      addresses: addressesReducer,
      searchFilter: searchFilterReducer,
      contactInfo: contactInfoReducer,
      contactsInPolicy: contactsInPolicyReducer,
    },
  });
};

const store = createContactStore();

export type ContactRootState = ReturnType<typeof store.getState>;
export type ContactDispatch = typeof store.dispatch;

export const useContactDispatch = () => useDispatch<ContactDispatch>();
export const useContactSelector: TypedUseSelectorHook<ContactRootState> =
  useSelector;

export const resetState = () => {
  const dispatch = useContactDispatch();
  dispatch(basicInfoActions.resetFields());
  dispatch(contactInfoActions.resetFields());
  dispatch(addressesActions.resetFields());
};

export default store;
