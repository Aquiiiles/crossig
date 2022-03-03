import { configureStore } from "@reduxjs/toolkit";
import { TypedUseSelectorHook, useDispatch, useSelector } from "react-redux";
import lookupSlice from "./lookupSlice";

export const createVesselsStore = () => {
  return configureStore({
    reducer: {
      lookupFilter: lookupSlice,
    },
  });
};

const store = createVesselsStore();

export type VesselRootState = ReturnType<typeof store.getState>;
export type VesselDispatch = typeof store.dispatch;

export const useVesselDispatch = () => useDispatch<VesselDispatch>();
export const useVesselSelector: TypedUseSelectorHook<VesselRootState> =
  useSelector;


export default store;
