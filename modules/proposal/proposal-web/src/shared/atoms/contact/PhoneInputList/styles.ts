import styled from "styled-components";
import ClayForm from "@clayui/form";

export const StyledFormGroup = styled(ClayForm.Group)`
  display: grid;
  grid-template-columns: 80%;
  grid-auto-rows: auto;
  row-gap: 1rem;

  @media ${({ theme }) => theme.breakpoint.tablet("down")} {
    padding-top: 1.875rem;
  }

  @media ${({ theme }) => theme.breakpoint.mobile("down")} {
    grid-template-columns: 1fr;
  }
`;

export const PhoneNumberWrapper = styled.li`
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  flex-wrap: wrap;

  & input {
    color: ${(props) => props.theme.color.primary.links};
    width: 60%;
  }

  option:disabled {
    color: ${(props) => props.theme.color.action.disabled};
  }

  .country-code {
    width: 19%;
    color: ${(props) => props.theme.color.primary.links};
  }

  .area-code {
    width: 19%;
  }

  .area-code-default-option {
    color: ${(props) => props.theme.color.neutral.neutralGreyText};
  }

  .area-code-option {
    color: ${(props) => props.theme.color.primary.links};
  }

  .phone-number {
    color: ${(props) => props.theme.color.primary.links};
  }

  .hidden-select {
    display: none;
  }

  .stretch-phone-number {
    width: 80%;
  }

  @media ${({ theme }) => theme.breakpoint.tablet("down")} {
    & .country-code,
    & .area-code {
      flex: 0 1 30%;
    }

    & .phone-number {
      flex: 1 1 40%;
    }
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
  color: ${(props) => props.theme.color.feedback.error};
`;
