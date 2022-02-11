import React, { ChangeEventHandler, useEffect } from "react";
import { useFetchData } from "../../../api/hooks/useFetchData";
import { AREA_CODE_URL } from "../../../api/constants/routes";
import { StyledSelect } from "./styles";
import { ClaySelect } from "@clayui/form";

type propsType = {
  id: string;
  disabled: boolean;
  className: string;
  entity: any;
  handleChange: ChangeEventHandler;
};

type AreaCodeType = {
  area_name: string;
  area_code: number;
};

interface AreaCodeOption {
  label: string;
  value: string;
  key: string;
}

interface State {
  status: string;
  response: {
    data: {
      area_codes: Array<AreaCodeType>;
    };
  };
  statusMessage: string;
  statusCode: string;
}

const AreaCodeSelect: React.FC<propsType> = (props: propsType) => {
  const { state, get: getAreaCodes } = useFetchData();
  const [areaCodeOptions, setAreaCodeOptions] = React.useState([
    {} as AreaCodeOption,
  ]);
  const areaCodeData = state as State;

  useEffect(() => {
    getAreaCodes(AREA_CODE_URL, {});
  }, []);

  useEffect(() => {
    if (areaCodeData.response.data?.area_codes) {
      const codes = areaCodeData.response.data.area_codes.map((item, index) => {
        return {
          label: item.area_code.toString(),
          value: item.area_code.toString(),
          key: index.toString(),
        };
      });

      setAreaCodeOptions(codes);
    }
  }, [areaCodeData]);

  const defaultAreaCodeOption = {
    key: "default",
    value: "",
    label: "Area Code",
  };

  return (
    <StyledSelect
      aria-label="Select Label"
      id={props.id}
      disabled={props.disabled}
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
      {areaCodeOptions &&
        areaCodeOptions.map((item: AreaCodeOption) => (
          <ClaySelect.Option
            className="area-code-option"
            key={item.key}
            label={item.label}
            value={item.value}
          />
        ))}
    </StyledSelect>
  );
};

export default AreaCodeSelect;
