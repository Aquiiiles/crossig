import styled from "styled-components";

export const Wrapper = styled.div`
  padding-top: 1rem;
  display: grid;
  grid-template-columns: 0.5fr 2fr;
  grid-auto-rows: auto;
  gap: 1rem 3rem;

  & > *:first-child {
    justify-self: end;
  }

  & > *:not(:first-child) {
    grid-column-start: 2;
  }

  & .birth-date-group {
    width: 100%;
    display: grid;
    grid-template-columns: 0.5fr 0.5fr 1fr;
    column-gap: 1rem;
  }

  @media ${(props) => props.theme.breakpoint.tablet("down")} {
    grid-template-columns: 1fr;

    & > *:first-child {
      justify-self: initial;
      width: calc(50% - 1.2rem);
    }

    & > *:not(:first-child) {
      grid-column-start: initial;
    }

    & > *:nth-child(2) {
      grid-row-start: 2;
    }
  }
`;
