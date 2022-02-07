import ClayForm from "@clayui/form";
import React from "react";
import { Wrapper } from "./styles";

interface props {
  title: string;
  subTitle: string;
}

const SubtitledLabel: React.FC<props> = ({ title, subTitle }: props) => {
  return (
    <Wrapper>
      <ClayForm.Group>
        <h5>{title}</h5>
        <ClayForm.Text>{subTitle}</ClayForm.Text>
      </ClayForm.Group>
    </Wrapper>
  );
};

export default SubtitledLabel;