package com.leykart.portlet;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

import com.leykartservice.model.Testmonials;
import com.leykartservice.service.TestmonialsLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
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
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.xml.DocumentException;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=AddUser Form",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/formview.jsp",
		"javax.portlet.name=formportlet",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class FormPortlet extends MVCPortlet {
	public Folder createFolder(ActionRequest actionRequest,ThemeDisplay themeDisplay)
	{
        Folder folder = null;
			long repositoryId = themeDisplay.getScopeGroupId();		
			try {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(), actionRequest);
				folder = DLAppServiceUtil.addFolder(repositoryId,DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, "Testmonials","To Store UserImages", serviceContext);
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
	public void addTestmonials(ActionRequest request,ActionResponse response) throws PortalException, DocumentException, IOException{
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		String FirstName =request.getParameter("firstName");
		String Message =request.getParameter("message");
	    UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(request);			
		File file = uploadPortletRequest.getFile("image");
		boolean isFolderExist=isFolderExist(themeDisplay,"Testmonials");
		if(!isFolderExist){
			createFolder(request,themeDisplay);			
		}
		Folder rootfolder = getFolder(themeDisplay,"Testmonials");
		String url =ImageUpload(themeDisplay,request,rootfolder,file,FirstName);
		Testmonials createTestmonials = TestmonialsLocalServiceUtil.createTestmonials(CounterLocalServiceUtil.increment());
		createTestmonials.setFullname(FirstName);
		createTestmonials.setMessage(Message);
		createTestmonials.setImagepath(url);
		createTestmonials.setUserId(themeDisplay.getUserId());
		createTestmonials.setUserName(themeDisplay.getUser().getScreenName());
		createTestmonials.setCompanyId(themeDisplay.getCompanyId());
		createTestmonials.setCreateDate(new Date());
		createTestmonials.setModifiedDate(new Date());
		TestmonialsLocalServiceUtil.addTestmonials(createTestmonials);
	}
	public String ImageUpload(ThemeDisplay themeDisplay,ActionRequest request,Folder rootfolder,File file,String FirstName) throws DocumentException, IOException, PortalException {
		long timeNow = System.currentTimeMillis();
        final long latest = timeNow;
        String title = FirstName+latest;
		String description = title;
		String mimetype = MimeTypesUtil.getContentType(file);
        ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), request);
        FileEntry addFileEntry = DLAppServiceUtil.addFileEntry(themeDisplay.getScopeGroupId(), rootfolder.getFolderId(),  file.getName(), mimetype, title, description, "", file, serviceContext);
        String url = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/" + themeDisplay.getScopeGroupId() + "/" + 
       		 addFileEntry.getFolderId() +  "/" +addFileEntry.getTitle();
        System.out.println(url);
        return url;
	}
	
}