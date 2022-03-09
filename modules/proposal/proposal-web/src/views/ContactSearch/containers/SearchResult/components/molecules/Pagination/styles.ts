import styled from "styled-components";

export const Wrapper = styled.div`
  padding: calc(1.875rem - 1.5rem) 1.5rem 0 0.4375rem;
  display: flex;
  justify-content: space-between;
  align-items: center;

  & p {
    margin-bottom: 0;
  }

  @media ${(props) => props.theme.breakpoint.mobile("down")} {
    flex-direction: column;
    row-gap: 1rem;
  }
`;
