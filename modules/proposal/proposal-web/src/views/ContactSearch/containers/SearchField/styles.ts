import styled from "styled-components";

export const Wrapper = styled.div``;

export const SearchWrapper = styled.div`
  display: grid;
  grid-template-columns: minmax(250px, 0.65fr) minmax(auto, 1fr);
  grid-template-rows: auto;
  column-gap: 0.5rem;
  align-items: end;

  & #basicInputText {
    color: ${props => props.theme.color.primary.links};
  }

  & > .btn {
    justify-self: start;
  }
`;
