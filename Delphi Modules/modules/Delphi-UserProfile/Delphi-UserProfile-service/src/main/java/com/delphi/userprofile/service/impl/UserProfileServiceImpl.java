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

import com.delphi.userprofile.service.base.UserProfileServiceBaseImpl;

import aQute.bnd.annotation.ProviderType;

/**
 * The implementation of the user profile remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.delphi.userprofile.service.UserProfileService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserProfileServiceBaseImpl
 * @see com.delphi.userprofile.service.UserProfileServiceUtil
 */
@ProviderType
public class UserProfileServiceImpl extends UserProfileServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.delphi.userprofile.service.UserProfileServiceUtil} to access the user profile remote service.
	 */
}