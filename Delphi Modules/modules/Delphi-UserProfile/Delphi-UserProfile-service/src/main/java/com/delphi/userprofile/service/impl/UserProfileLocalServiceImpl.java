/**
/ * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.delphi.userprofile.service.impl;

import com.delphi.userprofile.service.base.UserProfileLocalServiceBaseImpl;

import aQute.bnd.annotation.ProviderType;
import com.delphi.userprofile.exception.NoSuchUserProfileException;
import com.delphi.userprofile.model.UserProfile;

import com.liferay.counter.kernel.model.Counter;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;

/**
 * The implementation of the user profile local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.delphi.userprofile.service.UserProfileLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserProfileLocalServiceBaseImpl
 * @see com.delphi.userprofile.service.UserProfileLocalServiceUtil
 */
@ProviderType
public class UserProfileLocalServiceImpl extends UserProfileLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.delphi.userprofile.service.UserProfileLocalServiceUtil} to access the user profile local service.
	 */

	public  UserProfile findUserProfileByUserId(long userId)
			throws com.liferay.portal.kernel.exception.SystemException, NoSuchUserProfileException {
		
		return userProfilePersistence.findByUserId(userId);
	}

	public  UserProfile createNewUserProfile(long userId, long creatorUserId)
			throws com.liferay.portal.kernel.exception.SystemException, NoSuchUserProfileException {
		
		long profileId = CounterLocalServiceUtil.increment(UserProfile.class.getName());
		UserProfile userProfile = userProfilePersistence.create(profileId);
		userProfile.setUserId(userId);
		userProfile.setCreatedById(creatorUserId);
		userProfile.setCommunicationPreferences("{}");
		userProfile.setWorkHours("{}");
		userProfile.setInterests("{}");
		userProfile.setJobrole("{}");
		userProfile.setPortlets("{\"defaultPage\":\"/group/delphi/welcome\",\"Welcome\":true,\"Revenue & Expense\":false,\"Alerts & Thresholds\":true,\"Production Status Display\":true,\"Global Unit History\":true,\"Admin Tasks\":false}");
		userProfile.setCreatedById(creatorUserId);
		userProfilePersistence.update(userProfile);
		
		return userProfile;
	}
	
}