import React, { useState } from "react";
import Pagination from "../../molecules/Pagination";
import { SearchResultsHeader, Wrapper } from "./styles";
import ClayLoadingIndicator from "@clayui/loading-indicator";
import languageKeys from "../../../constants/Language";
import { PageIndex } from "../../hooks/types";
import SortButton from "../../atoms/SortButton";
import ClayDropDown from "@clayui/drop-down";
import useSort from "../../hooks/useSort";
import { SortableActionKeyType } from "../../hooks/types";
import spritemap from "@clayui/css/lib/images/icons/icons.svg";
import ClayIcon from "@clayui/icon";
import { HeaderCell } from "../../types";

const { TOO_MANY_SEARCH_RESULTS } = languageKeys;

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
  sortableActionKey: SortableActionKeyType;
  headerItems: Array<HeaderCell>;
};

const LookupResult: React.FC<PropsType> = (props: PropsType) => {
  const [showMobileDropdown, setShowMobileDropdown] = useState(false);
  const [{ sortedBy, sortOrder }, { handleSort }] = useSort(
    props.sortableActionKey
  );
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

  const arrowIcon = (
    <ClayIcon
      spritemap={spritemap}
      symbol={sortOrder === "asc" ? "order-arrow-up" : "order-arrow-down"}
    />
  );

  return (
    <>
      {shouldShowResults() ? (
        <SearchResultsHeader className="tablet-only">
          <h6 className="h9">{elementsFoundText()}</h6>
          <ClayDropDown
            active={showMobileDropdown}
            onActiveChange={setShowMobileDropdown}
            trigger={<SortButton />}
          >
            {hasResults && (
              <ClayDropDown.Group>
                {Object.values(props.headerItems).map(
                  (headerItem: HeaderCell) => (
                    <ClayDropDown.Item
                      key={headerItem.key}
                      onClick={() => handleSort(headerItem.key)}
                    >
                      {headerItem.name}
                      {sortedBy === headerItem.key ? arrowIcon : null}
                    </ClayDropDown.Item>
                  )
                )}
              </ClayDropDown.Group>
            )}
          </ClayDropDown>
        </SearchResultsHeader>
      ) : null}
      <Wrapper>
        {shouldShowResults() ? (
          <>
            <SearchResultsHeader className="desktop-only">
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
    </>
  );
};

export default LookupResult;
