import React, { ChangeEventHandler } from "react";
import { ClaySelectWithOption } from "@clayui/form";
import getUnicodeFlagIcon from "country-flag-icons/unicode";

interface propsType {
  id: string;
  className: string;
  countries: Array<Country>;
  entity: any;
  handleChange: ChangeEventHandler;
  disabled?: boolean;
}

export interface Country {
  label: string;
  value: string;
  flagKey: string;
}

const CountryCodeSelect: React.FC<propsType> = (props: propsType) => {
  const getFlagSVG = (country: Country) => {
    return getUnicodeFlagIcon(country.flagKey);
  };

  const createOptionsWithFlags = () => {
    return props.countries.map((country) => {
      return {
        label: getFlagSVG(country) + " " + country.label,
        value: country.value,
      };
    });
  };

  return (
    <ClaySelectWithOption
      id={props.id}
      className={props.className}
      onChange={props.handleChange}
      options={createOptionsWithFlags()}
      value={props.entity}
      disabled={props.disabled}
    />
  );
};

export default CountryCodeSelect;
