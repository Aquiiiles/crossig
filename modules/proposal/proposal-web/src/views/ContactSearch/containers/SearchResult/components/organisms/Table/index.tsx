import React, { useEffect, useRef } from "react";
import ClayTable from "@clayui/table";
import TableRow from "../../atoms/TableRow";

import * as types from "../../../types/searchResult";
import * as constants from "../../../constants/searchResult";

interface props {
  inputData: Array<types.responseType>;
  loading: boolean;
  onTableSort: (sortBy: { sortType: string; sortingKey: any }) => void;
}

const Table: React.FC<props> = ({ inputData, loading, onTableSort }: props) => {
  return (
    <ClayTable borderless>
      <ClayTable.Head>
        <ClayTable.Row>
          <ClayTable.Cell
            style={{ cursor: "pointer" }}
            headingCell
            onClick={() =>
              onTableSort({ sortType: "DESC", sortingKey: constants.OIB_KEY })
            }
          >
            {constants.OIB_NAME}
          </ClayTable.Cell>
          <ClayTable.Cell
            style={{ cursor: "pointer" }}
            headingCell
            onClick={() =>
              onTableSort({ sortType: "DESC", sortingKey: constants.SUB_KEY })
            }
          >
            {constants.SUB_NAME}
          </ClayTable.Cell>
          <ClayTable.Cell
            style={{ cursor: "pointer" }}
            headingCell
            onClick={() =>
              onTableSort({ sortType: "DESC", sortingKey: constants.DOB_KEY })
            }
          >
            {constants.DOB_NAME}
          </ClayTable.Cell>
          <ClayTable.Cell
            style={{ cursor: "pointer" }}
            expanded
            headingCell
            onClick={() =>
              onTableSort({ sortType: "DESC", sortingKey: constants.NAME_KEY })
            }
          >
            {constants.NAME_NAME}
          </ClayTable.Cell>
          <ClayTable.Cell
            style={{ cursor: "pointer" }}
            expanded
            headingCell
            onClick={() =>
              onTableSort({
                sortType: "DESC",
                sortingKey: constants.STREET_KEY,
              })
            }
          >
            {constants.STREET_NAME}
          </ClayTable.Cell>
          <ClayTable.Cell
            style={{ cursor: "pointer" }}
            headingCell
            onClick={() =>
              onTableSort({ sortType: "DESC", sortingKey: constants.CITY_KEY })
            }
          >
            {constants.CITY_NAME}
          </ClayTable.Cell>
          <ClayTable.Cell
            style={{ cursor: "pointer" }}
            headingCell
            onClick={() =>
              onTableSort({ sortType: "DESC", sortingKey: constants.TYPE_KEY })
            }
          >
            {constants.TYPE_NAME}
          </ClayTable.Cell>
        </ClayTable.Row>
      </ClayTable.Head>
      <ClayTable.Body>
        {inputData.map((item: types.responseType) => (
          <TableRow key={item.idValue} contact={item} />
        ))}
      </ClayTable.Body>
    </ClayTable>
  );
};

export default Table;
