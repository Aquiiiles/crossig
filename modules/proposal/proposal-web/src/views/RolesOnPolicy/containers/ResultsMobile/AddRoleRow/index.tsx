import React from "react";
import { Wrapper } from "./styles";
import { ROLES_ON_POLICY } from "../../../../../constants/languageKeys";
import { actions } from "../../../../../redux/";
import { useDispatch } from "../../../../../redux/store";

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
