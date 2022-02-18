import React, { useState } from "react";
import ClayForm, { ClaySelect } from '@clayui/form';

interface props {
  id: string;
  options: any[];
  showFeedback: boolean;
  defaultValue: string;
  label: string;
  labelHint: string;
  disabled: boolean;
  feedbackMsg: string;
  required: boolean;
  handleFieldChange: any;
}

const SelectInput: React.FC<props> = ({
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

	const onChange = (e: any) => {
		setValue(e.target.value);
		handleFieldChange(id, e.target.value);
	}

  const [value, setValue] = useState(defaultValue);

	let displayFeedback = showFeedback && !defaultValue;
  
  return (
    <ClayForm.Group className={displayFeedback ? "has-error" : ""}>
    <label htmlFor={id}>
      {label}
      {required ? <span className="form-mandatory-field">*</span> : ''}
      {labelHint ? <small><i> {labelHint.toLowerCase()}</i></small> : ''}
    </label>
    <ClaySelect
      id={id}
      name={id}
      onChange={e => onChange(e)}
      // value={defaultValue}
      disabled={disabled}
    >
      <ClaySelect.Option
        value=""
        key="select"
        label="Select"
        disabled
        selected={defaultValue === '' ? true : false }
        hidden
        />
      {options.map(item => (
        <ClaySelect.Option
          key={item.value}
          label={item.label}
          value={item.value}
          selected={value === item.value ? true: false}
        />
      ))}
    </ClaySelect>
    {displayFeedback && (
      <ClayForm.FeedbackGroup>
        <ClayForm.FeedbackItem>
          {feedbackMsg}
        </ClayForm.FeedbackItem>
      </ClayForm.FeedbackGroup>
    )}
  </ClayForm.Group>);
};

export default SelectInput;
