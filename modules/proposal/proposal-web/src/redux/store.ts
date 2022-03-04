import { configureStore } from "@reduxjs/toolkit";
import {
  TypedUseSelectorHook,
  useDispatch as useReduxDispatch,
  useSelector as useReduxSelector,
} from "react-redux";

import * as app from "./";

export const store = configureStore({
  reducer: app.reducer,
});

export type RootState = ReturnType<typeof store.getState>;
export type AppDispatch = typeof store.dispatch;

export const useDispatch = () => useReduxDispatch<AppDispatch>();
export const useSelector: TypedUseSelectorHook<RootState> = useReduxSelector;

export const resetState = () => {
  const dispatch = useDispatch();
  dispatch(app.actions.basicInfo.resetFields());
  dispatch(app.actions.contactInfo.resetFields());
  dispatch(app.actions.addresses.resetFields());
  dispatch(app.actions.coveragePlan.resetFields());
  dispatch(app.actions.insuranceProduct.resetFields());
  dispatch(app.actions.contactsInPolicy.resetFields());
};

export default store;
