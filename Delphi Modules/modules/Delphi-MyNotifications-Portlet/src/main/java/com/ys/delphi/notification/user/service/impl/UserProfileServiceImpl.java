package com.ys.delphi.notification.user.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.ys.delphi.notification.user.model.UserProfile;
import com.ys.delphi.notification.user.service.UserProfileService;

public class UserProfileServiceImpl implements UserProfileService{
	private static Log _log = LogFactoryUtil.getLog(UserProfileServiceImpl.class);

	@Override
	public UserProfile getUserProfile(long userId) {
		UserProfile userProfile = new UserProfile(userId);
		_log.debug("getUserProfile");
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT COMMUNICATIONPREFERENCES, REGION, SITE, SERVER, WORKHOURS FROM  DELPHI_USERPROFILE WHERE USERID = ? " ;
		_log.debug(sql);
		
		try{
			con = DataAccess.getConnection();
			 ps = con.prepareStatement(sql);
			 ps.setLong(1, userId);
			 rs = ps.executeQuery();
			 while(rs.next()){
				 userProfile.setServer(rs.getString("SERVER"));
				 userProfile.setRegion(rs.getString("REGION"));
				 userProfile.setSite(rs.getString("SITE"));
				 userProfile.setCommunicationPreferences(rs.getString("COMMUNICATIONPREFERENCES"));
				 userProfile.setWorkHours(rs.getString("WORKHOURS"));
			 }
		}catch(Exception e){
			_log.error("error while retireving getUserProfile");
			_log.error(e);
		}finally{
			DataAccess.cleanUp(con,ps,rs);
		} 
		return userProfile; 	
	}

}
