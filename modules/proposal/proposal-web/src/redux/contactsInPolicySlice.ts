import { createSlice, PayloadAction } from "@reduxjs/toolkit";
import { roleType } from "../views/RolesOnPolicy/constants/types";

const initialState = {
  contactsInPolicy: new Array<roleType>(),
};

const ContactsInPolicy = createSlice({
  name: "ContactsInPolicy",
  initialState,
  reducers: {
    addContact(state, action: PayloadAction<roleType>) {
      state.contactsInPolicy = [...state.contactsInPolicy, action.payload];
    },
    addRole(state, action: PayloadAction<[number, string]>) {
      const index = action.payload[0];
      const newState = [...state.contactsInPolicy];
      newState[index].contactRoles.push(action.payload[1]);
      state.contactsInPolicy = newState;
    },
    removeRole(state, action: PayloadAction<[number, string]>) {
      const index = action.payload[0];
      const newState = [...state.contactsInPolicy];
      newState[index].contactRoles = newState[index].contactRoles.filter((role) => role != action.payload[1]);
      state.contactsInPolicy = newState;
    },
    resetFields(state) {
      state.contactsInPolicy = initialState.contactsInPolicy;
    },
  },
});

export const actions = ContactsInPolicy.actions;

export default ContactsInPolicy.reducer;
