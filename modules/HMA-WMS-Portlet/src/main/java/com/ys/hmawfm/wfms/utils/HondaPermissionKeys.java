package com.ys.hmawfm.wfms.utils;


public interface HondaPermissionKeys {
  
	/*Action Keys Constants helpful for resolving the permissions*/
	public final static String ADD_RS_1="ADD_RS_1";
	public final static String ADD_RS_2 = "ADD_RS_2";
	public final static String ADD_RS_3 = "ADD_RS_3";
	public final static String SAVE_POS = "SAVE_POS";
	public final static String EDIT_POS = "EDIT_POS";
	public final static String VIEW_POS = "VIEW_POS";
	public final static String CLOSE_POS = "CLOSE_POS";
	public final static String RE_OPN_CLOSE_POS = "RE_OPN_CLOSE_POS";
	public final static String MOVE_ASSOCIATE = "MOVE_ASSOCIATE";
	public final static String SWAP_ASSOCIATE = "SWAP_ASSOCIATE";
	public final static String TERM_ASSOCIATE = "TERM_ASSOCIATE";
	public final static String MOVE_ASSOCIATE_TO_DRCT = "MOVE_ASSOCIATE_TO_DRCT";
	public final static String ADD_ASSOCIATE = "ADD_ASSOCIATE";
	public final static String APPROVE_DATA	= "APPROVE_DATA";														
	public final static String DIS_APPROVE_DATA = "DIS_APPROVE_DATA";
	public final static String MNG_CONF_DATA_ROLES = "MNG_CONF_DATA_ROLES";
	public final static String EDIT_SYS_POP_FLDS="EDIT_SYS_POP_FLDS";
	public final static String CRT_POS="CRT_POS";
	/*User role Constant for Honda WMS*/
	public final static String ROLE_DMP="DMP";
	public final static String ROLE_DM="DM";
	public final static String ROLE_SPDM="SPDM";
	public final static String ROLE_CMP="CMP";
	public final static String ROLE_WAITING_ON_COS="Waiting on COS";
	public final static String ROLE_STAFFING="Staffing";
	public final static String ROLE_PAYROLL="Payroll";
	public final static String ROLE_Administrator="Administrator";
	public final static String ROLE_Owner="Owner";
	public final static String ROLE_DVM="Division Manager";
	public final static String ROLE_HRDM="HR Department Manager";
	public final static String ROLE_OPS_LEADER="Ops Leader";
	//public final static String ROLE_SPBA="SP BA";
	public final static String ROLE_ARL_OA="ARLOA";
	public final static String ROLE_PR_Notify="PR Notify";
	

	
	/*Status Constants* ADD By ChandraMouli S /
	
	/*Position Constants*/
	public final static String POS_CLOSED="Closed";
	public final static String POS_OPEN = "Open";
	public final static String POS_PENDING = "Pending";
	public final static String POS_FILLED = "Filled";
	public final static String POS_DRAFT= "Draft";
	public final static String POS_MODFIED= "Modified";
	public final static String POS_CANCELLED= "Cancelled";
	public final static String POS_APPROVED= "Approved";
	
			
	
	/*Requuisition Constants*/
	public final static String REQ_DRAFT = "Draft";
	public final static String REQ_SUBMITTED = "Submitted";
	public final static String REQ_WAITINGONMANPOWER = "Waiting On Manpower";
	public final static String REQ_FILLEDBUTNOASSOCIATENUMBER = "Filled But No Associate Number";
	public final static String REQ_COMPLETE = "Complete";
	public final static String REQ_COMPLETE_PENDING_APPROVAL = "Complete Pending Approval";
	public final static String REQ_ONHOLD = "On Hold";
	public final static String REQ_CANCELLED = "Cancelled";
	public final static String REQ_SAVE = "save";
	
	/*Change  Of Status (COS)  Constants*/
	public final static String COS_DRAFT="Draft";
	public final static String COS_DISAPPROVED = "Disapproved";
	public final static String COS_SUBMIT = "Submitted";
	public final static String COS_APPROVED = "Approved";
	public final static String COS_CANCELLED = "Cancelled";
    public final static String COS_MODIFIED = "Modified";
    
    /*Change Of Status Approver Constants*/
    public final static String COS_CURRENT_DM = "current DM";
    public final static String COS_CURRENT_DVM = "current DVM"; //current DVM
    public final static String COS_NEW_DM = "new DM";
    public final static String COS_NEW_DVM = "new DVM";
    public final static String COS_CMP = "CMP";
    public final static String COS_SP_DM = "SP DM";
    public final static String COS_HR_DM = "HR DM";
    public final static String COS_OPS_LEADER = "Ops Leader";
    public final static String COS_ARL_OA = "AR LOA";
    public final static String ROLE_PR="PR";
	public final static String ROLE_CAC="CAC";
	
    public final static String POS_NOTE = "Note";
    public final static String COS_SYSTEM_GENERATE = "System Generate";
    
    public final static String SaveModify="SaveModify";
	
/*	Email Constants By chandraMOuli S*/
	
	public final static String EMAIL_FROM_NAME="Work Flow Management Of HMA ";
	public final static String EMAIL_FROM_MAIL="testproject1886@gmail.com";
	public final static String EMAIL_SUBJECT = "Subject for Work Flow Management Of HMA";
	public final static String EMAIL_CONTENT= "Email Content for Work Flow Management Of HMA ---Thanks Honda Team ";
	
	public final static String DMP_KEY="mpwrrep_user_name";
	public final static String DVM_KEY="dvmgr_user_name";
	public final static String DM_KEY="mgr_user_name";
	
	
}
