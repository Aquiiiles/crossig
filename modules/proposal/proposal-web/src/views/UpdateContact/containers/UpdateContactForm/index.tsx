import React, { useState, useEffect } from "react";
import { Wrapper, ButtonWrapper } from "./styles";
import BasicInfo from "../../../../shared/molecules/contact/BasicInfo";
import Addresses from "../../../../shared/molecules/contact/Addresses";
import ContactInfoForm from "../../../../shared/molecules/contact/ContactInfoForm";
import Modal from "../../../../shared/atoms/Modal";
import ClayButton from "@clayui/button";
import {
  CONTACT_INFO,
  UPDATE_CONTACT,
  ROLES_ON_POLICY,
} from "../../../../constants/languageKeys";
import {
  mapToCountryNames,
  mapToCountryCodes,
} from "../../../../shared/util/countryMappers";
import { actions } from "../../../../redux";
import store, { useDispatch, useSelector } from "../../../../redux/store";
import {
  contactOperations,
  contactTypes,
} from "../../../../constants/contactConstants";
import LinkWrapper from "../../../../shared/atoms/LinkWrapper";
import ContactButton from "../../../../shared/atoms/contact/ContactButton";
import { CONTACT_URL, COUNTRIES_URL } from "../../../../api/constants/routes";
import { useHttpRequest } from "../../../../api/hooks/useHttpRequest";
import { RESOLVED } from "../../../../api/reducers/constants";
import { useHistory } from "react-router-dom";
import {
  createAddressesDTO,
  createBasicInfoDTO,
  createContactInfoDTO,
  setAddressFields,
  setBasicInfoFields,
  setContactInfoFields,
} from "./util";
import * as constants from "../../../ContactSearch/constants/searchResult";
import { resetScroll } from "../../../../shared/util/commonFunctions";
import { ROUTES } from "../../../../constants/routes";

