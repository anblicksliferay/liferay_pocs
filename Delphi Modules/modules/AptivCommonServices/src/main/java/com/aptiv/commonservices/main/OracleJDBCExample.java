package com.aptiv.commonservices.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.liferay.portal.kernel.util.PortalClassLoaderUtil;

public class OracleJDBCExample {
	public static void main(String[] args) {
		//getConnection();
		HashMap<String, Integer> operationList = new HashMap<String, Integer>(); 
		operationList.put("Sarath", 1);
		operationList.put("Murali", 2);
		operationList.put("Sita", 3);
		operationList.put("Soumya", 4);
		operationList.put("Sri", 5);
		HashMap<String, Integer> machineList = new HashMap<String, Integer>();
		machineList.put("Chandra", 1);
		machineList.put("Krishna", 2);
		machineList.put("Lakshmi", 3);
		machineList.put("Chakkilam", 4);
		machineList.put("Kruthi", 5);
		machineList.put("Chaitanya", 6);
	}

	private static void getConnection() {
		InitialContext ctx;
		try {
			ClassLoader origLoader = Thread.currentThread().getContextClassLoader();
			Thread.currentThread().setContextClassLoader(PortalClassLoaderUtil.getClassLoader());
			ctx = new InitialContext();
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			DataSource datasource = (DataSource) ctx.lookup("java:comp/env/jdbc/DelphiOracleDB");
			Thread.currentThread().setContextClassLoader(origLoader);
			Connection connection = datasource.getConnection();
			preparedStatement = connection.prepareStatement("select * from AI_MACHINE_OPERATION_TYPE");
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
