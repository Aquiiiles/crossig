import React, { MouseEventHandler } from "react";
import ClayLink from "@clayui/link";
import { Wrapper } from "./styles";

interface props {
  title: string;
  disabled: boolean;
  handleClick: MouseEventHandler;
}

const LinkWrapper: React.FC<props> = props => {
  return (
    <Wrapper>
      <ClayLink
        onClick={props.handleClick}
        className={props.disabled ? "disabled" : "active"}
      >
        {props.title}
      </ClayLink>
    </Wrapper>
  );
};

export default LinkWrapper;
