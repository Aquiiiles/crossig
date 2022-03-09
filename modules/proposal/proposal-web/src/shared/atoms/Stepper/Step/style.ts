import { Step } from "../../../types/stepper";
import styled from "styled-components";

type StepState = Step["state"];

export const Wrapper = styled.div`
  display: grid;
  align-items: center;
  grid-template-columns: 3px 1fr;
  grid-template-rows: 3.5rem;
  column-gap: 0.6875rem;
`;

export const InnerWrapper = styled.div`
  display: grid;
  align-items: baseline;
  grid-template-columns: 15px 100%;
  grid-template-rows: auto;
  column-gap: 0.6875rem;
`;

export const SubStepWrapper = styled.div`
  padding-left: 0.5rem;
`;

export const ActiveBar = styled.div<{ state: StepState }>`
  align-self: stretch;
  background-color: ${({ state, theme }) =>
    state === "ACTIVE" ? theme.color.primary.links : "transparent"};
`;

export const Text = styled.h6<{ state: StepState }>`
  margin-bottom: 0;
  color: ${({ state, theme }) =>
    state === "ACTIVE"
      ? theme.color.primary.links
      : state === "COMPLETE"
      ? theme.color.neutral.black
      : theme.color.neutral.dividerGrey};

  cursor: ${({ state }) =>
    ["ACTIVE", "INACTIVE"].includes(state) ? "text" : "pointer"};
`;
