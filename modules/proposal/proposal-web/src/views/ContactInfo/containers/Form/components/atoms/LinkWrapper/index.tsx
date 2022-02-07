import React, { MouseEventHandler } from "react";
import ClayLink from '@clayui/link';
import { Wrapper } from "./styles";

interface props {
  title: string;
  handleClick: MouseEventHandler;
}

const LinkWrapper: React.FC<props> = ({ handleClick, title }: props) => {
  return (
    <Wrapper>
        <ClayLink onClick={handleClick}>{title}</ClayLink>
    </Wrapper>
  );
};

export default LinkWrapper;