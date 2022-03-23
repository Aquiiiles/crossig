import React from "react";
import { PhoneNumber } from "../types";
import { countryCodes } from "../../constants/defaultCountryConfiguration";

export const createEmptyPhoneNumber = (type: number) => {
  return {
    type: type,
    areaCode: "",
    countryCode: countryCodes.value,
    phoneNumber: "",
  } as PhoneNumber;
};

export const shouldDisableInput = (props: any) => {
  let shouldDisable = false;

  if (props.disableInput) {
    shouldDisable = props.disableInput;
  }

  return shouldDisable;
};

export const numbersOnly = (value: string) => {
  return value.replace(/\D/g, "");
};

export const lettersOnly = (value: string) => {
  return value.replace(/[^a-zA-Z]+/g, "");
};

export const handleEnterKeyEvent = (
  event: React.KeyboardEvent,
  callback: () => void
) => {
  if (event.key === "Enter") {
    callback();
  }
};

export const resetScroll = () => {
  window.scrollTo(0, 0);
};

export const resetModalScroll = () => {
  const modalBody = document.getElementsByClassName("modal-body");
  if (modalBody[0]) {
    modalBody[0].scrollTop = 0;
  }
};
