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
    display: grid;
    grid-template-columns: 0.5fr 0.5fr 1fr;
    column-gap: 1rem;
  }
`;
