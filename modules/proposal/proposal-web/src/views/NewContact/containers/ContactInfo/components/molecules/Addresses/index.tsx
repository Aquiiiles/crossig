import React, { useEffect } from "react";
import { AutocompleteInput } from "../../atoms";
import SectionSubTitle from "../../atoms/SectionSubTitle";
import FormSection from "../../../../../../../shared/atoms/FormSection";
import Row from "../../../../../../../shared/atoms/Row";
import ClayForm, {
  ClayInput,
  ClayCheckbox,
  ClaySelectWithOption,
} from "@clayui/form";
import { contactTypes } from "../../../../../../../constants/contactConstants";
import { countryNames } from "../../../../../../../constants/defaultCountryConfiguration";
import { CREATE_NEW_CONTACT } from "../../../../../../../constants/languageKeys";
import {
  useContactSelector,
  useContactDispatch,
} from "../../../../../../../redux/store";
import { actions } from "../../../../../../../redux/addressSlice";
import { Line } from "./styles";
import { searchCitiesByName, searchStreetsByCityIdAndName } from "./controller";

const Addresses: React.FC<{ countries: { label: any; value: any }[] }> = ({
  countries,
}) => {
  const dispatch = useContactDispatch();
  const { contactType } = useContactSelector(state => state.basicInfo);
  const {
    country,
    dispatchCountry,
    city,
    dispatchCity,
    isSameAddress,
    postalCode,
    dispatchPostalCode,
  } = useContactSelector(state => state.address);
  const {
    setCountry,
    setDispatchCountry,
    setCity,
    setDispatchCity,
    setIsSameAddress,
    setPostalCode,
    setDispatchPostalCode,
  } = actions;

  const mainAddressInCroatia = country === countryNames.value;

  const dispatchAddressInCroatia = dispatchCountry === countryNames.value;

  return (
    <>
      <Line />
      <FormSection title={CREATE_NEW_CONTACT.ADDRESS_TITLE}>
        <SectionSubTitle
          subTitle={
            contactType === contactTypes.Individual
              ? CREATE_NEW_CONTACT.ID_ADDRES
              : CREATE_NEW_CONTACT.REGISTERED_OFFICE_ADDRESS
          }
        />

        <Row half>
          <ClayForm.Group>
            <label htmlFor="country">{CREATE_NEW_CONTACT.FIELD.COUNTRY}</label>
            <ClaySelectWithOption
              id="country"
              options={countries}
              onChange={({ target: { value } }) => dispatch(setCountry(value))}
              required
            />
          </ClayForm.Group>
        </Row>

        <Row>
          <ClayForm.Group>
            <ClayInput.Group>
              <ClayInput.GroupItem>
                <AutocompleteInput
                  label={CREATE_NEW_CONTACT.FIELD.CITY}
                  id={"city"}
                  active={mainAddressInCroatia}
                  getOptions={searchCitiesByName}
                  setParentValue={value => dispatch(setCity(parseInt(value)))}
                  setPostalCode={value => dispatch(setPostalCode(value))}
                  isCity
                  disabled={false}
                />
              </ClayInput.GroupItem>

              <ClayInput.GroupItem>
                <label htmlFor="postal-code">
                  {CREATE_NEW_CONTACT.FIELD.POSTAL_CODE}
                </label>

                <ClayInput
                  id="postal-code"
                  type="text"
                  disabled={mainAddressInCroatia}
                  value={postalCode}
                />
              </ClayInput.GroupItem>
            </ClayInput.Group>
          </ClayForm.Group>
        </Row>

        <ClayForm.Group>
          <AutocompleteInput
            label={CREATE_NEW_CONTACT.FIELD.STREET_ADDRESS}
            id={"street-addres"}
            active={mainAddressInCroatia}
            getOptions={searchStreetsByCityIdAndName(city)}
            setParentValue={() => {
              return;
            }}
            setPostalCode={() => {
              return;
            }}
            isCity={false}
            disabled={!postalCode}
          />
        </ClayForm.Group>

        <Row half>
          <ClayForm.Group>
            <label htmlFor="house-number">
              {CREATE_NEW_CONTACT.FIELD.HOUSE_NUMBER}
            </label>

            <ClayInput id="house-number" type="text" />
          </ClayForm.Group>
        </Row>

        <SectionSubTitle subTitle={CREATE_NEW_CONTACT.DISPATCH_ADDRESS} />

        <ClayCheckbox
          checked={isSameAddress}
          onChange={() => dispatch(setIsSameAddress(!isSameAddress))}
          label={CREATE_NEW_CONTACT.FIELD.DISPATCH_ADDRESS}
        />

        {!isSameAddress && (
          <>
            <Row half>
              <ClayForm.Group>
                <label htmlFor="dispatch-country">
                  {CREATE_NEW_CONTACT.FIELD.COUNTRY}
                </label>
                <ClaySelectWithOption
                  id="dispatch-country"
                  options={countries}
                  required
                  onChange={({ target: { value } }) =>
                    dispatch(setDispatchCountry(value))
                  }
                />
              </ClayForm.Group>
            </Row>

            <Row>
              <ClayForm.Group>
                <ClayInput.Group>
                  <ClayInput.GroupItem>
                    <AutocompleteInput
                      label={CREATE_NEW_CONTACT.FIELD.CITY}
                      id={"dispatch-city"}
                      active={dispatchAddressInCroatia}
                      getOptions={searchCitiesByName}
                      setParentValue={value => dispatch(setDispatchCity(parseInt(value)))}
                      setPostalCode={value =>
                        dispatch(setDispatchPostalCode(value))
                      }
                      isCity
                      disabled={false}
                    />
                  </ClayInput.GroupItem>

                  <ClayInput.GroupItem>
                    <label htmlFor="dispatch-postal-code">
                      {CREATE_NEW_CONTACT.FIELD.POSTAL_CODE}
                    </label>

                    <ClayInput
                      id="dispatch-postal-code"
                      type="text"
                      disabled={dispatchAddressInCroatia}
                      value={dispatchPostalCode}
                    />
                  </ClayInput.GroupItem>
                </ClayInput.Group>
              </ClayForm.Group>
            </Row>

            <ClayForm.Group>
              <AutocompleteInput
                label={CREATE_NEW_CONTACT.FIELD.STREET_ADDRESS}
                id={"dispatch-street-addres"}
                active={dispatchAddressInCroatia}
                getOptions={searchStreetsByCityIdAndName(dispatchCity)}
                setParentValue={() => {
                  return;
                }}
                setPostalCode={() => {
                  return;
                }}
                isCity={false}
                disabled={!dispatchPostalCode}
              />
            </ClayForm.Group>

            <Row half>
              <ClayForm.Group>
                <label htmlFor="dispatch-house-number">
                  {CREATE_NEW_CONTACT.FIELD.HOUSE_NUMBER}
                </label>

                <ClayInput id="dispatch-house-number" type="text" />
              </ClayForm.Group>
            </Row>
          </>
        )}
      </FormSection>
      <Line />
    </>
  );
};

export default Addresses;
