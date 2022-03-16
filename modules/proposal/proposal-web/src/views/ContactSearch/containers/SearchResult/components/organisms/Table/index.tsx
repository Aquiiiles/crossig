import React from "react";
import ClayTable from "@clayui/table";
import TableRow from "../../atoms/TableRow";
import spritemap from "@clayui/css/lib/images/icons/icons.svg";
import ClayIcon from "@clayui/icon";
import { ResultsTable, Span } from "./styles";

import * as types from "../../../types/searchResult";
import * as constants from "../../../../../constants/searchResult";
import useSort from "../../../../../../../shared/hooks/useSort";

interface props {
  inputData: Array<types.responseType>;
  loading: boolean;
  embedded: boolean;
}

const Table: React.FC<props> = ({ inputData, loading, embedded }: props) => {
  const [{ sortedBy, sortOrder }, { handleSort }] = useSort("searchFilter");

  const arrowIcon = (
    <ClayIcon
      spritemap={spritemap}
      symbol={sortOrder === "asc" ? "order-arrow-up" : "order-arrow-down"}
    />
  );

  return (
    <ResultsTable borderless className="desktop-only">
      <ClayTable.Head>
        <ClayTable.Row>
          <ClayTable.Cell
            style={{ cursor: "pointer" }}
            headingCell
            onClick={() => handleSort(constants.OIB_KEY)}
          >
            <Span />
            {constants.OIB_NAME}
            {sortedBy === constants.OIB_KEY ? arrowIcon : null}
          </ClayTable.Cell>
          <ClayTable.Cell
            style={{ cursor: "pointer", whiteSpace: "nowrap" }}
            headingCell
            onClick={() => handleSort(constants.SUB_KEY)}
          >
            {constants.SUB_NAME}
            {sortedBy === constants.SUB_KEY ? arrowIcon : null}
          </ClayTable.Cell>
          <ClayTable.Cell
            style={{ cursor: "pointer" }}
            headingCell
            onClick={() => handleSort(constants.DOB_KEY)}
          >
            {constants.DOB_NAME}
            {sortedBy === constants.DOB_KEY ? arrowIcon : null}
          </ClayTable.Cell>
          <ClayTable.Cell
            style={{ cursor: "pointer" }}
            expanded
            headingCell
            onClick={() => handleSort(constants.NAME_KEY)}
          >
            {constants.NAME_NAME}
            {sortedBy === constants.NAME_KEY ? arrowIcon : null}
          </ClayTable.Cell>
          <ClayTable.Cell
            style={{ cursor: "pointer" }}
            expanded
            headingCell
            onClick={() => handleSort(constants.STREET_KEY)}
          >
            {constants.STREET_NAME}
            {sortedBy === constants.STREET_KEY ? arrowIcon : null}
          </ClayTable.Cell>
          <ClayTable.Cell
            style={{ cursor: "pointer" }}
            headingCell
            onClick={() => handleSort(constants.CITY_KEY)}
          >
            {constants.CITY_NAME}
            {sortedBy === constants.CITY_KEY ? arrowIcon : null}
          </ClayTable.Cell>
          <ClayTable.Cell
            style={{ cursor: "pointer" }}
            headingCell
            onClick={() => handleSort(constants.TYPE_KEY)}
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
