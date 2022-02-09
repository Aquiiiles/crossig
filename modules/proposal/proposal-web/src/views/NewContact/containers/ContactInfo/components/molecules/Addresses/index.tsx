import React, { useCallback, useEffect, useState } from "react";
import { FormSection, SectionSubTitle, Row } from "../../atoms";
import ClayForm, {
	ClayInput,
	ClayCheckbox,
	ClaySelectWithOption
} from "@clayui/form";
import ClayAutocomplete from "@clayui/autocomplete";
import ClayDropDown from "@clayui/drop-down";
import {
	contactTypes,
	croatiaCountryObject,
	citiesMock
} from "../../../../../../../constants/contactConstants";
import { CREATE_NEW_CONTACT } from "../../../../../../../constants/languageKeys";
import { useContactSelector } from "../../../contactStore";
import { Line } from "./styles";

const Addresses: React.FC<{ countries: Array<Object> }> = ({ countries }) => {
	const [country, setCountry] = useState<Object>(croatiaCountryObject);
	const [cities, setCities] = useState<Array<any>>(citiesMock);
	const [cityName, setCityName] = useState<string>("");
	const [loading, setLoading] = useState<boolean>(false);
	const [sameAddress, setSameAdress] = useState(true);
	const { contactType } = useContactSelector(
		(state: { basicInfo: any }) => state.basicInfo
	);

	const searchCitiesByName = useCallback(() => {
		if (cityName?.length > 2) {
			setLoading(true);
			setCities(citiesMock);
			setLoading(false);
		}
	}, [cityName]);

	useEffect(() => searchCitiesByName, [searchCitiesByName, cityName]);

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
							onChange={(country) => setCountry(country)}
							required
						/>
					</ClayForm.Group>
				</Row>

				<Row>
					<ClayForm.Group>
						<ClayInput.Group>
							<ClayInput.GroupItem>
								<label htmlFor='city'>{CREATE_NEW_CONTACT.FIELD.CITY}</label>

								<ClayAutocomplete>
									<ClayAutocomplete.Input
										onChange={(event: {
											target: { value: React.SetStateAction<string> };
										}) => setCityName(event.target.value)}
										value={cityName}
										id='city'
									/>
									<ClayAutocomplete.DropDown
										active={
											country === croatiaCountryObject &&
											!!cities &&
											cityName?.length > 2
										}
										closeOnClickOutside
									>
										<ClayDropDown.ItemList>
											{cities &&
												cities.map((item) => (
													<ClayAutocomplete.Item
														match={cityName}
														value={item}
														key={item}
														onClick={() => setCityName(item)}
													/>
												))}
										</ClayDropDown.ItemList>
									</ClayAutocomplete.DropDown>
									{loading && <ClayAutocomplete.LoadingIndicator />}
								</ClayAutocomplete>
							</ClayInput.GroupItem>

							<ClayInput.GroupItem>
								<label htmlFor='postal-code'>
									{CREATE_NEW_CONTACT.FIELD.POSTAL_CODE}
								</label>

								<ClayInput id='postal-code' type='text' />
							</ClayInput.GroupItem>
						</ClayInput.Group>
					</ClayForm.Group>
				</Row>

				<ClayForm.Group>
					<label htmlFor='street-address'>
						{CREATE_NEW_CONTACT.FIELD.STREET_ADDRESS}
					</label>

					<ClayInput id='street-address' type='text' required={true} />
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
								/>
							</ClayForm.Group>
						</Row>

						<Row>
							<ClayForm.Group>
								<ClayInput.Group>
									<ClayInput.GroupItem>
										<label htmlFor='dispatch-city'>
											{CREATE_NEW_CONTACT.FIELD.CITY}
										</label>

										<ClayInput
											id='dispatch-city'
											aria-required={true}
											type='text'
											required={true}
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
							<label htmlFor='dispatch-street-address'>
								{CREATE_NEW_CONTACT.FIELD.STREET_ADDRESS}
							</label>

							<ClayInput id='dispatch-street-address' type='text' />
						</ClayForm.Group>

						<Row half>
							<ClayForm.Group>
								<label htmlFor='dispatch-house-number'>
									{CREATE_NEW_CONTACT.FIELD.HOUSE_NUMBER}
								</label>

								<ClayInput id='dispatch-house-number' type='text' />
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
