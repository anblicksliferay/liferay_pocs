create table LeyKart_Testmonials (
	uuid_ VARCHAR(75) null,
	testmonialsId LONG not null primary key,
	fullname VARCHAR(75) null,
	imagepath VARCHAR(1000) null,
	message TEXT null,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);