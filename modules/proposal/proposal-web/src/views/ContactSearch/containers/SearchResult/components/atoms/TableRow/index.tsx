import React from "react";
import ClayButton from "@clayui/button";
import ClayTable from "@clayui/table";
import { HoveringButtonGroup, StyledRow } from "./style";
import MissingInformationIcon from "../MissingInformationIcon";
import {
  CONTACT_SEARCH_TABLE_VIEW_DETAILS,
  CONTACT_SEARCH_TABLE_USE_CONTACT,
} from "../../../../../../../constants/languageKeys";
import AddToPolicyBtn from "../../molecules/AddToPolicyBtn";

import * as types from "../../../types/searchResult";
import * as constants from "../../../../../constants/searchResult";
import { contactOperations } from "../../../../../../../constants/contactConstants";
import useTableRowState from "../../../../../hooks/useTableRowState";

interface props {
  contact: types.responseType;
  embedded: boolean;
}

const TableRow: React.FC<props> = ({ contact, embedded }) => {
  const [
    { showButtons },
    { setShowButtons, formatDOB, openUpdateContact, selectContact },
    types,
  ] = useTableRowState(
    embedded ? contactOperations.updateEmbedded : contactOperations.update
  );

  return (
    <StyledRow
      style={{ position: "relative" }}
      onMouseLeave={() => setShowButtons(false)}
      onPointerLeave={() => setShowButtons(false)}
      onMouseEnter={() => setShowButtons(true)}
      onPointerEnter={() => setShowButtons(true)}
      onDoubleClick={() => (!embedded ? selectContact(contact) : null)}
    >
      <ClayTable.Cell headingTitle className="no-wrap">
        <MissingInformationIcon
          mailValidated={contact[constants.MAIL_VALIDATED_KEY]}
          phoneNumberValidated={contact[constants.PHONE_NUMBER_VALIDATED_KEY]}
        />
        {contact[constants.OIB_KEY]}
      </ClayTable.Cell>
      <ClayTable.Cell headingTitle>{contact[constants.SUB_KEY]}</ClayTable.Cell>
      <ClayTable.Cell headingTitle>
        {formatDOB(contact[constants.DOB_KEY])}
      </ClayTable.Cell>
      <ClayTable.Cell headingTitle>
        {contact[constants.NAME_KEY]}
      </ClayTable.Cell>
      <ClayTable.Cell headingTitle>
        {contact[constants.STREET_KEY]}
      </ClayTable.Cell>
      <ClayTable.Cell headingTitle>
        {contact[constants.CITY_KEY]}
      </ClayTable.Cell>
      {showButtons ? (
        <HoveringButtonGroup>
          <ClayButton
            displayType="secondary"
            className="ghost"
            onClick={() => openUpdateContact(contact[constants.EXT_NUMBER_KEY])}
          >
            {CONTACT_SEARCH_TABLE_VIEW_DETAILS}
          </ClayButton>
          {embedded ? (
            <AddToPolicyBtn contact={contact} isMobile={false} />
          ) : (
            <ClayButton
              displayType="primary"
              onClick={() => selectContact(contact)}
            >
              {CONTACT_SEARCH_TABLE_USE_CONTACT}
            </ClayButton>
          )}
        </HoveringButtonGroup>
      ) : (
        <ClayTable.Cell headingTitle>
          {types[contact[constants.TYPE_KEY] as keyof typeof types]}
        </ClayTable.Cell>
      )}
    </StyledRow>
  );
};

export default TableRow;
