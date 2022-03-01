import React from "react";
import Stepper from "../ContactSearch/containers/Stepper";
import { Wrapper, Buttons } from "./styles";
import BackBtn from "../../shared/atoms/BackBtn";
import ContinueBtn from "../../shared/atoms/ContinueBtn";
import Table from "./containers/Table";
import { ROLES_ON_POLICY } from "../../constants/languageKeys";
import { useContactSelector } from "../../redux/store";

const RolesOnPolicy: React.FC = () => {
  const { contactsInPolicy } = useContactSelector(
    (state) => state.contactsInPolicy
  );
  const hasInsuredRole =
    contactsInPolicy.filter((contact) =>
      contact.contactRoles.includes("Insured")
    ).length > 0;

  return (
    <Wrapper>
      <Stepper />
      <h5>{ROLES_ON_POLICY.TITLE}</h5>
      <p className="body-small" style={{ marginBottom: "2.5rem" }}>
        {ROLES_ON_POLICY.SUBTITLE}
      </p>
      <Table hasInsuredRole={hasInsuredRole} />
      <Buttons>
        <BackBtn pathname="/product" state={{ doSearch: true }} />
        {!hasInsuredRole && <span>{ROLES_ON_POLICY.INSURED_ROLE_MISSING}</span>}
        <ContinueBtn
          disabled={!hasInsuredRole}
          onClick={() => {
            return;
          }}
        />
      </Buttons>
    </Wrapper>
  );
};

export default RolesOnPolicy;
