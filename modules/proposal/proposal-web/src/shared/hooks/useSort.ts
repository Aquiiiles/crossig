import { useSelector, useDispatch } from "../../redux/store";
import { actions } from "../../redux";
import { decideOrder } from "../../shared/util/tableUtils";

export type SortableActionKeyType = keyof Pick<
  typeof actions,
  "searchFilter" | "vesselLookupFilter"
>;

/**
 * Tap into the sort state for a particular redux action. Exposes helper functions for sorting.
 * @param sortableActionKey The key for the action to look for, must have sort functions or else it will not work.
 */
export default function useSort(sortableActionKey: SortableActionKeyType) {
  const dispatch = useDispatch();
  const { sortedBy, sortOrder } = useSelector(
    (state) => state[sortableActionKey]
  );
  const { setSortedBy, setSortOrder } = actions[sortableActionKey];

  const handleSort = (key: string) => {
    dispatch(setSortedBy(key));
    dispatch(setSortOrder(decideOrder(key, sortedBy, sortOrder)));
  };

  return [{ sortedBy, sortOrder }, { handleSort }, dispatch] as const;
}
