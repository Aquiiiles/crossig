import React, { useState, useRef, ReactElement } from "react";
import ClayForm, { ClayInput, ClayToggle, ClayRadio, ClayRadioGroup, ClayCheckbox } from "@clayui/form";
// import ClayButton from "@clayui/button";
// import ClayIcon from "@clayui/icon";
// import spritemap from "@clayui/css/lib/images/icons/icons.svg";
// import ClayDropDown from "@clayui/drop-down";
// import SearchFilters from "./components/molecules/SearchFilters";
// import ArrowButton from "./components/atoms/ArrowButton";
// import SearchButton from "./components/atoms/SearchButton";
import {Wrapper} from "./styles";

const FormSample: React.FC = () => {
  const [name, setDefaultInput] = useState("");
  const triggerElementRef = useRef<HTMLInputElement>(null);

  const [toggled, setToggle] = useState(false); // Toggles

  const [radioValue, setRadioValue] = useState('one'); // Radio

  const [checkboxValue, setCheckboxValue] = useState(false); // Checkbox

  return (
    <Wrapper>
      <h2>Text Layout</h2>

      <ClayForm.Group>
        <label htmlFor="basicInputText">Default<span>*</span></label>
        <ClayInput
          id="defaultInputText"
          type="text"
          ref={triggerElementRef}
          value={name}
          onChange={(e) => setDefaultInput(e.target.value)}
        />
      </ClayForm.Group>
      <ClayForm.Group>
        <label htmlFor="errorInputText">Error<span>*</span></label>
        <ClayInput
          id="errorInputText"
          type="text"
          ref={triggerElementRef}
          value={name}
        />
      </ClayForm.Group>

      <h2>Toggle</h2>
      <ClayToggle label="Checkbox" onToggle={setToggle} toggled={toggled} />
      <ClayToggle
        disabled
        label="Disabled"
        onToggle={setToggle}
        toggled={toggled}
      />

      <h2>Radio</h2>
      <ClayRadioGroup
        inline
        onSelectedValueChange={val => setRadioValue(val.toString())}
        selectedValue={radioValue}
      >
        <ClayRadio label="One" value="one" />
        <ClayRadio label="Two" value="two" />
        <ClayRadio label="Three" value="three" />
      </ClayRadioGroup>

      <h2>Checkbox</h2>
      <>
        <ClayCheckbox
          aria-label="Option 1"
          checked={checkboxValue}
          onChange={() => setCheckboxValue(val => !val)}
          label="Option 1"
          inline
        />
        <ClayCheckbox
          aria-label="Option 2"
          checked={checkboxValue}
          onChange={() => setCheckboxValue(val => !val)}
          label="Option 2"
          inline
        />
        <ClayCheckbox
          aria-label="Option 3"
          checked={checkboxValue}
          onChange={() => setCheckboxValue(val => !val)}
          label="Option 3"
          inline
        />
      </>

    </Wrapper>
  );
};

export default FormSample;
