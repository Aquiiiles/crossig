import React from "react";
import ClayTable from "@clayui/table";
import VesselTableRow from "../../atoms/VesselTableRow";
import { useDispatch, useSelector } from "../../../../../../../redux/store";
import { actions } from "../../../../../../../redux";
import { ResultsTable, Span } from "./styles";
import { decideOrder } from "../../../../../../../shared/util/tableUtils";
import * as types from "../../../types/vesselLookupResult";
import * as constants from "../../../constants/vesselLookup";
import ArrowIcon from "../../../../../../../shared/atoms/ArrowIcon";
import { HeaderCell } from "../../../../../../../shared/types/common";

type propsType = {
  inputData: Array<types.VesselRow>;
};

const VesselResultsTable: React.FC<propsType> = ({ inputData }: propsType) => {
  const dispatch = useDispatch();
  const { sortedBy, sortOrder } = useSelector(
    (state) => state.vesselLookupFilter
  );
  const { setSortedBy, setSortOrder } = actions.vesselLookupFilter;

  const headerCell = (cell: HeaderCell) => {
    return (
      <ClayTable.Cell
        style={{ cursor: "pointer" }}
        expanded={cell.expanded}
        headingCell
        onClick={() => {
          dispatch(setSortedBy(cell.key));
          dispatch(setSortOrder(decideOrder(cell.key, sortedBy, sortOrder)));
        }}
      >
        {cell.hasSpan && <Span />}
        {cell.name}
        {sortedBy === cell.key ? <ArrowIcon sortOrder={sortOrder} /> : null}
      </ClayTable.Cell>
    );
  };

  return (
    <ResultsTable borderless>
      <ClayTable.Head>
        <ClayTable.Row>
          {headerCell(constants.NIB)}
          {headerCell(constants.REGISTRATION_MARK)}
          {headerCell(constants.VESSEL_NAME)}
          {headerCell(constants.FLEET_NAME)}
          {headerCell(constants.POLICY_HOLDER)}
        </ClayTable.Row>
      </ClayTable.Head>
      <ClayTable.Body>
        {inputData.map((item: types.VesselRow) => (
          <VesselTableRow key={item.NIB} vessel={item} />
        ))}
      </ClayTable.Body>
    </ResultsTable>
  );
};

export default VesselResultsTable;
