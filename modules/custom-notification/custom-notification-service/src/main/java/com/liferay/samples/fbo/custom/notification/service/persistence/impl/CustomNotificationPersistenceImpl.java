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

package com.liferay.samples.fbo.custom.notification.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.samples.fbo.custom.notification.exception.NoSuchCustomNotificationException;
import com.liferay.samples.fbo.custom.notification.model.CustomNotification;
import com.liferay.samples.fbo.custom.notification.model.impl.CustomNotificationImpl;
import com.liferay.samples.fbo.custom.notification.model.impl.CustomNotificationModelImpl;
import com.liferay.samples.fbo.custom.notification.service.persistence.CustomNotificationPersistence;
import com.liferay.samples.fbo.custom.notification.service.persistence.CustomNotificationUtil;
import com.liferay.samples.fbo.custom.notification.service.persistence.impl.constants.FBOPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the custom notification service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = CustomNotificationPersistence.class)
public class CustomNotificationPersistenceImpl
	extends BasePersistenceImpl<CustomNotification>
	implements CustomNotificationPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CustomNotificationUtil</code> to access the custom notification persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CustomNotificationImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the custom notifications where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching custom notifications
	 */
	@Override
	public List<CustomNotification> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CustomNotification> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<CustomNotification> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CustomNotification> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<CustomNotification> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CustomNotification> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<CustomNotification> list = null;

		if (useFinderCache) {
			list = (List<CustomNotification>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CustomNotification customNotification : list) {
					if (!uuid.equals(customNotification.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_CUSTOMNOTIFICATION_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CustomNotificationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<CustomNotification>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first custom notification in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching custom notification
	 * @throws NoSuchCustomNotificationException if a matching custom notification could not be found
	 */
	@Override
	public CustomNotification findByUuid_First(
			String uuid,
			OrderByComparator<CustomNotification> orderByComparator)
		throws NoSuchCustomNotificationException {

		CustomNotification customNotification = fetchByUuid_First(
			uuid, orderByComparator);

		if (customNotification != null) {
			return customNotification;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCustomNotificationException(sb.toString());
	}

	/**
	 * Returns the first custom notification in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching custom notification, or <code>null</code> if a matching custom notification could not be found
	 */
	@Override
	public CustomNotification fetchByUuid_First(
		String uuid, OrderByComparator<CustomNotification> orderByComparator) {

		List<CustomNotification> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last custom notification in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching custom notification
	 * @throws NoSuchCustomNotificationException if a matching custom notification could not be found
	 */
	@Override
	public CustomNotification findByUuid_Last(
			String uuid,
			OrderByComparator<CustomNotification> orderByComparator)
		throws NoSuchCustomNotificationException {

		CustomNotification customNotification = fetchByUuid_Last(
			uuid, orderByComparator);

		if (customNotification != null) {
			return customNotification;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCustomNotificationException(sb.toString());
	}

	/**
	 * Returns the last custom notification in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching custom notification, or <code>null</code> if a matching custom notification could not be found
	 */
	@Override
	public CustomNotification fetchByUuid_Last(
		String uuid, OrderByComparator<CustomNotification> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<CustomNotification> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CustomNotification[] findByUuid_PrevAndNext(
			long customNotificationId, String uuid,
			OrderByComparator<CustomNotification> orderByComparator)
		throws NoSuchCustomNotificationException {

		uuid = Objects.toString(uuid, "");

		CustomNotification customNotification = findByPrimaryKey(
			customNotificationId);

		Session session = null;

		try {
			session = openSession();

			CustomNotification[] array = new CustomNotificationImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, customNotification, uuid, orderByComparator, true);

			array[1] = customNotification;

			array[2] = getByUuid_PrevAndNext(
				session, customNotification, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CustomNotification getByUuid_PrevAndNext(
		Session session, CustomNotification customNotification, String uuid,
		OrderByComparator<CustomNotification> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CUSTOMNOTIFICATION_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(CustomNotificationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						customNotification)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CustomNotification> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the custom notifications where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (CustomNotification customNotification :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(customNotification);
		}
	}

	/**
	 * Returns the number of custom notifications where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching custom notifications
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CUSTOMNOTIFICATION_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"customNotification.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(customNotification.uuid IS NULL OR customNotification.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the custom notifications where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching custom notifications
	 */
	@Override
	public List<CustomNotification> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CustomNotification> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<CustomNotification> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CustomNotification> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<CustomNotification> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CustomNotification> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<CustomNotification> list = null;

		if (useFinderCache) {
			list = (List<CustomNotification>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CustomNotification customNotification : list) {
					if (!uuid.equals(customNotification.getUuid()) ||
						(companyId != customNotification.getCompanyId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_CUSTOMNOTIFICATION_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CustomNotificationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				list = (List<CustomNotification>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public CustomNotification findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<CustomNotification> orderByComparator)
		throws NoSuchCustomNotificationException {

		CustomNotification customNotification = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (customNotification != null) {
			return customNotification;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchCustomNotificationException(sb.toString());
	}

	/**
	 * Returns the first custom notification in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching custom notification, or <code>null</code> if a matching custom notification could not be found
	 */
	@Override
	public CustomNotification fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<CustomNotification> orderByComparator) {

		List<CustomNotification> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CustomNotification findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<CustomNotification> orderByComparator)
		throws NoSuchCustomNotificationException {

		CustomNotification customNotification = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (customNotification != null) {
			return customNotification;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchCustomNotificationException(sb.toString());
	}

	/**
	 * Returns the last custom notification in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching custom notification, or <code>null</code> if a matching custom notification could not be found
	 */
	@Override
	public CustomNotification fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<CustomNotification> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<CustomNotification> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CustomNotification[] findByUuid_C_PrevAndNext(
			long customNotificationId, String uuid, long companyId,
			OrderByComparator<CustomNotification> orderByComparator)
		throws NoSuchCustomNotificationException {

		uuid = Objects.toString(uuid, "");

		CustomNotification customNotification = findByPrimaryKey(
			customNotificationId);

		Session session = null;

		try {
			session = openSession();

			CustomNotification[] array = new CustomNotificationImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, customNotification, uuid, companyId, orderByComparator,
				true);

			array[1] = customNotification;

			array[2] = getByUuid_C_PrevAndNext(
				session, customNotification, uuid, companyId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CustomNotification getByUuid_C_PrevAndNext(
		Session session, CustomNotification customNotification, String uuid,
		long companyId, OrderByComparator<CustomNotification> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_CUSTOMNOTIFICATION_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(CustomNotificationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						customNotification)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CustomNotification> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the custom notifications where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (CustomNotification customNotification :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(customNotification);
		}
	}

	/**
	 * Returns the number of custom notifications where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching custom notifications
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CUSTOMNOTIFICATION_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"customNotification.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(customNotification.uuid IS NULL OR customNotification.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"customNotification.companyId = ?";

	private FinderPath
		_finderPathWithPaginationFindByCompanyUserAndNotificationType;
	private FinderPath
		_finderPathWithoutPaginationFindByCompanyUserAndNotificationType;
	private FinderPath _finderPathCountByCompanyUserAndNotificationType;

	/**
	 * Returns all the custom notifications where companyId = &#63; and userId = &#63; and notificationType = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param notificationType the notification type
	 * @return the matching custom notifications
	 */
	@Override
	public List<CustomNotification> findByCompanyUserAndNotificationType(
		long companyId, long userId, String notificationType) {

		return findByCompanyUserAndNotificationType(
			companyId, userId, notificationType, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<CustomNotification> findByCompanyUserAndNotificationType(
		long companyId, long userId, String notificationType, int start,
		int end) {

		return findByCompanyUserAndNotificationType(
			companyId, userId, notificationType, start, end, null);
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
	@Override
	public List<CustomNotification> findByCompanyUserAndNotificationType(
		long companyId, long userId, String notificationType, int start,
		int end, OrderByComparator<CustomNotification> orderByComparator) {

		return findByCompanyUserAndNotificationType(
			companyId, userId, notificationType, start, end, orderByComparator,
			true);
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
	@Override
	public List<CustomNotification> findByCompanyUserAndNotificationType(
		long companyId, long userId, String notificationType, int start,
		int end, OrderByComparator<CustomNotification> orderByComparator,
		boolean useFinderCache) {

		notificationType = Objects.toString(notificationType, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByCompanyUserAndNotificationType;
				finderArgs = new Object[] {companyId, userId, notificationType};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByCompanyUserAndNotificationType;
			finderArgs = new Object[] {
				companyId, userId, notificationType, start, end,
				orderByComparator
			};
		}

		List<CustomNotification> list = null;

		if (useFinderCache) {
			list = (List<CustomNotification>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CustomNotification customNotification : list) {
					if ((companyId != customNotification.getCompanyId()) ||
						(userId != customNotification.getUserId()) ||
						!notificationType.equals(
							customNotification.getNotificationType())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(5);
			}

			sb.append(_SQL_SELECT_CUSTOMNOTIFICATION_WHERE);

			sb.append(
				_FINDER_COLUMN_COMPANYUSERANDNOTIFICATIONTYPE_COMPANYID_2);

			sb.append(_FINDER_COLUMN_COMPANYUSERANDNOTIFICATIONTYPE_USERID_2);

			boolean bindNotificationType = false;

			if (notificationType.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_COMPANYUSERANDNOTIFICATIONTYPE_NOTIFICATIONTYPE_3);
			}
			else {
				bindNotificationType = true;

				sb.append(
					_FINDER_COLUMN_COMPANYUSERANDNOTIFICATIONTYPE_NOTIFICATIONTYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CustomNotificationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				queryPos.add(userId);

				if (bindNotificationType) {
					queryPos.add(notificationType);
				}

				list = (List<CustomNotification>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public CustomNotification findByCompanyUserAndNotificationType_First(
			long companyId, long userId, String notificationType,
			OrderByComparator<CustomNotification> orderByComparator)
		throws NoSuchCustomNotificationException {

		CustomNotification customNotification =
			fetchByCompanyUserAndNotificationType_First(
				companyId, userId, notificationType, orderByComparator);

		if (customNotification != null) {
			return customNotification;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append(", userId=");
		sb.append(userId);

		sb.append(", notificationType=");
		sb.append(notificationType);

		sb.append("}");

		throw new NoSuchCustomNotificationException(sb.toString());
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
	@Override
	public CustomNotification fetchByCompanyUserAndNotificationType_First(
		long companyId, long userId, String notificationType,
		OrderByComparator<CustomNotification> orderByComparator) {

		List<CustomNotification> list = findByCompanyUserAndNotificationType(
			companyId, userId, notificationType, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CustomNotification findByCompanyUserAndNotificationType_Last(
			long companyId, long userId, String notificationType,
			OrderByComparator<CustomNotification> orderByComparator)
		throws NoSuchCustomNotificationException {

		CustomNotification customNotification =
			fetchByCompanyUserAndNotificationType_Last(
				companyId, userId, notificationType, orderByComparator);

		if (customNotification != null) {
			return customNotification;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append(", userId=");
		sb.append(userId);

		sb.append(", notificationType=");
		sb.append(notificationType);

		sb.append("}");

		throw new NoSuchCustomNotificationException(sb.toString());
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
	@Override
	public CustomNotification fetchByCompanyUserAndNotificationType_Last(
		long companyId, long userId, String notificationType,
		OrderByComparator<CustomNotification> orderByComparator) {

		int count = countByCompanyUserAndNotificationType(
			companyId, userId, notificationType);

		if (count == 0) {
			return null;
		}

		List<CustomNotification> list = findByCompanyUserAndNotificationType(
			companyId, userId, notificationType, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CustomNotification[]
			findByCompanyUserAndNotificationType_PrevAndNext(
				long customNotificationId, long companyId, long userId,
				String notificationType,
				OrderByComparator<CustomNotification> orderByComparator)
		throws NoSuchCustomNotificationException {

		notificationType = Objects.toString(notificationType, "");

		CustomNotification customNotification = findByPrimaryKey(
			customNotificationId);

		Session session = null;

		try {
			session = openSession();

			CustomNotification[] array = new CustomNotificationImpl[3];

			array[0] = getByCompanyUserAndNotificationType_PrevAndNext(
				session, customNotification, companyId, userId,
				notificationType, orderByComparator, true);

			array[1] = customNotification;

			array[2] = getByCompanyUserAndNotificationType_PrevAndNext(
				session, customNotification, companyId, userId,
				notificationType, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CustomNotification
		getByCompanyUserAndNotificationType_PrevAndNext(
			Session session, CustomNotification customNotification,
			long companyId, long userId, String notificationType,
			OrderByComparator<CustomNotification> orderByComparator,
			boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_CUSTOMNOTIFICATION_WHERE);

		sb.append(_FINDER_COLUMN_COMPANYUSERANDNOTIFICATIONTYPE_COMPANYID_2);

		sb.append(_FINDER_COLUMN_COMPANYUSERANDNOTIFICATIONTYPE_USERID_2);

		boolean bindNotificationType = false;

		if (notificationType.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_COMPANYUSERANDNOTIFICATIONTYPE_NOTIFICATIONTYPE_3);
		}
		else {
			bindNotificationType = true;

			sb.append(
				_FINDER_COLUMN_COMPANYUSERANDNOTIFICATIONTYPE_NOTIFICATIONTYPE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(CustomNotificationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(companyId);

		queryPos.add(userId);

		if (bindNotificationType) {
			queryPos.add(notificationType);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						customNotification)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CustomNotification> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the custom notifications where companyId = &#63; and userId = &#63; and notificationType = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param notificationType the notification type
	 */
	@Override
	public void removeByCompanyUserAndNotificationType(
		long companyId, long userId, String notificationType) {

		for (CustomNotification customNotification :
				findByCompanyUserAndNotificationType(
					companyId, userId, notificationType, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(customNotification);
		}
	}

	/**
	 * Returns the number of custom notifications where companyId = &#63; and userId = &#63; and notificationType = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param notificationType the notification type
	 * @return the number of matching custom notifications
	 */
	@Override
	public int countByCompanyUserAndNotificationType(
		long companyId, long userId, String notificationType) {

		notificationType = Objects.toString(notificationType, "");

		FinderPath finderPath =
			_finderPathCountByCompanyUserAndNotificationType;

		Object[] finderArgs = new Object[] {
			companyId, userId, notificationType
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_CUSTOMNOTIFICATION_WHERE);

			sb.append(
				_FINDER_COLUMN_COMPANYUSERANDNOTIFICATIONTYPE_COMPANYID_2);

			sb.append(_FINDER_COLUMN_COMPANYUSERANDNOTIFICATIONTYPE_USERID_2);

			boolean bindNotificationType = false;

			if (notificationType.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_COMPANYUSERANDNOTIFICATIONTYPE_NOTIFICATIONTYPE_3);
			}
			else {
				bindNotificationType = true;

				sb.append(
					_FINDER_COLUMN_COMPANYUSERANDNOTIFICATIONTYPE_NOTIFICATIONTYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				queryPos.add(userId);

				if (bindNotificationType) {
					queryPos.add(notificationType);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_COMPANYUSERANDNOTIFICATIONTYPE_COMPANYID_2 =
			"customNotification.companyId = ? AND ";

	private static final String
		_FINDER_COLUMN_COMPANYUSERANDNOTIFICATIONTYPE_USERID_2 =
			"customNotification.userId = ? AND ";

	private static final String
		_FINDER_COLUMN_COMPANYUSERANDNOTIFICATIONTYPE_NOTIFICATIONTYPE_2 =
			"customNotification.notificationType = ?";

	private static final String
		_FINDER_COLUMN_COMPANYUSERANDNOTIFICATIONTYPE_NOTIFICATIONTYPE_3 =
			"(customNotification.notificationType IS NULL OR customNotification.notificationType = '')";

	private FinderPath _finderPathWithPaginationFindByCompanyAndUser;
	private FinderPath _finderPathWithoutPaginationFindByCompanyAndUser;
	private FinderPath _finderPathCountByCompanyAndUser;

	/**
	 * Returns all the custom notifications where companyId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @return the matching custom notifications
	 */
	@Override
	public List<CustomNotification> findByCompanyAndUser(
		long companyId, long userId) {

		return findByCompanyAndUser(
			companyId, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CustomNotification> findByCompanyAndUser(
		long companyId, long userId, int start, int end) {

		return findByCompanyAndUser(companyId, userId, start, end, null);
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
	@Override
	public List<CustomNotification> findByCompanyAndUser(
		long companyId, long userId, int start, int end,
		OrderByComparator<CustomNotification> orderByComparator) {

		return findByCompanyAndUser(
			companyId, userId, start, end, orderByComparator, true);
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
	@Override
	public List<CustomNotification> findByCompanyAndUser(
		long companyId, long userId, int start, int end,
		OrderByComparator<CustomNotification> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByCompanyAndUser;
				finderArgs = new Object[] {companyId, userId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCompanyAndUser;
			finderArgs = new Object[] {
				companyId, userId, start, end, orderByComparator
			};
		}

		List<CustomNotification> list = null;

		if (useFinderCache) {
			list = (List<CustomNotification>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CustomNotification customNotification : list) {
					if ((companyId != customNotification.getCompanyId()) ||
						(userId != customNotification.getUserId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_CUSTOMNOTIFICATION_WHERE);

			sb.append(_FINDER_COLUMN_COMPANYANDUSER_COMPANYID_2);

			sb.append(_FINDER_COLUMN_COMPANYANDUSER_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CustomNotificationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				queryPos.add(userId);

				list = (List<CustomNotification>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public CustomNotification findByCompanyAndUser_First(
			long companyId, long userId,
			OrderByComparator<CustomNotification> orderByComparator)
		throws NoSuchCustomNotificationException {

		CustomNotification customNotification = fetchByCompanyAndUser_First(
			companyId, userId, orderByComparator);

		if (customNotification != null) {
			return customNotification;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append(", userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchCustomNotificationException(sb.toString());
	}

	/**
	 * Returns the first custom notification in the ordered set where companyId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching custom notification, or <code>null</code> if a matching custom notification could not be found
	 */
	@Override
	public CustomNotification fetchByCompanyAndUser_First(
		long companyId, long userId,
		OrderByComparator<CustomNotification> orderByComparator) {

		List<CustomNotification> list = findByCompanyAndUser(
			companyId, userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CustomNotification findByCompanyAndUser_Last(
			long companyId, long userId,
			OrderByComparator<CustomNotification> orderByComparator)
		throws NoSuchCustomNotificationException {

		CustomNotification customNotification = fetchByCompanyAndUser_Last(
			companyId, userId, orderByComparator);

		if (customNotification != null) {
			return customNotification;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append(", userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchCustomNotificationException(sb.toString());
	}

	/**
	 * Returns the last custom notification in the ordered set where companyId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching custom notification, or <code>null</code> if a matching custom notification could not be found
	 */
	@Override
	public CustomNotification fetchByCompanyAndUser_Last(
		long companyId, long userId,
		OrderByComparator<CustomNotification> orderByComparator) {

		int count = countByCompanyAndUser(companyId, userId);

		if (count == 0) {
			return null;
		}

		List<CustomNotification> list = findByCompanyAndUser(
			companyId, userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CustomNotification[] findByCompanyAndUser_PrevAndNext(
			long customNotificationId, long companyId, long userId,
			OrderByComparator<CustomNotification> orderByComparator)
		throws NoSuchCustomNotificationException {

		CustomNotification customNotification = findByPrimaryKey(
			customNotificationId);

		Session session = null;

		try {
			session = openSession();

			CustomNotification[] array = new CustomNotificationImpl[3];

			array[0] = getByCompanyAndUser_PrevAndNext(
				session, customNotification, companyId, userId,
				orderByComparator, true);

			array[1] = customNotification;

			array[2] = getByCompanyAndUser_PrevAndNext(
				session, customNotification, companyId, userId,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CustomNotification getByCompanyAndUser_PrevAndNext(
		Session session, CustomNotification customNotification, long companyId,
		long userId, OrderByComparator<CustomNotification> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_CUSTOMNOTIFICATION_WHERE);

		sb.append(_FINDER_COLUMN_COMPANYANDUSER_COMPANYID_2);

		sb.append(_FINDER_COLUMN_COMPANYANDUSER_USERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(CustomNotificationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(companyId);

		queryPos.add(userId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						customNotification)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CustomNotification> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the custom notifications where companyId = &#63; and userId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 */
	@Override
	public void removeByCompanyAndUser(long companyId, long userId) {
		for (CustomNotification customNotification :
				findByCompanyAndUser(
					companyId, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(customNotification);
		}
	}

	/**
	 * Returns the number of custom notifications where companyId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @return the number of matching custom notifications
	 */
	@Override
	public int countByCompanyAndUser(long companyId, long userId) {
		FinderPath finderPath = _finderPathCountByCompanyAndUser;

		Object[] finderArgs = new Object[] {companyId, userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CUSTOMNOTIFICATION_WHERE);

			sb.append(_FINDER_COLUMN_COMPANYANDUSER_COMPANYID_2);

			sb.append(_FINDER_COLUMN_COMPANYANDUSER_USERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				queryPos.add(userId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_COMPANYANDUSER_COMPANYID_2 =
		"customNotification.companyId = ? AND ";

	private static final String _FINDER_COLUMN_COMPANYANDUSER_USERID_2 =
		"customNotification.userId = ?";

	private FinderPath _finderPathFetchByCompanyAndUserNotificationEvent;
	private FinderPath _finderPathCountByCompanyAndUserNotificationEvent;

	/**
	 * Returns the custom notification where companyId = &#63; and userNotificationEventId = &#63; or throws a <code>NoSuchCustomNotificationException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param userNotificationEventId the user notification event ID
	 * @return the matching custom notification
	 * @throws NoSuchCustomNotificationException if a matching custom notification could not be found
	 */
	@Override
	public CustomNotification findByCompanyAndUserNotificationEvent(
			long companyId, long userNotificationEventId)
		throws NoSuchCustomNotificationException {

		CustomNotification customNotification =
			fetchByCompanyAndUserNotificationEvent(
				companyId, userNotificationEventId);

		if (customNotification == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("companyId=");
			sb.append(companyId);

			sb.append(", userNotificationEventId=");
			sb.append(userNotificationEventId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchCustomNotificationException(sb.toString());
		}

		return customNotification;
	}

	/**
	 * Returns the custom notification where companyId = &#63; and userNotificationEventId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param userNotificationEventId the user notification event ID
	 * @return the matching custom notification, or <code>null</code> if a matching custom notification could not be found
	 */
	@Override
	public CustomNotification fetchByCompanyAndUserNotificationEvent(
		long companyId, long userNotificationEventId) {

		return fetchByCompanyAndUserNotificationEvent(
			companyId, userNotificationEventId, true);
	}

	/**
	 * Returns the custom notification where companyId = &#63; and userNotificationEventId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param userNotificationEventId the user notification event ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching custom notification, or <code>null</code> if a matching custom notification could not be found
	 */
	@Override
	public CustomNotification fetchByCompanyAndUserNotificationEvent(
		long companyId, long userNotificationEventId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {companyId, userNotificationEventId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByCompanyAndUserNotificationEvent, finderArgs,
				this);
		}

		if (result instanceof CustomNotification) {
			CustomNotification customNotification = (CustomNotification)result;

			if ((companyId != customNotification.getCompanyId()) ||
				(userNotificationEventId !=
					customNotification.getUserNotificationEventId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_CUSTOMNOTIFICATION_WHERE);

			sb.append(
				_FINDER_COLUMN_COMPANYANDUSERNOTIFICATIONEVENT_COMPANYID_2);

			sb.append(
				_FINDER_COLUMN_COMPANYANDUSERNOTIFICATIONEVENT_USERNOTIFICATIONEVENTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				queryPos.add(userNotificationEventId);

				List<CustomNotification> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByCompanyAndUserNotificationEvent,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									companyId, userNotificationEventId
								};
							}

							_log.warn(
								"CustomNotificationPersistenceImpl.fetchByCompanyAndUserNotificationEvent(long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					CustomNotification customNotification = list.get(0);

					result = customNotification;

					cacheResult(customNotification);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (CustomNotification)result;
		}
	}

	/**
	 * Removes the custom notification where companyId = &#63; and userNotificationEventId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param userNotificationEventId the user notification event ID
	 * @return the custom notification that was removed
	 */
	@Override
	public CustomNotification removeByCompanyAndUserNotificationEvent(
			long companyId, long userNotificationEventId)
		throws NoSuchCustomNotificationException {

		CustomNotification customNotification =
			findByCompanyAndUserNotificationEvent(
				companyId, userNotificationEventId);

		return remove(customNotification);
	}

	/**
	 * Returns the number of custom notifications where companyId = &#63; and userNotificationEventId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userNotificationEventId the user notification event ID
	 * @return the number of matching custom notifications
	 */
	@Override
	public int countByCompanyAndUserNotificationEvent(
		long companyId, long userNotificationEventId) {

		FinderPath finderPath =
			_finderPathCountByCompanyAndUserNotificationEvent;

		Object[] finderArgs = new Object[] {companyId, userNotificationEventId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CUSTOMNOTIFICATION_WHERE);

			sb.append(
				_FINDER_COLUMN_COMPANYANDUSERNOTIFICATIONEVENT_COMPANYID_2);

			sb.append(
				_FINDER_COLUMN_COMPANYANDUSERNOTIFICATIONEVENT_USERNOTIFICATIONEVENTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				queryPos.add(userNotificationEventId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_COMPANYANDUSERNOTIFICATIONEVENT_COMPANYID_2 =
			"customNotification.companyId = ? AND ";

	private static final String
		_FINDER_COLUMN_COMPANYANDUSERNOTIFICATIONEVENT_USERNOTIFICATIONEVENTID_2 =
			"customNotification.userNotificationEventId = ?";

	public CustomNotificationPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(CustomNotification.class);

		setModelImplClass(CustomNotificationImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the custom notification in the entity cache if it is enabled.
	 *
	 * @param customNotification the custom notification
	 */
	@Override
	public void cacheResult(CustomNotification customNotification) {
		entityCache.putResult(
			CustomNotificationImpl.class, customNotification.getPrimaryKey(),
			customNotification);

		finderCache.putResult(
			_finderPathFetchByCompanyAndUserNotificationEvent,
			new Object[] {
				customNotification.getCompanyId(),
				customNotification.getUserNotificationEventId()
			},
			customNotification);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the custom notifications in the entity cache if it is enabled.
	 *
	 * @param customNotifications the custom notifications
	 */
	@Override
	public void cacheResult(List<CustomNotification> customNotifications) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (customNotifications.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (CustomNotification customNotification : customNotifications) {
			if (entityCache.getResult(
					CustomNotificationImpl.class,
					customNotification.getPrimaryKey()) == null) {

				cacheResult(customNotification);
			}
		}
	}

	/**
	 * Clears the cache for all custom notifications.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CustomNotificationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the custom notification.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CustomNotification customNotification) {
		entityCache.removeResult(
			CustomNotificationImpl.class, customNotification);
	}

	@Override
	public void clearCache(List<CustomNotification> customNotifications) {
		for (CustomNotification customNotification : customNotifications) {
			entityCache.removeResult(
				CustomNotificationImpl.class, customNotification);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(CustomNotificationImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		CustomNotificationModelImpl customNotificationModelImpl) {

		Object[] args = new Object[] {
			customNotificationModelImpl.getCompanyId(),
			customNotificationModelImpl.getUserNotificationEventId()
		};

		finderCache.putResult(
			_finderPathCountByCompanyAndUserNotificationEvent, args,
			Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByCompanyAndUserNotificationEvent, args,
			customNotificationModelImpl, false);
	}

	/**
	 * Creates a new custom notification with the primary key. Does not add the custom notification to the database.
	 *
	 * @param customNotificationId the primary key for the new custom notification
	 * @return the new custom notification
	 */
	@Override
	public CustomNotification create(long customNotificationId) {
		CustomNotification customNotification = new CustomNotificationImpl();

		customNotification.setNew(true);
		customNotification.setPrimaryKey(customNotificationId);

		String uuid = PortalUUIDUtil.generate();

		customNotification.setUuid(uuid);

		customNotification.setCompanyId(CompanyThreadLocal.getCompanyId());

		return customNotification;
	}

	/**
	 * Removes the custom notification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param customNotificationId the primary key of the custom notification
	 * @return the custom notification that was removed
	 * @throws NoSuchCustomNotificationException if a custom notification with the primary key could not be found
	 */
	@Override
	public CustomNotification remove(long customNotificationId)
		throws NoSuchCustomNotificationException {

		return remove((Serializable)customNotificationId);
	}

	/**
	 * Removes the custom notification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the custom notification
	 * @return the custom notification that was removed
	 * @throws NoSuchCustomNotificationException if a custom notification with the primary key could not be found
	 */
	@Override
	public CustomNotification remove(Serializable primaryKey)
		throws NoSuchCustomNotificationException {

		Session session = null;

		try {
			session = openSession();

			CustomNotification customNotification =
				(CustomNotification)session.get(
					CustomNotificationImpl.class, primaryKey);

			if (customNotification == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCustomNotificationException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(customNotification);
		}
		catch (NoSuchCustomNotificationException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected CustomNotification removeImpl(
		CustomNotification customNotification) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(customNotification)) {
				customNotification = (CustomNotification)session.get(
					CustomNotificationImpl.class,
					customNotification.getPrimaryKeyObj());
			}

			if (customNotification != null) {
				session.delete(customNotification);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (customNotification != null) {
			clearCache(customNotification);
		}

		return customNotification;
	}

	@Override
	public CustomNotification updateImpl(
		CustomNotification customNotification) {

		boolean isNew = customNotification.isNew();

		if (!(customNotification instanceof CustomNotificationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(customNotification.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					customNotification);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in customNotification proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CustomNotification implementation " +
					customNotification.getClass());
		}

		CustomNotificationModelImpl customNotificationModelImpl =
			(CustomNotificationModelImpl)customNotification;

		if (Validator.isNull(customNotification.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			customNotification.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (customNotification.getCreateDate() == null)) {
			if (serviceContext == null) {
				customNotification.setCreateDate(date);
			}
			else {
				customNotification.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!customNotificationModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				customNotification.setModifiedDate(date);
			}
			else {
				customNotification.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(customNotification);
			}
			else {
				customNotification = (CustomNotification)session.merge(
					customNotification);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			CustomNotificationImpl.class, customNotificationModelImpl, false,
			true);

		cacheUniqueFindersCache(customNotificationModelImpl);

		if (isNew) {
			customNotification.setNew(false);
		}

		customNotification.resetOriginalValues();

		return customNotification;
	}

	/**
	 * Returns the custom notification with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the custom notification
	 * @return the custom notification
	 * @throws NoSuchCustomNotificationException if a custom notification with the primary key could not be found
	 */
	@Override
	public CustomNotification findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCustomNotificationException {

		CustomNotification customNotification = fetchByPrimaryKey(primaryKey);

		if (customNotification == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCustomNotificationException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return customNotification;
	}

	/**
	 * Returns the custom notification with the primary key or throws a <code>NoSuchCustomNotificationException</code> if it could not be found.
	 *
	 * @param customNotificationId the primary key of the custom notification
	 * @return the custom notification
	 * @throws NoSuchCustomNotificationException if a custom notification with the primary key could not be found
	 */
	@Override
	public CustomNotification findByPrimaryKey(long customNotificationId)
		throws NoSuchCustomNotificationException {

		return findByPrimaryKey((Serializable)customNotificationId);
	}

	/**
	 * Returns the custom notification with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param customNotificationId the primary key of the custom notification
	 * @return the custom notification, or <code>null</code> if a custom notification with the primary key could not be found
	 */
	@Override
	public CustomNotification fetchByPrimaryKey(long customNotificationId) {
		return fetchByPrimaryKey((Serializable)customNotificationId);
	}

	/**
	 * Returns all the custom notifications.
	 *
	 * @return the custom notifications
	 */
	@Override
	public List<CustomNotification> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CustomNotification> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<CustomNotification> findAll(
		int start, int end,
		OrderByComparator<CustomNotification> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<CustomNotification> findAll(
		int start, int end,
		OrderByComparator<CustomNotification> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<CustomNotification> list = null;

		if (useFinderCache) {
			list = (List<CustomNotification>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CUSTOMNOTIFICATION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CUSTOMNOTIFICATION;

				sql = sql.concat(CustomNotificationModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<CustomNotification>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the custom notifications from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CustomNotification customNotification : findAll()) {
			remove(customNotification);
		}
	}

	/**
	 * Returns the number of custom notifications.
	 *
	 * @return the number of custom notifications
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(
					_SQL_COUNT_CUSTOMNOTIFICATION);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "customNotificationId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CUSTOMNOTIFICATION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CustomNotificationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the custom notification persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new CustomNotificationModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", CustomNotification.class.getName()));

		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_finderPathWithPaginationFindByUuid_C = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathWithoutPaginationFindByUuid_C = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathCountByUuid_C = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, false);

		_finderPathWithPaginationFindByCompanyUserAndNotificationType =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByCompanyUserAndNotificationType",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					String.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"companyId", "userId", "notificationType"}, true);

		_finderPathWithoutPaginationFindByCompanyUserAndNotificationType =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByCompanyUserAndNotificationType",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					String.class.getName()
				},
				new String[] {"companyId", "userId", "notificationType"}, true);

		_finderPathCountByCompanyUserAndNotificationType = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCompanyUserAndNotificationType",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			new String[] {"companyId", "userId", "notificationType"}, false);

		_finderPathWithPaginationFindByCompanyAndUser = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyAndUser",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"companyId", "userId"}, true);

		_finderPathWithoutPaginationFindByCompanyAndUser = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyAndUser",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"companyId", "userId"}, true);

		_finderPathCountByCompanyAndUser = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyAndUser",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"companyId", "userId"}, false);

		_finderPathFetchByCompanyAndUserNotificationEvent = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByCompanyAndUserNotificationEvent",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"companyId", "userNotificationEventId"}, true);

		_finderPathCountByCompanyAndUserNotificationEvent = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCompanyAndUserNotificationEvent",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"companyId", "userNotificationEventId"}, false);

		_setCustomNotificationUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setCustomNotificationUtilPersistence(null);

		entityCache.removeCache(CustomNotificationImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setCustomNotificationUtilPersistence(
		CustomNotificationPersistence customNotificationPersistence) {

		try {
			Field field = CustomNotificationUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, customNotificationPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = FBOPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = FBOPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = FBOPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private BundleContext _bundleContext;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_CUSTOMNOTIFICATION =
		"SELECT customNotification FROM CustomNotification customNotification";

	private static final String _SQL_SELECT_CUSTOMNOTIFICATION_WHERE =
		"SELECT customNotification FROM CustomNotification customNotification WHERE ";

	private static final String _SQL_COUNT_CUSTOMNOTIFICATION =
		"SELECT COUNT(customNotification) FROM CustomNotification customNotification";

	private static final String _SQL_COUNT_CUSTOMNOTIFICATION_WHERE =
		"SELECT COUNT(customNotification) FROM CustomNotification customNotification WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "customNotification.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CustomNotification exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CustomNotification exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CustomNotificationPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	private FinderPath _createFinderPath(
		String cacheName, String methodName, String[] params,
		String[] columnNames, boolean baseModelResult) {

		FinderPath finderPath = new FinderPath(
			cacheName, methodName, params, columnNames, baseModelResult);

		if (!cacheName.equals(FINDER_CLASS_NAME_LIST_WITH_PAGINATION)) {
			_serviceRegistrations.add(
				_bundleContext.registerService(
					FinderPath.class, finderPath,
					MapUtil.singletonDictionary("cache.name", cacheName)));
		}

		return finderPath;
	}

	private Set<ServiceRegistration<FinderPath>> _serviceRegistrations =
		new HashSet<>();
	private ServiceRegistration<ArgumentsResolver>
		_argumentsResolverServiceRegistration;

	private static class CustomNotificationModelArgumentsResolver
		implements ArgumentsResolver {

		@Override
		public Object[] getArguments(
			FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
			boolean original) {

			String[] columnNames = finderPath.getColumnNames();

			if ((columnNames == null) || (columnNames.length == 0)) {
				if (baseModel.isNew()) {
					return new Object[0];
				}

				return null;
			}

			CustomNotificationModelImpl customNotificationModelImpl =
				(CustomNotificationModelImpl)baseModel;

			long columnBitmask = customNotificationModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					customNotificationModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						customNotificationModelImpl.getColumnBitmask(
							columnName);
				}

				if (finderPath.isBaseModelResult() &&
					(CustomNotificationPersistenceImpl.
						FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
							finderPath.getCacheName())) {

					finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					customNotificationModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			CustomNotificationModelImpl customNotificationModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						customNotificationModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = customNotificationModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

		private static final long _ORDER_BY_COLUMNS_BITMASK;

		static {
			long orderByColumnsBitmask = 0;

			orderByColumnsBitmask |=
				CustomNotificationModelImpl.getColumnBitmask(
					"userNotificationEventId");

			_ORDER_BY_COLUMNS_BITMASK = orderByColumnsBitmask;
		}

	}

}