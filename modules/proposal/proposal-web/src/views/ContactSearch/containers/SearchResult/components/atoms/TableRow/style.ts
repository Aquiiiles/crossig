import styled from "styled-components";
import ClayTable from "@clayui/table";

export const StyledRow = styled(ClayTable.Row)`
  .no-wrap {
    white-space: nowrap;
  }
`;

export const HoveringButtonGroup = styled.div`
  pointer-events: none;
  padding: 0.25rem;
  display: grid;
  grid-template-columns: repeat(2, max-content);
  justify-content: end;
  align-content: center;
  column-gap: 0.625rem;
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  z-index: 5;
  background: transparent;

  & > * {
    pointer-events: all;
  }
`;
