CREATE DATABASE IF NOT EXISTS db_example2 DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

CREATE TABLE expenses (
    expense_id BIGINT(20) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    item_value DECIMAL(10, 2) NOT NULL,
    item_type VARCHAR(60) NOT NULL,
    item_description VARCHAR(255) NOT NULL,
    gmt_create DATETIME  NOT NULL,
    gmt_update DATETIME,
    user_id BIGINT(20) UNSIGNED  NOT NULL
);