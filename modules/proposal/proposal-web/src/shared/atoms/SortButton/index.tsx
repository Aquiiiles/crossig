import React from "react";
import { Button } from "./styles";
import { ReactComponent as FilterIcon } from "../../../assets/filterIcon.svg";

const SortButton: React.FC<React.ButtonHTMLAttributes<HTMLButtonElement>> = (
  props
) => {
  return (
    <Button displayType="unstyled" {...props}>
      <FilterIcon />
    </Button>
  );
};

export default SortButton;
