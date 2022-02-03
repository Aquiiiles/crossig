import styled from "styled-components";

export const Wrapper = styled.div<{ half: boolean }>`
  display: flex;

  & .form-group:first-child {
    margin-right: 1.5rem;
  }

  & > * {
    flex: ${props => (props.half ? "0 1 50%" : "1 1 100%")};
  }
`;
