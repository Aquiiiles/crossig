import ClayForm from "@clayui/form";
import styled from "styled-components";

export const Wrapper = styled.div`
  & .tablet-only {
    display: none;
  }

  @media ${({ theme }) => theme.breakpoint.tablet("down")} {
    & .desktop-only {
      display: none;
    }

    & .tablet-only {
      display: grid;
    }
  }
`;

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

export const InnerTitle = styled.div`
  padding-top: 2.5rem;
  display: grid;
  grid-template-columns: repeat(2, max-content);
  grid-auto-rows: min-content;
  column-gap: 0.5rem;
  align-items: center;
`;
