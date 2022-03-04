import React from "react";
import ClayTable from "@clayui/table";
import TableRow from "../../atoms/TableRow";
import spritemap from "@clayui/css/lib/images/icons/icons.svg";
import ClayIcon from "@clayui/icon";
import { useSelector, useDispatch } from "../../../../../../../redux/store";
import { actions } from "../../../../../../../redux";
import { ResultsTable, Span } from "./styles";

import * as types from "../../../types/searchResult";
import * as constants from "../../../../../constants/searchResult";

interface props {
  inputData: Array<types.responseType>;
  loading: boolean;
  embedded: boolean;
}

const Table: React.FC<props> = ({ inputData, loading, embedded }: props) => {
  const dispatch = useDispatch();
  const { sortedBy, sortOrder } = useSelector((state) => state.searchFilter);
  const { setSortedBy, setSortOrder } = actions.searchFilter;

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
            headingCell
            onClick={() => {
              dispatch(setSortedBy(constants.DOB_KEY));
              dispatch(setSortOrder(decideOrder(constants.DOB_KEY)));
            }}
          >
            {constants.DOB_NAME}
            {sortedBy === constants.DOB_KEY ? arrowIcon : null}
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
              dispatch(setSortedBy(constants.STREET_KEY));
              dispatch(setSortOrder(decideOrder(constants.STREET_KEY)));
            }}
          >
            {constants.STREET_NAME}
            {sortedBy === constants.STREET_KEY ? arrowIcon : null}
          </ClayTable.Cell>
          <ClayTable.Cell
            style={{ cursor: "pointer" }}
            headingCell
            onClick={() => {
              dispatch(setSortedBy(constants.CITY_KEY));
              dispatch(setSortOrder(decideOrder(constants.CITY_KEY)));
            }}
          >
            {constants.CITY_NAME}
            {sortedBy === constants.CITY_KEY ? arrowIcon : null}
          </ClayTable.Cell>
          <ClayTable.Cell
            style={{ cursor: "pointer" }}
            headingCell
            onClick={() => {
              dispatch(setSortedBy(constants.TYPE_KEY));
              dispatch(setSortOrder(decideOrder(constants.TYPE_KEY)));
            }}
          >
            {constants.TYPE_NAME}
            {sortedBy === constants.TYPE_KEY ? arrowIcon : null}
          </ClayTable.Cell>
        </ClayTable.Row>
      </ClayTable.Head>
      <ClayTable.Body>
        {inputData.map((item: types.responseType) => (
          <TableRow key={item.idValue} contact={item} embedded={embedded} />
        ))}
      </ClayTable.Body>
    </ResultsTable>
  );
};

export default Table;
