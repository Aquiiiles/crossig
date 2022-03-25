import React from "react";
import "./App.css";
import { Provider as StoreProvider } from "react-redux";
import { ThemeProvider } from "styled-components";
import LiferayEventProvider from "./views/LiferayEventProvider";
import defaultTheme from "./constants/theme";
import store from "./redux/store";
import Proposal from "./views/Proposal";

type PropsType = {
  eventProvider?: boolean;
};

const renderProposal = (eventProvider?: boolean) => {
  let app = <Proposal />;

  if (eventProvider && eventProvider) {
    app = <LiferayEventProvider />;
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
