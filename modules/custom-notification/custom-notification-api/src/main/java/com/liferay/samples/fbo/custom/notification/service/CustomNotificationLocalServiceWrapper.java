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
 * Provides a wrapper for {@link CustomNotificationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CustomNotificationLocalService
 * @generated
 */
public class CustomNotificationLocalServiceWrapper
	implements CustomNotificationLocalService,
			   ServiceWrapper<CustomNotificationLocalService> {

	public CustomNotificationLocalServiceWrapper(
		CustomNotificationLocalService customNotificationLocalService) {

		_customNotificationLocalService = customNotificationLocalService;
	}

	/**
	 * Adds the custom notification to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CustomNotificationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param customNotification the custom notification
	 * @return the custom notification that was added
	 */
	@Override
	public com.liferay.samples.fbo.custom.notification.model.CustomNotification
		addCustomNotification(
			com.liferay.samples.fbo.custom.notification.model.CustomNotification
				customNotification) {

		return _customNotificationLocalService.addCustomNotification(
			customNotification);
	}

	/**
	 * Creates a new custom notification with the primary key. Does not add the custom notification to the database.
	 *
	 * @param customNotificationId the primary key for the new custom notification
	 * @return the new custom notification
	 */
	@Override
	public com.liferay.samples.fbo.custom.notification.model.CustomNotification
		createCustomNotification(long customNotificationId) {

		return _customNotificationLocalService.createCustomNotification(
			customNotificationId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _customNotificationLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the custom notification from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CustomNotificationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param customNotification the custom notification
	 * @return the custom notification that was removed
	 */
	@Override
	public com.liferay.samples.fbo.custom.notification.model.CustomNotification
		deleteCustomNotification(
			com.liferay.samples.fbo.custom.notification.model.CustomNotification
				customNotification) {

		return _customNotificationLocalService.deleteCustomNotification(
			customNotification);
	}

	/**
	 * Deletes the custom notification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CustomNotificationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param customNotificationId the primary key of the custom notification
	 * @return the custom notification that was removed
	 * @throws PortalException if a custom notification with the primary key could not be found
	 */
	@Override
	public com.liferay.samples.fbo.custom.notification.model.CustomNotification
			deleteCustomNotification(long customNotificationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _customNotificationLocalService.deleteCustomNotification(
			customNotificationId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _customNotificationLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _customNotificationLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _customNotificationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.samples.fbo.custom.notification.model.impl.CustomNotificationModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _customNotificationLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.samples.fbo.custom.notification.model.impl.CustomNotificationModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _customNotificationLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _customNotificationLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _customNotificationLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.samples.fbo.custom.notification.model.CustomNotification
		fetchCustomNotification(long customNotificationId) {

		return _customNotificationLocalService.fetchCustomNotification(
			customNotificationId);
	}

	/**
	 * Returns the custom notification with the matching UUID and company.
	 *
	 * @param uuid the custom notification's UUID
	 * @param companyId the primary key of the company
	 * @return the matching custom notification, or <code>null</code> if a matching custom notification could not be found
	 */
	@Override
	public com.liferay.samples.fbo.custom.notification.model.CustomNotification
		fetchCustomNotificationByUuidAndCompanyId(String uuid, long companyId) {

		return _customNotificationLocalService.
			fetchCustomNotificationByUuidAndCompanyId(uuid, companyId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _customNotificationLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the custom notification with the primary key.
	 *
	 * @param customNotificationId the primary key of the custom notification
	 * @return the custom notification
	 * @throws PortalException if a custom notification with the primary key could not be found
	 */
	@Override
	public com.liferay.samples.fbo.custom.notification.model.CustomNotification
			getCustomNotification(long customNotificationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _customNotificationLocalService.getCustomNotification(
			customNotificationId);
	}

	@Override
	public java.util.List
		<com.liferay.samples.fbo.custom.notification.model.CustomNotification>
			getCustomNotificationByCompanyAndUser(
				long companyId, long userId, int start, int end) {

		return _customNotificationLocalService.
			getCustomNotificationByCompanyAndUser(
				companyId, userId, start, end);
	}

	@Override
	public java.util.List
		<com.liferay.samples.fbo.custom.notification.model.CustomNotification>
			getCustomNotificationByCompanyAndUserAndNotificationType(
				long companyId, long userId, String notificationType, int start,
				int end) {

		return _customNotificationLocalService.
			getCustomNotificationByCompanyAndUserAndNotificationType(
				companyId, userId, notificationType, start, end);
	}

	@Override
	public com.liferay.samples.fbo.custom.notification.model.CustomNotification
			getCustomNotificationByCompanyAndUserNotificationEvent(
				long companyId, long userNotificationEventId)
		throws com.liferay.samples.fbo.custom.notification.exception.
			NoSuchCustomNotificationException {

		return _customNotificationLocalService.
			getCustomNotificationByCompanyAndUserNotificationEvent(
				companyId, userNotificationEventId);
	}

	/**
	 * Returns the custom notification with the matching UUID and company.
	 *
	 * @param uuid the custom notification's UUID
	 * @param companyId the primary key of the company
	 * @return the matching custom notification
	 * @throws PortalException if a matching custom notification could not be found
	 */
	@Override
	public com.liferay.samples.fbo.custom.notification.model.CustomNotification
			getCustomNotificationByUuidAndCompanyId(String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _customNotificationLocalService.
			getCustomNotificationByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of all the custom notifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.samples.fbo.custom.notification.model.impl.CustomNotificationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of custom notifications
	 * @param end the upper bound of the range of custom notifications (not inclusive)
	 * @return the range of custom notifications
	 */
	@Override
	public java.util.List
		<com.liferay.samples.fbo.custom.notification.model.CustomNotification>
			getCustomNotifications(int start, int end) {

		return _customNotificationLocalService.getCustomNotifications(
			start, end);
	}

	/**
	 * Returns the number of custom notifications.
	 *
	 * @return the number of custom notifications
	 */
	@Override
	public int getCustomNotificationsCount() {
		return _customNotificationLocalService.getCustomNotificationsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _customNotificationLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _customNotificationLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _customNotificationLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _customNotificationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the custom notification in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CustomNotificationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param customNotification the custom notification
	 * @return the custom notification that was updated
	 */
	@Override
	public com.liferay.samples.fbo.custom.notification.model.CustomNotification
		updateCustomNotification(
			com.liferay.samples.fbo.custom.notification.model.CustomNotification
				customNotification) {

		return _customNotificationLocalService.updateCustomNotification(
			customNotification);
	}

	@Override
	public CustomNotificationLocalService getWrappedService() {
		return _customNotificationLocalService;
	}

	@Override
	public void setWrappedService(
		CustomNotificationLocalService customNotificationLocalService) {

		_customNotificationLocalService = customNotificationLocalService;
	}

	private CustomNotificationLocalService _customNotificationLocalService;

}