import styled from "styled-components";
import ClayForm from "@clayui/form";

export const StyledFormGroup = styled(ClayForm.Group)`
  display: grid;
  grid-template-columns: 80%;
  grid-auto-rows: auto;
  row-gap: 1rem;
  }
`;

export const PhoneNumberWrapper = styled.li`
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  flex-wrap: wrap;

  & input {
    color: ${props => props.theme.color.primary.links};
    width: 65%;
  }

  option:disabled {
    color: ${props => props.theme.color.action.disabled};
  }

  .country-code {
    width: 15%;
    color: ${props => props.theme.color.primary.links};
    border-radius: 0.25rem 0 0 0.25rem;
    border-right-color: white;
  }

  .area-code {
    width: 20%;
    border-radius: 0 0 0 0;
    border-left-color: white;
    border-right-color: white;
  }

  .area-code-default-option {
    color: ${props => props.theme.color.neutral.neutralGreyText};
  }

  .area-code-option {
    color: ${props => props.theme.color.primary.links};
  }

  .phone-number {
    color: ${props => props.theme.color.primary.links};
    border-left-color: white;
  }

  .hidden-select {
    display: none;
  }

  .stretch-phone-number {
    width: 85%;
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
  font-size: 13px;
  color: ${props => props.theme.color.feedback.error};
`;