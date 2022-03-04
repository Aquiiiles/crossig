import React, { useState } from "react";
import ClayButton from "@clayui/button";
import ClayTable from "@clayui/table";
import { HoveringButtonGroup } from "./style";
import {
  CONTACT_SEARCH_TABLE_VIEW_DETAILS,
  CONTACT_SEARCH_TABLE_USE_CONTACT,
} from "../../../../../../../constants/languageKeys";

import * as types from "../../../types/vesselLookupResult";
import { useHistory } from "react-router-dom";

type propsType = {
  vessel: types.responseType;
};

const VesselTableRow: React.FC<propsType> = (props: propsType) => {
  const [showButtons, setShowButtons] = useState(false);
  const history = useHistory();

  const openUpdateContact = (extNumber: number) => {
    history.push({
      pathname: "/update_contact",
      state: extNumber,
    });
  };

  return (
    <ClayTable.Row
      style={{ position: "relative" }}
      onMouseLeave={() => setShowButtons(false)}
      onMouseEnter={() => setShowButtons(true)}
      onDoubleClick={() => history.push("/product")}
    >
      <ClayTable.Cell headingTitle>{props.vessel.NIB}</ClayTable.Cell>
      <ClayTable.Cell headingTitle>
        {props.vessel.registrationMark}
      </ClayTable.Cell>
      <ClayTable.Cell headingTitle>{props.vessel.vesselName}</ClayTable.Cell>
      <ClayTable.Cell headingTitle>{props.vessel.fleetName}</ClayTable.Cell>
      {showButtons ? (
        <HoveringButtonGroup>
          <ClayButton
            displayType="secondary"
            className="ghost"
            onClick={() => {
              return;
            }}
          >
            {CONTACT_SEARCH_TABLE_VIEW_DETAILS}
          </ClayButton>
          <ClayButton
            displayType="primary"
            onClick={() => history.push("/product")}
          >
            {CONTACT_SEARCH_TABLE_USE_CONTACT}
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
