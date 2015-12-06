ALTER TABLE `user_address` 
DROP COLUMN `City_Area_ID`,
ADD COLUMN `province_id` BIGINT(20) NULL COMMENT '' AFTER `last_Modified_by`,
ADD COLUMN `city_id` BIGINT(20) NULL COMMENT '' AFTER `province_id`,
ADD COLUMN `area_id` BIGINT(20) NULL COMMENT '' AFTER `city_id`,
ADD COLUMN `province_name` VARCHAR(100) NULL COMMENT '' AFTER `area_id`,
ADD COLUMN `city_name` VARCHAR(100) NULL COMMENT '' AFTER `province_name`,
ADD COLUMN `area_name` VARCHAR(100) NULL COMMENT '' AFTER `city_name`;


--测试开发使用，只是对seller提供了id和名称
CREATE TABLE `seller` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `Created_TS` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `Created_by` varchar(30) DEFAULT NULL,
  `Last_Modified_TS` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `Last_Modified_By` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `Name_idx` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
