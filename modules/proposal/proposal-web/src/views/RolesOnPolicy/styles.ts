import styled from "styled-components";

export const Wrapper = styled.div`
  display: flex;
  flex-direction: row;
  background-color: ${(props) => props.theme.color.neutral.background};

  span.msg {
    padding-top: 0.5rem;
    padding-right: 1rem;
  }

  @media ${({ theme }) => theme.breakpoint.tablet("down")} {
    flex-direction: column;
  }
`;

export const InnerWrapper = styled.div`
  flex: 1 1 auto;
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
  padding: 3.125rem 0px 2.8125rem 3.75rem;
`;
