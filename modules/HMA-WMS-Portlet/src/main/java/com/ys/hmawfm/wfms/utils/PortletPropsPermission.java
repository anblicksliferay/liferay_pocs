package com.ys.hmawfm.wfms.utils;

public interface PortletPropsPermission {

	public final static String CRT_POS_ROLES="resource.permission.create.position.roles";
	public final static String CRT_POS_DPRT_ROLES="resource.permission.position.department.role";
	public final static String CACHE_KEY="CACHE_KEY";
	public final static String CACHE_NAME="resource.permission.position.department.role";
	public final static String GLBL_ROLES="resource.permission.global.roles";
	
	public final static String REQ_IMP_DAT="resource.permission.requisition.import.requisition.data";
	public final static String REQ_VIEW_REQ="resource.permission.requisition.view.requisition";
	public final static String REQ_CRT_REQ="resource.permission.requisition.create.requisitions";
	public final static String REQ_SBMT_REQ="resource.permission.requisition.submit.requisition";
	public final static String REQ_DIS_APPR_REQ ="resource.permission.create.req.approve.step.";
	public final static String REQ_APPRV_REQ="resource.permission.create.req.approve.step.";
	public final static String REQ_CNCL_REQ="resource.permission.requisition.cancel.requisition";
	public final static String REQ_CMPLT_REQ="resource.permission.requisition.complete.requisition";
	public final static String REQ_MNG_CNFG_DATA="resource.permission.requisition.manage.configurable.data";
	public final static String REQ_EDIT_REQ="resource.permission.requisition.edit.requisition";
	public final static String REQ_FILL_REQ="resource.permission.requisition.fill.requisition";
	public final static String REQ_SUBMIT_REQ="resource.permission.create.req.submit.step.";
	public final static String COS_CRT ="resource.permission.cos.create";
	public final static String COS_VIEW ="resource.permission.cos.view";
	/*public final static String COS_VIEW_DEPT ="resource.permission.cos.view.dept";*/
	public final static String COS_EDIT_COMMENTS ="resource.permission.cos.edit.comments.effictiveDate";
	public final static String COS_EDIT ="resource.permission.cos.edit";
	public final static String COS_SAVE ="resource.permission.cos.save";
	public final static String COS_OVRD_APRV ="resource.permission.cos.ovrd.aprv";
	public final static String COS_APRV ="resource.permission.cos.approve";
	/*public final static String COS_APRV_DEPT ="resource.permission.cos.approve.dept";*/
	public final static String COS_DIS_APRV ="resource.permission.cos.disapprove";
	/*public final static String COS_DIS_DEPT ="resource.permission.cos.disapprove.dept";*/
	public final static String COS_CNF_DATA ="resource.permission.cos.mng.cnf.data";
	public final static String COS_DEPT_ROLES ="resource.permission.cos.dept.roles";
	
	public final static String POS_MOD_APRV_CONT ="resource.permission.modify.pos.step.";
	
	public final static String POS_RS1="resource.permission.pos.rs1";
	public final static String POS_RS2="resource.permission.pos.rs2";
	public final static String POS_RS3="resource.permission.pos.rs3";
	public final static String POS_SAVE="resource.permission.pos.save";
	public final static String POS_EDIT="resource.permission.pos.edit";
	public final static String POS_VIEW="resource.permission.pos.view";
	public final static String POS_CLOSE="resource.permission.pos.close";
	public final static String POS_REOPEN="resource.permission.pos.reopen";
	public final static String POS_MOV_ASS="resource.permission.pos.move.associate";
	public final static String POS_SWAP_ASS="resource.permission.pos.swap.associate";
	public final static String POS_TER_ASS="resource.permission.pos.terminate.associate";
	public final static String POS_ADD_ASS="resource.permission.pos.add.associate";
	
	public final static String BTN_ADD_DATA="resource.permission.pos.add.button.step.";
	public final static String BTN_APRV_BTN="resource.permission.create.pos.approve.step.";
	public final static String BTN_YES="resource.permission.modify.pos.notify.";
	
	//added By ChandraMouli for button visablity to add Data button in draft status
	public final static String REQ_DRAFT_REQ="resource.permission.requisition.draft.requisition";
	public final static String 	REQ_SUBMIT_EDIT_REQ="resource.permission.requisition.submit_req.requisition";
	public final static String REQ_DIS_APPR_REQ_COMP ="resource.permission.create.req.approve.comp.step.";
	public final static String REQ_DIS_APPR_REQ_CMP_SPDM_HIDE="resource.permission.requisition.edit.requisition.wating.filledbut";
	public final static String ASSOCIATE_SAVE="resource.permission.associate.edit.associate.save";
	public final static String MODIFY_POSITION="resource.permission.modifiposition.cc_code.visable";
	public final static String NOTDM_POSITION ="resource.permission.modifiposition.cc_code.visable_notdm";

	//resource.permission.modifiposition.cc_code.visable_notdm
	public final static String REQ_FILLED_BUT_NO_ASSOCIATENUMBER="resource.permission.requisition.edit.requisition.filled.with.noassociate.number";
	public final static String COS_APPROVAL_PROCESS="resource.permission.cos.approval.process";
	public final static String REQ_VIEW_REQ_GRID="resource.permission.requisition.view.requisition.grid";
	public final static String COS_MODIFY_BUTTON="resource.permission.cos.modify.button.roles";
}