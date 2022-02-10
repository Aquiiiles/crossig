import React, { MouseEventHandler } from "react";
import { Button } from "./styles";
import { CONTACT_INFO_CREATE_CONTACT } from "../../../../../../../constants/languageKeys";

interface props {
  handleClick: MouseEventHandler;
}

const CreateContactButton: React.FC<props> = ({ handleClick }: props) => {
  return (
    <Button 
      onClick={handleClick}>
      {CONTACT_INFO_CREATE_CONTACT}
    </Button>
  );
};

export default CreateContactButton;
