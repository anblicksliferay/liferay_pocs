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

import com.ys.hmawfm.wfms.services.model.WFMS_associate_skills_audit;
import com.ys.hmawfm.wfms.services.service.WFMS_associate_skills_auditLocalServiceUtil;

/**
 * The extended model base implementation for the WFMS_associate_skills_audit service. Represents a row in the &quot;WFMS_associate_skills_audit&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link WFMS_associate_skills_auditImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_associate_skills_auditImpl
 * @see WFMS_associate_skills_audit
 * @generated
 */
@ProviderType
public abstract class WFMS_associate_skills_auditBaseImpl
	extends WFMS_associate_skills_auditModelImpl
	implements WFMS_associate_skills_audit {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a WFMS_associate_skills_audit model instance should use the {@link WFMS_associate_skills_audit} interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			WFMS_associate_skills_auditLocalServiceUtil.addWFMS_associate_skills_audit(this);
		}
		else {
			WFMS_associate_skills_auditLocalServiceUtil.updateWFMS_associate_skills_audit(this);
		}
	}
}