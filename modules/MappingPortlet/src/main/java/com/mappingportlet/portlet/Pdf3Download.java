package com.mappingportlet.portlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.util.ContentUtil;
/**
 * @author kranthi.kumar
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.Mapping",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Pdf3FiledownloadPortlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/pdfview.jsp",
		"javax.portlet.name=pdf3FiledownloadPortlet",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class Pdf3Download extends MVCPortlet {
	public Folder createFolder(ActionRequest actionRequest,ThemeDisplay themeDisplay)
	{
        Folder folder = null;
			long repositoryId = themeDisplay.getScopeGroupId();		
			try {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(), actionRequest);
				folder = DLAppServiceUtil.addFolder(repositoryId,DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, "AshokLeyLand_User","To Store PDFs", serviceContext);
			} catch (PortalException e1) {
				e1.printStackTrace();
			} catch (SystemException e1) {
				e1.printStackTrace();
			}			
		return folder;
	}	
	public boolean isFolderExist(ThemeDisplay themeDisplay, String ROOT_FOLDER_NAME){
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
	public Folder getFolder(ThemeDisplay themeDisplay,String ROOT_FOLDER_NAME){
		Folder folder = null;
		try {
			folder =DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), DLFolderConstants.DEFAULT_PARENT_FOLDER_ID,ROOT_FOLDER_NAME);
		} catch (Exception e) {	
			System.out.println(e.getMessage());
		}
		return folder;
	}
	public void getfile(ActionRequest request,ActionResponse response) throws PortalException, DocumentException, IOException{
    	ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
    	System.out.println("Start======>"+new Date());
    	long timeNow = System.currentTimeMillis();
        final long latest = timeNow;
		File file = new File("/"+themeDisplay.getUserId()+latest+".pdf");
		boolean isFolderExist=isFolderExist(themeDisplay,"AshokLeyLand_User");
		if(!isFolderExist){
			createFolder(request,themeDisplay);			
		}
		Folder rootfolder = getFolder(themeDisplay,"AshokLeyLand_User");
		String url =pdfoveride(themeDisplay,request,rootfolder,file);
		System.out.println(url);
		System.out.println(file.getName());
		System.out.println(file.getAbsolutePath());
		file.delete();
		System.out.println("done");
		System.out.println("end======>"+new Date());
    }
	public String pdfoveride(ThemeDisplay themeDisplay,ActionRequest request,Folder rootfolder,File file) throws DocumentException, IOException, PortalException {
		 long timeNow = System.currentTimeMillis();
         final long latest = timeNow;
         String title = themeDisplay.getUser().getScreenName()+themeDisplay.getUserId()+latest;
		 String description = title;
		 Document document = new Document();
         PdfWriter writer = PdfWriter.getInstance(document,new FileOutputStream(file));
         document.open();
         String sb=ContentUtil.get("/content/email-notification-changeover.html");
         XMLWorkerHelper.getInstance().parseXHtml(writer, document,new StringReader(sb));
         document.close();
         ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), request);
         FileEntry addFileEntry = DLAppServiceUtil.addFileEntry(themeDisplay.getScopeGroupId(), rootfolder.getFolderId(), file.getName(), "application/pdf", title, description, "", file, serviceContext);
         String url = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/" + themeDisplay.getScopeGroupId() + "/" + 
        		 addFileEntry.getFolderId() +  "/" +addFileEntry.getTitle();
         System.out.println(url);
         return url;
	}
}