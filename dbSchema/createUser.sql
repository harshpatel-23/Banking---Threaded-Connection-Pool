CREATE USER 'cs532_user'@'localhost' IDENTIFIED BY 'pswdForBankDb';

GRANT ALL PRIVILEGES ON bankdb.* TO 'cs532_user'@'localhost' WITH GRANT OPTION;

SHOW GRANTS FOR 'cs532_user'@'localhost';