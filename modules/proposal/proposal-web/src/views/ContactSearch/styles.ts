import styled from "styled-components";

export const Wrapper = styled.div`
  display: flex;
  flex-direction: row;
  background-color: ${props => props.theme.color.neutral.background};
  padding: 0;
  padding-top: 4.875rem;
`;

export const LinkWrapper = styled.div`
  border-top: 1px solid ${props => props.theme.color.neutral.dividerGrey};
  padding: 3.125rem 0 2.8125rem 0;
`;

export const Content = styled.div`
  flex: 1;
  padding: 1.25rem 3.5rem 1.25rem 3.75rem;
`;

export const EmptySpace = styled.div`
  height: calc(65px + 121px);
`;
