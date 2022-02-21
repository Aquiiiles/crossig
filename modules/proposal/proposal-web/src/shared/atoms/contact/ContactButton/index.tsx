import React, { MouseEventHandler } from "react";
import { Button } from "./styles";

interface props {
  disabled?: boolean;
  handleClick: MouseEventHandler;
  label: string;
}

const ContactButton: React.FC<props> = ({
  disabled,
  handleClick,
  label,
}: props) => {
  return (
    <Button onClick={handleClick} disabled={disabled}>
      {label}
    </Button>
  );
};

export default ContactButton;
