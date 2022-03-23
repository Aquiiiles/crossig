import React from "react";
import { render, cleanup, screen, fireEvent } from "@testing-library/react";
import Proposal from "../App";
import languageKeys from "../constants/Language";

describe("Proposal Module", () => {
  afterEach(cleanup);

  it("Should render the Proposal web", () => {
    render(<Proposal />);
    expect(screen.getByText(languageKeys.CONTACT_SEARCH.TITLE)).toBeVisible();
    expect(
      screen.getByText(languageKeys.CONTACT_SEARCH.SUBTITLE)
    ).toBeVisible();
  });

  it("Search button should be disabled", () => {
    render(<Proposal />);
    expect(
      screen.queryByText(languageKeys.CONTACT_SEARCH.ACTION_BUTTON)
    ).toBeDisabled();
  });

  it("After typing at least 3 letters on OIB field, search button should be enabled", () => {
    render(<Proposal />);
    expect(
      screen.queryByText(languageKeys.CONTACT_SEARCH.ACTION_BUTTON)
    ).toBeDisabled();
    const inputField = screen.getByLabelText(
      languageKeys.CONTACT_SEARCH.FIELD.OIB
    );
    fireEvent.change(inputField, { target: { value: "123" } });
    expect(
      screen.queryByText(languageKeys.CONTACT_SEARCH.ACTION_BUTTON)
    ).not.toBeDisabled();
    fireEvent.change(inputField, { target: { value: "" } });
  });

  it("After typing at least 3 letters on Name field, search button should be enabled", () => {
    render(<Proposal />);
    expect(
      screen.queryByText(languageKeys.CONTACT_SEARCH.ACTION_BUTTON)
    ).toBeDisabled();
    const inputField = screen.getByLabelText(
      languageKeys.CONTACT_SEARCH.FIELD.FIRST_NAME
    );
    fireEvent.change(inputField, { target: { value: "abc" } });
    expect(
      screen.queryByText(languageKeys.CONTACT_SEARCH.ACTION_BUTTON)
    ).not.toBeDisabled();
    fireEvent.change(inputField, { target: { value: "" } });
  });

  it("After typing at least 3 letters on LastName field, search button should be enabled", () => {
    render(<Proposal />);
    expect(
      screen.queryByText(languageKeys.CONTACT_SEARCH.ACTION_BUTTON)
    ).toBeDisabled();
    const inputField = screen.getByLabelText(
      languageKeys.CONTACT_SEARCH.FIELD.LAST_NAME
    );
    fireEvent.change(inputField, { target: { value: "abc" } });
    expect(
      screen.queryByText(languageKeys.CONTACT_SEARCH.ACTION_BUTTON)
    ).not.toBeDisabled();
    fireEvent.change(inputField, { target: { value: "" } });
  });
});
