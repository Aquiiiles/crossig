import React from "react";
import { ButtonGroup, InnerGrid, MainGrid, Wrapper } from "./styles";
import * as types from "../../../types/searchResult";
import * as constants from "../../../../../constants/searchResult";
import useTableRowState from "../../../../../hooks/useTableRowState";
import ClayButton from "@clayui/button";
import {
  CONTACT_SEARCH_TABLE_USE_CONTACT,
  CONTACT_SEARCH_TABLE_VIEW_DETAILS,
} from "../../../../../../../constants/languageKeys";
import { contactOperations } from "../../../../../../../constants/contactConstants";
import MissingInformationIcon from "../MissingInformationIcon";
import AddToPolicyBtn from "../../molecules/AddToPolicyBtn";
import ResultRowMobile from "../../../../../../../shared/atoms/ResultRowMobile";

interface Props {
  contact: types.responseType;
  embedded: boolean;
}

const ResultMobile: React.FC<Props> = ({ contact, embedded }) => {
  const [, { formatDOB, openUpdateContact, selectContact }, types] =
    useTableRowState(
      embedded ? contactOperations.updateEmbedded : contactOperations.update
    );

  return (
    <Wrapper>
      <MainGrid>
        <InnerGrid>
          <ResultRowMobile
            name={constants.OIB_NAME}
            value={contact[constants.OIB_KEY]}
          />
          <ResultRowMobile
            name={constants.SUB_NAME}
            value={contact[constants.SUB_KEY]}
          />
          <ResultRowMobile
            name={constants.DOB_NAME}
            value={formatDOB(contact[constants.DOB_KEY])}
          />
          <ResultRowMobile
            name={constants.NAME_NAME}
            value={contact[constants.NAME_KEY]}
          />
        </InnerGrid>
        <InnerGrid>
          <ResultRowMobile
            name={constants.STREET_NAME}
            value={contact[constants.STREET_KEY]}
          />
          <ResultRowMobile
            name={constants.CITY_NAME}
            value={contact[constants.CITY_KEY]}
          />
          <ResultRowMobile
            name={constants.TYPE_NAME}
            value={types[contact[constants.TYPE_KEY] as keyof typeof types]}
          />
        </InnerGrid>
      </MainGrid>
      <ButtonGroup>
        <ClayButton
          displayType="secondary"
          className="ghost"
          onClick={() => openUpdateContact(contact[constants.EXT_NUMBER_KEY])}
        >
          {CONTACT_SEARCH_TABLE_VIEW_DETAILS}
        </ClayButton>
        {embedded ? (
          <AddToPolicyBtn contact={contact} isMobile />
        ) : (
          <ClayButton
            displayType="primary"
            onClick={() => selectContact(contact)}
          >
            {CONTACT_SEARCH_TABLE_USE_CONTACT}
          </ClayButton>
        )}
      </ButtonGroup>
      <MissingInformationIcon
        mailValidated={contact[constants.MAIL_VALIDATED_KEY]}
        phoneNumberValidated={contact[constants.PHONE_NUMBER_VALIDATED_KEY]}
      />
    </Wrapper>
  );
};

export default ResultMobile;
