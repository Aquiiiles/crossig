import React, { useState } from "react";
import RoleItem from "../RoleItem";
import languageKeys from "../../../../../constants/Language";
import ClayDropDown from "@clayui/drop-down";

const { ROLES_ON_POLICY } = languageKeys;

const AddRoleItem: React.FC<{
  roleOptions: Array<string>;
  addRole: (title: string) => void;
}> = ({ roleOptions, addRole }) => {
  const [active, setActive] = useState(false);

  return (
    <ClayDropDown
      active={active}
      onActiveChange={setActive}
      trigger={
        <div onClick={() => setActive(!active)}>
          <RoleItem
            title={"+"}
            removable={false}
            removeRole={() => {
              return;
            }}
          />
        </div>
      }
    >
      <ClayDropDown.ItemList>
        {roleOptions && roleOptions?.length > 0 ? (
          roleOptions.map((role, index) => (
            <ClayDropDown.Item
              key={index}
              onClick={() => {
                addRole(role);
                setActive(false);
              }}
            >
              {role}
            </ClayDropDown.Item>
          ))
        ) : (
          <ClayDropDown.Item disabled>
            {ROLES_ON_POLICY.NO_OPTIONS}
          </ClayDropDown.Item>
        )}
      </ClayDropDown.ItemList>
    </ClayDropDown>
  );
};

export default AddRoleItem;
