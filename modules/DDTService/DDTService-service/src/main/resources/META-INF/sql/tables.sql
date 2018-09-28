create table WDDTS_FAQSAshok (
	uuid_ VARCHAR(75) null,
	id_ LONG not null primary key,
	FAQSContent VARCHAR(75) null
);

create table WDDTS_Loc_Course_Info (
	uuid_ VARCHAR(75) null,
	id_ LONG not null primary key,
	locationId LONG,
	couserId LONG,
	locationName VARCHAR(75) null,
	couserName VARCHAR(75) null,
	maxSeats LONG,
	toDate DATE null,
	fromDate DATE null,
	Fees LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table WDDTS_NewsAshok (
	uuid_ VARCHAR(75) null,
	id_ LONG not null primary key,
	Newscontent VARCHAR(75) null
);

create table WDDTS_TestimonialAshok (
	uuid_ VARCHAR(75) null,
	id_ LONG not null primary key,
	TestimonialContent VARCHAR(75) null
);