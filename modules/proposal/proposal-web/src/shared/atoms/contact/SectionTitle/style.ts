import styled from "styled-components";

export const Wrapper = styled.div`
  padding: 0 1.5rem;

  & h6 {
    margin-bottom: 0;
  }

  @media ${({ theme }) => theme.breakpoint.tablet("down")} {
    padding: 0;
  }
`;
