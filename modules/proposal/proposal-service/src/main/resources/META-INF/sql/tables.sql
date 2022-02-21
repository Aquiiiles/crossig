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