import React from "react";
import ClayTable from "@clayui/table";
import VesselTableRow from "../../atoms/VesselTableRow";
import {
  useContactDispatch,
  useContactSelector,
} from "../../../../../../../redux/store";
import { actions } from "../../../../../../../redux/vessel/vesselLookupSlice";
import { ResultsTable, Span } from "./styles";
import { decideOrder } from "../../../../../../../shared/util/tableUtils";
import * as types from "../../../types/vesselLookupResult";
import * as constants from "../../../constants/vesselLookup";
import ArrowIcon from "../../../../../../../shared/atoms/ArrowIcon";
import { headerCellType } from "../../../types/vesselLookupResult";

interface props {
  inputData: Array<types.responseType>;
}

const VesselResultsTable: React.FC<props> = ({ inputData }: props) => {
  const dispatch = useContactDispatch();
  const { sortedBy, sortOrder } = useContactSelector(
    (state) => state.vesselLookupFilter
  );
  const { setSortedBy, setSortOrder } = actions;

  const headerCell = (cell: headerCellType) => {
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
        {inputData.map((item: types.responseType) => (
          <VesselTableRow key={item.NIB} vessel={item} />
        ))}
      </ClayTable.Body>
    </ResultsTable>
  );
};

export default VesselResultsTable;
