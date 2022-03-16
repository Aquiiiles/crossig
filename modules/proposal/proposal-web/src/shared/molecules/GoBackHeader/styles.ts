import styled from "styled-components";

export const Wrapper = styled.div`
  display: none;

  @media ${({ theme }) => theme.breakpoint.tablet("down")} {
    height: 5rem;
    display: flex;
    position: relative;
    left: 2rem;
  }
`;
