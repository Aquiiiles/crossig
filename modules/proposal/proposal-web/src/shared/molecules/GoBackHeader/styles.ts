import styled from "styled-components";

export const Wrapper = styled.div`
  display: none;

  @media ${({ theme }) => theme.breakpoint.tablet("down")} {
    height: 5rem;
    width: calc(100% + 2rem);
    display: flex;
    padding: 0;
    position: relative;
    right: 1rem;
  }
`;
