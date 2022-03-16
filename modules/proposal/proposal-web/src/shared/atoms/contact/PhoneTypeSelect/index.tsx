import { ClaySelect } from "@clayui/form";
import React from "react";
import { CONTACT_INFO } from "../../../../constants/languageKeys";
import { FIXED, MOBILE } from "../../../../constants/contactConstants";
import { PhoneNumber } from "../../../types/contact";
import { Wrapper } from "./styles";
import { shouldDisableInput } from "../../../util/commonFunctions";

interface Props extends React.HTMLAttributes<HTMLDivElement> {
  index: number;
  title: string;
  handleChange: (index: number, e: React.ChangeEvent, property: string) => void;
  entity: Array<PhoneNumber>;
  disableInput?: boolean;
}

const getComponentId = (index: number) => {
  return "subtitled-select-" + index;
};

const PhoneTypeSelect: React.FC<Props> = ({
  index,
  title,
  handleChange,
  entity,
  ...props
}) => {
  return (
    <Wrapper {...props}>
      <label htmlFor={getComponentId(index)}>{title}</label>
      <ClaySelect
        aria-label="Select Label"
        id={getComponentId(index)}
        onChange={(e) => handleChange(index, e, "type")}
        value={entity[index].type}
        disabled={shouldDisableInput(props)}
      >
        <ClaySelect.Option
          selected
          key={"fixed" + "-" + index}
          label={CONTACT_INFO.OTHER_MOBILE_PHONES_FIXED}
          value={FIXED}
        />
        <ClaySelect.Option
          selected
          key={"mobile" + "-" + index}
          label={CONTACT_INFO.OTHER_MOBILE_PHONES_MOBILE}
          value={MOBILE}
        />
      </ClaySelect>
    </Wrapper>
  );
};

export default PhoneTypeSelect;
