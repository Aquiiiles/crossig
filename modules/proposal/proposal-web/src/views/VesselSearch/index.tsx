import React, { useEffect } from "react";
import { Content, Wrapper, InnerWrapper, LinkWrapper } from "./styles";
import Stepper from "../../shared/molecules/Stepper";
import { VESSEL_LOOKUP } from "../../constants/languageKeys";
import SearchField from "./containers/SearchField";
import { Link, useLocation } from "react-router-dom";
import { VESSEL_URL } from "../../api/constants/routes";
import { useHttpRequest } from "../../api/hooks/useHttpRequest";
import { FetchDataResultsFunction } from "../../shared/types/common";
import * as constants from "./constants";
import { initialState } from "../../redux/vesselLookup/vesselLookupSlice";
import VesselLookupResult from "./containers/VesselLookupResult";
import { PENDING, IDLE } from "../../api/reducers/constants";
import usePagination from "../../shared/hooks/usePagination";
import { useSelector } from "../../redux/store";
import { resetModalScroll } from "../../shared/util/commonFunctions";
import { ROUTES } from "../../constants/routes";

interface SearchState {
  doSearch: boolean;
}

const VesselSearch: React.FC = () => {
  const location = useLocation<SearchState>();
  const [searchResponse, { fetchData: fetchSearch }] = useHttpRequest();

  const [
    currentPage,
    pages,
    { goToNextPage, goToPrevPage, goToPage },
    handleNewTotal,
    totalPages,
  ] = usePagination(constants.RESULTS_LIMIT);

  const filterState = useSelector((state) => state.vesselLookupFilter);

  const {
    vesselType,
    vesselName,
    vesselFleetName,
    vesselRegistrationMark,
    vesselNIB,
    sortOrder,
    sortedBy,
  } = filterState;

  const idle = searchResponse.status === IDLE;
  const loading = searchResponse.status === PENDING;

  const fetchData: FetchDataResultsFunction = () => {
    const payload = {
      fleetName: vesselFleetName,
      nib: vesselNIB,
      registrationMark: vesselRegistrationMark,
      vesselName: vesselName,
      vesselType: vesselType,
    };

    const urlParams = new URLSearchParams({
      startIndex: ((currentPage - 1) * constants.RESULTS_LIMIT).toString(),
      count: constants.RESULTS_LIMIT.toString(),
      sortBy: sortedBy,
      sortOrder,
    });

    fetchSearch("POST", `${VESSEL_URL}/search`, urlParams, payload);
  };

  useEffect(() => {
    if (filterState !== initialState) {
      fetchData();
    }
  }, []);

  const fetchNewData = () => {
    if (currentPage === 1 && !idle) {
      fetchData();
    } else {
      goToPage(1);
    }
  };

  useEffect(() => {
    const result = searchResponse.response.data;
    if (result != null) {
      handleNewTotal(result.length);
    }
  }, [searchResponse, handleNewTotal]);

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

  useEffect(() => {
    resetModalScroll();
  }, []);

  return (
    <Wrapper>
      <Stepper
        currentStep={5}
        subCategory={{ name: "INSURED_OBJECT_DETAILS", currentStep: 1 }}
      />

      <InnerWrapper>
        <Content>
          <div className="tablet-padding">
            <h5>{VESSEL_LOOKUP.TITLE}</h5>
            <p className="body-small" style={{ marginBottom: "2.5rem" }}>
              {VESSEL_LOOKUP.SUBTITLE}
            </p>
            <SearchField onSearchClick={() => fetchData()} />
          </div>
          {!idle && (
            <VesselLookupResult
              data={searchResponse.response.data}
              loading={loading}
              paginationData={{
                lowerRange: (currentPage - 1) * constants.RESULTS_LIMIT + 1,
                upperRange: Math.min(
                  (currentPage - 1) * constants.RESULTS_LIMIT +
                    constants.RESULTS_LIMIT,
                  searchResponse.response.data.length
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
          )}
        </Content>
        <LinkWrapper>
          <Link to={ROUTES.COVERAGE_PLAN}>{VESSEL_LOOKUP.LINK_BACK}</Link>
        </LinkWrapper>
      </InnerWrapper>
    </Wrapper>
  );
};

export default VesselSearch;
