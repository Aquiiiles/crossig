import React, { ChangeEventHandler } from "react";
import { StyledSelect } from "./styles";
import { ClaySelect } from "@clayui/form";

export interface PhoneNumber {
  type: string;
  countryCode: string;
  areaCode: string;
  phoneNumber: string;
}

interface props {
  id: string;
  className: string;
  entity: any;
  handleChange: ChangeEventHandler;
  options: Array<any>;
}

const AreaCodeSelect: React.FC<props> = (props) => {
  const defaultAreaCodeOption = {
    value: "",
    label: "Area Code",
  };

  return (
    <StyledSelect
      aria-label="Select Label"
      id={props.id}
      className={props.className}
      onChange={props.handleChange}
      value={props.entity}
    >
      <ClaySelect.Option
        className="area-code-default-option"
        disabled={true}
        key={defaultAreaCodeOption.value}
        label={defaultAreaCodeOption.label}
        value={defaultAreaCodeOption.value}
      />
      {props.options.map((item) => (
        <ClaySelect.Option
          className="area-code-option"
          key={item.value}
          label={item.label}
          value={item.value}
        />
      ))}
    </StyledSelect>
  );
};

export default AreaCodeSelect;
