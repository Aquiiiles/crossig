import React from "react";
import "./App.css";
import NewContact from "./views/NewContact";
import ContactSearch from "./views/ContactSearch";
import UpdateContact from "./views/UpdateContact";
import InsuranceProduct from "./views/InsuranceProduct";
import RolesOnPolicy from "./views/RolesOnPolicy";
import CoveragePlan from "./views/CoveragePlan";
import VesselSearch from "./views/VesselSearch";
import VesselLookup from "./views/VesselLookup";
import { HashRouter as Router, Switch, Route } from "react-router-dom";

const App: React.FC = () => {
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
        <Route path="/vessel_lookup">
          <VesselLookup />
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
        <Route path="/">
          <ContactSearch embedded={false} />
        </Route>
      </Switch>
    </Router>
  );
};

export default App;
