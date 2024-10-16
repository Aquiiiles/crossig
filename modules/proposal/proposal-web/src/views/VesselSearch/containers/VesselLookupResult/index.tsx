import React, { useState } from "react";
import languageKeys from "../../../../constants/Language";
import { PageIndex } from "../../../../shared/hooks/types";
import LookupResult from "../../../../shared/containers/LookupResult";
import { ProvidedDataType, VesselRow } from "./types";
import ResultsTable from "../../../../shared/organisms/ResultsTable";
import VesselTableRow from "./components/atoms/VesselTableRow";
import { VESSEL_LOOKUP_HEADER } from "./constants/vesselLookup";
import useSort from "../../../../shared/hooks/useSort";
import VesselRowMobile from "./components/atoms/VesselRowMobile";

const { VESSEL_LOOKUP } = languageKeys;

type PropsType = {
  /* eslint-disable @typescript-eslint/no-explicit-any */
  data: Array<any>;
  loading: boolean;
  paginationData: {
    lowerRange: number;
    upperRange: number;
    currentPage: number;
    pages: Array<PageIndex>;
    goToNextPage: () => void;
    goToPrevPage: () => void;
    goToPage: (pageIndex: PageIndex) => void;
    totalPages: () => number;
  };
  totalResultsLimit: number;
};

const VesselLookupResult: React.FC<PropsType> = (props: PropsType) => {
  const [sortData, { handleSort }] = useSort("vesselLookupFilter");
  const [hoveringRow, setHoveringRow] = useState(-1);

  const parsedData = props.data.map((item: ProvidedDataType) => {
    const responseObj: VesselRow = {
      nib: item.nib,
      registrationMark: item.registrationMark,
      vesselName: item.vesselName,
      fleetName: item.fleetName,
      policyHolder: item.policyHolder,
    };

    return responseObj;
  });

  return (
    <LookupResult
      data={parsedData}
      loading={props.loading}
      paginationData={props.paginationData}
      totalResultsLimit={props.totalResultsLimit}
      noElementsMessage={VESSEL_LOOKUP.NO_VESSELS_FOUND}
      elementsFoundMessage={VESSEL_LOOKUP.VESSELS_FOUND}
      sortableActionKey={"vesselLookupFilter"}
      headerItems={VESSEL_LOOKUP_HEADER}
    >
      <ResultsTable
        inputData={parsedData}
        {...sortData}
        onSort={handleSort}
        rowGenerator={(vessel: VesselRow) => {
          return (
            <VesselTableRow
              vessel={vessel}
              rowId={parsedData.indexOf(vessel)}
              handleHover={setHoveringRow}
              hoveringRow={hoveringRow}
            />
          );
        }}
        rowGeneratorMobile={(vessel: VesselRow) => {
          return (
            <VesselRowMobile
              vessel={vessel}
              headerItems={VESSEL_LOOKUP_HEADER}
            />
          );
        }}
        headerItems={VESSEL_LOOKUP_HEADER}
      />
    </LookupResult>
  );
};

export default VesselLookupResult;
