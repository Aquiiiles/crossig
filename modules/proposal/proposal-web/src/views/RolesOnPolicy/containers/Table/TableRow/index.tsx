import React, { useState } from "react";
import { useHistory } from "react-router-dom";
import ClayTable from "@clayui/table";
import { Row, ViewDetailsBtn, Wrapper } from "./styles";
import RolesItens from "../../RolesItens";
import { CONTACT_SEARCH_TABLE_VIEW_DETAILS } from "../../../../../constants/languageKeys";

import * as types from "../../../../../redux/contactsInPolicy/types";
import * as constants from "../../../../../constants/RolesOnPolicy";
import { contactOperations } from "../../../../../constants/contactConstants";

interface props {
  contact: types.contactInPolicy;
  policyHolder: boolean;
  addRole: (title: string) => void;
  removeRole: (title: string) => void;
}

const TableRow: React.FC<props> = ({
  contact,
  policyHolder,
  addRole,
  removeRole,
}) => {
  const [showDetails, setShowDetails] = useState(false);
  const history = useHistory();

  const openUpdateContact = (extNumber: number) => {
    history.push({
      pathname: "/update_contact",
      state: { extNumber, operation: contactOperations.updateReadOnly },
    });
  };

  return (
    <Row
      onMouseLeave={() => setShowDetails(false)}
      onMouseEnter={() => setShowDetails(true)}
    >
      <ClayTable.Cell>{contact[constants.OIB_KEY] || "0"}</ClayTable.Cell>
      <ClayTable.Cell>{contact[constants.SUB_KEY] || "0"}</ClayTable.Cell>
      <ClayTable.Cell>{contact[constants.NAME_KEY] || "-"}</ClayTable.Cell>
      <ClayTable.Cell>
        <Wrapper>
          <RolesItens
            policyHolder={policyHolder}
            roles={contact.contactRoles}
            addRole={addRole}
            removeRole={removeRole}
          />
          <ViewDetailsBtn
            displayType="secondary"
            className="ghost"
            onClick={() => openUpdateContact(contact[constants.EXT_NUMBER_KEY])}
            showDetails={showDetails}
          >
            {CONTACT_SEARCH_TABLE_VIEW_DETAILS}
          </ViewDetailsBtn>
        </Wrapper>
      </ClayTable.Cell>
    </Row>
  );
};

export default TableRow;
