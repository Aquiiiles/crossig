import styled from "styled-components";

export const Wrapper = styled.div`
  display: flex;
  flex-direction: row;
  background-color: ${(props) => props.theme.color.neutral.background};
  height: 100%;

  @media ${({ theme }) => theme.breakpoint.tablet("down")} {
    display: block;
  }
`;

export const LinkWrapper = styled.div`
  border-top: 1px solid ${(props) => props.theme.color.neutral.dividerGrey};
  padding: 3.125rem 0 2.8125rem 3.75rem;
`;

export const InnerWrapper = styled.div`
  flex: 1 1 auto;

  @media ${({ theme }) => theme.breakpoint.tablet("down")} {
    padding: 0 2.1875rem;
    border-top: 1px solid ${(props) => props.theme.color.neutral.dividerGrey};
    background-color: ${(props) => props.theme.color.neutral.background};
  }
`;

export const Content = styled.div`
  background-color: ${(props) => props.theme.color.neutral.background};
  padding: 6.25rem 3.5rem 1.25rem 3.75rem;
  display: flex;
  flex-wrap: wrap;
  gap: 1rem;

  @media ${({ theme }) => theme.breakpoint.tablet("down")} {
    padding: 2.5rem 0;
    padding-bottom: 0;

    & .tablet-padding {
      padding: 0 2.5rem;
    }
  }

  @media ${({ theme }) => theme.breakpoint.mobile("down")} {
    & .tablet-padding {
      padding: 0 1.5rem;
    }
  }
`;

export const PremiumSectionTitle = styled.div`
  padding: 0;

  & h6 {
    margin-bottom: 0;
  }
`;

export const ButtonWrapper = styled.div`
  background-color: ${(props) => props.theme.color.neutral.background};
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding-bottom: 3rem;
  padding-left: 1rem;
  padding-right: 1rem;

  @media ${({ theme }) => theme.breakpoint.mobile("down")} {
    flex-direction: column;

    & > *:first-child {
      margin: 1.5rem 0;
    }

    & > .btn-group {
      flex-direction: column;
      align-items: center;
      row-gap: 1rem;
    }
  }
`;
