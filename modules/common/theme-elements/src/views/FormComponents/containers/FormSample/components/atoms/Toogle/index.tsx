import React, { useState } from "react";
import ClayForm, { ClayToggle } from '@clayui/form';

interface props {
  id: string;
  setToggle: boolean;
  toggled: boolean;
  showFeedback: boolean;
  defaultValue: boolean;
  label: string;
  labelHint: string;
  disabled: boolean;
  feedbackMsg: string;
  required: boolean;
  handleFieldChange: any;
}

const ToggleInput: React.FC<props> = ({
  id,
  showFeedback,
  defaultValue,
  label,
  labelHint,
  disabled,
  feedbackMsg,
  handleFieldChange,
  required,
}: props) => {

	let displayFeedback = showFeedback && !defaultValue;
  const [toggled, setToggle] = useState(defaultValue);

  const onChange = (e: boolean) => {
    setToggle(e);
    defaultValue = toggled;
		handleFieldChange(id, toggled);
	};
  
  return (
    <ClayForm.Group className={displayFeedback ? "has-error" : ""}>
      <div style={{ display: "flex", justifyContent: "space-around" }}>
        <label
          htmlFor={id}
        >
          {label}
          {required ? <span className="form-mandatory-field">*</span> : ''}
          {labelHint ? <small><i> {labelHint.toLowerCase()}</i></small> : ''}
        </label>
        <ClayToggle
          className="form-toggle"
          onToggle={bool => onChange(bool)}
          toggled={toggled}
          disabled={disabled}
        />
      </div>
      {displayFeedback && (
        <ClayForm.FeedbackGroup>
          <ClayForm.FeedbackItem>
            {feedbackMsg}
          </ClayForm.FeedbackItem>
        </ClayForm.FeedbackGroup>
      )}
    </ClayForm.Group>
  )};

export default ToggleInput;
