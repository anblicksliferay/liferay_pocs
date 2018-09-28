package com.delphi.portlet.service.impl;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.delphi.portlet.model.DashBoardQuery;
import com.delphi.portlet.model.DashBoardResults;
import com.delphi.portlet.model.Day;
import com.delphi.portlet.model.Division;
import com.delphi.portlet.model.ExpenseCatagory;
import com.delphi.portlet.model.ExpenseDetail;
import com.delphi.portlet.model.NameId;
import com.delphi.portlet.model.ProductLine;
import com.delphi.portlet.model.Region;
import com.delphi.portlet.model.Site;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ThreadLocalRandom;

public class DashBoardServiceMock  {
	private static Log logger = LogFactoryUtil
			.getLog(DashBoardServiceMock.class);

	private static BufferedWriter dataMaster_bw;
	private static BufferedWriter revenue_bw;
	public static void main(String[] args) throws IOException{
		
		try {	
			FileWriter dm_fw = new FileWriter(DATEMASTER_FILE,false);
			dataMaster_bw = new BufferedWriter(dm_fw);
			
			FileWriter rv_fw = new FileWriter(REVENUE_FILE,false);
			revenue_bw = new BufferedWriter(rv_fw);
		
		createDates();
		crateRevenueExpense();
		
		dataMaster_bw.close();
		revenue_bw.close();
		dm_fw.close();
		rv_fw.close();
		}catch(Exception e){
			
		}
	}
	
	public List<com.delphi.portlet.model.Site> getAllSites() {

		return null;
	}
    private static String[] shortMonths = new DateFormatSymbols().getShortMonths();
    private static String[] months = new DateFormatSymbols().getMonths();
    private static  String[] weekdays = new DateFormatSymbols().getWeekdays();
    private static final String DATEMASTER_FILE = "C:\\test\\dateMaster.sql";
    private static final String REVENUE_FILE = "C:\\test\\revenue.sql";
    
    private static  Calendar startDate = new GregorianCalendar(2014,0,1);
    private static  Calendar endDate = new GregorianCalendar(2016,11,31);
    
    private static FileWriter dataMaster_fw;
    private static FileWriter revenue_fw;
    
    private static List<Integer> dateIds = new ArrayList<Integer>();
    
