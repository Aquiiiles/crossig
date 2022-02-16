interface FetchDataProps {
  city?: string;
  contactType?: string;
}

export type FetchContactsFunction = ({
  city,
  contactType,
}: FetchDataProps) => void;
