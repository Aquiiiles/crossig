import React, { useState } from "react";
import ClayButton from "@clayui/button";
import ClayDropDown from "@clayui/drop-down";
import { ClayCheckbox } from "@clayui/form";
import { RolesWrapper, Buttons, Background } from "./styles";
import languageKeys from "../../../../../../../constants/Language";
import { useDispatch, useSelector } from "../../../../../../../redux/store";
import { actions } from "../../../../../../../redux";
import LinkWrapper from "../../../../../../../shared/atoms/LinkWrapper";
import * as types from "../../../types";
import * as constants from "../../../../../constants/searchResult";

const { CONTACT_SEARCH, ROLES_ON_POLICY } = languageKeys;

const AddToPolicyBtn: React.FC<{
  contact: types.responseType;
  isMobile: boolean;
}> = ({ contact, isMobile }) => {
  const dispatch = useDispatch();
  const { addContact, setShowMobileSearch } = actions.contactsInPolicy;
  const { roleOptions } = useSelector((state) => state.contactsInPolicy);

  const [active, setActive] = useState(false);
  const [selectedRole, setSelectedRole] = useState<string>("");

  const addToPolicy = (role: string) => {
    dispatch(
      addContact({
        [constants.EXT_NUMBER_KEY]: contact[constants.EXT_NUMBER_KEY],
        [constants.OIB_KEY]: contact[constants.OIB_KEY],
        [constants.SUB_KEY]: contact[constants.SUB_KEY],
        [constants.NAME_KEY]: contact[constants.NAME_KEY],
        [constants.ROLES_KEY]: [role],
      })
    );
  };

  return (
    <>
      {isMobile ? (
        <>
          <ClayButton displayType="primary" onClick={() => setActive(true)}>
            {CONTACT_SEARCH.TABLE.ADD_TO_POLICY}
          </ClayButton>
          {active ? (
            <>
              <RolesWrapper>
                {roleOptions.map((role, index) => (
                  <ClayCheckbox
                    aria-label={role}
                    checked={selectedRole === role}
                    onChange={() =>
                      selectedRole === role
                        ? setSelectedRole("")
                        : setSelectedRole(role)
                    }
                    label={role}
                    key={index}
                  />
                ))}
                <Buttons>
                  <ClayButton
                    displayType="primary"
                    onClick={() => {
                      if (selectedRole.length > 0) {
                        addToPolicy(selectedRole);
                        dispatch(setShowMobileSearch(false));
                      }
                    }}
                  >
                    APPLY
                  </ClayButton>
                  <LinkWrapper
                    title={"Cancel"}
                    handleClick={() => setActive(false)}
                    disabled={false}
                  />
                </Buttons>
              </RolesWrapper>
              <Background />
            </>
          ) : null}
        </>
      ) : (
        <ClayDropDown
          active={active}
          onActiveChange={setActive}
          trigger={
            <ClayButton
              displayType="primary"
              onClick={() => setActive(!active)}
            >
              {CONTACT_SEARCH.TABLE.ADD_TO_POLICY}
            </ClayButton>
          }
          style={{ marginLeft: "0.5rem" }}
        >
          <ClayDropDown.ItemList>
            {roleOptions && roleOptions?.length > 0 ? (
              roleOptions.map((role, index) => (
                <ClayDropDown.Item
                  key={index}
                  onClick={() => {
                    addToPolicy(role);
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
      )}
    </>
  );
};

export default AddToPolicyBtn;
