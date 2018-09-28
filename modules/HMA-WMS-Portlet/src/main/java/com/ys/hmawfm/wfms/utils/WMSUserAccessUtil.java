package com.ys.hmawfm.wfms.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.json.JSONException;

import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.configuration.ConfigurationFactoryUtil;
import com.liferay.portal.kernel.exception.NoSuchRoleException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.ys.hmawfm.wfms.services.model.WFMS_COS;
import com.ys.hmawfm.wfms.services.model.WFMS_Position;
import com.ys.hmawfm.wfms.services.rest.CostCenterService;
import com.ys.hmawfm.wfms.services.service.WFMS_COSLocalServiceUtil;
import com.ys.hmawfm.wfms.services.service.WFMS_PositionLocalServiceUtil;
import com.ys.hmawfm.wfms.services.sql.HMAAssociateInfoService;

public class WMSUserAccessUtil {
	/**
	 * 
	 * @param user
	 * @param companyId
	 * @param accessCategory
	 * @param actionType
	 * @param userIsSameDepartment
	 * @param userIsDepartmentManager
	 * @param userIsDepartmentManpower
	 * @return
	 */
	
	private static	Configuration configuration = ConfigurationFactoryUtil.getConfiguration(PortalClassLoaderUtil.getClassLoader(), "portlet");
	public static boolean doesUserHaveAccess(	User user, long companyId, String accessCategory, String actionType,
												boolean userIsSameDepartment, boolean userIsDepartmentManager, boolean userIsDepartmentManpower) {
		
		//_log.info("doesUserHaveAccess is called for "+accessCategory+" > "+ actionType);
		if( isAdmin(user.getUserId(), companyId) ) return true;

		if(accessCategory.equalsIgnoreCase("position")) {
			return doesUserHavePositionAccess( user, companyId, actionType,
											   userIsSameDepartment, userIsDepartmentManager, userIsDepartmentManpower);
		}else if(accessCategory.equalsIgnoreCase("requisition")){
			return doesUserHaveRequisitionAccess( 	user, companyId, actionType,
													userIsSameDepartment, userIsDepartmentManager, userIsDepartmentManpower);
		}else if(accessCategory.equalsIgnoreCase("changeofstatus")){
			return doesUserHaveChangeOfStatusAccess( user, companyId, actionType,
			   	   userIsSameDepartment, userIsDepartmentManager, userIsDepartmentManpower);
		}
		return false;
	}
	
