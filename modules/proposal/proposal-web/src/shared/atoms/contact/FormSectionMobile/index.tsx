import React from "react";
import FormGridMobile from "../FormGridMobile";
import SectionTitle from "../SectionTitle";
import { Wrapper } from "./styles";

interface Props extends React.HTMLAttributes<HTMLDivElement> {
  title?: string;
}

const FormSectionMobile: React.FC<Props> = ({ title, children, ...props }) => {
  return (
    <Wrapper {...props}>
      {title != null ? <SectionTitle title={title} /> : null}
      <FormGridMobile>{children}</FormGridMobile>
    </Wrapper>
  );
};

export default FormSectionMobile;
