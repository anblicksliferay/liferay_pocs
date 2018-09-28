create table Ashokleyland_Enquiry (
	uuid_ VARCHAR(75) null,
	Eid LONG not null primary key,
	FirstName VARCHAR(75) null,
	LastName VARCHAR(75) null,
	Email VARCHAR(75) null,
	ContactNumber VARCHAR(75) null,
	PartName VARCHAR(75) null,
	PartNumber VARCHAR(75) null,
	Message VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table Ashokleyland_UserExternal (
	uuid_ VARCHAR(75) null,
	uid LONG not null primary key,
	Location VARCHAR(75) null,
	PolicyNumber VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);