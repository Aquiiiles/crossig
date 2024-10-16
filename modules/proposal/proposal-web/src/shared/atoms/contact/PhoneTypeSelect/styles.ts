import styled from "styled-components";

export const Wrapper = styled.div`
  display: flex;
  align-items: flex-end;
  flex-direction: column;
  padding-top: 1.02rem;

  & select {
    width: min-content;
    color: ${(props) => props.theme.color.primary.links};
  }

  .form-control:focus {
    color: ${(props) => props.theme.color.primary.links};
  }

  @media ${({ theme }) => theme.breakpoint.tablet("down")} {
    align-items: flex-start;

    & select {
      width: 50%;
    }
  }

  @media ${({ theme }) => theme.breakpoint.mobile("down")} {
    & select {
      width: 100%;
    }
  }
`;
