import React, { useCallback, useEffect, useRef, useState } from "react";
import ClayAutocomplete from "@clayui/autocomplete";
import ClayDropDown from "@clayui/drop-down";
import { MINIMUN_LENGTH_FOR_AUTOCOMPLETE_INPUT } from "../../../../../../../constants/contactConstants";

const AutoCompleteInput: React.FC<{
	label: string;
	id: string;
	active: boolean;
	getOptions: Function;
}> = ({ label, id, active, getOptions }) => {
	const [value, setValue] = useState<string>("");
	const [options, setOptions] = useState<Array<any>>();
	const [filteredOptions, setFilteredOptions] = useState<Array<any>>();
	const [showAutocomplete, setShowAutocomplete] = useState<boolean>(false);
	const [loading, setLoading] = useState<boolean>(false);
	const [getNewOptions, setGetNewOptions] = useState<boolean>(true);
	const dropdownRef = useRef<HTMLInputElement>(null);

	const updateOptions = useCallback((value: string) => {
		if (value?.length > MINIMUN_LENGTH_FOR_AUTOCOMPLETE_INPUT) {
			setLoading(true);
			if (getNewOptions) {
				const newOptions = getOptions(value);
				setOptions(newOptions);
				setFilteredOptions(newOptions);
				setGetNewOptions(false);
			} else {
				setFilteredOptions(options?.filter((option) => option.includes(value)));
			}
			setLoading(false);
		} else {
			if (!getNewOptions) {
				setGetNewOptions(true);
			}
		}
	},[getNewOptions, getOptions, options]);

	const closeDropdown = (event: Event) => {
		if (
			dropdownRef.current &&
			!dropdownRef.current.contains(event.target as Node)
		) {
			setShowAutocomplete(false);
		}
	};

	useEffect(() => updateOptions(value), [updateOptions, value]);
	useEffect(() => {
		document.addEventListener("click", closeDropdown, true);
	});

	return (
		<>
			<label htmlFor={id}>{label}</label>
			<ClayAutocomplete>
				<ClayAutocomplete.Input
					onChange={(event) => setValue(event.target.value)}
					value={value}
					id={id}
					onFocus={() => setShowAutocomplete(true)}
					ref={dropdownRef}
				/>
				<ClayAutocomplete.DropDown
					active={
						active &&
						!!options &&
						value?.length > MINIMUN_LENGTH_FOR_AUTOCOMPLETE_INPUT &&
						showAutocomplete
					}
				>
					<ClayDropDown.ItemList>
						{filteredOptions &&
							filteredOptions.map((item, index) => (
								<ClayAutocomplete.Item
									key={index}
									match={value}
									value={item}
									onClick={() => setValue(item)}
								/>
							))}
					</ClayDropDown.ItemList>
				</ClayAutocomplete.DropDown>
				{loading && <ClayAutocomplete.LoadingIndicator />}
			</ClayAutocomplete>
		</>
	);
};

export default AutoCompleteInput;
