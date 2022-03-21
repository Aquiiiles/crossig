import React from "react";
import ClayButton from "@clayui/button";
import ClayTable from "@clayui/table";
import { CollapsableCell, StyledRow } from "./style";
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
  const operations = embedded
    ? contactOperations.updateEmbedded
    : contactOperations.update;

  const [{ formatDOB, openUpdateContact, selectContact }, types] =
    useTableRowState(operations);

  const handleContactActionButton = (embedded: boolean) => {
    let button = (
      <ClayButton
        displayType="primary"
        className="hovering-button"
        onClick={() => selectContact(contact)}
      >
        {CONTACT_SEARCH_TABLE_USE_CONTACT}
      </ClayButton>
    );

    if (embedded) {
      button = <AddToPolicyBtn isMobile={false} contact={contact} />;
    }

    return button;
  };

  return (
    <StyledRow
      style={{ position: "relative" }}
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
      <CollapsableCell headingTitle>
        <p className="collapsable-cell">{contact[constants.CITY_KEY]}</p>
        <ClayButton
          displayType="secondary"
          className="ghost hovering-button align-button-right"
          onClick={() => openUpdateContact(contact[constants.EXT_NUMBER_KEY])}
        >
          {CONTACT_SEARCH_TABLE_VIEW_DETAILS}
        </ClayButton>
      </CollapsableCell>
      <CollapsableCell headingTitle>
        <p className="collapsable-cell">
          {types[contact[constants.TYPE_KEY] as keyof typeof types]}
        </p>
        {handleContactActionButton(embedded)}
      </CollapsableCell>
    </StyledRow>
  );
};

export default TableRow;
