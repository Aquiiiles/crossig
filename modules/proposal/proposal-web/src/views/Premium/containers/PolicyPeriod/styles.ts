import styled from "styled-components";

export const Wrapper = styled.div`
  padding: 1.25rem 2.4375rem 1.25rem 1.9375rem;
  background-color: ${(props) => props.theme.color.neutral.white};
  border-radius: 12px;
  display: grid;
  grid-template-columns: auto 1fr auto;
  grid-template-rows: auto;
  width: 60%;

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

  .section-title {
    padding: 0;
  }

  .form-grid {
    padding-top: 1.5rem;
    display: grid;
    grid-auto-rows: auto;
  }
`;

export const Title = styled.div`
  padding: 0;

  & h6 {
    margin-bottom: 0;
  }
`;

export const Grid = styled.div`
  padding-top: 2.5rem;
  display: grid;
  grid-auto-rows: auto;

  & > *:first-child {
    justify-self: end;
  }

  & > div:not(:first-of-type) {
    grid-column-start: 2;
  }

  @media ${({ theme }) => theme.breakpoint.tablet("down")} {
    grid-template-columns: 1fr;

    && .halfRowTabletFullRowMobile {
      width: calc(50% - 1.1rem);
    }

    & > strong {
      justify-self: initial !important;
    }

    & > div:first-of-type {
      justify-self: initial;
      width: calc(50% - 1.2rem);
    }

    & > div:not(:first-of-type) {
      grid-column-start: initial;
    }

    & > div:nth-of-type(2) {
      grid-row-start: 2;
    }
  }

  @media ${({ theme }) => theme.breakpoint.mobile("down")} {
    && .halfRowTabletFullRowMobile {
      width: 100%;
    }

    & > div:first-of-type {
      justify-self: initial;
      width: 100%;
    }
  }
`;
