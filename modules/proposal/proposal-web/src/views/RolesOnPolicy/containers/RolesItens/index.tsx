import React from "react";
import RoleItem from "./RoleItem";
import AddRoleItem from "./AddRoleItem";
import { Wrapper } from "./styles";

interface rolesItens {
  policyHolder: boolean;
  roleOptions: Array<string>;
  roles: Array<string>;
  addRole: (title: string) => void;
  removeRole: (title: string) => void;
}

const RolesItens: React.FC<rolesItens> = ({
  policyHolder,
  roleOptions,
  roles,
  addRole,
  removeRole,
}) => {
  return (
    <Wrapper>
      {policyHolder && (
        <RoleItem
          title={"Policy Holder"}
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
    </Wrapper>
  );
};

export default RolesItens;
