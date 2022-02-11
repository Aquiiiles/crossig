import React, { useState } from "react";
import {
	AutocompleteInput,
	FormSection,
	Row,
	SectionSubTitle
} from "../../atoms";
import ClayForm, {
	ClayInput,
	ClayCheckbox,
	ClaySelectWithOption
} from "@clayui/form";
import {
	contactTypes,
	croatiaCountryObject
} from "../../../../../../../constants/contactConstants";
import { CREATE_NEW_CONTACT } from "../../../../../../../constants/languageKeys";
import { useContactSelector } from "../../../contactStore";
import { Line } from "./styles";
import { searchCitiesByName, searchStreetsByCityIdAndName } from "./controller";

const Addresses: React.FC<{ countries: Array<Object> }> = ({ countries }) => {
	const [country, setCountry] = useState<string>(croatiaCountryObject.value);
	const [dispatchCountry, setDispatchCountry] = useState<string>(
		croatiaCountryObject.value
	);
	const [city, setCity] = useState<any>();
	const [dispatchCity, setDispatchCity] = useState<any>();
	const [sameAddress, setSameAdress] = useState(true);
	const [postalCode, setPostalCode] = useState<string>();
	const [dispatchPostalCode, setDispatchPostalCode] = useState<string>();
	const { contactType } = useContactSelector(
		(state: { basicInfo: any }) => state.basicInfo
	);

	return (
		<>
			<Line />
			<FormSection title={CREATE_NEW_CONTACT.ADDRESS_TITLE}>
				<SectionSubTitle
					subTitle={
						contactType === contactTypes.Individual
							? CREATE_NEW_CONTACT.ID_ADDRES
							: CREATE_NEW_CONTACT.REGISTERED_OFFICE_ADDRESS
					}
				/>

				<Row half>
					<ClayForm.Group>
						<label htmlFor='country'>{CREATE_NEW_CONTACT.FIELD.COUNTRY}</label>
						<ClaySelectWithOption
							id='country'
							options={countries}
							onChange={(event) => setCountry(event.target.value)}
							required
						/>
					</ClayForm.Group>
				</Row>

				<Row>
					<ClayForm.Group>
						<ClayInput.Group>
							<ClayInput.GroupItem>
								<AutocompleteInput
									label={CREATE_NEW_CONTACT.FIELD.CITY}
									id={"city"}
									active={country === croatiaCountryObject.value}
									getOptions={searchCitiesByName}
									setParentValue={setCity}
									setPostalCode={setPostalCode}
									isCity
								/>
							</ClayInput.GroupItem>

							<ClayInput.GroupItem>
								<label htmlFor='postal-code'>
									{CREATE_NEW_CONTACT.FIELD.POSTAL_CODE}
								</label>

								<ClayInput
									id='postal-code'
									type='text'
									disabled
									value={postalCode}
								/>
							</ClayInput.GroupItem>
						</ClayInput.Group>
					</ClayForm.Group>
				</Row>

				<ClayForm.Group>
					<AutocompleteInput
						label={CREATE_NEW_CONTACT.FIELD.STREET_ADDRESS}
						id={"street-addres"}
						active={country === croatiaCountryObject.value}
						getOptions={searchStreetsByCityIdAndName(city)}
						setParentValue={() => {
							return;
						}}
						setPostalCode={() => {
							return;
						}}
						isCity={false}
					/>
				</ClayForm.Group>

				<Row half>
					<ClayForm.Group>
						<label htmlFor='house-number'>
							{CREATE_NEW_CONTACT.FIELD.HOUSE_NUMBER}
						</label>

						<ClayInput id='house-number' type='text' />
					</ClayForm.Group>
				</Row>

				<SectionSubTitle subTitle={CREATE_NEW_CONTACT.DISPATCH_ADDRESS} />

				<ClayCheckbox
					checked={sameAddress}
					onChange={() => setSameAdress((val) => !val)}
					label={CREATE_NEW_CONTACT.FIELD.DISPATCH_ADDRESS}
				/>

				{!sameAddress && (
					<>
						<Row half>
							<ClayForm.Group>
								<label htmlFor='dispatch-country'>
									{CREATE_NEW_CONTACT.FIELD.COUNTRY}
								</label>
								<ClaySelectWithOption
									id='dispatch-country'
									options={countries}
									required
									onChange={(event) => setDispatchCountry(event.target.value)}
								/>
							</ClayForm.Group>
						</Row>

						<Row>
							<ClayForm.Group>
								<ClayInput.Group>
									<ClayInput.GroupItem>
										<AutocompleteInput
											label={CREATE_NEW_CONTACT.FIELD.CITY}
											id={"dispatch-city"}
											active={dispatchCountry === croatiaCountryObject.value}
											getOptions={searchCitiesByName}
											setParentValue={setDispatchCity}
											setPostalCode={setDispatchPostalCode}
											isCity
										/>
									</ClayInput.GroupItem>

									<ClayInput.GroupItem>
										<label htmlFor='dispatch-postal-code'>
											{CREATE_NEW_CONTACT.FIELD.POSTAL_CODE}
										</label>

										<ClayInput id='dispatch-postal-code' type='text' />
									</ClayInput.GroupItem>
								</ClayInput.Group>
							</ClayForm.Group>
						</Row>

						<ClayForm.Group>
							<AutocompleteInput
								label={CREATE_NEW_CONTACT.FIELD.STREET_ADDRESS}
								id={"dispatch-street-addres"}
								active={dispatchCountry === croatiaCountryObject.value}
								getOptions={searchStreetsByCityIdAndName(dispatchCity)}
								setParentValue={() => {
									return;
								}}
								setPostalCode={() => {
									return;
								}}
								isCity={false}
							/>
						</ClayForm.Group>

						<Row half>
							<ClayForm.Group>
								<label htmlFor='dispatch-house-number'>
									{CREATE_NEW_CONTACT.FIELD.HOUSE_NUMBER}
								</label>

								<ClayInput
									id='dispatch-house-number'
									type='text'
									disabled
									value={dispatchPostalCode}
								/>
							</ClayForm.Group>
						</Row>
					</>
				)}
			</FormSection>
			<Line />
		</>
	);
};

export default Addresses;
