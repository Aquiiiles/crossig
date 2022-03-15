import React from "react";
import ResultRowMobile from "../../../../../../../shared/atoms/ResultRowMobile";
import { HeaderCell } from "../../../../../../../shared/types/common";
import { VesselRow } from "../../../types/vesselLookupResult";
import { ButtonGroup, InnerGrid, MainGrid, Wrapper } from "./styles";
import ClayButton from "@clayui/button";
import { VESSEL_LOOKUP_TABLE } from "../../../../../../../constants/languageKeys";

type PropsType = {
  vessel: VesselRow;
  headerItems: Array<HeaderCell>;
};

const VesselRowMobile: React.FC<PropsType> = ({ vessel, headerItems }) => {
  const gridLeftKeys: Array<keyof typeof vessel> = [
    "nib",
    "registrationMark",
    "vesselName",
  ];

  return (
    <Wrapper>
      <MainGrid>
        <InnerGrid>
          {headerItems
            .filter((headerCell) =>
              gridLeftKeys.includes(headerCell.key as keyof typeof vessel)
            )
            .map((headerCell: HeaderCell) => (
              <ResultRowMobile
                key={headerCell.key}
                name={headerCell.name}
                value={vessel[headerCell.key as keyof typeof vessel]}
              />
            ))}
        </InnerGrid>
        <InnerGrid>
          {headerItems
            .filter(
              (headerCell) =>
                !gridLeftKeys.includes(headerCell.key as keyof typeof vessel)
            )
            .map((headerCell: HeaderCell) => (
              <ResultRowMobile
                key={headerCell.key}
                name={headerCell.name}
                value={vessel[headerCell.key as keyof typeof vessel]}
              />
            ))}
        </InnerGrid>
      </MainGrid>
      <ButtonGroup>
        <ClayButton displayType="secondary" className="ghost">
          {VESSEL_LOOKUP_TABLE.VIEW_DETAILS}
        </ClayButton>
        <ClayButton displayType="primary">
          {VESSEL_LOOKUP_TABLE.USE_VESSEL}
        </ClayButton>
      </ButtonGroup>
    </Wrapper>
  );
};

export default VesselRowMobile;
