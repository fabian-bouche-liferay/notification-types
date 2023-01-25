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

package com.liferay.samples.fbo.custom.notification.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.samples.fbo.custom.notification.model.CustomNotification;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the custom notification service. This utility wraps <code>com.liferay.samples.fbo.custom.notification.service.persistence.impl.CustomNotificationPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CustomNotificationPersistence
 * @generated
 */
public class CustomNotificationUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(CustomNotification customNotification) {
		getPersistence().clearCache(customNotification);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, CustomNotification> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CustomNotification> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CustomNotification> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CustomNotification> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CustomNotification> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CustomNotification update(
		CustomNotification customNotification) {

		return getPersistence().update(customNotification);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CustomNotification update(
		CustomNotification customNotification, ServiceContext serviceContext) {

		return getPersistence().update(customNotification, serviceContext);
	}

	/**
	 * Returns all the custom notifications where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching custom notifications
	 */
	public static List<CustomNotification> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the custom notifications where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomNotificationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of custom notifications
	 * @param end the upper bound of the range of custom notifications (not inclusive)
	 * @return the range of matching custom notifications
	 */
	public static List<CustomNotification> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the custom notifications where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomNotificationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of custom notifications
	 * @param end the upper bound of the range of custom notifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching custom notifications
	 */
	public static List<CustomNotification> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CustomNotification> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the custom notifications where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomNotificationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of custom notifications
	 * @param end the upper bound of the range of custom notifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching custom notifications
	 */
	public static List<CustomNotification> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CustomNotification> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first custom notification in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching custom notification
	 * @throws NoSuchCustomNotificationException if a matching custom notification could not be found
	 */
	public static CustomNotification findByUuid_First(
			String uuid,
			OrderByComparator<CustomNotification> orderByComparator)
		throws com.liferay.samples.fbo.custom.notification.exception.
			NoSuchCustomNotificationException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first custom notification in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching custom notification, or <code>null</code> if a matching custom notification could not be found
	 */
	public static CustomNotification fetchByUuid_First(
		String uuid, OrderByComparator<CustomNotification> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last custom notification in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching custom notification
	 * @throws NoSuchCustomNotificationException if a matching custom notification could not be found
	 */
	public static CustomNotification findByUuid_Last(
			String uuid,
			OrderByComparator<CustomNotification> orderByComparator)
		throws com.liferay.samples.fbo.custom.notification.exception.
			NoSuchCustomNotificationException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last custom notification in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching custom notification, or <code>null</code> if a matching custom notification could not be found
	 */
	public static CustomNotification fetchByUuid_Last(
		String uuid, OrderByComparator<CustomNotification> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the custom notifications before and after the current custom notification in the ordered set where uuid = &#63;.
	 *
	 * @param customNotificationId the primary key of the current custom notification
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next custom notification
	 * @throws NoSuchCustomNotificationException if a custom notification with the primary key could not be found
	 */
	public static CustomNotification[] findByUuid_PrevAndNext(
			long customNotificationId, String uuid,
			OrderByComparator<CustomNotification> orderByComparator)
		throws com.liferay.samples.fbo.custom.notification.exception.
			NoSuchCustomNotificationException {

		return getPersistence().findByUuid_PrevAndNext(
			customNotificationId, uuid, orderByComparator);
	}

	/**
	 * Removes all the custom notifications where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of custom notifications where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching custom notifications
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the custom notifications where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching custom notifications
	 */
	public static List<CustomNotification> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the custom notifications where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomNotificationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of custom notifications
	 * @param end the upper bound of the range of custom notifications (not inclusive)
	 * @return the range of matching custom notifications
	 */
	public static List<CustomNotification> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the custom notifications where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomNotificationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of custom notifications
	 * @param end the upper bound of the range of custom notifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching custom notifications
	 */
	public static List<CustomNotification> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CustomNotification> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the custom notifications where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomNotificationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of custom notifications
	 * @param end the upper bound of the range of custom notifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching custom notifications
	 */
	public static List<CustomNotification> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CustomNotification> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first custom notification in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching custom notification
	 * @throws NoSuchCustomNotificationException if a matching custom notification could not be found
	 */
	public static CustomNotification findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<CustomNotification> orderByComparator)
		throws com.liferay.samples.fbo.custom.notification.exception.
			NoSuchCustomNotificationException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first custom notification in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching custom notification, or <code>null</code> if a matching custom notification could not be found
	 */
	public static CustomNotification fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<CustomNotification> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last custom notification in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching custom notification
	 * @throws NoSuchCustomNotificationException if a matching custom notification could not be found
	 */
	public static CustomNotification findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<CustomNotification> orderByComparator)
		throws com.liferay.samples.fbo.custom.notification.exception.
			NoSuchCustomNotificationException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last custom notification in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching custom notification, or <code>null</code> if a matching custom notification could not be found
	 */
	public static CustomNotification fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<CustomNotification> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the custom notifications before and after the current custom notification in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param customNotificationId the primary key of the current custom notification
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next custom notification
	 * @throws NoSuchCustomNotificationException if a custom notification with the primary key could not be found
	 */
	public static CustomNotification[] findByUuid_C_PrevAndNext(
			long customNotificationId, String uuid, long companyId,
			OrderByComparator<CustomNotification> orderByComparator)
		throws com.liferay.samples.fbo.custom.notification.exception.
			NoSuchCustomNotificationException {

		return getPersistence().findByUuid_C_PrevAndNext(
			customNotificationId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the custom notifications where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of custom notifications where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching custom notifications
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the custom notifications where companyId = &#63; and userId = &#63; and notificationType = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param notificationType the notification type
	 * @return the matching custom notifications
	 */
	public static List<CustomNotification> findByCompanyUserAndNotificationType(
		long companyId, long userId, String notificationType) {

		return getPersistence().findByCompanyUserAndNotificationType(
			companyId, userId, notificationType);
	}

	/**
	 * Returns a range of all the custom notifications where companyId = &#63; and userId = &#63; and notificationType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomNotificationModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param notificationType the notification type
	 * @param start the lower bound of the range of custom notifications
	 * @param end the upper bound of the range of custom notifications (not inclusive)
	 * @return the range of matching custom notifications
	 */
	public static List<CustomNotification> findByCompanyUserAndNotificationType(
		long companyId, long userId, String notificationType, int start,
		int end) {

		return getPersistence().findByCompanyUserAndNotificationType(
			companyId, userId, notificationType, start, end);
	}

	/**
	 * Returns an ordered range of all the custom notifications where companyId = &#63; and userId = &#63; and notificationType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomNotificationModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param notificationType the notification type
	 * @param start the lower bound of the range of custom notifications
	 * @param end the upper bound of the range of custom notifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching custom notifications
	 */
	public static List<CustomNotification> findByCompanyUserAndNotificationType(
		long companyId, long userId, String notificationType, int start,
		int end, OrderByComparator<CustomNotification> orderByComparator) {

		return getPersistence().findByCompanyUserAndNotificationType(
			companyId, userId, notificationType, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the custom notifications where companyId = &#63; and userId = &#63; and notificationType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomNotificationModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param notificationType the notification type
	 * @param start the lower bound of the range of custom notifications
	 * @param end the upper bound of the range of custom notifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching custom notifications
	 */
	public static List<CustomNotification> findByCompanyUserAndNotificationType(
		long companyId, long userId, String notificationType, int start,
		int end, OrderByComparator<CustomNotification> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCompanyUserAndNotificationType(
			companyId, userId, notificationType, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first custom notification in the ordered set where companyId = &#63; and userId = &#63; and notificationType = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param notificationType the notification type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching custom notification
	 * @throws NoSuchCustomNotificationException if a matching custom notification could not be found
	 */
	public static CustomNotification findByCompanyUserAndNotificationType_First(
			long companyId, long userId, String notificationType,
			OrderByComparator<CustomNotification> orderByComparator)
		throws com.liferay.samples.fbo.custom.notification.exception.
			NoSuchCustomNotificationException {

		return getPersistence().findByCompanyUserAndNotificationType_First(
			companyId, userId, notificationType, orderByComparator);
	}

	/**
	 * Returns the first custom notification in the ordered set where companyId = &#63; and userId = &#63; and notificationType = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param notificationType the notification type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching custom notification, or <code>null</code> if a matching custom notification could not be found
	 */
	public static CustomNotification
		fetchByCompanyUserAndNotificationType_First(
			long companyId, long userId, String notificationType,
			OrderByComparator<CustomNotification> orderByComparator) {

		return getPersistence().fetchByCompanyUserAndNotificationType_First(
			companyId, userId, notificationType, orderByComparator);
	}

	/**
	 * Returns the last custom notification in the ordered set where companyId = &#63; and userId = &#63; and notificationType = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param notificationType the notification type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching custom notification
	 * @throws NoSuchCustomNotificationException if a matching custom notification could not be found
	 */
	public static CustomNotification findByCompanyUserAndNotificationType_Last(
			long companyId, long userId, String notificationType,
			OrderByComparator<CustomNotification> orderByComparator)
		throws com.liferay.samples.fbo.custom.notification.exception.
			NoSuchCustomNotificationException {

		return getPersistence().findByCompanyUserAndNotificationType_Last(
			companyId, userId, notificationType, orderByComparator);
	}

	/**
	 * Returns the last custom notification in the ordered set where companyId = &#63; and userId = &#63; and notificationType = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param notificationType the notification type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching custom notification, or <code>null</code> if a matching custom notification could not be found
	 */
	public static CustomNotification fetchByCompanyUserAndNotificationType_Last(
		long companyId, long userId, String notificationType,
		OrderByComparator<CustomNotification> orderByComparator) {

		return getPersistence().fetchByCompanyUserAndNotificationType_Last(
			companyId, userId, notificationType, orderByComparator);
	}

	/**
	 * Returns the custom notifications before and after the current custom notification in the ordered set where companyId = &#63; and userId = &#63; and notificationType = &#63;.
	 *
	 * @param customNotificationId the primary key of the current custom notification
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param notificationType the notification type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next custom notification
	 * @throws NoSuchCustomNotificationException if a custom notification with the primary key could not be found
	 */
	public static CustomNotification[]
			findByCompanyUserAndNotificationType_PrevAndNext(
				long customNotificationId, long companyId, long userId,
				String notificationType,
				OrderByComparator<CustomNotification> orderByComparator)
		throws com.liferay.samples.fbo.custom.notification.exception.
			NoSuchCustomNotificationException {

		return getPersistence().
			findByCompanyUserAndNotificationType_PrevAndNext(
				customNotificationId, companyId, userId, notificationType,
				orderByComparator);
	}

	/**
	 * Removes all the custom notifications where companyId = &#63; and userId = &#63; and notificationType = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param notificationType the notification type
	 */
	public static void removeByCompanyUserAndNotificationType(
		long companyId, long userId, String notificationType) {

		getPersistence().removeByCompanyUserAndNotificationType(
			companyId, userId, notificationType);
	}

	/**
	 * Returns the number of custom notifications where companyId = &#63; and userId = &#63; and notificationType = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param notificationType the notification type
	 * @return the number of matching custom notifications
	 */
	public static int countByCompanyUserAndNotificationType(
		long companyId, long userId, String notificationType) {

		return getPersistence().countByCompanyUserAndNotificationType(
			companyId, userId, notificationType);
	}

	/**
	 * Returns all the custom notifications where companyId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @return the matching custom notifications
	 */
	public static List<CustomNotification> findByCompanyAndUser(
		long companyId, long userId) {

		return getPersistence().findByCompanyAndUser(companyId, userId);
	}

	/**
	 * Returns a range of all the custom notifications where companyId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomNotificationModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of custom notifications
	 * @param end the upper bound of the range of custom notifications (not inclusive)
	 * @return the range of matching custom notifications
	 */
	public static List<CustomNotification> findByCompanyAndUser(
		long companyId, long userId, int start, int end) {

		return getPersistence().findByCompanyAndUser(
			companyId, userId, start, end);
	}

	/**
	 * Returns an ordered range of all the custom notifications where companyId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomNotificationModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of custom notifications
	 * @param end the upper bound of the range of custom notifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching custom notifications
	 */
	public static List<CustomNotification> findByCompanyAndUser(
		long companyId, long userId, int start, int end,
		OrderByComparator<CustomNotification> orderByComparator) {

		return getPersistence().findByCompanyAndUser(
			companyId, userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the custom notifications where companyId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomNotificationModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of custom notifications
	 * @param end the upper bound of the range of custom notifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching custom notifications
	 */
	public static List<CustomNotification> findByCompanyAndUser(
		long companyId, long userId, int start, int end,
		OrderByComparator<CustomNotification> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCompanyAndUser(
			companyId, userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first custom notification in the ordered set where companyId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching custom notification
	 * @throws NoSuchCustomNotificationException if a matching custom notification could not be found
	 */
	public static CustomNotification findByCompanyAndUser_First(
			long companyId, long userId,
			OrderByComparator<CustomNotification> orderByComparator)
		throws com.liferay.samples.fbo.custom.notification.exception.
			NoSuchCustomNotificationException {

		return getPersistence().findByCompanyAndUser_First(
			companyId, userId, orderByComparator);
	}

	/**
	 * Returns the first custom notification in the ordered set where companyId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching custom notification, or <code>null</code> if a matching custom notification could not be found
	 */
	public static CustomNotification fetchByCompanyAndUser_First(
		long companyId, long userId,
		OrderByComparator<CustomNotification> orderByComparator) {

		return getPersistence().fetchByCompanyAndUser_First(
			companyId, userId, orderByComparator);
	}

	/**
	 * Returns the last custom notification in the ordered set where companyId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching custom notification
	 * @throws NoSuchCustomNotificationException if a matching custom notification could not be found
	 */
	public static CustomNotification findByCompanyAndUser_Last(
			long companyId, long userId,
			OrderByComparator<CustomNotification> orderByComparator)
		throws com.liferay.samples.fbo.custom.notification.exception.
			NoSuchCustomNotificationException {

		return getPersistence().findByCompanyAndUser_Last(
			companyId, userId, orderByComparator);
	}

	/**
	 * Returns the last custom notification in the ordered set where companyId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching custom notification, or <code>null</code> if a matching custom notification could not be found
	 */
	public static CustomNotification fetchByCompanyAndUser_Last(
		long companyId, long userId,
		OrderByComparator<CustomNotification> orderByComparator) {

		return getPersistence().fetchByCompanyAndUser_Last(
			companyId, userId, orderByComparator);
	}

	/**
	 * Returns the custom notifications before and after the current custom notification in the ordered set where companyId = &#63; and userId = &#63;.
	 *
	 * @param customNotificationId the primary key of the current custom notification
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next custom notification
	 * @throws NoSuchCustomNotificationException if a custom notification with the primary key could not be found
	 */
	public static CustomNotification[] findByCompanyAndUser_PrevAndNext(
			long customNotificationId, long companyId, long userId,
			OrderByComparator<CustomNotification> orderByComparator)
		throws com.liferay.samples.fbo.custom.notification.exception.
			NoSuchCustomNotificationException {

		return getPersistence().findByCompanyAndUser_PrevAndNext(
			customNotificationId, companyId, userId, orderByComparator);
	}

	/**
	 * Removes all the custom notifications where companyId = &#63; and userId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 */
	public static void removeByCompanyAndUser(long companyId, long userId) {
		getPersistence().removeByCompanyAndUser(companyId, userId);
	}

	/**
	 * Returns the number of custom notifications where companyId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @return the number of matching custom notifications
	 */
	public static int countByCompanyAndUser(long companyId, long userId) {
		return getPersistence().countByCompanyAndUser(companyId, userId);
	}

	/**
	 * Returns the custom notification where companyId = &#63; and userNotificationEventId = &#63; or throws a <code>NoSuchCustomNotificationException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param userNotificationEventId the user notification event ID
	 * @return the matching custom notification
	 * @throws NoSuchCustomNotificationException if a matching custom notification could not be found
	 */
	public static CustomNotification findByCompanyAndUserNotificationEvent(
			long companyId, long userNotificationEventId)
		throws com.liferay.samples.fbo.custom.notification.exception.
			NoSuchCustomNotificationException {

		return getPersistence().findByCompanyAndUserNotificationEvent(
			companyId, userNotificationEventId);
	}

	/**
	 * Returns the custom notification where companyId = &#63; and userNotificationEventId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param userNotificationEventId the user notification event ID
	 * @return the matching custom notification, or <code>null</code> if a matching custom notification could not be found
	 */
	public static CustomNotification fetchByCompanyAndUserNotificationEvent(
		long companyId, long userNotificationEventId) {

		return getPersistence().fetchByCompanyAndUserNotificationEvent(
			companyId, userNotificationEventId);
	}

	/**
	 * Returns the custom notification where companyId = &#63; and userNotificationEventId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param userNotificationEventId the user notification event ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching custom notification, or <code>null</code> if a matching custom notification could not be found
	 */
	public static CustomNotification fetchByCompanyAndUserNotificationEvent(
		long companyId, long userNotificationEventId, boolean useFinderCache) {

		return getPersistence().fetchByCompanyAndUserNotificationEvent(
			companyId, userNotificationEventId, useFinderCache);
	}

	/**
	 * Removes the custom notification where companyId = &#63; and userNotificationEventId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param userNotificationEventId the user notification event ID
	 * @return the custom notification that was removed
	 */
	public static CustomNotification removeByCompanyAndUserNotificationEvent(
			long companyId, long userNotificationEventId)
		throws com.liferay.samples.fbo.custom.notification.exception.
			NoSuchCustomNotificationException {

		return getPersistence().removeByCompanyAndUserNotificationEvent(
			companyId, userNotificationEventId);
	}

	/**
	 * Returns the number of custom notifications where companyId = &#63; and userNotificationEventId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userNotificationEventId the user notification event ID
	 * @return the number of matching custom notifications
	 */
	public static int countByCompanyAndUserNotificationEvent(
		long companyId, long userNotificationEventId) {

		return getPersistence().countByCompanyAndUserNotificationEvent(
			companyId, userNotificationEventId);
	}

	/**
	 * Caches the custom notification in the entity cache if it is enabled.
	 *
	 * @param customNotification the custom notification
	 */
	public static void cacheResult(CustomNotification customNotification) {
		getPersistence().cacheResult(customNotification);
	}

	/**
	 * Caches the custom notifications in the entity cache if it is enabled.
	 *
	 * @param customNotifications the custom notifications
	 */
	public static void cacheResult(
		List<CustomNotification> customNotifications) {

		getPersistence().cacheResult(customNotifications);
	}

	/**
	 * Creates a new custom notification with the primary key. Does not add the custom notification to the database.
	 *
	 * @param customNotificationId the primary key for the new custom notification
	 * @return the new custom notification
	 */
	public static CustomNotification create(long customNotificationId) {
		return getPersistence().create(customNotificationId);
	}

	/**
	 * Removes the custom notification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param customNotificationId the primary key of the custom notification
	 * @return the custom notification that was removed
	 * @throws NoSuchCustomNotificationException if a custom notification with the primary key could not be found
	 */
	public static CustomNotification remove(long customNotificationId)
		throws com.liferay.samples.fbo.custom.notification.exception.
			NoSuchCustomNotificationException {

		return getPersistence().remove(customNotificationId);
	}

	public static CustomNotification updateImpl(
		CustomNotification customNotification) {

		return getPersistence().updateImpl(customNotification);
	}

	/**
	 * Returns the custom notification with the primary key or throws a <code>NoSuchCustomNotificationException</code> if it could not be found.
	 *
	 * @param customNotificationId the primary key of the custom notification
	 * @return the custom notification
	 * @throws NoSuchCustomNotificationException if a custom notification with the primary key could not be found
	 */
	public static CustomNotification findByPrimaryKey(long customNotificationId)
		throws com.liferay.samples.fbo.custom.notification.exception.
			NoSuchCustomNotificationException {

		return getPersistence().findByPrimaryKey(customNotificationId);
	}

	/**
	 * Returns the custom notification with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param customNotificationId the primary key of the custom notification
	 * @return the custom notification, or <code>null</code> if a custom notification with the primary key could not be found
	 */
	public static CustomNotification fetchByPrimaryKey(
		long customNotificationId) {

		return getPersistence().fetchByPrimaryKey(customNotificationId);
	}

	/**
	 * Returns all the custom notifications.
	 *
	 * @return the custom notifications
	 */
	public static List<CustomNotification> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the custom notifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomNotificationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of custom notifications
	 * @param end the upper bound of the range of custom notifications (not inclusive)
	 * @return the range of custom notifications
	 */
	public static List<CustomNotification> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the custom notifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomNotificationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of custom notifications
	 * @param end the upper bound of the range of custom notifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of custom notifications
	 */
	public static List<CustomNotification> findAll(
		int start, int end,
		OrderByComparator<CustomNotification> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the custom notifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomNotificationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of custom notifications
	 * @param end the upper bound of the range of custom notifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of custom notifications
	 */
	public static List<CustomNotification> findAll(
		int start, int end,
		OrderByComparator<CustomNotification> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the custom notifications from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of custom notifications.
	 *
	 * @return the number of custom notifications
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CustomNotificationPersistence getPersistence() {
		return _persistence;
	}

	private static volatile CustomNotificationPersistence _persistence;

}