import { createSlice, PayloadAction } from "@reduxjs/toolkit";
import {
  roleType,
  initialRoleType,
} from "../views/RolesOnPolicy/constants/types";

const initialState = {
  roles: [initialRoleType]
}

const Roles = createSlice({
  name: "Roles",
  initialState,
  reducers: {
    addRole(state, action: PayloadAction<roleType>) {
      state.roles = [...state.roles, action.payload];
    },
    resetFields(state) {
      state.roles = initialState.roles;
    },
  },
});

export const actions = Roles.actions;

export default Roles.reducer;
