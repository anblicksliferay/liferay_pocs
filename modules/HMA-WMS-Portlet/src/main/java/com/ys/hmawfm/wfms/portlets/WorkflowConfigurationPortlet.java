package com.ys.hmawfm.wfms.portlets;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.ys.hmawfm.wfms.portlets.constants.WorkflowConfigurationPortletKeys;
import com.ys.hmawfm.wfms.services.model.WFMS_WorkflowConfig;
import com.ys.hmawfm.wfms.services.service.WFMS_WorkflowConfigLocalServiceUtil;

/**
 * @author RST021
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=HMA-WMS",
        "com.liferay.portlet.header-portlet-css=/css/main.css", 
		"com.liferay.portlet.header-portlet-javascript=/js/main.js",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=WMS-WorkflowConfig",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/html/workflow-configuration/list.jsp",
		"javax.portlet.name=" + WorkflowConfigurationPortletKeys.WorkflowConfiguration,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class WorkflowConfigurationPortlet extends MVCPortlet {
	
	public void doView(RenderRequest request, RenderResponse response) throws PortletException, IOException {

		/*
		WorkflowControler.runTest();*/
		
		
		
		try {
			List<WFMS_WorkflowConfig> wfms_ConfigList = WFMS_WorkflowConfigLocalServiceUtil.getAll();
			request.setAttribute("list", wfms_ConfigList);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		PortletRequestDispatcher prd = getPortletContext().getRequestDispatcher("/html/workflow-configuration/list.jsp");
		prd.include(request, response);
	}
	
	public void newConfiguration(ActionRequest request, ActionResponse response) throws Exception {
		response.setRenderParameter("jspPage", "/html/workflow-configuration/manage.jsp");
	}

	public void manageConfiguration(ActionRequest request, ActionResponse response) throws Exception {

		long configId = Long.parseLong(request.getParameter("configId"));
		//_log.info("In manage config portlet---- manageConfiguration for " + configId);

		WFMS_WorkflowConfig wfms_config = WFMS_WorkflowConfigLocalServiceUtil.getByConfigId(configId);

		if (wfms_config != null) {
			request.setAttribute("wfms_config", wfms_config);
		}

		response.setRenderParameter("jspPage", "/html/workflow-configuration/manage.jsp");
	}

	public void deleteConfiguration(ActionRequest request, ActionResponse response) throws Exception {

		long configId = Long.parseLong(request.getParameter("configId"));
		
		WFMS_WorkflowConfigLocalServiceUtil.deleteConfig(configId);
		
		try {
			List<WFMS_WorkflowConfig> wfms_ConfigList = WFMS_WorkflowConfigLocalServiceUtil.getAll();
			request.setAttribute("list", wfms_ConfigList);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		response.setRenderParameter("jspPage", "/html/workflow-configuration/list.jsp");

	}

	public void createConfiguration(ActionRequest request, ActionResponse response) throws Exception {
		//_log.info("In config portlet----createNotification");

		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			long userId = themeDisplay.getUserId();
			User user = UserLocalServiceUtil.getUserById(userId);
			String screenName = user.getScreenName();

			String configKey = request.getParameter("configKey");
			String configLabel = request.getParameter("configLabel");
			String contentType = request.getParameter("contentType");
			String content = request.getParameter("content");

			WFMS_WorkflowConfig wfms_config = WFMS_WorkflowConfigLocalServiceUtil.addNewConfig(screenName, configKey, configLabel,
					contentType, content);

			List<WFMS_WorkflowConfig> wfms_configList = WFMS_WorkflowConfigLocalServiceUtil.getAll();
			request.setAttribute("list", wfms_configList);
			response.setRenderParameter("jspPage", "/html/workflow-configuration/list.jsp");

		} catch (Exception ex) {
			_log.error("WorkflowConfigurationPortlet.createConfiguration(): "+ex);
		}
	}

	public void saveConfiguration(ActionRequest request, ActionResponse response) throws Exception {
		//_log.info("In config portlet----saveNotification");

		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			long userId = themeDisplay.getUserId();
			User user = UserLocalServiceUtil.getUserById(userId);
			String screenName = user.getScreenName();

			long configId = Long.parseLong(request.getParameter("configId"));
			String configKey = request.getParameter("configKey");
			String configLabel = request.getParameter("configLabel");
			String contentType = request.getParameter("contentType");
			String content = request.getParameter("content");

			WFMS_WorkflowConfig wfms_config = WFMS_WorkflowConfigLocalServiceUtil.updateConfig(configId, screenName, configKey, configLabel,
					contentType, content);

			List<WFMS_WorkflowConfig> wfms_configList = WFMS_WorkflowConfigLocalServiceUtil.getAll();
			request.setAttribute("list", wfms_configList);
			response.setRenderParameter("jspPage", "/html/workflow-configuration/list.jsp");

		} catch (Exception ex) {
			_log.error("WorkflowConfigurationPortlet.saveConfiguration(): "+ex);
		}
	}
	private static Log _log = LogFactoryUtil.getLog(WorkflowConfigurationPortlet.class.getName());
}