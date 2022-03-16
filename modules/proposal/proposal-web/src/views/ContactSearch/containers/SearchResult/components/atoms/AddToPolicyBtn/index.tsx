import React, { useState } from "react";
import ClayButton from "@clayui/button";
import ClayDropDown from "@clayui/drop-down";
import {
  CONTACT_SEARCH_TABLE_ADD_TO_POLICY,
  ROLES_ON_POLICY,
} from "../../../../../../../constants/languageKeys";
import { useDispatch, useSelector } from "../../../../../../../redux/store";
import { actions } from "../../../../../../../redux";

import * as types from "../../../types/searchResult";
import * as constants from "../../../../../constants/searchResult";

const AddToPolicyBtn: React.FC<{
  contact: types.responseType;
  isMobile: boolean;
}> = ({ contact, isMobile }) => {
  const dispatch = useDispatch();
  const { addContact, setShowMobileSearch } = actions.contactsInPolicy;
  const { roleOptions } = useSelector((state) => state.contactsInPolicy);

  const [active, setActive] = useState(false);

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
          <ClayButton
            displayType="primary"
            onClick={() => {
              addToPolicy("Insured");
              dispatch(setShowMobileSearch(false));
            }}
          >
            {CONTACT_SEARCH_TABLE_ADD_TO_POLICY}
          </ClayButton>
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
