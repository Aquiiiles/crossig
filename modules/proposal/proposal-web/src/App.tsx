import React from "react";
import "./App.css";
import NewContact from "./views/NewContact";
import ContactSearch from "./views/ContactSearch";
import UpdateContact from "./views/UpdateContact";
import InsuranceProduct from "./views/InsuranceProduct";
import { HashRouter as Router, Switch, Route } from "react-router-dom";

const App: React.FC = () => {
  return (
    <Router>
      <Switch>
        <Route path="/product">
          <InsuranceProduct />
        </Route>
        <Route path="/new_contact">
          <NewContact />
        </Route>
        <Route path="/update_contact">
          <UpdateContact />
        </Route>
        <Route path="/">
          <ContactSearch />
        </Route>
      </Switch>
    </Router>
  );
};

export default App;
