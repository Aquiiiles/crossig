import React, { useEffect } from "react";
import AutocompleteInput from "../../../atoms/contact/AutocompleteInput";
import SectionSubTitle from "../../../atoms/contact/SectionSubTitle";
import FormSection from "../../../atoms/contact/FormSection";
import Row from "../../../atoms/contact/Row";
import ClayForm, {
  ClayInput,
  ClayCheckbox,
  ClaySelectWithOption,
} from "@clayui/form";
import { contactTypes } from "../../../../constants/contactConstants";
import { countryNames } from "../../../../constants/defaultCountryConfiguration";
import { CREATE_NEW_CONTACT } from "../../../../constants/languageKeys";
import {
  useContactDispatch,
  useContactSelector,
} from "../../../../redux/store";
import { actions } from "../../../../redux/addressesSlice";
import { Line } from "./styles";
import { searchCitiesByName, searchStreetsByCityIdAndName } from "./controller";
import useRequiredField from "../../../hooks/useRequiredField";

type propsType = {
  enableSave?: () => void;
  countries: { label: any; value: any }[];
  operation: string;
  setUpdatedValues?: (value: string) => void;
};

const Addresses: React.FC<propsType> = ({
  countries,
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

  const { contactType } = useContactSelector(
    (state: { basicInfo: any }) => state.basicInfo
  );

  const {
    country,
    dispatchCountry,
    city,
    dispatchCity,
    cityName,
    dispatchCityName,
    street,
    dispatchStreet,
    isSameAddress,
    postalCode,
    dispatchPostalCode,
    houseNumber,
    dispatchHouseNumber,
  } = useContactSelector((state) => state.addresses);
  const {
    setCountry,
    setDispatchCountry,
    setCity,
    setDispatchCity,
    setStreet,
    setDispatchStreet,
    setIsSameAddress,
    setPostalCode,
    setDispatchPostalCode,
    setHouseNumber,
    setDispatchHouseNumber,
  } = actions;

  const isMainAddressInCroatia = () => {
    return country === countryNames.value || country === countryNames.label;
  };

  const isDispatchAddressInCroatia = () => {
    return (
      dispatchCountry === countryNames.value ||
      dispatchCountry === countryNames.label
    );
  };

  const isLegalEntity = () => {
    return contactType === contactTypes.Legal_Entity;
  };

  const isUpdate = () => {
    return operation === "update";
  };

  const [registerRequiredCity, cityWarn, hasCityWarn] = useRequiredField(
    city,
    true
  );
  const [registerRequiredAddress, addressWarn, hasAddressWarn] =
    useRequiredField(street, true);
  const [registerRequiredHouseNumber, houseNumberWarn, hasHouseNumberWarn] =
    useRequiredField(houseNumber, true);
  const [registerRequiredDispatchCity, dispatchCityWarn, hasDispatchCityWarn] =
    useRequiredField(dispatchCity, true);
  const [
    registerRequiredDispatchAddress,
    dispatchAddressWarn,
    hasDispatchAddressWarn,
  ] = useRequiredField(dispatchStreet, true);
  const [
    registerRequiredDispatchHouseNumber,
    dispatchHouseNumberWarn,
    hasDispatchHouseNumberWarn,
  ] = useRequiredField(dispatchHouseNumber, true);

  return (
    <>
      <Line />
      <FormSection title={CREATE_NEW_CONTACT.ADDRESS_TITLE}>
        <SectionSubTitle
          subTitle={
            contactType === contactTypes.Individual
              ? CREATE_NEW_CONTACT.ID_ADDRESS
              : CREATE_NEW_CONTACT.REGISTERED_OFFICE_ADDRESS
          }
        />

        <Row half>
          <ClayForm.Group>
            <label className="required" htmlFor="country">
              {CREATE_NEW_CONTACT.FIELD.COUNTRY}
            </label>
            <ClaySelectWithOption
              id="country"
              options={countries}
              onChange={({ target: { value } }) =>
                dispatch(setCountry(value), CREATE_NEW_CONTACT.FIELD.COUNTRY)
              }
              required
              disabled={isLegalEntity() && isUpdate()}
            />
          </ClayForm.Group>
        </Row>

        <Row>
          <ClayForm.Group>
            <ClayInput.Group>
              <ClayInput.GroupItem className={hasCityWarn ? "has-warning" : ""}>
                <AutocompleteInput
                  label={CREATE_NEW_CONTACT.FIELD.CITY}
                  id={"city"}
                  active={isMainAddressInCroatia()}
                  getOptions={searchCitiesByName}
                  setParentValue={(value) =>
                    dispatch(setCity(value), CREATE_NEW_CONTACT.FIELD.CITY)
                  }
                  setPostalCode={(value) =>
                    dispatch(
                      setPostalCode(value),
                      CREATE_NEW_CONTACT.FIELD.POSTAL_CODE
                    )
                  }
                  isCity
                  disabled={isLegalEntity() && isUpdate()}
                  selectedValue={cityName}
                  {...registerRequiredCity}
                />
                {hasCityWarn ? (
                  <ClayForm.FeedbackGroup>
                    <ClayForm.FeedbackItem>{cityWarn}</ClayForm.FeedbackItem>
                  </ClayForm.FeedbackGroup>
                ) : null}
              </ClayInput.GroupItem>

              <ClayInput.GroupItem>
                <label htmlFor="postal-code">
                  {CREATE_NEW_CONTACT.FIELD.POSTAL_CODE}
                </label>

                <ClayInput
                  id="postal-code"
                  type="number"
                  onChange={(e) =>
                    dispatch(
                      setPostalCode(e.target.value.toString()),
                      CREATE_NEW_CONTACT.FIELD.POSTAL_CODE
                    )
                  }
                  disabled={
                    isMainAddressInCroatia() || (isLegalEntity() && isUpdate())
                  }
                  value={postalCode}
                />
              </ClayInput.GroupItem>
            </ClayInput.Group>
          </ClayForm.Group>
        </Row>
        <ClayForm.Group className={hasAddressWarn ? "has-warning" : ""}>
          {isMainAddressInCroatia() ? (
            <AutocompleteInput
              label={CREATE_NEW_CONTACT.FIELD.STREET_ADDRESS}
              id={"street-address-autocomplete"}
              active={isMainAddressInCroatia()}
              getOptions={searchStreetsByCityIdAndName(parseInt(city))}
              setParentValue={(value) =>
                dispatch(
                  setStreet(value),
                  CREATE_NEW_CONTACT.FIELD.STREET_ADDRESS
                )
              }
              isCity={false}
              disabled={!postalCode || (isLegalEntity() && isUpdate())}
              {...registerRequiredAddress}
            />
          ) : (
            <>
              <label className="required" htmlFor="street-address-input">
                {CREATE_NEW_CONTACT.FIELD.STREET_ADDRESS}
              </label>

              <ClayInput
                id="street-address-input"
                type="text"
                onChange={(e) =>
                  dispatch(
                    setStreet(e.target.value.toString()),
                    CREATE_NEW_CONTACT.FIELD.STREET_ADDRESS
                  )
                }
                value={street}
                disabled={isLegalEntity() && isUpdate()}
                {...registerRequiredAddress}
              />
            </>
          )}
          {hasAddressWarn ? (
            <ClayForm.FeedbackGroup>
              <ClayForm.FeedbackItem>{addressWarn}</ClayForm.FeedbackItem>
            </ClayForm.FeedbackGroup>
          ) : null}
        </ClayForm.Group>
        <Row half>
          <ClayForm.Group className={hasHouseNumberWarn ? "has-warning" : ""}>
            <label className="required" htmlFor="house-number">
              {CREATE_NEW_CONTACT.FIELD.HOUSE_NUMBER}
            </label>
            <ClayInput
              id="house-number"
              type="number"
              onChange={(e) =>
                dispatch(
                  setHouseNumber(e.target.value.toString()),
                  CREATE_NEW_CONTACT.FIELD.HOUSE_NUMBER
                )
              }
              value={houseNumber}
              disabled={isLegalEntity() && isUpdate()}
              {...registerRequiredHouseNumber}
            />
            {hasHouseNumberWarn ? (
              <ClayForm.FeedbackGroup>
                <ClayForm.FeedbackItem>{houseNumberWarn}</ClayForm.FeedbackItem>
              </ClayForm.FeedbackGroup>
            ) : null}
          </ClayForm.Group>
        </Row>

        <SectionSubTitle subTitle={CREATE_NEW_CONTACT.DISPATCH_ADDRESS} />

        <ClayCheckbox
          checked={isSameAddress}
          onChange={() =>
            dispatch(
              setIsSameAddress(!isSameAddress),
              CREATE_NEW_CONTACT.FIELD.DISPATCH_ADDRESS
            )
          }
          label={CREATE_NEW_CONTACT.FIELD.DISPATCH_ADDRESS}
          disabled={isLegalEntity() && isUpdate()}
        />

        {!isSameAddress && (
          <>
            <Row half>
              <ClayForm.Group>
                <label className="required" htmlFor="dispatch-country">
                  {CREATE_NEW_CONTACT.FIELD.COUNTRY}
                </label>
                <ClaySelectWithOption
                  id="dispatch-country"
                  options={countries}
                  required
                  onChange={({ target: { value } }) =>
                    dispatch(
                      setDispatchCountry(value),
                      CREATE_NEW_CONTACT.FIELD.COUNTRY
                    )
                  }
                  disabled={isLegalEntity() && isUpdate()}
                />
              </ClayForm.Group>
            </Row>

            <Row>
              <ClayForm.Group>
                <ClayInput.Group>
                  <ClayInput.GroupItem
                    className={hasDispatchCityWarn ? "has-warning" : ""}
                  >
                    <AutocompleteInput
                      label={CREATE_NEW_CONTACT.FIELD.CITY}
                      id={"dispatch-city"}
                      active={isDispatchAddressInCroatia()}
                      getOptions={searchCitiesByName}
                      setParentValue={(value) =>
                        dispatch(
                          setDispatchCity(value),
                          CREATE_NEW_CONTACT.FIELD.CITY
                        )
                      }
                      setPostalCode={(value) =>
                        dispatch(
                          setDispatchPostalCode(value),
                          CREATE_NEW_CONTACT.FIELD.POSTAL_CODE
                        )
                      }
                      isCity
                      disabled={isLegalEntity() && isUpdate()}
                      selectedValue={dispatchCityName}
                      {...registerRequiredDispatchCity}
                    />
                    {hasDispatchCityWarn ? (
                      <ClayForm.FeedbackGroup>
                        <ClayForm.FeedbackItem>
                          {dispatchCityWarn}
                        </ClayForm.FeedbackItem>
                      </ClayForm.FeedbackGroup>
                    ) : null}
                  </ClayInput.GroupItem>

                  <ClayInput.GroupItem>
                    <label htmlFor="dispatch-postal-code">
                      {CREATE_NEW_CONTACT.FIELD.POSTAL_CODE}
                    </label>

                    <ClayInput
                      id="dispatch-postal-code"
                      type="number"
                      disabled={
                        isDispatchAddressInCroatia() ||
                        (isLegalEntity() && isUpdate())
                      }
                      onChange={(e) =>
                        dispatch(
                          setDispatchPostalCode(e.target.value.toString()),
                          CREATE_NEW_CONTACT.FIELD.POSTAL_CODE
                        )
                      }
                      value={dispatchPostalCode}
                    />
                  </ClayInput.GroupItem>
                </ClayInput.Group>
              </ClayForm.Group>
            </Row>

            <ClayForm.Group
              className={hasDispatchAddressWarn ? "has-warning" : ""}
            >
              {isDispatchAddressInCroatia() ? (
                <AutocompleteInput
                  label={CREATE_NEW_CONTACT.FIELD.STREET_ADDRESS}
                  id={"dispatch-street-address-autocomplete"}
                  active={isDispatchAddressInCroatia()}
                  getOptions={searchStreetsByCityIdAndName(
                    parseInt(dispatchCity)
                  )}
                  setParentValue={(value) =>
                    dispatch(
                      setDispatchStreet(value.toString()),
                      CREATE_NEW_CONTACT.FIELD.STREET_ADDRESS
                    )
                  }
                  isCity={false}
                  disabled={
                    !dispatchPostalCode || (isLegalEntity() && isUpdate())
                  }
                  {...registerRequiredDispatchAddress}
                />
              ) : (
                <>
                  <label htmlFor="street-dispatch-address-input">
                    {CREATE_NEW_CONTACT.FIELD.STREET_ADDRESS}
                  </label>

                  <ClayInput
                    id="street-dispatch-address-input"
                    type="text"
                    onChange={(e) =>
                      dispatch(
                        setDispatchStreet(e.target.value.toString()),
                        CREATE_NEW_CONTACT.FIELD.STREET_ADDRESS
                      )
                    }
                    value={dispatchStreet}
                    disabled={isLegalEntity() && isUpdate()}
                    {...registerRequiredDispatchAddress}
                  />
                </>
              )}
              {hasDispatchAddressWarn ? (
                <ClayForm.FeedbackGroup>
                  <ClayForm.FeedbackItem>
                    {dispatchAddressWarn}
                  </ClayForm.FeedbackItem>
                </ClayForm.FeedbackGroup>
              ) : null}
            </ClayForm.Group>

            <Row half>
              <ClayForm.Group
                className={hasDispatchHouseNumberWarn ? "has-warning" : ""}
              >
                <label className="required" htmlFor="dispatch-house-number">
                  {CREATE_NEW_CONTACT.FIELD.HOUSE_NUMBER}
                </label>
                <ClayInput
                  id="dispatch-house-number"
                  type="text"
                  onChange={(e) =>
                    dispatch(
                      setDispatchHouseNumber(e.target.value.toString()),
                      CREATE_NEW_CONTACT.FIELD.HOUSE_NUMBER
                    )
                  }
                  value={dispatchHouseNumber}
                  disabled={isLegalEntity() && isUpdate()}
                  {...registerRequiredDispatchHouseNumber}
                />
                {hasDispatchHouseNumberWarn ? (
                  <ClayForm.FeedbackGroup>
                    <ClayForm.FeedbackItem>
                      {dispatchHouseNumberWarn}
                    </ClayForm.FeedbackItem>
                  </ClayForm.FeedbackGroup>
                ) : null}
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
