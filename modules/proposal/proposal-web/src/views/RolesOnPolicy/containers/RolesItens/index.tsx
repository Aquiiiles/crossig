import React from "react";
import RoleItem from "./RoleItem";
import AddRoleItem from "./AddRoleItem";
import { Wrapper, Roles } from "./styles";
import { ROLES_ON_POLICY } from "../../../../constants/languageKeys";
import { useSelector } from "../../../../redux/store";
import * as constants from "../../../../constants/RolesOnPolicy";

interface rolesItens {
  policyHolder: boolean;
  roles: Array<string>;
  addRole: (title: string) => void;
  removeRole: (title: string) => void;
}

const RolesItens: React.FC<rolesItens> = ({
  policyHolder,
  roles,
  addRole,
  removeRole,
}) => {
  const { roleOptions } = useSelector((state) => state.contactsInPolicy);

  return (
    <Wrapper>
      <h6 className="h10">{constants.ROLES_NAME}</h6>
      <Roles>
        {policyHolder && (
          <RoleItem
            title={ROLES_ON_POLICY.POLICY_HOLDER}
            removable={false}
            removeRole={() => {
              return;
            }}
          />
        )}
        {roles.map((role, index) => (
          <RoleItem
            key={index}
            title={role}
            removable={true}
            removeRole={() => removeRole(role)}
          />
        ))}
        <AddRoleItem
          roleOptions={roleOptions.filter(
            (roleOption) => !roles.includes(roleOption)
          )}
          addRole={(title: string) => addRole(title)}
        />
      </Roles>
    </Wrapper>
  );
};

export default RolesItens;
