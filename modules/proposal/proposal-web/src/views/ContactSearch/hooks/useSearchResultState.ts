import { useState, useEffect } from "react";
import { useSelector, useDispatch } from "../../../redux/store";
import { actions } from "../../../redux";

import * as constants from "../constants/searchResult";

import {
  providedDataType,
  responseType,
} from "../containers/SearchResult/types/searchResult";

/* eslint-disable @typescript-eslint/no-explicit-any */
export default function useSearchResultState(data: any[]) {
  const formatedData = data.map((item: providedDataType) => {
    const responseObj: responseType = {
      [constants.EXT_NUMBER_KEY]: item[constants.EXT_NUMBER_KEY],
      [constants.OIB_KEY]: item[constants.OIB_KEY],
      [constants.SUB_KEY]: "",
      [constants.DOB_KEY]: item[constants.DOB_KEY],
      [constants.NAME_KEY]:
        (item[constants.FIRST_NAME_KEY] !== null
          ? item[constants.FIRST_NAME_KEY] + " "
          : "") +
        (item[constants.NAME_KEY] !== null ? item[constants.NAME_KEY] : ""),
      [constants.STREET_KEY]: item[constants.STREET_KEY],
      [constants.CITY_KEY]: item[constants.CITY_KEY],
      [constants.TYPE_KEY]: item[constants.TYPE_KEY].desc,
      [constants.MAIL_VALIDATED_KEY]: item[constants.MAIL_VALIDATED_KEY],
      [constants.PHONE_NUMBER_VALIDATED_KEY]:
        item[constants.PHONE_NUMBER_VALIDATED_KEY],
    };
    return responseObj;
  });
  const dispatch = useDispatch();
  const [showCountryDropdown, setShowCountryDropdown] = useState(false);
  const [showSortDropdown, setShowSortDropdown] = useState(false);
  const [citySearch, setCitySearch] = useState("");
  const [filteredData, setFilteredData] = useState(formatedData);
  const cities = new Set(data.map((item: providedDataType) => item["city"]));
  const { selectedContactType, selectedCity } = useSelector(
    (state) => state.searchFilter
  );
  const { setSelectedContactType, setSelectedCity } = actions.searchFilter;

  useEffect(() => {
    if (showCountryDropdown) {
      document.getElementById("searchContactInput")?.focus();
    } else {
      document.getElementById("cityFilterField")?.blur();
      setCitySearch("");
    }
  }, [showCountryDropdown]);

  useEffect(() => {
    setFilteredData(formatedData.filter(getDataPredicate()));
  }, [selectedCity, selectedContactType, data]);

  const getDataPredicate = () => {
    let predicate = (_item: responseType) => true;

    if (selectedContactType) {
      predicate = (item: responseType) =>
        item[constants.TYPE_KEY] === selectedContactType;
    }

    if (selectedCity) {
      predicate = (item: responseType) =>
        item[constants.CITY_KEY] === selectedCity;
    }

    if (selectedContactType && selectedCity) {
      predicate = (item: responseType) => {
        return (
          item[constants.TYPE_KEY] === selectedContactType &&
          item[constants.CITY_KEY] === selectedCity
        );
      };
    }

    return predicate;
  };

  const foundContacts = filteredData.length > 0;

  return [
    {
      filteredData,
      foundContacts,
      selectedCity,
      selectedContactType,
      citySearch,
      cities,
      showCountryDropdown,
      showSortDropdown,
    },
    {
      setCitySearch,
      setSelectedCity,
      setSelectedContactType,
      setShowCountryDropdown,
      setShowSortDropdown,
    },
    dispatch,
  ] as const;
}
