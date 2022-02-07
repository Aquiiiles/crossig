import { CREATE_NEW_CONTACT } from "./languageKeys";

export const contactTypes = {
	Individual: "1",
	Self_Employed: "2",
	Legal_Entity: "3"
};

export const contactTypeOptions = [
	{
		label: CREATE_NEW_CONTACT.FIELD.CONTACT_TYPE.INDIVIDUAL,
		value: contactTypes.Individual
	},
	{
		label: CREATE_NEW_CONTACT.FIELD.CONTACT_TYPE.SELF_EMPLOYED,
		value: contactTypes.Legal_Entity
	},
	{
		label: CREATE_NEW_CONTACT.FIELD.CONTACT_TYPE.LEGAL_ENTITY,
		value: contactTypes.Self_Employed
	}
];

export const cities = [
	{
		label: "Croatia",
		value: "1"
	},
	{
		label: "Alemanha",
		value: "2"
	},
	{
		label: "Brasil",
		value: "3"
	},
	{
		label: "EUA",
		value: "4"
	},
	{
		label: "Inglaterra",
		value: "5"
	}
];
