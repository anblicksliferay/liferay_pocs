package com.aptiv.commonservices.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.liferay.portal.kernel.util.PortalClassLoaderUtil;

public class SecondExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InitialContext ctx;
		try {
			System.out.println("Okay");
			ClassLoader origLoader = Thread.currentThread().getContextClassLoader();
			Thread.currentThread().setContextClassLoader(PortalClassLoaderUtil.getClassLoader());
			ctx = new InitialContext();
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			DataSource datasource = (DataSource) ctx.lookup("java:comp/env/jdbc/DelphiOracleDB");
			Thread.currentThread().setContextClassLoader(origLoader);
			Connection connection = datasource.getConnection();
			preparedStatement = connection.prepareStatement("select * from AI_MACHINE_OPERATION_TYPE");
			//preparedStatement = connection.prepareStatement("select /*+ INDEX(fis_ins_del_list INDEX_PARENT) */ \"fis_ins_unit_child\" from fis_ins_del_list where \"fis_ins_unit_parent\" ='"+""+"' and \"fis_isdel_unit\" = false" );
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				System.out.println("Result is: " + resultSet.toString());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
