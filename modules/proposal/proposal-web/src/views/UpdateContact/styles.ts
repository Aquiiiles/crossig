import styled from "styled-components";

export const Wrapper = styled.div`
  display: flex;
  flex-direction: row;
  background-color: ${(props) => props.theme.color.neutral.background};
`;

export const Content = styled.div`
  flex: 1;
  padding: 1.25rem;
`;
