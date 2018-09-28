/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

import aQute.bnd.annotation.ProviderType;

import java.util.List;

import com.delphi.userprofile.exception.NoSuchUserAccessRequestException;
import com.delphi.userprofile.model.UserAccessRequest;
import com.delphi.userprofile.service.base.UserAccessRequestLocalServiceBaseImpl;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;

/**
 * The implementation of the user access request local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.delphi.userprofile.service.UserAccessRequestLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserAccessRequestLocalServiceBaseImpl
 * @see com.delphi.userprofile.service.UserAccessRequestLocalServiceUtil
 */
@ProviderType
public class UserAccessRequestLocalServiceImpl
	extends UserAccessRequestLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.delphi.userprofile.service.UserAccessRequestLocalServiceUtil} to access the user access request local service.
	 */

	public  List<UserAccessRequest>  findUserAccessRequestsByUserId(long userId)
			throws com.liferay.portal.kernel.exception.SystemException, NoSuchUserAccessRequestException {
		
		return userAccessRequestPersistence.findByUserId(userId);
	}
	
	public  List<UserAccessRequest> findUserAccessRequestByActiveState(int activeState)
			throws com.liferay.portal.kernel.exception.SystemException, NoSuchUserAccessRequestException {
		
		return userAccessRequestPersistence.findByActiveState(activeState);
	}

	public  UserAccessRequest createNewUserAccessRequest(long userId, long creatorUserId)
			throws com.liferay.portal.kernel.exception.SystemException, NoSuchUserAccessRequestException {
		
		long profileId = CounterLocalServiceUtil.increment(UserAccessRequest.class.getName());
		UserAccessRequest userAccessRequest = userAccessRequestPersistence.create(profileId);
		userAccessRequest.setUserId(userId);
		userAccessRequest.setCreatedById(creatorUserId);
		userAccessRequestPersistence.update(userAccessRequest);
		
		return userAccessRequest;
	}
}