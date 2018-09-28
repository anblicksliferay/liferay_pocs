package com.ys.delphi.notification.service.impl;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.sql.DataSource;

public class DelphiHbaseServerConnection {
	    private static Log _log = LogFactoryUtil.getLog(DelphiHbaseServerConnection.class);
	    public static Connection getConnection() throws NamingException, SQLException {
			ClassLoader origLoader = Thread.currentThread().getContextClassLoader();
			Thread.currentThread().setContextClassLoader(PortalClassLoaderUtil.getClassLoader());
			InitialContext ctx = new InitialContext();
			DataSource datasource = (DataSource) ctx.lookup("java:comp/env/jdbc/DelphiPhoenixDB");
			Thread.currentThread().setContextClassLoader(origLoader);
			Connection connection = datasource.getConnection();
			return connection;

			// model.addAttribute("msgArgument",
			// "Maven Java Web Application Project: Success!");
			      
			/**
			 * Get initial context that has references to all configurations and
			 * resources defined for this web application.
			 */
//			Context initialContext = new InitialContext();

			/**
			 * Get Context object for all environment naming (JNDI), such as
			 * Resources configured for this web application.
			 */
			
//			Context environmentContext = (Context) initialContext
//					.lookup("java:comp/env");
			/**
			 * Name of the Resource we want to access.
			 */
//			String dataResourceName = "jdbc/DelphiPhoenixDB";
			/**
			 * Get the data source for the MySQL to request a connection.
			 */
			
//			DataSource dataSource = (DataSource) environmentContext
//					.lookup(dataResourceName);
//			System.out.println("the datasource returned for PhoenixDB is "+dataSource);
			/**
			 * Request a Connection from the pool of connection threads.
			 */
//			Connection conn = dataSource.getConnection();
//			return conn;
	    }
	    public static void close(Connection con, PreparedStatement ps, ResultSet rs){
	    	try { if (rs != null) rs.close(); } catch (Exception e) {_log.error(e.getMessage());};
	        try { if (ps != null) ps.close(); } catch (Exception e) {_log.error(e.getMessage());};
	        try { if (con != null) con.close(); } catch (Exception e) {_log.error(e.getMessage());};
	    }
}
