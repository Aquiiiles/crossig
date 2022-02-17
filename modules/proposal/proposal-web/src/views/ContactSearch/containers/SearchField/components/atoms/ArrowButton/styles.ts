import styled from "styled-components";
import ClayButton from "@clayui/button";

export const Button = styled(ClayButton)`
  position: absolute;
  right: 0.2rem;
  bottom: 0;
  transform: scale(0.8);

  & svg {
    pointer-events: none;
  }
`;
