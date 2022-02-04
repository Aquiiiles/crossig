create table AP_Contact_City (
	cityId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	zipCode VARCHAR(75) null,
	boxNumber VARCHAR(75) null,
	postName VARCHAR(75) null
);

create table AP_Contact_Street (
	streetId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	externalId LONG,
	name VARCHAR(75) null,
	cityId LONG
);