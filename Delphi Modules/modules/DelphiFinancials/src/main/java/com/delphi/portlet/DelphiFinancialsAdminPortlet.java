package com.delphi.portlet;


import com.delphi.portlet.model.Division;
import com.delphi.portlet.model.ExpenseCatagory;
import com.delphi.portlet.model.ExpenseDetail;
import com.delphi.portlet.model.ExpenseRevenueQuery;
import com.delphi.portlet.model.ExpenseRevenueResult;
import com.delphi.portlet.model.ExpenseRevenueSaveUpdate;
import com.delphi.portlet.model.NameId;
import com.delphi.portlet.model.ProductLine;
import com.delphi.portlet.service.ExpenseRevenueService;
import com.delphi.portlet.service.impl.ExpenseRevenueServiceImpl;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;




import java.io.IOException;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;

import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=Delphi",
		"com.liferay.portlet.header-portlet-css=/css/main-admin.css",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=Delphi Financials Admin Portlet",
		"javax.portlet.init-param.template-path=/", 
		"javax.portlet.init-param.view-template=/html/admin/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class DelphiFinancialsAdminPortlet extends MVCPortlet {
 
	private ExpenseRevenueService expeseRevenueService = new ExpenseRevenueServiceImpl();
	private List<NameId> expenseCatoryList = expeseRevenueService.getExpenseCatagories();
    private static String[] months = new DateFormatSymbols().getMonths();
    
    @Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws PortletException, IOException {
				List<NameId> sites = expeseRevenueService.getSites();
		_log.info("sites size = "+sites.size());
		renderRequest.setAttribute("sites",sites );
		
		HttpServletRequest request = PortalUtil.getHttpServletRequest(renderRequest);
		int siteId = GetterUtil.getInteger(PortalUtil.getOriginalServletRequest(request).getParameter("adminSiteId"),sites.get(0).getId());
		_log.info("from http request Site Id : "+siteId);
		int expenseId = GetterUtil.getInteger(PortalUtil.getOriginalServletRequest(request).getParameter("expenseId"),1);

		renderRequest.getPortletSession().setAttribute("siteId", siteId);
		renderRequest.getPortletSession().setAttribute("expenseId", expenseId);
		try {
				ExpenseCatagory expenseCatagory = expeseRevenueService.getExpenseRevenueMetaData(siteId);
				_log.info(expenseCatagory);
				SortedSet<Division> divisions = expenseCatagory.getDivisions();
				_log.info("divisions size : "+divisions.size());
				renderRequest.setAttribute("divisions",divisions );
			} catch (Exception e) {
				_log.error("Error while getting expenseCatagory  : "+e);	
				e.printStackTrace();
			} 
		
		PortletRequestDispatcher prd = getPortletContext()
				.getRequestDispatcher("/html/admin/view.jsp");
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		boolean loggedIn = themeDisplay.isSignedIn();
		if (!loggedIn){
			prd = getPortletContext().getRequestDispatcher("/html/admin/signin.jsp");
		}
		
		prd.include(renderRequest, renderResponse);
	}
	

	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {

		_log.info("serveResource called");
		
		String cmd = ParamUtil.getString(resourceRequest, "cmd");
		String cmdType = ParamUtil.getString(resourceRequest, "cmdType");
		String context = ParamUtil.getString(resourceRequest, "context");
		User user = null;
		try {
			user = PortalUtil.getUser(resourceRequest);
		} catch (PortalException e1) {
			_log.error(e1.getMessage());
			e1.printStackTrace();
		} catch (SystemException e1) {
			_log.error(e1.getMessage());
			e1.printStackTrace();
		}
		
		_log.info("serveResource command is: "+cmd +" with cmdType(optional): "+cmdType +" with context(optional): "+context);
		
		if (cmd.equals("list")) {
			ExpenseRevenueQuery q=  null;
			try {
					q= createExpenseRevenueQuery(context);
					resourceRequest.getPortletSession().setAttribute("siteId", q.getSiteId());
					resourceRequest.getPortletSession().setAttribute("expenseId", q.getExpenseId());
				
				_log.info("q = "+q);
				ExpenseRevenueResult r = expeseRevenueService.getExpenseRevenue(q);
			//	_log.info(r.getExpenseCatagory());
				JSONObject json = null;
				if(doesDateExist(r)){
					json =  convertToJSON( r );
				}else{
					// see if partial data exist
					String partialData = expeseRevenueService.getPartialExpenseRevenueData(q.getSiteId(), q.getMonth(), q.getYear());
					if(partialData == null ){
						json = JSONFactoryUtil.createJSONObject();
						json.put("msg", "Data is empty");
					}
					else{
						// load partial data
						json = JSONFactoryUtil.createJSONObject();
						json.put("msg", "Partial data exist");
						json.put("data", partialData);
					}
				}			
				
				//r.getExpenseCatagory().getNameId().
			//	_log.info(r);
				//_log.info(json);
				writeJSON(resourceRequest, resourceResponse, json);
			} catch (SystemException e) {
				_log.error(e.getMessage());
				e.printStackTrace();
			} catch (PortalException e) {
				_log.error(e.getMessage());
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				_log.error(e.getMessage());
				e.printStackTrace();
			}
			
		} else if (cmd.equals("update")) {	
			try {
				List<ExpenseRevenueSaveUpdate> l = null;
				if(cmdType.equalsIgnoreCase("total")){
					l  = convertToExpenseRevenueSaveUpdateListTotal( context, user.getScreenName());
					checkAndDeletePartialData( context);
				}else{
					l  = convertToExpenseRevenueSaveUpdateList( context, user.getScreenName());
				}
				_log.info("l size : "+l.size());
				JSONObject json = JSONFactoryUtil.createJSONObject();
				if(!l.isEmpty()){
					expeseRevenueService.saveOrUpdateExpenseRevenue(l);		
					json.put("msg", "update was successful");
					writeJSON(resourceRequest, resourceResponse, json); 
				}else{
				_log.error("context is blank or not formatted correctly");
				json.put("msg", "context is blank or not formatted correctly");
				writeJSON(resourceRequest, resourceResponse, json);
				}
			}
			catch (Exception e) {
				_log.error(e.getMessage());
				e.printStackTrace();
			}
		} if(cmd.equals("save")){
			try {
				JSONObject json = JSONFactoryUtil.createJSONObject(context);
				String month = json.getString("month") ;
				int year = json.getInt("year"); 
				int siteId = json.getInt("siteid") ; 
				expeseRevenueService.savePartialExpenseRevenueData(siteId, month, year, context);
				JSONObject retJson = JSONFactoryUtil.createJSONObject();
				retJson.put("msg", "update was successful");
				writeJSON(resourceRequest, resourceResponse, retJson);
			} catch (JSONException e) {
				_log.error(e);
			} catch (Exception e) {
				_log.error(e);
			}
		}
		else{
			_log.info("serveResource command not found for this call!");
		}		
	}
	
	private void checkAndDeletePartialData(String context){
		try {
			JSONObject json = JSONFactoryUtil.createJSONObject(context);
			String month = json.getString("month");
			int year = json.getInt("year");
			int siteId = json.getInt("siteid") ; 
			expeseRevenueService.deletePartialExpenseRevenueData(siteId, month, year);
		}
		catch(Exception ex){
			_log.error(ex);
		}
	}

	private boolean doesDateExist(ExpenseRevenueResult r){
		boolean exist = true;
		try{
			if(r.getExpenseCatagory().getDivisions().first().getProductLines().first().getExpenseDetails() == null || r.getExpenseCatagory().getDivisions().first().getProductLines().first().getExpenseDetails().isEmpty()){
				exist = false;
			}
		}catch(Exception e){
			exist = false;
			_log.error(e.getMessage());
		}
		
		return exist;
	}
	
	private ExpenseRevenueQuery createExpenseRevenueQuery(String context){
		ExpenseRevenueQuery erq = null;
		try {
			JSONObject json = JSONFactoryUtil.createJSONObject(context);	
			erq = new ExpenseRevenueQuery(json.getString("month"), json.getInt("year"), json.getInt("expenseId"), json.getInt("siteId"));
			
		} catch (JSONException e) {
			_log.error(e);
			e.printStackTrace();
		}
		return erq;
	}
	
	private ExpenseRevenueQuery createExpenseRevenueQueryFromId(String context,int siteId){
		ExpenseRevenueQuery erq = null;
		if(context == null || context.isEmpty()){
			return null;
		}
		context =context.trim();
		if(context.startsWith("{")){
			try {
				JSONObject json = JSONFactoryUtil.createJSONObject(context);
				String id = json.getString("id");
				if(id == null || id.isEmpty()){
					return null;
				}
				String[] ids= id.split("\\.");				
				int expenseId = GetterUtil.getInteger(ids[2], -1);
				String date = ids[1];
				int month = GetterUtil.getInteger(date.substring(2,4));
				int year = GetterUtil.getInteger(date.substring(4,8));
				erq = new ExpenseRevenueQuery(months[month-1],year,expenseId,siteId);
			}catch(Exception ex ){}
		}
		return erq;

	}
	
	private List<ExpenseRevenueSaveUpdate> convertToExpenseRevenueSaveUpdateListTotal(String context,String updatedBy){
		List<ExpenseRevenueSaveUpdate> list = new ArrayList<ExpenseRevenueSaveUpdate>();
		ExpenseRevenueSaveUpdate e;
		try {
			JSONObject json = JSONFactoryUtil.createJSONObject(context);
			JSONArray holidays = json.getJSONArray("holiday");
			String month = json.getString("month");
			int year = json.getInt("year");
			JSONArray totals = json.getJSONArray("total");
			_log.info("month  = "+getMonth(month));
			Calendar mycal = new GregorianCalendar(year, getMonth(month), 1);
			int workdays = calculateWorkingDays(year, getMonth(month), holidays);
			_log.info("workdays = "+workdays);
			
			int daysInMonth = mycal.getActualMaximum(Calendar.DAY_OF_MONTH); 
			for(int i=1; i<=daysInMonth;i++){			
				for(int t = 0; t < totals.length(); t++){
					JSONObject j = totals.getJSONObject(t);
					int rpdpId = j.getInt("rpdpId");
					int categoryId = j.getInt("categoryId");
					double target = java.lang.Math.round(j.getDouble("value",0)/workdays);
					int dayOfWeek = mycal.get(Calendar.DAY_OF_WEEK);
					
				//	_log.info("rpdpId = "+rpdpId);
				//	_log.info("categoryId = "+categoryId);
				//	_log.info("target = "+target);
				//	_log.info("dayOfWeek = "+dayOfWeek);
					
					
				if (dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY ) {
				//	_log.info("This is weekeend");
					e = new ExpenseRevenueSaveUpdate(rpdpId, categoryId ,i,
							month , year , null,null, null, GetterUtil.getString(updatedBy) );
				}else if(isHoliday(i,  holidays)){
				//	_log.info("This is Holiday");
					e = new ExpenseRevenueSaveUpdate(rpdpId, categoryId ,i,
							month , year , true,null, null, GetterUtil.getString(updatedBy) );
				}else{
					e = new ExpenseRevenueSaveUpdate(rpdpId, categoryId ,i,
							month , year , null,target, null, GetterUtil.getString(updatedBy) );
				}
				list.add(e);
				//_log.info(e);
			}
				mycal.set(Calendar.DATE, i+1);
			}
			
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return list;
		
	}
	
	private int getMonth(String month){
		int m = -1;
		 for(int i = 0; i< months.length;i++){
			 if(month.equalsIgnoreCase(months[i])){
				 return i;
			 }
		 }
		return m;
	}
	private int calculateWorkingDays(int year, int month,JSONArray holidays){
		int workDays = 0;
		Calendar mycal = new GregorianCalendar(year,month, 1);
		int daysInMonth = mycal.getActualMaximum(Calendar.DAY_OF_MONTH); 
		_log.info("daysInMonth = "+daysInMonth);
		
		for(int i=1; i<=daysInMonth;i++){			
			int dayOfWeek = mycal.get(Calendar.DAY_OF_WEEK);
			mycal.set(Calendar.DATE, i+1);
			if (dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY ) {
				_log.info( i +" is weekeend");
				continue;
			}else if(isHoliday(i,  holidays)){
				_log.info(i + " is Holiday");
				continue;
			}else{
				workDays++;
			}
		}
		
		return workDays;
		
		
	}
	private boolean isHoliday(int day, JSONArray holidays){
		boolean isHoliday = false;
		for(int i = 0; i<holidays.length();i++){
			if(day == holidays.getInt(i)){
				return true;
			}
		}
		return isHoliday;
		
	}
	
	private List<ExpenseRevenueSaveUpdate> convertToExpenseRevenueSaveUpdateList(String context,String updatedBy){
		_log.info("context : "+context);
	
		if(context == null || context.isEmpty()){
			return null;
		}
		context =context.trim();
		List<ExpenseRevenueSaveUpdate> list = new ArrayList<ExpenseRevenueSaveUpdate>();
		
		ExpenseRevenueSaveUpdate e;
		if(context.startsWith("{")){
			try {
				JSONObject json = JSONFactoryUtil.createJSONObject(context);
				String id = json.getString("id");
				if(id == null || id.isEmpty()){
					return null;
				}
				String[] ids= id.split("\\.");
				String[] reIds = ids[3].split("_");
				String[] rpdpIds = ids[0].split("_");
				
				int reId = -1;
				int rpdpId =  -1;
				int expenseId = GetterUtil.getInteger(ids[2], -1);
				String date = ids[1];
				int month = GetterUtil.getInteger(date.substring(2,4));
				int day = GetterUtil.getInteger(date.substring(0,2));
				int year = GetterUtil.getInteger(date.substring(4,8));
				String column = json.getString("column");		
				Double actual = null;
				Double target = null;
				Boolean isHoliday = null;
				JSONArray rows = json.getJSONArray("rows");
				
				if(column.startsWith("target") || column.startsWith("actual")){
					int index = GetterUtil.getInteger(column.substring(6));
					_log.info("index : "+index);
					if(rows==null || rows.length()==0){
						reId=GetterUtil.getInteger(reIds[index-1],-1);
					}
					rpdpId = GetterUtil.getInteger(rpdpIds[rpdpIds.length- index],-1);					
					if (column.startsWith("actual")){
						actual = json.getDouble("value");
					}else{
						target = json.getDouble("value");
					}
				}else if (column.startsWith("holiday")){
					isHoliday = json.getBoolean("value");					
					_log.info("isHoliday :"+isHoliday);
					for(int i = 0; i< rpdpIds.length ; i++){
							for(NameId ec : expenseCatoryList){
								e = new ExpenseRevenueSaveUpdate(GetterUtil.getInteger(rpdpIds[i]), ec.getId() ,day,
										months[month-1] , year , isHoliday,target, actual, GetterUtil.getString(updatedBy) );
								list.add(e);
							}
					}

					return list;
				}
				
			
				if(reId <=0 && rpdpId == -1){
					_log.error("Both  reId  & rpdpId are not present. One should be there !  ");
					return null;
				}
				 
				if(reId > 0){
					e = new ExpenseRevenueSaveUpdate(reId, rpdpId,target, actual ,isHoliday,GetterUtil.getString(updatedBy));
					
				}else{
					if(rows==null || rows.length()==0){
						 e = new ExpenseRevenueSaveUpdate(rpdpId, expenseId ,day,
									months[month-1] , year , isHoliday,target, actual, GetterUtil.getString(updatedBy) );
					}else{
						for(int i = 0; i< rows.length();i++){	
							date = rows.getString(i);
							day = GetterUtil.getInteger(date.substring(0,2));
							e = new ExpenseRevenueSaveUpdate(rpdpId, expenseId ,day,
									months[month-1] , year , isHoliday,target, actual, GetterUtil.getString(updatedBy) );
							list.add(e);
							_log.info("ExpenseRevenueSaveUpdate : "+e);
						}
						return list;
					}
					
					
				}
				_log.info("ExpenseRevenueSaveUpdate : "+e);
				list.add(e);						
				
			} catch (JSONException ex) {
				_log.error(ex.getMessage());
				ex.printStackTrace();
			}
		}else {
			_log.error("could not recognise context values :  "+context);
		}
				
		return list;
	}

	private ExpenseRevenueSaveUpdate createExpenseRevenueSaveUpdate(JSONObject json,String updatedBy){
		String id = json.getString("id");
		if(id == null || id.isEmpty()){
			return null;
		}
		String[] ids= id.split("\\.");
		String[] reIds = ids[3].split("_");
		String[] rpdpIds = ids[0].split("_");
		
		int reId = -1;
		int rpdpId =  -1;
		int expenseId = GetterUtil.getInteger(ids[2], -1);
		String date = ids[1];
		int month = GetterUtil.getInteger(date.substring(2,4));
		int day = GetterUtil.getInteger(date.substring(0,2));
		int year = GetterUtil.getInteger(date.substring(4,8));
		String column = json.getString("column");		
		Double actual = null;
		Double target = null;
		boolean isHoliday = false;
				
		if(column.startsWith("target")){
			_log.info("column.lastIndexOf('t')");
			int index = GetterUtil.getInteger(column.substring(6));
			_log.info("index : "+index);
			reId=GetterUtil.getInteger(reIds[index-1],-1);
			rpdpId = GetterUtil.getInteger(rpdpIds[rpdpIds.length- index],-1);
			target = json.getDouble("value");;
		}else if (column.startsWith("actual")){
			int index = GetterUtil.getInteger(column.substring(6));
			_log.info("index : "+index);
			reId=GetterUtil.getInteger(reIds[index-1],-1);
			rpdpId = GetterUtil.getInteger(rpdpIds[rpdpIds.length- index],-1);
			actual = json.getDouble("value");;
		}else if (column.startsWith("holiday")){
			isHoliday = json.getBoolean("value");
			_log.info("isHoliday :"+isHoliday);
			
			reId=GetterUtil.getInteger(reIds[0],-1);
			rpdpId = GetterUtil.getInteger(rpdpIds[0],-1);
		}
		
		ExpenseRevenueSaveUpdate e;
		if(reId <=0 && rpdpId == -1){
			_log.error("Both  reId  & rpdpId are not present. One should be there !  ");
			return null;
		}
		 
		if(reId > 0){
			e = new ExpenseRevenueSaveUpdate(reId, rpdpId,target, actual ,isHoliday,GetterUtil.getString(updatedBy));
			
		}else{
			 e = new ExpenseRevenueSaveUpdate(rpdpId, expenseId ,day,
					months[month-1] , year , isHoliday,target, actual, GetterUtil.getString(updatedBy) );
			
		}
		_log.info("ExpenseRevenueSaveUpdate : "+e);
		return e;
	}
	
	private boolean checkTotalTarget(ExpenseRevenueResult r){
		boolean isNewRevExp = true;
		ExpenseCatagory ec = r.getExpenseCatagory();
		Double target = 0.0;
		for(Division d: ec.getDivisions()){				
			for(ProductLine p : d.getProductLines()){
				if(p.getTotal()!=null){
				target = target + p.getTotal().getTaget();
				}
			}
		}
		if(target>0){
			isNewRevExp = false;
		}
		return isNewRevExp;
	}
	
	private JSONObject convertToJSON(ExpenseRevenueResult r ){
		
		ExpenseCatagory ec = r.getExpenseCatagory();
		JSONObject json = JSONFactoryUtil.createJSONObject();

		JSONArray jsonMetaArray = JSONFactoryUtil.createJSONArray();
		
		jsonMetaArray.put( getColumnDef("date","DATE","string",false) );
		jsonMetaArray.put( getColumnDef("holiday","Holiday","boolean",false) );
		jsonMetaArray.put( getColumnDef("day","DAY","string",false) );

		
		int columnCount = 0;
		for(Division d: ec.getDivisions()){				
			for(ProductLine p : d.getProductLines()){
				columnCount++;
				jsonMetaArray.put( getColumnDef("target"+(columnCount),"Target","float",true) );
				jsonMetaArray.put( getColumnDef("actual"+(columnCount),"Actual","float",true) );
			}
			}
		
		json.put("metadata", jsonMetaArray );

		JSONArray jsonDataArray = JSONFactoryUtil.createJSONArray();
		
		Map<Date, JSONObject> map = new TreeMap<Date, JSONObject>(new Comparator<Date>() {
			public int	compare(Date o1, Date o2){
				return o1.compareTo(o2);
				
			}
		});
		
		
		int index = 0;
		for(Division d: ec.getDivisions()){		
			
			for(ProductLine p : d.getProductLines()){
				index++;				
				if(p.getExpenseDetails() !=null)
				for(ExpenseDetail e: p.getExpenseDetails()){					
					JSONObject data  = map.get(e.getDay().getDate());
					JSONObject values= null;
					if(data == null){
						data = JSONFactoryUtil.createJSONObject();	
						values = JSONFactoryUtil.createJSONObject();
						data.put("values", values);
						data.put("id", p.getRpdpId()+"."+e.getDay().getFormattedDate().replace("/", "")+"."+ec.getNameId().getId()+"."+e.getReId());
						map.put(e.getDay().getDate(), data);
						//data  = map.get(e.getDay().getDate());
						values.put("date", e.getDay().getFormattedDate());
						values.put("holiday", e.getDay().isHoliday());
						values.put("day", e.getDay().getDayofWeek());
						values.put("target"+index, e.getTaget());
						values.put("actual"+index, e.getActual());
					}else{
						String newId = p.getRpdpId()+"_"+data.getString("id")+"_"+e.getReId();
						data.put("id", newId);						
						values = data.getJSONObject("values");
						values.put("target"+index, e.getTaget());
						values.put("actual"+index, e.getActual());
					}									
				}
				
			}
		}
		
		for (Map.Entry<Date, JSONObject> entry : map.entrySet()) {
			jsonDataArray.put(entry.getValue());		   
		}
		_log.info("jsonDataArray size = "+jsonDataArray.length());
		json.put("data", jsonDataArray );
		return json;
	}
	
	private int getTotalProductLines(ExpenseRevenueResult r){
		int productLineCount = 0;
		ExpenseCatagory ec = r.getExpenseCatagory();
		_log.info("division size = "+ec.getDivisions().size());
		_log.info("Product Size = "+ec.getDivisions().first().getProductLines().size());
		productLineCount = ec.getDivisions().size() * ec.getDivisions().first().getProductLines().size();
		
		
		_log.info("productLineCount : "+productLineCount);
		
		return productLineCount;
	}
	
	
	public JSONObject getColumnDef(String name, String label, String type, boolean editable){
		
		JSONObject jsonMetaData = JSONFactoryUtil.createJSONObject();

		jsonMetaData.put("name", name );
		jsonMetaData.put("label", label );
		jsonMetaData.put("datatype", type );
		jsonMetaData.put("bar", true );
		jsonMetaData.put("editable", editable );

		return jsonMetaData;
		
	}
	
	public JSONObject addRecord(String id, String date, float revenuePlan, float revenueActual){

		JSONObject jsonValues = JSONFactoryUtil.createJSONObject();
		JSONObject jsonData = JSONFactoryUtil.createJSONObject();

		jsonValues.put("date",date);
		jsonValues.put("revenuePlan",revenuePlan);
		jsonValues.put("revenueActual",revenueActual);
	
		jsonData.put("id", id );
		jsonData.put("values", jsonValues );
		
		return jsonData;
	}
	
	private static Log _log = LogFactoryUtil.getLog(DelphiFinancialsAdminPortlet.class);

}