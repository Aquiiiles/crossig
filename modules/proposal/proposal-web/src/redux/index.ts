import { combineReducers } from "redux";

import * as addresses from "./addresses/addressesSlice";
import * as basicInfo from "./basicInfo/basicInfoSlice";
import * as contactInfo from "./contactInfo/contactInfoSlice";
import * as searchFilter from "./searchFilter/searchFilterSlice";
import * as vesselLookupFilter from "./vesselLookup/vesselLookupSlice";
import * as contactsInPolicy from "./contactsInPolicy/contactsInPolicySlice";
import * as coveragePlan from "./coveragePlan/coveragePlanSlice";
import * as insuranceProduct from "./insuranceProduct/insuranceProductSlice";
import * as proposal from "./proposal/proposalSlice";

export const reducer = combineReducers({
  addresses: addresses.default,
  basicInfo: basicInfo.default,
  contactInfo: contactInfo.default,
  contactsInPolicy: contactsInPolicy.default,
  coveragePlan: coveragePlan.default,
  insuranceProduct: insuranceProduct.default,
  searchFilter: searchFilter.default,
  vesselLookupFilter: vesselLookupFilter.default,
  proposal: proposal.default,
});

export const actions = Object.freeze({
  addresses: addresses.actions,
  basicInfo: basicInfo.actions,
  contactInfo: contactInfo.actions,
  contactsInPolicy: contactsInPolicy.actions,
  coveragePlan: coveragePlan.actions,
  insuranceProduct: insuranceProduct.actions,
  searchFilter: searchFilter.actions,
  vesselLookupFilter: vesselLookupFilter.actions,
  proposal: proposal.actions,
});

export type ActionsType = typeof actions;
