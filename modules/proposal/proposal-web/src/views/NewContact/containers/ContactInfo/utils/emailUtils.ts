type EmailData = {
  email: string;
  emailType: {
    id: number;
  };
  isPreferredDeliveryAddress: boolean;
};
type Emails = EmailData[];

export const emailListToData = (emails: string[]): Emails => {
  if (emails[0] === "") return [];
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
