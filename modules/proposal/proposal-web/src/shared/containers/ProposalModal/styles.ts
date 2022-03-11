import ClayModal from "@clayui/modal";
import styled from "styled-components";

export const StyledModal = styled(ClayModal)`
  .modal-header,
  .modal-title {
    background-color: ${(props) => props.theme.color.primary.main};
    border-color: ${(props) => props.theme.color.primary.main};
    color: ${(props) => props.theme.color.neutral.white};
    font-family: Crosig-Bold;
  }

  .lexicon-icon-info-circle {
    display: none;
  }
`;
