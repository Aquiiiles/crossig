import React from "react";
import { render, cleanup, screen, fireEvent } from "@testing-library/react";
import Proposal from "../App";
import * as language from "../constants/languageKeys";

describe("Proposal Module", () => {
  afterEach(cleanup);

  it("Should render the Proposal web", () => {
    render(<Proposal />);
    expect(screen.getByText(language.CONTACT_SEARCH_TITLE)).toBeVisible();
    expect(screen.getByText(language.CONTACT_SEARCH_SUBTITLE)).toBeVisible();
  });

  it("Search button should be disabled", () => {
    render(<Proposal />);
    expect(
      screen.queryByText(language.CONTACT_SEARCH_ACTION_BUTTON)
    ).toBeDisabled();
  });

  it("After typing at least 3 letters on OIB field, search button should be enabled", () => {
    render(<Proposal />);
    expect(
      screen.queryByText(language.CONTACT_SEARCH_ACTION_BUTTON)
    ).toBeDisabled();
    const inputField = screen.getByLabelText(language.CONTACT_SEARCH_FIELD_OIB);
    fireEvent.change(inputField, { target: { value: "123" } });
    expect(
      screen.queryByText(language.CONTACT_SEARCH_ACTION_BUTTON)
    ).not.toBeDisabled();
    fireEvent.change(inputField, { target: { value: "" } });
  });

  it("After typing at least 3 letters on Name field, search button should be enabled", () => {
    render(<Proposal />);
    expect(
      screen.queryByText(language.CONTACT_SEARCH_ACTION_BUTTON)
    ).toBeDisabled();
    const inputField = screen.getByLabelText(
      language.CONTACT_SEARCH_FIELD_FIRST_NAME
    );
    fireEvent.change(inputField, { target: { value: "abc" } });
    expect(
      screen.queryByText(language.CONTACT_SEARCH_ACTION_BUTTON)
    ).not.toBeDisabled();
    fireEvent.change(inputField, { target: { value: "" } });
  });

  it("After typing at least 3 letters on LastName field, search button should be enabled", () => {
    render(<Proposal />);
    expect(
      screen.queryByText(language.CONTACT_SEARCH_ACTION_BUTTON)
    ).toBeDisabled();
    const inputField = screen.getByLabelText(
      language.CONTACT_SEARCH_FIELD_LAST_NAME
    );
    fireEvent.change(inputField, { target: { value: "abc" } });
    expect(
      screen.queryByText(language.CONTACT_SEARCH_ACTION_BUTTON)
    ).not.toBeDisabled();
    fireEvent.change(inputField, { target: { value: "" } });
  });
});
