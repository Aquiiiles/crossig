import styled from "styled-components";

export const Wrapper = styled.div`
  padding: 1.25rem 2.5rem;
  .form-group {
    margin-top: 1rem;
  }
`;

export const InputWrapper = styled.div`
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  flex-wrap: wrap;
  .form-group {
    width: max-content;
  }

  & ol {
      list-style-type: none;
      margin: 0;
      padding: 0;
    }
`;