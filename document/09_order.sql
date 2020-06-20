-- ������
CREATE TABLE `project_crowd`.`t_order`
(
`id` INT NOT NULL AUTO_INCREMENT COMMENT '����',
`order_num` CHAR(100) COMMENT '������',
`pay_order_num` CHAR(100) COMMENT '֧������ˮ��',
`order_amount` DOUBLE(10,5) COMMENT '�������',
`invoice` INT COMMENT '�Ƿ񿪷�Ʊ��0 ������1 ����',
`invoice_title` CHAR(100) COMMENT '��Ʊ̧ͷ',
`order_remark` CHAR(100) COMMENT '������ע',
`address_id` CHAR(100) COMMENT '�ջ���ַ id',
PRIMARY KEY (`id`)
);

-- �ջ���ַ��
CREATE TABLE `project_crowd`.`t_address`
(
`id` INT NOT NULL AUTO_INCREMENT COMMENT '����',
`receive_name` CHAR(100) COMMENT '�ռ���',
`phone_num` CHAR(100) COMMENT '�ֻ���',
`address` CHAR(200) COMMENT '�ջ���ַ',
`member_id` INT COMMENT '�û� id',
PRIMARY KEY (`id`)
);

-- ��Ŀ��Ϣ��
CREATE TABLE `project_crowd`.`t_order_project`
(
`id` INT NOT NULL AUTO_INCREMENT COMMENT '����',
`project_name` CHAR(200) COMMENT '��Ŀ����',
`launch_name` CHAR(100) COMMENT '������',
`return_content` CHAR(200) COMMENT '�ر�����',
`return_count` INT COMMENT '�ر�����',
`support_price` INT COMMENT '֧�ֵ���',
`freight` INT COMMENT '���ͷ���',
`order_id` INT COMMENT '�����������',
PRIMARY KEY (`id`)
);