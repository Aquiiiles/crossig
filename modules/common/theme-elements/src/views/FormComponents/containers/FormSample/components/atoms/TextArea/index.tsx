import React from "react";
import ClayForm, { ClayInput } from '@clayui/form';

interface props {
  id: string;
  showFeedback: boolean;
  defaultValue: string;
  label: string;
  labelHint: string;
  disabled: boolean;
  placeholder: string;
  inputRef: string;
  feedbackMsg: string;
  type: string;
  required: boolean;
  handleFieldChange: any;
  onClick: () => void;
}


const TextAreaInput: React.FC<props> = ({ id, showFeedback, defaultValue, handleFieldChange, label, labelHint, disabled, placeholder, feedbackMsg, type, required }: props) => {

  const onChange = (e: React.ChangeEvent<HTMLInputElement>) => {
		let fieldValue = e.target.value;
		handleFieldChange(id, fieldValue);
	};

	let displayFeedback = showFeedback && !defaultValue;
  
  return (
      <ClayForm.Group>
        <label htmlFor={id}>
          {label}
          {required ? <span className="form-mandatory-field">*</span> : ''}
          {labelHint ? <small><i> {labelHint.toLowerCase()}</i></small> : ''}
        </label>

        <ClayInput
          disabled={disabled}
          placeholder={placeholder}
          id={id}
          name={id}
          component="textarea"
          type={type ? type : "text"}
          defaultValue={defaultValue}
          onChange={(e) => onChange(e)}
        />

        {displayFeedback && (
          <ClayForm.FeedbackGroup>
            <ClayForm.FeedbackItem>
              {feedbackMsg}
            </ClayForm.FeedbackItem>
          </ClayForm.FeedbackGroup>
        )}
      </ClayForm.Group>
  );
};

export default TextAreaInput;
