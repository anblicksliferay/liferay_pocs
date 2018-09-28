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
 * The extended model interface for the WFMS_action_and_reasoncode service. Represents a row in the &quot;WFMS_action_and_reasoncode&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_action_and_reasoncodeModel
 * @see com.ys.hmawfm.wfms.services.model.impl.WFMS_action_and_reasoncodeImpl
 * @see com.ys.hmawfm.wfms.services.model.impl.WFMS_action_and_reasoncodeModelImpl
 * @generated
 */
@ImplementationClassName("com.ys.hmawfm.wfms.services.model.impl.WFMS_action_and_reasoncodeImpl")
@ProviderType
public interface WFMS_action_and_reasoncode
	extends WFMS_action_and_reasoncodeModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.ys.hmawfm.wfms.services.model.impl.WFMS_action_and_reasoncodeImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<WFMS_action_and_reasoncode, String> AAR_ID_ACCESSOR =
		new Accessor<WFMS_action_and_reasoncode, String>() {
			@Override
			public String get(
				WFMS_action_and_reasoncode wfms_action_and_reasoncode) {
				return wfms_action_and_reasoncode.getAarId();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<WFMS_action_and_reasoncode> getTypeClass() {
				return WFMS_action_and_reasoncode.class;
			}
		};
}