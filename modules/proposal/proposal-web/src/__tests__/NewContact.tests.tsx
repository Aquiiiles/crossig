import React from "react";
import { render, cleanup, screen, fireEvent } from "@testing-library/react";
import * as language from "../constants/languageKeys";
import NewContact from "../views/NewContact";
import { Provider as StoreProvider } from "react-redux";
import { ThemeProvider } from "styled-components";
import defaultTheme from "../constants/theme";
import store from "../redux/store";
import { act } from "react-dom/test-utils";

const App: React.FC = () => {
  return (
    <ThemeProvider theme={defaultTheme}>
      <StoreProvider store={store}>
        <NewContact />
      </StoreProvider>
    </ThemeProvider>
  );
};

const mockHistoryPush = jest.fn();
const mockHistoryReplace = jest.fn();

jest.mock("react-router-dom", () => ({
  ...jest.requireActual("react-router-dom"),
  useHistory: () => ({
    push: mockHistoryPush,
    replace: mockHistoryReplace,
  }),
}));

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

  it("Click cancel button", () => {
    act(() => screen.getByText(language.CONTACT_INFO.CANCEL).click());

    expect(mockHistoryReplace).toHaveBeenCalledWith({
      pathname: "/",
      state: { doSearch: true },
    });
  });

  it("Contact types in dropdown", () => {
    act(() => screen.getByText(language.CREATE_NEW_CONTACT.TYPE).click());

    expect(
      screen.getByText(
        language.CREATE_NEW_CONTACT.FIELD.CONTACT_TYPE.INDIVIDUAL
      )
    ).toBeVisible();
    expect(
      screen.getByText(
        language.CREATE_NEW_CONTACT.FIELD.CONTACT_TYPE.SELF_EMPLOYED
      )
    ).toBeVisible();
    expect(
      screen.getByText(
        language.CREATE_NEW_CONTACT.FIELD.CONTACT_TYPE.LEGAL_ENTITY
      )
    ).toBeVisible();
  });

  it("Individual type fields", () => {
    act(() => {
      screen.getByText(language.CREATE_NEW_CONTACT.TYPE).click();
      screen
        .getByText(language.CREATE_NEW_CONTACT.FIELD.CONTACT_TYPE.INDIVIDUAL)
        .click();
    });

    expect(
      screen.getByText(language.CREATE_NEW_CONTACT.FIELD.FIRST_NAME)
    ).toBeVisible();
    expect(
      screen.getByText(language.CREATE_NEW_CONTACT.FIELD.LAST_NAME)
    ).toBeVisible();
    expect(
      screen.getByText(language.CREATE_NEW_CONTACT.FIELD.BIRTH_DATE)
    ).toBeVisible();
    expect(
      screen.getByText(language.CREATE_NEW_CONTACT.FIELD.OIB)
    ).toBeVisible();
    expect(
      screen.getByText(language.CREATE_NEW_CONTACT.FIELD.FOREIGNER_STATUS)
    ).toBeChecked();
  });

  it("Self Employed type fields", () => {
    act(() => {
      screen.getByText(language.CREATE_NEW_CONTACT.TYPE).click();
      screen
        .getByText(language.CREATE_NEW_CONTACT.FIELD.CONTACT_TYPE.SELF_EMPLOYED)
        .click();
    });

    expect(
      screen.getByText(language.CREATE_NEW_CONTACT.FIELD.COMPANY_NAME)
    ).toBeVisible();
    expect(
      screen.getByText(language.CREATE_NEW_CONTACT.FIELD.LAST_NAME)
    ).toBeVisible();
    expect(
      screen.getByText(language.CREATE_NEW_CONTACT.FIELD.SUBSIDIARY_NUMBER)
    ).toBeDisabled();
    expect(
      screen.getByText(language.CREATE_NEW_CONTACT.FIELD.OIB)
    ).toBeVisible();
    expect(
      screen.getByText(language.CREATE_NEW_CONTACT.FIELD.FOREIGNER_STATUS)
    ).not.toBeChecked();
    expect(
      screen.getByText(language.CREATE_NEW_CONTACT.SUBMIT_BUTTON)
    ).toBeDisabled();
  });

  it("Legal type fields", () => {
    act(() => {
      screen.getByText(language.CREATE_NEW_CONTACT.TYPE).click();
      screen
        .getByText(language.CREATE_NEW_CONTACT.FIELD.CONTACT_TYPE.SELF_EMPLOYED)
        .click();
    });

    expect(
      screen.getByText(language.CREATE_NEW_CONTACT.FIELD.COMPANY_NAME)
    ).toBeVisible();
    expect(
      screen.getByText(language.CREATE_NEW_CONTACT.FIELD.LAST_NAME)
    ).toBeVisible();
    expect(
      screen.getByText(language.CREATE_NEW_CONTACT.FIELD.SUBSIDIARY_NUMBER)
    ).toBeDisabled();
    expect(
      screen.getByText(language.CREATE_NEW_CONTACT.FIELD.OIB)
    ).toBeVisible();
    expect(
      screen.getByText(language.CREATE_NEW_CONTACT.FIELD.FOREIGNER_STATUS)
    ).not.toBeChecked();
    expect(
      screen.getByText(language.CREATE_NEW_CONTACT.SUBMIT_BUTTON)
    ).toBeDisabled();
  });
});
