package com.ys.hmawfm.pi.portlets;

import java.io.File;
import java.io.IOException;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;

import org.json.JSONException;
import org.json.JSONObject;
import org.osgi.service.component.annotations.Component;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.PortalUtil;
import com.ys.hma.account.model.Book;
import com.ys.hma.account.service.BookLocalServiceUtil;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=AccountingApp",
			"com.liferay.portlet.instanceable=true",
			"javax.portlet.display-name=UploadPI Portlet",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/html/Upload/view.jsp",
			"javax.portlet.name=Upload",
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)

public class UploadPortlet extends MVCPortlet {
	public void uploadDocument(ActionRequest actionRequest,ActionResponse actionResponse) throws IOException,PortletException, PortalException, SystemException, BiffException 
	{
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);			
		File[] files= uploadPortletRequest.getFiles("uploadedFile");
		for (File file : files) {				
			excelupload(file,file.getName());			
		}		
		Email();
	}
	public static void upload(String json) throws JSONException{
		 JSONObject newjson = new JSONObject(json.toString());
		 String author = (String) newjson.get("authorname");
		 String name = (String) newjson.get("bookname");
		 String desc = (String) newjson.get("description");
		 String isbn = (String) newjson.get("isbn");
		 String price = newjson.getString("price");
	     System.out.println(author+"  "+name+"  "+desc+"  "+isbn+"  "+price);
	     Book book=BookLocalServiceUtil.createBook(CounterLocalServiceUtil.increment());
		 book.setBookName(name);
		 book.setAuthorName(author);
		 book.setDescription(desc);
		 book.setIsbn(Integer.parseInt(isbn));
		 book.setPrice(Integer.parseInt(price));
		 BookLocalServiceUtil.addBook(book);
		}
		public static void excelupload(File file,String filename) throws IOException,BiffException{		
			try {	
				System.out.println(filename);
				//File file = new File("D:/test.xls");
				 Workbook workbook =  Workbook.getWorkbook(file);
				   Sheet sheet = workbook.getSheet(0);
				   System.out.println(sheet.getColumns());
				   System.out.println(sheet.getRows());
				   for(int row = 1; row < sheet.getRows(); row++) {
					   JSONObject json = new JSONObject();
				    for(int column = 0; column < sheet.getColumns(); column++) {
					 Cell cell1=sheet.getCell(column,0);
				     Cell cell = sheet.getCell(column,row);
				     json.put(cell1.getContents(),cell.getContents());
				    }
				    upload(json.toString());
				   }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}
	public static void Email(){
		InternetAddress fromAddress = null;
		InternetAddress toAddress = null;
		try {
	    		fromAddress = new InternetAddress("testproject1886@gmail.com");
	    		toAddress = new InternetAddress("kranthi.k1009@gmail.com");
	    		MailMessage mailMessage = new MailMessage();
	    		mailMessage.setTo(toAddress);
	    		mailMessage.setFrom(fromAddress);
	    		mailMessage.setSubject("Test Test");
	    		mailMessage.setBody("Excels Files are Imported Succesfully");
	    		MailServiceUtil.sendEmail(mailMessage);
	    		System.out.println("Send mail with Plain Text");
		} catch (AddressException e) {
		    	e.printStackTrace();
		}
				
	}
}
