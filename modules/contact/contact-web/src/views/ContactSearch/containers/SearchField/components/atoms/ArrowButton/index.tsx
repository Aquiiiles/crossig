import React from "react";

import ClayIcon from "@clayui/icon";
import spritemap from "@clayui/css/lib/images/icons/icons.svg";
import { Button } from "./styles";

interface props {
  onClick: () => void;
}

const ArrowButton: React.FC<props> = ({  onClick }: props) => {
  return (
    <Button displayType={null} onClick={onClick}>
      <ClayIcon symbol="angle-down" spritemap={spritemap} />
    </Button>
  );
};

export default ArrowButton;
