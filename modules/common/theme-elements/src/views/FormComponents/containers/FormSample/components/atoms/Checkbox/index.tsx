import React from "react";
import ClayForm, { ClayCheckbox } from '@clayui/form';

interface props {
  fieldName: string;
  options: any[];
  selectedValues: any[],
  showErrors: boolean;
  defaultValue: string;
  label: string;
  labelHint: string;
  disabled: boolean;
  errorMsg: string;
  required: boolean;
  handleFieldChange: any;
}

const CheckboxInput: React.FC<props> = ({
  fieldName,
  options,
  selectedValues,
  showErrors,
  defaultValue,
  label,
  labelHint,
  disabled,
  errorMsg,
  required,
  handleFieldChange
}: props) => {

	let displayError = showErrors && !defaultValue;
  const onChange = (item: any) => {
    console.log("selected", selectedValues, " | item", item);
		// handleFieldChange(fieldName, fieldValue);
	};

  const isChecked = (value: string) => {
    return selectedValues.includes(value);
  }
  
  return (
    <ClayForm.Group className={displayError ? "has-error" : ""}>
      <label className="input-label" htmlFor={fieldName}>
        {label}
        {required ? <span className="form-mandatory-field">*</span> : ''}
        {labelHint ? <small><i> {labelHint.toLowerCase()}</i></small> : ''}
      </label>
      <>
      {options.map((item, index) => (
        <ClayCheckbox
          key={index}
          label={index}
          aria-label={item.label}
          checked={isChecked(item.value)}
          value={item.value}
          onChange={() => onChange(item.value)}
          inline
        />
      ))}
      </>
      {displayError && (
      <ClayForm.FeedbackGroup>
          <ClayForm.FeedbackItem>
            {errorMsg}
          </ClayForm.FeedbackItem>
        </ClayForm.FeedbackGroup>
      )}
    </ClayForm.Group>
  )};

export default CheckboxInput;
