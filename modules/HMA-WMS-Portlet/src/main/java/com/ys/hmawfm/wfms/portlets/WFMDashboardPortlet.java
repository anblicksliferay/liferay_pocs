/**
 * Copyright 2000-present Liferay, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ys.hmawfm.wfms.portlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.ys.hmawfm.wfms.portlets.constants.WorkflowConfigurationPortletKeys;
import com.ys.hmawfm.wfms.services.model.WFMS_COS;
import com.ys.hmawfm.wfms.services.model.WFMS_Position;
import com.ys.hmawfm.wfms.services.model.WFMS_Requisition;
import com.ys.hmawfm.wfms.services.service.WFMS_COSLocalServiceUtil;
import com.ys.hmawfm.wfms.services.service.WFMS_PositionLocalServiceUtil;
import com.ys.hmawfm.wfms.services.service.WFMS_RequisitionLocalServiceUtil;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=HMA-WMS",
        "com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.header-portlet-js=/js/main.js",
        "com.liferay.portlet.instanceable=false",
        "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/html/wfmDashboard/wfmDashboardView.jsp",
		"javax.portlet.name=" + WorkflowConfigurationPortletKeys.DashBoard,
        "javax.portlet.security-role-ref=power-user,user",
        "javax.portlet.display-name=WMS-Dashboard"
    },
    service = Portlet.class
)
public class WFMDashboardPortlet extends MVCPortlet {

	public void doView(RenderRequest request, RenderResponse response) throws PortletException, IOException {
		PortletRequestDispatcher prd = getPortletContext()
				.getRequestDispatcher("/html/wfmDashboard/wfmDashboardView.jsp");

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

		boolean loggedIn = themeDisplay.isSignedIn();
		if (!loggedIn) {
			prd = getPortletContext().getRequestDispatcher("/html/signin.jsp");
		} else {
			long userId = themeDisplay.getUserId();
			User user;
			try {
				user = UserLocalServiceUtil.getUserById(userId);

				List<Role> userRoles = user.getRoles();

				List<WFMS_Position> wfms_PositionList = new ArrayList<WFMS_Position>();
				List<WFMS_Requisition> wfms_RequisitionList = new ArrayList<WFMS_Requisition>();
				List<WFMS_COS> wfms_COSList = new ArrayList<WFMS_COS>();

				List<WFMS_Position> wfms_PositionTasksList = new ArrayList<WFMS_Position>();
				List<WFMS_Requisition> wfms_RequisitionTasksList = new ArrayList<WFMS_Requisition>();
				List<WFMS_COS> wfms_COSTasksList = new ArrayList<WFMS_COS>();
				//System.out.println("WFMDashboardPortlet:>>>>>>>>>" );
				for (Role r : userRoles) {

					if (r.getName().equalsIgnoreCase("Payroll") || r.getName().equalsIgnoreCase("Staffing")) {
						/*wfms_PositionList = WFMS_PositionLocalServiceUtil.findByNextApprover(r.getName());
						if (wfms_PositionList != null)
							wfms_PositionTasksList.addAll(wfms_PositionList);
						System.out.println("wfms_PositionList1:>>>>>>>>>" + wfms_PositionList.size());*/

						wfms_RequisitionList = WFMS_RequisitionLocalServiceUtil.findByRoleOfApprover(r.getName());
						if (wfms_RequisitionList != null) {
							wfms_RequisitionTasksList.addAll(wfms_RequisitionList);
							user.getScreenName();
						}

						wfms_COSList = WFMS_COSLocalServiceUtil.findByRoleOfApprover(r.getName());
						if (wfms_COSList != null) {
							wfms_COSTasksList.addAll(wfms_COSList);
						}

					}

				}
				wfms_PositionList = WFMS_PositionLocalServiceUtil
						.findByNextApprover("%" + user.getFirstName() + " " + user.getLastName() + "%");
				
				if (wfms_PositionList != null && !wfms_PositionList.isEmpty()) {
					for (WFMS_Position wfms_Position : wfms_PositionList) {
						//if (!wfms_PositionTasksList.contains(wfms_Position))
							wfms_PositionTasksList.add(wfms_Position);
					}

				}
				
				wfms_RequisitionList = WFMS_RequisitionLocalServiceUtil
						.findByNextApprover("%" + user.getFirstName() + " " + user.getLastName() + "%");
				if (wfms_RequisitionList != null && !wfms_RequisitionList.isEmpty()) {
					for (WFMS_Requisition wfms_Requisition : wfms_RequisitionList) {
						if (!wfms_RequisitionTasksList.contains(wfms_Requisition))
							wfms_RequisitionTasksList.add(wfms_Requisition);
					}

				}

				wfms_COSList = WFMS_COSLocalServiceUtil
						.findByNextApprover("%" + user.getFirstName() + " " + user.getLastName() + "%");
				if (wfms_COSList != null && !wfms_COSList.isEmpty()) {
					for (WFMS_COS wfms_COS : wfms_COSList) {
						if (!wfms_COSTasksList.contains(wfms_COS))
							wfms_COSTasksList.add(wfms_COS);
					}

				}

				if (wfms_PositionTasksList != null)
					request.setAttribute("wfms_PositionTasksList", wfms_PositionTasksList);

				if (wfms_RequisitionTasksList != null)
					request.setAttribute("wfms_RequisitionTasksList", wfms_RequisitionTasksList);

				if (wfms_COSTasksList != null)
					request.setAttribute("wfms_COSTasksList", wfms_COSTasksList);

			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		prd.include(request, response);
	}

	public void newPositions(ActionRequest request, ActionResponse response) throws Exception {

		System.out.println("In new notification portlet-----");

		response.setRenderParameter("jspPage", "/html/position/positionView.jsp");

	}

	public void newChangeOfStatuss(ActionRequest request, ActionResponse response) throws Exception {

		System.out.println("In new notification portlet-----");

		response.setRenderParameter("jspPage", "/html/changeOfStatus/manage.jsp");

	}
	
	/* Redirect to update position with pos id 
	*//**
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 *//*
	public void getPosition(ActionRequest request, ActionResponse response) throws Exception {
		try {

			String positionId = request.getParameter("positionId");
			System.out.print("---------getPosition action-------------------" + positionId);
			List<WFMS_Position> position = WFMS_PositionLocalServiceUtil.findByrefPosId(positionId);
			System.out.print("---------getPosition post-------------------" + position);
			String tempStatus = "";
			if (request.getParameter("autoReqAfterTerminate") != null) {
				request.setAttribute("autoReqAfterTerminate", request.getParameter("autoReqAfterTerminate"));
			}
			for (WFMS_Position obj : position) {
				tempStatus = obj.getStatus();
			}
			if (tempStatus.equalsIgnoreCase(HondaPermissionKeys.POS_DRAFT)) {
				request.setAttribute("positionId", positionId.concat("-WFM"));
			} else {
				request.setAttribute("positionId", positionId);
			}

		} catch (SystemException e) {
			e.printStackTrace();
		}
		response.setRenderParameter("jspPage", "/html/position/updatePosition.jsp");
	}*/

	/**
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	/*public void getRequisition(ActionRequest request, ActionResponse response) throws Exception {

		try {
			// String positionId = request.getParameter("positionId");
			String reqId = request.getParameter("reqId");
			System.out.print("--------getRequisition :" + reqId);

			WFMS_Requisition req = WFMS_RequisitionLocalServiceUtil.getWFMS_Requisition(reqId);
			System.out.print("--------getRequisition 3:" + req);
			if (req != null) {
				WFMS_Position wfms_Position = WFMS_PositionLocalServiceUtil.getByPositionId(req.getRId());
				request.setAttribute("positionId", req.getRId());
				request.setAttribute("requisitionId", req.getRwfId());
				request.setAttribute("wfms_PositionObj", wfms_Position);
				ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
				long userId = themeDisplay.getUserId();
				User user = UserLocalServiceUtil.getUserById(userId);

			}

		} catch (SystemException e) {
			e.printStackTrace();
		}
		response.setRenderParameter("jspPage", "/html/requisition/manageRequisition.jsp");

	}*/

	/**
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	/*public void getCOS(ActionRequest request, ActionResponse response) throws Exception {

		try {
			// String positionId = request.getParameter("positionId");
			String cosId = request.getParameter("cosId");
			System.out.print("--------getCOS :" + cosId);
			// WFMS_Position wfms_Position =
			// WFMS_PositionLocalServiceUtil.getByPositionId(positionId);
			WFMS_COS cos = WFMS_COSLocalServiceUtil.getByCOSId(cosId);
			System.out.print("--------getCOS 5:" + cos);
			if (cos != null) {
				WFMS_Position wfms_Position = WFMS_PositionLocalServiceUtil.getByPositionId(cos.getRequistionId());
				request.setAttribute("positionId", cos.getNewPositionNumber());
				request.setAttribute("requisitionId", cos.getRequistionId());
				request.setAttribute("wfms_PositionObj", wfms_Position);
				request.setAttribute("wfms_CosObj", cos);
				request.setAttribute("AssociateNumber", cos.getAssoicateId());
				ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
				long userId = themeDisplay.getUserId();
				User user = UserLocalServiceUtil.getUserById(userId);

			}

		} catch (SystemException e) {
			e.printStackTrace();
		}
		response.setRenderParameter("jspPage", "/html/changeOfStatus/manageCOS.jsp");

	}*/
}