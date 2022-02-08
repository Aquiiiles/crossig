import React from "react";
import FormSection from "../../../../../../../shared/atoms/FormSection";
import Row from "../../../../../../../shared/atoms/Row";
import { CREATE_NEW_CONTACT } from "../../../../../../../constants/languageKeys";
import ClayForm, {
  ClayInput,
  ClayCheckbox,
  ClaySelectWithOption,
} from "@clayui/form";
import { actions } from "../../../../../../../redux/basicInfoSlice";
import {
  useContactDispatch,
  useContactSelector,
} from "../../../../../../../redux/store";
import {
  contactTypeOptions,
  contactTypes,
} from "../../../../../../../constants/contactConstants";
import useFieldValidation from "../../../../../hooks/useFieldValidation";
import { validateDay, validateMonth, validateYear } from "./validators";

const BasicInfo: React.FC = () => {
  const dispatch = useContactDispatch();
  const {
    contactType,
    firstName,
    lastName,
    dateDay,
    dateMonth,
    dateYear,
    oib,
    foreignerStatus,
    companyName,
    subsidiaryNumber,
  } = useContactSelector(state => state.basicInfo);
  const {
    setType,
    setFirstName,
    setLastName,
    setDateDay,
    setDateMonth,
    setDateYear,
    setOIB,
    toggleForeignerStatus,
    setCompanyName,
    setSubsidiaryNumber,
  } = actions;
  const [dayRef, dayError, hasDayError] = useFieldValidation<HTMLInputElement>(
    React.useCallback(
      value => validateDay(value, dateMonth, dateYear),
      [dateYear, dateMonth]
    )
  );
  const [monthRef, monthError, hasMonthError] =
    useFieldValidation<HTMLInputElement>(React.useCallback(validateMonth, []));
  const [yearRef, yearError, hasYearError] =
    useFieldValidation<HTMLInputElement>(React.useCallback(validateYear, []));

  const showIndividualFields = contactType === contactTypes.Individual;

  return (
    <FormSection title={CREATE_NEW_CONTACT.BASIC_INFO_TITLE}>
      <ClayForm.Group>
        <label htmlFor="contactTypeInput">{CREATE_NEW_CONTACT.TYPE}</label>
        <ClaySelectWithOption
          id="contactTypeInput"
          required
          value={contactType}
          onChange={({ target: { value } }) => dispatch(setType(value))}
          options={contactTypeOptions}
        ></ClaySelectWithOption>
      </ClayForm.Group>
      {showIndividualFields ? (
        <Row>
          <ClayForm.Group>
            <ClayInput.Group>
              <ClayInput.GroupItem>
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
              </ClayInput.GroupItem>

              <ClayInput.GroupItem>
                <label htmlFor="lastNameInput">
                  {CREATE_NEW_CONTACT.FIELD.LAST_NAME}
                </label>
                <ClayInput
                  required={showIndividualFields}
                  id="lastNameInput"
                  type="text"
                  onChange={({ target: { value } }) =>
                    dispatch(setLastName(value))
                  }
                  value={lastName}
                />
              </ClayInput.GroupItem>
            </ClayInput.Group>
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
          <ClayForm.Group
            className={
              hasDayError || hasMonthError || hasYearError ? "has-error" : ""
            }
          >
            <label htmlFor="dateOfBirthInput">
              {CREATE_NEW_CONTACT.FIELD.BIRTH_DATE}
            </label>
            <div className="birth-date-group">
              <ClayInput
                ref={dayRef}
                required={showIndividualFields}
                id="birthDateDay"
                type="text"
                onChange={({ target: { value } }) =>
                  dispatch(setDateDay(value))
                }
                placeholder="DD"
                value={dateDay}
              />
              <ClayInput
                ref={monthRef}
                required={showIndividualFields}
                id="birthDateMonth"
                type="text"
                onChange={({ target: { value } }) =>
                  dispatch(setDateMonth(value))
                }
                placeholder="MM"
                value={dateMonth}
              />
              <ClayInput
                ref={yearRef}
                required={showIndividualFields}
                id="birthDateYear"
                type="text"
                onChange={({ target: { value } }) =>
                  dispatch(setDateYear(value))
                }
                value={dateYear}
              />
            </div>
            {hasDayError || hasMonthError || hasYearError ? (
              <ClayForm.FeedbackGroup>
                <ClayForm.FeedbackItem>{dayError}</ClayForm.FeedbackItem>
                <ClayForm.FeedbackItem>{monthError}</ClayForm.FeedbackItem>
                <ClayForm.FeedbackItem>{yearError}</ClayForm.FeedbackItem>
              </ClayForm.FeedbackGroup>
            ) : null}
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
