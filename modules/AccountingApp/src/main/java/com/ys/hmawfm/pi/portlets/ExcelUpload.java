package com.ys.hmawfm.pi.portlets;

import java.io.File;
import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.json.JSONException;
import org.json.JSONObject;
import org.osgi.service.component.annotations.Component;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
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
			"javax.portlet.display-name=ExcelUpload Portlet",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/view.jsp",
			"javax.portlet.name=ExcelUpload",
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)

public class ExcelUpload extends MVCPortlet{
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		/*try {
			JSONArray jsonArray = new JSONArray();
			jsonArray.put("D:/test.xls");
			jsonArray.put("D:/test1.xls");
			jsonArray.put("D:/test2.xls");			
			for(int i=0;i<jsonArray.length();i++){
				excelupload(jsonArray.get(i).toString());				
			}
		} catch (BiffException | JSONException e) {
			e.printStackTrace();
		}	*/	
		try {
			excelupload();
		} catch (BiffException e) {
			e.printStackTrace();
		}
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
	public static void excelupload() throws IOException,BiffException{		
		try {	
		//	System.out.println(path);
			File file = new File("D:/test.xls");
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
}