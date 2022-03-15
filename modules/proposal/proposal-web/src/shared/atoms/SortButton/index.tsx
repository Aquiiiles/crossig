import React from "react";
import { Button } from "./styles";
import { ReactComponent as FilterIcon } from "../../../assets/filterIcon.svg";

type PropsType = React.ButtonHTMLAttributes<HTMLButtonElement>;

const SortButton = React.forwardRef<HTMLButtonElement, PropsType>(
  (props, ref) => {
    return (
      <Button displayType="unstyled" ref={ref} {...props}>
        <FilterIcon />
      </Button>
    );
  }
);
SortButton.displayName = "SortButton";

export default SortButton;
