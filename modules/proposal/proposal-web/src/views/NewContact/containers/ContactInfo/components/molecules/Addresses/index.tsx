import React, {useState} from "react"
import {FormSection} from "../../atoms"
import ClayForm, {
	ClayInput,
	ClayCheckbox,
	ClaySelectWithOption
} from "@clayui/form"
import {ContactType} from "../../../../../../../constants/contactConstants"
import {
	CREATE_NEW_CONTACT_ADDRESS_TITLE,
	CREATE_NEW_CONTACT_ID_ADDRES,
	CREATE_NEW_CONTACT_REGISTERED_OFFICE_ADDRESS,
	CREATE_NEW_CONTACT_DISPATCH_ADDRESS,
	CREATE_NEW_CONTACT_FIELD_COUNTRY,
	CREATE_NEW_CONTACT_FIELD_CITY,
	CREATE_NEW_CONTACT_FIELD_POSTAL_CODE,
	CREATE_NEW_CONTACT_FIELD_STREET_ADDRESS,
	CREATE_NEW_CONTACT_FIELD_HOUSE_NUMBER,
	CREATE_NEW_CONTACT_FIELD_DISPATCH_ADDRESS
} from "../../../../../../../constants/languageKeys"

const Addresses: React.FC<{contactType: number; cities: Array<Object>}> = ({
	contactType,
	cities
}) => {
	const [sameAddress, setSameAdress] = useState(true)

	return (
		<FormSection title={CREATE_NEW_CONTACT_ADDRESS_TITLE}>
			<span>
				{contactType === ContactType.Individual
					? CREATE_NEW_CONTACT_ID_ADDRES
					: CREATE_NEW_CONTACT_REGISTERED_OFFICE_ADDRESS}
			</span>

			<p>{CREATE_NEW_CONTACT_FIELD_COUNTRY}</p>
			<ClaySelectWithOption options={cities} />

			<ClayForm.Group>
				<ClayInput.Group>
					<ClayInput.GroupItem>
						<label htmlFor='city'>{CREATE_NEW_CONTACT_FIELD_CITY}</label>

						<ClayInput
							id='city'
							aria-required={true}
							type='text'
							required={true}
						/>
					</ClayInput.GroupItem>

					<ClayInput.GroupItem>
						<label htmlFor='postal-code'>{CREATE_NEW_CONTACT_FIELD_POSTAL_CODE}</label>

						<ClayInput id='postal-code' type='text' />
					</ClayInput.GroupItem>
				</ClayInput.Group>
			</ClayForm.Group>

			<ClayForm.Group>
				<label htmlFor='street-address'>{CREATE_NEW_CONTACT_FIELD_STREET_ADDRESS}</label>

				<ClayInput id='street-address' type='text' required={true} />
			</ClayForm.Group>

			<ClayForm.Group>
				<label htmlFor='house-number'>{CREATE_NEW_CONTACT_FIELD_HOUSE_NUMBER}</label>

				<ClayInput id='house-number' type='text' />
			</ClayForm.Group>

			<span>{CREATE_NEW_CONTACT_FIELD_DISPATCH_ADDRESS}</span>

			<ClayCheckbox
				checked={sameAddress}
				onChange={() => setSameAdress((val) => !val)}
				label={CREATE_NEW_CONTACT_DISPATCH_ADDRESS}
			/>

			{!sameAddress && (
				<>
					<ClayForm.Group>
						<label htmlFor='dispatch-country'>{CREATE_NEW_CONTACT_FIELD_COUNTRY}</label>

						<ClayInput id='dispatch-country' type='text' />
					</ClayForm.Group>

					<ClayForm.Group>
						<ClayInput.Group>
							<ClayInput.GroupItem>
								<label htmlFor='dispatch-city'>{CREATE_NEW_CONTACT_FIELD_CITY}</label>

								<ClayInput.GroupText id='dispatch-city' />
							</ClayInput.GroupItem>

							<ClayInput.GroupItem>
								<label htmlFor='dispatch-postal-code'>{CREATE_NEW_CONTACT_FIELD_POSTAL_CODE}</label>

								<ClayInput.GroupText id='dispatch-postal-code' />
							</ClayInput.GroupItem>
						</ClayInput.Group>
					</ClayForm.Group>

					<ClayForm.Group>
						<label htmlFor='dispatch-street-address'>{CREATE_NEW_CONTACT_FIELD_STREET_ADDRESS}</label>

						<ClayInput id='dispatch-street-address' type='text' />
					</ClayForm.Group>

					<ClayForm.Group>
						<label htmlFor='dispatch-house-number'>{CREATE_NEW_CONTACT_FIELD_HOUSE_NUMBER}</label>

						<ClayInput id='dispatch-house-number' type='text' />
					</ClayForm.Group>
				</>
			)}
		</FormSection>
	)
}

export default Addresses
