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