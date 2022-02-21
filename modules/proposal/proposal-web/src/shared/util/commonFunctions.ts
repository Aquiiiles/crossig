import { PhoneNumber } from "../types/contact";
import { countryCodes } from "../../constants/defaultCountryConfiguration";

export const createEmptyPhoneNumber = (type: string) => {
  return {
    type: type,
    areaCode: "",
    countryCode: countryCodes.value,
    phoneNumber: "",
  } as PhoneNumber;
};

export const shouldDisableInput = (props:any) => {
  let shouldDisable = false;

  if (props.disableInput) {
    shouldDisable = props.disableInput
  }

  return shouldDisable;
};