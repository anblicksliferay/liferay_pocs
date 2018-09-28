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

package com.ys.hmawfm.wfms.services.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.ys.hmawfm.wfms.services.model.WFMS_action_and_reasoncode;
import com.ys.hmawfm.wfms.services.service.WFMS_action_and_reasoncodeLocalServiceUtil;

/**
 * The extended model base implementation for the WFMS_action_and_reasoncode service. Represents a row in the &quot;WFMS_action_and_reasoncode&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link WFMS_action_and_reasoncodeImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_action_and_reasoncodeImpl
 * @see WFMS_action_and_reasoncode
 * @generated
 */
@ProviderType
public abstract class WFMS_action_and_reasoncodeBaseImpl
	extends WFMS_action_and_reasoncodeModelImpl
	implements WFMS_action_and_reasoncode {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a WFMS_action_and_reasoncode model instance should use the {@link WFMS_action_and_reasoncode} interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			WFMS_action_and_reasoncodeLocalServiceUtil.addWFMS_action_and_reasoncode(this);
		}
		else {
			WFMS_action_and_reasoncodeLocalServiceUtil.updateWFMS_action_and_reasoncode(this);
		}
	}
}