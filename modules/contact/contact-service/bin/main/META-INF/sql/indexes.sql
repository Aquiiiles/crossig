create index IX_4C8FBD7F on AP_Contact_City (name[$COLUMN_LENGTH:75$]);

create index IX_234266B1 on AP_Contact_Street (cityId, name[$COLUMN_LENGTH:75$]);
create index IX_83AC9457 on AP_Contact_Street (name[$COLUMN_LENGTH:75$]);