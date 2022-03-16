import React from "react";
import { Wrapper } from "./style";

interface Props {
  children: React.ReactNode;
}

const FormGridMobile: React.FC<Props> = ({ children }) => {
  return <Wrapper>{children}</Wrapper>;
};

export default FormGridMobile;
