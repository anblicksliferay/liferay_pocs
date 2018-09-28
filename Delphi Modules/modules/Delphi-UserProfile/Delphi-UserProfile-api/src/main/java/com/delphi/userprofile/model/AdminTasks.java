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

package com.delphi.userprofile.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the AdminTasks service. Represents a row in the &quot;Delphi_AdminTasks&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see AdminTasksModel
 * @see com.delphi.userprofile.model.impl.AdminTasksImpl
 * @see com.delphi.userprofile.model.impl.AdminTasksModelImpl
 * @generated
 */
@ImplementationClassName("com.delphi.userprofile.model.impl.AdminTasksImpl")
@ProviderType
public interface AdminTasks extends AdminTasksModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.delphi.userprofile.model.impl.AdminTasksImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<AdminTasks, Long> ADMIN_TASK_ID_ACCESSOR = new Accessor<AdminTasks, Long>() {
			@Override
			public Long get(AdminTasks adminTasks) {
				return adminTasks.getAdminTaskId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<AdminTasks> getTypeClass() {
				return AdminTasks.class;
			}
		};

	public static final Accessor<AdminTasks, Long> USER_ID_ACCESSOR = new Accessor<AdminTasks, Long>() {
			@Override
			public Long get(AdminTasks adminTasks) {
				return adminTasks.getUserId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<AdminTasks> getTypeClass() {
				return AdminTasks.class;
			}
		};
}