import styled from "styled-components";
import { Step } from "../../../types/stepper";

type StepState = Step["state"];

export const Wrapper = styled.div`
  width: 100%;
`;

export const Dot = styled.span<{ state: StepState }>`
  height: ${({ state }) => (state === "ACTIVE" ? "0.625rem" : "0.375rem")};
  width: ${({ state }) => (state === "ACTIVE" ? "0.625rem" : "0.375rem")};
  background-color: ${({ state, theme }) =>
    state === "ACTIVE"
      ? theme.color.primary.links
      : theme.color.neutral.background};
  border-radius: 50%;
`;

export const OutterDot = styled.span`
  height: 0.875rem;
  width: 0.875rem;
  background-color: ${(props) => props.theme.color.neutral.white};
  border: 1px solid ${(props) => props.theme.color.primary.links};
`;
