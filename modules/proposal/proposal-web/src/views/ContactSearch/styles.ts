import styled from "styled-components";

interface Props {
  readonly embedded: boolean;
}

export const Wrapper = styled.div<Props>`
  display: ${(props) => (props.embedded ? "block" : "flex")};
  flex-direction: row;
  background-color: ${(props) =>
    props.embedded
      ? props.theme.color.neutral.white
      : props.theme.color.neutral.background};
  padding: 0;
  height: 100%;

  @media ${({ theme }) => theme.breakpoint.tablet("down")} {
    display: block;
  }
`;

export const LinkWrapper = styled.div`
  border-top: 1px solid ${(props) => props.theme.color.neutral.dividerGrey};
  padding: 3.125rem 0 2.8125rem 3.75rem;

  @media ${({ theme }) => theme.breakpoint.tablet("down")} {
    padding: 1.9375rem 0 1.5rem 2.5rem;
    position: fixed;
    bottom: 0;
    left: 0;
    width: 100%;
    border-top: 0;
    box-shadow: 0px 2px 7px ${(props) => props.theme.color.neutral.neutralGrey};
    background-color: ${(props) => props.theme.color.neutral.white};
    z-index: 5;
  }
`;

export const InnerWrapper = styled.div<Props>`
  flex: 1 1 auto;
  background-color: ${(props) => props.theme.color.neutral.background};

  @media ${({ theme }) => theme.breakpoint.tablet("down")} {
    padding: 2rem 2.1875rem 0 2.1875rem;
    border-top: 1px solid ${(props) => props.theme.color.neutral.dividerGrey};
  }
`;

export const Content = styled.div<Props>`
  flex: 1;
  padding: ${(props) =>
    props.embedded ? "0" : "6.25rem 3.5rem 1.25rem 3.75rem"};

  & .content-subtitle {
    margin-bottom: 2.5rem;
  }

  @media ${({ theme }) => theme.breakpoint.tablet("down")} {
    padding: ${(props) => (props.embedded ? "0" : "2.5rem 0")};

    & .content-subtitle {
      margin-bottom: 1.5rem;
    }
  }
  background-color: ${(props) => props.theme.color.neutral.background};
`;

export const EmptySpace = styled.div`
  height: calc(65px + 121px);
`;
