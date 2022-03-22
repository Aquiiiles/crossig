import styled from "styled-components";

export const Wrapper = styled.div`
  padding: 1.25rem 2.4375rem 1.25rem 1.9375rem;
  background-color: ${(props) => props.theme.color.neutral.white};
  border-radius: 12px;
  display: grid;
  grid-template-rows: auto;
  column-gap: 1.875rem;
  align-items: center;
  white-space: nowrap;

  @media ${({ theme }) => theme.breakpoint.mobile("down")} {
    display: flex;
    flex-direction: column;

    img {
      margin-right: auto;
    }

    button {
      margin-right: auto;
      margin-left: 0 !important;
    }
  }

  .vessel-description-row {
    column-gap: 5rem;
    flex-direction: row;
  }

  .section-title {
    padding: 0;
  }
`;

export const LabelGroup = styled.div`
  display: flex;
  flex-direction: column;
`;
