CREATE DATABASE IF NOT EXISTS expensecenter DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

 CREATE TABLE expenses (
     expense_id BIGINT(20) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
     item_value DECIMAL(10, 2) NOT NULL,
     item_type VARCHAR(60) NOT NULL,
     item_description VARCHAR(255) NOT NULL,
     gmt_create DATETIME  NOT NULL,
     gmt_update DATETIME,
     user_id BIGINT(20) UNSIGNED  NOT NULL
 );

 CREATE TABLE income (
     income_id BIGINT(20) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
     income DECIMAL(10, 2) NOT NULL,
     principal DECIMAL(10, 2) NOT NULL,
     date_start DATETIME  NOT NULL,
     date_end DATETIME  NOT NULL,
     gmt_create DATETIME  NOT NULL,
     gmt_update DATETIME,
     user_id BIGINT(20) UNSIGNED  NOT NULL
 );