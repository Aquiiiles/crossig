import styled from "styled-components";

export const Wrapper = styled.div`
  padding: 4.5rem 2.5rem;
  width: 15rem;
  background-color: ${(props) => props.theme.color.neutral.white};

  @media ${({ theme }) => theme.breakpoint.tablet("down")} {
    width: 100%;
    display: flex;
    padding: 1.6rem;
    position: relative;
  }

  .desktop-stepper {
    @media ${({ theme }) => theme.breakpoint.tablet("down")} {
      display: none;
    }
  }

  .mobile-stepper {
    display: none;
    margin: auto;

    @media ${({ theme }) => theme.breakpoint.tablet("down")} {
      display: block;
    }
  }
`;

export const MobileWrapper = styled.div`
  svg {
    display: none;
  }

  @media ${({ theme }) => theme.breakpoint.tablet("down")} {
    width: 11rem;
    display: flex;
    margin: auto;

    svg {
      display: flex;
      position: absolute;
      right: 2rem;
      top: 2rem;
      color: ${(props) => props.theme.color.neutral.dot};
    }
  }
`;
