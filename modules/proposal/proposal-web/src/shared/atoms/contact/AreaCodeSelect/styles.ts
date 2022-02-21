import styled from "styled-components";
import { ClaySelect } from "@clayui/form";

export const StyledSelect = styled(ClaySelect)`
  option:disabled {
    color: ${props => props.theme.color.action.disabled};
  }

  .area-code-default-option {
    color: ${props => props.theme.color.neutral.neutralGreyText};
  }

  .area-code-option {
    color: ${props => props.theme.color.primary.links};
  }
`;
