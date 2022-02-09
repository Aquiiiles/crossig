import styled from "styled-components";
import { ClaySelectWithOption } from "@clayui/form";

export const ButtonWrapper = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: center;
`;

export const StyledClaySelectWithOption = styled(ClaySelectWithOption)`
  .form-control-select {
    background-image: clay-icon(caret-bottom, #000000);
  }
`;