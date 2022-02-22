import ClayForm from "@clayui/form";
import styled from "styled-components";

export const StyledLabelFormGroup = styled(ClayForm.Group)`
  display: grid;
  padding-bottom: 2.5rem;
`;

export const StyledPhoneTypeFormGroup = styled(ClayForm.Group)`
  display: flex;
  flex-direction: column;
  padding-top: 1.5rem;
  justify-content: flex-start;

  .form-group {
    margin-top: -1.5rem;
    margin-bottom: 2.5rem;
  }
`;
