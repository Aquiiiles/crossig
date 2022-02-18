import styled from "styled-components";

export const Wrapper = styled.div`
  display: flex;
  flex-direction: row;
  background-color: ${props => props.theme.color.neutral.background};
  padding: 0;
  padding-top: 4.875rem;
`;

export const Content = styled.div`
  flex: 1;
  padding: 1.25rem 3.5rem 1.25rem 3.75rem;
`;

export const Products = styled.div`
  display: grid;
  grid-template-columns: 0.25fr 1fr 0.25fr;
  grid-auto-rows: auto;
  row-gap: 1.25rem;

  & > * {
    grid-column-start: 2;
  }
`;
