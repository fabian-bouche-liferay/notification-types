create index IX_2768658D on FBO_CustomNotification (companyId, userId, notificationType[$COLUMN_LENGTH:75$]);
create index IX_4D931EF5 on FBO_CustomNotification (companyId, userNotificationEventId);
create index IX_9DD0F002 on FBO_CustomNotification (uuid_[$COLUMN_LENGTH:75$], companyId);