import React from "react";
import NewContact from "../NewContact";
import ContactSearch from "../ContactSearch";
import UpdateContact from "../UpdateContact";
import InsuranceProduct from "../InsuranceProduct";
import RolesOnPolicy from "../RolesOnPolicy";
import CoveragePlan from "../CoveragePlan";
import VesselSearch from "../VesselSearch";
import { HashRouter as Router, Switch, Route } from "react-router-dom";
import Premium from "../Premium";
import { ProposalResponse } from "../../shared/types/common";
import { ROUTES } from "../../constants/routes";

type PropsType = {
  proposalState?: ProposalResponse | null;
};

const Proposal: React.FC<PropsType> = (props: PropsType) => {
  const initialView = props.proposalState ? (
    <Premium proposalState={props.proposalState} />
  ) : (
    <ContactSearch embedded={false} />
  );

  return (
    <Router>
      <Switch>
        <Route path={ROUTES.COVERAGE_PLAN}>
          <CoveragePlan />
        </Route>
        <Route path={ROUTES.PRODUCT}>
          <InsuranceProduct />
        </Route>
        <Route path={ROUTES.ROLES}>
          <RolesOnPolicy />
        </Route>
        <Route path={ROUTES.NEW_CONTACT}>
          <NewContact />
        </Route>
        <Route path={ROUTES.UPDATE_CONTACT}>
          <UpdateContact />
        </Route>
        <Route path={ROUTES.VESSEL_SEARCH}>
          <VesselSearch />
        </Route>
        <Route path={ROUTES.PREMIUM}>
          <Premium />
        </Route>
        <Route path={ROUTES.CONTACT_SEARCH}>{initialView}</Route>
      </Switch>
    </Router>
  );
};

export default Proposal;
