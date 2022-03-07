import React, { useState } from "react";
import ClayButton from "@clayui/button";
import ClayTable from "@clayui/table";
import { HoveringButtonGroup } from "./style";
import { VESSEL_LOOKUP_TABLE } from "../../../../../../../constants/languageKeys";
import { VesselRow } from "../../../types/vesselLookupResult";

type propsType = {
  vessel: VesselRow;
};

const VesselTableRow: React.FC<propsType> = (props: propsType) => {
  const [showButtons, setShowButtons] = useState(false);

  return (
    <ClayTable.Row
      style={{ position: "relative" }}
      onMouseLeave={() => setShowButtons(false)}
      onMouseEnter={() => setShowButtons(true)}
      onDoubleClick={() => {
        return;
      }}
    >
      <ClayTable.Cell headingTitle>{props.vessel.NIB}</ClayTable.Cell>
      <ClayTable.Cell headingTitle>
        {props.vessel.registrationMark}
      </ClayTable.Cell>
      <ClayTable.Cell headingTitle>{props.vessel.vesselName}</ClayTable.Cell>
      <ClayTable.Cell headingTitle>{props.vessel.fleetName}</ClayTable.Cell>
      {showButtons ? (
        <HoveringButtonGroup>
          <ClayButton displayType="primary">
            {VESSEL_LOOKUP_TABLE.CHOOSE_AND_CONTINUE}
          </ClayButton>
        </HoveringButtonGroup>
      ) : (
        <ClayTable.Cell headingTitle>
          {props.vessel.policyHolder}
        </ClayTable.Cell>
      )}
    </ClayTable.Row>
  );
};

export default VesselTableRow;
