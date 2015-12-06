ALTER TABLE `order_item` 
ADD COLUMN `sku_icon` VARCHAR(200) NULL COMMENT '' AFTER `sku_name`;


ALTER TABLE `order_master` 
ADD COLUMN `payment_type` BIGINT(20) NULL COMMENT '' AFTER `payed_amount`;

ALTER TABLE `order_payment` 
ADD COLUMN `payment_type` BIGINT(20) NULL COMMENT '' AFTER `pay_status`;

ALTER TABLE `order_header` 
ADD COLUMN `payment_type` BIGINT(20) NULL COMMENT '' AFTER `payed_amount`;

ALTER TABLE `order_master` 
CHANGE COLUMN `pay_method` `pay_method` INT(11) NULL COMMENT '支付方式' ;

ALTER TABLE `order_header` 
CHANGE COLUMN `pay_method` `pay_method` INT(11) NULL COMMENT '支付方式' ;

ALTER TABLE `auto007db`.`order_master` 
CHANGE COLUMN `ID` `ID` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '' ;

ALTER TABLE `auto007db`.`order_payment` 
CHANGE COLUMN `pay_method` `pay_method` INT(11) NULL COMMENT '' ;

ALTER TABLE `auto007db`.`order_payment` 
CHANGE COLUMN `payed_amount` `payed_amount` DECIMAL(18,4) NULL COMMENT '' ;
