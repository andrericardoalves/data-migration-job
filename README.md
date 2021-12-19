# Data Migration - Spring Batch with JDBC.

### Introduction
Spring Batch is an open source framework for batch processing. This project is a example how build a job with framework. 



### Version JDK and Database

- Java: 11
- Docker
- Mysql

### How execute the project in Linux

### Prerequisites

**Clone the project:** https://github.com/andrericardoalves/data-migration-job.git

**Enter docker directory and run:** 
``docker-compose -f docker-compose.yml up``

### Running the project
1. Enter the project directory and run:
   ``mvn spring-boot:run``

### Running Mysql

** After running the project project on terminal : **

1 - `` docker exec -it mysql /bin/bash ``

2 - `` mysql -uroot -proot `` 

3 - `` use data_migration; ``

4 - `` show tables;``

5 - `` select * from person; ``

6 - `` select * from bank_data; ``

## Obs:
After running the project, a new file called **invalid_people.csv** will be created in the files folder.
