import React from "react";
import ClayTable from "@clayui/table";
import TableRow from "./TableRow";
import AddRoleRow from "./AddRoleRow";
import spritemap from "@clayui/css/lib/images/icons/icons.svg";
import ClayIcon from "@clayui/icon";
import {
  useContactSelector,
  useContactDispatch,
} from "../../../../redux/store";
import { actions } from "../../../../redux/searchFilterSlice";
import { actions as contactActions } from "../../../../redux/contactsInPolicySlice";
import { ResultsTable } from "./styles";

import * as constants from "../../constants/constants";

const Table: React.FC<{ hasInsuredRole: boolean }> = ({ hasInsuredRole }) => {
  const dispatch = useContactDispatch();
  const { sortedBy, sortOrder } = useContactSelector(
    (state) => state.searchFilter
  );
  const { setSortedBy, setSortOrder } = actions;

  const { contactsInPolicy } = useContactSelector(
    (state) => state.contactsInPolicy
  );
  const { addRole, removeRole } = contactActions;

  const decideOrder = (sortBy: string) => {
    if (sortBy === sortedBy) {
      return sortOrder === "asc" ? "desc" : "asc";
    } else {
      return "desc";
    }
  };

  const arrowIcon = (
    <ClayIcon
      spritemap={spritemap}
      symbol={sortOrder === "asc" ? "order-arrow-up" : "order-arrow-down"}
    />
  );

  return (
    <ResultsTable borderless>
      <ClayTable.Head>
        <ClayTable.Row>
          <ClayTable.Cell
            headingCell
            onClick={() => {
              dispatch(setSortedBy(constants.OIB_KEY));
              dispatch(setSortOrder(decideOrder(constants.OIB_KEY)));
            }}
          >
            {constants.OIB_NAME}
            {sortedBy === constants.OIB_KEY ? arrowIcon : null}
          </ClayTable.Cell>
          <ClayTable.Cell
            headingCell
            onClick={() => {
              dispatch(setSortedBy(constants.SUB_KEY));
              dispatch(setSortOrder(decideOrder(constants.SUB_KEY)));
            }}
          >
            {constants.SUB_NAME}
            {sortedBy === constants.SUB_KEY ? arrowIcon : null}
          </ClayTable.Cell>
          <ClayTable.Cell
            expanded
            headingCell
            onClick={() => {
              dispatch(setSortedBy(constants.NAME_KEY));
              dispatch(setSortOrder(decideOrder(constants.NAME_KEY)));
            }}
          >
            {constants.NAME_NAME}
            {sortedBy === constants.NAME_KEY ? arrowIcon : null}
          </ClayTable.Cell>
          <ClayTable.Cell
            expanded
            headingCell
            onClick={() => {
              dispatch(setSortedBy(constants.ROLES_KEY));
              dispatch(setSortOrder(decideOrder(constants.ROLES_KEY)));
            }}
          >
            {constants.ROLES_NAME}
            {sortedBy === constants.ROLES_KEY ? arrowIcon : null}
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
        <AddRoleRow hasInsuredRole={hasInsuredRole} />
      </ClayTable.Body>
    </ResultsTable>
  );
};

export default Table;
