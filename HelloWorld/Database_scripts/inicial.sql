create table risk (
riskId varchar(20),
funcA varchar(20),
funcB varchar(20),
funcC varchar(20),
funcD varchar(20),
unk varchar(20),
processId varchar(20),
riskLvl int,
active boolean,
risktype int
);

create table riskDesc(
riskId varchar(20),
lang char(2),
description varchar(255),
detdescription varchar(2550)
);

create table busProc(
busProcId varchar(20),
lang char(2),
description varchar(255)
);

create table functions(
funcId varchar(20),
lang char(2),
description varchar(255)
);

create table function_busproc(
funcId varchar(20),
busProcId varchar(20)
);

create table transactions(
funcId varchar(20),
transactionId varchar(255),
status boolean
);

create table authorizations(
funcId varchar(20),
transactionId varchar(255),
object varchar(255),
field varchar (255),
low varchar(255),
high varchar(255),
operator varchar(3),
status boolean
);

create table rulesets(
rulesetId varchar(20),
lang char(2),
description varchar(255)
);

create table risk_ruleset(
riskId varchar(20),
rulesetId varchar(20)
);

