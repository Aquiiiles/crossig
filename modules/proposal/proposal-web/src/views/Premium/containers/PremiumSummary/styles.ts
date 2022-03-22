import styled from "styled-components";

export const Wrapper = styled.div`
  padding: 1.25rem 2.4375rem 1.25rem 1.9375rem;
  background-color: ${(props) => props.theme.color.neutral.white};
  border-radius: 12px;
  width: 38%;

  .discount-form-group {
    display: flex;
    gap: 1rem;
    align-items: center;

    & button {
      height: 3.4375rem;
    }
  }
`;

export const Title = styled.div`
  padding: 0;

  & h6 {
    margin-bottom: 0;
  }
`;

export const DescriptionWrapper = styled.div`
  padding-top: 2.5rem;
`;

export const PaymentDescription = styled.div`
  display: flex;
  justify-content: space-between;
`;
