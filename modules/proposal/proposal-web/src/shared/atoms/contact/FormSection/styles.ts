import styled from "styled-components";

export const Wrapper = styled.section`
  @media ${({ theme }) => theme.breakpoint.mobile("down")} {
    & #dateOibInputGroup {
      flex-direction: column;
      row-gap: 1.875rem;
    }

    & #dateOibInputGroup > .input-group-item {
      width: 100%;
      margin-left: 0;
    }
  }
`;
