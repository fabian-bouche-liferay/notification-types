package com.liferay.samples.fbo.notification.listener;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.model.UserNotificationEvent;
import com.liferay.samples.fbo.custom.notification.exception.NoSuchCustomNotificationException;
import com.liferay.samples.fbo.custom.notification.model.CustomNotification;
import com.liferay.samples.fbo.custom.notification.service.CustomNotificationLocalService;

import java.util.Date;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Fabian-Liferay
 */
@Component(
		immediate = true,
		service = ModelListener.class
		)
public class UserNotificationEventListener extends BaseModelListener<UserNotificationEvent> {
	
	private final static Logger LOG = LoggerFactory.getLogger(UserNotificationEventListener.class);
	
	@Override
	public void onAfterCreate(UserNotificationEvent userNotificationEvent) throws ModelListenerException {
	
		if(LOG.isDebugEnabled()) {
			LOG.debug("Create | Payload: {}", userNotificationEvent.getPayload());
		}
		
		long customNotificationId = _counterLocalService.increment(CustomNotification.class.getName());
		
		Date now = new Date();
		
		CustomNotification customNotification = _customNotificationLocalService.createCustomNotification(customNotificationId);
		customNotification.setUserId(userNotificationEvent.getUserId());
		customNotification.setCompanyId(userNotificationEvent.getCompanyId());
		customNotification.setUserNotificationEventId(userNotificationEvent.getUserNotificationEventId());
		customNotification.setCreateDate(now);
		customNotification.setModifiedDate(now);
		customNotification.setNotificationType(getNotificationType(userNotificationEvent.getPayload()));
		
		_customNotificationLocalService.addCustomNotification(customNotification);
	
		super.onAfterCreate(userNotificationEvent);
	}
	
	
	@Override
	public void onAfterUpdate(UserNotificationEvent userNotificationEvent) throws ModelListenerException {
	
		if(LOG.isDebugEnabled()) {
			LOG.debug("Update | Payload: {}", userNotificationEvent.getPayload());
		}

		try {
			CustomNotification customNotification = _customNotificationLocalService.getCustomNotificationByCompanyAndUserNotificationEvent(userNotificationEvent.getCompanyId(), userNotificationEvent.getUserNotificationEventId());

			Date now = new Date();

			customNotification.setUserId(userNotificationEvent.getUserId());
			customNotification.setCompanyId(userNotificationEvent.getCompanyId());
			customNotification.setUserNotificationEventId(userNotificationEvent.getUserNotificationEventId());
			customNotification.setModifiedDate(now);
			customNotification.setNotificationType(getNotificationType(userNotificationEvent.getPayload()));
			
			_customNotificationLocalService.updateCustomNotification(customNotification);
			
		} catch (NoSuchCustomNotificationException e) {
			if(LOG.isErrorEnabled()) {
				LOG.error("Failed to find Custom Notification for Id {}", userNotificationEvent.getUserNotificationEventId(), e);
			}
		}
		
		super.onAfterUpdate(userNotificationEvent);
	}
	
	@Override
	public void onAfterRemove(UserNotificationEvent userNotificationEvent) throws ModelListenerException {

		if(LOG.isDebugEnabled()) {
			LOG.debug("Delete | Payload: {}", userNotificationEvent.getPayload());
		}

		try {
			CustomNotification customNotification = _customNotificationLocalService.getCustomNotificationByCompanyAndUserNotificationEvent(userNotificationEvent.getCompanyId(), userNotificationEvent.getUserNotificationEventId());

			_customNotificationLocalService.deleteCustomNotification(customNotification.getCustomNotificationId());
			
		} catch (NoSuchCustomNotificationException e) {
			if(LOG.isErrorEnabled()) {
				LOG.error("Failed to find Custom Notification for Id {}", userNotificationEvent.getUserNotificationEventId(), e);
			}
		} catch (PortalException e) {
			if(LOG.isErrorEnabled()) {
				LOG.error("Failed to delete Custom Notification for Id {}", userNotificationEvent.getUserNotificationEventId(), e);
			}
		}
		
		super.onAfterRemove(userNotificationEvent);
	}
	
	private String getNotificationType(String payload) {
		JSONObject jsonObject;
		try {
			jsonObject = JSONFactoryUtil.createJSONObject(payload);
		} catch (JSONException e) {
			if(LOG.isWarnEnabled()) {
				LOG.warn("Failed to parse payload {}", payload, e);
			}
			return StringPool.BLANK;
		}
		String entryType = (String) jsonObject.get("entryType");
		
		if(entryType == null) {
			if(LOG.isWarnEnabled()) {
				LOG.warn("Entry type not found in payload {}", payload);
			}
			return StringPool.BLANK;
		} else {
			if(LOG.isDebugEnabled()) {
				LOG.debug("Entry type {} in payload {}", entryType, payload);
			}
			return entryType;
		}
		
	}
	
	@Reference
	private CounterLocalService _counterLocalService;

	@Reference
	private CustomNotificationLocalService _customNotificationLocalService;
	
}