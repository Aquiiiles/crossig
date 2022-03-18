import React from "react";
import { Wrapper } from "./style";
interface Props extends React.HTMLAttributes<HTMLDivElement> {
  half?: boolean;
}

const Row: React.FC<Props> = ({ children, half = false, ...props }) => {
  return (
    <Wrapper half={half} {...props}>
      {children}
    </Wrapper>
  );
};

export default Row;
