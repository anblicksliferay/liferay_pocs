package com.ys.hmawfm.wfms.utils;

import javax.portlet.ActionRequest;
import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.service.LayoutLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

public class GenerateFrindlyURL {


	
	private static Log _log = LogFactoryUtil.getLog(GenerateFrindlyURL.class.getName());

	public static String getHMAfrindlyURL( PortletRequest portletRequest,String poid) throws WindowStateException, PortletModeException
	{
		
		String pageName="/position";
		String portletAction = "editPosition";
		String positionId =poid;
		long position_plid = 0;
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
			position_plid = LayoutLocalServiceUtil.getFriendlyURLLayout(themeDisplay.getScopeGroupId(), true, pageName).getPlid();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//_log.info("Position Portlet - Ready to Create URL");
		
		LiferayPortletURL positionCreateURL = PortletURLFactoryUtil.create(portletRequest,          
				"Position" , position_plid, PortletRequest.ACTION_PHASE);
		positionCreateURL.setWindowState(LiferayWindowState.MAXIMIZED);
		positionCreateURL.setPortletMode(PortletMode.VIEW);
		positionCreateURL.setParameter("javax.portlet.action", portletAction);
		positionCreateURL.setParameter("positionId", positionId);
		//_log.info("URL Result: "+ positionCreateURL.toString());
		return positionCreateURL.toString();
	}
	public static String getURLForRequisition( ActionRequest request,String ReqId) throws WindowStateException, PortletModeException, com.liferay.portal.kernel.exception.PortalException, com.liferay.portal.kernel.exception.SystemException
	{   
	        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
	        Layout layout=LayoutLocalServiceUtil.getFriendlyURLLayout(themeDisplay.getScopeGroupId(), true,"/requisition");
	    	PortletURL portletURL = PortletURLFactoryUtil.create(request,"Requisition",layout.getPlid(), ActionRequest.ACTION_PHASE);        
	    	portletURL.setWindowState(WindowState.NORMAL);
	    	portletURL.setParameter("positionId",ReqId);
	    	portletURL.setParameter(ActionRequest.ACTION_NAME,"editRequisition");
	    	return portletURL.toString();    
	}
	public static String getURLForPosition( ActionRequest request,String PosId) throws WindowStateException, PortletModeException, com.liferay.portal.kernel.exception.PortalException, com.liferay.portal.kernel.exception.SystemException
	{   
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		Layout layout=LayoutLocalServiceUtil.getFriendlyURLLayout(themeDisplay.getScopeGroupId(), true,"/position");
		PortletURL portletURL = PortletURLFactoryUtil.create(request,"Position",layout.getPlid(), ActionRequest.ACTION_PHASE);                                                        
		portletURL.setWindowState(WindowState.NORMAL);
		portletURL.setParameter(ActionRequest.ACTION_NAME,"editPosition");
		portletURL.setParameter("positionId",PosId);
		return portletURL.toString();
	}
	public static String getCOSfrindlyURL(PortletRequest portletRequest,String cosid) throws WindowStateException, PortletModeException

	{
		String pageName="/change-of-status";
		String portletAction = "editCOS";
		String cosId =cosid;
		long cos_plid = 0;
		
		
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
			cos_plid = LayoutLocalServiceUtil.getFriendlyURLLayout(themeDisplay.getScopeGroupId(), true, pageName).getPlid();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		LiferayPortletURL positionCreateURL = PortletURLFactoryUtil.create(portletRequest,          
				"ChangeOfStatus" , cos_plid, PortletRequest.ACTION_PHASE);
		positionCreateURL.setWindowState(LiferayWindowState.MAXIMIZED);
		positionCreateURL.setPortletMode(PortletMode.VIEW);
		positionCreateURL.setParameter("javax.portlet.action", portletAction);
		positionCreateURL.setParameter("cosId", cosId);
		positionCreateURL.setParameter("modifyButtonEnable", "modifyButtonEnable");
		//_log.info("URL Result: "+ positionCreateURL.toString());
		return positionCreateURL.toString();
	}
public static String renderManagePosition( PortletRequest portletRequest) throws PortalException, SystemException, WindowStateException
{
	ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
	Layout layout=LayoutLocalServiceUtil.getFriendlyURLLayout(themeDisplay.getScopeGroupId(), true,"/position");
	PortletURL portletURL = PortletURLFactoryUtil.create(portletRequest,"Position",layout.getPlid(), ActionRequest.RENDER_PHASE);                                                        
	portletURL.setWindowState(WindowState.NORMAL);
	 return portletURL.toString();
}
public static String renderManageCOS( PortletRequest portletRequest) throws PortalException, SystemException, WindowStateException
{
	ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
	Layout layout=LayoutLocalServiceUtil.getFriendlyURLLayout(themeDisplay.getScopeGroupId(), true,"/change-of-status");
	PortletURL portletURL = PortletURLFactoryUtil.create(portletRequest,"ChangeOfStatus",layout.getPlid(), ActionRequest.RENDER_PHASE);                                                        
	portletURL.setWindowState(WindowState.NORMAL);
	 return portletURL.toString();
}
public static String renderManageRequisition( PortletRequest portletRequest) throws PortalException, SystemException, WindowStateException
{
	ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
	Layout layout=LayoutLocalServiceUtil.getFriendlyURLLayout(themeDisplay.getScopeGroupId(), true,"/Requisition");
	PortletURL portletURL = PortletURLFactoryUtil.create(portletRequest,"Requisition",layout.getPlid(), ActionRequest.RENDER_PHASE);                                                        
	portletURL.setWindowState(WindowState.NORMAL);
	 return portletURL.toString();
}
public static PortletURL renderingPage( PortletRequest actionRequest , PortletResponse actionResponse ,String jspPageName ) throws WindowStateException{
	
    ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest .getAttribute(WebKeys.THEME_DISPLAY);
    String portletName=(String) actionRequest.getAttribute(WebKeys.PORTLET_ID);
	PortletURL portletURL = PortletURLFactoryUtil .create(PortalUtil.getHttpServletRequest(actionRequest), portletName,themeDisplay.getLayout().getPlid(),PortletRequest.RENDER_PHASE);
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("jspPage",jspPageName);
		 // _log.info(portletURL.toString() );
 
return portletURL;
}
}
