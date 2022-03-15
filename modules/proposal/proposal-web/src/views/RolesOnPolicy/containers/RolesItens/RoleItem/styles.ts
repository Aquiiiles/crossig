import styled from "styled-components";

export const Wrapper = styled.div`
  background-color: ${(props) => props.theme.color.secondary[2]};
  border-radius: 160px;
  padding: 0 0.5rem;

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

  svg {
    transform: scale(0.8);
  }
`;
