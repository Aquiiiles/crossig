import React from "react";
import ClayButton from "@clayui/button";
import ClayTable from "@clayui/table";
import { HoveringButtonGroup } from "./style";
import { VESSEL_LOOKUP_TABLE } from "../../../../../../../constants/languageKeys";
import { VesselRow } from "../../../types/vesselLookupResult";
import { useHistory } from "react-router-dom";

type propsType = {
  vessel: VesselRow;
  rowId: number;
  handleHover: (rowId: number) => void;
  hoveringRow: number;
};

const VesselTableRow: React.FC<propsType> = (props: propsType) => {
  const history = useHistory();

  const hoveringButtons = () => {
    return (
      <HoveringButtonGroup>
        <ClayButton
          displayType="primary"
          onClick={() => {
            history.push("/premium");
          }}
        >
          {VESSEL_LOOKUP_TABLE.CHOOSE_AND_CONTINUE}
        </ClayButton>
      </HoveringButtonGroup>
    );
  };

  const policyHolderCell = () => {
    return (
      <ClayTable.Cell headingTitle>{props.vessel.policyHolder}</ClayTable.Cell>
    );
  };

  const lastCell =
    props.hoveringRow === props.rowId ? hoveringButtons() : policyHolderCell();

  return (
    <ClayTable.Row
      style={{ position: "relative" }}
      onMouseLeave={() => props.handleHover(-1)}
      onMouseEnter={() => props.handleHover(props.rowId)}
      onDoubleClick={() => {
        return;
      }}
    >
      <ClayTable.Cell headingTitle>{props.vessel.nib}</ClayTable.Cell>
      <ClayTable.Cell headingTitle>
        {props.vessel.registrationMark}
      </ClayTable.Cell>
      <ClayTable.Cell headingTitle>{props.vessel.vesselName}</ClayTable.Cell>
      <ClayTable.Cell headingTitle>{props.vessel.fleetName}</ClayTable.Cell>
      {lastCell}
    </ClayTable.Row>
  );
};

export default VesselTableRow;
