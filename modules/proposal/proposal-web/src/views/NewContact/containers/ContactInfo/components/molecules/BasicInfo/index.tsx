import React from "react";
import { Row, FormSection } from "../../atoms";
import { CREATE_NEW_CONTACT } from "../../../../../../../constants/languageKeys";
import ClayForm, {
  ClayInput,
  ClayCheckbox,
  ClaySelectWithOption,
} from "@clayui/form";
import ClayDatePicker from "@clayui/date-picker";
import { actions } from "./slice/basicInfoSlice";
import { useContactDispatch, useContactSelector } from "../../../contactStore";

const BasicInfo: React.FC = () => {
  const dispatch = useContactDispatch();
  const {
    contactType,
    firstName,
    lastName,
    dateOfBirth,
    oib,
    foreignerStatus,
    companyName,
    subsidiaryNumber,
  } = useContactSelector(state => state.basicInfo);
  const {
    setType,
    setFirstName,
    setLastName,
    setDateOfBirth,
    setOIB,
    toggleForeignerStatus,
    setCompanyName,
    setSubsidiaryNumber,
  } = actions;

  const contactTypeOptions = [
    {
      label: CREATE_NEW_CONTACT.FIELD.CONTACT_TYPE.INDIVIDUAL,
      value: "1",
    },
    {
      label: CREATE_NEW_CONTACT.FIELD.CONTACT_TYPE.SELF_EMPLOYED,
      value: "2",
    },
    {
      label: CREATE_NEW_CONTACT.FIELD.CONTACT_TYPE.LEGAL_ENTITY,
      value: "3",
    },
  ];
  const showIndividualFields = contactType === "1";

  return (
    <FormSection title={CREATE_NEW_CONTACT.BASIC_INFO_TITLE}>
      <div className="select-arrow-down">
        <ClaySelectWithOption
          required
          value={contactType}
          onChange={({ target: { value } }) => dispatch(setType(value))}
          options={contactTypeOptions}
        ></ClaySelectWithOption>
      </div>
      {showIndividualFields ? (
        <Row>
          <ClayForm.Group>
            <label htmlFor="firstNameInput">
              {CREATE_NEW_CONTACT.FIELD.FIRST_NAME}
            </label>
            <ClayInput
              required={showIndividualFields}
              id="firstNameInput"
              type="text"
              onChange={({ target: { value } }) =>
                dispatch(setFirstName(value))
              }
              value={firstName}
            />
          </ClayForm.Group>
          <ClayForm.Group>
            <label htmlFor="lastNameInput">
              {CREATE_NEW_CONTACT.FIELD.LAST_NAME}
            </label>
            <ClayInput
              required={showIndividualFields}
              id="lastNameInput"
              type="text"
              onChange={({ target: { value } }) => dispatch(setLastName(value))}
              value={lastName}
            />
          </ClayForm.Group>
        </Row>
      ) : (
        <Row>
          <ClayForm.Group>
            <label htmlFor="companyName">
              {CREATE_NEW_CONTACT.FIELD.COMPANY_NAME}
            </label>
            <ClayInput
              required={!showIndividualFields}
              id="companyName"
              type="text"
              onChange={({ target: { value } }) =>
                dispatch(setCompanyName(value))
              }
              value={companyName}
            />
          </ClayForm.Group>
        </Row>
      )}
      <Row half={!showIndividualFields}>
        {showIndividualFields ? (
          <ClayForm.Group>
            <label htmlFor="dateOfBirthInput">
              {CREATE_NEW_CONTACT.FIELD.BIRTH_DATE}
            </label>
            <ClayDatePicker
              aria-required={showIndividualFields}
              id="dateOfBirthInput"
              placeholder="dd/mm/yyyy"
              dateFormat="dd/MM/yyyy"
              value={dateOfBirth}
              onValueChange={value => dispatch(setDateOfBirth(value))}
            />
          </ClayForm.Group>
        ) : null}
        <ClayForm.Group>
          <label htmlFor="oibInput">{CREATE_NEW_CONTACT.FIELD.OIB}</label>
          <ClayInput
            required={foreignerStatus ? false : true}
            id="oibInput"
            type="text"
            onChange={({ target: { value } }) => dispatch(setOIB(value))}
            value={oib}
          />
        </ClayForm.Group>
      </Row>
      {!showIndividualFields ? (
        <Row half>
          <ClayForm.Group>
            <label htmlFor="subsidiaryNumber">
              {CREATE_NEW_CONTACT.FIELD.SUBSIDIARY_NUMBER}
            </label>
            <ClayInput
              disabled
              required={!showIndividualFields}
              id="subsidiaryNumber"
              type="text"
              value={subsidiaryNumber}
            />
          </ClayForm.Group>
        </Row>
      ) : null}
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
