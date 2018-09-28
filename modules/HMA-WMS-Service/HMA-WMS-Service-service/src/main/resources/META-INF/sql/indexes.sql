create index IX_BC2888D on WFMS_COS (action[$COLUMN_LENGTH:75$]);
create index IX_AA27AD12 on WFMS_COS (assoicateId[$COLUMN_LENGTH:75$]);
create index IX_2ABEE6F on WFMS_COS (cosId[$COLUMN_LENGTH:75$]);
create index IX_F055407F on WFMS_COS (newPositionNumber[$COLUMN_LENGTH:75$]);
create index IX_32C7CCEF on WFMS_COS (nextApprover[$COLUMN_LENGTH:9000$]);
create index IX_E1843C29 on WFMS_COS (positionNumber[$COLUMN_LENGTH:75$]);
create index IX_573FB129 on WFMS_COS (roleOfApprover[$COLUMN_LENGTH:75$]);
create index IX_BD135B49 on WFMS_COS (status[$COLUMN_LENGTH:75$]);

create index IX_22C414F3 on WFMS_COS_Audit (cosId[$COLUMN_LENGTH:75$]);

create index IX_C63351FB on WFMS_Config (configKey[$COLUMN_LENGTH:75$]);

create index IX_58701AD1 on WFMS_NA_Support (ASSOCIATE_NUMBER[$COLUMN_LENGTH:75$]);

create index IX_9F92090C on WFMS_NotificationEngine (content[$COLUMN_LENGTH:75$]);
create index IX_530D20E6 on WFMS_NotificationEngine (contentType[$COLUMN_LENGTH:75$]);
create index IX_FD3EBC32 on WFMS_NotificationEngine (createdBy[$COLUMN_LENGTH:75$]);
create index IX_C972EF6B on WFMS_NotificationEngine (title[$COLUMN_LENGTH:75$]);

create index IX_65221FFE on WFMS_Position (associateNumber[$COLUMN_LENGTH:75$]);
create index IX_8616E8F1 on WFMS_Position (autoGenerateReq[$COLUMN_LENGTH:75$]);
create index IX_664F5DCB on WFMS_Position (category[$COLUMN_LENGTH:75$]);
create index IX_EAB91716 on WFMS_Position (createdBy[$COLUMN_LENGTH:75$]);
create index IX_8CD5CA on WFMS_Position (departmentName[$COLUMN_LENGTH:75$]);
create index IX_77AAEA9F on WFMS_Position (dummy[$COLUMN_LENGTH:75$]);
create index IX_A1783FA5 on WFMS_Position (nextApprover[$COLUMN_LENGTH:9000$]);
create index IX_EF89AB6D on WFMS_Position (number_[$COLUMN_LENGTH:75$]);
create index IX_BEA44C22 on WFMS_Position (pId[$COLUMN_LENGTH:75$]);
create index IX_10479B09 on WFMS_Position (refPosId[$COLUMN_LENGTH:75$]);
create index IX_FA4DAF91 on WFMS_Position (reportsTo[$COLUMN_LENGTH:75$]);
create index IX_4AE58E7F on WFMS_Position (status[$COLUMN_LENGTH:75$]);
create index IX_539A1447 on WFMS_Position (workflowId[$COLUMN_LENGTH:75$]);

create index IX_BD323426 on WFMS_Position_Audit (pId[$COLUMN_LENGTH:75$]);

create index IX_B1B1BC22 on WFMS_Requisition (Number[$COLUMN_LENGTH:75$], associatenumber[$COLUMN_LENGTH:75$]);
create index IX_EBCE2720 on WFMS_Requisition (dummy[$COLUMN_LENGTH:75$]);
create index IX_98851A72 on WFMS_Requisition (nextapprove[$COLUMN_LENGTH:10000$]);
create index IX_FDAE3E5 on WFMS_Requisition (rId[$COLUMN_LENGTH:75$]);
create index IX_AE6092FE on WFMS_Requisition (roleOfApprover[$COLUMN_LENGTH:75$]);
create index IX_D35BC534 on WFMS_Requisition (rwfId[$COLUMN_LENGTH:75$]);
create index IX_87EDBCBF on WFMS_Requisition (status[$COLUMN_LENGTH:75$], rId[$COLUMN_LENGTH:75$]);
create index IX_3C3D8066 on WFMS_Requisition (workflowId[$COLUMN_LENGTH:75$]);

create index IX_FF9A5ED5 on WFMS_Requisition_Audit (reqId[$COLUMN_LENGTH:75$]);

create index IX_3A5D1DBC on WFMS_WorkflowConfig (configKey[$COLUMN_LENGTH:75$]);

create index IX_D7D84A3F on WFMS_action_and_reasoncode (aarId[$COLUMN_LENGTH:75$]);

create index IX_C3832783 on WFMS_routing_and_approvers (rapId[$COLUMN_LENGTH:75$]);