<%@ include file="/init.jsp" %>

<p>
	<b><liferay-ui:message key="customnotification.caption"/></b>
</p>

<ul>
	<c:forEach var="customNotification" items="${customNotificationsByNotificationTypeMap}">
	   <li>${customNotification.key}: ${customNotification.value.size()} elements</li>
	</c:forEach>
</ul>
