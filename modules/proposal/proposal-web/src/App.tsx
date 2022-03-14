import React from "react";
import "./App.css";
import NewContact from "./views/NewContact";
import ContactSearch from "./views/ContactSearch";
import UpdateContact from "./views/UpdateContact";
import InsuranceProduct from "./views/InsuranceProduct";
import RolesOnPolicy from "./views/RolesOnPolicy";
import CoveragePlan from "./views/CoveragePlan";
import VesselSearch from "./views/VesselSearch";
import { HashRouter as Router, Switch, Route } from "react-router-dom";
import { Provider } from "react-redux";
import { ThemeProvider } from "styled-components";
import defaultTheme from "./constants/theme";
import store from "./redux/store";

const App: React.FC = () => {
  return (
    <ThemeProvider theme={defaultTheme}>
      <Provider store={store}>
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
            <Route path="/">
              <ContactSearch embedded={false} />
            </Route>
          </Switch>
        </Router>
      </Provider>
    </ThemeProvider>
  );
};

export default App;
