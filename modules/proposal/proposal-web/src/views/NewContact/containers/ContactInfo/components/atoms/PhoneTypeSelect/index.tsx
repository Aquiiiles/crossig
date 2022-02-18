import { ClaySelect } from "@clayui/form";
import React from "react";
import {
  CONTACT_INFO_OTHER_MOBILE_PHONES_FIXED,
  CONTACT_INFO_OTHER_MOBILE_PHONES_MOBILE,
} from "../../../../../../../constants/languageKeys";
import { FIXED, MOBILE } from "../../../../../../../constants/contactConstants";
import { PhoneNumber } from "../../../../../../../shared/types";
import { Wrapper } from "./styles";

interface props {
  index: number;
  title: string;
  handleChange: (index: number, e: React.ChangeEvent, property: string) => void;
  entity: Array<PhoneNumber>;
}

const getComponentId = (index: number) => {
  return "subtitled-select-" + index;
};

const PhoneTypeSelect: React.FC<props> = props => {
  return (
    <Wrapper>
      <label htmlFor={getComponentId(props.index)}>{props.title}</label>
      <ClaySelect
        aria-label="Select Label"
        id={getComponentId(props.index)}
        onChange={e => props.handleChange(props.index, e, "type")}
        value={props.entity[props.index].type}
      >
        <ClaySelect.Option
          selected
          key={FIXED + "-" + props.index}
          label={CONTACT_INFO_OTHER_MOBILE_PHONES_FIXED}
          value={FIXED}
        />
        <ClaySelect.Option
          selected
          key={MOBILE + "-" + props.index}
          label={CONTACT_INFO_OTHER_MOBILE_PHONES_MOBILE}
          value={MOBILE}
        />
      </ClaySelect>
    </Wrapper>
  );
};

export default PhoneTypeSelect;
