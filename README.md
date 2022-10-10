# Azure-SQL-Managed-Instance-and-Failover-Replicas-implemented-with-Spring-Boot
In this project, I implement Master-Slave or Primary-Replicas Model into Spring Boot. In this model, all writes and updates happen in master Database; whereas, read operations are distributed across replicas database. This model improves  performance because it allows more queries to be processed in parallel. 2 Managed Databases are hosted on 2 SQL Managed Instance

<img width="864" alt="Picture1" src="https://user-images.githubusercontent.com/36349293/194906441-9a21652e-8738-4202-8bbd-9ff1218e763a.png">


### 1. After creating Database inside your Primary SQL Managed Instance, create a example table:

```sql
CREATE TABLE person(
    id int,
    name varchar(255)
)
```

### 2. Next, please follow this guide to setup Secondary SQL Managed Instance for your original database on SQL Managed Instance
https://learn.microsoft.com/en-us/azure/azure-sql/managed-instance/failover-group-add-instance-tutorial?view=azuresql&tabs=azure-portal


### 3. Please follow this guide to open public endpoint for your SQL Managed Instance:
https://learn.microsoft.com/en-us/azure/azure-sql/managed-instance/public-endpoint-configure?view=azuresql


### 4. Please follow this guide to connect Spring Boot to SQL Managed Instance Using Connection String:
https://learn.microsoft.com/en-us/azure/developer/java/spring-framework/configure-spring-data-jdbc-with-azure-sql-server


### 4. Get connection string from 2 SQL Managed Instance and connect to 2 datasources in application.properties file:
```properties
#AZURE PRIMARY DATASOURCE
spring.datasource.jdbc-url=...
spring.datasource.driver-class-name=com.microsoft.sqlserver.jdbc.SQLServerDriver
spring.datasource.username=...
spring.datasource.password=...

#AZURE REPLICA DATASOURCE
db2.datasource.driver-class-name=com.microsoft.sqlserver.jdbc.SQLServerDriver
db2.datasource.jdbc-url = ...
db2.datasource.username = ...
db2.datasource.password = ...
```
