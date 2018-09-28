package com.mappingportlet.portlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;

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
import com.liferay.util.ContentUtil;
/**
 * @author kranthi.kumar
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.Mapping",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=PdfFiledownloadPortlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/pdfview.jsp",
		"javax.portlet.name=pdfFiledownloadPortlet",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class PdfDownload extends MVCPortlet {
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
	public void fileUpload(ThemeDisplay themeDisplay,ActionRequest actionRequest, Folder rootfolder, FileEntry fileEntry, File file)
	{   long timeNow = System.currentTimeMillis();
        final long latest = timeNow;
		String fileName=fileEntry.getFileName();		 			
		String mimeType = fileEntry.getMimeType();
        String title = themeDisplay.getUser().getScreenName()+themeDisplay.getUserId()+latest;
		String description = "This file is added via programatically";
		long repositoryId = themeDisplay.getScopeGroupId();
		System.out.println("Title=>"+title);
	    try
	    {  
	    	ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), actionRequest);
	    	FileEntry addFileEntry = DLAppServiceUtil.addFileEntry(repositoryId, rootfolder.getFolderId(), fileName, mimeType, title, description, "", file, serviceContext);
	    	File newfile = DLFileEntryLocalServiceUtil.getFile(addFileEntry.getFileEntryId(), "", true);
	    	Overidepdf(rootfolder,addFileEntry,newfile,actionRequest);
	     } catch (Exception e)
	    {
	       System.out.println(e.getMessage());
	    	e.printStackTrace();
	    }	    
	}
    public void Overidepdf(Folder rootfolder, FileEntry addFileEntry, File newfile,ActionRequest actionRequest) throws DocumentException, IOException, PortalException {
 	     Document document = new Document();
         PdfWriter writer = PdfWriter.getInstance(document,new FileOutputStream(newfile));
         document.open();
         String sb=ContentUtil.get("/content/email-notification-changeover.html");
         XMLWorkerHelper.getInstance().parseXHtml(writer, document,new StringReader(sb));
         document.close();
         ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), actionRequest);
         DLAppServiceUtil.updateFileEntry(addFileEntry.getFileEntryId(), addFileEntry.getTitle(), addFileEntry.getMimeType(), addFileEntry.getTitle(), "", "", true, newfile, serviceContext);
	}
	public void getfile(ActionRequest request,ActionResponse response) throws PortalException{
    	ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
    	long repositoryId = themeDisplay.getScopeGroupId();
		Long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
		Folder folder =DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), parentFolderId, "AshokLeyLand_Folder");
		FileEntry fileEntry = DLAppServiceUtil.getFileEntry(repositoryId, folder.getFolderId(), "AshokLeyLandSample.pdf");
		File file = DLFileEntryLocalServiceUtil.getFile(fileEntry.getFileEntryId(), "", true);
		boolean isFolderExist=isFolderExist(themeDisplay,"AshokLeyLand_User");
		if(!isFolderExist){
			createFolder(request,themeDisplay);			
		}
		Folder rootfolder = getFolder(themeDisplay,"AshokLeyLand_User");
		fileUpload(themeDisplay,request,rootfolder,fileEntry,file);
    }
	
}