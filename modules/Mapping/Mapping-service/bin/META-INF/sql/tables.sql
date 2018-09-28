create table DDTI_course (
	uuid_ VARCHAR(75) null,
	courseId LONG not null primary key,
	courseName VARCHAR(75) null,
	fee LONG,
	startDate DATE null,
	endDate DATE null,
	maxseats LONG,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table DDTI_location (
	uuid_ VARCHAR(75) null,
	locationId LONG not null primary key,
	locationName VARCHAR(75) null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table DDTI_location_course (
	companyId LONG not null,
	courseId LONG not null,
	locationId LONG not null,
	primary key (courseId, locationId)
);

create table DDTI_registrationDetails (
	uuid_ VARCHAR(75) null,
	registrationId LONG not null primary key,
	firstName VARCHAR(75) null,
	lastName VARCHAR(75) null,
	surName VARCHAR(75) null,
	address VARCHAR(75) null,
	contactNumber LONG,
	gender BOOLEAN,
	imagepath VARCHAR(75) null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table DDTI_registrationDetails_course (
	companyId LONG not null,
	courseId LONG not null,
	registrationId LONG not null,
	primary key (courseId, registrationId)
);