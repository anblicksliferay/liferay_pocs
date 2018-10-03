create index IX_B1F9574A on astra_Foo (field2);
create index IX_60D557D2 on astra_Foo (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_8915AAD4 on astra_Foo (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_54F077D0 on astra_kpi (uuid_[$COLUMN_LENGTH:75$], companyId);