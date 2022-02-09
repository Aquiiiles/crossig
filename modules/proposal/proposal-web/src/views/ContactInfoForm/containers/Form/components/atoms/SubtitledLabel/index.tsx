import ClayForm from "@clayui/form";
import React from "react";
import { Wrapper } from "./styles";

interface props {
  title: string;
  padded: boolean;
  subTitle: string;
}

const SubtitledLabel: React.FC<props> = (props) => {
  return (
    <Wrapper>
      <ClayForm.Group className={props.padded ? "padded" : ""}>
        <label>{props.title}</label>
        <ClayForm.Text>{props.subTitle}</ClayForm.Text>
      </ClayForm.Group>
    </Wrapper>
  );
};

export default SubtitledLabel;