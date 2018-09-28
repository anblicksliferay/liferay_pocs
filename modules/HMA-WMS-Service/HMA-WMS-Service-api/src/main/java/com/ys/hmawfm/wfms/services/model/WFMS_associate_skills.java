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

package com.ys.hmawfm.wfms.services.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the WFMS_associate_skills service. Represents a row in the &quot;WFMS_associate_skills&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_associate_skillsModel
 * @see com.ys.hmawfm.wfms.services.model.impl.WFMS_associate_skillsImpl
 * @see com.ys.hmawfm.wfms.services.model.impl.WFMS_associate_skillsModelImpl
 * @generated
 */
@ImplementationClassName("com.ys.hmawfm.wfms.services.model.impl.WFMS_associate_skillsImpl")
@ProviderType
public interface WFMS_associate_skills extends WFMS_associate_skillsModel,
	PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.ys.hmawfm.wfms.services.model.impl.WFMS_associate_skillsImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<WFMS_associate_skills, String> ASSOCIATE_NUMBER_ACCESSOR =
		new Accessor<WFMS_associate_skills, String>() {
			@Override
			public String get(WFMS_associate_skills wfms_associate_skills) {
				return wfms_associate_skills.getAssociate_number();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<WFMS_associate_skills> getTypeClass() {
				return WFMS_associate_skills.class;
			}
		};
}