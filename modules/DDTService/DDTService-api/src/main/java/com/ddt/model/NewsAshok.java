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

package com.ddt.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the NewsAshok service. Represents a row in the &quot;WDDTS_NewsAshok&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see NewsAshokModel
 * @see com.ddt.model.impl.NewsAshokImpl
 * @see com.ddt.model.impl.NewsAshokModelImpl
 * @generated
 */
@ImplementationClassName("com.ddt.model.impl.NewsAshokImpl")
@ProviderType
public interface NewsAshok extends NewsAshokModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.ddt.model.impl.NewsAshokImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<NewsAshok, Long> ID_ACCESSOR = new Accessor<NewsAshok, Long>() {
			@Override
			public Long get(NewsAshok newsAshok) {
				return newsAshok.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<NewsAshok> getTypeClass() {
				return NewsAshok.class;
			}
		};
}