import styled from "styled-components";

export const SubTitle = styled.strong`
  grid-column-start: 1 !important;
  text-align: end;

  @media ${({ theme }) => theme.breakpoint.tablet("down")} {
    text-align: start;
  }
`;
