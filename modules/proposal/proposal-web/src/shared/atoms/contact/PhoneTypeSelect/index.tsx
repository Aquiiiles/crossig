import { ClaySelect } from "@clayui/form";
import React from "react";
import { CONTACT_INFO } from "../../../../constants/languageKeys";
import { FIXED, MOBILE } from "../../../../constants/contactConstants";
import { PhoneNumber } from "../../../types/contact";
import { Wrapper } from "./styles";
import { shouldDisableInput } from "../../../util/commonFunctions";

interface props {
  index: number;
  title: string;
  handleChange: (index: number, e: React.ChangeEvent, property: string) => void;
  entity: Array<PhoneNumber>;
  disableInput?: boolean;
}

const getComponentId = (index: number) => {
  return "subtitled-select-" + index;
};

const PhoneTypeSelect: React.FC<props> = (props) => {
  return (
    <Wrapper>
      <label htmlFor={getComponentId(props.index)}>{props.title}</label>
      <ClaySelect
        aria-label="Select Label"
        id={getComponentId(props.index)}
        onChange={(e) => props.handleChange(props.index, e, "type")}
        value={props.entity[props.index].type}
        disabled={shouldDisableInput(props)}
      >
        <ClaySelect.Option
          selected
          key={"fixed" + "-" + props.index}
          label={CONTACT_INFO.OTHER_MOBILE_PHONES_FIXED}
          value={FIXED}
        />
        <ClaySelect.Option
          selected
          key={"mobile" + "-" + props.index}
          label={CONTACT_INFO.OTHER_MOBILE_PHONES_MOBILE}
          value={MOBILE}
        />
      </ClaySelect>
    </Wrapper>
  );
};

export default PhoneTypeSelect;
