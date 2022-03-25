import React from "react";
import "./App.css";
import { HashRouter as Router, Switch, Route } from "react-router-dom";
import { Provider as StoreProvider } from "react-redux";
import { ThemeProvider } from "styled-components";
import LiferayEventProvider from "./views/LiferayEventProvider";
import defaultTheme from "./constants/theme";
import store from "./redux/store";
import { ROUTES } from "./constants/routes";
import Premium from "./views/Premium";
import ContactSearch from "./views/ContactSearch";
import CoveragePlan from "./views/CoveragePlan";
import InsuranceProduct from "./views/InsuranceProduct";
import NewContact from "./views/NewContact";
import RolesOnPolicy from "./views/RolesOnPolicy";
import UpdateContact from "./views/UpdateContact";
import VesselSearch from "./views/VesselSearch";

type PropsType = {
  eventProvider?: boolean;
};

const Proposal = () => {
  return (
    <Router>
      <Switch>
        <Route path={ROUTES.PRODUCT}>
          <InsuranceProduct />
        </Route>
        <Route path={ROUTES.ROLES}>
          <RolesOnPolicy />
        </Route>
        <Route path={ROUTES.COVERAGE_PLAN}>
          <CoveragePlan />
        </Route>
        <Route path={ROUTES.VESSEL_SEARCH}>
          <VesselSearch />
        </Route>
        <Route path={ROUTES.UPDATE_CONTACT}>
          <UpdateContact />
        </Route>
        <Route path={ROUTES.NEW_CONTACT}>
          <NewContact />
        </Route>
        <Route path={ROUTES.PREMIUM}>
          <Premium />
        </Route>
        <Route path={ROUTES.CONTACT_SEARCH}>
          <ContactSearch embedded={false} />
        </Route>
      </Switch>
    </Router>
  );
};

const renderProposal = (eventProvider?: boolean) => {
  let app = <Proposal />;

  if (eventProvider && eventProvider) {
    app = (
      <LiferayEventProvider>
        <Proposal />
      </LiferayEventProvider>
    );
  }

  return app;
};

const App: React.FC<PropsType> = (props: PropsType) => {
  return (
    <ThemeProvider theme={defaultTheme}>
      <StoreProvider store={store}>
        {renderProposal(props.eventProvider)}
      </StoreProvider>
    </ThemeProvider>
  );
};

export default App;
