import React, { useCallback, useEffect, useRef, useState } from "react";
import ClayAutocomplete from "@clayui/autocomplete";
import ClayDropDown from "@clayui/drop-down";
import { MINIMUN_LENGTH_FOR_AUTOCOMPLETE_INPUT } from "../../../../constants/contactConstants";
import languageKeys from "../../../../constants/Language";

const { CREATE_NEW_CONTACT } = languageKeys;

type props = {
  label: string;
  id: string;
  active: boolean;
  getOptions: (value: string) => any;
  setParentValue: (parentValue: string) => void;
  setPostalCode?: (postalCode: string) => void;
  isCity: boolean;
  disabled: boolean;
  onFocus?: (event: React.FocusEvent<HTMLInputElement, Element>) => void;
  onBlur?: (event: React.FocusEvent<HTMLInputElement, Element>) => void;
  selectedValue?: string;
  required?: boolean;
};

const AutoCompleteInput: React.FC<props> = ({
  label,
  id,
  active,
  getOptions,
  setParentValue,
  setPostalCode,
  isCity,
  onFocus,
  onBlur,
  disabled,
  selectedValue,
  required,
}: props) => {
  const [value, setValue] = useState<string>(selectedValue || "");
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

  useEffect(() => updateOptions(value), [value]);
  useEffect(() => {
    document.addEventListener("click", closeDropdown, true);
    return () => document.removeEventListener("click", closeDropdown, true);
  }, []);

  return (
    <>
      <label className={required ? "required" : ""} htmlFor={id}>
        {label}
      </label>
      <ClayAutocomplete>
        <ClayAutocomplete.Input
          onChange={(event) => {
            setValue(event.target.value.toString());
            setParentValue(event.target.value.toString());
          }}
          value={value}
          id={id}
          onFocus={(e) => {
            setShowAutocomplete(true);
            onFocus && onFocus(e);
          }}
          onBlur={onBlur}
          ref={dropdownRef}
          autoComplete="off"
          disabled={disabled}
          required={required}
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
                    setParentValue(isCity ? item.cityId : item);
                    setPostalCode &&
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
