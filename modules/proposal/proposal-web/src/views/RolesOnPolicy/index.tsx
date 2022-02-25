import React, { useState } from "react";
import Stepper from "../ContactSearch/containers/Stepper";
import { Wrapper } from "./styles";
import BackBtn from "../../shared/atoms/BackBtn";
import ContinueBtn from "../../shared/atoms/ContinueBtn";
import Table from "./containers/Table"
import { ROLES_ON_POLICY } from "../../constants/languageKeys";

const RolesOnPolicy: React.FC = () => {
  const [hasInsuredRole, setHasInsuredRole] = useState(true);

  return (
    <Wrapper>
      <Stepper />
      <h5>{ROLES_ON_POLICY.TITLE}</h5>;
      <p className="body-small" style={{ marginBottom: "2.5rem" }}>
        {ROLES_ON_POLICY.SUBTITLE}
      </p>
      <Table />
      <BackBtn pathname="/product" state={{ doSearch: true }} />
      <ContinueBtn
        disabled={hasInsuredRole}
        onClick={() => {
          return;
        }}
      />
      {!hasInsuredRole && <p>{ROLES_ON_POLICY.INSURED_ROLE_MISSING}</p>}
    </Wrapper>
  );
};

export default RolesOnPolicy;
