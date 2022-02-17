create table AP_Proposal_Product (
	productId LONG not null primary key,
	name VARCHAR(75) null,
	externalId LONG
);

create table AP_Proposal_ProductRole (
	productRoleId LONG not null primary key,
	productId LONG,
	roleId LONG
);