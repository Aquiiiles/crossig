import { AnyAction } from "@reduxjs/toolkit";
import { useEffect, useState } from "react";
import { useDispatch, useSelector } from "../../../../../redux/store";
import { countryNames } from "../../../../../constants/defaultCountryConfiguration";
import { actions } from "../../../../../redux";
import {
  contactOperations,
  contactTypes,
} from "../../../../../constants/contactConstants";
import { useFetchData } from "../../../../../api/hooks/useFetchData";

export default function useAddressState(
  operation: number,
  enableSave?: () => void,
  setUpdatedValues?: (value: string) => void
) {
  const [disableFields, setDisableFields] = useState(false);
  const dispatcher = useDispatch();
  const { contactType } = useSelector((state) => state.basicInfo);
  const addressValues = useSelector((state) => state.addresses);
  const addressActions = actions.addresses;
  const { returnFetchData: getCities } = useFetchData();
  const { returnFetchData: getStreets } = useFetchData();

  const dispatch = (action: AnyAction, updatedValue: string) => {
    enableSave && enableSave();
    dispatcher(action);
    setUpdatedValues && setUpdatedValues(updatedValue);
  };

  const isMainAddressInCroatia = () => {
    return (
      addressValues.country === countryNames.value ||
      addressValues.country === countryNames.label
    );
  };

  const isDispatchAddressInCroatia = () => {
    return (
      addressValues.dispatchCountry === countryNames.value ||
      addressValues.dispatchCountry === countryNames.label
    );
  };

  const searchCitiesByName = async (cityName: string) => {
    return await getCities(
      "GET",
      `/o/agent-portal/address/city?cityName=${cityName}`
    );
  };

  const searchStreetsByCityIdAndName =
    (cityId: number) => async (streetName: string) => {
      return await getStreets(
        "GET",
        `/o/agent-portal/address/streets?cityId=${cityId}&streetName=${streetName}`
      );
    };

  useEffect(() => {
    setDisableFields(
      (contactType === contactTypes.Legal_Entity &&
        operation !== contactOperations.create) ||
        operation === contactOperations.updateReadOnly
    );
  }, [contactType]);

  return [
    { disableFields, contactType, ...addressValues },
    addressActions,
    {
      isMainAddressInCroatia,
      isDispatchAddressInCroatia,
      searchCitiesByName,
      searchStreetsByCityIdAndName,
    },
    dispatch,
  ] as const;
}
