import { useEffect, useState } from "react";
import {
  useContactSelector,
  useContactDispatch,
} from "../../../../../redux/store";
import { actions } from "../../../../../redux/vesselSearchSlice";
import { MINIMUM_LENGTH_FOR_SEARCH } from "../../../../../constants/vesselConstants";
import { useHistory } from "react-router-dom";

export default function useSearchField() {
  const dispatch = useContactDispatch();
  const [disabledSearch, setDisabledSearch] = useState(true);
  const fieldValues = useContactSelector((state) => state.vesselSearch);
  const fieldActions = actions;
  const history = useHistory();

  useEffect(() => {
    const { vesselName, vesselRegistrationMark, vesselNib, vesselType } =
      fieldValues;

    if (
      (vesselName.length >= MINIMUM_LENGTH_FOR_SEARCH && vesselType !== "") ||
      vesselRegistrationMark.length >= MINIMUM_LENGTH_FOR_SEARCH ||
      vesselNib.length >= MINIMUM_LENGTH_FOR_SEARCH
    ) {
      setDisabledSearch(false);
    } else {
      setDisabledSearch(true);
    }
  }, [
    fieldValues.vesselName,
    fieldValues.vesselRegistrationMark,
    fieldValues.vesselNib,
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
