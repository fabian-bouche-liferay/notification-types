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

package com.liferay.samples.fbo.custom.notification.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CustomNotificationService}.
 *
 * @author Brian Wing Shun Chan
 * @see CustomNotificationService
 * @generated
 */
public class CustomNotificationServiceWrapper
	implements CustomNotificationService,
			   ServiceWrapper<CustomNotificationService> {

	public CustomNotificationServiceWrapper(
		CustomNotificationService customNotificationService) {

		_customNotificationService = customNotificationService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _customNotificationService.getOSGiServiceIdentifier();
	}

	@Override
	public CustomNotificationService getWrappedService() {
		return _customNotificationService;
	}

	@Override
	public void setWrappedService(
		CustomNotificationService customNotificationService) {

		_customNotificationService = customNotificationService;
	}

	private CustomNotificationService _customNotificationService;

}