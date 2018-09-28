create table Delphi_AdminTasks (
	uuid_ VARCHAR(75) null,
	adminTaskId LONG not null,
	userId LONG not null,
	systemAlert BOOLEAN,
	messageText VARCHAR(75) null,
	postOnPortBanner BOOLEAN,
	siteAlert BOOLEAN,
	siteName VARCHAR(75) null,
	companyId LONG,
	createdById LONG,
	createDate DATE null,
	modifiedDate DATE null,
	primary key (adminTaskId, userId)
);

create table Delphi_UserAccessRequest (
	uuid_ VARCHAR(75) null,
	requestId LONG not null primary key,
	userId LONG,
	companyId LONG,
	createdById LONG,
	createDate DATE null,
	modifiedDate DATE null,
	portletAccess VARCHAR(75) null,
	requestType VARCHAR(75) null,
	responseType VARCHAR(75) null,
	responseComment VARCHAR(75) null,
	responseUser LONG,
	activeState INTEGER
);

create table Delphi_UserProfile (
	uuid_ VARCHAR(75) null,
	profileId LONG not null primary key,
	userId LONG,
	companyId LONG,
	createdById LONG,
	createDate DATE null,
	modifiedDate DATE null,
	communicationPreferences VARCHAR(500) null,
	region VARCHAR(75) null,
	site VARCHAR(75) null,
	server VARCHAR(75) null,
	division VARCHAR(75) null,
	language VARCHAR(75) null,
	timezone VARCHAR(75) null,
	workHours VARCHAR(500) null,
	jobrole VARCHAR(500) null,
	interests VARCHAR(500) null,
	portlets VARCHAR(500) null
);