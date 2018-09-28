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

package com.ddt.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the Loc_Course_Info service. Represents a row in the &quot;WDDTS_Loc_Course_Info&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see Loc_Course_InfoModel
 * @see com.ddt.model.impl.Loc_Course_InfoImpl
 * @see com.ddt.model.impl.Loc_Course_InfoModelImpl
 * @generated
 */
@ImplementationClassName("com.ddt.model.impl.Loc_Course_InfoImpl")
@ProviderType
public interface Loc_Course_Info extends Loc_Course_InfoModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.ddt.model.impl.Loc_Course_InfoImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Loc_Course_Info, Long> ID_ACCESSOR = new Accessor<Loc_Course_Info, Long>() {
			@Override
			public Long get(Loc_Course_Info loc_Course_Info) {
				return loc_Course_Info.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Loc_Course_Info> getTypeClass() {
				return Loc_Course_Info.class;
			}
		};
}