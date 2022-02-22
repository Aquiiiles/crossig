import styled from "styled-components";

export const Banner = styled.div`
  margin-bottom: 1rem;
  padding: 1rem;
  background-color: ${props => props.theme.color.feedback.success};
  color: ${props => props.theme.color.neutral.white};
  border-radius: 12px;
`;
