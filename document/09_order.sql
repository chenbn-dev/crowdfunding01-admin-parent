-- 订单表
CREATE TABLE `project_crowd`.`t_order`
(
`id` INT NOT NULL AUTO_INCREMENT COMMENT '主键',
`order_num` CHAR(100) COMMENT '订单号',
`pay_order_num` CHAR(100) COMMENT '支付宝流水号',
`order_amount` DOUBLE(10,5) COMMENT '订单金额',
`invoice` INT COMMENT '是否开发票（0 不开，1 开）',
`invoice_title` CHAR(100) COMMENT '发票抬头',
`order_remark` CHAR(100) COMMENT '订单备注',
`address_id` CHAR(100) COMMENT '收货地址 id',
PRIMARY KEY (`id`)
);

-- 收货地址表
CREATE TABLE `project_crowd`.`t_address`
(
`id` INT NOT NULL AUTO_INCREMENT COMMENT '主键',
`receive_name` CHAR(100) COMMENT '收件人',
`phone_num` CHAR(100) COMMENT '手机号',
`address` CHAR(200) COMMENT '收货地址',
`member_id` INT COMMENT '用户 id',
PRIMARY KEY (`id`)
);

-- 项目信息表
CREATE TABLE `project_crowd`.`t_order_project`
(
`id` INT NOT NULL AUTO_INCREMENT COMMENT '主键',
`project_name` CHAR(200) COMMENT '项目名称',
`launch_name` CHAR(100) COMMENT '发起人',
`return_content` CHAR(200) COMMENT '回报内容',
`return_count` INT COMMENT '回报数量',
`support_price` INT COMMENT '支持单价',
`freight` INT COMMENT '配送费用',
`order_id` INT COMMENT '订单表的主键',
PRIMARY KEY (`id`)
);