	/**
	 * 
	 * @param user
	 * @param companyId
	 * @param actionType
	 * @param userIsSameDepartment
	 * @param userIsDepartmentManager
	 * @param userIsDepartmentManpower
	 * @return boolean
	 */
	public static boolean doesUserHavePositionAccess( User user, long companyId, String actionType,
													 boolean userIsSameDepartment, boolean userIsDepartmentManager, boolean userIsDepartmentManpower){
		
		List<String> groupARoles = new ArrayList<String>();
		List<String> groupBRoles = new ArrayList<String>();
		List<String> groupDRoles = new ArrayList<String>();
		List<String> groupERoles = new ArrayList<String>();
		
		// An option would be to replace this entire conditional with a lookup table. Below is a quicker solution that works.
		
		if(actionType.equals("add1stSet")) {
			groupARoles = Arrays.asList("CMP","SPDM");
		} else if(actionType.equals("editFields")) {
			
		} else if(actionType.equals("add2ndSet")) {
			groupARoles = Arrays.asList("CMP","SPDM");
			groupBRoles = Arrays.asList("DM","DMP");
		} else if(actionType.equals("add3rdSet")) {
			groupARoles = Arrays.asList("CMP","SPDM","Staffing","Payroll");
		} else if(actionType.equals("savePosition")) {
			groupARoles = Arrays.asList("CMP","SPDM","Staffing","Payroll");
			groupBRoles = Arrays.asList("DM","DMP");
		} else if(actionType.equals("editPosition")) {
			groupARoles = Arrays.asList("CMP","SPDM","Staffing","Payroll");
			groupBRoles = Arrays.asList("DM","DMP");
		} else if(actionType.equals("viewPosition")) {
			groupARoles = Arrays.asList("CMP","SPDM","Staffing","Payroll","DM","DMP");
		} else if(actionType.equals("closePosition")) {
			groupARoles = Arrays.asList("CMP","SPDM");
			groupBRoles = Arrays.asList("DM","DMP");
		} else if(actionType.equals("reopenPosition")) {
			groupARoles = Arrays.asList("CMP","SPDM");
		} else if(actionType.equals("moveAssociate")) {
			groupARoles = Arrays.asList("CMP","SPDM");
			groupBRoles = Arrays.asList("DM","DMP");
		} else if(actionType.equals("swapAssociate")) {
			groupARoles = Arrays.asList("CMP","SPDM");
			groupBRoles = Arrays.asList("DM","DMP");
		} else if(actionType.equals("terminiateAssociate")) {
			groupARoles = Arrays.asList("CMP","SPDM");
			groupBRoles = Arrays.asList("DM","DMP");
		} else if(actionType.equals("moveAssociateToDirect")) {
			
		} else if(actionType.equals("addAssociate")) {
			groupARoles = Arrays.asList("CMP","SPDM");
			groupBRoles = Arrays.asList("DM","DMP");
		} else if(actionType.equals("manageConfigurableDataRoles")) {
			groupARoles = Arrays.asList("CMP","SPDM");
		} else if(actionType.equals("approveData")) {
			groupDRoles = Arrays.asList("DMP","Staffing","Payroll");
			groupERoles = Arrays.asList("CMP","SPDM");
		} else if(actionType.equals("disapproveData")) {
			groupDRoles = Arrays.asList("DMP","Staffing","Payroll");
			groupERoles = Arrays.asList("CMP","SPDM");
		}
		
		if( ( userIsSameDepartment && userIsDepartmentManager  && groupBRoles.contains("DM")  ) ||
			( userIsSameDepartment && userIsDepartmentManpower && groupBRoles.contains("DMP") ) ){
			//_log.info("User is a DM/DMP for this department and the action allows access.");
				return true;
		}
		
		if(userhasRolefromList(groupARoles, user.getUserId(), companyId)){
			return true;
		}
		
		return false; 
	}

	/**
	 * 
	 * @param user
	 * @param companyId
	 * @param actionType
	 * @param userIsSameDepartment
	 * @param userIsDepartmentManager
	 * @param userIsDepartmentManpower
	 * @return boolean
	 */
	public static boolean doesUserHaveRequisitionAccess( User user, long companyId, String actionType,
													 	 boolean userIsSameDepartment, boolean userIsDepartmentManager, boolean userIsDepartmentManpower){
		//Requires Team Development
		return false;
	}
	
	/**
	 * 
	 * @param user
	 * @param companyId
	 * @param actionType
	 * @param userIsSameDepartment
	 * @param userIsDepartmentManager
	 * @param userIsDepartmentManpower
	 * @return boolean
	 */
	public static boolean doesUserHaveChangeOfStatusAccess( User user, long companyId, String actionType,
			 												boolean userIsSameDepartment, boolean userIsDepartmentManager, boolean userIsDepartmentManpower){
		//Requires Team Development
		return false;
	}

	/**
	 * 
	 * @param wfmRoles
	 * @param userId
	 * @param companyId
	 * @return boolean
	 */
	public static boolean userhasRolefromList(List<String> wfmRoles, long userId, long companyId){
		
		for(String wfmRole : wfmRoles){
			try{
				if( UserLocalServiceUtil.hasRoleUser(companyId, wfmRole, userId, true) ){
					//System.out.print("User has inherited role " + wfmRole + ", returning true.");
					return true;
				}
			}catch( PortalException portalEx ){
				_log.error("WMSUserAccessUtil.userhasRolefromList()-PortalException thrown.",portalEx);
			}catch( SystemException systemEx ){
				_log.error("WMSUserAccessUtil.userhasRolefromList()-SystemException thrown.",systemEx);
			}
		}
		return false;
		
	}
	
