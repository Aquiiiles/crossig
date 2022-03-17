import styled from "styled-components";

export const Wrapper = styled.div`
  background-color: ${(props) => props.theme.color.secondary[2]};
  border-radius: 160px;
  padding: 0 1rem;
  margin-bottom: 0.5rem;

  @media ${({ theme }) => theme.breakpoint.tablet("down")} {
    position: relative;
    top: -0.5rem;
  }

  &:not(:last-child) {
    margin-right: 0.5rem;
  }

  p {
    margin-bottom: 0;
    color: ${(props) => props.theme.color.neutral.white};
    white-space: nowrap;

    &.not-title {
      cursor: pointer;
    }
  }

  svg {
    transform: scale(0.8);
  }
`;