    private static void crateRevenueExpense(){
    	DashBoardResults dashBoardResults = new DashBoardResults();
		List<Site> sites = new ArrayList<Site>();
		Site s;
		s = new Site();
		s.setNameId(new NameId(1, "Kokomo (Indiana, USA)"));
		sites.add(s);
		s.setCatagories(createExpenseCatagoryList());
		s = new Site();
		s.setNameId(new NameId(2, "Reynosa (Tamaulipas, Mexico)"));
		sites.add(s);
		s.setCatagories(createExpenseCatagoryList());
		s = new Site();
		s.setNameId(new NameId(3, "Matamoros (Tamaulipas, Mexico)"));
		sites.add(s);
		s.setCatagories(createExpenseCatagoryList());
		s = new Site();
		s.setNameId(new NameId(4, "Jambiero (Brazil)"));
		sites.add(s);
		s.setCatagories(createExpenseCatagoryList());
		s = new Site();
		s.setNameId(new NameId(5, "Barcelona (Spain)"));
		sites.add(s);
		s.setCatagories(createExpenseCatagoryList());
		s = new Site();
		s.setNameId(new NameId(6, "Braga (Portugal)"));
		sites.add(s);
		s.setCatagories(createExpenseCatagoryList());
		s = new Site();
		s.setNameId(new NameId(7, "Gdansk (Poland)"));
		sites.add(s);
		s.setCatagories(createExpenseCatagoryList());
		s = new Site();
		s.setNameId(new NameId(8, "Osberghausen (Germany)"));
		sites.add(s);
		s.setCatagories(createExpenseCatagoryList());
		s = new Site();
		s.setNameId(new NameId(9, "St. Aubin (France)"));
		sites.add(s);
		s.setCatagories(createExpenseCatagoryList());
		s = new Site();
		s.setNameId(new NameId(10, "Szombathely (Hungary)"));
		sites.add(s);
		s.setCatagories(createExpenseCatagoryList());
		s = new Site();
		s.setNameId(new NameId(11, "Chennai (India)"));
		sites.add(s);
		s.setCatagories(createExpenseCatagoryList());
		s = new Site();
		s.setNameId(new NameId(12, "Suzhou (China)"));
		sites.add(s);
		s.setCatagories(createExpenseCatagoryList());
		s = new Site();
		s.setNameId(new NameId(13, "Singapore"));
		sites.add(s);
		s.setCatagories(createExpenseCatagoryList());
		s = new Site();
		s.setNameId(new NameId(14, "Macedonia"));
		sites.add(s);
		//s.setCatagories(createExpenseCatagoryList());
		
		List<ExpenseCatagory>  catagories = createExpenseCatagoryList();
		List<Region> regions = new ArrayList<Region>();
		Region r;
		r = new Region();
		r.setNameId(new NameId(1, "Americas"));
		regions.add(r);
		r.setSites(sites.subList(0, 4));
		r = new Region();
		r.setNameId(new NameId(2, "EMEA "));
		regions.add(r);
		r.setSites(sites.subList(4, 10));
		r = new Region();
		r.setNameId(new NameId(3, "Asia"));
		regions.add(r);
		r.setSites(sites.subList(10, 14));

		long reId = 201;
		for (ExpenseCatagory ec : catagories) {
			//addDivision( sites, ec);		
				for(Site site: sites){
					SortedSet<Division> divisions = addDivisionProductLine(site);					
					for (Division d : divisions) {
						logger.info("Division Id : "+d.getNameId().getId());
						for (ProductLine p : d.getProductLines()) {
							logger.info("ProductLine Id : "+p.getNameId().getId());
							
							Calendar temp = Calendar.getInstance();
							temp.setTime(startDate.getTime());
							int dateId = Integer.parseInt((temp.get(Calendar.MONTH)+1) +""+temp.get(Calendar.YEAR));
							reId++;
							createRevenueInsert( reId,dateId, p.getRpdpId(), ec.getNameId().getId());
							while(temp.before(endDate) || temp.equals(endDate)){
								reId++;
								dateId = Integer.parseInt((temp.get(Calendar.MONTH)+1)+""+(temp.get(Calendar.DATE) < 10 ?"0"+temp.get(Calendar.DATE):temp.get(Calendar.DATE)) +""+temp.get(Calendar.YEAR));
								createRevenueInsert(reId, dateId, p.getRpdpId(), ec.getNameId().getId());
								temp.add(Calendar.DATE, 1);;
							}

							
						}
					}
				}
				
			
		}
			
		
		
    }

private static void  createRevenueInsert(long reId, int dateId, int rpdpId, int expenseId) {	
	
	StringBuffer sb = new StringBuffer("insert into Revenue_Expense  (reId, dateId, rpdpId, expenseId,expected,actual,isHoliday,updatedBy,createDate,modifiedDate) values(");
	sb.append(reId).append(",");
	sb.append(dateId).append(",");
	sb.append(rpdpId).append(",");
	sb.append(expenseId).append(",");	
	sb.append(showRandomInteger(300,500)*1000).append(",");
	sb.append(showRandomInteger(200,400)*1000).append(",");
	sb.append(0).append(",");
	sb.append("'").append("manish").append("'").append(",");
	sb.append("'").append(new java.sql.Date(startDate.getTimeInMillis())).append("'").append(",");
	sb.append("'").append(new java.sql.Date(startDate.getTimeInMillis())).append("'");
	
	sb.append(");");
	writeToFile(revenue_bw,sb);
}
    
private static int showRandomInteger(int aStart, int aEnd){
	Random aRandom = new Random();
    if (aStart > aEnd) {
      throw new IllegalArgumentException("Start cannot exceed End.");
    }
    //get the range, casting to long to avoid overflow problems
    long range = (long)aEnd - (long)aStart + 1;
    // compute a fraction of the range, 0 <= frac < range
    long fraction = (long)(range * aRandom.nextDouble());
    return (int)(fraction + aStart); 
  }
  
