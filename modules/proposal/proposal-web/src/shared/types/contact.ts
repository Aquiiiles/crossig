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
  country: string,
  city: number,
  postalCode: string,
  street: string,
  houseNumber: string,
}