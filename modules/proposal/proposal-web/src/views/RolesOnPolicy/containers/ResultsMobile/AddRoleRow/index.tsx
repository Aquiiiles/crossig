import React from "react";
import { Wrapper } from "./styles";
import { actions } from "../../../../../redux/";
import languageKeys from "../../../../../constants/Language";
import { useDispatch } from "../../../../../redux/store";

const { ROLES_ON_POLICY } = languageKeys;

const AddRoleRow: React.FC = () => {
  const dispatch = useDispatch();
  const { setShowMobileSearch } = actions.contactsInPolicy;

  return (
    <Wrapper>
      <p
        onClick={() => dispatch(setShowMobileSearch(true))}
        className="add-role"
      >
        {ROLES_ON_POLICY.ADD_ROLE + "  "}
      </p>
    </Wrapper>
  );
};

export default AddRoleRow;
