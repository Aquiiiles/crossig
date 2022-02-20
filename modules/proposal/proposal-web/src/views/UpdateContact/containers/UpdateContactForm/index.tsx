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
import store, { useContactDispatch , useContactSelector}  from "../../../../redux/store";
import { PhoneNumber } from "../../../../shared/types/contact";
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
  const [isLegalEntity, setIsLegalEntity] = useState(data.entityType.id.toString() === contactTypes.Legal_Entity);

  const [showModal, setShowModal] = useState(false);
  const [isUpdateSuccessful, setUpdateSuccess] = useState(false);

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

  const handleUpdateContact = () => {
    const response = API.put(CONTACT_URL, createContactDTO());
    window.scrollTo(0, 0);

    setUpdateSuccess(true);
    setShowModal(true);

    response.then((result) => {
      return;
    });
  };
  
  return (
    <Wrapper id="update-contact-form-main-container">
      {showModal && isUpdateSuccessful && (
        <Modal
          title={UPDATE_CONTACT.TITLE}
          body={UPDATE_CONTACT.SUCCESS}
          lastButtonTitle={UPDATE_CONTACT.USE_CONTACT}
          lastButtonAction={() => {
            return;
          }}
        />
      )}
      {showModal && !isUpdateSuccessful && (
        <Modal title={UPDATE_CONTACT.TITLE} body={UPDATE_CONTACT.FAILURE} />
      )}
      <h3>{UPDATE_CONTACT.TITLE}</h3>
      <p className="subtitle">{UPDATE_CONTACT.SUBTITLE}</p>
      <BasicInfo key="update-contact-basic-info" operation="update" enableSave={()=>{ setEnabledButton(true)}} />
      {countries && (
        <Addresses
          countries={mapToCountryNames(countries)}
          key="update-contact-addresses"
          operation="update"
          enableSave={()=>{ setEnabledButton(true)}}
        />
      )}
      {countries && (
        <ContactInfoForm
          countries={mapToCountryCodes(countries)}
          key="update-contact-contact-info"
          operation="update"
          enableSave={()=>{ setEnabledButton(true)}}
        />
      )}

      <ButtonWrapper>
        <LinkWrapper
          title={CONTACT_INFO.CANCEL}
          handleClick={() => {
            [basicInfoActions, addressesSetters, contactInfoSetters].forEach(
              (action) => dispatch(action["resetFields"]())
            );
            history.push("/");
          }}
          disabled={false}
        />
        <ClayButton.Group spaced>
          <ContactButton
            handleClick={() => {
              return;
            }}
            label={UPDATE_CONTACT.USE_CONTACT}
            disabled={!isLegalEntity}
          />
          <ContactButton
            handleClick={handleUpdateContact}
            label={UPDATE_CONTACT.SUBMIT_BUTTON}
            disabled={!enabledButton && !isLegalEntity}
          />
        </ClayButton.Group>
      </ButtonWrapper>
    </Wrapper>
  );
};

export default UpdateContactForm;
