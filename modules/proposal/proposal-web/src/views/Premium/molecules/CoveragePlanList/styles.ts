import styled from "styled-components";

export const Wrapper = styled.div`
  padding: 1.25rem 2.4375rem 1.25rem 1.9375rem;
  background-color: ${(props) => props.theme.color.neutral.background};
  border-radius: 12px 0 0 12px;
  width: fit-content;
  white-space: nowrap;
`;

export const LabelGroup = styled.div`
  display: flex;
  flex-direction: column;
`;
