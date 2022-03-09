import React from "react";
import { ButtonGroup, InnerGrid, MainGrid, Wrapper } from "./styles";
import * as types from "../../../types/searchResult";
import * as constants from "../../../../../constants/searchResult";
import useTableRowState from "../../../../../hooks/useTableRowState";
import ClayButton from "@clayui/button";
import {
  CONTACT_SEARCH_TABLE_USE_CONTACT,
  CONTACT_SEARCH_TABLE_VIEW_DETAILS,
  ROLES_ON_POLICY,
} from "../../../../../../../constants/languageKeys";
import MissingInformationIcon from "../MissingInformationIcon";

interface Props {
  contact: types.responseType;
}

const ResultMobile: React.FC<Props> = ({ contact }) => {
  const [
    ,
    { formatDOB, openUpdateContact, addContact },
    types,
    history,
    dispatch,
  ] = useTableRowState();

  return (
    <Wrapper>
      <MainGrid>
        <InnerGrid>
          <h6 className="h10">{constants.OIB_NAME}</h6>
          <p className="body-small">{contact[constants.OIB_KEY]}</p>
          <h6 className="h10">{constants.SUB_NAME}</h6>
          <p className="body-small">{contact[constants.SUB_KEY]}</p>
          <h6 className="h10">{constants.DOB_NAME}</h6>
          <p className="body-small">{formatDOB(contact[constants.DOB_KEY])}</p>
          <h6 className="h10">{constants.NAME_NAME}</h6>
          <p className="body-small">{contact[constants.NAME_KEY]}</p>
        </InnerGrid>
        <InnerGrid>
          <h6 className="h10">{constants.STREET_NAME}</h6>
          <p className="body-small">{contact[constants.STREET_KEY]}</p>
          <h6 className="h10">{constants.CITY_NAME}</h6>
          <p className="body-small">{contact[constants.CITY_KEY]}</p>
          <h6 className="h10">{constants.TYPE_NAME}</h6>
          <p className="body-small">
            {types[contact[constants.TYPE_KEY] as keyof typeof types]}
          </p>
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
        <ClayButton
          displayType="primary"
          onClick={() => {
            dispatch(
              addContact({
                [constants.EXT_NUMBER_KEY]: contact[constants.EXT_NUMBER_KEY],
                [constants.OIB_KEY]: contact[constants.OIB_KEY],
                [constants.SUB_KEY]: contact[constants.SUB_KEY],
                [constants.NAME_KEY]: contact[constants.NAME_KEY],
                [constants.ROLES_KEY]: [ROLES_ON_POLICY.INSURED],
              })
            );
            history.push("/product");
          }}
        >
          {CONTACT_SEARCH_TABLE_USE_CONTACT}
        </ClayButton>
      </ButtonGroup>
      <MissingInformationIcon
        mailValidated={contact[constants.MAIL_VALIDATED_KEY]}
        phoneNumberValidated={contact[constants.PHONE_NUMBER_VALIDATED_KEY]}
      />
    </Wrapper>
  );
};

export default ResultMobile;
