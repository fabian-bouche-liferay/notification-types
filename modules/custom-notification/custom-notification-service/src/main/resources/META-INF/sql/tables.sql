create table FBO_CustomNotification (
	uuid_ VARCHAR(75) null,
	customNotificationId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	userNotificationEventId LONG,
	notificationType VARCHAR(75) null
);