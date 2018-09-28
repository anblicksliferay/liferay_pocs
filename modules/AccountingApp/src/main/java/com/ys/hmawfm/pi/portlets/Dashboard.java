package com.ys.hmawfm.pi.portlets;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.util.ContentUtil;
@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=AccountingApp",
			"com.liferay.portlet.instanceable=true",
			"javax.portlet.display-name=Dashboard Portlet",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/view.jsp",
			"javax.portlet.name=Dashboard",
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)

public class Dashboard extends MVCPortlet{
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		super.doView(renderRequest, renderResponse);
	}
	public static void   fileUploadByApp(String folderName ,ThemeDisplay themeDisplay,ResourceRequest resourceRequest,ResourceResponse resourceResponse) throws IOException, com.itextpdf.text.DocumentException
    {
		/*long timeNow = System.currentTimeMillis();
		final long latest = timeNow;
	//		fileCreation(latest);		
        java.io.File file = new java.io.File("D://pdf//piinvocie"+latest+".pdf");
        System.out.println("Exist=>"+file.exists());
        long repositoryId = themeDisplay.getScopeGroupId();
         String mimeType = MimeTypesUtil.getContentType(file);
        String title = file.getName();
        String description = "This file is added via programatically";
        String changeLog = "hi";
        Long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
        try
        {  
            Folder folder =DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), parentFolderId,"test");
            ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), resourceRequest);
            FileInputStream is = new FileInputStream( file );
            DLAppServiceUtil.addFileEntry(repositoryId, folder.getFolderId(), file.getName(), mimeType, 
                    title, description, changeLog, is, file.getTotalSpace(), serviceContext);
         } catch (Exception e)
        {
           System.out.println("Exception");
            e.printStackTrace();
        }
        JSONObject json = JSONFactoryUtil.createJSONObject();
        json.put("path", "http:/localhost:6060/documents/20154/24564/piinvocie.pdf");
        PrintWriter writer = resourceResponse.getWriter();
        writer.print(json);*/
    }
    @Override
    public void serveResource(ResourceRequest resourceRequest,
            ResourceResponse resourcdeeResponse) throws IOException,PortletException {
        String cmd = ParamUtil.getString(resourceRequest, "cmd");
        System.out.println(cmd);
        ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
        if(cmd.equalsIgnoreCase("downloadpdf")){
        	/*try {
				fileUploadByApp("app", themeDisplay, resourceRequest ,resourcdeeResponse);
			} catch (DocumentException e) {
				e.printStackTrace();
			}*/
        	try {
				fileCreation(resourceRequest,resourcdeeResponse);
			} catch (DocumentException e) {
				e.printStackTrace();
			}      
    }
  }  
    
    public void fileCreation(ResourceRequest resourceRequest,
            ResourceResponse resourceResponse) throws FileNotFoundException, IOException,com.itextpdf.text.DocumentException{
    	    long timeNow = System.currentTimeMillis();
		    final long latest = timeNow;
    	    Document document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document,new FileOutputStream("E://Kranthi_Liferay//WorkSpace//DxpWorkSpace//modules//AccountingApp//src//main//resources//META-INF//resources//pdf//piinvocie"+latest+".pdf"));
            document.open();
            String sb=ContentUtil.get("/content/email-notification-changeover.html");
         //   XMLWorkerHelper.getInstance().parseXHtml(writer, document,new FileInputStream("D://Honda//liferay-plugins-sdk-6.2.0//hma-wms//liferay-plugins-sdk-6.2.0//portlets//AccountingApp-portlet//docroot//WEB-INF//src//content//email-notification-changeover.html"));
            XMLWorkerHelper.getInstance().parseXHtml(writer, document,new StringReader(sb));
            document.close();
            JSONObject json = JSONFactoryUtil.createJSONObject();
            json.put("path", "piinvocie"+latest+".pdf");
            PrintWriter writer1 = resourceResponse.getWriter();
            writer1.print(json);
            System.out.println("Success");
    }	
}
