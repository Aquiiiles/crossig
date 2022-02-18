type EmailData = {
  email: string;
  emailType: {
    id: number;
  };
  isPreferredDeliveryAddress: boolean;
};
type Emails = EmailData[];

export const emailListToData = (emails: string[]): Emails => {
  return emails.map((email, index) => {
    return {
      email,
      emailType: {
        id: 1,
      },
      isPreferredDeliveryAddress: index === 0,
    };
  });
};
