-- “ 发起项目 ” 建模
-- 1.1.1   分类表
create table t_type
(
id int(11) not null auto_increment,
name varchar(255) comment '分类名称',
remark varchar(255) comment '分类介绍',
primary key (id)
);
-- 1.1.2  项目分类中间表
create table t_project_type
(
id int not null auto_increment,
projectid int(11),
typeid int(11),
primary key (id)
);
-- 1.1.3 标签表
create table t_tag
(
id int(11) not null auto_increment,
pid int(11),
name varchar(255),
primary key (id)
);
-- 1.1.4 项目标签中间表
create table t_project_tag
(
id int(11) not null auto_increment,
projectid int(11),
tagid int(11),
primary key (id)
);
-- 1.1.5项目表
create table t_project
(
id int(11) not null auto_increment,
project_name varchar(255) comment '项目名称',
project_description varchar(255) comment '项目描述',
money bigint (11) comment '筹集金额',
day int(11) comment '筹集天数',
status int(4) comment '0-即将开始，1-众筹中，2-众筹成功，3-众筹失败',
deploydate varchar(10) comment '项目发起时间',
supportmoney bigint(11) comment '已筹集到的金额',
supporter int(11) comment '支持人数',
completion int(3) comment '百分比完成度',
memberid int(11) comment '发起人的会员 id',
createdate varchar(19) comment '项目创建时间',
follower int(11) comment '关注人数',
header_picture_path varchar(255) comment '头图路径',
primary key (id)
);
-- 1.1.6 项目表项目详情图片表

create table t_project_item_pic
(
id int(11) not null auto_increment,
projectid int(11),
item_pic_path varchar(255),
primary key (id)
);
-- 1.1.7 项目发起人信息表
create table t_member_launch_info
(
id int(11) not null auto_increment,
memberid int(11) comment '会员 id',
description_simple varchar(255) comment '简单介绍',
description_detail varchar(255) comment '详细介绍',
phone_num varchar(255) comment '联系电话',
service_num varchar(255) comment '客服电话',
primary key (id)
);
-- 1.1.8   回报信息表
create table t_return
(
id int(11) not null auto_increment,
projectid int(11),
type int(4) comment '0 - 实物回报， 1 虚拟物品回报',
supportmoney int(11) comment '支持金额',
content varchar(255) comment '回报内容',
count int(11) comment '回报产品限额，“0”为不限回报数量',
signalpurchase int(11) comment '是否设置单笔限购',
purchase int(11) comment '具体限购数量',
freight int(11) comment '运费，“0”为包邮',
invoice int(4) comment '0 - 不开发票， 1 - 开发票',
returndate int(11) comment '项目结束后多少天向支持者发送回报',
describ_pic_path varchar(255) comment '说明图片路径',
primary key (id)
);
-- 1.1.9 发起人确认信息表
create table t_member_confirm_info
(
id int(11) not null auto_increment,
memberid int(11) comment '会员 id',
paynum varchar(200) comment '易付宝企业账号',
cardnum varchar(200) comment '法人身份证号',
primary key (id)
);