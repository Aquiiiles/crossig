import { CREATE_NEW_CONTACT } from "./languageKeys";

export const contactTypes = {
  Individual: "1",
  Self_Employed: "2",
  Legal_Entity: "3",
};

export const contactTypeOptions = [
  {
    label: CREATE_NEW_CONTACT.FIELD.CONTACT_TYPE.INDIVIDUAL,
    value: contactTypes.Individual,
  },
  {
    label: CREATE_NEW_CONTACT.FIELD.CONTACT_TYPE.SELF_EMPLOYED,
    value: contactTypes.Self_Employed,
  },
  {
    label: CREATE_NEW_CONTACT.FIELD.CONTACT_TYPE.LEGAL_ENTITY,
    value: contactTypes.Legal_Entity,
  },
];

export const filterTypeOptions = [
  {
    label: CREATE_NEW_CONTACT.FIELD.CONTACT_TYPE.INDIVIDUAL,
    value: "Individual",
  },
  {
    label: CREATE_NEW_CONTACT.FIELD.CONTACT_TYPE.SELF_EMPLOYED,
    value: "Legal Entity",
  },
  {
    label: CREATE_NEW_CONTACT.FIELD.CONTACT_TYPE.LEGAL_ENTITY,
    value: "Self Employed",
  },
];

export const MINIMUN_LENGTH_FOR_AUTOCOMPLETE_INPUT = 2;

export const MAXIMUM_EMAIL_ADDRESSES = 4;
export const MAXIMUM_MOBILE_PHONES = 4;

export const FIXED = "fixed";
export const MOBILE = "mobile";
