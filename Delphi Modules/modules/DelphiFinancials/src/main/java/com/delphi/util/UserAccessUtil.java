package com.delphi.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserGroup;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

public class UserAccessUtil {
	private static Log _log = LogFactoryUtil.getLog(UserAccessUtil.class);

	public static boolean checkPermissionForIsAdmin(PortletRequest renderRequest) throws PortalException, SystemException, IOException{
		 
	
		    ThemeDisplay themeDisplay=(ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		    User selUser=themeDisplay.getUser();
		    List<Group> allGroups = new ArrayList<Group>();
		    List<UserGroup> userGroups = selUser.getUserGroups();
		    List<Group> groups = selUser.getGroups();
		    List<Organization> organizations = selUser.getOrganizations();
		    allGroups.addAll(groups);
		    allGroups.addAll(GroupLocalServiceUtil.
		    getOrganizationsGroups(organizations));
		    allGroups.addAll(GroupLocalServiceUtil.
		    getOrganizationsRelatedGroups(organizations));
		    allGroups.addAll
		    (GroupLocalServiceUtil.getUserGroupsGroups(userGroups));
		    allGroups.addAll(GroupLocalServiceUtil.
		    getUserGroupsRelatedGroups(userGroups));
		    List<Role> groupRoles=null;
		    List<String> listof= new ArrayList<String>();
		    for(int i=0;i<allGroups.size();i++){
		    Group group=allGroups.get(i);
		     groupRoles = RoleLocalServiceUtil.getGroupRoles(group.getGroupId());
		    if (!groupRoles.isEmpty()) {

		    }
		    for(Role va: groupRoles){
		    	//out.println(va.getName());
		    	
		    	if(va.getName().equalsIgnoreCase("Financial Admin")){
		    		listof.add(va.getName());
		    	}
		    }
		    }
		    System.out.println(listof);
		    String [] adminRoles = listof.toArray(new String[listof.size()]);

		    boolean   hasPermission = RoleLocalServiceUtil.hasUserRoles(themeDisplay.getUserId(), themeDisplay.getCompanyId(),adminRoles, true); 
		   return hasPermission;
	   }

}
