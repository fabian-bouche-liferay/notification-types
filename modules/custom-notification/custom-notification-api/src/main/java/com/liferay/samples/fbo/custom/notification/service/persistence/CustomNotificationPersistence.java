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

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.samples.fbo.custom.notification.exception.NoSuchCustomNotificationException;
import com.liferay.samples.fbo.custom.notification.model.CustomNotification;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the custom notification service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CustomNotificationUtil
 * @generated
 */
@ProviderType
public interface CustomNotificationPersistence
	extends BasePersistence<CustomNotification> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CustomNotificationUtil} to access the custom notification persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the custom notifications where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching custom notifications
	 */
	public java.util.List<CustomNotification> findByUuid(String uuid);

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
	public java.util.List<CustomNotification> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<CustomNotification> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CustomNotification>
			orderByComparator);

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
	public java.util.List<CustomNotification> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CustomNotification>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first custom notification in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching custom notification
	 * @throws NoSuchCustomNotificationException if a matching custom notification could not be found
	 */
	public CustomNotification findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CustomNotification>
				orderByComparator)
		throws NoSuchCustomNotificationException;

	/**
	 * Returns the first custom notification in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching custom notification, or <code>null</code> if a matching custom notification could not be found
	 */
	public CustomNotification fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CustomNotification>
			orderByComparator);

	/**
	 * Returns the last custom notification in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching custom notification
	 * @throws NoSuchCustomNotificationException if a matching custom notification could not be found
	 */
	public CustomNotification findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CustomNotification>
				orderByComparator)
		throws NoSuchCustomNotificationException;

	/**
	 * Returns the last custom notification in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching custom notification, or <code>null</code> if a matching custom notification could not be found
	 */
	public CustomNotification fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CustomNotification>
			orderByComparator);

	/**
	 * Returns the custom notifications before and after the current custom notification in the ordered set where uuid = &#63;.
	 *
	 * @param customNotificationId the primary key of the current custom notification
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next custom notification
	 * @throws NoSuchCustomNotificationException if a custom notification with the primary key could not be found
	 */
	public CustomNotification[] findByUuid_PrevAndNext(
			long customNotificationId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CustomNotification>
				orderByComparator)
		throws NoSuchCustomNotificationException;

	/**
	 * Removes all the custom notifications where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of custom notifications where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching custom notifications
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the custom notifications where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching custom notifications
	 */
	public java.util.List<CustomNotification> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<CustomNotification> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<CustomNotification> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CustomNotification>
			orderByComparator);

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
	public java.util.List<CustomNotification> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CustomNotification>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first custom notification in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching custom notification
	 * @throws NoSuchCustomNotificationException if a matching custom notification could not be found
	 */
	public CustomNotification findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CustomNotification>
				orderByComparator)
		throws NoSuchCustomNotificationException;

	/**
	 * Returns the first custom notification in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching custom notification, or <code>null</code> if a matching custom notification could not be found
	 */
	public CustomNotification fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CustomNotification>
			orderByComparator);

	/**
	 * Returns the last custom notification in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching custom notification
	 * @throws NoSuchCustomNotificationException if a matching custom notification could not be found
	 */
	public CustomNotification findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CustomNotification>
				orderByComparator)
		throws NoSuchCustomNotificationException;

	/**
	 * Returns the last custom notification in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching custom notification, or <code>null</code> if a matching custom notification could not be found
	 */
	public CustomNotification fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CustomNotification>
			orderByComparator);

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
	public CustomNotification[] findByUuid_C_PrevAndNext(
			long customNotificationId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CustomNotification>
				orderByComparator)
		throws NoSuchCustomNotificationException;

	/**
	 * Removes all the custom notifications where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of custom notifications where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching custom notifications
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the custom notifications where companyId = &#63; and userId = &#63; and notificationType = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param notificationType the notification type
	 * @return the matching custom notifications
	 */
	public java.util.List<CustomNotification>
		findByCompanyUserAndNotificationType(
			long companyId, long userId, String notificationType);

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
	public java.util.List<CustomNotification>
		findByCompanyUserAndNotificationType(
			long companyId, long userId, String notificationType, int start,
			int end);

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
	public java.util.List<CustomNotification>
		findByCompanyUserAndNotificationType(
			long companyId, long userId, String notificationType, int start,
			int end,
			com.liferay.portal.kernel.util.OrderByComparator<CustomNotification>
				orderByComparator);

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
	public java.util.List<CustomNotification>
		findByCompanyUserAndNotificationType(
			long companyId, long userId, String notificationType, int start,
			int end,
			com.liferay.portal.kernel.util.OrderByComparator<CustomNotification>
				orderByComparator,
			boolean useFinderCache);

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
	public CustomNotification findByCompanyUserAndNotificationType_First(
			long companyId, long userId, String notificationType,
			com.liferay.portal.kernel.util.OrderByComparator<CustomNotification>
				orderByComparator)
		throws NoSuchCustomNotificationException;

	/**
	 * Returns the first custom notification in the ordered set where companyId = &#63; and userId = &#63; and notificationType = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param notificationType the notification type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching custom notification, or <code>null</code> if a matching custom notification could not be found
	 */
	public CustomNotification fetchByCompanyUserAndNotificationType_First(
		long companyId, long userId, String notificationType,
		com.liferay.portal.kernel.util.OrderByComparator<CustomNotification>
			orderByComparator);

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
	public CustomNotification findByCompanyUserAndNotificationType_Last(
			long companyId, long userId, String notificationType,
			com.liferay.portal.kernel.util.OrderByComparator<CustomNotification>
				orderByComparator)
		throws NoSuchCustomNotificationException;

	/**
	 * Returns the last custom notification in the ordered set where companyId = &#63; and userId = &#63; and notificationType = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param notificationType the notification type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching custom notification, or <code>null</code> if a matching custom notification could not be found
	 */
	public CustomNotification fetchByCompanyUserAndNotificationType_Last(
		long companyId, long userId, String notificationType,
		com.liferay.portal.kernel.util.OrderByComparator<CustomNotification>
			orderByComparator);

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
	public CustomNotification[]
			findByCompanyUserAndNotificationType_PrevAndNext(
				long customNotificationId, long companyId, long userId,
				String notificationType,
				com.liferay.portal.kernel.util.OrderByComparator
					<CustomNotification> orderByComparator)
		throws NoSuchCustomNotificationException;

	/**
	 * Removes all the custom notifications where companyId = &#63; and userId = &#63; and notificationType = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param notificationType the notification type
	 */
	public void removeByCompanyUserAndNotificationType(
		long companyId, long userId, String notificationType);

	/**
	 * Returns the number of custom notifications where companyId = &#63; and userId = &#63; and notificationType = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param notificationType the notification type
	 * @return the number of matching custom notifications
	 */
	public int countByCompanyUserAndNotificationType(
		long companyId, long userId, String notificationType);

	/**
	 * Returns all the custom notifications where companyId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @return the matching custom notifications
	 */
	public java.util.List<CustomNotification> findByCompanyAndUser(
		long companyId, long userId);

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
	public java.util.List<CustomNotification> findByCompanyAndUser(
		long companyId, long userId, int start, int end);

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
	public java.util.List<CustomNotification> findByCompanyAndUser(
		long companyId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CustomNotification>
			orderByComparator);

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
	public java.util.List<CustomNotification> findByCompanyAndUser(
		long companyId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CustomNotification>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first custom notification in the ordered set where companyId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching custom notification
	 * @throws NoSuchCustomNotificationException if a matching custom notification could not be found
	 */
	public CustomNotification findByCompanyAndUser_First(
			long companyId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<CustomNotification>
				orderByComparator)
		throws NoSuchCustomNotificationException;

	/**
	 * Returns the first custom notification in the ordered set where companyId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching custom notification, or <code>null</code> if a matching custom notification could not be found
	 */
	public CustomNotification fetchByCompanyAndUser_First(
		long companyId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<CustomNotification>
			orderByComparator);

	/**
	 * Returns the last custom notification in the ordered set where companyId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching custom notification
	 * @throws NoSuchCustomNotificationException if a matching custom notification could not be found
	 */
	public CustomNotification findByCompanyAndUser_Last(
			long companyId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<CustomNotification>
				orderByComparator)
		throws NoSuchCustomNotificationException;

	/**
	 * Returns the last custom notification in the ordered set where companyId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching custom notification, or <code>null</code> if a matching custom notification could not be found
	 */
	public CustomNotification fetchByCompanyAndUser_Last(
		long companyId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<CustomNotification>
			orderByComparator);

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
	public CustomNotification[] findByCompanyAndUser_PrevAndNext(
			long customNotificationId, long companyId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<CustomNotification>
				orderByComparator)
		throws NoSuchCustomNotificationException;

	/**
	 * Removes all the custom notifications where companyId = &#63; and userId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 */
	public void removeByCompanyAndUser(long companyId, long userId);

	/**
	 * Returns the number of custom notifications where companyId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @return the number of matching custom notifications
	 */
	public int countByCompanyAndUser(long companyId, long userId);

	/**
	 * Returns the custom notification where companyId = &#63; and userNotificationEventId = &#63; or throws a <code>NoSuchCustomNotificationException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param userNotificationEventId the user notification event ID
	 * @return the matching custom notification
	 * @throws NoSuchCustomNotificationException if a matching custom notification could not be found
	 */
	public CustomNotification findByCompanyAndUserNotificationEvent(
			long companyId, long userNotificationEventId)
		throws NoSuchCustomNotificationException;

	/**
	 * Returns the custom notification where companyId = &#63; and userNotificationEventId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param userNotificationEventId the user notification event ID
	 * @return the matching custom notification, or <code>null</code> if a matching custom notification could not be found
	 */
	public CustomNotification fetchByCompanyAndUserNotificationEvent(
		long companyId, long userNotificationEventId);

	/**
	 * Returns the custom notification where companyId = &#63; and userNotificationEventId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param userNotificationEventId the user notification event ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching custom notification, or <code>null</code> if a matching custom notification could not be found
	 */
	public CustomNotification fetchByCompanyAndUserNotificationEvent(
		long companyId, long userNotificationEventId, boolean useFinderCache);

	/**
	 * Removes the custom notification where companyId = &#63; and userNotificationEventId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param userNotificationEventId the user notification event ID
	 * @return the custom notification that was removed
	 */
	public CustomNotification removeByCompanyAndUserNotificationEvent(
			long companyId, long userNotificationEventId)
		throws NoSuchCustomNotificationException;

	/**
	 * Returns the number of custom notifications where companyId = &#63; and userNotificationEventId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userNotificationEventId the user notification event ID
	 * @return the number of matching custom notifications
	 */
	public int countByCompanyAndUserNotificationEvent(
		long companyId, long userNotificationEventId);

	/**
	 * Caches the custom notification in the entity cache if it is enabled.
	 *
	 * @param customNotification the custom notification
	 */
	public void cacheResult(CustomNotification customNotification);

	/**
	 * Caches the custom notifications in the entity cache if it is enabled.
	 *
	 * @param customNotifications the custom notifications
	 */
	public void cacheResult(
		java.util.List<CustomNotification> customNotifications);

	/**
	 * Creates a new custom notification with the primary key. Does not add the custom notification to the database.
	 *
	 * @param customNotificationId the primary key for the new custom notification
	 * @return the new custom notification
	 */
	public CustomNotification create(long customNotificationId);

	/**
	 * Removes the custom notification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param customNotificationId the primary key of the custom notification
	 * @return the custom notification that was removed
	 * @throws NoSuchCustomNotificationException if a custom notification with the primary key could not be found
	 */
	public CustomNotification remove(long customNotificationId)
		throws NoSuchCustomNotificationException;

	public CustomNotification updateImpl(CustomNotification customNotification);

	/**
	 * Returns the custom notification with the primary key or throws a <code>NoSuchCustomNotificationException</code> if it could not be found.
	 *
	 * @param customNotificationId the primary key of the custom notification
	 * @return the custom notification
	 * @throws NoSuchCustomNotificationException if a custom notification with the primary key could not be found
	 */
	public CustomNotification findByPrimaryKey(long customNotificationId)
		throws NoSuchCustomNotificationException;

	/**
	 * Returns the custom notification with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param customNotificationId the primary key of the custom notification
	 * @return the custom notification, or <code>null</code> if a custom notification with the primary key could not be found
	 */
	public CustomNotification fetchByPrimaryKey(long customNotificationId);

	/**
	 * Returns all the custom notifications.
	 *
	 * @return the custom notifications
	 */
	public java.util.List<CustomNotification> findAll();

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
	public java.util.List<CustomNotification> findAll(int start, int end);

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
	public java.util.List<CustomNotification> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CustomNotification>
			orderByComparator);

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
	public java.util.List<CustomNotification> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CustomNotification>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the custom notifications from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of custom notifications.
	 *
	 * @return the number of custom notifications
	 */
	public int countAll();

}