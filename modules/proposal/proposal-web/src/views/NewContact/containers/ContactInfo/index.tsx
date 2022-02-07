import React from "react";
import { Wrapper } from "./style";
import BasicInfo from "./components/molecules/BasicInfo";
import Addresses from "./components/molecules/Addresses";
import { cities } from "../../../../constants/contactConstants";
import { Provider as ContactInfoProvider } from "react-redux";
import { CREATE_NEW_CONTACT } from "../../../../constants/languageKeys";
import store from "./contactStore";

const ContactInfo: React.FC = () => {
	return (
		<ContactInfoProvider store={store}>
			<Wrapper id='ContactInfo-main-container'>
				<h3>{CREATE_NEW_CONTACT.TITLE}</h3>
        <p style={{ marginBottom: "1.875rem" }}>
          {CREATE_NEW_CONTACT.SUBTITLE}
        </p>
				<BasicInfo />
				<Addresses cities={cities} />
			</Wrapper>
		</ContactInfoProvider>
	);
};

export default ContactInfo;
