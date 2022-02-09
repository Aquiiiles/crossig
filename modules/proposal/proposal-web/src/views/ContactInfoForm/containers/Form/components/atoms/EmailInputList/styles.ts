import styled from "styled-components";
import ClayForm from "@clayui/form";

export const StyledFormGroup = styled(ClayForm.Group)`
  display: grid;
  grid-template-columns: 80%;
  grid-auto-rows: auto;
  row-gap: 1rem;

  .email-label {
    color: #1A1A1A;
    opacity: 0.8;
  }
`;

export const Error = styled.small`
  font-size: 12px;
  color: red;
`;
