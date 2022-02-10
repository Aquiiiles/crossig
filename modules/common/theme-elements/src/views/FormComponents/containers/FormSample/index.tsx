import React from "react";

import InputText from "./components/atoms/InputText";
import TextAreaInput from "./components/atoms/TextArea";
import CheckboxInput from "./components/atoms/Checkbox";
import ToggleInput from "./components/atoms/Toogle";
import RadioInput from "./components/atoms/Radio";
import SelectInput from "./components/atoms/Select";
import ButtonCrosig from "./components/atoms/Buttons";
import ClayLayout from '@clayui/layout';


const propsForm = {
  inputSample: "",
  inputTextArea: "",
  selectOptions: [
    {"marca 1": "1",},
    {"marca 2": "2",},
    {"marca 3": "3",},
    {"marca 4": "4",},
    {"marca 5": "5"},
  ]
}

const colStyles = {
  border: "1px solid #CDCED9",
  paddingBottom: ".75rem",
  paddingTop: ".75rem"
};


const FormSample: React.FC = () => {
  const handleChanges = (fieldName: string, value: any) => {
    console.log("field:", fieldName, " | value:", value);
  };

  return (
    <div>
      <h6>Botões</h6>
      <hr />
      <ClayLayout.Row justify="center">
        <ClayLayout.Col size={4} style={colStyles}>
          <ButtonCrosig
            size="large"
            type="solid"
            label="Primary"
            icon=""
            disabled={false}
            onClick={() => console.log("Clicou!")}
          />
          <hr />
          <ButtonCrosig
            size="medium"
            type="ghost"
            label=""
            icon="plus"
            disabled={false}
            onClick={() => console.log("Clicou!")}
          />
          <hr />
          <ButtonCrosig
            size="small"
            type="borderless"
            label="Borderless"
            icon=""
            disabled={false}
            onClick={() => console.log("Clicou!")}
          />
          <hr />
          <ButtonCrosig
            size="medium"
            type="solid"
            label="Botão"
            icon=""
            disabled={true}
            onClick={() => console.log("Clicou!")}
          />
        </ClayLayout.Col>
        <ClayLayout.Col size={4} style={colStyles}>
          <ButtonCrosig
            size="large"
            type="solid"
            label="Large Button"
            icon="download"
            disabled={false}
            onClick={() => console.log("Clicou!")}
          />
          <hr />
          <ButtonCrosig
            size="medium"
            type="ghost"
            label="Ghost button"
            icon="download"
            disabled={false}
            onClick={() => console.log("Clicou!")}
          />
          <hr />
          <ButtonCrosig
            size="small"
            type="borderless"
            label="Borderless Button"
            icon="download"
            disabled={false}
            onClick={() => console.log("Clicou!")}
          />
          <hr />
          <ButtonCrosig
            size="medium"
            type="solid"
            label=""
            icon="plus"
            disabled={true}
            onClick={() => console.log("Clicou!")}
          />
          </ClayLayout.Col>
        <ClayLayout.Col size={4} style={colStyles}>
          <ButtonCrosig
            size="large"
            type="solid"
            label="Disabled"
            icon=""
            disabled={true}
            onClick={() => console.log("Clicou!")}
          />
          <hr />
          <ButtonCrosig
            size="medium"
            type="ghost"
            label="Ghost"
            icon=""
            disabled={true}
            onClick={() => console.log("Clicou!")}
          />
          <hr />
          <ButtonCrosig
            size="small"
            type="borderless"
            label="Borderless"
            icon=""
            disabled={true}
            onClick={() => console.log("Clicou!")}
          />
          <hr />
          <ButtonCrosig
            size="medium"
            type="solid"
            label="Disabled"
            icon=""
            disabled={true}
            onClick={() => console.log("Clicou!")}
          />
            
        </ClayLayout.Col>
      </ClayLayout.Row>
        
      <hr />
      <h6>Inputs</h6>
      <hr />
      <InputText
        fieldName="inputText"
        label="Label"
        defaultValue={propsForm.inputSample}
        showErrors={false}
        labelHint=""
        disabled={false}
        placeholder="Insira seu nome"
        inputRef="input"
        errorMsg="Teste de mensagem de erro"
        type="text"
        required={true}
        handleFieldChange={(fieldName: string, fieldValue: any) => handleChanges(fieldName, fieldValue)}
        onClick={() => console.log("Go Team")}
      />
      <hr />
      <TextAreaInput
        fieldName="inputTextArea"
        label="Text Area"
        defaultValue={propsForm.inputTextArea}
        labelHint=""
        disabled={false}
        placeholder="Text area field text area field text area field "
        showErrors={true}
        inputRef=""
        errorMsg="Error message"
        type="text"
        required={false}
        handleFieldChange={(fieldName: string, fieldValue: any) => handleChanges(fieldName, fieldValue)}
        onClick={() => console.log("Go Team")}
      />
      <hr />
      <ToggleInput
        fieldName="toggleInput"
        setToggle={false}
        toggled={true}
        label="Toggle"
        showErrors={true}
        defaultValue="1"
        labelHint=""
        disabled={false}
        errorMsg="Selecione um"
        required={true}
        handleFieldChange={(fieldName: string, fieldValue: any) => handleChanges(fieldName, fieldValue)}
      />
      <hr />
      <hr />
      <RadioInput
        label="Radio Input"
        fieldName="radioInput"
        options={propsForm.selectOptions}
        showErrors={false}
        defaultValue={'1'}
        labelHint=""
        disabled={false}
        errorMsg=""
        required={true}
        handleFieldChange={(fieldName: string, fieldValue: any) => handleChanges(fieldName, fieldValue)}
      />
      <SelectInput
        label="Select Input"
        fieldName="selectInput"
        options={propsForm.selectOptions}
        showErrors={false}
        defaultValue={'1'}
        labelHint=""
        disabled={false}
        errorMsg=""
        required={true}
        handleFieldChange={(fieldName: string, fieldValue: any) => handleChanges(fieldName, fieldValue)}
      />
      <hr />
      {/* <CheckboxInput
        fieldName="checkboxInput"
        options={[1, 2, 3, 4, 5, 6]}
        selectedValues={[1]}
        showErrors={false}
        defaultValue="[]"
        label="Checkbox"
        labelHint=""
        disabled={false}
        errorMsg=""
        required={true}
        handleFieldChange={(fieldName: string, fieldValue: any) => handleChanges(fieldName, fieldValue)}
      /> */}
      < hr />
      
    </div>
  );
};

export default FormSample;
