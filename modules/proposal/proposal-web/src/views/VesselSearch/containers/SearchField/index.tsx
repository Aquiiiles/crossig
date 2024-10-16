import React from "react";
import ClayForm, { ClayInput, ClaySelectWithOption } from "@clayui/form";
import ClayButton from "@clayui/button";
import { Wrapper } from "./style";
import { vesselTypeOptions } from "../../../../constants/vesselConstants";
import useSearchField from "./hooks/useSearchField";
import { handleEnterKeyEvent } from "../../../../shared/util/commonFunctions";
import languageKeys from "../../../../constants/Language";
import { ROUTES } from "../../../../constants/routes";

const { VESSEL_LOOKUP } = languageKeys;

interface props {
  onSearchClick: () => void;
}

const SearchField: React.FC<props> = ({ onSearchClick }) => {
  const [
    disabledSearch,
    {
      vesselType,
      vesselName,
      vesselNIB,
      vesselRegistrationMark,
      vesselFleetName,
    },
    {
      setVesselType,
      setVesselName,
      setVesselNIB,
      setVesselRegistrationMark,
      setVesselFleetName,
    },
    dispatch,
    history,
  ] = useSearchField();

  return (
    <Wrapper onKeyDown={(e) => handleEnterKeyEvent(e, onSearchClick)}>
      <ClayForm.Group style={{ marginBottom: "0" }}>
        <ClayInput.Group id="vesselLookupInputGroup">
          <ClayInput.GroupItem>
            <label className="body-small" htmlFor="vesselNib">
              {VESSEL_LOOKUP.FIELD.NIB}
            </label>
            <ClayInput
              id="vesselNib"
              type="text"
              value={vesselNIB}
              onChange={({ target: { value } }) =>
                dispatch(setVesselNIB(value))
              }
            />
          </ClayInput.GroupItem>
          <ClayInput.GroupItem className="registration-mark-search-field">
            <label className="body-small" htmlFor="vesselRegistrationMark">
              {VESSEL_LOOKUP.FIELD.REGISTRATION_MARK}
            </label>
            <ClayInput
              id="vesselRegistrationMark"
              type="text"
              value={vesselRegistrationMark}
              onChange={({ target: { value } }) =>
                dispatch(setVesselRegistrationMark(value))
              }
            />
          </ClayInput.GroupItem>
          <ClayInput.GroupItem>
            <label className="body-small" htmlFor="vesselType">
              {VESSEL_LOOKUP.FIELD.TYPE}
            </label>
            <ClaySelectWithOption
              id="vesselType"
              options={vesselTypeOptions}
              value={vesselType}
              onChange={({ target: { value } }) =>
                dispatch(setVesselType(value))
              }
            />
          </ClayInput.GroupItem>
          <ClayInput.GroupItem>
            <label className="body-small" htmlFor="vesselName">
              {VESSEL_LOOKUP.FIELD.NAME}
            </label>
            <ClayInput
              id="vesselName"
              type="text"
              value={vesselName}
              onChange={({ target: { value } }) =>
                dispatch(setVesselName(value))
              }
            />
          </ClayInput.GroupItem>
          <ClayInput.GroupItem>
            <label className="body-small" htmlFor="vesselFleetName">
              {VESSEL_LOOKUP.FIELD.FLEET_NAME}
            </label>
            <ClayInput
              id="vesselFleetName"
              type="text"
              value={vesselFleetName}
              onChange={({ target: { value } }) =>
                dispatch(setVesselFleetName(value))
              }
            />
          </ClayInput.GroupItem>
        </ClayInput.Group>
        <br />
        <ClayButton.Group spaced>
          <ClayButton disabled={disabledSearch} onClick={onSearchClick}>
            {VESSEL_LOOKUP.BUTTON_SEARCH_VESSEL}
          </ClayButton>
          <span id="vesselLookupCreateVesselButton">
            <ClayButton
              displayType="link"
              onClick={() => history.push(ROUTES.NEW_VESSEL)}
            >
              {VESSEL_LOOKUP.BUTTON_CREATE_NEW_VESSEL}
            </ClayButton>
          </span>
        </ClayButton.Group>
      </ClayForm.Group>
    </Wrapper>
  );
};

export default SearchField;