	private static void createDates(){
		
		StringBuffer sb ;
		Calendar temp = Calendar.getInstance();
		temp.setTime(startDate.getTime());
		while(temp.before(endDate) || temp.equals(endDate)){
			
			if(temp.get(Calendar.DATE) == 1){
				sb = new StringBuffer("INSERT INTO `lportal`.`date_master`(`dateId`,`dateVal`,`monthName`,`monthDisplayName`,`year`,`dayOfWeek`,`isWeekend`,`isGenericDom`,`createDate`,`modifiedDate`) VALUES(");
				dateIds.add(Integer.parseInt(temp.get(Calendar.MONTH)+1+""+temp.get(Calendar.YEAR)));
				sb.append(Integer.parseInt(temp.get(Calendar.MONTH)+1+""+temp.get(Calendar.YEAR))).append(",");
				sb.append("'").append(new java.sql.Date(temp.getTimeInMillis())).append("'").append(",");
				sb.append("'").append(months[temp.get(Calendar.MONTH)]).append("'").append(",");
				sb.append("'").append(shortMonths[temp.get(Calendar.MONTH)]).append(" "+temp.get(Calendar.YEAR)).append("'").append(",");
				sb.append(temp.get(Calendar.YEAR)).append(",");
				sb.append("'").append(weekdays[temp.get(Calendar.DAY_OF_WEEK)]).append("'").append(",");
				sb.append(0).append(",");
				sb.append(1).append(",");
				sb.append("'").append(new java.sql.Date(temp.getTimeInMillis())).append("'").append(",");
				sb.append("'").append(new java.sql.Date(temp.getTimeInMillis())).append("'");
				sb.append(");");
				writeToFile(dataMaster_bw,sb);
				
			}
			sb = new StringBuffer("INSERT INTO `lportal`.`date_master`(`dateId`,`dateVal`,`monthName`,`monthDisplayName`,`year`,`dayOfWeek`,`isWeekend`,`isGenericDom`,`createDate`,`modifiedDate`) VALUES(");
			sb.append(Integer.parseInt(temp.get(Calendar.MONTH)+1+""+(temp.get(Calendar.DATE) < 10 ?"0"+temp.get(Calendar.DATE):temp.get(Calendar.DATE)) +""+temp.get(Calendar.YEAR))).append(",");
			dateIds.add(Integer.parseInt(temp.get(Calendar.MONTH)+1+""+(temp.get(Calendar.DATE) < 10 ?"0"+temp.get(Calendar.DATE):temp.get(Calendar.DATE))));
			sb.append("'").append(new java.sql.Date(temp.getTimeInMillis())).append("'").append(",");
			sb.append("'").append(months[temp.get(Calendar.MONTH)]).append("'").append(",");
			sb.append("'").append(shortMonths[temp.get(Calendar.MONTH)]).append(" "+temp.get(Calendar.YEAR)).append("'").append(",");
			sb.append(temp.get(Calendar.YEAR)).append(",");
			sb.append("'").append(weekdays[temp.get(Calendar.DAY_OF_WEEK)]).append("'").append(",");
			sb.append(0).append(",");
			sb.append(0).append(",");
			sb.append("'").append(new java.sql.Date(temp.getTimeInMillis())).append("'").append(",");
			sb.append("'").append(new java.sql.Date(temp.getTimeInMillis())).append("'");
			sb.append(");");
			
			writeToFile(dataMaster_bw,sb);
			temp.add(Calendar.DATE, 1);
		}
		
	}
	
	private static void writeToFile(BufferedWriter bw,StringBuffer sb){
		try {
			bw.write(sb.toString());
			bw.write("\n");
			System.out.println("Done");

		} catch (IOException e) {

			e.printStackTrace();

		} 

	}
	

	public DashBoardResults getTotalExpenseRevenue(DashBoardQuery query) {
		DashBoardResults dashBoardResults = new DashBoardResults();
		List<Site> sites = new ArrayList<Site>();
		Site s;
		s = new Site();
		s.setNameId(new NameId(1, "Kokomo (Indiana, USA)"));
		sites.add(s);
		s.setCatagories(createExpenseCatagoryList());
		s = new Site();
		s.setNameId(new NameId(2, "Reynosa (Tamaulipas, Mexico)"));
		sites.add(s);
		s.setCatagories(createExpenseCatagoryList());
		s = new Site();
		s.setNameId(new NameId(3, "Matamoros (Tamaulipas, Mexico)"));
		sites.add(s);
		s.setCatagories(createExpenseCatagoryList());
		s = new Site();
		s.setNameId(new NameId(4, "Jambiero (Brazil)"));
		sites.add(s);
		s.setCatagories(createExpenseCatagoryList());
		s = new Site();
		s.setNameId(new NameId(5, "Barcelona (Spain)"));
		sites.add(s);
		s.setCatagories(createExpenseCatagoryList());
		s = new Site();
		s.setNameId(new NameId(6, "Braga (Portugal)"));
		sites.add(s);
		s.setCatagories(createExpenseCatagoryList());
		s = new Site();
		s.setNameId(new NameId(7, "Gdansk (Poland)"));
		sites.add(s);
		s.setCatagories(createExpenseCatagoryList());
		s = new Site();
		s.setNameId(new NameId(8, "Osberghausen (Germany)"));
		sites.add(s);
		s.setCatagories(createExpenseCatagoryList());
		s = new Site();
		s.setNameId(new NameId(9, "St. Aubin (France)"));
		sites.add(s);
		s.setCatagories(createExpenseCatagoryList());
		s = new Site();
		s.setNameId(new NameId(10, "Szombathely (Hungary)"));
		sites.add(s);
		s.setCatagories(createExpenseCatagoryList());
		s = new Site();
		s.setNameId(new NameId(11, "Chennai (India)"));
		sites.add(s);
		s.setCatagories(createExpenseCatagoryList());
		s = new Site();
		s.setNameId(new NameId(12, "Suzhou (China)"));
		sites.add(s);
		s.setCatagories(createExpenseCatagoryList());
		s = new Site();
		s.setNameId(new NameId(13, "Singapore"));
		sites.add(s);
		s.setCatagories(createExpenseCatagoryList());
		s = new Site();
		s.setNameId(new NameId(14, "Macedonia"));
		sites.add(s);
		//s.setCatagories(createExpenseCatagoryList());
		
		List<ExpenseCatagory>  catagories = createExpenseCatagoryList();
		List<Region> regions = new ArrayList<Region>();
		Region r;
		r = new Region();
		r.setNameId(new NameId(1, "Americas"));
		regions.add(r);
		r.setSites(sites.subList(0, 4));
		r = new Region();
		r.setNameId(new NameId(2, "EMEA "));
		regions.add(r);
		r.setSites(sites.subList(4, 10));
		r = new Region();
		r.setNameId(new NameId(3, "Asia"));
		regions.add(r);
		r.setSites(sites.subList(10, 14));

		Calendar startDate = Calendar.getInstance();
		startDate.setTime(query.getStartDate());
		
		Calendar endDate = Calendar.getInstance();
		endDate.setTime(query.getEndDate());
		endDate.set(Calendar.DATE, endDate.getMaximum(Calendar.DATE));
		
		for (ExpenseCatagory ec : catagories) {			
			getDivision(query.getRegionId(),query.getSiteId(),regions,ec);
						
		for (Region region : regions) {
			if(query.getRegionId() < 0 || query.getRegionId() == region.getNameId().getId()){
				//logger.info("region Id : "+region.getNameId().getId());
			for (Site site : region.getSites()) {
				if(query.getSiteId() < 0 || query.getSiteId() == site.getNameId().getId()){
					//logger.info("site Id : "+site.getNameId().getId());
					for (Division d : ec.getDivisions()) {
						//logger.info("Division Id : "+d.getNameId().getId());
						for (ProductLine p : d.getProductLines()) {
							//logger.info("ProductLine Id : "+p.getNameId().getId());
							SortedSet<ExpenseDetail> l = new TreeSet<ExpenseDetail>();
							Calendar temp = Calendar.getInstance();
							temp.setTime(startDate.getTime());
							while(temp.before(endDate)){
								l.add(createMonthlyExpense(temp));
								temp.add(Calendar.DATE, 1);;
							}

							p.setExpenseDetails(l);
						}
					}
				}
			}
			}
		}
		
			}
		
		dashBoardResults.setExpenseCatagory(catagories);

		return dashBoardResults;
	}

