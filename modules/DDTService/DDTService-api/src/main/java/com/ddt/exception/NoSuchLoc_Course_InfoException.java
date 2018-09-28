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
package com.ddt.exception;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
@ProviderType
public class NoSuchLoc_Course_InfoException extends NoSuchModelException {

	public NoSuchLoc_Course_InfoException() {
	}

	public NoSuchLoc_Course_InfoException(String msg) {
		super(msg);
	}

	public NoSuchLoc_Course_InfoException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchLoc_Course_InfoException(Throwable cause) {
		super(cause);
	}

}