import styled from "styled-components";
import ClayTable from "@clayui/table";

export const Row = styled(ClayTable.Row)`
  background-color: ${props => props.theme.color.neutral.white};
`;
