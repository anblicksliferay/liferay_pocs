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

package com.astra.anblicks.pdca.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the kpi service. Represents a row in the &quot;astra_kpi&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see kpiModel
 * @see com.astra.anblicks.pdca.model.impl.kpiImpl
 * @see com.astra.anblicks.pdca.model.impl.kpiModelImpl
 * @generated
 */
@ImplementationClassName("com.astra.anblicks.pdca.model.impl.kpiImpl")
@ProviderType
public interface kpi extends kpiModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.astra.anblicks.pdca.model.impl.kpiImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<kpi, Long> KPI_ID_ACCESSOR = new Accessor<kpi, Long>() {
			@Override
			public Long get(kpi kpi) {
				return kpi.getKpiId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<kpi> getTypeClass() {
				return kpi.class;
			}
		};
}