	/**
	 * 
	 * @param userId
	 * @param companyId
	 * @return boolean
	 */
	public static boolean isAdmin(long userId,long companyId){
		boolean isAdmin = false;
		try {
			isAdmin = UserLocalServiceUtil.hasRoleUser(companyId, "Administrator", userId, true);
			
			if(!isAdmin){
				List<Role> userGroupRoles = RoleLocalServiceUtil.getUserGroupRoles(userId, companyId);

				for(Role userGroupRole : userGroupRoles){
					if(!isAdmin && userGroupRole.getName().equalsIgnoreCase("Site Administrator")){
						isAdmin = true;
					}
				}
			}
		} catch (NoSuchRoleException nsrex) {
			_log.error("WMSUserAccessUtil.isAdmin()-NoSuchRoleException thrown.",nsrex);
		} catch (Exception ex) {
			_log.error("WMSUserAccessUtil.isAdmin()-Exception thrown.",ex);
		}
		//_log.info("User is an admin? " + ((isAdmin)?"Yes":"No"));
		return isAdmin;
	}
	
	public static boolean checkPermissionForPosition(
			PortletRequest aPortletRequest, String aActionId,
			String positionsDepNo) throws PortalException, SystemException,
			 IOException, JSONException {
		boolean hasPermission = false;
		ThemeDisplay themeDisplay = (ThemeDisplay) aPortletRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		hasPermission=checkPermission(aPortletRequest, aActionId);
	//	_log.info(aActionId+" ::::: Init Permissions ::::>>> "+hasPermission);
		User user = themeDisplay.getUser();
		if (!hasPermission) {
			if (Validator.isNotNull(positionsDepNo)) {
					hasPermission =  HMAAssociateInfoService.getDepartmentNoByAssociateId(positionsDepNo,user.getScreenName(), positionsDepNo);
			 String[] roles=StringUtil.split(configuration.get(aActionId),StringPool.COMMA);
			 boolean hasDMP=ArrayUtil.contains(roles,HondaPermissionKeys.ROLE_DMP);
			 boolean hasDM=ArrayUtil.contains(roles,HondaPermissionKeys.ROLE_DM);
				 if(hasDMP){
					 hasPermission =  HMAAssociateInfoService
								.getDepartmentNoByAssociateId(positionsDepNo,user.getScreenName(),HondaPermissionKeys.DMP_KEY);
				 }
				 if(hasDM && !hasPermission){
					 hasPermission =  HMAAssociateInfoService
								.getDepartmentNoByAssociateId(positionsDepNo,user.getScreenName(),HondaPermissionKeys.DM_KEY);
				 }
			} 
		}
	//	_log.info("User with name : " + themeDisplay.getUser().getFullName()+ " have permission for Position ? " + hasPermission);
		return hasPermission;
		
		
	}
	
   
   /*checking permission for approve disapprove data*/
   public static boolean checkPermissionForData(PortletRequest aPortletRequest,String aActionId,String positionsId) throws PortalException, SystemException,  IOException{
	   boolean hasPermission=false;
	    ThemeDisplay themeDisplay=(ThemeDisplay)aPortletRequest.getAttribute(WebKeys.THEME_DISPLAY);
	    PortletDisplay portletDisplay=themeDisplay.getPortletDisplay();
	    String name = portletDisplay.getRootPortletId();
		String primKey = portletDisplay.getResourcePK();
		long groupId =themeDisplay.getScopeGroupId();
		User user=themeDisplay.getUser();
		PermissionChecker permissionChecker=themeDisplay.getPermissionChecker();
		
		hasPermission=permissionChecker.hasPermission(groupId, name, primKey, aActionId) ;
		if(false){
			/*Need to check code for permissions in Queue or not*/
			
			
		}
		
	   return hasPermission;
   }
	
