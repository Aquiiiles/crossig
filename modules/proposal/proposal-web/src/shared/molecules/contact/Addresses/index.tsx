import React, { useEffect, useState } from "react";
import AutocompleteInput from "../../../atoms/contact/AutocompleteInput";
import SectionSubTitle from "../../../atoms/contact/SectionSubTitle";
import FormSection from "../../../atoms/contact/FormSection";
import Row from "../../../atoms/contact/Row";
import ClayForm, {
  ClayInput,
  ClayCheckbox,
  ClaySelectWithOption,
} from "@clayui/form";
import {
  contactOperations,
  contactTypes,
} from "../../../../constants/contactConstants";
import { countryNames } from "../../../../constants/defaultCountryConfiguration";
import { CREATE_NEW_CONTACT } from "../../../../constants/languageKeys";
import { useDispatch, useSelector } from "../../../../redux/store";
import { actions } from "../../../../redux";
import { Line } from "./styles";
import { searchCitiesByName, searchStreetsByCityIdAndName } from "./controller";
import useRequiredField from "../../../hooks/useRequiredField";

type propsType = {
  enableSave?: () => void;
  countries: { label: any; value: any }[];
  operation: number;
  setUpdatedValues?: (value: string) => void;
};

const Addresses: React.FC<propsType> = ({
  countries,
  enableSave,
  operation,
  setUpdatedValues,
}: propsType) => {
  const [disableFields, setDisableFields] = useState(false);
  const dispatcher = useDispatch();
  const dispatch = (action: any, updatedValue: string) => {
    enableSave && enableSave();
    dispatcher(action);
    setUpdatedValues && setUpdatedValues(updatedValue);
  };

  const { contactType } = useSelector(
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
  } = useSelector((state) => state.addresses);
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
  } = actions.addresses;

  const isMainAddressInCroatia = () => {
    return country === countryNames.value || country === countryNames.label;
  };

  const isDispatchAddressInCroatia = () => {
    return (
      dispatchCountry === countryNames.value ||
      dispatchCountry === countryNames.label
    );
  };

  useEffect(() => {
    setDisableFields(
      (contactType === contactTypes.Legal_Entity &&
        operation !== contactOperations.create) ||
        operation === contactOperations.updateReadOnly
    );
  }, [contactType]);

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
              disabled={disableFields}
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
                  disabled={disableFields}
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
                  disabled={isMainAddressInCroatia() || disableFields}
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
              disabled={!postalCode || disableFields}
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
                disabled={disableFields}
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
              disabled={disableFields}
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
          disabled={disableFields}
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
                  disabled={disableFields}
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
                      disabled={disableFields}
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
                      disabled={isDispatchAddressInCroatia() || disableFields}
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
                  disabled={!dispatchPostalCode || disableFields}
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
                    disabled={disableFields}
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
                  disabled={disableFields}
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
