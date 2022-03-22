import React from "react";
import { render, cleanup, screen, fireEvent } from "@testing-library/react";
import * as language from "../constants/languageKeys";
import NewContact from "../views/NewContact";
import { Provider as StoreProvider } from "react-redux";
import { ThemeProvider } from "styled-components";
import defaultTheme from "../constants/theme";
import store from "../redux/store";

const App: React.FC = () => {
  return (
    <ThemeProvider theme={defaultTheme}>
      <StoreProvider store={store}>
        <NewContact />
      </StoreProvider>
    </ThemeProvider>
  );
};

describe("New Contact page", () => {
  beforeEach(() => {
    render(<App />);
  });
  afterEach(cleanup);

  it("Should render the New Contact page", () => {
    expect(screen.getByText(language.CREATE_NEW_CONTACT.TITLE)).toBeVisible();
    expect(
      screen.getByText(language.CREATE_NEW_CONTACT.SUBTITLE)
    ).toBeVisible();
  });

  it("Cancel button should be active", () => {
    expect(screen.getByText(language.CONTACT_INFO.CANCEL)).not.toBeDisabled();
  });
});
