ALTER TABLE flyway_dev.project MODIFY COLUMN id varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键';
ALTER TABLE flyway_dev.project ADD state tinyint(4) DEFAULT 1 NOT NULL COMMENT '状态';
