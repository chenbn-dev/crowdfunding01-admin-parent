create table t_member
(
id int(11) not null auto_increment,
loginacct varchar(255) not null,
userpswd char(200) not null,
username varchar(255),
email varchar(255),
authstatus int(4) comment '实名认证状态 0 - 未实名认证， 1 - 实名认证申请中， 2 - 已实名认证',
usertype int(4) comment ' 0 - 个人， 1 - 企业',
realname varchar(255),
cardnum varchar(255),
accttype int(4) comment '0 - 企业， 1 - 个体， 2 - 个人， 3 - 政府',
primary key (id)
);