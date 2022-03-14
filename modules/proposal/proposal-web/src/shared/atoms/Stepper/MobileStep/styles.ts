import styled from "styled-components";

export const Wrapper = styled.div<{ active: boolean }>`
  span {
    height: 0.625rem;
    width: 0.625rem;
    border-radius: 50%;
    display: inline-block;

    &.not-active {
      background-color: ${({ theme }) => theme.color.neutral.dot};
    }

    &.active {
      background-color: ${({ theme }) => theme.color.primary.links};
      position: relative;
      right: 0.75rem;
      bottom: 0.125rem;
      margin-right: -0.75rem;
    }

    &.outter {
      height: 0.875rem;
      width: 0.875rem;
      background-color: ${(props) => props.theme.color.neutral.white};
      border: 1px solid rgba(33, 114, 255, 0.5);
    }
  }

  margin-top: ${({ active }) => (active ? "0.25rem" : "0")};
`;
