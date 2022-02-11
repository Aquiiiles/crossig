import styled from "styled-components";

export const Wrapper = styled.div`
  display: flex;
  align-items: flex-end;
  flex-direction: column;
  padding-top: 1.02rem;

  & select {
    width: min-content;
    color: ${props => props.theme.color.primary.links};
  }

  .form-control:focus {
    color: ${props => props.theme.color.primary.links};
  }

  & label {
    padding-right: 3.5rem;
  }
`;
