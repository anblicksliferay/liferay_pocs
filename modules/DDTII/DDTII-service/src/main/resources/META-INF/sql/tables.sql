create table DDTII_category (
	categoryId LONG not null primary key,
	categoryName VARCHAR(75) null,
	courseId LONG,
	locationId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table DDTII_course (
	courseId LONG not null primary key,
	courseName VARCHAR(75) null,
	locationId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table DDTII_loc_cou_cat (
	loc_cou_catId LONG not null primary key,
	categoryId LONG,
	courseId LONG,
	locationId LONG,
	durationString VARCHAR(75) null,
	durationLong LONG,
	startDate_ DATE null,
	endDate_ DATE null,
	maxSeats LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table DDTII_location (
	locationId LONG not null primary key,
	locationName VARCHAR(75) null,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);