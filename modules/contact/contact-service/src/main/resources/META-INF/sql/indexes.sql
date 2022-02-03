create index IX_4C8FBD7F on AP_Contact_City (name[$COLUMN_LENGTH:75$]);

create index IX_8878B472 on AP_Contact_Street (cityId);
create index IX_83AC9457 on AP_Contact_Street (name[$COLUMN_LENGTH:75$]);