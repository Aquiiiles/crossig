import React, { useEffect } from "react";
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

type PropsType = {
  proposalState?: ProposalResponse | null;
};

const Proposal: React.FC<PropsType> = (props: PropsType) => {
  return (
    <Router>
      <Switch>
        <Route path="/coverage_plan">
          <CoveragePlan />
        </Route>
        <Route path="/product">
          <InsuranceProduct />
        </Route>
        <Route path="/roles">
          <RolesOnPolicy />
        </Route>
        <Route path="/new_contact">
          <NewContact />
        </Route>
        <Route path="/update_contact">
          <UpdateContact />
        </Route>
        <Route path="/vessel_search">
          <VesselSearch />
        </Route>
        <Route path="/premium">
          <Premium />
        </Route>
        <Route path="/">
          <ContactSearch proposalState={props.proposalState} embedded={false} />
        </Route>
      </Switch>
    </Router>
  );
};

export default Proposal;
