import ClayTable from "@clayui/table";
import styled from "styled-components";

export const Table = styled(ClayTable)`
  td {
    cursor: pointer;
  }

  th:first-child {
    margin-left: 1rem;
  }
`;

export const Span = styled.span`
  margin-left: 2rem;
`;

export const MobileWrapper = styled.div`
  display: none;
  flex-direction: column;

  @media ${({ theme }) => theme.breakpoint.tablet("down")} {
    display: flex;
  }
`;
