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
