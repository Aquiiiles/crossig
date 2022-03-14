import ClayModal from "@clayui/modal";
import styled from "styled-components";

export const StyledModal = styled(ClayModal)`
  .cap {
    pointer-events: none;
  }

  .modal-body {
    padding: 0;
  }

  .modal-header {
    margin-left: 15rem;
  }

  .modal-header,
  .modal-title {
    background-color: ${(props) => props.theme.color.neutral.background};
    border-color: ${(props) => props.theme.color.neutral.background};
    color: ${(props) => props.theme.color.neutral.white};
    font-family: Crosig-Bold;
    pointer-events: none;
  }

  .close {
    pointer-events: all;
  }

  .lexicon-icon-info-circle {
    display: none;
  }
`;
