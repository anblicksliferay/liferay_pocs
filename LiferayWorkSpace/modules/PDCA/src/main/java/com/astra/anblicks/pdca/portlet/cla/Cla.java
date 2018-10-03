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
package com.astra.anblicks.pdca.portlet.cla;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.ProcessAction;

import org.osgi.service.component.annotations.Component;

import com.astra.anblicks.pdca.constants.PDCAPortletKeys;
import com.astra.anblicks.pdca.model.kpi;
import com.astra.anblicks.pdca.service.kpiLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

@Component(
	immediate = true,
	property = {
        "com.liferay.portlet.display-category=AstraPDCA",
        "com.liferay.portlet.instanceable=true",
        "javax.portlet.display-name=Cla",
        "javax.portlet.init-param.template-path=/",
        "javax.portlet.init-param.view-template=/cla/updatekpi.jsp",
        "javax.portlet.name=" + PDCAPortletKeys.Cla,
        "javax.portlet.resource-bundle=content.Language",
        "javax.portlet.security-role-ref=power-user,user"
    },
    service = Portlet.class
)
public class Cla extends MVCPortlet {
	public void addKpi(ActionRequest actionRequest, ActionResponse actionResponse) {
		actionResponse.setRenderParameter("mvcPath", "/cla/addkpi.jsp");
	}

	@ProcessAction(name = "createKpi")
	public void createKpi(ActionRequest actionRequest, ActionResponse actionResponse) {
		try {
			 ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			 kpi _kpi = kpiLocalServiceUtil.createkpi(CounterLocalServiceUtil.increment());
			 _kpi.setCompanyName(actionRequest.getParameter("company"));
			 _kpi.setTipe(actionRequest.getParameter("type"));
			 _kpi.setWeight(actionRequest.getParameter("weight"));
			 _kpi.setTarget(actionRequest.getParameter("target"));
			 _kpi.setYear(actionRequest.getParameter("year"));
			 _kpi.setItemDescription(actionRequest.getParameter("item"));
			 _kpi.setUnit(actionRequest.getParameter("unit"));
			 _kpi.setAchivementFormula(actionRequest.getParameter("achivementformula")); 
			 _kpi.setCompanyId(themeDisplay.getCompanyId());
			 _kpi.setUserId(themeDisplay.getUserId());
			 _kpi.setUserName(themeDisplay.getUser().getFullName());
			 _kpi.setCreateDate(new Date());
			 _kpi.setModifiedDate(new Date());
			 kpi Createdkpi = kpiLocalServiceUtil.addkpi(_kpi);
			 System.out.println(Createdkpi.toString());
			 
			
		} catch (Exception e) {
			
		}
	}

