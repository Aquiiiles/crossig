create table AP_Proposal_CoveragePlan (
	coveragePlanId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	category VARCHAR(75) null
);

create table AP_Proposal_InsuredRole (
	InsuredRoleId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	title VARCHAR(75) null,
	name VARCHAR(75) null,
	externalId VARCHAR(75) null
);

create table AP_Proposal_PolicyCoverageOpt (
	policyCoverageOptionId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	proposalId LONG,
	coverageOptionsName VARCHAR(75) null,
	coverageOptionsValue VARCHAR(75) null,
	type_ VARCHAR(75) null
);

create table AP_Proposal_PolicyOptions (
	policyOptionsId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	proposalId LONG,
	currency_ VARCHAR(75) null,
	termsDate DATE null,
	productCategory VARCHAR(75) null,
	productExtNumber VARCHAR(75) null,
	issueDate DATE null,
	contractStartDate DATE null,
	contractEndDate DATE null,
	contractPeriod VARCHAR(75) null,
	durationYear INTEGER,
	policyStartDate DATE null,
	policyEndDate DATE null,
	policyNumberDays INTEGER,
	communicationMethod VARCHAR(75) null
);

create table AP_Proposal_Product (
	productId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	externalId LONG,
	active_ BOOLEAN,
	description VARCHAR(75) null,
	category VARCHAR(75) null
);

create table AP_Proposal_ProductRole (
	productRoleId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	productId LONG,
	roleId LONG
);

create table AP_Proposal_Proposal (
	proposalId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	externalProposalNumber VARCHAR(75) null,
	lastUpdate DATE null,
	origin VARCHAR(75) null,
	agentUserId LONG,
	policyHolderExtNumber VARCHAR(75) null,
	insuredObjectExtNumber VARCHAR(75) null,
	status VARCHAR(75) null
);

create table AP_Proposal_ProposalContact (
	proposalContactId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	proposalId LONG,
	contactExtNumber VARCHAR(75) null,
	insuredRoles VARCHAR(75) null
);