import styled from "styled-components";

export const Wrapper = styled.div`
  display: flex;
  flex-direction: row;
  background-color: ${(props) => props.theme.color.neutral.background};

  span.msg {
    max-width: calc(100% - 15rem);
    margin: auto;
  }

  @media ${({ theme }) => theme.breakpoint.tablet("down")} {
    display: block;
  }
`;

export const InnerWrapper = styled.div`
  flex: 1 1 auto;

  @media ${({ theme }) => theme.breakpoint.tablet("down")} {
    padding: 0 2.1875rem;
    border-top: 1px solid ${(props) => props.theme.color.neutral.dividerGrey};

    & .desktop-only {
      display: none;
    }
  }
`;

export const Content = styled.div`
  flex: 1;
  padding: 6.25rem 3.5rem 1.25rem 3.75rem;

  @media ${(props) => props.theme.breakpoint.tablet("down")} {
    padding: 2.5rem 0;
  }

  p.subtitle {
    margin-bottom: 2.5rem;
    line-break: auto;
    color: ${({ theme }) => theme.color.neutral.neutralGreyText};
  }
`;

export const Buttons = styled.div`
  display: flex;
  border-top: 1px solid ${(props) => props.theme.color.neutral.dividerGrey};
  padding: 3.125rem 3.75rem 2.8125rem;

  @media ${(props) => props.theme.breakpoint.tablet("down")} {
    padding: 3.125rem 0 2.8125rem;
  }

  button {
    margin-left: auto;
  }
`;
