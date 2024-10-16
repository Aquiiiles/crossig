import React from "react";
import FormGrid from "../FormGrid";
import SectionTitle from "../SectionTitle";
import { Wrapper } from "./styles";

interface Props extends React.HTMLAttributes<HTMLDivElement> {
  title?: string;
}

const FormSection: React.FC<Props> = ({ title, children, ...props }) => {
  return (
    <Wrapper {...props}>
      {title != null ? <SectionTitle title={title} /> : null}
      <FormGrid>{children}</FormGrid>
    </Wrapper>
  );
};

export default FormSection;
