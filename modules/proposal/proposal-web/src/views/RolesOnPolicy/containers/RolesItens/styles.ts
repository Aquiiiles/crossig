import styled from "styled-components";

export const Wrapper = styled.div`
  display: flex;

  p {
    padding: 0.4rem;
  }

  h6 {
    display: none;
    margin-right: 2.5rem;
    color: ${({ theme }) => theme.color.neutral.neutralGreyText};
    @media ${({ theme }) => theme.breakpoint.tablet("down")} {
      display: flex;
    }
  }
`;

export const Roles = styled.div`
  display: flex;
  flex-wrap: wrap;
`;
