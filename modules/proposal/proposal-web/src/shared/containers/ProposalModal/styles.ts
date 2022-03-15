import ClayModal from "@clayui/modal";
import styled from "styled-components";

export const StyledModal = styled(ClayModal)`
  .modal-body {
    padding: 0;
  }

  .modal-header,
  .modal-title {
    background-color: transparent;
    border-color: transparent;
    pointer-events: none;
  }

  .close {
    pointer-events: all;
  }

  .lexicon-icon-info-circle {
    display: none;
  }
`;

export const HeaderWrapper = styled(ClayModal.Header)`
  pointer-events: none;
  display: grid;
  grid-template-columns: repeat(2, max-content);
  column-gap: 0.625rem;
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  z-index: 8000;
  background: transparent;

  & > * {
    pointer-events: all;
  }
`;