   public static boolean checkPermission(PortletRequest aPortletRequest,String aActionId) throws PortalException, SystemException,  IOException{
	   
	   String roles=configuration.get(aActionId);
	   String[] rolesArray=StringUtil.split(roles,StringPool.COMMA) ;
	   ThemeDisplay themeDisplay=(ThemeDisplay)aPortletRequest.getAttribute(WebKeys.THEME_DISPLAY);
	   boolean hasPermission = RoleLocalServiceUtil.hasUserRoles(themeDisplay.getUserId(), themeDisplay.getCompanyId(),rolesArray, true);
	   return hasPermission;
   }
   
    /*check permissions for requesition based on status and roles*/
	public static boolean checkPermissionForRequisition(
			PortletRequest aPortletRequest, String aActionId,
			String requestionDeptNo) throws PortalException, SystemException,
			 IOException, JSONException {
		boolean hasPermission = false;
		ThemeDisplay themeDisplay = (ThemeDisplay) aPortletRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		hasPermission=checkPermission(aPortletRequest, aActionId);
		//_log.info(aActionId+" ::::: Init Permissions ::::>>> "+hasPermission);
		User user = themeDisplay.getUser();
		if (!hasPermission) {
			if (Validator.isNotNull(requestionDeptNo)) {
					/*hasPermission =  HMAAssociateInfoService.getDepartmentNoByAssociateId(positionsDepNo,user.getScreenName());*/
			 String[] roles=StringUtil.split(configuration.get(aActionId),StringPool.COMMA);
			 boolean hasDMP=ArrayUtil.contains(roles,HondaPermissionKeys.ROLE_DMP);
			 boolean hasDM=ArrayUtil.contains(roles,HondaPermissionKeys.ROLE_DM);
			 boolean hasDVM=ArrayUtil.contains(roles,HondaPermissionKeys.ROLE_DVM);
				 if(hasDMP){
					 hasPermission =  HMAAssociateInfoService
								.getDepartmentNoByAssociateId(requestionDeptNo,user.getScreenName(),HondaPermissionKeys.DMP_KEY);
				 }
				 if(hasDM && !hasPermission){
					 hasPermission =  HMAAssociateInfoService
								.getDepartmentNoByAssociateId(requestionDeptNo,user.getScreenName(),HondaPermissionKeys.DM_KEY);
				 }
				 if(hasDVM && !hasPermission){
					 hasPermission =  HMAAssociateInfoService
								.getDepartmentNoByAssociateId(requestionDeptNo,user.getScreenName(),HondaPermissionKeys.DVM_KEY);
				 }
			} 
		}
		//_log.info("User with name : " + themeDisplay.getUser().getFullName()	+ " have permission for Position ? " + hasPermission);
		return hasPermission;
		
		
	}
	
	/*check permissions for requesition based on status and roles*/
	public static boolean checkPermissionForCOS(
			PortletRequest aPortletRequest, String aActionId,
			String requestionDeptNo) throws PortalException, SystemException,
			 IOException, JSONException {
		
		String roles = configuration.get(aActionId);
		String[] rolesArray = StringUtil.split(roles, StringPool.COMMA);
		ThemeDisplay themeDisplay = (ThemeDisplay) aPortletRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		User user=themeDisplay.getUser();
		boolean hasPermission = RoleLocalServiceUtil.hasUserRoles(
				themeDisplay.getUserId(), themeDisplay.getCompanyId(),
				rolesArray, true);
		String[] globalRoles=StringUtil.split(configuration.get(PortletPropsPermission.GLBL_ROLES), StringPool.COMMA);
		if(!RoleLocalServiceUtil.hasUserRoles(
				themeDisplay.getUserId(), themeDisplay.getCompanyId(),
				globalRoles, true) && hasPermission){
			if(Validator.isNotNull(requestionDeptNo)){
			//	hasPermission = HMAAssociateInfoService.getDepartmentNoByAssociateId(requestionDeptNo, user.getScreenName());

		}}
		//_log.info(": : Action ID : : "+aActionId);
		//_log.info(": : HAS Permission  : : "+hasPermission);
		return hasPermission;
	}
	
