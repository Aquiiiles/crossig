import { useEffect, useState } from "react";
import { useSelector, useDispatch } from "../../../../../redux/store";
import { MINIMUM_LENGTH_FOR_SEARCH } from "../../../../../constants/vesselConstants";
import { useHistory } from "react-router-dom";
import { actions } from "../../../../../redux";

export default function useSearchField() {
  const dispatch = useDispatch();
  const [disabledSearch, setDisabledSearch] = useState(true);
  const fieldValues = useSelector((state) => state.vesselLookupFilter);
  const fieldActions = actions.vesselLookupFilter;
  const history = useHistory();

  useEffect(() => {
    const { vesselName, vesselRegistrationMark, vesselNIB, vesselType } =
      fieldValues;

    if (
      (vesselName.length >= MINIMUM_LENGTH_FOR_SEARCH && vesselType !== "") ||
      vesselRegistrationMark.length >= MINIMUM_LENGTH_FOR_SEARCH ||
      vesselNIB.length >= MINIMUM_LENGTH_FOR_SEARCH
    ) {
      setDisabledSearch(false);
    } else {
      setDisabledSearch(true);
    }
  }, [
    fieldValues.vesselName,
    fieldValues.vesselRegistrationMark,
    fieldValues.vesselNIB,
    fieldValues.vesselType,
  ]);

  return [
    disabledSearch,
    fieldValues,
    fieldActions,
    dispatch,
    history,
  ] as const;
}
