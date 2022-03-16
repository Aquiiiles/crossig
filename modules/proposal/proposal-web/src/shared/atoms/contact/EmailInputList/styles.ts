import styled from "styled-components";
import ClayForm from "@clayui/form";

export const StyledFormGroup = styled(ClayForm.Group)`
  display: grid;
  grid-template-columns: 80%;
  grid-auto-rows: auto;
  row-gap: 1rem;

  & input {
    color: ${(props) => props.theme.color.primary.links};
  }

  .form-control:focus {
    color: ${(props) => props.theme.color.primary.links};
  }

  @media ${({ theme }) => theme.breakpoint.tablet("down")} {
    padding-top: 1.875rem;
  }

  @media ${({ theme }) => theme.breakpoint.mobile("down")} {
    grid-template-columns: 1fr;
  }
`;

export const Error = styled.small`
  font-size: 13px;
  color: ${(props) => props.theme.color.feedback.error};
`;
