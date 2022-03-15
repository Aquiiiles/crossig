import React from "react";
import FormSection from "../../../atoms/contact/FormSection";
import Row from "../../../atoms/contact/Row";
import { CREATE_NEW_CONTACT } from "../../../../constants/languageKeys";
import ClayForm, {
  ClayInput,
  ClayCheckbox,
  ClaySelectWithOption,
} from "@clayui/form";
import { actions } from "../../../../redux";
import { useDispatch, useSelector } from "../../../../redux/store";
import {
  contactOperations,
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
import useRequiredField from "../../../hooks/useRequiredField";

type propsType = {
  operation: number;
  enableSave?: () => void;
  setUpdatedValues?: (value: string) => void;
};

const BasicInfo: React.FC<propsType> = ({
  enableSave,
  operation,
  setUpdatedValues,
}: propsType) => {
  const dispatcher = useDispatch();

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
  } = useSelector((state) => state.basicInfo);
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
  } = actions.basicInfo;

  const showIndividualFields = contactType === contactTypes.Individual;

  const isLegalEntity = () => {
    return contactType === contactTypes.Legal_Entity;
  };

  const isIndividual = () => {
    return contactType === contactTypes.Individual;
  };

  const isUpdate = () => {
    return operation !== contactOperations.create;
  };

  const isReadOnly = () => {
    return operation === contactOperations.updateReadOnly;
  };

  const [dayError, hasDayError] = useFieldValidation(
    dateDay,
    React.useCallback(
      (value) => validateDay(value, dateMonth, dateYear),

      [dateYear, dateMonth]
    )
  );
  const [monthError, hasMonthError] = useFieldValidation(
    dateMonth,
    React.useCallback(validateMonth, [])
  );
  const [yearError, hasYearError] = useFieldValidation(
    dateYear,
    React.useCallback(validateYear, [])
  );
  const [oibError, hasOibError] = useFieldValidation(
    oib,
    React.useCallback(validateOib, [])
  );

  useJumpFocus(dateDay, "birthDateMonth", 2);

  useJumpFocus(dateMonth, "birthDateYear", 2);

  const [registerRequiredName, nameWarn, hasNameWarn] = useRequiredField(
    firstName,
    showIndividualFields
  );
  const [registerRequiredLastName, lastNameWarn, hasLastNameWarn] =
    useRequiredField(lastName, showIndividualFields);
  const [registerRequiredOib, oibWarn, hasOibWarn] = useRequiredField(
    oib,
    !foreignerStatus
  );
  const [registerRequiredDay, dayWarn, hasDayWarn] = useRequiredField(
    dateDay,
    showIndividualFields
  );
  const [registerRequiredMonth, monthWarn, hasMonthWarn] = useRequiredField(
    dateMonth,
    showIndividualFields
  );
  const [registerRequiredYear, yearWarn, hasYearWarn] = useRequiredField(
    dateYear,
    showIndividualFields
  );
  const [registerRequiredCompanyName, companyNameWarn, hasCompanyNameWarn] =
    useRequiredField(companyName, !showIndividualFields);
  const [
    registerRequiredSubsidiaryNumber,
    subsidiaryNumberWarn,
    hasSubsidiaryNumberWarn,
  ] = useRequiredField(subsidiaryNumber, !showIndividualFields);

  return (
    <FormSection title={CREATE_NEW_CONTACT.BASIC_INFO_TITLE}>
      <ClayForm.Group>
        <label className="required" htmlFor="contactTypeInput">
          {CREATE_NEW_CONTACT.TYPE}
        </label>
        <ClaySelectWithOption
          id="contactTypeInput"
          required
          value={contactType}
          onChange={({ target: { value } }) =>
            dispatch(setContactType(value), CREATE_NEW_CONTACT.TYPE)
          }
          options={contactTypeOptions}
          disabled={isUpdate() || isReadOnly()}
        ></ClaySelectWithOption>
      </ClayForm.Group>
      {showIndividualFields ? (
        <Row>
          <ClayForm.Group>
            <ClayInput.Group>
              <ClayInput.GroupItem className={hasNameWarn ? "has-warning" : ""}>
                <label
                  className={showIndividualFields ? "required" : ""}
                  htmlFor="firstNameInput"
                >
                  {CREATE_NEW_CONTACT.FIELD.FIRST_NAME}
                </label>
                <ClayInput
                  id="firstNameInput"
                  type="text"
                  onChange={({ target: { value } }) =>
                    dispatch(
                      setFirstName(value),
                      CREATE_NEW_CONTACT.FIELD.FIRST_NAME
                    )
                  }
                  value={firstName}
                  disabled={(isIndividual() && isUpdate()) || isReadOnly()}
                  {...registerRequiredName}
                />
                {hasNameWarn ? (
                  <ClayForm.FeedbackGroup>
                    <ClayForm.FeedbackItem>{nameWarn}</ClayForm.FeedbackItem>
                  </ClayForm.FeedbackGroup>
                ) : null}
              </ClayInput.GroupItem>

              <ClayInput.GroupItem
                className={hasLastNameWarn ? "has-warning" : ""}
              >
                <label
                  className={showIndividualFields ? "required" : ""}
                  htmlFor="lastNameInput"
                >
                  {CREATE_NEW_CONTACT.FIELD.LAST_NAME}
                </label>
                <ClayInput
                  id="lastNameInput"
                  type="text"
                  onChange={({ target: { value } }) =>
                    dispatch(
                      setLastName(value),
                      CREATE_NEW_CONTACT.FIELD.LAST_NAME
                    )
                  }
                  {...registerRequiredLastName}
                  value={lastName}
                  disabled={isReadOnly()}
                />
                {hasLastNameWarn ? (
                  <ClayForm.FeedbackGroup>
                    <ClayForm.FeedbackItem>
                      {lastNameWarn}
                    </ClayForm.FeedbackItem>
                  </ClayForm.FeedbackGroup>
                ) : null}
              </ClayInput.GroupItem>
            </ClayInput.Group>
          </ClayForm.Group>
        </Row>
      ) : (
        <Row>
          <ClayForm.Group className={hasCompanyNameWarn ? "has-warning" : ""}>
            <label
              className={!showIndividualFields ? "required" : ""}
              htmlFor="companyName"
            >
              {CREATE_NEW_CONTACT.FIELD.COMPANY_NAME}
            </label>
            <ClayInput
              {...registerRequiredCompanyName}
              id="companyName"
              type="text"
              onChange={({ target: { value } }) =>
                dispatch(
                  setCompanyName(value),
                  CREATE_NEW_CONTACT.FIELD.COMPANY_NAME
                )
              }
              value={companyName}
              disabled={(isLegalEntity() && isUpdate()) || isReadOnly()}
            />
            {hasCompanyNameWarn ? (
              <ClayForm.FeedbackGroup>
                <ClayForm.FeedbackItem>{companyNameWarn}</ClayForm.FeedbackItem>
              </ClayForm.FeedbackGroup>
            ) : null}
          </ClayForm.Group>
        </Row>
      )}
      <Row half={!showIndividualFields}>
        <ClayForm.Group>
          <ClayInput.Group id="dateOibInputGroup">
            {showIndividualFields ? (
              <ClayInput.GroupItem
                className={`${
                  hasDayError || hasMonthError || hasYearError
                    ? "has-error"
                    : ""
                } ${
                  hasDayWarn || hasMonthWarn || hasYearWarn ? "has-warning" : ""
                }`}
              >
                <label
                  className={showIndividualFields ? "required" : ""}
                  htmlFor="birthDateDay"
                >
                  {CREATE_NEW_CONTACT.FIELD.BIRTH_DATE}
                </label>
                <div className="birth-date-group">
                  <ClayInput
                    id="birthDateDay"
                    type="text"
                    onChange={({ target: { value } }) =>
                      dispatch(setDateDay(value), "Birth Day")
                    }
                    placeholder="DD"
                    value={dateDay}
                    disabled={(isIndividual() && isUpdate()) || isReadOnly()}
                    {...registerRequiredDay}
                  />
                  <ClayInput
                    id="birthDateMonth"
                    type="text"
                    onChange={({ target: { value } }) =>
                      dispatch(setDateMonth(value), "Birth Month")
                    }
                    placeholder="MM"
                    value={dateMonth}
                    disabled={(isIndividual() && isUpdate()) || isReadOnly()}
                    {...registerRequiredMonth}
                  />
                  <ClayInput
                    id="birthDateYear"
                    type="text"
                    onChange={({ target: { value } }) =>
                      dispatch(setDateYear(value), "Birth Year")
                    }
                    placeholder="YYYY"
                    value={dateYear}
                    disabled={(isIndividual() && isUpdate()) || isReadOnly()}
                    {...registerRequiredYear}
                  />
                </div>
                {hasDayError ||
                hasMonthError ||
                hasYearError ||
                hasDayWarn ||
                hasMonthWarn ||
                hasYearWarn ? (
                  <ClayForm.FeedbackGroup>
                    <ClayForm.FeedbackItem>
                      {dayWarn !== ""
                        ? dayWarn
                        : monthWarn !== ""
                        ? monthWarn
                        : yearWarn !== ""
                        ? yearWarn
                        : ""}
                    </ClayForm.FeedbackItem>
                    <ClayForm.FeedbackItem>{dayError}</ClayForm.FeedbackItem>
                    <ClayForm.FeedbackItem>{monthError}</ClayForm.FeedbackItem>
                    <ClayForm.FeedbackItem>{yearError}</ClayForm.FeedbackItem>
                  </ClayForm.FeedbackGroup>
                ) : null}
              </ClayInput.GroupItem>
            ) : null}
            <ClayInput.GroupItem
              className={`${hasOibError ? "has-error" : ""} ${
                hasOibWarn ? "has-warning" : ""
              }`}
            >
              <label
                className={foreignerStatus ? "" : "required"}
                htmlFor="oibInput"
              >
                {CREATE_NEW_CONTACT.FIELD.OIB}
              </label>
              <ClayInput
                id="oibInput"
                type="text"
                onChange={({ target: { value } }) =>
                  dispatch(setOIB(value), CREATE_NEW_CONTACT.FIELD.OIB)
                }
                value={oib}
                disabled={isUpdate() || isReadOnly()}
                {...registerRequiredOib}
              />
              {hasOibWarn || hasOibError ? (
                <ClayForm.FeedbackGroup>
                  {hasOibWarn ? (
                    <ClayForm.FeedbackItem>{oibWarn}</ClayForm.FeedbackItem>
                  ) : null}
                  {hasOibError ? (
                    <ClayForm.FeedbackItem>{oibError}</ClayForm.FeedbackItem>
                  ) : null}
                </ClayForm.FeedbackGroup>
              ) : null}
            </ClayInput.GroupItem>
          </ClayInput.Group>
        </ClayForm.Group>
      </Row>
      {!showIndividualFields ? (
        <Row half>
          <ClayForm.Group
            className={hasSubsidiaryNumberWarn ? "has-warning" : ""}
          >
            <label
              className={!showIndividualFields ? "required" : ""}
              htmlFor="subsidiaryNumber"
            >
              {CREATE_NEW_CONTACT.FIELD.SUBSIDIARY_NUMBER}
            </label>
            <ClayInput
              required={!showIndividualFields}
              id="subsidiaryNumber"
              type="text"
              value={subsidiaryNumber}
              disabled={isUpdate() || isReadOnly()}
              onChange={({ target: { value } }) =>
                dispatch(
                  setSubsidiaryNumber(value),
                  CREATE_NEW_CONTACT.FIELD.SUBSIDIARY_NUMBER
                )
              }
            />
            {hasSubsidiaryNumberWarn ? (
              <ClayForm.FeedbackGroup>
                <ClayForm.FeedbackItem>
                  {subsidiaryNumberWarn}
                </ClayForm.FeedbackItem>
              </ClayForm.FeedbackGroup>
            ) : null}
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
          disabled={(isLegalEntity() && isUpdate()) || isReadOnly()}
        />
      </Row>
      {isLegalEntity() && <p>{CREATE_NEW_CONTACT.CREATE_LEGAL_ENTITY}</p>}
    </FormSection>
  );
};

export default BasicInfo;
