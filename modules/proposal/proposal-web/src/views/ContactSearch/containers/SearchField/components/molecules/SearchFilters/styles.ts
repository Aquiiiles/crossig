import styled from "styled-components";

export const Wrapper = styled.div`
  padding: 0.725rem 2.5rem;
  .form-group {
    margin-top: 1rem;
  }
`;

export const InputWrappers = styled.div`
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  flex-wrap: wrap;
  .form-group {
    width: 31%;
  }
`;

export const ButtonsWrapper = styled.div`
  display: flex;
  margin-top: 1rem;
  flex-direction: row;
  justify-content: flex-end;
  flex-wrap: wrap;
`;
