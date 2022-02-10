import styled from "styled-components";

export const Wrapper = styled.div`
  & a.active {
    color: ${props => props.theme.color.action.active}
  }

  & a.disabled {
    color: ${props => props.theme.color.action.disabled}
    pointer-events: none;
  }
`;