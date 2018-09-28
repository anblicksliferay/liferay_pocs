create table Book (
	bookId LONG not null primary key,
	bookName VARCHAR(75) null,
	description VARCHAR(75) null,
	authorName VARCHAR(75) null,
	isbn INTEGER,
	price INTEGER
);

create table Data (
	DataId LONG not null primary key,
	StartDate DATE null,
	EndDate DATE null,
	Exported INTEGER,
	NotExported INTEGER
);