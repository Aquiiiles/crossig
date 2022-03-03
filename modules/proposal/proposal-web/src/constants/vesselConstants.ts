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

const FIELD_MAX_LENGTH = 12;
export const MAXIMUM_LENGTH_FOR_REGISTRATION_MARK = FIELD_MAX_LENGTH;
export const MAXIMUM_LENGTH_FOR_NIB = FIELD_MAX_LENGTH;
export const MINIMUM_LENGTH_FOR_SEARCH = 3;
