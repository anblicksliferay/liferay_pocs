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
 * The extended model interface for the WFMS_Associate_History service. Represents a row in the &quot;WFMS_Associate_History&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_Associate_HistoryModel
 * @see com.ys.hmawfm.wfms.services.model.impl.WFMS_Associate_HistoryImpl
 * @see com.ys.hmawfm.wfms.services.model.impl.WFMS_Associate_HistoryModelImpl
 * @generated
 */
@ImplementationClassName("com.ys.hmawfm.wfms.services.model.impl.WFMS_Associate_HistoryImpl")
@ProviderType
public interface WFMS_Associate_History extends WFMS_Associate_HistoryModel,
	PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.ys.hmawfm.wfms.services.model.impl.WFMS_Associate_HistoryImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<WFMS_Associate_History, Integer> ASSOC_HISTORY_ID_ACCESSOR =
		new Accessor<WFMS_Associate_History, Integer>() {
			@Override
			public Integer get(WFMS_Associate_History wfms_Associate_History) {
				return wfms_Associate_History.getAssocHistoryId();
			}

			@Override
			public Class<Integer> getAttributeClass() {
				return Integer.class;
			}

			@Override
			public Class<WFMS_Associate_History> getTypeClass() {
				return WFMS_Associate_History.class;
			}
		};
}