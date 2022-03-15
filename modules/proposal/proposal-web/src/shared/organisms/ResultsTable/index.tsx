import React from "react";
import ClayTable from "@clayui/table";
import { Table, Span, MobileWrapper } from "./styles";
import ArrowIcon from "../../atoms/ArrowIcon";
import { HeaderCell } from "../../types/common";

interface propsInterface<RowGeneratorType> {
  inputData: Array<RowGeneratorType>;
  onSort: (key: string) => void;
  rowGenerator: (item: RowGeneratorType) => void;
  rowGeneratorMobile?: (item: RowGeneratorType) => void;
  sortedBy: string;
  sortOrder: string;
  headerItems: Array<HeaderCell>;
}

const ResultsTable = <RowGeneratorType extends object>(
  props: propsInterface<RowGeneratorType>
): React.ReactElement => {
  const handleHeaderCell = (cell: HeaderCell) => {
    return (
      <ClayTable.Cell
        style={{ cursor: "pointer" }}
        expanded={cell.expanded}
        headingCell
        onClick={() => props.onSort(cell.key)}
      >
        {cell.hasSpan && <Span />}
        {cell.name}
        {props.sortedBy === cell.key ? (
          <ArrowIcon sortOrder={props.sortOrder} />
        ) : null}
      </ClayTable.Cell>
    );
  };

  return (
    <>
      <MobileWrapper>
        {props.inputData.map(
          (row: RowGeneratorType) =>
            !!props.rowGeneratorMobile && props.rowGeneratorMobile(row)
        )}
      </MobileWrapper>
      <Table borderless className="desktop-only">
        <ClayTable.Head>
          <ClayTable.Row>
            {Object.values(props.headerItems).map((headerItem: HeaderCell) =>
              handleHeaderCell(headerItem)
            )}
          </ClayTable.Row>
        </ClayTable.Head>
        <ClayTable.Body>
          {props.inputData.map((row: RowGeneratorType) =>
            props.rowGenerator(row)
          )}
        </ClayTable.Body>
      </Table>
    </>
  );
};

export default ResultsTable;
