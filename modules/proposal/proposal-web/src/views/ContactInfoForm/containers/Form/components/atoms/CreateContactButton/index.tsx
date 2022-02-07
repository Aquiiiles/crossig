import React, { MouseEventHandler } from "react";
import { Button } from "./styles";

interface props {
  handleClick: MouseEventHandler;
}

const CreateContactButton: React.FC<props> = ({ handleClick }: props) => {
  return (
    <Button 
      onClick={handleClick}>
      Create Contact
    </Button>
  );
};

export default CreateContactButton;
