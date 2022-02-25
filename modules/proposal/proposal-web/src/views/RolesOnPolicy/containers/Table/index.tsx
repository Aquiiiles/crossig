import React from "react";
import ClayTable from "@clayui/table";
import TableRow from "./TableRow";
import spritemap from "@clayui/css/lib/images/icons/icons.svg";
import ClayIcon from "@clayui/icon";
import {
  useContactSelector,
  useContactDispatch,
} from "../../../../redux/store";
import { actions } from "../../../../redux/searchFilterSlice";
import { ResultsTable, Span } from "./styles";

import * as types from "../../constants/types";
import * as constants from "../../constants/constants";

const Table: React.FC = () => {
  const dispatch = useContactDispatch();
  const { sortedBy, sortOrder } = useContactSelector(
    (state) => state.searchFilter
  );
  const { setSortedBy, setSortOrder } = actions;

  const { firstName, lastName, oib, subsidiaryNumber } = useContactSelector(
    (state) => state.basicInfo
  );

  const contact = {
    [constants.NAME_KEY] : firstName + lastName,
    [constants.OIB_KEY]: oib,
    [constants.SUB_KEY]: subsidiaryNumber,
    [constants.ROLES_KEY]: []
  }

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
            style={{ cursor: "pointer" }}
            headingCell
            onClick={() => {
              dispatch(setSortedBy(constants.OIB_KEY));
              dispatch(setSortOrder(decideOrder(constants.OIB_KEY)));
            }}
          >
            <Span />
            {constants.OIB_NAME}
            {sortedBy === constants.OIB_KEY ? arrowIcon : null}
          </ClayTable.Cell>
          <ClayTable.Cell
            style={{ cursor: "pointer" }}
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
            style={{ cursor: "pointer" }}
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
            style={{ cursor: "pointer" }}
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
        <TableRow key={1} contact={contact} />
      </ClayTable.Body>
    </ResultsTable>
  );
};

export default Table;
