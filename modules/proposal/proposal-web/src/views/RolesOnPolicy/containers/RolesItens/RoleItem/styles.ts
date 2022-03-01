import styled from "styled-components";

export const Wrapper = styled.div`
  background-color: ${(props) => props.theme.color.primary.main};
  border-radius: 16px;

  &:not(:first-child) {
    margin-left: 0.5rem;
  }

  p {
    margin-bottom: 0;
    color: ${(props) => props.theme.color.neutral.white};

    &.not-title {
      cursor: pointer;
    }
  }
`;
