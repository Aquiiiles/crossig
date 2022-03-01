import styled from "styled-components";
import ClayTable from "@clayui/table";
import ClayButton from "@clayui/button";

export const Row = styled(ClayTable.Row)`
  background-color: ${(props) => props.theme.color.neutral.white};
`;

export const ViewDetailsBtn = styled(ClayButton)`
  margin-left: auto;
  margin-top: -0.1875rem;
`;

export const Wrapper = styled.div`
  display: flex;
`;
