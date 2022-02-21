import React from "react";
import { Wrapper } from "./style";

interface props {
  children: React.ReactNode;
}

const FormGrid: React.FC<props> = ({ children }: props) => {
  return <Wrapper>{children}</Wrapper>;
};

export default FormGrid;
