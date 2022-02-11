import React, { useState, useEffect, useCallback } from "react";
import { Wrapper } from "./style";
import BasicInfo from "./components/molecules/BasicInfo";
import Addresses from "./components/molecules/Addresses";
import ContactInfoForm from "./components/molecules/ContactInfoForm";
import { Provider as ContactInfoProvider } from "react-redux";
import { CREATE_NEW_CONTACT } from "../../../../constants/languageKeys";
import { 
	mapToAddressCountries,
  mapToContactInfoFormCountries
 } from "../../../../shared/util/countryMappers";

import store from "./contactStore";

declare const Liferay: any;

const ContactInfo: React.FC = () => {
	const [countries, setCountries] = useState<{ label: any; value: any; }[]>();

	const loadCountries = useCallback(() => {
		Liferay.Service(
			"/country/get-countries",
			{
				active: true
			},
			(countriesArray: Array<any>) => {
				setCountries(countriesArray);
			}
		);
	}, []);

	useEffect(() => {
		loadCountries();
	}, [loadCountries]);

	return (
		<ContactInfoProvider store={store}>
			<Wrapper id='ContactInfo-main-container'>
				<h3>{CREATE_NEW_CONTACT.TITLE}</h3>
				<p style={{ marginBottom: "1.875rem" }}>
					{CREATE_NEW_CONTACT.SUBTITLE}
				</p>
				<BasicInfo />
				{countries && <Addresses countries={mapToAddressCountries(countries)} />}
				{countries && <ContactInfoForm countries={mapToContactInfoFormCountries(countries)} />}
			</Wrapper>
		</ContactInfoProvider>
	);
};

export default ContactInfo;
