import styled from "styled-components";

export const Wrapper = styled.div`
  margin-top: 3.75rem;
  margin-bottom: 2.8125rem;
  padding: 2.3125rem 0 1.875rem 0.5625rem;
  width: 100%;
  background-color: ${(props) => props.theme.color.neutral.white};
  border-radius: 12px;

  .city-dropdown {
    cursor: pointer;
    width: max-content;
  }

  .type-dropdown {
    cursor: pointer;
    width: min-content;
  }

  @media ${({ theme }) => theme.breakpoint.tablet("down")} {
    margin-top: 1.5rem;
    padding: 0 2.1875rem;
    padding-bottom: 1.875rem;
    border-radius: 0;
    border-top: 1px solid ${(props) => props.theme.color.neutral.dividerGrey};

    & .desktop-only {
      display: none;
    }
  }
`;

export const SearchResultsHeader = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 2.625rem;
  padding-left: calc(1.25rem - 0.5625rem);
  padding-right: 1.5rem;

  & > .h9 {
    flex: 1 1 auto;
    margin-bottom: 0;
  }

  & > .form-group {
    flex: 0 1 20%;
    display: grid;
    grid-template-columns: repeat(2, 1fr);
    grid-auto-rows: auto;
    column-gap: 1.1875rem;
    margin-bottom: 0;
  }
`;

export const Error = styled.small`
  font-size: 14px;
  color: ${(props) => props.theme.color.feedback.error};
  font-weight: bold;
`;
