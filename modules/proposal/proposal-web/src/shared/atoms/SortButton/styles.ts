import styled from "styled-components";
import ClayButton from "@clayui/button";

export const Button = styled(ClayButton)`
  display: grid;
  place-items: center;
  width: 36px;
  height: 36px;
  border-radius: 6px;
  background-color: ${({ theme }) => theme.color.neutral.white};
`;
