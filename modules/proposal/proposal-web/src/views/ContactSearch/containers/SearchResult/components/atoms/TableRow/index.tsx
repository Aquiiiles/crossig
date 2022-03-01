import React, { useState } from "react";
import { useHistory } from "react-router-dom";
import ClayButton from "@clayui/button";
import ClayTable from "@clayui/table";
import { HoveringButtonGroup } from "./style";
import MissingInformationIcon from "../MissingInformationIcon";
import {
  CONTACT_SEARCH_TABLE_VIEW_DETAILS,
  CONTACT_SEARCH_TABLE_USE_CONTACT,
  CONTACT_SEARCH_TABLE_ADD_TO_POLICY,
  ROLES_ON_POLICY
} from "../../../../../../../constants/languageKeys";
import { useContactDispatch } from "../../../../../../../redux/store";
import { actions } from "../../../../../../../redux/contactsInPolicySlice";

import * as types from "../../../types/searchResult";
import * as constants from "../../../../../constants/searchResult";

interface props {
  contact: types.responseType;
  embedded: boolean;
}

const TableRow: React.FC<props> = ({ contact, embedded }) => {
  const [showButtons, setShowButtons] = useState(false);
  const history = useHistory();

  const dispatch = useContactDispatch();
  const { addContact } = actions;

  const types = {
    Individual: "F",
    "Self Employed": "O",
    "Legal Entity": "P",
  };

  const formatDOB = (date: string): string => {
    try {
      const [year, month, day] = date.split("-");

      return `${day}/${month}/${year}`;
    } catch (error) {
      return "";
    }
  };

  const openUpdateContact = (extNumber: number) => {
    history.push({
      pathname: "/update_contact",
      state: extNumber,
    });
  };

  return (
    <ClayTable.Row
      style={{ position: "relative" }}
      onMouseLeave={() => setShowButtons(false)}
      onMouseEnter={() => setShowButtons(true)}
      onDoubleClick={() => history.push("/product")}
    >
      <ClayTable.Cell headingTitle>
        <MissingInformationIcon
          mailValidated={contact[constants.MAIL_VALIDATED_KEY]}
          phoneNumberValidated={contact[constants.PHONE_NUMBER_VALIDATED_KEY]}
        />
        {contact[constants.OIB_KEY]}
      </ClayTable.Cell>
      <ClayTable.Cell headingTitle>{contact[constants.SUB_KEY]}</ClayTable.Cell>
      <ClayTable.Cell headingTitle>
        {formatDOB(contact[constants.DOB_KEY])}
      </ClayTable.Cell>
      <ClayTable.Cell headingTitle>
        {contact[constants.NAME_KEY]}
      </ClayTable.Cell>
      <ClayTable.Cell headingTitle>
        {contact[constants.STREET_KEY]}
      </ClayTable.Cell>
      <ClayTable.Cell headingTitle>
        {contact[constants.CITY_KEY]}
      </ClayTable.Cell>
      {showButtons ? (
        <HoveringButtonGroup>
          <ClayButton
            displayType="secondary"
            className="ghost"
            onClick={() => openUpdateContact(contact[constants.EXT_NUMBER_KEY])}
          >
            {CONTACT_SEARCH_TABLE_VIEW_DETAILS}
          </ClayButton>
          {embedded ? (
            <ClayButton
              displayType="primary"
              onClick={() =>
                dispatch(
                  addContact({
                    [constants.EXT_NUMBER_KEY]: contact[constants.EXT_NUMBER_KEY],
                    [constants.OIB_KEY]: contact[constants.OIB_KEY],
                    [constants.SUB_KEY]: contact[constants.SUB_KEY],
                    [constants.NAME_KEY]: contact[constants.NAME_KEY],
                    [constants.ROLES_KEY]: [],
                  })
                )
              }
            >
              {CONTACT_SEARCH_TABLE_ADD_TO_POLICY}
            </ClayButton>
          ) : (
            <ClayButton
              displayType="primary"
              onClick={() => {
                addContact({
                  [constants.EXT_NUMBER_KEY]: contact[constants.EXT_NUMBER_KEY],
                  [constants.OIB_KEY]: contact[constants.OIB_KEY],
                  [constants.SUB_KEY]: contact[constants.SUB_KEY],
                  [constants.NAME_KEY]: contact[constants.NAME_KEY],
                  [constants.ROLES_KEY]: [ROLES_ON_POLICY.INSURED],
                });
                history.push("/product");
              }}
            >
              {CONTACT_SEARCH_TABLE_USE_CONTACT}
            </ClayButton>
          )}
        </HoveringButtonGroup>
      ) : (
        <ClayTable.Cell headingTitle>
          {types[contact[constants.TYPE_KEY] as keyof typeof types]}
        </ClayTable.Cell>
      )}
    </ClayTable.Row>
  );
};

export default TableRow;
