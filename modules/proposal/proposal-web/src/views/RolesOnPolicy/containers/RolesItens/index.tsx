import React, { useState } from "react";
import RoleItem from "./RoleItem";
import AddRoleItem from "./AddRoleItem";
import { Wrapper } from "./styles";

interface rolesItens {
  policyHolder: boolean;
  roleOptions: Array<string>;
}

const RolesItens: React.FC<rolesItens> = ({ policyHolder, roleOptions }) => {
  const [roles, setRoles] = useState(["Insured"]);

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
          removeRole={() =>
            setRoles(roles.filter((roleItem) => roleItem != role))
          }
        />
      ))}
      <AddRoleItem
        roleOptions={roleOptions.filter(
          (roleOption) => !roles.includes(roleOption)
        )}
        addRole={(title: string) => setRoles([...roles, title])}
      />
    </Wrapper>
  );
};

export default RolesItens;
