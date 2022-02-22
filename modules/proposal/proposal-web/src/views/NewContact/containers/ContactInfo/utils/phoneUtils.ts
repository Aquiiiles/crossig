type RawPhoneObject = {
  areaCode: string;
  countryCode: string;
  phoneNumber: string;
  type: number;
};

type Phone = {
  countryDialCode: {
    id: number;
  };
  isPreferredDeliveryAddress: boolean;
  telephoneNumber: string;
  telephoneType: {
    id: number;
  };
};

export const phoneObjectToData = (phones: RawPhoneObject[]): Phone[] => {
  if (phones[0].phoneNumber === "") return [];

  return phones.map((phone, index) => {
    return {
      countryDialCode: {
        id: Number(phone.countryCode),
      },
      isPreferredDeliveryAddress: index === 0,
      telephoneNumber: `${phone.areaCode}${phone.phoneNumber}`,
      telephoneType: {
        id: phone.type,
      },
    };
  });
};
