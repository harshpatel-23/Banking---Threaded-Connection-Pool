CREATE SCHEMA `bankdb` ;

CREATE TABLE `bankdb`.`account` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `acctnum` VARCHAR(5) NOT NULL,
  `balance` DECIMAL(9,2) ZEROFILL NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `acctnum_UNIQUE` (`acctnum` ASC));
  
INSERT INTO `bankdb`.`account` (`acctnum`, `balance`) VALUES ('AB682', '150.75');
INSERT INTO `bankdb`.`account` (`acctnum`, `balance`) VALUES ('GA379', '45.56');
  