import styled from "styled-components";

export const Wrapper = styled.div`
  & .tablet-only {
    display: none;
  }

  @media ${({ theme }) => theme.breakpoint.tablet("down")} {
    & .desktop-only {
      display: none;
    }

    & .tablet-only {
      display: block;
    }
  }
`;

export const SearchWrapper = styled.div`
  display: flex;
  grid-template-columns: minmax(750px, 0.65fr) minmax(auto, 1fr);
  grid-template-rows: auto;
  column-gap: 0.5rem;
  align-items: end;

  & #oibInputText {
    color: ${(props) => props.theme.color.primary.links};
  }
  & #lastNameInputText {
    color: ${(props) => props.theme.color.primary.links};
  }
  & #firstNameInputText {
    color: ${(props) => props.theme.color.primary.links};
  }

  @media ${({ theme }) => theme.breakpoint.mobile("down")} {
    & .searchFieldInputs > .input-group-item {
      width: 100%;
      margin-left: 0;
    }

    & .searchFieldButtonGroup {
      display: grid;
      grid-template-columns: 1fr;
      grid-auto-rows: auto;
      row-gap: 1rem;
    }

    & .searchFieldButtonGroup button {
      width: 100%;
    }
  }
`;
