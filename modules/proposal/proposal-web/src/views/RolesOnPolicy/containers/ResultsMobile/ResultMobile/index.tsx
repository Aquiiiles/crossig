import React from "react";
import { useHistory } from "react-router-dom";
import ClayButton from "@clayui/button";
import { ButtonGroup, InnerGrid, MainGrid, Wrapper } from "./styles";
import RolesItens from "../../RolesItens";
import ResultRowMobile from "../../../../../shared/atoms/ResultRowMobile";
import * as types from "../../../../../redux/contactsInPolicy/types";
import { CONTACT_SEARCH_TABLE_VIEW_DETAILS } from "../../../../../constants/languageKeys";
import * as constants from "../../../../../constants/RolesOnPolicy";
import { contactOperations } from "../../../../../constants/contactConstants";
import { ROUTES } from "../../../../../constants/routes";

interface Props {
  contact: types.contactInPolicy;
  policyHolder: boolean;
  addRole: (title: string) => void;
  removeRole: (title: string) => void;
}

const ResultMobile: React.FC<Props> = ({
  contact,
  policyHolder,
  addRole,
  removeRole,
}) => {
  const history = useHistory();
  const openUpdateContact = (extNumber: number) => {
    history.push({
      pathname: ROUTES.UPDATE_CONTACT,
      state: { extNumber, operation: contactOperations.updateReadOnly },
    });
  };

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
            name={constants.NAME_NAME}
            value={contact[constants.NAME_KEY]}
          />
        </InnerGrid>
        <div>
          <RolesItens
            policyHolder={policyHolder}
            roles={contact.contactRoles}
            addRole={addRole}
            removeRole={removeRole}
          />
        </div>
      </MainGrid>
      <ButtonGroup>
        <ClayButton
          displayType="secondary"
          className="ghost"
          onClick={() => openUpdateContact(contact[constants.EXT_NUMBER_KEY])}
        >
          {CONTACT_SEARCH_TABLE_VIEW_DETAILS}
        </ClayButton>
      </ButtonGroup>
    </Wrapper>
  );
};

export default ResultMobile;
