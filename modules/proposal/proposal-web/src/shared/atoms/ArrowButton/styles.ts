import styled from "styled-components";
import ClayButton from "@clayui/button";

interface Props {
  angleUp: boolean;
}

export const Button = styled(ClayButton)<Props>`
  transition: all 0.4s ease;
  transform: ${props => props.angleUp ? "rotate(180)" : ""}

  & svg {
    pointer-events: none;
  }
`;
