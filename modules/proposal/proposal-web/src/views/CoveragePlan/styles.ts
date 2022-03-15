import styled from "styled-components";

export const Wrapper = styled.div`
  display: flex;
  flex-direction: row;
  background-color: ${(props) => props.theme.color.neutral.background};
  height: 100%;

  @media ${({ theme }) => theme.breakpoint.tablet("down")} {
    flex-direction: column;
  }
`;

export const InnerWrapper = styled.div`
  flex: 1 1 auto;
`;

export const Content = styled.div`
  flex: 1;
  padding: 1.25rem 3.5rem 1.25rem 3.75rem;

  @media ${({ theme }) => theme.breakpoint.tablet("down")} {
    padding: 2rem;
  }

  p {
    line-break: auto;
    color: ${({ theme }) => theme.color.neutral.neutralGreyText};
  }
`;

export const Products = styled.div`
  display: grid;
  grid-template-columns: 0.25fr 1fr 0.25fr;
  grid-auto-rows: auto;
  row-gap: 1.25rem;
  margin-bottom: 12.3125rem;

  & > * {
    grid-column-start: 2;
  }

  @media ${({ theme }) => theme.breakpoint.tablet("down")} {
    grid-template-columns: 0 1fr 0;
  }
`;

export const Footer = styled.div`
  display: flex;
  border-top: 1px solid ${(props) => props.theme.color.neutral.dividerGrey};
  padding: 3.125rem 0 2.8125rem 0;
`;
