import React from "react";
import ClayForm, { ClayRadio, ClayRadioGroup } from '@clayui/form';

interface props {
  fieldName: string;
  options: any[];
  showErrors: boolean;
  defaultValue: any;
  label: string;
  labelHint: string;
  disabled: boolean;
  errorMsg: string;
  required: boolean;
  handleFieldChange: any;
}

const RadioInput: React.FC<props> = ({
  fieldName,
  options,
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
  const onChange = () => {
    console.log("aqui radio");
		// let fieldValue = e.target.value;
		// handleFieldChange(fieldName, fieldValue);
	};
  
  return (
    <ClayForm.Group className={displayError ? "has-error" : ""}>
      <label className="input-label" htmlFor={fieldName}>
        {label}
        {required ? <span className="form-mandatory-field">*</span> : ''}
        {labelHint ? <small><i> {labelHint.toLowerCase()}</i></small> : ''}
      </label>
      <ClayRadioGroup
        inline
        onSelectedValueChange={() => onChange()}
        selectedValue={defaultValue}
      >
        {options.map(item => (
          <ClayRadio
            key={item.value}
            label={item.value}
            value={item.value}
            disabled={disabled}
          />
        ))}
      </ClayRadioGroup>
      {displayError && (
        <ClayForm.FeedbackGroup>
          <ClayForm.FeedbackItem>
            {errorMsg}
          </ClayForm.FeedbackItem>
        </ClayForm.FeedbackGroup>
      )}
    </ClayForm.Group>
  )};

export default RadioInput;
