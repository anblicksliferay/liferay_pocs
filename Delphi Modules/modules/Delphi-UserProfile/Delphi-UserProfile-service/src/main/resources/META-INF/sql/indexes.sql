create index IX_3F167A12 on Delphi_AdminTasks (uuid_[$COLUMN_LENGTH:75$], companyId);

create index IX_956561AE on Delphi_UserAccessRequest (activeState);
create index IX_812DC147 on Delphi_UserAccessRequest (userId);
create index IX_28D8BEC1 on Delphi_UserAccessRequest (uuid_[$COLUMN_LENGTH:75$], companyId);

create index IX_5EB743D8 on Delphi_UserProfile (jobrole[$COLUMN_LENGTH:500$]);
create index IX_E7064DE5 on Delphi_UserProfile (userId);
create index IX_17989DDF on Delphi_UserProfile (uuid_[$COLUMN_LENGTH:75$], companyId);