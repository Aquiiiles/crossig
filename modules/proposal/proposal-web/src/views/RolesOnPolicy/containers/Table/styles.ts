import ClayTable from "@clayui/table";
import styled from "styled-components";

export const Wrapper = styled.div`
  box-shadow: 0px 2px 7px rgba(12, 61, 157, 0.24);
  border-top: 1px solid ${(props) => props.theme.color.neutral.dividerGrey};
`;

export const ResultsTable = styled(ClayTable)`
  margin-bottom: 0;

  th {
    font-weight: unset;
    color: #79838c;
  }

  tr:last-child {
    background-color: ${(props) => props.theme.color.neutral.white};

    &:hover {
      background-color: ${(props) => props.theme.color.neutral.white};
    }
  }

  .sub-header-cell {
    white-space: nowrap;
  }
`;
