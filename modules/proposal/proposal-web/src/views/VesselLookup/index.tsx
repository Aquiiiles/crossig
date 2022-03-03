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
import { initialState } from "../../redux/vessel/lookupSlice";
import { useVesselSelector } from "../../redux/vessel/store";

interface stateType {
  doSearch: boolean;
}

const RESULTS_LIMIT = 20;
const TOTAL_RESULTS_LIMIT = 100;

const VesselLookup: React.FC = () => {
  const [data, setData] = useState([]);
  const location = useLocation<stateType>();
  const { state: searchResultData, fetchData: fetchSearchResultData } =
    useFetchData();

  const [
    currentPage,
    pages,
    { goToNextPage, goToPrevPage, goToPage },
    handleNewTotal,
    totalPages,
  ] = usePagination(RESULTS_LIMIT);

  const filterState = useVesselSelector((state) => state.lookupFilter);
  const { vesselType, vesselName, registrationMark, NIB, sortOrder, sortedBy } =
    filterState;

  const idle = searchResultData.status === IDLE;
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
      startIndex: ((currentPage - 1) * RESULTS_LIMIT).toString(),
      count: RESULTS_LIMIT.toString(),
      sortBy: sortedBy,
      sortOrder,
    }).toString();

    const VESSEL_URL = ""; // TODO: change this when the API is ready.

    fetchSearchResultData("POST", `${VESSEL_URL}?${urlParams}`, {}, payload);
  };

  const fetchNewData = () => {
    if (currentPage === 1 && !idle) {
      fetchData();
    } else {
      goToPage(1);
    }
  };

  useEffect(() => {
    const result = searchResultData.response.data[0]; // TODO: change this when the API is ready.
    if (result != null) {
      setData(result);
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
            data={data}
            loading={loading}
            paginationData={{
              lowerRange: (currentPage - 1) * RESULTS_LIMIT + 1,
              upperRange: Math.min(
                (currentPage - 1) * RESULTS_LIMIT + RESULTS_LIMIT,
                data.length
              ),
              currentPage,
              pages,
              goToNextPage,
              goToPrevPage,
              goToPage,
              handleNewTotal,
              totalPages,
            }}
            totalResultsLimit={TOTAL_RESULTS_LIMIT}
          />
        ) : (
          <EmptySpace />
        )}
      </Content>
    </Wrapper>
  );
};

export default VesselLookup;
