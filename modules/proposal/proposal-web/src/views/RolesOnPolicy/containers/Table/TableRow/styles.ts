import styled from "styled-components";
import ClayTable from "@clayui/table";
import ClayButton from "@clayui/button";

interface Props {
  showDetails: boolean;
}

export const Row = styled(ClayTable.Row)`
  background-color: ${(props) => props.theme.color.neutral.white};
`;

export const ViewDetailsBtn = styled(ClayButton)<Props>`
  margin-left: auto;
  margin-top: -0.1875rem;
  z-index: ${(props) => (props.showDetails ? "2" : "-2")};
  white-space: nowrap;
  height: fit-content;
`;

export const Wrapper = styled.div`
  display: flex;
`;
