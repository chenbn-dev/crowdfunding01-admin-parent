-- 创建角色到权限之间关联关系的中间表
CREATE TABLE inner_role_auth ( `id` INT NOT NULL AUTO_INCREMENT, `role_id` INT, `auth_id` INT, PRIMARY KEY (`id`) );