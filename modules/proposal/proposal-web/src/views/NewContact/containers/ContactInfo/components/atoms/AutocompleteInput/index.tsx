import React, { useCallback, useEffect, useRef, useState } from "react";
import ClayAutocomplete from "@clayui/autocomplete";
import ClayDropDown from "@clayui/drop-down";
import { MINIMUN_LENGTH_FOR_AUTOCOMPLETE_INPUT } from "../../../../../../../constants/contactConstants";
import { CREATE_NEW_CONTACT } from "../../../../../../../constants/languageKeys";

const AutoCompleteInput: React.FC<{
  label: string;
  id: string;
  active: boolean;
  getOptions: (value: string) => any;
  setParentValue: (value: any) => void;
  setPostalCode: (value: any) => void;
  isCity: boolean;
  disabled: boolean;
}> = ({
  label,
  id,
  active,
  getOptions,
  setParentValue,
  setPostalCode,
  isCity,
  disabled,
}) => {
  const [value, setValue] = useState<string>("");
  const [options, setOptions] = useState<Array<any>>();
  const [filteredOptions, setFilteredOptions] = useState<Array<any>>();
  const [showAutocomplete, setShowAutocomplete] = useState<boolean>(false);
  const [loading, setLoading] = useState<boolean>(false);
  const [getNewOptions, setGetNewOptions] = useState<boolean>(true);
  const dropdownRef = useRef<HTMLInputElement>(null);

  const updateOptions = useCallback(
    (value: string) => {
      if (value?.length > MINIMUN_LENGTH_FOR_AUTOCOMPLETE_INPUT) {
        setLoading(true);
        if (getNewOptions) {
          getOptions(value).then((newOptions: Array<any>) => {
            setOptions(newOptions);
            setFilteredOptions(
              newOptions?.filter((option) =>
                isCity
                  ? option.cityName.toLowerCase().includes(value.toLowerCase())
                  : option.toLowerCase().includes(value.toLowerCase())
              )
            );
            setGetNewOptions(false);
          });
        } else {
          setFilteredOptions(
            options?.filter((option) =>
              isCity
                ? option.cityName.toLowerCase().includes(value.toLowerCase())
                : option.toLowerCase().includes(value.toLowerCase())
            )
          );
        }
        setLoading(false);
      } else {
        if (!getNewOptions) {
          setGetNewOptions(true);
        }
      }
    },
    [getNewOptions, getOptions, isCity, options]
  );

  const closeDropdown = (event: Event) => {
    if (
      dropdownRef.current &&
      !dropdownRef.current.contains(event.target as Node)
    ) {
      setShowAutocomplete(false);
    }
  };

  const createCityFullName = (
    cityName: string,
    postName: string,
    boxNumber: string
  ) =>
    cityName +
    " - " +
    (postName || "postName") +
    " - " +
    (boxNumber || "boxNumber");

  useEffect(() => updateOptions(value), [updateOptions, value]);
  useEffect(() => {
    document.addEventListener("click", closeDropdown, true);
  });

  return (
    <>
      <label htmlFor={id}>{label}</label>
      <ClayAutocomplete>
        <ClayAutocomplete.Input
          onChange={(event) => {
            setValue(event.target.value);
            setParentValue(event.target.value);
          }}
          value={value}
          id={id}
          onFocus={() => setShowAutocomplete(true)}
          ref={dropdownRef}
          autoComplete="off"
          disabled={disabled}
        />
        <ClayAutocomplete.DropDown
          active={
            active &&
            !!options &&
            value?.length > MINIMUN_LENGTH_FOR_AUTOCOMPLETE_INPUT &&
            showAutocomplete
          }
        >
          <ClayDropDown.ItemList>
            {(!filteredOptions || filteredOptions?.length === 0) && (
              <ClayDropDown.Item className="disabled">
                {CREATE_NEW_CONTACT.NO_RESULTS_FOUND}
              </ClayDropDown.Item>
            )}
            {filteredOptions &&
              filteredOptions.map((item, index) => (
                <ClayAutocomplete.Item
                  key={index}
                  match={value}
                  value={
                    isCity
                      ? createCityFullName(
                          item.cityName,
                          item.postName,
                          item.boxNumber
                        )
                      : item
                  }
                  onClick={() => {
                    setValue(isCity ? item.cityName : item);
                    setParentValue(item.cityId);
                    setPostalCode(item.boxNumber || "boxNumber");
                  }}
                />
              ))}
          </ClayDropDown.ItemList>
        </ClayAutocomplete.DropDown>
        {loading && <ClayAutocomplete.LoadingIndicator />}
      </ClayAutocomplete>
    </>
  );
};

AutoCompleteInput.defaultProps = {
  setParentValue: () => {
    return;
  },
  setPostalCode: () => {
    return;
  },
  isCity: false,
};

export default AutoCompleteInput;
