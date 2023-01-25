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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.samples.fbo.custom.notification.model.CustomNotification;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for CustomNotification. This utility wraps
 * <code>com.liferay.samples.fbo.custom.notification.service.impl.CustomNotificationLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see CustomNotificationLocalService
 * @generated
 */
public class CustomNotificationLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.samples.fbo.custom.notification.service.impl.CustomNotificationLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static CustomNotification addCustomNotification(
		CustomNotification customNotification) {

		return getService().addCustomNotification(customNotification);
	}

	/**
	 * Creates a new custom notification with the primary key. Does not add the custom notification to the database.
	 *
	 * @param customNotificationId the primary key for the new custom notification
	 * @return the new custom notification
	 */
	public static CustomNotification createCustomNotification(
		long customNotificationId) {

		return getService().createCustomNotification(customNotificationId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
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
	public static CustomNotification deleteCustomNotification(
		CustomNotification customNotification) {

		return getService().deleteCustomNotification(customNotification);
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
	public static CustomNotification deleteCustomNotification(
			long customNotificationId)
		throws PortalException {

		return getService().deleteCustomNotification(customNotificationId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static CustomNotification fetchCustomNotification(
		long customNotificationId) {

		return getService().fetchCustomNotification(customNotificationId);
	}

	/**
	 * Returns the custom notification with the matching UUID and company.
	 *
	 * @param uuid the custom notification's UUID
	 * @param companyId the primary key of the company
	 * @return the matching custom notification, or <code>null</code> if a matching custom notification could not be found
	 */
	public static CustomNotification fetchCustomNotificationByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().fetchCustomNotificationByUuidAndCompanyId(
			uuid, companyId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the custom notification with the primary key.
	 *
	 * @param customNotificationId the primary key of the custom notification
	 * @return the custom notification
	 * @throws PortalException if a custom notification with the primary key could not be found
	 */
	public static CustomNotification getCustomNotification(
			long customNotificationId)
		throws PortalException {

		return getService().getCustomNotification(customNotificationId);
	}

	public static List<CustomNotification>
		getCustomNotificationByCompanyAndUser(
			long companyId, long userId, int start, int end) {

		return getService().getCustomNotificationByCompanyAndUser(
			companyId, userId, start, end);
	}

	public static List<CustomNotification>
		getCustomNotificationByCompanyAndUserAndNotificationType(
			long companyId, long userId, String notificationType, int start,
			int end) {

		return getService().
			getCustomNotificationByCompanyAndUserAndNotificationType(
				companyId, userId, notificationType, start, end);
	}

	public static CustomNotification
			getCustomNotificationByCompanyAndUserNotificationEvent(
				long companyId, long userNotificationEventId)
		throws com.liferay.samples.fbo.custom.notification.exception.
			NoSuchCustomNotificationException {

		return getService().
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
	public static CustomNotification getCustomNotificationByUuidAndCompanyId(
			String uuid, long companyId)
		throws PortalException {

		return getService().getCustomNotificationByUuidAndCompanyId(
			uuid, companyId);
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
	public static List<CustomNotification> getCustomNotifications(
		int start, int end) {

		return getService().getCustomNotifications(start, end);
	}

	/**
	 * Returns the number of custom notifications.
	 *
	 * @return the number of custom notifications
	 */
	public static int getCustomNotificationsCount() {
		return getService().getCustomNotificationsCount();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
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
	public static CustomNotification updateCustomNotification(
		CustomNotification customNotification) {

		return getService().updateCustomNotification(customNotification);
	}

	public static CustomNotificationLocalService getService() {
		return _service;
	}

	private static volatile CustomNotificationLocalService _service;

}