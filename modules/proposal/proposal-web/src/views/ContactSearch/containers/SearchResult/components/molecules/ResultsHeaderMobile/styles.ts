import styled from "styled-components";

export const Wrapper = styled.div`
  display: none;
  flex-direction: column;
  padding: 2.625rem 1.5rem 0 1.5rem;

  @media ${({ theme }) => theme.breakpoint.tablet("down")} {
    display: flex;
  }
`;

export const Header = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: center;

  & > *:first-child {
    flex: 0 1 45%;
  }

  & > *:last-child {
    flex: 0 0 auto;
  }

  @media ${(props) => props.theme.breakpoint.mobile("down")} {
    & > *:first-child {
      flex: 0 1 75%;
    }

    & > *:last-child {
      flex: 0 0 auto;
    }
  }
`;

export const FieldWrapper = styled.div`
  display: grid;
  grid-template-columns: repeat(2, 1fr);
  grid-template-rows: 1fr;
  column-gap: 1rem;
`;
