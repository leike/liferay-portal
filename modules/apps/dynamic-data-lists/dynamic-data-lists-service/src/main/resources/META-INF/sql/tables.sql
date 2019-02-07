create table DDLRecord (
	mvccVersion LONG default 0 not null,
	uuid_ VARCHAR(75) null,
	recordId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	versionUserId LONG,
	versionUserName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	DDMStorageId LONG,
	recordSetId LONG,
	recordSetVersion VARCHAR(75) null,
	version VARCHAR(75) null,
	displayIndex INTEGER,
	lastPublishDate DATE null
);

create table DDLRecordSet (
	mvccVersion LONG default 0 not null,
	uuid_ VARCHAR(75) null,
	recordSetId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	versionUserId LONG,
	versionUserName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	DDMStructureId LONG,
	recordSetKey VARCHAR(75) null,
	version VARCHAR(75) null,
	name STRING null,
	description_ STRING null,
	minDisplayRows INTEGER,
	scope INTEGER,
	settings_ TEXT null,
	lastPublishDate DATE null
);

create table DDLRecordSetVersion (
	mvccVersion LONG default 0 not null,
	recordSetVersionId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	recordSetId LONG,
	DDMStructureVersionId LONG,
	name STRING null,
	description_ STRING null,
	settings_ TEXT null,
	version VARCHAR(75) null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null
);

create table DDLRecordVersion (
	mvccVersion LONG default 0 not null,
	recordVersionId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	DDMStorageId LONG,
	recordSetId LONG,
	recordSetVersion VARCHAR(75) null,
	recordId LONG,
	version VARCHAR(75) null,
	displayIndex INTEGER,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null
);