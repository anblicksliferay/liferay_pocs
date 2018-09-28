package com.aptiv.commonservices.util;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.liferay.portal.kernel.util.PortalClassLoaderUtil;

public class OracleJDBCConnection {
	/**
	 * Utility method to get the connection object for the DB.
	 * @return Connection object for Oracle Database
	 */
	public static Connection getConnection() {
		try {
			ClassLoader origLoader = Thread.currentThread().getContextClassLoader();
			Thread.currentThread().setContextClassLoader(PortalClassLoaderUtil.getClassLoader());
			InitialContext ctx = new InitialContext();
			DataSource datasource = (DataSource) ctx.lookup("java:comp/env/jdbc/DelphiOracleDB");
			Thread.currentThread().setContextClassLoader(origLoader);
			Connection connection = datasource.getConnection();
			return connection;
		} catch (Exception e) {
			System.out.println("Where is your database?");
			System.out.println(e.toString());
		}
		return null;
	}
}
