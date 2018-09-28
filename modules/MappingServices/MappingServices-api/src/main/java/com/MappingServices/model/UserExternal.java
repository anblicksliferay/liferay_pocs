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

package com.MappingServices.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the UserExternal service. Represents a row in the &quot;Ashokleyland_UserExternal&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see UserExternalModel
 * @see com.MappingServices.model.impl.UserExternalImpl
 * @see com.MappingServices.model.impl.UserExternalModelImpl
 * @generated
 */
@ImplementationClassName("com.MappingServices.model.impl.UserExternalImpl")
@ProviderType
public interface UserExternal extends UserExternalModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.MappingServices.model.impl.UserExternalImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<UserExternal, Long> UID_ACCESSOR = new Accessor<UserExternal, Long>() {
			@Override
			public Long get(UserExternal userExternal) {
				return userExternal.getUid();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<UserExternal> getTypeClass() {
				return UserExternal.class;
			}
		};
}