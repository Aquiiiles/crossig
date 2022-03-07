import React from "react";
import { VESSEL_LOOKUP } from "../../../../constants/languageKeys";
import { PageIndex } from "../../../../shared/hooks/usePagination";
import LookupResult from "../../../../shared/containers/LookupResult";
import { ProvidedDataType, VesselRow } from "./types/vesselLookupResult";
import ResultsTable from "../../../../shared/organisms/ResultsTable";
import { useDispatch, useSelector } from "../../../../redux/store";
import { actions } from "../../../../redux";
import { decideOrder } from "../../../../shared/util/tableUtils";
import VesselTableRow from "./components/atoms/VesselTableRow";
import { VESSEL_LOOKUP_HEADER } from "./constants/vesselLookup";

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
  const dispatch = useDispatch();
  const { sortedBy, sortOrder } = useSelector(
    (state) => state.vesselLookupFilter
  );
  const { setSortedBy, setSortOrder } = actions.vesselLookupFilter;

  const parsedData = props.data.map((item: ProvidedDataType) => {
    const responseObj: VesselRow = {
      NIB: item.NIB,
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
        onSort={(key: string) => {
          dispatch(setSortedBy(key));
          dispatch(setSortOrder(decideOrder(key, sortedBy, sortOrder)));
        }}
        rowGenerator={(vessel: VesselRow) => {
          return <VesselTableRow vessel={vessel} />;
        }}
        sortedBy={sortedBy}
        sortOrder={sortOrder}
        headerItems={VESSEL_LOOKUP_HEADER}
      />
    </LookupResult>
  );
};

export default VesselLookupResult;
