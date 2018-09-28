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

import com.ys.hmawfm.wfms.services.model.WFMS_Position;
import com.ys.hmawfm.wfms.services.service.WFMS_PositionLocalServiceUtil;

/**
 * The extended model base implementation for the WFMS_Position service. Represents a row in the &quot;WFMS_Position&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link WFMS_PositionImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_PositionImpl
 * @see WFMS_Position
 * @generated
 */
@ProviderType
public abstract class WFMS_PositionBaseImpl extends WFMS_PositionModelImpl
	implements WFMS_Position {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a WFMS_Position model instance should use the {@link WFMS_Position} interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			WFMS_PositionLocalServiceUtil.addWFMS_Position(this);
		}
		else {
			WFMS_PositionLocalServiceUtil.updateWFMS_Position(this);
		}
	}
}