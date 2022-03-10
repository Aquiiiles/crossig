import styled from "styled-components";

export const Wrapper = styled.div`
  padding: 4.5rem 2.5rem;
  width: 15rem;
  background-color: ${(props) => props.theme.color.neutral.white};

  @media ${({ theme }) => theme.breakpoint.tablet("down")} {
    height: 5rem;
    width: 100%;
    display: flex;
    margin: auto;
    position: absolute;
    padding: 0;
  }

  .desktop-stepper {
    @media ${({ theme }) => theme.breakpoint.tablet("down")} {
      display: none;
    }
  }

  .mobile-stepper {
    @media ${({ theme }) => theme.breakpoint.tablet("up")} {
      display: none;
    }
    margin: auto;
  }
`;
