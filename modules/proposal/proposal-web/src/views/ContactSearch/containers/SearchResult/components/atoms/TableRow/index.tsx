import React, { useState } from "react";
import ClayButton from "@clayui/button";
import ClayTable from "@clayui/table";
import { HoveringButtonGroup } from "./style";
import MissingInformationIcon from "../MissingInformationIcon";
import {
  CONTACT_SEARCH_TABLE_VIEW_DETAILS,
  CONTACT_SEARCH_TABLE_USE_CONTACT,
} from "../../../../../../../constants/languageKeys";

import * as types from "../../../types/searchResult";
import * as constants from "../../../constants/searchResult";
import { useFetchData } from "../../../../../../../api/hooks/useFetchData";
import { CONTACT_URL } from "../../../../../../../api/constants/routes";
import { useHistory } from "react-router-dom";

interface props {
  contact: types.responseType;
}

const TableRow: React.FC<props> = ({ contact }) => {
  const [showButtons, setShowButtons] = useState(false);
  const history = useHistory();

  const types = {
    Individual: "F",
    "Self Employed": "O",
    "Legal Entity": "P",
  };

  const formatDOB = (date: string): string => {
    try {
      const [year, month, day] = date.split("-");

      return `${day}/${month}/${year}`;
    } catch (error) {
      return "";
    }
  };

  const openUpdateContact = (oib: string) => {
    history.push({
      pathname: "/update_contact",
      state: oib,
    });
  };

  return (
    <ClayTable.Row
      style={{ position: "relative" }}
      onMouseLeave={() => setShowButtons(false)}
      onMouseEnter={() => setShowButtons(true)}
      onDoubleClick={() => history.push("/product")}
    >
      <ClayTable.Cell headingTitle>
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
            onClick={() => openUpdateContact(contact[constants.OIB_KEY])}
          >
            {CONTACT_SEARCH_TABLE_VIEW_DETAILS}
          </ClayButton>
          <ClayButton
            displayType="primary"
            onClick={() => history.push("/product")}
          >
            {CONTACT_SEARCH_TABLE_USE_CONTACT}
          </ClayButton>
        </HoveringButtonGroup>
      ) : (
        <ClayTable.Cell headingTitle>
          {types[contact[constants.TYPE_KEY] as keyof typeof types]}
        </ClayTable.Cell>
      )}
    </ClayTable.Row>
  );
};

export default TableRow;
