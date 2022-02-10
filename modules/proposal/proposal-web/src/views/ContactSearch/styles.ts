import styled from "styled-components";

export const Wrapper = styled.div`
  display: flex;
  flex-direction: row;
  background-color: #f8f8f9;
  padding: 0;
  padding-top: 78px;
`;

export const LinkWrapper = styled.div`
  border-top: 1px solid ${props => props.theme.color.neutral.dividerGrey};
  padding: 3.125rem 0 2.8125rem 0;
`;

export const Content = styled.div`
  flex: 1;
  padding: 1.25rem;
`;
