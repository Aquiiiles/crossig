import styled from "styled-components";

export const Wrapper = styled.div`
  display: flex;
  flex-direction: column;
  padding: 1.5rem 0;
  border-bottom: 1px solid ${(props) => props.theme.color.neutral.dividerGrey};
`;

export const MainGrid = styled.div`
  display: grid;
  grid-template-columns: repeat(2, 1fr);
  grid-template-rows: auto;

  @media ${({ theme }) => theme.breakpoint.mobile("down")} {
    grid-template-columns: 1fr;
  }
`;

export const InnerGrid = styled.div`
  display: grid;
  grid-template-columns: max-content 1fr;
  grid-auto-rows: min-content;
  column-gap: 2.5rem;

  & > h6 {
    color: ${(props) => props.theme.color.neutral.neutralGreyText};
    min-height: 2rem;
  }

  & > p {
    color: ${(props) => props.theme.color.neutral.black};
  }

  @media ${({ theme }) => theme.breakpoint.mobile("down")} {
    & > p {
      text-align: end;
      justify-self: end;
      align-self: start;
    }
  }
`;

export const ButtonGroup = styled.div`
  display: grid;
  grid-auto-columns: max-content;
  grid-auto-flow: column;
  column-gap: 1rem;
`;
