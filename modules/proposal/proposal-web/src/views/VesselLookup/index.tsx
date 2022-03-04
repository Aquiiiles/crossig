/* eslint-disable @typescript-eslint/no-empty-function */
import React, { useEffect, useState } from "react";
import { Content, Wrapper, EmptySpace } from "./styles";
import Stepper from "../../shared/containers/Stepper";
import { useFetchData } from "../../api/hooks/useFetchData";
import VesselLookupResult from "./containers/VesselLookupResult";
import { PENDING, IDLE } from "../../api/reducers/constants";
import { useLocation } from "react-router-dom";
import { VESSEL_LOOKUP } from "../../constants/languageKeys";
import usePagination from "../../shared/hooks/usePagination";
import { FetchDataResultsFunction } from "../../shared/types/common";
import { initialState } from "../../redux/vessel/vesselLookupSlice";
import { useSelector } from "../../redux/store";
import { VESSEL_URL } from "../../api/constants/routes";
import { mockData } from "./util";

import * as constants from "./constants/";

interface stateType {
  doSearch: boolean;
}

const VesselLookup: React.FC = () => {
  const location = useLocation<stateType>();
  const { state: searchResultData, fetchData: fetchSearchResultData } =
    useFetchData();

  const [
    currentPage,
    pages,
    { goToNextPage, goToPrevPage, goToPage },
    handleNewTotal,
    totalPages,
  ] = usePagination(constants.RESULTS_LIMIT);

  const filterState = useSelector((state) => state.vesselLookupFilter);

  const { vesselType, vesselName, registrationMark, NIB, sortOrder, sortedBy } =
    filterState;

  // TODO: this should be uncommented once the search filter is done.
  // const idle = searchResultData.status === IDLE;
  const idle = false;
  const loading = searchResultData.status === PENDING;

  useEffect(() => {
    if (filterState !== initialState) {
      fetchData();
    }
  }, []);

  const fetchData: FetchDataResultsFunction = () => {
    const numberRegex = /^\d+/;
    const textRegex = /^[A-Za-z\s]+/;
    const payload = {
      finderKey: 1,
      identifierType: 1000000,
      identityNumber: numberRegex.test(NIB) ? NIB : undefined,
      type: textRegex.test(vesselType) ? vesselType : undefined,
      name: textRegex.test(vesselName) ? vesselName : undefined,
      registrationMark: textRegex.test(registrationMark)
        ? registrationMark
        : undefined,
    };

    const urlParams = new URLSearchParams({
      startIndex: ((currentPage - 1) * constants.RESULTS_LIMIT).toString(),
      count: constants.RESULTS_LIMIT.toString(),
      sortBy: sortedBy,
      sortOrder,
    });

    fetchSearchResultData(
      "POST",
      `${VESSEL_URL}?${urlParams.toString()}`,
      {},
      payload,
      mockData
    );
  };

  const fetchNewData = () => {
    if (currentPage === 1 && !idle) {
      fetchData();
    } else {
      goToPage(1);
    }
  };

  useEffect(() => {
    const result = searchResultData.response.data;
    if (result != null) {
      handleNewTotal(result.length);
    }
  }, [searchResultData, handleNewTotal]);

  useEffect(() => {
    if (!idle) {
      fetchData();
    }
  }, [currentPage]);

  useEffect(() => {
    fetchNewData();
  }, [sortOrder, sortedBy]);

  useEffect(() => {
    if (location.state?.doSearch) {
      fetchData();
    }
  }, []);

  return (
    <Wrapper>
      <Stepper />

      <Content>
        <h5>{VESSEL_LOOKUP.TITLE}</h5>
        <p className="body-small" style={{ marginBottom: "2.5rem" }}>
          {VESSEL_LOOKUP.SUBTITLE}
        </p>
        {!idle ? (
          <VesselLookupResult
            data={mockData}
            loading={loading}
            paginationData={{
              lowerRange: (currentPage - 1) * constants.RESULTS_LIMIT + 1,
              upperRange: Math.min(
                (currentPage - 1) * constants.RESULTS_LIMIT +
                  constants.RESULTS_LIMIT,
                mockData.length
              ),
              currentPage,
              pages,
              goToNextPage,
              goToPrevPage,
              goToPage,
              totalPages,
            }}
            totalResultsLimit={constants.TOTAL_RESULTS_LIMIT}
          />
        ) : (
          <EmptySpace />
        )}
      </Content>
    </Wrapper>
  );
};

export default VesselLookup;
