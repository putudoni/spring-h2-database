# spring-h2-database
Simple Spring Boot with H2 Database

### Pipeline `Jenkins`

```
MKDIR BOOT-INF\classes
CD BOOT-INF\classes
jar -xvf ..\..\target\account-service-0.0.1-SNAPSHOT_obfuscated.jar com
CD ..\..\
jar uvf target\account-service-0.0.1-SNAPSHOT.jar BOOT-INF
RMDIR /Q/S BOOT-INF
```
