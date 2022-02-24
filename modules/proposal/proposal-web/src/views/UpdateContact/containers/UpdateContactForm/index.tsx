import React, { useState, useEffect } from "react";
import { Wrapper, ButtonWrapper } from "./styles";
import BasicInfo from "../../../../shared/molecules/contact/BasicInfo";
import Addresses from "../../../../shared/molecules/contact/Addresses";
import ContactInfoForm from "../../../../shared/molecules/contact/ContactInfoForm";
import Modal from "../../../../shared/atoms/contact/Modal";
import ClayButton from "@clayui/button";
import {
  CONTACT_INFO,
  UPDATE_CONTACT,
} from "../../../../constants/languageKeys";
import {
  mapToCountryNames,
  mapToCountryCodes,
} from "../../../../shared/util/countryMappers";
import { actions as basicInfoActions } from "../../../../redux/basicInfoSlice";
import { actions as addressesSetters } from "../../../../redux/addressesSlice";
import { actions as contactInfoSetters } from "../../../../redux/contactInfoSlice";
import store, {
  resetState,
  useContactDispatch,
  useContactSelector,
} from "../../../../redux/store";
import { contactTypes } from "../../../../constants/contactConstants";
import LinkWrapper from "../../../../shared/atoms/contact/LinkWrapper";
import ContactButton from "../../../../shared/atoms/contact/ContactButton";
import API from "../../../../api";
import { CONTACT_URL, COUNTRIES_URL } from "../../../../api/constants/routes";
import { useFetchData } from "../../../../api/hooks/useFetchData";
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

const UpdateContactForm: React.FC<{ contactResponse: any }> = ({
  contactResponse,
}) => {
  const history = useHistory();
  const dispatch = useContactDispatch();
  const data = contactResponse[0];
  const { state, get } = useFetchData();
  const [countries, setCountries] = useState<Array<any> | null>(null);
  const [enabledButton, setEnabledButton] = useState(false);

  const [showModal, setShowModal] = useState(false);
  const [isUpdateSuccessful, setUpdateSuccess] = useState(false);
  const [updatedValues, setUpdatedValues] = useState<string[]>([]);

  const { contactType, firstName, lastName, companyName } = useContactSelector(
    (state) => state.basicInfo
  );

  useEffect(() => {
    get(COUNTRIES_URL);
  }, []);

  useEffect(() => {
    if (state.status === RESOLVED) {
      setCountries(state.response.data);
    }
  });

  useEffect(() => {
    setBasicInfoFields(data, dispatch, basicInfoActions);
    setAddressFields(data, dispatch, addressesSetters);
    setContactInfoFields(data, dispatch, contactInfoSetters);
  }, []);

  const createContactDTO = () => {
    const basicInfoDTO = createBasicInfoDTO(store);
    const addressesDTO = createAddressesDTO(store);
    const contactInfoDTO = createContactInfoDTO(store);
    return { ...basicInfoDTO, ...addressesDTO, ...contactInfoDTO };
  };

  const isLegalEntity = () => {
    return contactType === contactTypes.Legal_Entity;
  };

  const handleUpdateContact = () => {
    const response = API.put(CONTACT_URL, createContactDTO());
    window.scrollTo(0, 0);

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
              {contactType === contactTypes.Individual
                ? firstName + " " + lastName
                : companyName}
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

  return (
    <Wrapper id="update-contact-form-main-container">
      <Modal
        visible={showModal && isUpdateSuccessful}
        onClose={() => setShowModal(false)}
        title={UPDATE_CONTACT.TITLE}
        body={successMessage()}
        lastButtonTitle={UPDATE_CONTACT.USE_CONTACT}
        lastButtonAction={() => {
          return;
        }}
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
        operation="update"
        enableSave={() => {
          setEnabledButton(true);
        }}
        setUpdatedValues={handleUpdatedValues}
      />
      {countries && (
        <Addresses
          countries={mapToCountryNames(countries)}
          key="update-contact-addresses"
          operation="update"
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
          operation="update"
          enableSave={() => {
            setEnabledButton(true);
          }}
          setUpdatedValues={handleUpdatedValues}
        />
      )}

      <ButtonWrapper>
        <LinkWrapper
          title={CONTACT_INFO.CANCEL}
          handleClick={() => {
            history.replace({ pathname: "/", state: { doSearch: true } });
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
                  disabled={false}
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
                  disabled={false}
                />
              </span>
            </ClayButton.Group>
          )}

          <ClayButton.Group spaced>
            <ContactButton
              handleClick={() => {
                history.push("/product");
              }}
              label={UPDATE_CONTACT.USE_CONTACT}
              disabled={false}
            />
            {!isLegalEntity() && (
              <ContactButton
                handleClick={handleUpdateContact}
                label={UPDATE_CONTACT.SUBMIT_BUTTON}
                disabled={!enabledButton}
              />
            )}
          </ClayButton.Group>
        </ClayButton.Group>
      </ButtonWrapper>
    </Wrapper>
  );
};

export default UpdateContactForm;
