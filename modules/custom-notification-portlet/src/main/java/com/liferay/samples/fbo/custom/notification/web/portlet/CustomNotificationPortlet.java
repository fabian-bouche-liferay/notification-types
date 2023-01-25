package com.liferay.samples.fbo.custom.notification.web.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.samples.fbo.custom.notification.exception.NoSuchCustomNotificationException;
import com.liferay.samples.fbo.custom.notification.model.CustomNotification;
import com.liferay.samples.fbo.custom.notification.service.CustomNotificationLocalService;
import com.liferay.samples.fbo.custom.notification.web.constants.CustomNotificationPortletKeys;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Fabian-Liferay
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=CustomNotification",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + CustomNotificationPortletKeys.CUSTOMNOTIFICATION,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class CustomNotificationPortlet extends MVCPortlet {
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		List<CustomNotification> customNotifications;
		customNotifications = _customNotificationLocalService.getCustomNotificationByCompanyAndUser(themeDisplay.getCompanyId(), themeDisplay.getUserId(), 0, 200);
		
		Map<String, List<CustomNotification>> customNotificationsByNotificationTypeMap = customNotifications.stream().collect(Collectors.groupingBy(CustomNotification::getNotificationType));
		
		renderRequest.setAttribute("customNotificationsByNotificationTypeMap", customNotificationsByNotificationTypeMap);
		
		super.doView(renderRequest, renderResponse);
	}
	
	@Reference
	private CustomNotificationLocalService _customNotificationLocalService;
	
	private final static Logger LOG = LoggerFactory.getLogger(CustomNotificationPortlet.class);
	
}