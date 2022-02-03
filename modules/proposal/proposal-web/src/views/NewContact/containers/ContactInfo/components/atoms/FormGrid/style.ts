import styled from "styled-components";

export const Wrapper = styled.div`
  display: grid;
  grid-template-columns: 1fr 2fr;
  grid-auto-rows: auto;

  & > *:not(:first-child) {
    grid-column-start: 2;
  }
`;
