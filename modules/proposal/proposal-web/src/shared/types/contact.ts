export interface Country {
  label: string;
  value: string;
  flagKey: string;
}

export interface PhoneNumber {
  type: string;
  countryCode: string;
  areaCode: string;
  phoneNumber: string;
}
