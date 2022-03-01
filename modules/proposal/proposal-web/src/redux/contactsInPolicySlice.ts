import { createSlice, PayloadAction } from "@reduxjs/toolkit";
import { roleType } from "../views/RolesOnPolicy/constants/types";

const initialState = {
  contactsInPolicy: new Array<roleType>(),
};

const ContactsInPolicy = createSlice({
  name: "ContactsInPolicy",
  initialState,
  reducers: {
    addRole(state, action: PayloadAction<roleType>) {
      state.contactsInPolicy = [...state.contactsInPolicy, action.payload];
    },
    resetFields(state) {
      state.contactsInPolicy = initialState.contactsInPolicy;
    },
  },
});

export const actions = ContactsInPolicy.actions;

export default ContactsInPolicy.reducer;
