import React, { useEffect, useRef } from "react";
import ClayTable from "@clayui/table";

import * as types from "../../../types/searchResult";
import * as constants from "../../../constants/searchResult";

interface props {
  inputData: Array<types.responseType>;
  loading: boolean;
  onTableSort: (sortBy: { sortType: string; sortingKey: any }) => void;
}

const Table: React.FC<props> = ({ inputData, loading, onTableSort }: props) => {
  const types = {
    Individual: "F",
    "Self employed": "O",
    "Legal entity": "P",
  };

  const formatDOB = (date: string): string => {
    try {
      const [year, month, day] = date.split("-");

      return `${day}/${month}/${year}`;
    } catch (error) {
      return "";
    }
  };

  return (
    <ClayTable borderless>
      <ClayTable.Head>
        <ClayTable.Row>
          <ClayTable.Cell
            headingCell
            onClick={() =>
              onTableSort({ sortType: "DESC", sortingKey: constants.OIB_KEY })
            }
          >
            {constants.OIB_NAME}
          </ClayTable.Cell>
          <ClayTable.Cell
            headingCell
            onClick={() =>
              onTableSort({ sortType: "DESC", sortingKey: constants.SUB_KEY })
            }
          >
            {constants.SUB_NAME}
          </ClayTable.Cell>
          <ClayTable.Cell
            headingCell
            onClick={() =>
              onTableSort({ sortType: "DESC", sortingKey: constants.DOB_KEY })
            }
          >
            {constants.DOB_NAME}
          </ClayTable.Cell>
          <ClayTable.Cell
            expanded
            headingCell
            onClick={() =>
              onTableSort({ sortType: "DESC", sortingKey: constants.NAME_KEY })
            }
          >
            {constants.NAME_NAME}
          </ClayTable.Cell>
          <ClayTable.Cell
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
            headingCell
            onClick={() =>
              onTableSort({ sortType: "DESC", sortingKey: constants.CITY_KEY })
            }
          >
            {constants.CITY_NAME}
          </ClayTable.Cell>
          <ClayTable.Cell
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
          <ClayTable.Row>
            <ClayTable.Cell headingTitle>
              {item[constants.OIB_KEY]}
            </ClayTable.Cell>
            <ClayTable.Cell headingTitle>
              {item[constants.SUB_KEY]}
            </ClayTable.Cell>
            <ClayTable.Cell headingTitle>
              {formatDOB(item[constants.DOB_KEY])}
            </ClayTable.Cell>
            <ClayTable.Cell headingTitle>
              {item[constants.NAME_KEY]}
            </ClayTable.Cell>
            <ClayTable.Cell headingTitle>
              {item[constants.STREET_KEY]}
            </ClayTable.Cell>
            <ClayTable.Cell headingTitle>
              {item[constants.CITY_KEY]}
            </ClayTable.Cell>
            <ClayTable.Cell headingTitle>
              {types[item[constants.TYPE_KEY] as keyof typeof types]}
            </ClayTable.Cell>
          </ClayTable.Row>
        ))}
      </ClayTable.Body>
    </ClayTable>
  );
};

export default Table;
