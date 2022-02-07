import React from "react";
import "./App.css";
import NewContact from "./views/NewContact";
import ContactSearch from './views/ContactSearch';
import ContactInfo from './views/ContactInfoForm';
import { HashRouter as Router, Switch, Route } from "react-router-dom";

const App: React.FC = () => {
  return (
    <Router>
      <Switch>
        <Route path="/new_contact">
          <NewContact />
        </Route>
        <Route path="/contact_info">
          <ContactInfo />
        </Route>
        <Route path="/">
          <ContactSearch />
        </Route>
      </Switch>
    </Router>
  );
};

export default App;
