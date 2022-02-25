import React from "react";
import RoleItem from "./RoleItem";
import { Wrapper } from "./styles";

interface rolesItens {
  policyHolder: boolean;
  roles: Array<string>;
}

const RolesItens: React.FC<rolesItens> = ({ policyHolder, roles }) => {
  return (
    <Wrapper>
      {policyHolder && <RoleItem title={"Policy Holder"} removable={false} />}
      {roles.map((role, index) => (
        <RoleItem key={index} title={role} removable={true} />
      ))}
      <RoleItem title={"+"} removable={false} />
    </Wrapper>
  );
};

export default RolesItens;
