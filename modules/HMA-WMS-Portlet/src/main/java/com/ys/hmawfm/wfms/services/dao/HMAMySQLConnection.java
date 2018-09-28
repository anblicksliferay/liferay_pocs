package com.ys.hmawfm.wfms.services.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;

public class HMAMySQLConnection{
	protected static String _driver 	= PropsUtil.get("jdbc.default.driverClassName");
	protected static String _url 		= PropsUtil.get("jdbc.default.url");
	protected static String _schema 	= PropsUtil.get("jdbc.default.schema");
	protected static String _username 	= PropsUtil.get("jdbc.default.username");
	protected static String _password 	= PropsUtil.get("jdbc.default.password");
	protected static String _wfms_position 	= PropsUtil.get("jdbc.default.wfms_position.tablename");
	protected static String _wfms_requisition 	= PropsUtil.get("jdbc.default.schema");
	protected static String _wfms_cos	= PropsUtil.get("jdbc.default.schema");
	
	/**
	 * 
	 * @return Connection
	 */
	public static Connection getConnection() {
		Connection connection = null;
		try {
		//	_log.info("Getting connection with driver type "+_driver);
		//	_log.info("getConnection for: "+_url+", _username:"+ _username+", _password: "+_password);
			Class.forName(_driver).newInstance();
			connection = DriverManager.getConnection(_url, _username, _password);
		} catch (Exception ex) {
			_log.error("Error Occured While Getting the Connection: - "+ ex);
		}
		return connection;
	}

	/**
	 * 
	 * @return String
	 */
	public static String getSchema() {
		return _schema;
	}
	
	

	
	public java.util.List<String> getPositionsForCOS()
	{
		
		    java.util.List<String> valuesList = new ArrayList<String>();
	        Connection conn = HMAMySQLConnection.getConnection();
	       
	        PreparedStatement stmt = null;
	        ResultSet rs = null;
	       
	        try{
	            if(conn!=null){
	            	
	            	String sql="SELECT pId FROM _wfms_position p INNER JOIN _wfms_requisition r ON (p.pid= r.rid) INNER JOIN _wfms_cos c ON (p.pid= c.positionNumber)WHERE p.status = 'open' AND (r.status= 'Complete' OR r.status ='Cancelled') AND ( c.status='Approved' OR  c.status='Cancelled' OR  c.status='Disapprove')";
	                _log.info("HMAAssociateInfoService.getDistinctDeptNumbers() sql: " + sql);
	                stmt = conn.prepareStatement(sql);       
	                rs = stmt.executeQuery();       
	            }
	           
	            if(null==rs) return valuesList;
	   
	            while(rs.next()){ 
	            	valuesList.add(rs.getString("pId").trim());
	            }
	           
	            conn.close();
	            stmt.close();
	            rs.close();
	           
	        }
	       
	        catch(SQLException ex){
	           
	            _log.info("HMAAssociateInfoService.getDistinctDeptNumbers() SQLException",ex);
	           
	            if(conn !=null){
	                try {
	                    conn.rollback();
	                } catch (SQLException e1) {
	                    _log.error("HMAAssociateInfoService.getDistinctDeptNumbers() Error",ex);
	                }
	            }
	           
	        }
	       
	        finally{
	            if(conn != null){
	                try {
	                    conn.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	            if(stmt != null){
	                try {
	            stmt.close();
	                } catch (SQLException e) {
	           
	                    e.printStackTrace();
	                }
	            }
	            if(rs != null){
	                try {
	                    rs.close();
	                } catch (SQLException e) {
	                   
	                    e.printStackTrace();
	                }
	                       
	            }
	           
	        }
	           
		 return valuesList;
		
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
	 private static Log _log = LogFactoryUtil.getLog(HMAMySQLConnection.class.getName());
}