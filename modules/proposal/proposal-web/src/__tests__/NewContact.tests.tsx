import React from "react";
import { render, cleanup, screen, fireEvent } from "@testing-library/react";
import { act } from "react-dom/test-utils";
import { Provider as StoreProvider } from "react-redux";
import { ThemeProvider } from "styled-components";
import { store as reduxStore } from "../redux/store";
import * as language from "../constants/languageKeys";
import defaultTheme from "../constants/theme";
import NewContact from "../views/NewContact";

const App: React.FC = () => {
  return (
    <ThemeProvider theme={defaultTheme}>
      <StoreProvider store={reduxStore}>
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

const selectIndividualType = () => {
  act(() => {
    fireEvent.change(screen.getByLabelText(language.CREATE_NEW_CONTACT.TYPE), {
      target: { value: 1 },
    });
  });
};

const selectSelfType = () => {
  act(() => {
    fireEvent.change(screen.getByLabelText(language.CREATE_NEW_CONTACT.TYPE), {
      target: { value: 2 },
    });
  });
};

const selectLegalType = () => {
  act(() => {
    fireEvent.change(screen.getByLabelText(language.CREATE_NEW_CONTACT.TYPE), {
      target: { value: 3 },
    });
  });
};

describe("New Contact page", () => {
  beforeEach(() => {
    act(() => {
      render(<App />);
    });
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
    const oibInput = screen.getByLabelText(
      language.CREATE_NEW_CONTACT.FIELD.OIB
    );

    act(() => {
      fireEvent.change(oibInput, {
        target: { value: "oib" },
      });
      screen.getByText(language.CONTACT_INFO.CANCEL).click();
    });

    expect(oibInput).toHaveValue("");
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

  it("Individual type basic info fields", () => {
    selectIndividualType();

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
      screen.getByLabelText(language.CREATE_NEW_CONTACT.FIELD.FOREIGNER_STATUS)
    ).not.toBeChecked();
  });

  it("Self Employed type basic info fields", () => {
    selectSelfType();

    expect(
      screen.getByText(language.CREATE_NEW_CONTACT.FIELD.COMPANY_NAME)
    ).toBeVisible();
    expect(
      screen.getByText(language.CREATE_NEW_CONTACT.FIELD.SUBSIDIARY_NUMBER)
    ).toBeVisible();
    expect(
      screen.getByText(language.CREATE_NEW_CONTACT.FIELD.OIB)
    ).toBeVisible();
    expect(
      screen.getByLabelText(language.CREATE_NEW_CONTACT.FIELD.FOREIGNER_STATUS)
    ).not.toBeChecked();
  });

  it("Legal type basic info fields", () => {
    selectLegalType();

    expect(
      screen.getByText(language.CREATE_NEW_CONTACT.FIELD.COMPANY_NAME)
    ).toBeVisible();
    expect(
      screen.getByText(language.CREATE_NEW_CONTACT.FIELD.SUBSIDIARY_NUMBER)
    ).toBeVisible();
    expect(
      screen.getByText(language.CREATE_NEW_CONTACT.FIELD.OIB)
    ).toBeVisible();
    expect(
      screen.getByLabelText(language.CREATE_NEW_CONTACT.FIELD.FOREIGNER_STATUS)
    ).not.toBeChecked();
  });

  it("Address fields", () => {
    expect(
      screen.getByText(language.CREATE_NEW_CONTACT.ADDRESS_TITLE)
    ).toBeVisible();
    expect(
      screen.getByText(language.CREATE_NEW_CONTACT.ID_ADDRESS)
    ).toBeVisible();
    expect(
      screen.getAllByText(language.CREATE_NEW_CONTACT.FIELD.COUNTRY).length
    ).toBe(1);
    expect(
      screen.getAllByText(language.CREATE_NEW_CONTACT.FIELD.CITY).length
    ).toBe(1);
    expect(
      screen.getAllByText(language.CREATE_NEW_CONTACT.FIELD.POSTAL_CODE).length
    ).toBe(1);
    expect(
      screen.getAllByText(language.CREATE_NEW_CONTACT.FIELD.STREET_ADDRESS)
        .length
    ).toBe(1);
    expect(
      screen.getAllByText(language.CREATE_NEW_CONTACT.FIELD.HOUSE_NUMBER).length
    ).toBe(1);
    expect(
      screen.getByLabelText(language.CREATE_NEW_CONTACT.FIELD.DISPATCH_ADDRESS)
    ).toBeChecked();
  });

  it("Address fields for Self Employed", () => {
    selectSelfType();

    expect(
      screen.getByText(language.CREATE_NEW_CONTACT.REGISTERED_OFFICE_ADDRESS)
    ).toBeVisible();
    expect(
      screen.getAllByText(language.CREATE_NEW_CONTACT.FIELD.COUNTRY).length
    ).toBe(1);
    expect(
      screen.getAllByText(language.CREATE_NEW_CONTACT.FIELD.CITY).length
    ).toBe(1);
    expect(
      screen.getAllByText(language.CREATE_NEW_CONTACT.FIELD.POSTAL_CODE).length
    ).toBe(1);
    expect(
      screen.getAllByText(language.CREATE_NEW_CONTACT.FIELD.STREET_ADDRESS)
        .length
    ).toBe(1);
    expect(
      screen.getAllByText(language.CREATE_NEW_CONTACT.FIELD.HOUSE_NUMBER).length
    ).toBe(1);
    expect(
      screen.getByLabelText(language.CREATE_NEW_CONTACT.FIELD.DISPATCH_ADDRESS)
    ).toBeChecked();
  });

  it("Address fields for Self Employed", () => {
    selectLegalType();

    expect(
      screen.getByText(language.CREATE_NEW_CONTACT.REGISTERED_OFFICE_ADDRESS)
    ).toBeVisible();
    expect(
      screen.getAllByText(language.CREATE_NEW_CONTACT.FIELD.COUNTRY).length
    ).toBe(1);
    expect(
      screen.getAllByText(language.CREATE_NEW_CONTACT.FIELD.CITY).length
    ).toBe(1);
    expect(
      screen.getAllByText(language.CREATE_NEW_CONTACT.FIELD.POSTAL_CODE).length
    ).toBe(1);
    expect(
      screen.getAllByText(language.CREATE_NEW_CONTACT.FIELD.STREET_ADDRESS)
        .length
    ).toBe(1);
    expect(
      screen.getAllByText(language.CREATE_NEW_CONTACT.FIELD.HOUSE_NUMBER).length
    ).toBe(1);
    expect(
      screen.getByLabelText(language.CREATE_NEW_CONTACT.FIELD.DISPATCH_ADDRESS)
    ).toBeChecked();
  });

  it("Address test dispatch address", () => {
    const dispatchAddress = screen.getByLabelText(
      language.CREATE_NEW_CONTACT.FIELD.DISPATCH_ADDRESS
    );

    act(() => {
      fireEvent.click(dispatchAddress);
    });

    expect(
      screen.getAllByText(language.CREATE_NEW_CONTACT.FIELD.COUNTRY).length
    ).toBe(2);
    expect(
      screen.getAllByText(language.CREATE_NEW_CONTACT.FIELD.CITY).length
    ).toBe(2);
    expect(
      screen.getAllByText(language.CREATE_NEW_CONTACT.FIELD.POSTAL_CODE).length
    ).toBe(2);
    expect(
      screen.getAllByText(language.CREATE_NEW_CONTACT.FIELD.STREET_ADDRESS)
        .length
    ).toBe(2);
    expect(
      screen.getAllByText(language.CREATE_NEW_CONTACT.FIELD.HOUSE_NUMBER).length
    ).toBe(2);
    expect(dispatchAddress).not.toBeChecked();
  });

  it("Create Contact button", () => {
    expect(
      screen.getByText(language.CONTACT_INFO.CREATE_CONTACT)
    ).toBeDisabled();
  });
});
