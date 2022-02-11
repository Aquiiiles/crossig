import { ClaySelectWithOption } from "@clayui/form";
import React from "react";
import { Wrapper } from "./styles";

interface props {
  index:number;
  options: Array<any>;
  title: string;
  padded: boolean;
}

const getComponentId = (index:number) => {
  return 'subtitled-select-' + index;
}

const SubtitledSelect: React.FC<props> = (props) => {
  return (
    <Wrapper>
      <label htmlFor={getComponentId(props.index)}>{props.title}</label>
      <ClaySelectWithOption
        id={getComponentId(props.index)}
        aria-label="Select Label"
        options={props.options}
        // className={props.padded ? "padded" : ""}
      />
    </Wrapper>
  );
};

export default SubtitledSelect;
