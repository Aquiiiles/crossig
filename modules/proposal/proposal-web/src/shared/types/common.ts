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

export type PolicyCoverageOption = {
  coverageOptionsName: string;
  coverageOptionsValue: string;
  type: string;
};

export type PolicyOptions = {
  communicationMethod: string;
  contractEndDate: Date;
  contractPeriod: string;
  contractStartDate: Date;
  currency: string;
  durationYear: number;
  issueDate: Date;
  policyEndDate: Date;
  policyNumberDays: number;
  policyStartDate: Date;
  productCategory: string;
  productExtNumber: string;
  termsDate: Date;
};

export type ProposalContact = {
  contactExtNumber: string;
  insuredRoles: string;
};

export type ProposalResponse = {
  agentUserId: number;
  companyId: number;
  externalProposalNumber: string;
  insuredObjectExtNumber: string;
  origin: string;
  policyCoverageOptions: Array<PolicyCoverageOption>;
  policyHolderExtNumber: string;
  policyOptions: PolicyOptions;
  proposalContacts: Array<ProposalContact>;
  proposalId: number;
  status: string;
  userId: number;
  userName: string;
};
