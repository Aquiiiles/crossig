import styled from "styled-components";
import ClayButton from "@clayui/button";

export const Button = styled(ClayButton)`
  border: none;
  color: ${props => props.theme.color.neutral.white};
  background-color: ${props => props.theme.color.action.default};

`;
