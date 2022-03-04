import { combineReducers } from "redux";

import * as addresses from "./addresses/addressesSlice";
import * as basicInfo from "./basicInfo/basicInfoSlice";
import * as contactInfo from "./contactInfo/contactInfoSlice";
import * as searchFilter from "./searchFilter/searchFilterSlice";
import * as vesselLookupFilter from "./vessel/vesselLookupSlice";

export const reducer = combineReducers({
  addresses: addresses.default,
  basicInfo: basicInfo.default,
  contactInfo: contactInfo.default,
  searchFilter: searchFilter.default,
  vesselLookupFilter: vesselLookupFilter.default,
});

export const actions = Object.freeze({
  addresses: addresses.actions,
  basicInfo: basicInfo.actions,
  contactInfo: contactInfo.actions,
  searchFilter: searchFilter.actions,
  vesselLookupFilter: vesselLookupFilter.actions,
});
