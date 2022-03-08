import React from "react";
import ClayTable from "@clayui/table";
import TableRow from "./TableRow";
import AddRoleRow from "./AddRoleRow";
import { useSelector, useDispatch } from "../../../../redux/store";
import { actions } from "../../../../redux";
import { ResultsTable } from "./styles";

import * as constants from "../../../../constants/RolesOnPolicy";

const Table: React.FC<{ hasInsuredRole: boolean }> = ({ hasInsuredRole }) => {
  const dispatch = useDispatch();
  const { contactsInPolicy } = useSelector((state) => state.contactsInPolicy);
  const { addRole, removeRole } = actions.contactsInPolicy;

  return (
    <ResultsTable borderless>
      <ClayTable.Head>
        <ClayTable.Row>
          <ClayTable.Cell headingCell>{constants.OIB_NAME}</ClayTable.Cell>
          <ClayTable.Cell headingCell>{constants.SUB_NAME}</ClayTable.Cell>
          <ClayTable.Cell expanded headingCell>
            {constants.NAME_NAME}
          </ClayTable.Cell>
          <ClayTable.Cell expanded headingCell>
            {constants.ROLES_NAME}
          </ClayTable.Cell>
        </ClayTable.Row>
      </ClayTable.Head>
      <ClayTable.Body>
        {contactsInPolicy.map((contact, index) => (
          <TableRow
            key={index}
            contact={contact}
            policyHolder={index === 0}
            addRole={(title: string) => dispatch(addRole([index, title]))}
            removeRole={(title: string) => dispatch(removeRole([index, title]))}
          />
        ))}
      </ClayTable.Body>
      <AddRoleRow hasInsuredRole={hasInsuredRole} />
    </ResultsTable>
  );
};

export default Table;
