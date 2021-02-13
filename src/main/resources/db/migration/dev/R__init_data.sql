CREATE TABLE IF NOT EXISTS `sys_user`
(
    `user_id`         int(10) unsigned NOT NULL AUTO_INCREMENT,
    `username`        varchar(200)    NOT NULL unique ,
    `encode_password` varchar(100)       NOT NULL,
    `age`             int(3)           NOT NULL,
    PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP PROCEDURE IF EXISTS sys_user_add_column;
DELIMITER $$
CREATE PROCEDURE sys_user_add_column()
BEGIN
    IF NOT EXISTS
        ( select 1 from information_schema.COLUMNS c where c.TABLE_SCHEMA = (SELECT DATABASE()) and TABLE_NAME ='sys_user' and COLUMN_NAME ='code')
    THEN
        ALTER TABLE sys_user ADD `code` varchar(1024)  NOT NULL COMMENT '编码';
    END IF;
END $$
DELIMITER ;
CALL sys_user_add_column;
DROP PROCEDURE IF EXISTS sys_user_add_column;

insert IGNORE into `sys_user` (`user_id`, `username`, `encode_password`, `age`, `code`) values (1001, '张三', '9999', 18, 'code1');
insert IGNORE into `sys_user` (`user_id`, `username`, `encode_password`, `age`, `code`) values (1002, '李四', '1000', 20, 'code2');