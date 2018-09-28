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

package com.leykartservice.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the Testmonials service. Represents a row in the &quot;LeyKart_Testmonials&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see TestmonialsModel
 * @see com.leykartservice.model.impl.TestmonialsImpl
 * @see com.leykartservice.model.impl.TestmonialsModelImpl
 * @generated
 */
@ImplementationClassName("com.leykartservice.model.impl.TestmonialsImpl")
@ProviderType
public interface Testmonials extends TestmonialsModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.leykartservice.model.impl.TestmonialsImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Testmonials, Long> TESTMONIALS_ID_ACCESSOR = new Accessor<Testmonials, Long>() {
			@Override
			public Long get(Testmonials testmonials) {
				return testmonials.getTestmonialsId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Testmonials> getTypeClass() {
				return Testmonials.class;
			}
		};
}