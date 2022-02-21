import React from "react";
import { Wrapper } from "./style";

interface props {
  half?: boolean;
  children: React.ReactNode;
}

const Row: React.FC<props> = ({ children, half = false }: props) => {
  return <Wrapper half={half}>{children}</Wrapper>;
};

export default Row;
