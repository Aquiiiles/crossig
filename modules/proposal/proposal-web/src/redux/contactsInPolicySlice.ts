import { createSlice, PayloadAction } from "@reduxjs/toolkit";
import { contactInPolicy } from "../views/RolesOnPolicy/constants/types";

const initialState = {
  contactsInPolicy: new Array<contactInPolicy>(),
  roleOptions: new Array<string>(),
};

const ContactsInPolicy = createSlice({
  name: "ContactsInPolicy",
  initialState,
  reducers: {
    addContact(state, action: PayloadAction<contactInPolicy>) {
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
      newState[index].contactRoles = newState[index].contactRoles.filter(
        (role) => role != action.payload[1]
      );
      state.contactsInPolicy = newState;
    },
    setRoleOptions(state, action: PayloadAction<Array<string>>) {
      state.roleOptions = action.payload;
    },
    resetFields(state) {
      state.contactsInPolicy = initialState.contactsInPolicy;
      state.roleOptions = initialState.roleOptions;
    },
  },
});

export const actions = ContactsInPolicy.actions;

export default ContactsInPolicy.reducer;
