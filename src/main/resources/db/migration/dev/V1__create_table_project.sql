CREATE TABLE IF NOT EXISTS `project` (
  `id` varchar(16) NOT NULL COMMENT '主键',
  `code` varchar(20) NOT NULL,
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


insert IGNORE into `project` (`id`, `code`, `name`) values ('1', 'code1', '项目1');