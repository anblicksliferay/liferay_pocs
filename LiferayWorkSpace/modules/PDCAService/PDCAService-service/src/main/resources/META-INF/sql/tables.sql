create table astra_Foo (
	uuid_ VARCHAR(75) null,
	fooId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	field1 VARCHAR(75) null,
	field2 BOOLEAN,
	field3 INTEGER,
	field4 DATE null,
	field5 VARCHAR(75) null
);

create table astra_kpi (
	uuid_ VARCHAR(75) null,
	kpiId LONG not null primary key,
	companyName VARCHAR(75) null,
	tipe VARCHAR(75) null,
	weight VARCHAR(75) null,
	target VARCHAR(75) null,
	year VARCHAR(75) null,
	unit VARCHAR(75) null,
	achivementFormula VARCHAR(75) null,
	itemDescription VARCHAR(75) null,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);