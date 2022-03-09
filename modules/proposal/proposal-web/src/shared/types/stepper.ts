type StepState = "ACTIVE" | "INACTIVE" | "COMPLETE";

export interface Step {
  name: string;
  state: StepState;
  route: string;
}
