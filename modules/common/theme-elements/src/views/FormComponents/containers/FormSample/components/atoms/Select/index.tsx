import React from "react";
import ClayForm, { ClaySelect } from '@clayui/form';

interface props {
  fieldName: string;
  options: any[];
  showErrors: boolean;
  defaultValue: string;
  label: string;
  labelHint: string;
  disabled: boolean;
  errorMsg: string;
  required: boolean;
  handleFieldChange: any;
}

const SelectInput: React.FC<props> = ({
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

	const onChange = (e:any) => {
    console.log("aqui");
		let fieldValue = e.target.value;
		handleFieldChange(fieldName, fieldValue);
	}

	let displayError = showErrors && !defaultValue;
  
  return (
    <ClayForm.Group className={displayError ? "has-error" : ""}>
    <label className="input-label" htmlFor={fieldName}>
      {label}
      {required ? <span className="form-mandatory-field">*</span> : ''}
      {labelHint ? <small><i> {labelHint.toLowerCase()}</i></small> : ''}
    </label>
    <ClaySelect
      id={fieldName}
      name={fieldName}
      onChange={(e) => onChange(e)}
      value={defaultValue}
      disabled={disabled}
    >
      {options.map((item, index) => (
        <ClaySelect.Option
          key={index}
          label={item.value}
          value={item.value}
        />
      ))}
    </ClaySelect>
    {displayError && (
      <ClayForm.FeedbackGroup>
        <ClayForm.FeedbackItem>
          {errorMsg}
        </ClayForm.FeedbackItem>
      </ClayForm.FeedbackGroup>
    )}
  </ClayForm.Group>);
};

export default SelectInput;