	public static WFMS_Position createTempPositionForModify(String positionid) throws SystemException{
		//_log.info(" : Create Temp : ");
		
		WFMS_Position getPosition=WFMS_PositionLocalServiceUtil.getByPositionId(positionid);
		String currentStatus=getPosition.getStatus();
		getPosition.setStatus(HondaPermissionKeys.POS_MODFIED);
		getPosition.setIsmodify(true);
		WFMS_PositionLocalServiceUtil.updatePositionEntry(getPosition);
		
		
		getPosition.setPId(positionid+"-WFM");
		getPosition.setStatus(currentStatus);
		getPosition.setDummy("1");
		getPosition.setRefPosId(positionid);
		WFMS_PositionLocalServiceUtil.addWFMS_Position(getPosition);
		
		return getPosition;
	}
	
	
	public static List<User> getUserByRoles(String roles,PortletRequest portletRequest) throws PortalException, SystemException {
		ThemeDisplay themeDisplay=(ThemeDisplay)portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long roleId= RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), roles).getRoleId();
		List<User> users=UserLocalServiceUtil.getRoleUsers(roleId);
		return users;
	}
   
	public static boolean getApprovePermissions(PortletRequest portletRequest,int step,String deptno) throws PortalException, SystemException, IOException, JSONException{
		ThemeDisplay themeDisplay=(ThemeDisplay)portletRequest.getAttribute(WebKeys.THEME_DISPLAY);	
	    User user=themeDisplay.getUser();
		String[] deptRoleArray=StringUtil.split(configuration.get(PortletPropsPermission.POS_MOD_APRV_CONT+step), StringPool.COMMA);
		boolean hasPermissions=false;
		hasPermissions=RoleLocalServiceUtil.hasUserRoles(
				themeDisplay.getUserId(), themeDisplay.getCompanyId(),
				deptRoleArray, true);
		//boolean isDept=UserLocalServiceUtil.hasRoleUser(getDMPRoleId(),userId)||UserLocalServiceUtil.hasRoleUser(getDMRoleId(),userId);
		if(!hasPermissions){
			if (Validator.isNotNull(deptno)) {
				/*hasPermission =  HMAAssociateInfoService
						.getDepartmentNoByAssociateId(positionsDepNo,user.getScreenName());*/
		 String[] roles=deptRoleArray;
		 boolean hasDMP=ArrayUtil.contains(roles,HondaPermissionKeys.ROLE_DMP);
		 boolean hasDM=ArrayUtil.contains(roles,HondaPermissionKeys.ROLE_DM);
			 if(hasDMP){
				 hasPermissions =  HMAAssociateInfoService
							.getDepartmentNoByAssociateId(deptno,user.getScreenName(),HondaPermissionKeys.DMP_KEY);
			 }
			 if(hasDM && !hasPermissions){
				 hasPermissions =  HMAAssociateInfoService
							.getDepartmentNoByAssociateId(deptno,user.getScreenName(),HondaPermissionKeys.DM_KEY);
			 }
		} 
	}
		//_log.info(deptRoleArray.length +" :: Length Has Approve Permission :: >> "+hasPermissions);
		return hasPermissions;
	}
	
	public static boolean checkButtonVisibility(PortletRequest portletRequest,int step,String deptno,String buttonKey)
			throws PortalException, SystemException, IOException, JSONException{
		
		//_log.info(step+"\t"+deptno+"\t"+buttonKey);
		ThemeDisplay themeDisplay=(ThemeDisplay)portletRequest.getAttribute(WebKeys.THEME_DISPLAY);	
	    User user=themeDisplay.getUser();
	    String searchKey=buttonKey+step;
		String[] deptRoleArray=StringUtil.split(configuration.get(searchKey), StringPool.COMMA);
		boolean hasPermissions=false;
		hasPermissions=RoleLocalServiceUtil.hasUserRoles(
				themeDisplay.getUserId(), themeDisplay.getCompanyId(),
				deptRoleArray, true);
		if (!hasPermissions) {
			if (Validator.isNotNull(deptno)) {
					/*hasPermission =  HMAAssociateInfoService
							.getDepartmentNoByAssociateId(positionsDepNo,user.getScreenName());*/
			 String[] roles=StringUtil.split(configuration.get(searchKey),StringPool.COMMA);
			 boolean hasDMP=ArrayUtil.contains(roles,HondaPermissionKeys.ROLE_DMP);
			 boolean hasDM=ArrayUtil.contains(roles,HondaPermissionKeys.ROLE_DM);
				 if(hasDMP){
					 hasPermissions =  HMAAssociateInfoService
								.getDepartmentNoByAssociateId(deptno,user.getScreenName(),HondaPermissionKeys.DMP_KEY);
				 }
				 if(hasDM && !hasPermissions){
					 hasPermissions =  HMAAssociateInfoService
								.getDepartmentNoByAssociateId(deptno,user.getScreenName(),HondaPermissionKeys.DM_KEY);
				 }
			} 
		}
		//_log.info("User with name : " + themeDisplay.getUser().getFullName()	+ " have permission for Position ? " + hasPermissions);
		//_log.info(deptRoleArray.length +" :: Length Has Approve Permission :: >> **********"+hasPermissions);
		return hasPermissions;
	}
	
	public static boolean checkButtonVisibilityForFill(
			PortletRequest portletRequest, int step, String deptno,
			String buttonKey) throws PortalException, SystemException {
		//_log.info(step + "\t" + deptno + "\t" + buttonKey);
		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		String searchKey = buttonKey + step;
		String[] deptRoleArray = StringUtil.split(configuration.get(searchKey),
				StringPool.COMMA);
		boolean hasPermissions = false;
		hasPermissions = RoleLocalServiceUtil.hasUserRoles(
				themeDisplay.getUserId(), themeDisplay.getCompanyId(),
				deptRoleArray, true);

		return hasPermissions;
	}

	
	public static boolean checkBtnVisibilityCOSApprove(String cosId,PortletRequest aPortletRequest,String aActionId) throws PortalException, SystemException, IOException, JSONException{

			WFMS_COS cos=WFMS_COSLocalServiceUtil.getWFMS_COS(cosId);
			String role=StringPool.BLANK;
			String DeptId=StringPool.BLANK;
			int currentStep=cos.getApproverStep();
			String[] steps=null;
             if( Validator.isNull(cos.getSortApprovedList())){
					steps= StringUtil.split(cos.getApproverList(),",");
			}
			else{
				 steps =  StringUtil.split(cos.getSortApprovedList(),",");
			}
			 role=steps[currentStep];
		 String[] gbroles=  StringUtil.split(configuration.get(aActionId),",");
			 List<String> gblist = new LinkedList<String>(Arrays.asList(gbroles)); 
if(role.equalsIgnoreCase(HondaPermissionKeys.COS_CMP))  {gblist.add(HondaPermissionKeys.COS_CMP);  gblist.add(HondaPermissionKeys.ROLE_CMP);}
if(role.equalsIgnoreCase(HondaPermissionKeys.COS_HR_DM))  {gblist.add(HondaPermissionKeys.ROLE_HRDM); }
if(role.equalsIgnoreCase(HondaPermissionKeys.ROLE_STAFFING))  {gblist.add(HondaPermissionKeys.ROLE_STAFFING); }
if(role.equalsIgnoreCase(HondaPermissionKeys.COS_OPS_LEADER))  {gblist.add(HondaPermissionKeys.ROLE_OPS_LEADER); }
if(role.equalsIgnoreCase(HondaPermissionKeys.COS_ARL_OA))  {gblist.add(HondaPermissionKeys.ROLE_ARL_OA); }

String[] rolesArray = new String[gblist.size()];
rolesArray = gblist.toArray(rolesArray);
/*
for(String s : gblist)
    System.out.println(s);*/
//_log.info(rolesArray);
ThemeDisplay themeDisplay=(ThemeDisplay)aPortletRequest.getAttribute(WebKeys.THEME_DISPLAY);
boolean hasPermission = RoleLocalServiceUtil.hasUserRoles(themeDisplay.getUserId(), themeDisplay.getCompanyId(),rolesArray, true);

//System.out.println(gbroles);
			//_log.info("role---------------"+role);
			//System.out.println( configuration.get(aActionId));
		//	boolean hasPermission = false;
			/*ThemeDisplay themeDisplay = (ThemeDisplay) aPortletRequest
					.getAttribute(WebKeys.THEME_DISPLAY);
			hasPermission=checkPermission(aPortletRequest, aActionId);
		//	_log.info(aActionId+" ::::: Init Permissions ::::>>> "+hasPermission);
*/			
//			 _log.info(hasPermission);
			if (!hasPermission) {
				
				 if(role.equals(HondaPermissionKeys.COS_CURRENT_DM) || role.equals(HondaPermissionKeys.COS_CURRENT_DVM)){

						  DeptId=cos.getCurrentDepartmentNumber();
					 }
					
					if(role.equals(HondaPermissionKeys.COS_NEW_DM) || role.equals(HondaPermissionKeys.COS_NEW_DVM)){
						 if(cos.getNewJobCode().equals("PA") || cos.getNewJobCode().equals("TC") || cos.getNewPositionNumber().equals("None")){
							 DeptId = cos.getSameDept();
						 }else{
							 DeptId = cos.getNewDepartmentNumber();
						 } 
					}
					User user = themeDisplay.getUser();
				
				if (Validator.isNotNull(DeptId)) {
						
				
					 if(role.equalsIgnoreCase(HondaPermissionKeys.COS_CURRENT_DM)){
						 hasPermission =  HMAAssociateInfoService
									.getDepartmentNoByAssociateId(DeptId,user.getScreenName(),HondaPermissionKeys.DM_KEY);
					 }
					 if(role.equalsIgnoreCase(HondaPermissionKeys.COS_CURRENT_DVM)){
						 hasPermission =  HMAAssociateInfoService
									.getDepartmentNoByAssociateId(DeptId,user.getScreenName(),HondaPermissionKeys.DVM_KEY);
					 }
					 if(role.equalsIgnoreCase(HondaPermissionKeys.COS_NEW_DM)){
						 hasPermission =  HMAAssociateInfoService
									.getDepartmentNoByAssociateId(DeptId,user.getScreenName(),HondaPermissionKeys.DM_KEY);
						 
					 }
					 if(role.equalsIgnoreCase(HondaPermissionKeys.COS_NEW_DVM)){
							//_log.info("COS_NEW_DVM"+DeptId);

						 hasPermission =  HMAAssociateInfoService
									.getDepartmentNoByAssociateId(DeptId,user.getScreenName(),HondaPermissionKeys.DVM_KEY);
						//	_log.info("COS_NEW_DVM hasPermission---------"+hasPermission);
					 }
				} 
			}
		//	_log.info("User with name : " + themeDisplay.getUser().getFullName()	+ " have permission for Position ? " + hasPermission);
			return hasPermission;

}

	
	public static  List<String> getccCodelistOnRequistionGrid(PortletRequest aPortletRequest,String aActionId) throws PortalException, SystemException,  IOException, JSONException{
		
		
		ThemeDisplay themeDisplay = (ThemeDisplay) aPortletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		User user = UserLocalServiceUtil.getUserById(userId);
		String screenName = user.getScreenName();
		List<Role> roliselist= RoleLocalServiceUtil.getRoles(user.getUserId());
		   List<String> cclists1=new ArrayList<String>();
		   List<String> cclists2=new ArrayList<String>();
		   List<String> cclists3=new ArrayList<String>();
		   List<String> cclists4=new ArrayList<String>();
		   
		   boolean hasPermission = false;
			
			hasPermission=checkPermission(aPortletRequest, aActionId);
		if(!hasPermission){
			  if(roliselist.size()==0){
				  cclists1=HondaLogicUtil.getccCodesonRequisitonGrid(HondaPermissionKeys.DVM_KEY,screenName);
			      cclists2=HondaLogicUtil.getccCodesonRequisitonGrid(HondaPermissionKeys.DMP_KEY,screenName);
			      cclists3=HondaLogicUtil.getccCodesonRequisitonGrid(HondaPermissionKeys.DM_KEY,screenName);
			    cclists4.addAll(cclists1);
			    cclists4.addAll(cclists2);
			    cclists4.addAll(cclists3);
			  }
			  
			}
		return cclists4;
		
	}

