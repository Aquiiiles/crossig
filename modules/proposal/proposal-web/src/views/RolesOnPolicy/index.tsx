import React, { useEffect, useRef } from "react";
import { useHistory } from "react-router-dom";
import { Wrapper, Buttons, InnerWrapper, Content } from "./styles";
import Stepper from "../../shared/molecules/Stepper";
import BackBtn from "../../shared/atoms/BackBtn";
import ContinueBtn from "../../shared/atoms/ContinueBtn";
import Table from "./containers/Table";
import ResultsMobile from "./containers/ResultsMobile";
import { ROLES_ON_POLICY } from "../../constants/languageKeys";
import { useDispatch, useSelector } from "../../redux/store";
import { actions } from "../../redux";
import ContactSearch from "../ContactSearch";
import { handleEnterKeyEvent } from "../../shared/util/commonFunctions";

const RolesOnPolicy: React.FC = () => {
  const dispatch = useDispatch();
  const { policyHolder, contactsInPolicy, showMobileSearch } = useSelector(
    (state) => state.contactsInPolicy
  );
  const { setRoleOptions } = actions.contactsInPolicy;
  const { clearSearchValues } = actions.searchFilter;
  const wrapperRef = useRef<HTMLDivElement>(null);

  const history = useHistory();

  const hasInsuredRole =
    contactsInPolicy.filter((contact) =>
      contact.contactRoles.includes(ROLES_ON_POLICY.INSURED)
    ).length > 0 || policyHolder.contactRoles.includes(ROLES_ON_POLICY.INSURED);

  useEffect(() => {
    dispatch(setRoleOptions(["Insured", "Payer"]));
    dispatch(clearSearchValues());
  }, []);

  const continueToCoveragePlan = () => {
    window.scrollTo(0, 0);
    history.push("/coverage_plan");
  };

  useEffect(() => {
    if (wrapperRef.current) {
      wrapperRef.current.focus();
    }
  }, []);

  return (
    <>
      {showMobileSearch ? (
        <ContactSearch embedded={true} />
      ) : (
        <Wrapper
          tabIndex={1}
          ref={wrapperRef}
          onKeyDown={(e) => handleEnterKeyEvent(e, continueToCoveragePlan)}
        >
          <Stepper currentStep={3} />

          <InnerWrapper>
            <Content>
              <h5>{ROLES_ON_POLICY.TITLE}</h5>
              <p className="body-small subtitle">{ROLES_ON_POLICY.SUBTITLE}</p>
              <ResultsMobile />
              <Table hasInsuredRole={hasInsuredRole} />
            </Content>
            <Buttons>
              <BackBtn pathname="/product" state={{ doSearch: true }} />
              {!hasInsuredRole && (
                <span className="msg">
                  {ROLES_ON_POLICY.INSURED_ROLE_MISSING}
                </span>
              )}
              <ContinueBtn
                disabled={!hasInsuredRole}
                onClick={() => continueToCoveragePlan()}
              />
            </Buttons>
          </InnerWrapper>
        </Wrapper>
      )}
    </>
  );
};

export default RolesOnPolicy;
