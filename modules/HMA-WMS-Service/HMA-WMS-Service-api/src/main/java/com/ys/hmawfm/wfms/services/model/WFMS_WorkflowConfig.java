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
 * The extended model interface for the WFMS_WorkflowConfig service. Represents a row in the &quot;WFMS_WorkflowConfig&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_WorkflowConfigModel
 * @see com.ys.hmawfm.wfms.services.model.impl.WFMS_WorkflowConfigImpl
 * @see com.ys.hmawfm.wfms.services.model.impl.WFMS_WorkflowConfigModelImpl
 * @generated
 */
@ImplementationClassName("com.ys.hmawfm.wfms.services.model.impl.WFMS_WorkflowConfigImpl")
@ProviderType
public interface WFMS_WorkflowConfig extends WFMS_WorkflowConfigModel,
	PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.ys.hmawfm.wfms.services.model.impl.WFMS_WorkflowConfigImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<WFMS_WorkflowConfig, Long> WFC_ID_ACCESSOR = new Accessor<WFMS_WorkflowConfig, Long>() {
			@Override
			public Long get(WFMS_WorkflowConfig wfms_WorkflowConfig) {
				return wfms_WorkflowConfig.getWfcId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<WFMS_WorkflowConfig> getTypeClass() {
				return WFMS_WorkflowConfig.class;
			}
		};
}