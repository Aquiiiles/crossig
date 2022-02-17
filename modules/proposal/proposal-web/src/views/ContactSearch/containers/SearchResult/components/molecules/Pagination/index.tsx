import React from "react";
import { Wrapper } from "./styles";
import ClayPagination from "@clayui/pagination";
import { PageIndex } from "../../../../../hooks/usePagination";

interface props {
  paginationData: {
    lowerRange: number;
    upperRange: number;
    total: number;
    currentPage: number;
    pages: Array<PageIndex>;
    goToNextPage: () => void;
    goToPrevPage: () => void;
    goToPage: (pageIndex: PageIndex) => void;
    totalPages: () => number;
  };
}

const Pagination: React.FC<props> = ({
  paginationData: {
    lowerRange,
    upperRange,
    total,
    currentPage,
    pages,
    goToNextPage,
    goToPrevPage,
    goToPage,
    totalPages,
  },
}) => {
  return (
    <Wrapper>
      <p className="body-small">
        Showing {lowerRange} to {upperRange} of {Math.min(total, 100)} entries
      </p>
      <ClayPagination style={{ marginBottom: "0" }}>
        {pages.map(page => {
          if (typeof page === "number") {
            return (
              <ClayPagination.Item
                onClick={() => goToPage(page)}
                active={page === currentPage}
              >
                {page}
              </ClayPagination.Item>
            );
          } else {
            return <ClayPagination.Item>{page}</ClayPagination.Item>;
          }
        })}
        <ClayPagination.Item disabled={currentPage <= 1} onClick={goToPrevPage}>
          {"<"}
        </ClayPagination.Item>
        <ClayPagination.Item
          disabled={currentPage >= totalPages()}
          onClick={goToNextPage}
        >
          {">"}
        </ClayPagination.Item>
      </ClayPagination>
    </Wrapper>
  );
};

export default Pagination;
