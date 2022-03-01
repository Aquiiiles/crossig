import React from "react";
import ClayTable from "@clayui/table";
import { Row } from "./styles";
import RolesItens from "../../RolesItens";

import * as types from "../../../constants/types";
import * as constants from "../../../constants/constants";

interface props {
  contact: types.roleType;
  roleOptions: Array<string>;
  policyHolder: boolean;
}

const TableRow: React.FC<props> = ({ contact, roleOptions, policyHolder }) => {
  return (
    <Row>
      <ClayTable.Cell headingTitle>{contact[constants.OIB_KEY]}</ClayTable.Cell>
      <ClayTable.Cell headingTitle>{contact[constants.SUB_KEY]}</ClayTable.Cell>
      <ClayTable.Cell headingTitle>
        {contact[constants.NAME_KEY]}
      </ClayTable.Cell>
      <ClayTable.Cell headingTitle>
        <RolesItens
          policyHolder={policyHolder}
          roleOptions={roleOptions}
          initialRoles={contact.contactRoles}
        />
      </ClayTable.Cell>
    </Row>
  );
};

export default TableRow;
