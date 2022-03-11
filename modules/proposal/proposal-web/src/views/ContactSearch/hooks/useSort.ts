import { useSelector, useDispatch } from "../../../redux/store";
import { actions } from "../../../redux";

export default function useSort() {
  const dispatch = useDispatch();
  const { sortedBy, sortOrder } = useSelector((state) => state.searchFilter);
  const { setSortedBy, setSortOrder } = actions.searchFilter;

  const decideOrder = (sortBy: string) => {
    if (sortBy === sortedBy) {
      return sortOrder === "asc" ? "desc" : "asc";
    } else {
      return "desc";
    }
  };

  return [
    { sortedBy, sortOrder },
    { setSortedBy, setSortOrder, decideOrder },
    dispatch,
  ] as const;
}
