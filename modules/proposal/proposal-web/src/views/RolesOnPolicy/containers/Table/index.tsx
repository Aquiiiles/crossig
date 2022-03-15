import React from "react";
import ClayTable from "@clayui/table";
import TableRow from "./TableRow";
import AddRoleRow from "./AddRoleRow";
import { useSelector, useDispatch } from "../../../../redux/store";
import { actions } from "../../../../redux";
import { ResultsTable } from "./styles";

import * as constants from "../../../../constants/RolesOnPolicy";
import { Wrapper } from "./styles";

const Table: React.FC<{ hasInsuredRole: boolean }> = ({ hasInsuredRole }) => {
  const dispatch = useDispatch();
  const { policyHolder, contactsInPolicy } = useSelector(
    (state) => state.contactsInPolicy
  );
  const {
    addRoleToPolicyHolder,
    removeRoleFromPolicyHolder,
    addContactRole,
    removeContactRole,
  } = actions.contactsInPolicy;

  return (
    <Wrapper>
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
          <TableRow
            key={0}
            contact={policyHolder}
            policyHolder={true}
            addRole={(title: string) => dispatch(addRoleToPolicyHolder(title))}
            removeRole={(title: string) =>
              dispatch(removeRoleFromPolicyHolder(title))
            }
          />
          {contactsInPolicy.map((contact, index) => (
            <TableRow
              key={index}
              contact={contact}
              policyHolder={false}
              addRole={(title: string) =>
                dispatch(addContactRole([index, title]))
              }
              removeRole={(title: string) =>
                dispatch(removeContactRole([index, title]))
              }
            />
          ))}
        </ClayTable.Body>
        <AddRoleRow hasInsuredRole={hasInsuredRole} />
      </ResultsTable>
    </Wrapper>
  );
};

export default Table;
