import React, { useState } from "react";
import { FormSection, SectionSubTitle, Row } from "../../atoms";
import ClayForm, {
	ClayInput,
	ClayCheckbox,
	ClaySelectWithOption
} from "@clayui/form";
import { contactTypes } from "../../../../../../../constants/contactConstants";
import { CREATE_NEW_CONTACT } from "../../../../../../../constants/languageKeys";
import { useContactSelector } from "../../../contactStore";

const Addresses: React.FC<{ countries: Array<Object> }> = ({ countries }) => {
	const [sameAddress, setSameAdress] = useState(true);
	const { contactType } = useContactSelector(
		(state: { basicInfo: any }) => state.basicInfo
	);

	return (
		<FormSection title={CREATE_NEW_CONTACT.ADDRESS_TITLE}>
			<SectionSubTitle
				subTitle={
					contactType === contactTypes.Individual
						? CREATE_NEW_CONTACT.ID_ADDRES
						: CREATE_NEW_CONTACT.REGISTERED_OFFICE_ADDRESS
				}
			/>

			<Row half>
				<label htmlFor='contactTypeInput'>Type</label>
				<ClaySelectWithOption options={countries} />
			</Row>

			<Row>
				<ClayForm.Group>
					<ClayInput.Group>
						<ClayInput.GroupItem>
							<label htmlFor='city'>{CREATE_NEW_CONTACT.FIELD.CITY}</label>

							<ClayInput
								id='city'
								aria-required={true}
								type='text'
								required={true}
							/>
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

			<ClayForm.Group>
				<label htmlFor='house-number'>
					{CREATE_NEW_CONTACT.FIELD.HOUSE_NUMBER}
				</label>

				<ClayInput id='house-number' type='text' />
			</ClayForm.Group>

			<SectionSubTitle subTitle={CREATE_NEW_CONTACT.DISPATCH_ADDRESS} />

			<ClayCheckbox
				checked={sameAddress}
				onChange={() => setSameAdress((val) => !val)}
				label={CREATE_NEW_CONTACT.FIELD.DISPATCH_ADDRESS}
			/>

			{!sameAddress && (
				<>
					<strong>{CREATE_NEW_CONTACT.FIELD.COUNTRY}</strong>
					<ClaySelectWithOption options={countries} />

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

					<ClayForm.Group>
						<label htmlFor='dispatch-street-address'>
							{CREATE_NEW_CONTACT.FIELD.STREET_ADDRESS}
						</label>

						<ClayInput id='dispatch-street-address' type='text' />
					</ClayForm.Group>

					<ClayForm.Group>
						<label htmlFor='dispatch-house-number'>
							{CREATE_NEW_CONTACT.FIELD.HOUSE_NUMBER}
						</label>

						<ClayInput id='dispatch-house-number' type='text' />
					</ClayForm.Group>
				</>
			)}
		</FormSection>
	);
};

export default Addresses;
