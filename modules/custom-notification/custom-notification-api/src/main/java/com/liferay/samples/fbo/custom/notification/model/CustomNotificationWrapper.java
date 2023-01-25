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

package com.liferay.samples.fbo.custom.notification.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link CustomNotification}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CustomNotification
 * @generated
 */
public class CustomNotificationWrapper
	extends BaseModelWrapper<CustomNotification>
	implements CustomNotification, ModelWrapper<CustomNotification> {

	public CustomNotificationWrapper(CustomNotification customNotification) {
		super(customNotification);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("customNotificationId", getCustomNotificationId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userNotificationEventId", getUserNotificationEventId());
		attributes.put("notificationType", getNotificationType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long customNotificationId = (Long)attributes.get(
			"customNotificationId");

		if (customNotificationId != null) {
			setCustomNotificationId(customNotificationId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long userNotificationEventId = (Long)attributes.get(
			"userNotificationEventId");

		if (userNotificationEventId != null) {
			setUserNotificationEventId(userNotificationEventId);
		}

		String notificationType = (String)attributes.get("notificationType");

		if (notificationType != null) {
			setNotificationType(notificationType);
		}
	}

	/**
	 * Returns the company ID of this custom notification.
	 *
	 * @return the company ID of this custom notification
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this custom notification.
	 *
	 * @return the create date of this custom notification
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the custom notification ID of this custom notification.
	 *
	 * @return the custom notification ID of this custom notification
	 */
	@Override
	public long getCustomNotificationId() {
		return model.getCustomNotificationId();
	}

	/**
	 * Returns the modified date of this custom notification.
	 *
	 * @return the modified date of this custom notification
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the notification type of this custom notification.
	 *
	 * @return the notification type of this custom notification
	 */
	@Override
	public String getNotificationType() {
		return model.getNotificationType();
	}

	/**
	 * Returns the primary key of this custom notification.
	 *
	 * @return the primary key of this custom notification
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this custom notification.
	 *
	 * @return the user ID of this custom notification
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this custom notification.
	 *
	 * @return the user name of this custom notification
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user notification event ID of this custom notification.
	 *
	 * @return the user notification event ID of this custom notification
	 */
	@Override
	public long getUserNotificationEventId() {
		return model.getUserNotificationEventId();
	}

	/**
	 * Returns the user uuid of this custom notification.
	 *
	 * @return the user uuid of this custom notification
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this custom notification.
	 *
	 * @return the uuid of this custom notification
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this custom notification.
	 *
	 * @param companyId the company ID of this custom notification
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this custom notification.
	 *
	 * @param createDate the create date of this custom notification
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the custom notification ID of this custom notification.
	 *
	 * @param customNotificationId the custom notification ID of this custom notification
	 */
	@Override
	public void setCustomNotificationId(long customNotificationId) {
		model.setCustomNotificationId(customNotificationId);
	}

	/**
	 * Sets the modified date of this custom notification.
	 *
	 * @param modifiedDate the modified date of this custom notification
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the notification type of this custom notification.
	 *
	 * @param notificationType the notification type of this custom notification
	 */
	@Override
	public void setNotificationType(String notificationType) {
		model.setNotificationType(notificationType);
	}

	/**
	 * Sets the primary key of this custom notification.
	 *
	 * @param primaryKey the primary key of this custom notification
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this custom notification.
	 *
	 * @param userId the user ID of this custom notification
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this custom notification.
	 *
	 * @param userName the user name of this custom notification
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user notification event ID of this custom notification.
	 *
	 * @param userNotificationEventId the user notification event ID of this custom notification
	 */
	@Override
	public void setUserNotificationEventId(long userNotificationEventId) {
		model.setUserNotificationEventId(userNotificationEventId);
	}

	/**
	 * Sets the user uuid of this custom notification.
	 *
	 * @param userUuid the user uuid of this custom notification
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this custom notification.
	 *
	 * @param uuid the uuid of this custom notification
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected CustomNotificationWrapper wrap(
		CustomNotification customNotification) {

		return new CustomNotificationWrapper(customNotification);
	}

}