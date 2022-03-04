import React, { useEffect } from "react";
import { useHistory } from "react-router-dom";
import Stepper from "../../shared/molecules/Stepper";
import { Wrapper, Buttons, InnerWrapper, Content } from "./styles";
import BackBtn from "../../shared/atoms/BackBtn";
import ContinueBtn from "../../shared/atoms/ContinueBtn";
import Table from "./containers/Table";
import { ROLES_ON_POLICY } from "../../constants/languageKeys";
import { useContactDispatch, useContactSelector } from "../../redux/store";
import { actions } from "../../redux/contactsInPolicySlice";

const RolesOnPolicy: React.FC = () => {
  const dispatch = useContactDispatch();
  const { contactsInPolicy } = useContactSelector(
    (state) => state.contactsInPolicy
  );
  const { setRoleOptions } = actions;

  const history = useHistory();

  const hasInsuredRole =
    contactsInPolicy.filter((contact) =>
      contact.contactRoles.includes(ROLES_ON_POLICY.INSURED)
    ).length > 0;

  useEffect(() => {
    dispatch(setRoleOptions(["Insured", "Payer"]));
  }, []);

  return (
    <Wrapper>
      <Stepper currentStep={3} />

      <InnerWrapper>
        <Content>
          <h5>{ROLES_ON_POLICY.TITLE}</h5>
          <p className="body-small" style={{ marginBottom: "2.5rem" }}>
            {ROLES_ON_POLICY.SUBTITLE}
          </p>
          <Table hasInsuredRole={hasInsuredRole} />
        </Content>
        <Buttons>
          <BackBtn pathname="/product" state={{ doSearch: true }} />
          {!hasInsuredRole && (
            <span>{ROLES_ON_POLICY.INSURED_ROLE_MISSING}</span>
          )}
          <ContinueBtn
            disabled={!hasInsuredRole}
            onClick={() => {
              history.push("/coverage_plan");
            }}
          />
        </Buttons>
      </InnerWrapper>
    </Wrapper>
  );
};

export default RolesOnPolicy;
