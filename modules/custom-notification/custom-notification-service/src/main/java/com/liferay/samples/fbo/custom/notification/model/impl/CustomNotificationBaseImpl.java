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

package com.liferay.samples.fbo.custom.notification.model.impl;

import com.liferay.samples.fbo.custom.notification.model.CustomNotification;
import com.liferay.samples.fbo.custom.notification.service.CustomNotificationLocalServiceUtil;

/**
 * The extended model base implementation for the CustomNotification service. Represents a row in the &quot;FBO_CustomNotification&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CustomNotificationImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CustomNotificationImpl
 * @see CustomNotification
 * @generated
 */
public abstract class CustomNotificationBaseImpl
	extends CustomNotificationModelImpl implements CustomNotification {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a custom notification model instance should use the <code>CustomNotification</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			CustomNotificationLocalServiceUtil.addCustomNotification(this);
		}
		else {
			CustomNotificationLocalServiceUtil.updateCustomNotification(this);
		}
	}

}