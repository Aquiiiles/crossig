import styled from "styled-components";
import {Step} from "../../../types/stepper";

type StepState = Step["state"];

export const Wrapper = styled.div<{ state: StepState }>`

  & .step-icon {
    position: static !important;
    color: ${({ state, theme }) =>
    state === "ACTIVE"
        ? theme.color.primary.links
        : state === "COMPLETE" ? theme.color.neutral.stepComplete 
            : theme.color.neutral.dot};
        
    font-size: ${({state}) => 
    state === "COMPLETE" ? '70%' : '80%'};
  }  

`;
