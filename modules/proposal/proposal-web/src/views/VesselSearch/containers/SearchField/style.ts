import styled from "styled-components";

export const Wrapper = styled.div`
  display: flex;
  align-items: end;

  @media ${({ theme }) => theme.breakpoint.tablet("down")} {
    & #vesselLookupInputGroup {
      display: grid;
      grid-template-columns: 1fr repeat(2, 0.5fr) 1fr;
      grid-auto-rows: auto;
      column-gap: 0.5rem;
      align-items: end;

      & .input-group-item {
        margin-left: 0;
        width: 100%;
      }

      & .input-group-item:nth-child(2) {
        grid-column: 2 / 4;
      }

      & .input-group-item:nth-child(4) {
        grid-column: 1 / 3;
      }

      & .input-group-item:nth-child(5) {
        grid-column: 3 / 5;
      }
    }

    & #vesselLookupCreateVesselButton {
      padding: 1.9375rem 0 1.5rem 2.5rem;
      position: fixed;
      bottom: 0;
      left: 0;
      width: 100%;
      box-shadow: 0px 2px 7px
        ${(props) => props.theme.color.neutral.neutralGrey};
      background-color: ${(props) => props.theme.color.neutral.white};
      z-index: 5;

      & > button {
        padding: 0;
      }
    }
  }

  @media ${({ theme }) => theme.breakpoint.mobile("down")} {
    & #vesselLookupInputGroup {
      display: flex;
    }
  }
`;