	private ExpenseDetail createMonthlyExpense(Calendar c) {		
		ExpenseDetail e;
		Day d;
		double target = ThreadLocalRandom.current().nextDouble(100);
		double actual = ThreadLocalRandom.current().nextDouble(target);		
			e = new ExpenseDetail();
			d = new Day();d.setDate(c.getTime());
			e.setDay(d);
			e.setTaget(target);
			e.setActual(actual);
		return e;
	}
	private static void  getDivision(int regionId,int siteId,List<Region> regions,ExpenseCatagory ec){
		List<Site> sites = new ArrayList<Site>();
		for(Region region: regions){
			if(regionId < 1 || region.getNameId().getId() == regionId){
				List<Site> ss = region.getSites();
				for(Site s:ss){
					if(siteId < 1 || s.getNameId().getId() == siteId){
						sites.add(s);
					}
				}
			}
		}
		logger.info("Size of site : "+sites.size());
		addDivision( sites, ec);
		
	}
	
private static Division getDivision(SortedSet<Division> divisions,int divisionId){
		
		for(Division dv : divisions){
			if(dv.getNameId().getId() == divisionId){
				return dv;
			}
		}
		return null;
	}
	
private static ProductLine getProductLine(SortedSet<ProductLine> productLines,int productLineId){
	
	for(ProductLine dv : productLines){
		if(dv.getNameId().getId() == productLineId){
			return dv;
		}
	}
	return null;
}
	private  static void addDivision(List<Site> sites,ExpenseCatagory ec) {
		Division d;
		ProductLine p;
		SortedSet<ProductLine> productLines;
		SortedSet<Division> divisions;
		for (Site s : sites) {
			switch (s.getNameId().getId()) {
			case 1:
					divisions = ec.getDivisions();
					if(divisions == null){
						divisions = new TreeSet<Division>();
						ec.setDivisions(divisions);
					}
					d = getDivision(divisions, 2);
					if(d == null){
						d = new Division();
						d.setNameId(new NameId(2, "PT"));
						productLines = new TreeSet<ProductLine>();
						d.setProductLines(productLines);
						p = new ProductLine();
						p.setRpdpId(1);
						p.setNameId(new NameId(3, "PTG"));
						productLines.add(p);
						d.setProductLines(productLines);
						divisions.add(d);
						break;
					}
					p = getProductLine(d.getProductLines(), 3);
					
					if(p == null){
						p = new ProductLine();
						p.setRpdpId(1);
						p.setNameId(new NameId(3, "PTG"));
						d.getProductLines().add(p);
						
					}	

				break;

			case 2:
				divisions = ec.getDivisions();
				if(divisions == null){
					divisions = new TreeSet<Division>();
					ec.setDivisions(divisions);
				}
				d = getDivision(divisions, 2);
				if(d == null){					
					d = new Division();
					d.setNameId(new NameId(2, "PT"));
					productLines = new TreeSet<ProductLine>();
					d.setProductLines(productLines);
					p = new ProductLine();
					p.setRpdpId(4);
					p.setNameId(new NameId(3, "PTG"));
					productLines.add(p);
					p = new ProductLine();
					p.setRpdpId(5);
					p.setNameId(new NameId(4, "PTD"));
					productLines.add(p);
					d.setProductLines(productLines);
					divisions.add(d);					
					
				}else{
				p = getProductLine(d.getProductLines(), 3);
				
				if(p == null){
					p = new ProductLine();
					p.setRpdpId(4);
					p.setNameId(new NameId(3, "PTG"));
					d.getProductLines().add(p);
					
				}
				p = getProductLine(d.getProductLines(), 4);
				if(p == null){
					p = new ProductLine();
					p.setRpdpId(5);
					p.setNameId(new NameId(4, "PTD"));
					d.getProductLines().add(p);
					
				}
				}
				d = getDivision(divisions, 1);
				if(d == null){					
					d = new Division();
					d.setNameId(new NameId(1, "E&S"));
					productLines = new TreeSet<ProductLine>();
					d.setProductLines(productLines);
					p = new ProductLine();
					p.setRpdpId(2);
					p.setNameId(new NameId(1, "IDI"));
					productLines.add(p);
					p = new ProductLine();
					p.setRpdpId(3);
					p.setNameId(new NameId(2, "EC"));
					productLines.add(p);
					d.setProductLines(productLines);
					divisions.add(d);
					
				}else{
				p = getProductLine(d.getProductLines(), 1);
				
				if(p == null){
					p = new ProductLine();
					p.setRpdpId(2);
					p.setNameId(new NameId(1, "IDI"));
					d.getProductLines().add(p);
					
				}
				p = getProductLine(d.getProductLines(), 2);
				if(p == null){
					p = new ProductLine();
					p.setRpdpId(3);
					p.setNameId(new NameId(2, "EC"));
					d.getProductLines().add(p);
					
				}
				}
				
			break;
				

			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
				divisions = ec.getDivisions();
				if(divisions == null){
					divisions = new TreeSet<Division>();
					ec.setDivisions(divisions);
				}
				d = getDivision(divisions, 1);
				if(d == null){
					divisions = new TreeSet<Division>();
					ec.setDivisions(divisions);
					d = new Division();
					d.setNameId(new NameId(1, "E&S"));
					productLines = new TreeSet<ProductLine>();
					d.setProductLines(productLines);
					p = new ProductLine();
					if(s.getNameId().getId() ==3){
						p.setRpdpId(6);
					}else if(s.getNameId().getId() ==4){
						p.setRpdpId(7);
					}else if(s.getNameId().getId() ==5){
						p.setRpdpId(8);
					}else if(s.getNameId().getId() ==6){
						p.setRpdpId(9);
					}else if(s.getNameId().getId() ==7){
						p.setRpdpId(10);
					}
					p.setNameId(new NameId(1, "IDI"));
					productLines.add(p);
					d.setProductLines(productLines);
					divisions.add(d);
					break;
				}else{
				p = getProductLine(d.getProductLines(), 1);
				
				if(p == null){
					p = new ProductLine();
					if(s.getNameId().getId() ==3){
						p.setRpdpId(6);
					}else if(s.getNameId().getId() ==4){
						p.setRpdpId(7);
					}else if(s.getNameId().getId() ==5){
						p.setRpdpId(8);
					}else if(s.getNameId().getId() ==6){
						p.setRpdpId(9);
					}else if(s.getNameId().getId() ==7){
						p.setRpdpId(10);
					}
					p.setNameId(new NameId(1, "IDI"));
					d.getProductLines().add(p);
					
				}	
				
				}	
				

				break;

			case 8:
			case 9:
				divisions = ec.getDivisions();
				if(divisions == null){
					divisions = new TreeSet<Division>();
					ec.setDivisions(divisions);
				}
				d = getDivision(divisions, 1);
				if(d == null){
					d = new Division();
					d.setNameId(new NameId(1, "E&S"));
					productLines = new TreeSet<ProductLine>();
					d.setProductLines(productLines);
					p = new ProductLine();
					if(s.getNameId().getId() ==8){
						p.setRpdpId(11);
					}else if(s.getNameId().getId() ==9){
						p.setRpdpId(12);
					}
					p.setNameId(new NameId(2, "EC"));
					productLines.add(p);
					d.setProductLines(productLines);
					divisions.add(d);
					break;
				}else{
				p = getProductLine(d.getProductLines(), 2);
				
				if(p == null){
					p = new ProductLine();
					if(s.getNameId().getId() ==8){
						p.setRpdpId(11);
					}else if(s.getNameId().getId() ==9){
						p.setRpdpId(12);
					}
					p.setNameId(new NameId(2, "EC"));
					d.getProductLines().add(p);
					
				}	
				
				}
				break;

			case 10:
			case 12:
				divisions = ec.getDivisions();
				if(divisions == null){
					divisions = new TreeSet<Division>();
					ec.setDivisions(divisions);
				}
				d = getDivision(divisions, 2);
				if(d == null){					
					d = new Division();
					d.setNameId(new NameId(2, "PT"));
					productLines = new TreeSet<ProductLine>();
					d.setProductLines(productLines);
					p = new ProductLine();
					if(s.getNameId().getId() ==10){
						p.setRpdpId(15);
					}else if(s.getNameId().getId() ==12){
						p.setRpdpId(21);
					}
					p.setNameId(new NameId(1, "IDI"));
					productLines.add(p);
					p = new ProductLine();
					if(s.getNameId().getId() ==10){
						p.setRpdpId(16);
					}else if(s.getNameId().getId() ==12){
						p.setRpdpId(22);
					}
					p.setNameId(new NameId(2, "EC"));
					productLines.add(p);
					d.setProductLines(productLines);
					divisions.add(d);

							
					
				}else{
				p = getProductLine(d.getProductLines(), 1);
				
				if(p == null){
					p = new ProductLine();
					if(s.getNameId().getId() ==10){
						p.setRpdpId(15);
					}else if(s.getNameId().getId() ==12){
						p.setRpdpId(21);
					}
					p.setNameId(new NameId(1, "IDI"));
					d.getProductLines().add(p);
					
				}
				p = getProductLine(d.getProductLines(), 2);
				if(p == null){
					p = new ProductLine();
					if(s.getNameId().getId() ==10){
						p.setRpdpId(16);
					}else if(s.getNameId().getId() ==12){
						p.setRpdpId(22);
					}
					p.setNameId(new NameId(2, "EC"));
					d.getProductLines().add(p);
					
				}
				}
				d = getDivision(divisions, 1);
				if(d == null){

					d = new Division();
					d.setNameId(new NameId(1, "E&S"));
					productLines = new TreeSet<ProductLine>();
					d.setProductLines(productLines);
					p = new ProductLine();
					if(s.getNameId().getId() ==10){
						p.setRpdpId(13);
					}else if(s.getNameId().getId() ==12){
						p.setRpdpId(19);
					}
					p.setNameId(new NameId(1, "IDI"));
					productLines.add(p);
					p = new ProductLine();
					if(s.getNameId().getId() ==10){
						p.setRpdpId(14);
					}else if(s.getNameId().getId() ==12){
						p.setRpdpId(20);
					}
					p.setNameId(new NameId(2, "EC"));
					productLines.add(p);
					d.setProductLines(productLines);
					divisions.add(d);
					
				}else{p = getProductLine(d.getProductLines(), 1);
				
				if(p == null){
					p = new ProductLine();
					if(s.getNameId().getId() ==10){
						p.setRpdpId(13);
					}else if(s.getNameId().getId() ==12){
						p.setRpdpId(19);
					}
					p.setNameId(new NameId(1, "IDI"));
					d.getProductLines().add(p);
					
				}
				p = getProductLine(d.getProductLines(), 2);
				if(p == null){
					p = new ProductLine();
					if(s.getNameId().getId() ==10){
						p.setRpdpId(14);
					}else if(s.getNameId().getId() ==12){
						p.setRpdpId(20);
					}
					p.setNameId(new NameId(2, "EC"));
					d.getProductLines().add(p);
					
					
				}
				}
				break;
			case 11:
				
				divisions = ec.getDivisions();
				if(divisions == null){
					divisions = new TreeSet<Division>();
					ec.setDivisions(divisions);
				}
				d = getDivision(divisions, 1);
				if(d == null){
					d = new Division();
					d.setNameId(new NameId(1, "E&S"));
					productLines = new TreeSet<ProductLine>();
					d.setProductLines(productLines);
					p = new ProductLine();
					p.setRpdpId(17);
					p.setNameId(new NameId(1, "IDI"));
					productLines.add(p);
					p = new ProductLine();
					p.setRpdpId(18);
					p.setNameId(new NameId(2, "EC"));
					productLines.add(p);
					d.setProductLines(productLines);
					divisions.add(d);
					break;
				}else{
					
					p = getProductLine(d.getProductLines(), 1);
					
					if(p == null){
						p = new ProductLine();
						p.setRpdpId(17);
						p.setNameId(new NameId(2, "IDI"));
						d.getProductLines().add(p);
						
					}	
				p = getProductLine(d.getProductLines(), 2);
				
				if(p == null){
					p = new ProductLine();
					p.setRpdpId(18);
					p.setNameId(new NameId(2, "EC"));
					d.getProductLines().add(p);
					
				}	
				
				}

				break;
			case 13:
				divisions = ec.getDivisions();
				if(divisions == null){
					divisions = new TreeSet<Division>();
					ec.setDivisions(divisions);
				}
				d = getDivision(divisions, 2);
				if(d == null){					
					d = new Division();
					d.setNameId(new NameId(2, "PT"));
					productLines = new TreeSet<ProductLine>();
					d.setProductLines(productLines);
					p = new ProductLine();
					p.setRpdpId(24);
					p.setNameId(new NameId(1, "IDI"));
					productLines.add(p);
					d.setProductLines(productLines);
					divisions.add(d);							
					
				}else{
				p = getProductLine(d.getProductLines(), 1);
				
				if(p == null){
					p = new ProductLine();
					p.setRpdpId(24);
					p.setNameId(new NameId(1, "IDI"));
					d.getProductLines().add(p);
					
				}
				}
				d = getDivision(divisions, 1);
				if(d == null){


					d = new Division();
					d.setNameId(new NameId(1, "E&S"));
					productLines = new TreeSet<ProductLine>();
					d.setProductLines(productLines);
					p = new ProductLine();
					p.setRpdpId(23);
					p.setNameId(new NameId(2, "EC"));
					productLines.add(p);
					d.setProductLines(productLines);
					divisions.add(d);
					
				}else{
				p = getProductLine(d.getProductLines(), 2);
				if(p == null){
					p = new ProductLine();
					p.setRpdpId(23);
					p.setNameId(new NameId(2, "EC"));
					d.getProductLines().add(p);
					
					
				}
				}
				break;

			case 14:
				divisions = ec.getDivisions();
				if(divisions == null){
					divisions = new TreeSet<Division>();
					ec.setDivisions(divisions);
				}
				d = getDivision(divisions, 1);
				if(d == null){
					d = new Division();
					d.setNameId(new NameId(1, "E&S"));
					productLines = new TreeSet<ProductLine>();
					d.setProductLines(productLines);
					p = new ProductLine();
					p.setRpdpId(25);
					p.setNameId(new NameId(2, "EC"));
					productLines.add(p);
					d.setProductLines(productLines);
					divisions.add(d);
					break;
				}else{
				p = getProductLine(d.getProductLines(), 2);
				
				if(p == null){
					p = new ProductLine();
					p.setRpdpId(25);
					p.setNameId(new NameId(2, "EC"));
					d.getProductLines().add(p);
					
				}				
				}
				break;

			}
		}
	}

