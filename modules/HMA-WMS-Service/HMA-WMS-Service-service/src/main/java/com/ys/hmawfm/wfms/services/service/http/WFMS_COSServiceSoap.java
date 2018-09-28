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

package com.ys.hmawfm.wfms.services.service.http;

import aQute.bnd.annotation.ProviderType;

/**
 * Provides the SOAP utility for the
 * {@link com.ys.hmawfm.wfms.services.service.WFMS_COSServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.ys.hmawfm.wfms.services.model.WFMS_COSSoap}.
 * If the method in the service utility returns a
 * {@link com.ys.hmawfm.wfms.services.model.WFMS_COS}, that is translated to a
 * {@link com.ys.hmawfm.wfms.services.model.WFMS_COSSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WFMS_COSServiceHttp
 * @see com.ys.hmawfm.wfms.services.model.WFMS_COSSoap
 * @see com.ys.hmawfm.wfms.services.service.WFMS_COSServiceUtil
 * @generated
 */
@ProviderType
public class WFMS_COSServiceSoap {
}