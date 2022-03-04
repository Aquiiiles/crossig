import React from "react";
import VesselResultsTable from "./components/organisms/VesselResultsTable";
import Pagination from "../../../../shared/molecules/Pagination";
import { SearchResultsHeader, Wrapper } from "./styles";
import ClayLoadingIndicator from "@clayui/loading-indicator";
import { VESSEL_LOOKUP } from "../../../../constants/languageKeys";
import { PageIndex } from "../../../../shared/hooks/usePagination";

import { providedDataType, responseType } from "./types/vesselLookupResult";

type propsType = {
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

const VesselLookupResult: React.FC<propsType> = (props: propsType) => {
  const formatedData = props.data.map((item: providedDataType) => {
    const responseObj: responseType = {
      NIB: item.NIB,
      registrationMark: item.registrationMark,
      vesselName: item.vesselName,
      fleetName: item.fleetName,
      policyHolder: item.policyHolder,
    };

    return responseObj;
  });

  const foundContacts = formatedData.length > 0;

  return (
    <Wrapper>
      {!props.loading && formatedData.length <= props.totalResultsLimit ? (
        <>
          <SearchResultsHeader>
            <h6 className="h9">
              {foundContacts
                ? `${formatedData.length} ${VESSEL_LOOKUP.CONTACTS_FOUND}`
                : `${VESSEL_LOOKUP.NO_CONTACTS_FOUND}`}
            </h6>
          </SearchResultsHeader>
          {foundContacts ? (
            <>
              <VesselResultsTable inputData={formatedData} />
              <Pagination
                paginationData={{
                  total: formatedData.length,
                  ...props.paginationData,
                }}
              />
            </>
          ) : null}
        </>
      ) : formatedData.length > props.totalResultsLimit ? (
        <h6 className="h9">{VESSEL_LOOKUP.TOO_MANY_SEARCH_RESULTS}</h6>
      ) : (
        <ClayLoadingIndicator />
      )}
    </Wrapper>
  );
};

export default VesselLookupResult;
