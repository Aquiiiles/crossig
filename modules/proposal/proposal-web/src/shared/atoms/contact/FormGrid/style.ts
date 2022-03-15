import styled from "styled-components";

export const Wrapper = styled.div`
  padding-top: 1rem;
  display: grid;
  grid-template-columns: 0.5fr 2fr;
  grid-auto-rows: auto;
  gap: 1rem 3rem;

  & > *:first-child {
    justify-self: end;
  }

  & > div:not(:first-of-type) {
    grid-column-start: 2;
  }

  & .birth-date-group {
    width: 100%;
    display: grid;
    grid-template-columns: 0.5fr 0.5fr 1fr;
    column-gap: 1rem;
  }

  @media ${({ theme }) => theme.breakpoint.tablet("down")} {
    grid-template-columns: 1fr;

    && .cityPostalRow {
      grid-row-start: 3;
    }

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
