import React, { useState } from "react";
import ClayButton from "@clayui/button";
import ClayDropDown from "@clayui/drop-down";
import {
  CONTACT_SEARCH_TABLE_ADD_TO_POLICY,
  ROLES_ON_POLICY,
} from "../../../../../../../constants/languageKeys";
import {
  useContactDispatch,
  useContactSelector,
} from "../../../../../../../redux/store";
import { actions } from "../../../../../../../redux/contactsInPolicySlice";

import * as types from "../../../types/searchResult";
import * as constants from "../../../../../constants/searchResult";

const AddToPolicyBtn: React.FC<{ contact: types.responseType }> = ({
  contact,
}) => {
  const dispatch = useContactDispatch();
  const { addContact } = actions;
  const { roleOptions } = useContactSelector((state) => state.contactsInPolicy);

  const [active, setActive] = useState(false);

  return (
    <ClayDropDown
      active={active}
      onActiveChange={setActive}
      trigger={
        <ClayButton displayType="primary" onClick={() => setActive(!active)}>
          {CONTACT_SEARCH_TABLE_ADD_TO_POLICY}
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
                dispatch(
                  addContact({
                    [constants.EXT_NUMBER_KEY]:
                      contact[constants.EXT_NUMBER_KEY],
                    [constants.OIB_KEY]: contact[constants.OIB_KEY],
                    [constants.SUB_KEY]: contact[constants.SUB_KEY],
                    [constants.NAME_KEY]: contact[constants.NAME_KEY],
                    [constants.ROLES_KEY]: [role],
                  })
                );
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

export default AddToPolicyBtn;
