/**
 * 
 *//*
package com.ys.hmawfm.wfms.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.ys.hmawfm.wfms.services.model.WFMS_NA_Support;
import com.ys.hmawfm.wfms.services.model.WFMS_Position;
import com.ys.hmawfm.wfms.services.service.WFMS_NA_SupportLocalServiceUtil;
import com.ys.hmawfm.wfms.services.service.WFMS_PositionLocalServiceUtil;
import com.ys.hmawfm.wfms.services.sql.HMAAssociateInfoService;
import com.ys.hmawfm.wfms.vo.AssociateInformation;

public class ExcelFileUtil {

	private static Log _log = LogFactoryUtil.getLog(ExcelFileUtil.class);
	
	private static final String FILE_PATH = "";

	*//**
	 * @param args
	 *//*
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		_log.info("ExcelFileUtil main");
		//parseFile();

	}
	
	public List<WFMS_Position> parsePositionFile(File positionFile)
	{
		_log.info("parsePositionFile called for file "+positionFile);
		List<WFMS_Position> records = new ArrayList<WFMS_Position>();
		try {

			XSSFWorkbook wb = null;
			try{
				wb = new XSSFWorkbook(positionFile);
			}catch(InvalidFormatException ifex){
				_log.info("InvalidFormatException");
			}

			_log.info("XSSFWorkbook Added");
			
			XSSFSheet sheet = wb.getSheetAt(0);
			XSSFRow row; 
			XSSFCell cell;
			
			int rowNum = sheet.getLastRowNum() + 1;
			
			int colNum = sheet.getRow(0).getLastCellNum();

			Iterator rows = sheet.rowIterator();
			
			WFMS_Position entry = null;
			
			//
			// Delete All Positions
			// 
			WFMS_PositionLocalServiceUtil.removeAllPositions();
			
			Map<Integer,String> keySet = new HashMap<Integer,String>();
			
			for(int i=0;i<rowNum;i++)
			{
				Iterator cells = null;
				row=(XSSFRow) rows.next();
				cells = row.cellIterator();

				if(i == 0){
					try{
						while(cells.hasNext()) {
							cell=(XSSFCell) cells.next();
							keySet.put(cell.getColumnIndex(),cell.getStringCellValue().toUpperCase());
						}
						
						//_log.info("Header values are: "+keySet);
						continue;

					}catch(java.util.NoSuchElementException nseex){
						_log.info(nseex);
						break;
					}
				}
				
				_log.debug("Creating new empty position for " + i);
				
				entry = WFMS_PositionLocalServiceUtil.addNewEmptyPosition();

				String tempId = entry.getPId();
				
				while(cells.hasNext()) {
				
					cell=(XSSFCell) cells.next();
					cell.setCellType(1);

					//_log.info("Adding row");
					
					entry = setPositionValues(	entry,
												keySet.get(cell.getColumnIndex()),
												cell.getStringCellValue());	
				
					
				}
				
				boolean isExist=false;
				if(Validator.isNotNull(entry.getAssociateNumber())){
					 isExist=HMAAssociateInfoService.checkAssociateNumberExist(entry.getAssociateNumber().trim());
					if(isExist){
				AssociateInformation associateInformation= new AssociateInformation();
				associateInformation=HMAAssociateInfoService.fetchPositionOnAssociateNumber(entry.getAssociateNumber().trim());
				entry.setAssociateName(associateInformation.getAssociateName().trim());
				entry.setAssociateTitle(associateInformation.getAssociateTitle().trim());
			//	_log.info(" ass id ---" +value+" ass name-- " +associateInformation.getAssociateName()+" ass title--- " +associateInformation.getAssociateTitle());
				}
					}
				_log.debug("Added all rows for record " + i);
				
				if(entry.getStatus().equalsIgnoreCase("Filled")){
					entry.setMpCatFilledWith("");
				};
				
				WFMS_Position updatedEntry = WFMS_PositionLocalServiceUtil.updatePositionEntry(entry);
				WFMS_PositionLocalServiceUtil.deletePosition(tempId);
				
				records.add(updatedEntry);
			}
			return records;
			
		} catch (FileNotFoundException fe) {
			// TODO Auto-generated catch block
			fe.printStackTrace();
		} catch (IOException ioe) {
			// TODO Auto-generated catch block
			ioe.printStackTrace();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return records;
	}
	
	private WFMS_Position setPositionValues(WFMS_Position entry, String name, String value ){
		
		//_log.info("name:"+name+" value:"+value);
		boolean isExit=false;
		try{
			if(name.equalsIgnoreCase("POS #")){
				entry.setPId(value);
			}else if(name.equalsIgnoreCase("DIVISION")){
				entry.setDivision(value);
			}else if(name.equalsIgnoreCase("DEPARTMENT")){
				entry.setDepartmentName(value);
			}else if(name.equalsIgnoreCase("REPORTS TO")){
				entry.setReportsTo(value);
			}else if(name.equalsIgnoreCase("STATUS")){
				entry.setStatus(value);
			}else if(name.equalsIgnoreCase("LINE")){
				entry.setLine(value);
			}else if(name.equalsIgnoreCase("LADDER")){
				entry.setLadder(value);
			}else if(name.equalsIgnoreCase("MP CATEGORY BUDGETED")){
				entry.setMpCatBugdet(value);
			}else if(name.equalsIgnoreCase("MP CATEGORY FILLED")){
				entry.setMpCatFilledWith(value);
			}else if(name.equalsIgnoreCase("POSITION CLASS")){
				entry.setPositionClass(value);
			}else if(name.equalsIgnoreCase("TYPE")){
				entry.setType(value);
			}else if(name.equalsIgnoreCase("LEVEL")){
				entry.setLevel(value);
			}else if(name.equalsIgnoreCase("LEADERSHIP ASSIGNMENT")){
				entry.setLeadershipAssignment(value);
			}else if(name.equalsIgnoreCase("CATEGORY")){
				entry.setCategory(value);
			}else if(name.equalsIgnoreCase("SUBCATEGORY")){
				entry.setSubCategory(value);
			}else if(name.equalsIgnoreCase("WF CAT")){
				entry.setWorkforceCategory(value);
			}else if(name.equalsIgnoreCase("EMP CAT")){
				entry.setEmpCategory(stringCleanup(value));
			}else if(name.equalsIgnoreCase("EMP CAT DESC")){
				entry.setEmpCategoryDesc(value);
			}else if(name.equalsIgnoreCase("YEAR ESTABLISHED")){
				entry.setYearEst(stringCleanup(value));
			}else if(name.equalsIgnoreCase("ADDITION REASON")){
				entry.setReasonsFor(value);
			}else if(name.equalsIgnoreCase("RE-EVAL DATE")){
				entry.setReavailuationDate(value);
			}else if(name.equalsIgnoreCase("ASSOC NUM")){
				entry.setAssociateNumber(stringCleanup(value));
			}else if(name.equalsIgnoreCase("ASSOC NAME")){
				entry.setAssociateName(value);
			}else if(name.equalsIgnoreCase("ASSOC TITLE")){
				entry.setAssociateTitle(value);
			}else if(name.equalsIgnoreCase("CRITICAL WORKFORCE?")){
				entry.setCritical("Yes".equalsIgnoreCase(value));
			}else if(name.equalsIgnoreCase("TYPICAL TITLE")){
				entry.setTypicalJobTitle(value);
			}else if(name.equalsIgnoreCase("MINIMUM KNOWLEDGE")){
				entry.setMinJobKnowHow(value);
			}else if(name.equalsIgnoreCase("DUTIES")){
				entry.setDuties(value);
			}else if(name.equalsIgnoreCase("TASKS")){
				entry.setTasksPerformed(value);
			}else if(name.equalsIgnoreCase("EXPERIENCE")){
				//entry.setHistory(value);
				entry.setLengthOfService(value);
			}else if(name.equalsIgnoreCase("DEGREE")){
				entry.setDegree(value);
			}else if(name.equalsIgnoreCase("MUSTS")){
				entry.setDesiredSkills(value);
			}else if(name.equalsIgnoreCase("WANTS")){
				entry.setReqSkills(value);
			}else if(name.equalsIgnoreCase("ESTIMATED OT")){
				entry.setWeeklyOvertime(value);
			}else if(name.equalsIgnoreCase("TRAVEL")){
				entry.setFrequencyOfTravel(value);
			}else if(name.equalsIgnoreCase("ENVIRONMENT")){
				entry.setEnvironment(value);
			} else if(name.equalsIgnoreCase("JOB CODE")){
				entry.setAssociateTitle(value);
			} else if(name.equalsIgnoreCase("JOB TITLE")){
				entry.setTypicalJobTitle(value);
			} else if(name.equalsIgnoreCase("DESCRIPTION")){
				entry.setComments(value);
			} else if(name.equalsIgnoreCase("POSITION DESC")){
				entry.setDescription(value);
			}else if(name.equalsIgnoreCase("OTHER CAT DESC")){
				// TODO: What goes here
			} else if(name.equalsIgnoreCase("SUBCATEGORY DESC")){
				// TODO: What goes here
			} else if(name.equalsIgnoreCase("DEPT NUM")){
				entry.setDepartmentNumber(value);
			}
			entry.setDummy("0");
			entry.setWorkflowStep(-1);
			entry.setAutoGenerateReq("false");
			
			
			// Will Add Elsewhere
			// entry.setCompanyId(value);
			// entry.setScopeGroupId(value);
			// entry.setCreatedBy(value);
			// entry.setCreateDate(new java.util.Date());
			// entry.setActive(value);
			
			//Not Found
			// entry.setAutoGenerateReq(value);
			// entry.setDescription(value);
			// entry.setAssociateNumber(value);
			// 
			// entry.setDepartmentNumber(value);
			// entry.setLengthOfService(value);
			// entry.setAssociateName(value);
			// Typical Title
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return entry;
	}
	
	private static String stringCleanup(String string){
		
		if( null != string && string.length() > 1 ){
			if( string.substring(string.length()-2, string.length()).equals(".0") ){

				//System.out.println(string.substring(string.length()-2, string.length()));
				string = string.substring(0,string.length()-2);
			}
		}
		
		return string;
	}

	public List<WFMS_NA_Support> parseNaSupportfile(File nasupportfile){
		

		_log.info("parse NA support called for file "+nasupportfile);
		List<WFMS_NA_Support> records = new ArrayList<WFMS_NA_Support>();
		try {

			XSSFWorkbook wb = null;
			try{
				wb = new XSSFWorkbook(nasupportfile);
			}catch(InvalidFormatException ifex){
				_log.info("InvalidFormatException");
			}

			_log.info("XSSFWorkbook Added");
			
			XSSFSheet sheet = wb.getSheetAt(0);
			XSSFRow row; 
			XSSFCell cell;
			
			int rowNum = sheet.getLastRowNum() + 1;
			
			int colNum = sheet.getRow(0).getLastCellNum();

			Iterator rows = sheet.rowIterator();
			
			WFMS_NA_Support entry = null;
			
			//
			// Delete All Positions
			// 
			//WFMS_NA_SupportLocalServiceUtil.re
			
			Map<Integer,String> keySet = new HashMap<Integer,String>();
			
			for(int i=0;i<rowNum;i++)
			{
				Iterator cells = null;
				row=(XSSFRow) rows.next();
				cells = row.cellIterator();

				if(i == 0){
					try{
						while(cells.hasNext()) {
							cell=(XSSFCell) cells.next();
							keySet.put(cell.getColumnIndex(),cell.getStringCellValue().toUpperCase());
						}
						
						//_log.info("Header values are: "+keySet);
						continue;

					}catch(java.util.NoSuchElementException nseex){
						_log.info(nseex);
						break;
					}
				}
				
				_log.debug("Creating new empty position for " + i);
				
			entry = WFMS_NA_SupportLocalServiceUtil.addNewEmptyassociate();
		String tempId = entry.getASSOCIATE_NUMBER();
				
				while(cells.hasNext()) {
				
					cell=(XSSFCell) cells.next();
					cell.setCellType(1);

					//_log.info("Adding row");
					
					entry = setnasupportValues(	entry,
												keySet.get(cell.getColumnIndex()),
												cell.getStringCellValue());	
				
					
				}
				
		
				_log.debug("Added all rows for record " + i);
				
				if(entry.getStatus().equalsIgnoreCase("Filled")){
					entry.setMpCatFilledWith(""); 
				};
				
				WFMS_NA_Support updatedEntry = WFMS_NA_SupportLocalServiceUtil.updateassociatedata(entry);
				WFMS_NA_SupportLocalServiceUtil.deleteWFMS_NA_Support(tempId);
				
				records.add(updatedEntry);
			}
			return records;
			
		} catch (FileNotFoundException fe) {
			// TODO Auto-generated catch block
			fe.printStackTrace();
		} catch (IOException ioe) {
			// TODO Auto-generated catch block
			ioe.printStackTrace();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return records;
	
	}
private WFMS_NA_Support setnasupportValues(WFMS_NA_Support entry, String name, String value ){
		
		//_log.info("name:"+name+" value:"+value);
		boolean isExit=false;
		try{
			if(name.equalsIgnoreCase("ASSOCIATE_NUMBER")){
				entry.setASSOCIATE_NUMBER(value);
			}else if(name.equalsIgnoreCase("ASSOC_NO")){
				entry.setASSOC_NO(value);
			}else if(name.equalsIgnoreCase("ASSOCIATE_DATE_OF_HIRE")){
				entry.setASSOCIATE_DATE_OF_HIRE(value);
			}else if(name.equalsIgnoreCase("ASSOCIATE_NAME")){
				entry.setASSOCIATE_NAME(value);
			}else if(name.equalsIgnoreCase("DEPT_NUMBER")){
				entry.setDEPT_NUMBER(value);
			}else if(name.equalsIgnoreCase("DEPT_NO")){
				entry.setDEPT_NO(Integer.parseInt(value));
			}else if(name.equalsIgnoreCase("DEPT_NAME")){
				entry.setDEPT_NAME(value);
			}else if(name.equalsIgnoreCase("ASSOCIATE_TITLE")){
				entry.setASSOCIATE_TITLE(value);
			}else if(name.equalsIgnoreCase("SHIFT_CODE")){
				entry.setSHIFT_CODE(value);
			}else if(name.equalsIgnoreCase("TEAM_NUMBER")){
				entry.setTEAM_NUMBER(value);
			}else if(name.equalsIgnoreCase("EFFDT")){
				entry.setEFFDT(value);
			}else if(name.equalsIgnoreCase("TERMINATION_DT")){
				entry.setTERMINATION_DT(value);
			}else if(name.equalsIgnoreCase("MANAGER_ASSOCIATE_NUMBER")){
				entry.setMANAGER_ASSOCIATE_NUMBER(Integer.parseInt(value));
			}else if(name.equalsIgnoreCase("ASSGN_TYPE")){
				entry.setASSGN_TYPE(value);
			}else if(name.equalsIgnoreCase("LEADERSHIP_ASSIGNMENT")){
				entry.setLEADERSHIP_ASSIGNMENT(value);
			}else if(name.equalsIgnoreCase("EMAIL")){
				entry.setEMAIL(value);
			}
			// Will Add Elsewhere
			// entry.setCompanyId(value);
			// entry.setScopeGroupId(value);
			// entry.setCreatedBy(value);
			// entry.setCreateDate(new java.util.Date());
			// entry.setActive(value);
			
			//Not Found
			// entry.setAutoGenerateReq(value);
			// entry.setDescription(value);
			// entry.setAssociateNumber(value);
			// 
			// entry.setDepartmentNumber(value);
			// entry.setLengthOfService(value);
			// entry.setAssociateName(value);
			// Typical Title
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return entry;
	}
	
}
*/