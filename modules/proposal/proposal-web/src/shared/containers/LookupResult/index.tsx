import React from "react";
import Pagination from "../../molecules/Pagination";
import { SearchResultsHeader, Wrapper } from "./styles";
import ClayLoadingIndicator from "@clayui/loading-indicator";
import { TOO_MANY_SEARCH_RESULTS } from "../../../constants/languageKeys";
import { PageIndex } from "../../../shared/hooks/usePagination";

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
  children: React.ReactNode;
  noElementsMessage: string;
  elementsFoundMessage: string;
};

const LookupResult: React.FC<PropsType> = (props: PropsType) => {
  const hasResults = props.data.length > 0;

  const shouldShowResults = () => {
    return !props.loading && props.data.length <= props.totalResultsLimit;
  };

  const elementsFoundText = () => {
    let elementsFound = props.noElementsMessage;

    if (hasResults) {
      elementsFound = props.data.length + " " + props.elementsFoundMessage;
    }

    return elementsFound;
  };

  return (
    <Wrapper>
      {shouldShowResults() ? (
        <>
          <SearchResultsHeader>
            <h6 className="h9">{elementsFoundText()}</h6>
          </SearchResultsHeader>
          {hasResults && (
            <>
              {props.children}
              <Pagination
                paginationData={{
                  total: props.data.length,
                  ...props.paginationData,
                }}
              />
            </>
          )}
        </>
      ) : props.data.length > props.totalResultsLimit ? (
        <h6 className="h9">{TOO_MANY_SEARCH_RESULTS}</h6>
      ) : (
        <ClayLoadingIndicator />
      )}
    </Wrapper>
  );
};

export default LookupResult;
