import styled from "styled-components";

export const Wrapper = styled.div`
  padding: 1.5rem 3.125rem;
  background-color: ${(props) => props.theme.color.neutral.white};

  p {
    margin-bottom: 0;

    &.add-role {
      color: ${(props) => props.theme.color.primary.links};
    }
  }
`;
