package com.ddt.portlet;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.osgi.service.component.annotations.Component;

import com.all.ddtiservice.model.location;
import com.all.ddtiservice.service.locationLocalServiceUtil;
import com.ddt.model.TestimonialAshok;
import com.ddt.service.TestimonialAshokLocalServiceUtil;
import com.liferay.calendar.model.CalendarBooking;
import com.liferay.calendar.service.CalendarBookingLocalServiceUtil;
import com.liferay.calendar.service.CalendarLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFileEntryType;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryTypeLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.LayoutSet;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.LayoutSetLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

@Component(immediate=true, 
property={
		"com.liferay.portlet.display-category=AshokLeyLand",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.display-name=ImageUpload Portlet"}, 
service={ Portlet.class })
public class DdtportletPortlet  extends MVCPortlet

			{
			  private static final int ONE_GB = 1073741824;
		    //	  private static final String baseDir = "D://images";
			//  private static final String fileInputName = "fileupload";
			  public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			    throws IOException, PortletException
			  {
			    try
			    {
			    	  ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			    	LayoutSet	siblingLayoutSet = LayoutSetLocalServiceUtil.getLayoutSet(
							themeDisplay.getScopeGroupId(), false);
					
					if (siblingLayoutSet.isLogo()) {
					 long	logoId = siblingLayoutSet.getLogoId();
						}
			  	
			      TestimonialAshok testimonialAshok = TestimonialAshokLocalServiceUtil.createTestimonialAshok(CounterLocalServiceUtil.increment());
			      testimonialAshok.setId(CounterLocalServiceUtil.increment());
			      testimonialAshok.setTestimonialContent("TestimonialContent12");
			    }
			    catch (Exception localException) {
			    localException.printStackTrace();
			    }
			    super.doView(renderRequest, renderResponse);
			  }
			  
			
			  public void upload(ActionRequest request, ActionResponse response)throws Exception
			  {
			    UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);
			     System.out.println(request.getParameter("firstname"));
			    long sizeInBytes = uploadRequest.getSize("fileupload").longValue();
			    
			    if (uploadRequest.getSize("fileupload").longValue() == 0L) {
			      throw new Exception("Received file is 0 bytes!");
			    }
			    File uploadedFile = uploadRequest.getFile("fileupload");
			    String sourceFileName = uploadRequest.getFileName("fileupload");
			    String kept = sourceFileName.substring(0, sourceFileName.indexOf("."));
			    String remainder = sourceFileName.substring(sourceFileName.indexOf(".") + 1, sourceFileName.length());
			    System.out.println(kept);
			    System.out.println(remainder);
			    File folder = new File("D://images");
			    if (folder.getUsableSpace() < 1073741824L) {
			      throw new Exception("Out of disk space!");
			    }
			    File filePath = new File(folder.getAbsolutePath() + File.separator + kept + new Date().getTime() + "." + remainder);
			    FileUtils.copyFile(uploadedFile, filePath);
			   System.out.println(uploadedFile.getAbsolutePath());
		//	    fileUploadByDumnetandLibra(request,response);
			  //  fileUploadByDL( "AshokLeyland" ,uploadedFile,request,response );
			  }
			  
			  
			  public static void fileUploadByDL(String folderName, File file , ActionRequest request, ActionResponse response) throws IOException, PortalException{
	
					 ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
					  System.out.println("Exist=>"+file.exists());
					  long userId = themeDisplay.getUserId();
					  long groupId = themeDisplay.getScopeGroupId();
					  long repositoryId = themeDisplay.getScopeGroupId();
					  String mimeType = MimeTypesUtil.getContentType(file);
					  String title = file.getName();
					  String description = "This file is added via programatically";
					  String changeLog = "hi";
					  Long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
					  try{  
					  Folder folder =DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), parentFolderId, folderName);
					  ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), request);
					  InputStream is = new FileInputStream( file );
					  DLAppServiceUtil.addFileEntry(repositoryId, folder.getFolderId(), file.getName(), mimeType, 
					  	    			title, description, changeLog, is, file.getTotalSpace(), serviceContext);
					  	     } 
					  catch (Exception e) {
					  	    	e.printStackTrace();
					  	    }
			  }
			  
			  
			  public static void fileUploadByDumnetandLibra(ActionRequest request, ActionResponse response) throws IOException, PortalException{
				  ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
				  UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);
				  File file = uploadRequest.getFile("fileupload");
				  DLFileEntry fileEntry = null;
				//  Long lessonId = ParamUtil.getLong(request, "lid");
			//	  Lesson lll = LessonLocalServiceUtil.getLesson(lessonId);
				//  String lesName = URLEncoder.encode(lll.getName(themeDisplay.getLocale()));
				//  Date da = new Date();
				//  String ext = FileUtil.getExtension(file.getName());
				//  String dat = new SimpleDateFormat("yyyy-MM-dd").format(da);
			
				  //String title = lesName + "-" + dat + "." + ext;
				  byte[] imageBytes = FileUtil.getBytes(file);
				  InputStream is = new ByteArrayInputStream(imageBytes);
			
				  DLFolder dlFolder = DLFolderLocalServiceUtil.getFolder(themeDisplay.getScopeGroupId(), 0, "TestFolder");
				  ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), request);
				  List<DLFileEntryType> tip = DLFileEntryTypeLocalServiceUtil.getDLFileEntryTypes(0, DLFileEntryLocalServiceUtil.getDLFileEntriesCount());
			
				  fileEntry = DLFileEntryLocalServiceUtil.addFileEntry(themeDisplay.getUserId(), 
				          themeDisplay.getScopeGroupId(), 
				          themeDisplay.getScopeGroupId(), 
				          dlFolder.getFolderId(), 
				          file.getName(),
				          MimeTypesUtil.getContentType(file), 
				          "titleChandra", 
				          request.getParameter("name"), 
				          "", 
				          tip.get(0).getFileEntryTypeId(), 
				          null, 
				          file, 
				          is, 
				          file.getTotalSpace(), 
				          serviceContext);
			
				  DLFileEntryLocalServiceUtil.updateFileEntry(
				          themeDisplay.getUserId(), 
				          fileEntry.getFileEntryId(),
				          file.getName(), 
				          MimeTypesUtil.getContentType(file), 
				          "titleChandra",
				          "", 
				          "", 
				          true, 
				          tip.get(0).getPrimaryKey(), 
				          null, 
				          file, 
				          is,
				          file.getTotalSpace(), 
				          serviceContext);
				  
				/*  DLFileEntry dlf = DLFileEntryLocalServiceUtil.getDLFileEntry(f.get(i).getFileEntryId());
				  <a href='<%=themeDisplay.getPortalURL()+"/c/document_library/get_file?uuid="+DL.getUuid()+"&groupId="+themeDisplay.getScopeGroupId() %>' download>
				  Download </a>*/
			  }
			

				@Override
				public void serveResource(ResourceRequest request, ResourceResponse response)
						throws IOException, PortletException {
					String cmd = ParamUtil.getString(request, "cmd");
					File outputFile = new File("D:/liferay-ce-portal-7.0-ga5/tomcat-8.0.32/temp/upload_00000082.pdf");
					response.setContentType("application/pdf");		
             		OutputStream out = response.getPortletOutputStream();
					InputStream in = new FileInputStream(outputFile);
					IOUtils.copy(in, out);
					out.flush();
				
				}	
				
				  public void addlocation(ActionRequest request, ActionResponse response) throws Exception  {
						  
					  System.out.println(request.getParameter("location"));
					  try {
						ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
						location __location=locationLocalServiceUtil.createlocation(CounterLocalServiceUtil.increment());
						__location.setLocationId(CounterLocalServiceUtil.increment(location.class.getName()));
						__location.setLocationName(request.getParameter("location"));
						__location.setCreateDate(new Date());
						__location.setModifiedDate(new Date());
						__location.setUserId(themeDisplay.getUserId());
						__location.setGroupId(themeDisplay .getSiteGroupId());
						__location.setCompanyId(themeDisplay.getCompanyId());
						__location.setUserName(themeDisplay.getUser().getFullName());
                        locationLocalServiceUtil.updatelocation(__location);
					 
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				  
				    public void addUser(ActionRequest request,ActionResponse response)
					       	throws IOException, PortletException, PortalException
				    {
					       	ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
					       	long siteid = themeDisplay.getSiteGroupId();
					       	long calendarid=getCalendar(siteid);
					       	addevent(request,calendarid);
					       }
					   public void addevent(ActionRequest request, long calendarid) throws PortalException {
						   String ex = "\"en_US\"";
					   	CalendarBooking calendarBooking = null;	       
					       ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
					       try {
					       	com.liferay.calendar.model.Calendar cal = CalendarLocalServiceUtil.getCalendar(calendarid);
					calendarBooking  = CalendarBookingLocalServiceUtil.createCalendarBooking(CounterLocalServiceUtil.increment(CalendarBooking.class.getName()));
					       	calendarBooking.setCalendarBookingId(CounterLocalServiceUtil.increment(CalendarBooking.class.getName()));
					   	calendarBooking.setUserName("");
					           calendarBooking.setCompanyId(themeDisplay.getCompanyId());
					           calendarBooking.setUserId(themeDisplay.getUserId());
					           calendarBooking.setGroupId(themeDisplay.getSiteGroupId());
					           calendarBooking.setStartTime(1521822720000L);
					           calendarBooking.setEndTime(1521828900000L);
					           calendarBooking.setTitle("<?xml version='1.0' encoding='UTF-8'?><root available-locales="+ex+" default-locale="+ex+"><Title language-id="+ex+">interview</Title></root>");
					           calendarBooking.setDescription("<?xml version='1.0' encoding='UTF-8'?><root available-locales="+ex+" default-locale="+ex+"><Description language-id="+ex+">Basis of Java</Description></root>");
					           calendarBooking.setCreateDate(new Date());
					           calendarBooking.setCalendarId(cal.getCalendarId());
					           calendarBooking.setCalendarResourceId(cal.getCalendarResourceId());
					           calendarBooking.setResourceBlockId(cal.getResourceBlockId());
					           calendarBooking= CalendarBookingLocalServiceUtil.addCalendarBooking(calendarBooking);	 
					           calendarBooking.setParentCalendarBookingId(calendarBooking.getCalendarBookingId());
					           CalendarBookingLocalServiceUtil.updateCalendarBooking(calendarBooking);
					} catch (Exception e) {
					}
					   	               
					}
					public static long getCalendar(long siteid){	   	
					   List<com.liferay.calendar.model.Calendar> calendars = CalendarLocalServiceUtil.getCalendars(0, CalendarLocalServiceUtil.getCalendarsCount());
					   for(com.liferay.calendar.model.Calendar cal : calendars){
					   	if(cal.getGroupId()==siteid){
					   	return cal.getCalendarId();
					   	}
					   }
					   return 0L;
					   }
  
		  }
				
