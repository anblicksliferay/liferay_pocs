create index IX_F136385F on DDTI_course (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_55F4AA1 on DDTI_course (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_AA3A6C79 on DDTI_location (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_9A35BD3B on DDTI_location (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_27F05E7 on DDTI_location_course (companyId);
create index IX_42EC666B on DDTI_location_course (courseId);
create index IX_F5E44C45 on DDTI_location_course (locationId);

create index IX_F3256DB9 on DDTI_registrationDetails (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_88700E7B on DDTI_registrationDetails (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_4B6A0727 on DDTI_registrationDetails_course (companyId);
create index IX_1BFC3D2B on DDTI_registrationDetails_course (courseId);
create index IX_B651D089 on DDTI_registrationDetails_course (registrationId);