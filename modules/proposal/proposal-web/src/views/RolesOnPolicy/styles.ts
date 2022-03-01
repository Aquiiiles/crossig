import styled from "styled-components";

export const Wrapper = styled.div`
  span {
    padding-top: 0.5rem;
    padding-right: 1rem;
  }
`;

export const Buttons = styled.div`
  display: flex;
  border-top: 1px solid ${(props) => props.theme.color.neutral.dividerGrey};
  padding: 3.125rem 0 2.8125rem 0;
`;
