import React from "react";
import ClayTable from "@clayui/table";
import { Row } from "./styles";
import RolesItens from "../../RolesItens"

import * as types from "../../../constants/types";
import * as constants from "../../../constants/constants";

interface props {
  contact: types.roleType;
}

const TableRow: React.FC<props> = ({ contact }) => {
  return (
    <Row style={{ position: "relative" }}>
      <ClayTable.Cell headingTitle>{contact[constants.OIB_KEY]}</ClayTable.Cell>
      <ClayTable.Cell headingTitle>{contact[constants.SUB_KEY]}</ClayTable.Cell>
      <ClayTable.Cell headingTitle>
        {contact[constants.NAME_KEY]}
      </ClayTable.Cell>
      <ClayTable.Cell headingTitle>
        <RolesItens policyHolder={true} roles={contact[constants.ROLES_KEY]} />
      </ClayTable.Cell>
    </Row>
  );
};

export default TableRow;
