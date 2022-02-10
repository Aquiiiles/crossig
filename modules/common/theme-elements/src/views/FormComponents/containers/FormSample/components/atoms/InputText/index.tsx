import React from "react";
import ClayForm, { ClayInput } from '@clayui/form';

interface props {
  fieldName: string;
  showErrors: boolean;
  defaultValue: string;
  label: string;
  labelHint: string;
  disabled: boolean;
  placeholder: string;
  inputRef: string;
  errorMsg: string;
  type: string;
  required: boolean;
  handleFieldChange: any;
  onClick: () => void;
}


const TextInput: React.FC<props> = ({ fieldName, showErrors, defaultValue, handleFieldChange, label, labelHint, disabled, placeholder, errorMsg, type, required }: props) => {

  const onChange = (e: React.ChangeEvent<HTMLInputElement>) => {
		let fieldValue = e.target.value;
		handleFieldChange(fieldName, fieldValue);
	};

	let displayError = showErrors && !defaultValue;
  
  return (
      <ClayForm.Group>
        <label className="input-label" htmlFor={fieldName}>
          {label}
          {required ? <span className="form-mandatory-field">*</span> : ''}
          {labelHint ? <small><i> {labelHint.toLowerCase()}</i></small> : ''}
        </label>

        <ClayInput
          className="form-input"
          disabled={disabled}
          placeholder={placeholder}
          id={fieldName}
          name={fieldName}
          type={type ? type : "text"}
          defaultValue={defaultValue}
          onChange={(e) => onChange(e)}
        />

        {displayError && (
          <ClayForm.FeedbackGroup>
            <ClayForm.FeedbackItem>
              {errorMsg}
            </ClayForm.FeedbackItem>
          </ClayForm.FeedbackGroup>
        )}
      </ClayForm.Group>
  );
};

export default TextInput;
