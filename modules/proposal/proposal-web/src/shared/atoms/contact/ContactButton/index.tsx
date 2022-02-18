import React, { MouseEventHandler } from "react";
import { Button } from "./styles";

interface props {
  handleClick: MouseEventHandler;
  label:string;
}

const ContactButton: React.FC<props> = ({ handleClick, label }: props) => {
  return <Button onClick={handleClick}>{label}</Button>;
};

export default ContactButton;