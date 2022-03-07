import React, { useState } from "react";

import InputText from "./components/atoms/InputText";
import TextAreaInput from "./components/atoms/TextArea";
import {ClayCheckbox} from '@clayui/form';
import ToggleInput from "./components/atoms/Toogle";
import RadioInput from "./components/atoms/Radio";
import SelectInput from "./components/atoms/Select";
import ButtonCrosig from "./components/atoms/Buttons";
import ClayLayout from '@clayui/layout';
import Modal from "../../ModalMessage";

const propsForm = {
  inputSample: "",
  inputTextArea: "",
  selectOptions: [
    {
      label: "Option 1",
      value: "1"
    },
    {
      label: "Option 2",
      value: "2"
    },
    {
      label: "Option 3",
      value: "3"
    },
    {
      label: "Option 4",
      value: "4"
    }
  ]
}

const colStyles = {
  border: "1px solid #CDCED9",
  paddingBottom: ".75rem",
  paddingTop: ".75rem"
};


const FormSample: React.FC = () => {
  const handleChanges = (id: string, value: any) => {
    console.log("field:", id, " | value:", value);
  };

  const [value, setValue] = useState(false);

  const [showModal, setShowModal] = useState(false);

  const handleSuccessModal = () => {
    setShowModal(true);
  };

  return (
    <div>
      <h6>Messages</h6>
      <ClayLayout.Row>
        <ClayLayout.Col size={4}>
          <Modal
            visible={showModal}
            onClose={() => setShowModal(false)}
            title={'Updated successful'}
            body={'Form updated successfully'}
            lastButtonTitle={'Modal button'}
            lastButtonAction={() => {
              return alert('Modal Button Action');
            }}
            timeOut={5000}
          />
          <ButtonCrosig
            size="medium"
            type="solid"
            label="Open modal"
            icon=""
            disabled={false}
            onClick={handleSuccessModal}
          />
        </ClayLayout.Col>
      </ClayLayout.Row>
      <h6>Botões</h6>
      <ClayLayout.Row justify="center">
        <ClayLayout.Col size={4} style={colStyles}>
          <ButtonCrosig
            size="large"
            type="solid"
            label="Primary"
            icon=""
            disabled={false}
            onClick={() => console.log("Clicked!")}
          />
          <hr />
          <ButtonCrosig
            size="medium"
            type="ghost"
            label=""
            icon="plus"
            disabled={false}
            onClick={() => console.log("Clicked!")}
          />
          <hr />
          <ButtonCrosig
            size="small"
            type="borderless"
            label="Borderless"
            icon=""
            disabled={false}
            onClick={() => console.log("Clicked!")}
          />
          <hr />
          <ButtonCrosig
            size="medium"
            type="solid"
            label="Botão"
            icon=""
            disabled={true}
            onClick={() => console.log("Clicked!")}
          />
        </ClayLayout.Col>
        <ClayLayout.Col size={4} style={colStyles}>
          <ButtonCrosig
            size="large"
            type="solid"
            label="Large Button"
            icon="download"
            disabled={false}
            onClick={() => console.log("Clicked!")}
          />
          <hr />
          <ButtonCrosig
            size="medium"
            type="ghost"
            label="Ghost button"
            icon="download"
            disabled={false}
            onClick={() => console.log("Clicked!")}
          />
          <hr />
          <ButtonCrosig
            size="small"
            type="borderless"
            label="Borderless Button"
            icon="download"
            disabled={false}
            onClick={() => console.log("Clicked!")}
          />
          <hr />
          <ButtonCrosig
            size="medium"
            type="solid"
            label=""
            icon="plus"
            disabled={true}
            onClick={() => console.log("Clicked!")}
          />
          </ClayLayout.Col>
        <ClayLayout.Col size={4} style={colStyles}>
          <ButtonCrosig
            size="large"
            type="solid"
            label="Disabled"
            icon=""
            disabled={true}
            onClick={() => console.log("Clicked!")}
          />
          <hr />
          <ButtonCrosig
            size="medium"
            type="ghost"
            label="Ghost"
            icon=""
            disabled={true}
            onClick={() => console.log("Clicked!")}
          />
          <hr />
          <ButtonCrosig
            size="small"
            type="borderless"
            label="Borderless"
            icon=""
            disabled={true}
            onClick={() => console.log("Clicked!")}
          />
          <hr />
          <ButtonCrosig
            size="medium"
            type="solid"
            label="Disabled"
            icon=""
            disabled={true}
            onClick={() => console.log("Clicked!")}
          />
            
        </ClayLayout.Col>
      </ClayLayout.Row>
        
      <hr />
      <h6>Inputs</h6>
      <ClayLayout.Row justify="center">
        <ClayLayout.Col size={4} style={colStyles}>
          <InputText
            id="inputText"
            label="Label"
            defaultValue={propsForm.inputSample}
            showFeedback={false}
            labelHint=""
            disabled={false}
            placeholder="Input text"
            feedbackMsg="Feedback message"
            inputRef="input"
            type="text"
            required={true}
            handleFieldChange={(id: string, fieldValue: any) => handleChanges(id, fieldValue)}
            onClick={() => console.log("Go Team")}
          />
        </ClayLayout.Col>
      </ClayLayout.Row>

      <ClayLayout.Row justify="center">
        <ClayLayout.Col size={4} style={colStyles}>
          <TextAreaInput
            id="inputTextArea"
            label="Text Area"
            defaultValue={propsForm.inputTextArea}
            labelHint=""
            disabled={false}
            placeholder="Text area field"
            showFeedback={true}
            feedbackMsg="Feedback Message"
            inputRef=""
            type="text"
            required={false}
            handleFieldChange={(id: string, fieldValue: any) => handleChanges(id, fieldValue)}
            onClick={() => console.log("Go Team")}
          />

        </ClayLayout.Col>
      </ClayLayout.Row>

      <ClayLayout.Row justify="center">
        <ClayLayout.Col size={4} style={colStyles}>
          <ToggleInput
            id="toggleInput"
            setToggle={false}
            toggled={true}
            label="Toggle"
            showFeedback={false}
            defaultValue={false}
            labelHint=""
            feedbackMsg=""
            disabled={false}
            required={true}
            handleFieldChange={(id: string, fieldValue: any) => handleChanges(id, fieldValue)}
          />
          
        </ClayLayout.Col>
      </ClayLayout.Row>

      <ClayLayout.Row justify="center">
        <ClayLayout.Col size={4} style={colStyles}>
          <RadioInput
            label="Radio Input"
            id="radioInput"
            options={propsForm.selectOptions}
            showFeedback={false}
            defaultValue="3"
            labelHint=""
            feedbackMsg=""
            disabled={false}
            required={true}
            handleFieldChange={(id: string, fieldValue: any) => handleChanges(id, fieldValue)}
          />
        </ClayLayout.Col>
      </ClayLayout.Row>

      <ClayLayout.Row justify="center">
        <ClayLayout.Col size={4} style={colStyles}>
          <SelectInput
            label="Select Input"
            id="selectInput"
            options={propsForm.selectOptions}
            showFeedback={false}
            defaultValue=""
            labelHint=""
            feedbackMsg=""
            disabled={false}
            required={true}
            handleFieldChange={(id: string, fieldValue: any) => handleChanges(id, fieldValue)}
          />
        </ClayLayout.Col>
      </ClayLayout.Row>

      <ClayLayout.Row justify="center">
        <ClayLayout.Col size={4} style={colStyles}>
          <ClayCheckbox
            aria-label="Aria label"
            checked={value}
            onChange={() => setValue(val => !val)}
            label="Label for the checkbox"
          />
        </ClayLayout.Col>
      </ClayLayout.Row>
    </div>
  );
};

export default FormSample;
