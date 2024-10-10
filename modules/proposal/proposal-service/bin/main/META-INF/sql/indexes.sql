create index IX_66C3B906 on AP_Proposal_CoveragePlan (category[$COLUMN_LENGTH:75$]);
create index IX_6E13E253 on AP_Proposal_CoveragePlan (name[$COLUMN_LENGTH:75$]);

create index IX_3DE94DC3 on AP_Proposal_PolicyCoverageOpt (proposalId);

create unique index IX_C81497F6 on AP_Proposal_PolicyOptions (proposalId);

create index IX_A6839BB7 on AP_Proposal_Product (name[$COLUMN_LENGTH:75$]);

create index IX_84211573 on AP_Proposal_ProductRole (roleId);

create index IX_3C5D3BA6 on AP_Proposal_Proposal (agentUserId);

create index IX_1C793778 on AP_Proposal_ProposalContact (proposalId);