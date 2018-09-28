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

package ddtii.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the loc_cou_cat service. Represents a row in the &quot;DDTII_loc_cou_cat&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see loc_cou_catModel
 * @see ddtii.model.impl.loc_cou_catImpl
 * @see ddtii.model.impl.loc_cou_catModelImpl
 * @generated
 */
@ImplementationClassName("ddtii.model.impl.loc_cou_catImpl")
@ProviderType
public interface loc_cou_cat extends loc_cou_catModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link ddtii.model.impl.loc_cou_catImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<loc_cou_cat, Long> LOC_COU_CAT_ID_ACCESSOR = new Accessor<loc_cou_cat, Long>() {
			@Override
			public Long get(loc_cou_cat loc_cou_cat) {
				return loc_cou_cat.getLoc_cou_catId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<loc_cou_cat> getTypeClass() {
				return loc_cou_cat.class;
			}
		};
}