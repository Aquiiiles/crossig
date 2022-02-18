import styled from "styled-components";

export const Wrapper = styled.form`
  background-color: ${(props) => props.theme.color.neutral.white};
  padding: 1rem 1rem 2rem 2rem;
  box-shadow: rgb(0 0 0 / 10%) 0px 2px 5px;
  border-radius: 12px;

  .subtitle {
    margin-bottom: 1.875rem;
  }
`;

export const ButtonWrapper = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: center;
`;
