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
  padding-top: ${(props) => (props.embedded ? "2rem" : "4.875rem")};
`;

export const LinkWrapper = styled.div`
  border-top: 1px solid ${(props) => props.theme.color.neutral.dividerGrey};
  padding: 3.125rem 0 2.8125rem 3.75rem;
`;

export const InnerWrapper = styled.div`
  flex: 1 1 auto;
`;

export const Content = styled.div<Props>`
  flex: 1;
  padding: ${(props) =>
    props.embedded ? "0" : "6.25rem 3.5rem 1.25rem 3.75rem"};
`;

export const EmptySpace = styled.div`
  height: calc(65px + 121px);
`;
