import React from "react";
import { FormGrid, SectionTitle } from "..";
import { Wrapper } from "./style";

interface props {
  title?: string;
  children: React.ReactNode;
}

const FormSection: React.FC<props> = ({ title, children }: props) => {
  return (
    <Wrapper>
      {title != null ? <SectionTitle title={title} /> : null}
      <FormGrid>{children}</FormGrid>
    </Wrapper>
  );
};

export default FormSection;
