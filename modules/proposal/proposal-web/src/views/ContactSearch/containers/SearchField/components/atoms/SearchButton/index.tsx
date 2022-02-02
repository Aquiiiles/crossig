import React from "react";

import ClayIcon from "@clayui/icon";
import spritemap from "@clayui/css/lib/images/icons/icons.svg";
import { Button } from "./styles";

interface props {
  disabled: boolean;
  onClick: () => void;
}

const SearchButton: React.FC<props> = ({ disabled, onClick }: props) => {
  return (
    <Button displayType="secondary" disabled={disabled} onClick={onClick}>
      <ClayIcon symbol="search" spritemap={spritemap} />
    </Button>
  );
};

export default SearchButton;
