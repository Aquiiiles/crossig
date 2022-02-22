import React, { useEffect } from "react";
import FormSection from "../../../atoms/contact/FormSection";
import Row from "../../../atoms/contact/Row";
import { CREATE_NEW_CONTACT } from "../../../../constants/languageKeys";
import ClayForm, {
  ClayInput,
  ClayCheckbox,
  ClaySelectWithOption,
} from "@clayui/form";
import { actions } from "../../../../redux/basicInfoSlice";
import {
  useContactDispatch,
  useContactSelector,
} from "../../../../redux/store";
import {
  contactTypeOptions,
  contactTypes,
} from "../../../../constants/contactConstants";
import { useFieldValidation, useJumpFocus } from "../../../hooks";
import {
  validateDay,
  validateMonth,
  validateYear,
} from "../../../validators/date";
import { validateOib } from "../../../validators/oib";

type propsType = {
  operation: string;
  enableSave?: () => void;
  setUpdatedValues?: (value: string) => void;
};

const BasicInfo: React.FC<propsType> = ({
  enableSave,
  operation,
  setUpdatedValues,
}: propsType) => {
  const dispatcher = useContactDispatch();

  const dispatch = (action: any, updatedValue: string) => {
    enableSave && enableSave();
    dispatcher(action);
    setUpdatedValues && setUpdatedValues(updatedValue);
  };

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
  } = useContactSelector((state) => state.basicInfo);
  const {
    setContactType,
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

  const showIndividualFields = contactType === contactTypes.Individual;

  const isLegalEntity = () => {
    return contactType === contactTypes.Legal_Entity;
  };

  const isIndividual = () => {
    return contactType === contactTypes.Individual;
  };

  const isUpdate = () => {
    return operation === "update";
  };

  const [dayRef, dayError, hasDayError] = useFieldValidation<HTMLInputElement>(
    React.useCallback(
      (value) => validateDay(value, dateMonth, dateYear),

      [dateYear, dateMonth]
    )
  );
  const [monthRef, monthError, hasMonthError] =
    useFieldValidation<HTMLInputElement>(React.useCallback(validateMonth, []));

  const [yearRef, yearError, hasYearError] =
    useFieldValidation<HTMLInputElement>(React.useCallback(validateYear, []));

  const [oibRef, oibError, hasOibError] = useFieldValidation<HTMLInputElement>(
    React.useCallback(validateOib, [])
  );

  useJumpFocus(dateDay, "birthDateMonth", 2);

  useJumpFocus(dateMonth, "birthDateYear", 2);

  return (
    <FormSection title={CREATE_NEW_CONTACT.BASIC_INFO_TITLE}>
      <ClayForm.Group>
        <label htmlFor="contactTypeInput">{CREATE_NEW_CONTACT.TYPE}</label>
        <ClaySelectWithOption
          id="contactTypeInput"
          required
          value={contactType}
          onChange={({ target: { value } }) =>
            dispatch(setContactType(value), CREATE_NEW_CONTACT.TYPE)
          }
          options={contactTypeOptions}
          disabled={isUpdate()}
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
                    dispatch(
                      setFirstName(value),
                      CREATE_NEW_CONTACT.FIELD.FIRST_NAME
                    )
                  }
                  value={firstName}
                  disabled={isIndividual() && isUpdate()}
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
                    dispatch(
                      setLastName(value),
                      CREATE_NEW_CONTACT.FIELD.LAST_NAME
                    )
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
                dispatch(
                  setCompanyName(value),
                  CREATE_NEW_CONTACT.FIELD.COMPANY_NAME
                )
              }
              value={companyName}
              disabled={isLegalEntity() && isUpdate()}
            />
          </ClayForm.Group>
        </Row>
      )}
      <Row half={!showIndividualFields}>
        <ClayForm.Group>
          <ClayInput.Group>
            {showIndividualFields ? (
              <ClayInput.GroupItem
                className={
                  hasDayError || hasMonthError || hasYearError
                    ? "has-error"
                    : ""
                }
              >
                <label htmlFor="birthDateDay">
                  {CREATE_NEW_CONTACT.FIELD.BIRTH_DATE}
                </label>
                <div className="birth-date-group">
                  <ClayInput
                    ref={dayRef}
                    required={showIndividualFields}
                    id="birthDateDay"
                    type="text"
                    onChange={({ target: { value } }) =>
                      dispatch(setDateDay(value), "Birth Day")
                    }
                    placeholder="DD"
                    value={dateDay}
                    disabled={isIndividual() && isUpdate()}
                  />
                  <ClayInput
                    ref={monthRef}
                    required={showIndividualFields}
                    id="birthDateMonth"
                    type="text"
                    onChange={({ target: { value } }) =>
                      dispatch(setDateMonth(value), "Birth Month")
                    }
                    placeholder="MM"
                    value={dateMonth}
                    disabled={isIndividual() && isUpdate()}
                  />
                  <ClayInput
                    ref={yearRef}
                    required={showIndividualFields}
                    id="birthDateYear"
                    type="text"
                    onChange={({ target: { value } }) =>
                      dispatch(setDateYear(value), "Birth Year")
                    }
                    placeholder="YYYY"
                    value={dateYear}
                    disabled={isIndividual() && isUpdate()}
                  />
                </div>
                {hasDayError || hasMonthError || hasYearError ? (
                  <ClayForm.FeedbackGroup>
                    <ClayForm.FeedbackItem>{dayError}</ClayForm.FeedbackItem>
                    <ClayForm.FeedbackItem>{monthError}</ClayForm.FeedbackItem>
                    <ClayForm.FeedbackItem>{yearError}</ClayForm.FeedbackItem>
                  </ClayForm.FeedbackGroup>
                ) : null}
              </ClayInput.GroupItem>
            ) : null}
            <ClayInput.GroupItem className={hasOibError ? "has-error" : ""}>
              <label htmlFor="oibInput">{CREATE_NEW_CONTACT.FIELD.OIB}</label>
              <ClayInput
                required={foreignerStatus ? false : true}
                id="oibInput"
                type="text"
                onChange={({ target: { value } }) =>
                  dispatch(setOIB(value), CREATE_NEW_CONTACT.FIELD.OIB)
                }
                value={oib}
                disabled={isUpdate()}
                ref={oibRef}
              />
              {hasOibError ? (
                <ClayForm.FeedbackGroup>
                  <ClayForm.FeedbackItem>{oibError}</ClayForm.FeedbackItem>
                </ClayForm.FeedbackGroup>
              ) : null}
            </ClayInput.GroupItem>
          </ClayInput.Group>
        </ClayForm.Group>
      </Row>
      {!showIndividualFields ? (
        <Row half>
          <ClayForm.Group>
            <label htmlFor="subsidiaryNumber">
              {CREATE_NEW_CONTACT.FIELD.SUBSIDIARY_NUMBER}
            </label>
            <ClayInput
              required={!showIndividualFields}
              id="subsidiaryNumber"
              type="text"
              value={subsidiaryNumber}
              disabled={isUpdate()}
              onChange={({ target: { value } }) =>
                dispatch(
                  setSubsidiaryNumber(value),
                  CREATE_NEW_CONTACT.FIELD.SUBSIDIARY_NUMBER
                )
              }
            />
          </ClayForm.Group>
        </Row>
      ) : null}
      <Row>
        <ClayCheckbox
          aria-label={CREATE_NEW_CONTACT.FIELD.FOREIGNER_STATUS}
          label={CREATE_NEW_CONTACT.FIELD.FOREIGNER_STATUS}
          checked={foreignerStatus}
          onChange={() =>
            dispatch(
              toggleForeignerStatus(),
              CREATE_NEW_CONTACT.FIELD.FOREIGNER_STATUS
            )
          }
          disabled={isLegalEntity() && isUpdate()}
        />
      </Row>
    </FormSection>
  );
};

export default BasicInfo;
