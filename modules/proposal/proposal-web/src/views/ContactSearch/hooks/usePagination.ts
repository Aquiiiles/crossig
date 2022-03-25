import { useCallback, useLayoutEffect, useState } from "react";
import { PageIndex } from "../../../shared/hooks/types";

export default function usePagination(limit: number) {
  const [currentPage, setCurrentPage] = useState(1);
  const [pages, setPages] = useState<Array<PageIndex>>([1]);
  const [total, setTotal] = useState(limit);

  const DOTS = "...";

  const totalPages = useCallback(
    () => Math.ceil(total / limit),
    [limit, total]
  );

  const goToNextPage = () => {
    if (currentPage + 1 <= totalPages()) {
      setCurrentPage((value) => value + 1);
    }
  };

  const goToPrevPage = () => {
    if (currentPage - 1 > 0) {
      setCurrentPage((value) => value - 1);
    }
  };

  const goToPage = (pageIndex: PageIndex) => {
    const numericPage = Number(pageIndex);
    if (!isNaN(numericPage)) {
      setCurrentPage(numericPage);
    }
  };

  const handleNewTotal = useCallback((newTotal: number) => {
    setTotal(newTotal);
  }, []);

  const range = (start: number, end: number) => {
    const length = end - start + 1;

    return Array.from({ length }, (_, index) => index + start);
  };

  useLayoutEffect(() => {
    const calculatePages = () => {
      const siblingCount = 1;
      const totalPageNumbers = siblingCount + 5;

      if (totalPageNumbers >= totalPages()) {
        return range(1, totalPages());
      }

      const leftSiblingIndex = Math.max(currentPage - siblingCount, 1);
      const rightSiblingIndex = Math.min(
        currentPage + siblingCount,
        totalPages()
      );
      const showLeftDots = leftSiblingIndex > 2;
      const showRightDots = rightSiblingIndex < totalPages() - 2;

      const firstPageIndex = 1;
      const lastPageIndex = totalPages();

      if (!showLeftDots && showRightDots) {
        const leftItemCount = 3 + 2 * siblingCount;
        const leftRange = range(1, leftItemCount);

        return [...leftRange, DOTS, totalPages()];
      } else if (showLeftDots && !showRightDots) {
        const rightItemCount = 3 + 2 * siblingCount;
        const rightRange = range(
          totalPages() - rightItemCount + 1,
          totalPages()
        );

        return [firstPageIndex, DOTS, ...rightRange];
      } else {
        const middleRange = range(leftSiblingIndex, rightSiblingIndex);
        return [firstPageIndex, DOTS, ...middleRange, DOTS, lastPageIndex];
      }
    };

    setPages(calculatePages());
  }, [currentPage, totalPages]);

  return [
    currentPage,
    pages,
    { goToNextPage, goToPrevPage, goToPage },
    handleNewTotal,
    totalPages,
  ] as const;
}
