import ClayModal from "@clayui/modal";
import styled from "styled-components";

type PropsType = {
  headerMargin: boolean;
};

export const StyledModal = styled(ClayModal)<PropsType>`
  .modal-body {
    padding: 0;
  }

  .modal-header {
    margin-left: ${(props: PropsType) => (props.headerMargin ? "15rem" : "0")};
  }

  .modal-header,
  .modal-title {
    background-color: ${(props) => props.theme.color.neutral.background};
    border-color: ${(props) => props.theme.color.neutral.background};
    pointer-events: none;
  }

  .close {
    pointer-events: all;
  }

  .lexicon-icon-info-circle {
    display: none;
  }
`;
