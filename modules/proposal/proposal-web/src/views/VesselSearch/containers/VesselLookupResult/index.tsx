import React from "react";
import { VESSEL_LOOKUP } from "../../../../constants/languageKeys";
import { PageIndex } from "../../../../shared/hooks/usePagination";
import LookupResult from "../../../../shared/containers/LookupResult";
import { ProvidedDataType, VesselRow } from "./types/vesselLookupResult";
import ResultsTable from "../../../../shared/organisms/ResultsTable";
import VesselTableRow from "./components/atoms/VesselTableRow";
import { VESSEL_LOOKUP_HEADER } from "./constants/vesselLookup";
import useSort from "../../../../shared/hooks/useSort";

type PropsType = {
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
    >
      <ResultsTable
        inputData={parsedData}
        {...sortData}
        onSort={handleSort}
        rowGenerator={(vessel: VesselRow) => {
          return <VesselTableRow vessel={vessel} />;
        }}
        headerItems={VESSEL_LOOKUP_HEADER}
      />
    </LookupResult>
  );
};

export default VesselLookupResult;
