package com.delphi.portlet;

import com.delphi.portlet.model.CategoryExpense;
import com.delphi.portlet.model.DailyRevenueExpenseTracker;
import com.delphi.portlet.model.DashBoardQuery;
import com.delphi.portlet.model.DivisionProduct;
import com.delphi.portlet.model.RevenueExpenseTracker;
import com.delphi.portlet.service.DashBoardService;
import com.delphi.portlet.service.UserDefaultsService;
import com.delphi.portlet.service.impl.DashBoardServiceImpl;
import com.delphi.portlet.service.impl.UserDefaultsServiceImpl;
import com.delphi.util.DelphiFinancialConstants;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;


@Component(
	immediate = true, 
	property = {
		"com.liferay.portlet.display-category=Delphi",
		"com.liferay.portlet.header-portlet-css=/css/main-dash.css", 
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=Delphi Financials Dashboard Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/html/dashboard/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" 
	},
	service = Portlet.class
)
public class DelphiFinancialsDashboardPortlet extends MVCPortlet {

	private static Log _log = LogFactoryUtil.getLog(DelphiFinancialsDashboardPortlet.class);
	private DashBoardService dashBoardService = new DashBoardServiceImpl() ;
	private UserDefaultsService userDefaultService = new UserDefaultsServiceImpl() ;

	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws PortletException, IOException {
		
		Calendar  allStartDate = dashBoardService.getStartDate();
		Calendar  dateToday = dashBoardService.getTodaysDate();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		
		renderRequest.setAttribute("allStartDate", sdf.format(allStartDate.getTime()));	
		StringBuffer sb = new StringBuffer();
		 sb.append(dateToday.get(Calendar.YEAR)).append("-").append(dateToday.get(Calendar.MONTH)+1).append("-").append(dateToday.get(Calendar.DATE));
		_log.debug("dateToday : "+ sb.toString());
		renderRequest.setAttribute("dateToday", sb.toString());	
		setUserDefault(renderRequest);
		PortletRequestDispatcher prd = getPortletContext()
				.getRequestDispatcher("/html/dashboard/view.jsp");
		prd.include(renderRequest, renderResponse);
	}

	private void setUserDefault(RenderRequest renderRequest){
		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		long userId = user.getUserId();

		Map<String, String> model = userDefaultService.fetchUserDefaults(userId, DelphiFinancialConstants.PAGEID);
		renderRequest.setAttribute("userDefaultModel", model);	
	}
	
	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		
		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		//String userName = user.getFullName();
		long userId = user.getUserId();
		String cmd = ParamUtil.getString(resourceRequest, "cmd");
		String cmdType = ParamUtil.getString(resourceRequest, "cmdType");
		String context = ParamUtil.getString(resourceRequest, "context");
		_log.debug("serveResource command is: "+cmd +" with cmdType(optional): "+cmdType +" with context(optional): "+context);

