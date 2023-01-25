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

package com.liferay.samples.fbo.custom.notification.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.samples.fbo.custom.notification.exception.NoSuchCustomNotificationException;
import com.liferay.samples.fbo.custom.notification.model.CustomNotification;
import com.liferay.samples.fbo.custom.notification.service.base.CustomNotificationLocalServiceBaseImpl;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.liferay.samples.fbo.custom.notification.model.CustomNotification",
	service = AopService.class
)
public class CustomNotificationLocalServiceImpl
	extends CustomNotificationLocalServiceBaseImpl {
	
	public CustomNotification getCustomNotificationByCompanyAndUserNotificationEvent(long companyId, long userNotificationEventId) throws NoSuchCustomNotificationException {
		return customNotificationPersistence.findByCompanyAndUserNotificationEvent(companyId, userNotificationEventId);
	}

	public List<CustomNotification> getCustomNotificationByCompanyAndUserAndNotificationType(long companyId, long userId, String notificationType, int start, int end) {
		return customNotificationPersistence.findByCompanyUserAndNotificationType(companyId, userId, notificationType, start, end);
	}

	public List<CustomNotification> getCustomNotificationByCompanyAndUser(long companyId, long userId, int start, int end) {
		return customNotificationPersistence.findByCompanyAndUser(companyId, userId, start, end);
	}

	
}