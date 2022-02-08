import styled from "styled-components";

export const Wrapper = styled.div`
  & a.active {
    color: #005CD0;
  }

  & a.disabled {
    color: #005CD0;
    pointer-events: none;
    opacity: 0.7;
  }
`;