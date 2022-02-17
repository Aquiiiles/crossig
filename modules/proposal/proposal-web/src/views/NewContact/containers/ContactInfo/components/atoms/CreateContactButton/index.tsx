import React from "react";
import { Button } from "./styles";
import { CONTACT_INFO_CREATE_CONTACT } from "../../../../../../../constants/languageKeys";

const CreateContactButton: React.FC = () => {
  return <Button type="submit">{CONTACT_INFO_CREATE_CONTACT}</Button>;
};

export default CreateContactButton;
