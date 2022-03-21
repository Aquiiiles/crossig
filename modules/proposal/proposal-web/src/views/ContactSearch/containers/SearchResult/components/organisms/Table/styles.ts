import ClayTable from "@clayui/table";
import styled from "styled-components";

export const ResultsTable = styled(ClayTable)`
  td {
    cursor: pointer;
    vertical-align: baseline;
  }

  th:first-child {
    margin-left: 1rem;
    margin-top: 1rem;
  }
  
  & tr:hover .align-button-right {
    text-align: right;
  }

  & tr .collapsable-cell {
    display: block;
  }

  & tr:hover .collapsable-cell {
    display: none;
  }

  & tr .hovering-button {
    display: none;
  }

  & tr:hover .hovering-button {
    display: inline-block;
    white-space: nowrap;
  }
}
`;

export const Span = styled.span`
  margin-left: 2rem;
`;