public static  Boolean  isUserHaveRole(PortletRequest aPortletRequest,String aActionId) throws PortalException, SystemException,  IOException, JSONException{
		
		
		ThemeDisplay themeDisplay = (ThemeDisplay) aPortletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		User user = UserLocalServiceUtil.getUserById(userId);
		String screenName = user.getScreenName();
		List<Role> roliselist= RoleLocalServiceUtil.getRoles(user.getUserId());
		   boolean hasPermission = false;
		   boolean cclists1 = false;
		   boolean cclists2 = false;
		   boolean cclists3 = false;
		   boolean finalcc = false;
			hasPermission=checkPermission(aPortletRequest, aActionId);
		if(!hasPermission){
			  if(roliselist.size()==0){
				  CostCenterService costCenterService=new CostCenterService();
				  cclists1=costCenterService.isUserhaveRoles(HondaPermissionKeys.DMP_KEY,screenName);
			      cclists2=costCenterService.isUserhaveRoles(HondaPermissionKeys.DVM_KEY,screenName);
		  	      cclists3=costCenterService.isUserhaveRoles(HondaPermissionKeys.DM_KEY,screenName);
		       
			  }
			  
			  if(cclists1 || cclists2 || cclists3) hasPermission=true;
			}
		return hasPermission;
		
	}

	
	
	public static boolean permissionOnCOSModifyButton(PortletRequest aPortletRequest,String aActionId) throws PortalException, SystemException,  IOException{
		    boolean hasPermission = false;
			hasPermission=checkPermission(aPortletRequest, aActionId);
		    return hasPermission;
	}
  /* public static final long getDMPRoleId() throws PortalException, SystemException{
	 return  RoleLocalServiceUtil.getRole(serviceContext.getCompanyId(),HondaPermissionKeys.ROLE_DMP).getRoleId();
   }
   
   public static final long getDMRoleId() throws PortalException, SystemException{
    return RoleLocalServiceUtil.getRole(serviceContext.getCompanyId(),HondaPermissionKeys.ROLE_DM).getRoleId();
   }*/
	private static Log _log = LogFactoryUtil.getLog(WMSUserAccessUtil.class.getName());
    private static ServiceContext serviceContext=ServiceContextThreadLocal.getServiceContext();

    
   public static String convertSPBAtoCMP(String approvelist)
   {
	   
	   String[] approveArry=StringUtil.split(approvelist,StringPool.COMMA) ;
	   
	   List<String> applist = Arrays.asList(approveArry);  
	   List<String> finallist=new ArrayList<String>();
	   _log.info( applist.contains("SP BA"));
	   for(String val:applist){
// System.out.println(val);
		  if( val.trim().equalsIgnoreCase("SP BA")){
			//  System.out.println(val);
			   // finallist.add(HondaPermissionKeys.ROLE_CMP);
			  val=HondaPermissionKeys.ROLE_CMP;
		  }
		  
		  else{
		  finallist.add(val);}
	   }
	   return StringUtil.merge(finallist, StringPool.COMMA);
   }
   public static boolean sericeNowisactiveOrnot(){
	   if("true".equalsIgnoreCase(configuration.get("mail.config.verify")))	   return true;
	   else return false;
   }
}