	private  static SortedSet<Division>  addDivisionProductLine(Site s) {
		Division d;
		ProductLine p;
		SortedSet<ProductLine> productLines;
		SortedSet<Division> divisions = new TreeSet<Division>();;
		
			switch (s.getNameId().getId()) {
			case 1:
					
					
						d = new Division();
						d.setNameId(new NameId(2, "PT"));
						productLines = new TreeSet<ProductLine>();
						d.setProductLines(productLines);
						p = new ProductLine();
						p.setRpdpId(1);
						p.setNameId(new NameId(3, "PTG"));
						productLines.add(p);
						d.setProductLines(productLines);
						divisions.add(d);
						break;
					
					

			case 2:
								
					d = new Division();
					d.setNameId(new NameId(2, "PT"));
					productLines = new TreeSet<ProductLine>();
					d.setProductLines(productLines);
					p = new ProductLine();
					p.setRpdpId(4);
					p.setNameId(new NameId(3, "PTG"));
					productLines.add(p);
					p = new ProductLine();
					p.setRpdpId(5);
					p.setNameId(new NameId(4, "PTD"));
					productLines.add(p);
					d.setProductLines(productLines);
					divisions.add(d);					
					
									
					d = new Division();
					d.setNameId(new NameId(1, "E&S"));
					productLines = new TreeSet<ProductLine>();
					d.setProductLines(productLines);
					p = new ProductLine();
					p.setRpdpId(2);
					p.setNameId(new NameId(1, "IDI"));
					productLines.add(p);
					p = new ProductLine();
					p.setRpdpId(3);
					p.setNameId(new NameId(2, "EC"));
					productLines.add(p);
					d.setProductLines(productLines);
					divisions.add(d);
					
				
				
			break;
				

			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
				
			
					d = new Division();
					d.setNameId(new NameId(1, "E&S"));
					productLines = new TreeSet<ProductLine>();
					d.setProductLines(productLines);
					p = new ProductLine();
					if(s.getNameId().getId() ==3){
						p.setRpdpId(6);
					}else if(s.getNameId().getId() ==4){
						p.setRpdpId(7);
					}else if(s.getNameId().getId() ==5){
						p.setRpdpId(8);
					}else if(s.getNameId().getId() ==6){
						p.setRpdpId(9);
					}else if(s.getNameId().getId() ==7){
						p.setRpdpId(10);
					}
					p.setNameId(new NameId(1, "IDI"));
					productLines.add(p);
					d.setProductLines(productLines);
					divisions.add(d);
					break;
				

			case 8:
			case 9:
				
					d = new Division();
					d.setNameId(new NameId(1, "E&S"));
					productLines = new TreeSet<ProductLine>();
					d.setProductLines(productLines);
					p = new ProductLine();
					if(s.getNameId().getId() ==8){
						p.setRpdpId(11);
					}else if(s.getNameId().getId() ==9){
						p.setRpdpId(12);
					}
					p.setNameId(new NameId(2, "EC"));
					productLines.add(p);
					d.setProductLines(productLines);
					divisions.add(d);
					break;
				

			case 10:
			case 12:
								
					d = new Division();
					d.setNameId(new NameId(2, "PT"));
					productLines = new TreeSet<ProductLine>();
					d.setProductLines(productLines);
					p = new ProductLine();
					if(s.getNameId().getId() ==10){
						p.setRpdpId(15);
					}else if(s.getNameId().getId() ==12){
						p.setRpdpId(21);
					}
					p.setNameId(new NameId(1, "IDI"));
					productLines.add(p);
					p = new ProductLine();
					if(s.getNameId().getId() ==10){
						p.setRpdpId(16);
					}else if(s.getNameId().getId() ==12){
						p.setRpdpId(22);
					}
					p.setNameId(new NameId(2, "EC"));
					productLines.add(p);
					d.setProductLines(productLines);
					divisions.add(d);


					d = new Division();
					d.setNameId(new NameId(1, "E&S"));
					productLines = new TreeSet<ProductLine>();
					d.setProductLines(productLines);
					p = new ProductLine();
					if(s.getNameId().getId() ==10){
						p.setRpdpId(13);
					}else if(s.getNameId().getId() ==12){
						p.setRpdpId(19);
					}
					p.setNameId(new NameId(1, "IDI"));
					productLines.add(p);
					p = new ProductLine();
					if(s.getNameId().getId() ==10){
						p.setRpdpId(14);
					}else if(s.getNameId().getId() ==12){
						p.setRpdpId(20);
					}
					p.setNameId(new NameId(2, "EC"));
					productLines.add(p);
					d.setProductLines(productLines);
					divisions.add(d);
					
				
				break;
			case 11:
				
				
					d = new Division();
					d.setNameId(new NameId(1, "E&S"));
					productLines = new TreeSet<ProductLine>();
					d.setProductLines(productLines);
					p = new ProductLine();
					p.setRpdpId(17);
					p.setNameId(new NameId(1, "IDI"));
					productLines.add(p);
					p = new ProductLine();
					p.setRpdpId(18);
					p.setNameId(new NameId(2, "EC"));
					productLines.add(p);
					d.setProductLines(productLines);
					divisions.add(d);
					break;
				
			case 13:
							
					d = new Division();
					d.setNameId(new NameId(2, "PT"));
					productLines = new TreeSet<ProductLine>();
					d.setProductLines(productLines);
					p = new ProductLine();
					p.setRpdpId(24);
					p.setNameId(new NameId(1, "IDI"));
					productLines.add(p);
					d.setProductLines(productLines);
					divisions.add(d);							
					
				


					d = new Division();
					d.setNameId(new NameId(1, "E&S"));
					productLines = new TreeSet<ProductLine>();
					d.setProductLines(productLines);
					p = new ProductLine();
					p.setRpdpId(23);
					p.setNameId(new NameId(2, "EC"));
					productLines.add(p);
					d.setProductLines(productLines);
					divisions.add(d);
				
				break;

			case 14:
				
					d = new Division();
					d.setNameId(new NameId(1, "E&S"));
					productLines = new TreeSet<ProductLine>();
					d.setProductLines(productLines);
					p = new ProductLine();
					p.setRpdpId(25);
					p.setNameId(new NameId(2, "EC"));
					productLines.add(p);
					d.setProductLines(productLines);
					divisions.add(d);
					break;
				

			}
		
		return divisions;
	}
	
	private static List<ExpenseCatagory> createExpenseCatagoryList() {
		List<ExpenseCatagory> ecs = new ArrayList<ExpenseCatagory>();

		ExpenseCatagory ec;
		ec = new ExpenseCatagory();
		ec.setNameId(new NameId(1, "Revenue"));
		ecs.add(ec);
		ec = new ExpenseCatagory();
		ec.setNameId(new NameId(2, "Electricity"));
		ecs.add(ec);
		ec = new ExpenseCatagory();
		ec.setNameId(new NameId(3, "Maintenance"));
		ecs.add(ec);
		ec = new ExpenseCatagory();
		ec.setNameId(new NameId(4, "Scrap"));
		ecs.add(ec);
		ec = new ExpenseCatagory();
		ec.setNameId(new NameId(5, "Overtime"));
		ecs.add(ec);
		ec = new ExpenseCatagory();
		ec.setNameId(new NameId(6, "Packaging"));
		ecs.add(ec);

		return ecs;
	}
	
	public Calendar getStartDate() {
		// TODO Auto-generated method stub
		return null;
	}
}
