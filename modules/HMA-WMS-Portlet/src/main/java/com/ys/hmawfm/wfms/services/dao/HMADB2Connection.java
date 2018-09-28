package com.ys.hmawfm.wfms.services.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;

public class HMADB2Connection{
	protected static String _driver 		= PropsUtil.get("jdbc.honda.associatedata.driverClassName");
	protected static String _url 			= PropsUtil.get("jdbc.honda.associatedata.url");
	protected static String _username 		= PropsUtil.get("jdbc.honda.associatedata.username");
	protected static String _password 		= PropsUtil.get("jdbc.honda.associatedata.password");
	protected static String _assocTableName = PropsUtil.get("jdbc.honda.associatedata.tablename");
	protected static String _approversTableName = PropsUtil.get("jdbc.honda.approversTableName.tablename");
	
	/**
	 * 
	 * @return Connection
	 */
	public static Connection getConnection() {
		Connection connection = null;

		try {
		//	_log.info("Getting connection with driver type "+_driver);
			Class.forName(_driver).newInstance();
			connection = DriverManager.getConnection(_url, _username, _password);
			
		} catch (Exception ex) {
			_log.error("Error Occured While Getting the Connection: - "
					+ ex);
		}
		return connection;
	}

	/**
	 * 
	 * @return String
	 */
	public static String getAssocTableName() {
		return _assocTableName;
	}
	
	/**
	 * 
	 * @return String
	 */
	public static String getRoutingApproversTableName(){
		return _approversTableName;
		
	}
	
	/**
	 * 
	 * @param connection
	 */
	public static void close(Connection connection) {
         try  {
        	 connection.close();
         }catch(Exception ex) {
        	 _log.error("Error closing the Connection: - "
 					+ ex);
         }
    }
	private static Log _log = LogFactoryUtil.getLog(HMADB2Connection.class.getName());
}