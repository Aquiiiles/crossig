import styled from "styled-components";

export const Wrapper = styled.div`
  display: none;
  flex-direction: column;

  @media ${({ theme }) => theme.breakpoint.tablet("down")} {
    display: flex;
  }
`;
