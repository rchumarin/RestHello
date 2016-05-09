CREATE DATABASE IF NOT EXISTS contact_manager;
GRANT ALL PRIVILEGES on contact_manager to root@localhost identified by 'root';

USE contact_manager;

CREATE TABLE IF NOT EXISTS contacts (
  id  BIGINT(8) NOT NULL AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  PRIMARY KEY (id)
);