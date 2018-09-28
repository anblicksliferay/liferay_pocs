create table Astra_Registration (
	uuid_ VARCHAR(75) null,
	RegistrationId LONG not null primary key,
	firstname VARCHAR(75) null,
	lastname VARCHAR(75) null,
	course VARCHAR(75) null,
	email VARCHAR(75) null,
	location VARCHAR(75) null,
	status VARCHAR(75) null,
	comments VARCHAR(75) null,
	Workflowstepnumber VARCHAR(75) null,
	WorkflowId VARCHAR(75) null,
	CurrentApprover TEXT null,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table Astra_WorkFlowConfig (
	uuid_ VARCHAR(75) null,
	WfcId LONG not null primary key,
	ConfigKey VARCHAR(75) null,
	Content TEXT null,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);