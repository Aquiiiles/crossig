// Common
export interface Country {
  label: string;
  value: string;
  flagKey: string;
}

export interface PhoneNumber {
  type: number;
  countryCode: string;
  areaCode: string;
  phoneNumber: string;
}

export type HeaderCell = {
  key: string;
  name: string;
  expanded: boolean;
  hasSpan: boolean;
};

export type FetchDataResultsFunction = () => void;

// Contact

export interface Country {
  label: string;
  value: string;
  flagKey: string;
}

export interface PhoneNumber {
  type: number;
  countryCode: string;
  areaCode: string;
  phoneNumber: string;
}

export interface Address {
  country: string;
  city: number;
  postalCode: string;
  street: string;
  houseNumber: string;
}

// Stepper
type StepState = "ACTIVE" | "INACTIVE" | "COMPLETE";

export interface Step {
  name: string;
  state: StepState;
  route: string;
}
