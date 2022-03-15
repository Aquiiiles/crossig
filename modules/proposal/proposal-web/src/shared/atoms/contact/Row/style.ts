import styled from "styled-components";

export const Wrapper = styled.div<{ half: boolean }>`
  display: flex;

  & .input-group-item:not(:first-child) {
    margin-left: 2.5rem;
  }

  & > * {
    flex: ${(props) => (props.half ? "0 1 50%" : "1 1 100%")};
    padding-right: ${(props) => (props.half ? "1.25rem" : "0")};
  }

  @media ${({ theme }) => theme.breakpoint.tablet("down")} {
    & .input-group-item:not(:first-child) {
      margin-left: 2rem;
    }
  }
`;
