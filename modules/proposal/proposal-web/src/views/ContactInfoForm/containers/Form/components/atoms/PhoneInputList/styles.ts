import styled from "styled-components";
import ClayForm from "@clayui/form";

export const StyledFormGroup = styled(ClayForm.Group)`
  display: grid;
  grid-template-columns: 80%;
  grid-auto-rows: auto;
  row-gap: 1rem;

  .phone-label {
    color: #1A1A1A;
    opacity: 0.8;
  }
`;

export const PhoneNumberWrapper = styled.li`
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  flex-wrap: wrap;

  & select {
    width: 31%;
  }

  & input {
    width: 38%;
  }

  .country-code {
    color: #005CD0;
    border-radius: 0.25rem 0 0 0.25rem;
    border-right-color: white;
  }

  .area-code {
    border-radius: 0 0 0 0;
    border-left-color: white;
    border-right-color: white;
  }

  .phone-number {
    border-left-color: white;
  }
`;

export const LinkWrapper = styled.div`
  & a {
    color: #394a64;
    text-decoration: underline;
  }
`;

export const OrderedListWrapper = styled.ol`
  display: grid;
  grid-auto-rows: auto;
  row-gap: 1rem;
  list-style-type: none;
  margin: 0;
  padding: 0;

  input[type="number"]::-webkit-outer-spin-button,
  input[type="number"]::-webkit-inner-spin-button {
    -webkit-appearance: none;
    margin: 0;
  }

  input[type="number"] {
    -moz-appearance: textfield;
  }
`;


export const Error = styled.small`
  font-size: 12px;
  color: red;
`;