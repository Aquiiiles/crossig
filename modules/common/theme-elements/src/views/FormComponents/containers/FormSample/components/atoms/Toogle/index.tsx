import React, { useState } from "react";
import ClayForm, { ClayToggle } from '@clayui/form';

interface props {
  id: string;
  setToggle: boolean;
  toggled: boolean;
  showFeedback: boolean;
  defaultValue: string;
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
  required
}: props) => {

	let displayFeedback = showFeedback && !defaultValue;
  const [toggled, setToggle] = useState(false);
  
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
          onToggle={setToggle}
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
