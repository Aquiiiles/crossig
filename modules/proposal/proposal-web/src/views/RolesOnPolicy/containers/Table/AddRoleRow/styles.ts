import styled from "styled-components";
import ClayTable from "@clayui/table";

export const Row = styled(ClayTable.Row)`
  background-color: ${(props) => props.theme.color.neutral.white};
  cursor: auto;
  width: 100%

  padding: 0.75rem 0.75rem 0.75rem 0.9375rem;

  p {
    margin-bottom: 0;

    &.add-role{
      color: ${(props) => props.theme.color.primary.links};
    }
  }

  :hover {
    background-color: ${(props) => props.theme.color.neutral.white} !important;
  }
`;
