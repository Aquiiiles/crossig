import ClayForm, { ClaySelectWithOption } from "@clayui/form";
import React from "react";
import { Wrapper } from "./styles";

interface props {
  options: Array<any>;
  subTitle: string;
}

const SubtitledSelect: React.FC<props> = (props) => {
  return (
    <Wrapper>
      <ClaySelectWithOption
        aria-label="Select Label"
        options={props.options}
        className="padded-select"
      />
      <ClayForm.Text>{props.subTitle}</ClayForm.Text>
    </Wrapper>
  );
};

export default SubtitledSelect;
