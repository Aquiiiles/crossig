import React from "react";
import { Wrapper } from "./style";

interface props {
  title: string;
}

const SectionTitle: React.FC<props> = ({ title }: props) => {
  return (
    <Wrapper className="section-title">
      <h6>{title}</h6>
    </Wrapper>
  );
};

export default SectionTitle;
