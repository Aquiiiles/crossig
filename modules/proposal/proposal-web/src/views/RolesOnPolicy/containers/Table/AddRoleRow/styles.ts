import styled from "styled-components";
import ClayTable from "@clayui/table";

export const Row = styled(ClayTable.Row)`
  background-color: ${(props) => props.theme.color.neutral.white};
  cursor: auto;
  width: 100%

  padding: 0.75rem 0.75rem 0.75rem 0.9375rem;

  p {
    margin-bottom: 0;
  }

  :hover {
    background-color: ${(props) => props.theme.color.neutral.white} !important;

    td: hover {
      background-color: ${(props) =>
        props.theme.color.neutral.white} !important;
    }
  }
`;
