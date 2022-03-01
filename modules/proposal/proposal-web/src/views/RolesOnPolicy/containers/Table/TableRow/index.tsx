import React, { useState } from "react";
import { useHistory } from "react-router-dom";
import ClayTable from "@clayui/table";
import ClayButton from "@clayui/button";
import { Row, HoveringButtonGroup } from "./styles";
import RolesItens from "../../RolesItens";
import { CONTACT_SEARCH_TABLE_VIEW_DETAILS } from "../../../../../constants/languageKeys";

import * as types from "../../../constants/types";
import * as constants from "../../../constants/constants";

interface props {
  contact: types.contactInPolicy;
  roleOptions: Array<string>;
  policyHolder: boolean;
  addRole: (title: string) => void;
  removeRole: (title: string) => void;
}

const TableRow: React.FC<props> = ({
  contact,
  roleOptions,
  policyHolder,
  addRole,
  removeRole,
}) => {
  const [showButtons, setShowButtons] = useState(false);
  const history = useHistory();

  const openUpdateContact = (extNumber: number) => {
    history.push({
      pathname: "/update_contact",
      state: extNumber,
    });
  };

  return (
    <Row
      onMouseLeave={() => setShowButtons(false)}
      onMouseEnter={() => setShowButtons(true)}
    >
      <ClayTable.Cell>{contact[constants.OIB_KEY] || "0"}</ClayTable.Cell>
      <ClayTable.Cell>{contact[constants.SUB_KEY || "0"]}</ClayTable.Cell>
      <ClayTable.Cell>{contact[constants.NAME_KEY || "-"]}</ClayTable.Cell>
      {showButtons ? (
        <HoveringButtonGroup>
          <ClayButton
            displayType="secondary"
            className="ghost"
            onClick={() => openUpdateContact(contact[constants.EXT_NUMBER_KEY])}
          >
            {CONTACT_SEARCH_TABLE_VIEW_DETAILS}
          </ClayButton>
        </HoveringButtonGroup>
      ) : (
        <ClayTable.Cell>
          <RolesItens
            policyHolder={policyHolder}
            roleOptions={roleOptions}
            roles={contact.contactRoles}
            addRole={addRole}
            removeRole={removeRole}
          />
        </ClayTable.Cell>
      )}
    </Row>
  );
};

export default TableRow;
