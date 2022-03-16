import React from "react";
import { LinkWrapper } from "./styles";
import { Link } from "react-router-dom";
import { PROPOSAL } from "../../../constants/languageKeys";

const BackBtn: React.FC<{
  pathname: string;
  state: any;
  onClick?: () => void;
}> = ({ pathname, state, onClick }) => {
  return (
    <LinkWrapper onClick={onClick}>
      <Link to={{ pathname, state }}>{PROPOSAL.LINK_BACK}</Link>
    </LinkWrapper>
  );
};

export default BackBtn;
