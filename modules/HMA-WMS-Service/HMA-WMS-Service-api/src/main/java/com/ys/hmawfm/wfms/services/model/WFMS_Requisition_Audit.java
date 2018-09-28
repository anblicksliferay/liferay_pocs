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
 * The extended model interface for the WFMS_Requisition_Audit service. Represents a row in the &quot;WFMS_Requisition_Audit&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_Requisition_AuditModel
 * @see com.ys.hmawfm.wfms.services.model.impl.WFMS_Requisition_AuditImpl
 * @see com.ys.hmawfm.wfms.services.model.impl.WFMS_Requisition_AuditModelImpl
 * @generated
 */
@ImplementationClassName("com.ys.hmawfm.wfms.services.model.impl.WFMS_Requisition_AuditImpl")
@ProviderType
public interface WFMS_Requisition_Audit extends WFMS_Requisition_AuditModel,
	PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.ys.hmawfm.wfms.services.model.impl.WFMS_Requisition_AuditImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<WFMS_Requisition_Audit, String> REQA_ID_ACCESSOR =
		new Accessor<WFMS_Requisition_Audit, String>() {
			@Override
			public String get(WFMS_Requisition_Audit wfms_Requisition_Audit) {
				return wfms_Requisition_Audit.getReqaId();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<WFMS_Requisition_Audit> getTypeClass() {
				return WFMS_Requisition_Audit.class;
			}
		};
}