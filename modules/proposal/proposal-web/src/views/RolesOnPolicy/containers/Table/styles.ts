import ClayTable from "@clayui/table";
import styled from "styled-components";

export const ResultsTable = styled(ClayTable)`
  th:first-child {
    padding-left: 2rem;
  }

  tr:last-child {
    background-color: ${(props) => props.theme.color.neutral.white};

    &:hover {
      background-color: ${(props) => props.theme.color.neutral.white};
    }
  }
`;
