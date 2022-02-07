import styled from "styled-components";

export const Wrapper = styled.div`
  padding-top: 1rem;
  display: grid;
  grid-template-columns: 0.5fr 2fr;
  grid-auto-rows: auto;
  column-gap: 3.5rem;
  row-gap: 1rem;

  & > div select.form-control {
    background-image: none !important;
    text-align: end;
    padding: 0 0.75rem 0 1.75rem !important;
    border: 0;
    transform: translateY(-0.4rem);

    &:focus {
      box-shadow: none;
    }
  }

  & > *:first-child {
    position: relative;
    justify-self: end;
  }

  & > .select-arrow-down:after {
    content: "";
    position: absolute;
    top: 0;
    right: -2px;
    width: 0;
    height: 0;
    transform: translateY(200%);
    border-left: 5px solid transparent;
    border-right: 5px solid transparent;
    border-top: 5px solid #000;
  }

  & > *:not(:first-child) {
    grid-column-start: 2;
  }
`;