	@ProcessAction(name = "getfile")
	public void getfile(ActionRequest actionRequest, ActionResponse actionResponse) throws FileNotFoundException, IOException {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
	    	long repositoryId = themeDisplay.getScopeGroupId();
			Long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
			Folder folder =DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), parentFolderId, PDCAPortletKeys.AstraParentFolderName);
			FileEntry fileEntry = DLAppServiceUtil.getFileEntry(repositoryId, folder.getFolderId(), PDCAPortletKeys.AstraSampleExcel);
			File file = DLFileEntryLocalServiceUtil.getFile(fileEntry.getFileEntryId(), "", true);
			boolean isFolderExist=isFolderExist(themeDisplay,PDCAPortletKeys.CLAFolderName);
			if(!isFolderExist){
				createFolder(actionRequest,themeDisplay);			
			}
			Folder rootfolder = getFolder(themeDisplay,PDCAPortletKeys.CLAFolderName);
			String url =excelWrite(themeDisplay,actionRequest,rootfolder,fileEntry,file);
			System.out.println(url);
		} catch (Exception e) {
		}	
	       
  }
	
	private String excelWrite(ThemeDisplay themeDisplay, ActionRequest actionRequest, Folder rootfolder,FileEntry fileEntry, File file) throws FileNotFoundException {
		List<kpi> getkpis = kpiLocalServiceUtil.getkpis(0, kpiLocalServiceUtil.getkpisCount());
		long timeNow = System.currentTimeMillis();
		int rowIndex = 1;
        final long latest = timeNow;
        String title = themeDisplay.getUser().getScreenName()+themeDisplay.getUserId()+latest;
		 String description = PDCAPortletKeys.CLAExcelDesc;
		WritableWorkbook claWbook = null;
		String url = null;
		File file2 = new File("E:\\output.xls");
		try {
			claWbook = Workbook.createWorkbook(file2);
	         
	        WritableSheet claSheet = claWbook.createSheet("Cla_Astra", 1);       	 
	         
       	 for(kpi _kpi: getkpis){
	        	 claSheet.addCell(new Number(0,rowIndex, _kpi.getKpiId()));
	        	 claSheet.addCell(new Label(1,rowIndex,_kpi.getCompanyName()));
	        	 claSheet.addCell(new Label(2,rowIndex,_kpi.getTipe()));
	        	 claSheet.addCell(new Label(3,rowIndex,_kpi.getWeight()));
	        	 claSheet.addCell(new Label(4,rowIndex,_kpi.getTarget()));
	        	 rowIndex++;
	         }
       	     claWbook.write();
	         ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), actionRequest);
	         FileEntry addFileEntry = DLAppServiceUtil.addFileEntry(themeDisplay.getScopeGroupId(), rootfolder.getFolderId(), fileEntry.getFileName(), fileEntry.getMimeType(), title , description, "", file2, serviceContext);
	         DLAppServiceUtil.updateFileEntry(addFileEntry.getFileEntryId(), addFileEntry.getFileName(), addFileEntry.getMimeType(), title, description, "", true, file2, serviceContext);
	         url = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/" + themeDisplay.getScopeGroupId() + "/" + 
	        		 addFileEntry.getFolderId() +  "/" +addFileEntry.getTitle();
	         System.out.println(url);         	
		} catch (IOException e) {
            e.printStackTrace();
        } catch (WriteException e) {
            e.printStackTrace();
        } catch (PortalException e) {
			e.printStackTrace();
		} finally {

            if (claWbook != null) {
                try {
                	claWbook.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (WriteException e) {
                    e.printStackTrace();
                }
            }


        } 
		 return url;
	}

	private Folder createFolder(ActionRequest actionRequest,ThemeDisplay themeDisplay)
	{
        Folder folder = null;
			long repositoryId = themeDisplay.getScopeGroupId();		
			try {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(), actionRequest);
				folder = DLAppServiceUtil.addFolder(repositoryId,DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, PDCAPortletKeys.CLAFolderName,PDCAPortletKeys.CLAFolderDesc, serviceContext);
			} catch (PortalException e1) {
				e1.printStackTrace();
			} catch (SystemException e1) {
				e1.printStackTrace();
			}			
		return folder;
	}	
	private boolean isFolderExist(ThemeDisplay themeDisplay, String ROOT_FOLDER_NAME){
			boolean folderExist = false;
			try {
				DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(),DLFolderConstants.DEFAULT_PARENT_FOLDER_ID,ROOT_FOLDER_NAME);
				folderExist = true;
				System.out.println("Folder is already Exist");
			} catch (Exception e) {	
				System.out.println(e.getMessage());
			}
			return folderExist;
	}	
	private Folder getFolder(ThemeDisplay themeDisplay,String ROOT_FOLDER_NAME){
		Folder folder = null;
		try {
			folder =DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), DLFolderConstants.DEFAULT_PARENT_FOLDER_ID,ROOT_FOLDER_NAME);
		} catch (Exception e) {	
			System.out.println(e.getMessage());
		}
		return folder;
	}
	
	private void excelwrite(){
		 WritableWorkbook myFirstWbook = null;
	        try {

	            myFirstWbook = Workbook.createWorkbook(new File("E:\\my.xls"));
	         
	            WritableSheet excelSheet = myFirstWbook.createSheet("Sheet 1", 0);
	            
	            Label label = new Label(0, 0, "Test Count");
	            excelSheet.addCell(label);

	            Number number = new Number(0, 1, 1);
	            excelSheet.addCell(number);

	             label = new Label(1, 0, "Result");
	            excelSheet.addCell(label);

	            label = new Label(1, 1, "Passed");
	            excelSheet.addCell(label);

	            number = new Number(0, 2, 2);
	            excelSheet.addCell(number);

	            label = new Label(1, 2, "Passed 2");
	            excelSheet.addCell(label);

	            myFirstWbook.write();


	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (WriteException e) {
	            e.printStackTrace();
	        } finally {

	            if (myFirstWbook != null) {
	                try {
	                    myFirstWbook.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                } catch (WriteException e) {
	                    e.printStackTrace();
	                }
	            }


	        } 
}
	
	
	
		
}