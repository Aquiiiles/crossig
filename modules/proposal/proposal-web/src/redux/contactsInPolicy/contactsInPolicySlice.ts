import { createSlice, PayloadAction } from "@reduxjs/toolkit";
import { contactInPolicy } from "./types";
import * as constants from "../../constants/RolesOnPolicy";

const initialState = {
  policyHolder: {
    [constants.EXT_NUMBER_KEY]: 0,
    [constants.OIB_KEY]: "",
    [constants.SUB_KEY]: "",
    [constants.NAME_KEY]: "",
    [constants.ROLES_KEY]: new Array<string>(),
  },
  contactsInPolicy: new Array<contactInPolicy>(),
  roleOptions: new Array<string>(),
};

const ContactsInPolicy = createSlice({
  name: "ContactsInPolicy",
  initialState,
  reducers: {
    setPolicyHolder(state, action: PayloadAction<contactInPolicy>) {
      state.policyHolder = action.payload;
    },
    addRoleToPolicyHolder(state, action: PayloadAction<string>) {
      state.policyHolder.contactRoles.push(action.payload);
    },
    removeRoleFromPolicyHolder(state, action: PayloadAction<string>) {
      state.policyHolder.contactRoles = state.policyHolder.contactRoles.filter(
        (role) => role != action.payload
      );
    },
    addContact(state, action: PayloadAction<contactInPolicy>) {
      state.contactsInPolicy = [...state.contactsInPolicy, action.payload];
    },
    addContactRole(state, action: PayloadAction<[number, string]>) {
      const index = action.payload[0];
      const newState = [...state.contactsInPolicy];
      newState[index].contactRoles.push(action.payload[1]);
      state.contactsInPolicy = newState;
    },
    removeContactRole(state, action: PayloadAction<[number, string]>) {
      const index = action.payload[0];
      const newState = [...state.contactsInPolicy];
      newState[index].contactRoles = newState[index].contactRoles.filter(
        (role) => role != action.payload[1]
      );
      state.contactsInPolicy = newState;
    },
    setRoleOptions(state, action: PayloadAction<Array<string>>) {
      state.roleOptions = action.payload;
    },
    resetFields(state) {
      state.policyHolder = initialState.policyHolder;
      state.contactsInPolicy = initialState.contactsInPolicy;
      state.roleOptions = initialState.roleOptions;
    },
  },
});

export const actions = ContactsInPolicy.actions;

export default ContactsInPolicy.reducer;
