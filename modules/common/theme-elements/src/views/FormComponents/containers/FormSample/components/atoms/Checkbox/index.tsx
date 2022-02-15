import React, { useState } from "react";
import ClayForm, { ClayCheckbox } from '@clayui/form';

interface props {
  // id: string;
  // options: any[];
  // selectedValues: any[],
  // showFeedback: boolean;
  // defaultValue: string;
  // label: string;
  // labelHint: string;
  // disabled: boolean;
  // feedbackMsg: string;
  // required: boolean;
  // handleFieldChange: any;
}
const CheckboxInput = () => {
  const [value, setValue] = useState(false);
  return (
    <>
      <ClayCheckbox
        label="Option 1"
        checked={value}
        onChange={() => setValue((val) => !val)}
        inline
      />
    </>
  );
}
// const CheckboxInput: React.FC<props> = ({
//   id,
//   options,
//   selectedValues,
//   showFeedback,
//   defaultValue,
//   label,
//   labelHint,
//   disabled,
//   feedbackMsg,
//   required,
//   handleFieldChange
// }: props) => {

// 	let displayFeedback = showFeedback && !defaultValue;
//   const onChange = (item: any) => {
//     console.log("selected", selectedValues, " | item", item);
// 		// handleFieldChange(id, fieldValue);
// 	};

//   const isChecked = (value: string) => {
//     return selectedValues.includes(value);
//   }
  
//   return (
//     <ClayForm.Group className={displayFeedback ? "has-error" : ""}>
//       <label htmlFor={id}>
//         {label}
//         {required ? <span className="form-mandatory-field">*</span> : ''}
//         {labelHint ? <small><i> {labelHint.toLowerCase()}</i></small> : ''}
//       </label>
//       <>
//       {options.map((item, index) => (
//         <ClayCheckbox
//           key={index}
//           label={index}
//           aria-label={item.label}
//           checked={isChecked(item.value)}
//           value={item.value}
//           onChange={() => onChange(item.value)}
//           inline
//         />
//       ))}
//       </>
//       {displayFeedback && (
//       <ClayForm.FeedbackGroup>
//           <ClayForm.FeedbackItem>
//             {feedbackMsg}
//           </ClayForm.FeedbackItem>
//         </ClayForm.FeedbackGroup>
//       )}
//     </ClayForm.Group>
//   )};

export default CheckboxInput;
