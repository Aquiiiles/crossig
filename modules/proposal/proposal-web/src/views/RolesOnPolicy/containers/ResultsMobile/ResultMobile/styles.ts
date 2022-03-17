import styled from "styled-components";

export const Wrapper = styled.div`
  position: relative;
  display: flex;
  flex-direction: column;
  padding: 1.5rem 3.125rem;
`;

export const MainGrid = styled.div`
  display: grid;
  grid-auto-columns: minmax(0, 1fr);
  grid-auto-flow: column;
  column-gap: 1rem;

  @media ${({ theme }) => theme.breakpoint.mobile("down")} {
    grid-template-columns: 1fr;
    grid-auto-flow: row;
  }
`;

export const InnerGrid = styled.div`
  display: grid;
  grid-template-columns: min-content 1fr;
  grid-auto-rows: min-content;
  column-gap: 2.5rem;

  & > h6 {
    color: ${(props) => props.theme.color.neutral.neutralGreyText};
    margin-bottom: 1.5rem;
  }

  & > p {
    color: ${(props) => props.theme.color.neutral.black};
  }
`;

export const ButtonGroup = styled.div`
  display: grid;
  grid-auto-columns: max-content;
  grid-auto-flow: column;
  column-gap: 1rem;
`;