		if(cmdType.equalsIgnoreCase("storeDefault")){
			try{
				JSONObject jsonRequestContext = JSONFactoryUtil.createJSONObject(context);
				String id = jsonRequestContext.getString("fieldid");
				String value = jsonRequestContext.getString("fieldvalue");
				userDefaultService.updateDefaults(userId, DelphiFinancialConstants.PAGEID, id, value);
				JSONObject returnObject = JSONFactoryUtil.createJSONObject();
				returnObject.put("data", "storeDefault request completed sucessfully" );
				writeJSON(resourceRequest, resourceResponse, returnObject);
			}
			catch(Exception ex){
				JSONObject json = JSONFactoryUtil.createJSONObject();
				json.put("error", "storeDefault Unsuccessful");
				writeJSON(resourceRequest, resourceResponse, json);
			}
		}else{
			DashBoardQuery dashBoardQuery = null;
			dashBoardQuery = createDashBoardQuery(context);
			_log.debug("dashBoardQuery = " + dashBoardQuery);
			if(cmdType.equalsIgnoreCase("divisionProdctChart")){
				boolean isDivsion = false;
				if(cmd.equalsIgnoreCase("division")){
					isDivsion = true;
				}
				List<DivisionProduct> divisionProducts = dashBoardService.getDivisionProductList(dashBoardQuery, isDivsion);
				writeJSON(resourceRequest, resourceResponse,toDivisionProductListJSON(divisionProducts));
			}else if(cmdType.equalsIgnoreCase("trackerChart")){
				
				RevenueExpenseTracker revenueExpenseTracker =   dashBoardService.getRevenueExpenseTrackerList(dashBoardQuery);
				writeJSON(resourceRequest, resourceResponse,revenueExpenseTracker.toJSON());
			}else if(cmdType.equalsIgnoreCase("categoryExpenseChart")){
				
				List<CategoryExpense> categoryExpenses = dashBoardService.getCategoryExpenseList(dashBoardQuery);
				writeJSON(resourceRequest, resourceResponse,toCategoryExpenseListJSON(categoryExpenses));
			}else if(cmdType.equalsIgnoreCase("timeSeriesChart")){
//				userDefaultService.updateDefaults(userId, DelphiFinancialConstants.PAGEID, DelphiFinancialConstants.EXPENSE_CATEGORY_FIELD, Integer.toString(dashBoardQuery.getExpenseId()));
//				userDefaultService.updateDefaults(userId, DelphiFinancialConstants.PAGEID, DelphiFinancialConstants.REGION_FIELD, Integer.toString(dashBoardQuery.getRegionId()));
//				userDefaultService.updateDefaults(userId, DelphiFinancialConstants.PAGEID, DelphiFinancialConstants.SITE_FIELD, Integer.toString(dashBoardQuery.getSiteId()));
				Collection<DailyRevenueExpenseTracker> dailyRevenueExpenseTrackers = null;
				if(cmd.equalsIgnoreCase("daily")){
					dailyRevenueExpenseTrackers = dashBoardService.getDailyRevenueExpenseTrackerList(dashBoardQuery);
				}else if(cmd.equalsIgnoreCase("monthly")){
					dailyRevenueExpenseTrackers = dashBoardService.getMonthlyRevenueExpenseTrackerList(dashBoardQuery);
					
				}else {
					dailyRevenueExpenseTrackers = dashBoardService.getYearlyRevenueExpenseTrackerList(dashBoardQuery);
				}
				
				writeJSON(resourceRequest, resourceResponse,toDailyRevenueExpenseTrackerListJSON(dailyRevenueExpenseTrackers));
			} 
		}
	}
	private  JSONObject toDailyRevenueExpenseTrackerListJSON(Collection<DailyRevenueExpenseTracker> dailyRevenueExpenseTrackers){
		JSONObject json = JSONFactoryUtil.createJSONObject();
		JSONArray jsonArray  = 	JSONFactoryUtil.createJSONArray();
		for(DailyRevenueExpenseTracker dp: dailyRevenueExpenseTrackers){
			jsonArray.put(dp.toJSON());
		}		
		json.put("timeSeriesChart", jsonArray);
		return json;
	} 
	
	private  JSONObject toCategoryExpenseListJSON(List<CategoryExpense> categoryExpenses){
		JSONObject json = JSONFactoryUtil.createJSONObject();
		JSONArray jsonArray  = 	JSONFactoryUtil.createJSONArray();
		for(CategoryExpense dp: categoryExpenses){
			jsonArray.put(dp.toJSON());
		}		
		json.put("categoryExpenseChart", jsonArray);
		return json;
	} 
	private  JSONObject toDivisionProductListJSON(List<DivisionProduct> divisionProducts){
		JSONObject json = JSONFactoryUtil.createJSONObject();
		JSONArray jsonArray  = 	JSONFactoryUtil.createJSONArray();
		for(DivisionProduct dp: divisionProducts){
			jsonArray.put(dp.toJSON());
		}		
		json.put("divisionProdctChart", jsonArray);
		return json;
	}
	
	
	private DashBoardQuery createDashBoardQuery(String context) {
		DashBoardQuery erq = null;
		try {
			JSONObject json = JSONFactoryUtil.createJSONObject(context);
			
			erq = new DashBoardQuery(createDate(json.getString("startDate")), createDate(json.getString("endDate")),
					json.getInt("expenseId"),GetterUtil.getInteger(json.getInt("regionId"),-1), GetterUtil.getInteger(json.getInt("siteId"),-1),
					GetterUtil.getInteger(json.getInt("divisionId"),-1),GetterUtil.getInteger(json.getInt("productLineId"),-1));

		} catch (JSONException e) {
			_log.error(e);
			e.printStackTrace();
		}
		return erq;

	}
	
	private Date createDate(String date){
		_log.debug("date : "+date);
		try{
		String[] dates  = date.split("/");
		int month = GetterUtil.getInteger(dates[0]);
		int dayOfMonth = GetterUtil.getInteger(dates[1]);
		int year = GetterUtil.getInteger(dates[2]);
		
		GregorianCalendar cal = new GregorianCalendar(year, month-1, dayOfMonth);
		return cal.getTime();
		}catch(Exception e){
			_log.error(e.getMessage());
		}
		return null;
	}

}