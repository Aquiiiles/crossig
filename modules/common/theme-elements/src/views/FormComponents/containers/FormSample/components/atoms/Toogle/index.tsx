import React, { useState } from "react";
import ClayForm, { ClayToggle } from '@clayui/form';

interface props {
  fieldName: string;
  setToggle: boolean;
  toggled: boolean;
  showErrors: boolean;
  defaultValue: string;
  label: string;
  labelHint: string;
  disabled: boolean;
  errorMsg: string;
  required: boolean;
  handleFieldChange: any;
}

const ToggleInput: React.FC<props> = ({
  fieldName,
  showErrors,
  defaultValue,
  label,
  labelHint,
  disabled,
  errorMsg,
  required
}: props) => {

	let displayError = showErrors && !defaultValue;
  const [toggled, setToggle] = useState(false);
  
  return (
    <ClayForm.Group className={displayError ? "has-error" : ""}>
      <div style={{ display: "flex", justifyContent: "space-around" }}>
        <label
          htmlFor={fieldName}
        >
          {label}
          {required ? <span className="form-mandatory-field">*</span> : ''}
          {labelHint ? <small><i> {labelHint.toLowerCase()}</i></small> : ''}
        </label>
        <ClayToggle
          onToggle={setToggle}
          toggled={toggled}
          disabled={disabled}
        />
        </div>
      {displayError && (
        <ClayForm.FeedbackGroup>
          <ClayForm.FeedbackItem>
            {errorMsg}
          </ClayForm.FeedbackItem>
        </ClayForm.FeedbackGroup>
      )}
    </ClayForm.Group>
  )};

export default ToggleInput;
