# spring_using_azure_replicas
In this project, I implement Master-Slave or Primary-Replicas Model into Spring Boot. In this model, all writes and updates happen in master Database; whereas, read operations are distributed across replicas database. This model improves  performance because it allows more queries to be processed in parallel.

![Replica](https://user-images.githubusercontent.com/36349293/193421538-24ba9f66-44a9-4361-89d5-9e6587e2666e.jpeg)


### 1. Please follow this guide to create your Azure Database and it's replicas:
https://learn.microsoft.com/en-us/azure/mysql/single-server/how-to-read-replicas-portal

### 2. After creating Database and it's replica, create a example table:

```sql
CREATE TABLE person(
    id int,
    name varchar(255)
)
```

### 3. Please follow this guide to connect Spring Boot to Azure Database:
https://learn.microsoft.com/en-us/azure/developer/java/spring-framework/configure-spring-data-jdbc-with-azure-sql-server

### 4. Get connection string from Azure Portal and connect to 2 datasources in application.properties file:
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
