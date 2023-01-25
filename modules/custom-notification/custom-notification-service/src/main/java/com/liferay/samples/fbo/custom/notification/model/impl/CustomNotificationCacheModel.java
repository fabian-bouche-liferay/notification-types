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

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.samples.fbo.custom.notification.model.CustomNotification;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CustomNotification in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CustomNotificationCacheModel
	implements CacheModel<CustomNotification>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CustomNotificationCacheModel)) {
			return false;
		}

		CustomNotificationCacheModel customNotificationCacheModel =
			(CustomNotificationCacheModel)object;

		if (customNotificationId ==
				customNotificationCacheModel.customNotificationId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, customNotificationId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", customNotificationId=");
		sb.append(customNotificationId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", userNotificationEventId=");
		sb.append(userNotificationEventId);
		sb.append(", notificationType=");
		sb.append(notificationType);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CustomNotification toEntityModel() {
		CustomNotificationImpl customNotificationImpl =
			new CustomNotificationImpl();

		if (uuid == null) {
			customNotificationImpl.setUuid("");
		}
		else {
			customNotificationImpl.setUuid(uuid);
		}

		customNotificationImpl.setCustomNotificationId(customNotificationId);
		customNotificationImpl.setCompanyId(companyId);
		customNotificationImpl.setUserId(userId);

		if (userName == null) {
			customNotificationImpl.setUserName("");
		}
		else {
			customNotificationImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			customNotificationImpl.setCreateDate(null);
		}
		else {
			customNotificationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			customNotificationImpl.setModifiedDate(null);
		}
		else {
			customNotificationImpl.setModifiedDate(new Date(modifiedDate));
		}

		customNotificationImpl.setUserNotificationEventId(
			userNotificationEventId);

		if (notificationType == null) {
			customNotificationImpl.setNotificationType("");
		}
		else {
			customNotificationImpl.setNotificationType(notificationType);
		}

		customNotificationImpl.resetOriginalValues();

		return customNotificationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		customNotificationId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		userNotificationEventId = objectInput.readLong();
		notificationType = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(customNotificationId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(userNotificationEventId);

		if (notificationType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(notificationType);
		}
	}

	public String uuid;
	public long customNotificationId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long userNotificationEventId;
	public String notificationType;

}