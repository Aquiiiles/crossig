import React, { useState } from "react";
import ClayForm, { ClayRadio, ClayRadioGroup } from '@clayui/form';

interface props {
  id: string;
  options: any[];
  showFeedback: boolean;
  defaultValue: any;
  label: string;
  labelHint: string;
  disabled: boolean;
  feedbackMsg: string;
  required: boolean;
  handleFieldChange: any;
}

const RadioInput: React.FC<props> = ({
  id,
  options,
  showFeedback,
  defaultValue,
  label,
  labelHint,
  disabled,
  feedbackMsg,
  required,
  handleFieldChange
}: props) => {

	// let displayFeedback = showFeedback && !defaultValue;
  const [value, setValue] = useState(defaultValue);

  const onChange = (fiedlValue: any) => {
    setValue(fiedlValue);
		handleFieldChange(id, fiedlValue);
	};
  
  return (
    <ClayForm.Group className={showFeedback ? "has-error" : ""}>
      <label htmlFor={id}>
        {label}
        {required ? <span className="form-mandatory-field">*</span> : ''}
        {labelHint ? <small><i> {labelHint.toLowerCase()}</i></small> : ''}
      </label>
      <ClayRadioGroup
        inline
        onSelectedValueChange={val => onChange(val)}
        selectedValue={value}
      >
        {options.map(item => (
          <ClayRadio
            key={item.value}
            label={item.label}
            value={item.value}
            disabled={disabled}
          />
        ))}
      </ClayRadioGroup>
      {showFeedback && (
        <ClayForm.FeedbackGroup>
          <ClayForm.FeedbackItem>
            {feedbackMsg}
          </ClayForm.FeedbackItem>
        </ClayForm.FeedbackGroup>
      )}
    </ClayForm.Group>
  )};

export default RadioInput;
