import { VESSEL, VESSEL_LOOKUP } from "../constants/languageKeys";

export const vesselTypeOptions: { label: string; value: string }[] = [
  {
    label: VESSEL_LOOKUP.FIELD.SELECT,
    value: "",
  },
  {
    label: VESSEL.TYPE.BOAT,
    value: "boat",
  },
  {
    label: VESSEL.TYPE.YATCH,
    value: "yatch",
  },
  {
    label: VESSEL.TYPE.BIG_YATCH,
    value: "big_yatch",
  },
  {
    label: VESSEL.TYPE.RIVERBOAT,
    value: "riverboat",
  },
];

export const MAXIMUM_LENGTH_FOR_NAME_OF_VESSEL = 255;
export const MAXIMUM_LENGTH_FOR_NAME_OF_FLEET = 255;
export const MAXIMUM_LENGTH_FOR_REGISTRATION_MARK = 12;
export const MAXIMUM_LENGTH_FOR_NIB = 12;
export const MINIMUM_LENGTH_FOR_SEARCH = 3;