const UpdateContactForm: React.FC<{
  contactResponse: any;
  extNumber: unknown;
  operation: number;
}> = ({ contactResponse, extNumber, operation }) => {
  const history = useHistory();
  const dispatch = useDispatch();
  const data = contactResponse[0];
  const [countriesResponse, { fetchData: fetchCountries }] = useHttpRequest();
  const [, { returnFetchData: updateContact }] = useHttpRequest();
  const [countries, setCountries] = useState<Array<any> | null>(null);
  const [enabledButton, setEnabledButton] = useState(false);

  const [showModal, setShowModal] = useState(false);
  const [isUpdateSuccessful, setUpdateSuccess] = useState(false);
  const [updatedValues, setUpdatedValues] = useState<string[]>([]);

  const basicInfoValues = useSelector((state) => state.basicInfo);
  const contactInfoValues = useSelector((state) => state.contactInfo);

  useEffect(() => {
    fetchCountries("GET", COUNTRIES_URL);
  }, []);

  useEffect(() => {
    if (countriesResponse.status === RESOLVED) {
      setCountries(countriesResponse.response.data);
    }
  }, [countriesResponse]);

  useEffect(() => {
    setBasicInfoFields(data, dispatch, actions.basicInfo);
    setAddressFields(data, dispatch, actions.addresses);
    setContactInfoFields(data, dispatch, actions.contactInfo);
  }, []);

  const createContactDTO = () => {
    const basicInfoDTO = createBasicInfoDTO(store);
    const addressesDTO = createAddressesDTO(store);
    const contactInfoDTO = createContactInfoDTO(store);
    return { ...basicInfoDTO, ...addressesDTO, ...contactInfoDTO };
  };

  const isLegalEntity = () => {
    return basicInfoValues.contactType === contactTypes.Legal_Entity;
  };

  const handleUpdateContact = () => {
    const response = updateContact("PUT", CONTACT_URL, createContactDTO());
    resetScroll();

    response
      .then(() => {
        setUpdateSuccess(true);
        setShowModal(true);
      })
      .catch(() => {
        setUpdateSuccess(false);
        setShowModal(true);
      });
  };

  const successMessage = () => {
    return (
      <>
        <p>{UPDATE_CONTACT.SUCCESS}</p>
        <p>
          {updatedValues.map((value: string, index: number) => {
            return (
              <span key={index}>
                {value !== "" && index > 0 && ", "}
                {value}
              </span>
            );
          })}

          {updatedValues.length > 0 && (
            <span style={{ marginLeft: 5 }}>
              {" "}
              updated for{" "}
              {basicInfoValues.contactType === contactTypes.Individual
                ? basicInfoValues.firstName + " " + basicInfoValues.lastName
                : basicInfoValues.companyName}
            </span>
          )}
        </p>
      </>
    );
  };

  const handleUpdatedValues = (value: string) => {
    const prevValues = [...updatedValues];
    const valueUpdated = prevValues.includes(value);
    if (!valueUpdated) {
      setUpdatedValues([...prevValues, value]);
    }
  };

  const useContact = () => {
    if (operation === contactOperations.updateEmbedded) {
      dispatch(
        actions.contactsInPolicy.addContact({
          [constants.EXT_NUMBER_KEY]: Number(extNumber),
          [constants.OIB_KEY]: basicInfoValues.oib,
          [constants.SUB_KEY]: basicInfoValues.subsidiaryNumber,
          [constants.NAME_KEY]:
            basicInfoValues.firstName + basicInfoValues.lastName,
          [constants.ROLES_KEY]: [ROLES_ON_POLICY.INSURED],
        })
      );
      history.goBack();
    } else {
      dispatch(actions.contactsInPolicy.resetFields());
      dispatch(
        actions.contactsInPolicy.setPolicyHolder({
          [constants.EXT_NUMBER_KEY]: Number(extNumber),
          [constants.OIB_KEY]: basicInfoValues.oib,
          [constants.SUB_KEY]: basicInfoValues.subsidiaryNumber,
          [constants.NAME_KEY]:
            basicInfoValues.firstName + basicInfoValues.lastName,
          [constants.ROLES_KEY]: [ROLES_ON_POLICY.INSURED],
        })
      );
      history.push(ROUTES.PRODUCT);
    }
  };

  const readOnly = operation === contactOperations.updateReadOnly;

  const goBackPath =
    operation === contactOperations.create ||
    operation === contactOperations.update
      ? ROUTES.CONTACT_SEARCH
      : ROUTES.ROLES;

  return (
    <Wrapper id="update-contact-form-main-container">
      <Modal
        visible={showModal && isUpdateSuccessful}
        onClose={() => setShowModal(false)}
        title={UPDATE_CONTACT.TITLE}
        body={successMessage()}
        lastButtonTitle={UPDATE_CONTACT.USE_CONTACT}
        lastButtonAction={useContact}
        timeOut={5000}
      />

      <Modal
        visible={showModal && !isUpdateSuccessful}
        onClose={() => setShowModal(false)}
        title={UPDATE_CONTACT.TITLE}
        body={UPDATE_CONTACT.FAILURE}
        timeOut={5000}
      />

      <h3>{UPDATE_CONTACT.TITLE}</h3>
      <p className="subtitle">{UPDATE_CONTACT.SUBTITLE}</p>
      <BasicInfo
        key="update-contact-basic-info"
        operation={operation}
        enableSave={() => {
          setEnabledButton(true);
        }}
        setUpdatedValues={handleUpdatedValues}
        basicInfoValues={basicInfoValues}
        basicInfoActions={actions.basicInfo}
      />
      {countries && (
        <Addresses
          countries={mapToCountryNames(countries)}
          key="update-contact-addresses"
          operation={operation}
          enableSave={() => {
            setEnabledButton(true);
          }}
          setUpdatedValues={handleUpdatedValues}
        />
      )}
      {countries && (
        <ContactInfoForm
          countries={mapToCountryCodes(countries)}
          key="update-contact-contact-info"
          operation={operation}
          enableSave={() => {
            setEnabledButton(true);
          }}
          setUpdatedValues={handleUpdatedValues}
          contactType={basicInfoValues.contactType}
          contactInfoValues={contactInfoValues}
          contactInfoActions={actions.contactInfo}
        />
      )}

      <ButtonWrapper>
        <LinkWrapper
          title={CONTACT_INFO.CANCEL}
          handleClick={() => {
            history.push({ pathname: goBackPath, state: { doSearch: true } });
          }}
          disabled={false}
        />

        <ClayButton.Group spaced>
          {isLegalEntity() ? (
            <ClayButton.Group spaced>
              <span className="link-small">
                {UPDATE_CONTACT.EDIT_LEGAL_ENTITY}
              </span>

              <span>
                <LinkWrapper
                  title={UPDATE_CONTACT.CREATE_A_TASK}
                  handleClick={() => {
                    return;
                  }}
                  disabled={readOnly}
                />
              </span>

              <span className="link-small">
                {UPDATE_CONTACT.BACKOFFICE_WILL_GET_NOTIFIED}
              </span>
            </ClayButton.Group>
          ) : (
            <ClayButton.Group spaced>
              <span>
                <LinkWrapper
                  title={UPDATE_CONTACT.CREATE_A_TASK}
                  handleClick={() => {
                    return;
                  }}
                  disabled={readOnly}
                />
              </span>
            </ClayButton.Group>
          )}

          <ClayButton.Group spaced>
            <ContactButton
              handleClick={useContact}
              label={UPDATE_CONTACT.USE_CONTACT}
              disabled={readOnly}
            />
            {!isLegalEntity() && (
              <ContactButton
                handleClick={handleUpdateContact}
                label={UPDATE_CONTACT.SUBMIT_BUTTON}
                disabled={!enabledButton || readOnly}
              />
            )}
          </ClayButton.Group>
        </ClayButton.Group>
      </ButtonWrapper>
    </Wrapper>
  );
};

export default UpdateContactForm;
