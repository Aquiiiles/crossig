import React from "react";
import { Row, FormSection } from "../../atoms";
import { CREATE_NEW_CONTACT } from "../../../../../../../constants/languageKeys";
import ClayForm, { ClayInput, ClayCheckbox, ClaySelect } from "@clayui/form";
import ClayDatePicker from "@clayui/date-picker";
import { actionsBag } from "./slice/basicInfoSlice";
import { useContactDispatch, useContactSelector } from "../../../contactStore";

const BasicInfo: React.FC = () => {
  const dispatch = useContactDispatch();
  const { type, firstName, lastName, dateOfBirth, oib, foreignerStatus } =
    useContactSelector(state => state.basicInfo);
  const {
    setType,
    setFirstName,
    setLastName,
    setDateOfBirth,
    setOIB,
    toggleForeignerStatus,
  } = actionsBag;

  return (
    <FormSection title={CREATE_NEW_CONTACT.BASIC_INFO_TITLE}>
      <div>
        <ClaySelect
          onChange={({ target: { value } }) => dispatch(setType(value))}
        >
          <option>Individual</option>
          <option>Self-Employed</option>
          <option>Legal Entity</option>
        </ClaySelect>
      </div>
      <Row>
        <ClayForm.Group>
          <label htmlFor="firstNameInput">
            {CREATE_NEW_CONTACT.FIELD.FIRST_NAME}
          </label>
          <ClayInput
            id="firstNameInput"
            type="text"
            onChange={({ target: { value } }) => dispatch(setFirstName(value))}
            value={firstName}
          />
        </ClayForm.Group>
        <ClayForm.Group>
          <label htmlFor="lastNameInput">
            {CREATE_NEW_CONTACT.FIELD.LAST_NAME}
          </label>
          <ClayInput
            id="lastNameInput"
            type="text"
            onChange={({ target: { value } }) => dispatch(setLastName(value))}
            value={lastName}
          />
        </ClayForm.Group>
      </Row>
      <Row>
        <ClayForm.Group>
          <label htmlFor="dateOfBirthInput">
            {CREATE_NEW_CONTACT.FIELD.BIRTH_DATE}
          </label>
          <ClayDatePicker
            id="dateOfBirthInput"
            placeholder=""
            value={dateOfBirth}
            onValueChange={value => dispatch(setDateOfBirth(value))}
          />
        </ClayForm.Group>
        <ClayForm.Group>
          <label htmlFor="oibInput">{CREATE_NEW_CONTACT.FIELD.OIB}</label>
          <ClayInput
            id="oibInput"
            type="text"
            onChange={({ target: { value } }) => dispatch(setOIB(value))}
            value={oib}
          />
        </ClayForm.Group>
      </Row>
      <Row>
        <ClayCheckbox
          aria-label={CREATE_NEW_CONTACT.FIELD.FOREIGNER_STATUS}
          label={CREATE_NEW_CONTACT.FIELD.FOREIGNER_STATUS}
          checked={foreignerStatus}
          onChange={() => dispatch(toggleForeignerStatus())}
        />
      </Row>
    </FormSection>
  );
};

export default BasicInfo;
