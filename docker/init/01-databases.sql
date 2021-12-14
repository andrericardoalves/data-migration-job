# create databases
CREATE DATABASE IF NOT EXISTS spring_batch;
CREATE DATABASE IF NOT EXISTS data_migration;

# create root user and grant rights
CREATE USER 'user'@'localhost' IDENTIFIED BY 'user123';
GRANT ALL PRIVILEGES ON * . * TO 'user'@'localhost';