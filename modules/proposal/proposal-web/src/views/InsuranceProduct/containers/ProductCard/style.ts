import styled from "styled-components";

export const Wrapper = styled.div`
  padding: 1.25rem 2.4375rem 1.25rem 1.9375rem;
  background-color: ${props => props.theme.color.neutral.white};
  border-radius: 12px;
  display: grid;
  grid-template-columns: auto 1fr auto;
  grid-template-rows: auto;
  column-gap: 1.875rem;
  align-items: center;
`;

export const ProductInfoWrapper = styled.div`
  display: flex;
  flex-direction: column;
  transform: translateY(0.6rem);
`;
