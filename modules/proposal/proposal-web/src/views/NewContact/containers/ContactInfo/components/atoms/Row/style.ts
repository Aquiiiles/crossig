import styled from "styled-components";

export const Wrapper = styled.div<{ half: boolean }>`
  display: flex;

  & > * {
    flex: ${(props) => (props.half ? "0 1 50%" : "1 1 100%")};
  }
`;
