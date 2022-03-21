import React, { ChangeEventHandler, useEffect } from "react";
import { useHttpRequest } from "../../../../api/hooks/useHttpRequest";
import { AREA_CODE_URL } from "../../../../api/constants/routes";
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

interface AreaCodeResponseType {
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
  const [areaCodeResponse, , { get: getAreaCodes }] = useHttpRequest();
  const [areaCodeOptions, setAreaCodeOptions] = React.useState([
    {} as AreaCodeOption,
  ]);

  useEffect(() => {
    getAreaCodes(AREA_CODE_URL);
  }, []);

  useEffect(() => {
    if (areaCodeResponse.response.data?.area_codes) {
      const codes = (
        areaCodeResponse as AreaCodeResponseType
      ).response.data.area_codes.map((item, index) => {
        return {
          label: item.area_code.toString(),
          value: item.area_code.toString(),
          key: index.toString(),
        };
      });

      setAreaCodeOptions(codes);
    }
  }, [areaCodeResponse]);

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
