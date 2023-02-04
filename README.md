#
Spring Boot 2.7.8
Java 17
PostgreSQL

INFORMATION
1. Change <db_name> in .properties to your db name.
2. Used MyBatis instead of Hibernate
3. Swagger documentation at /swagger-ui.html
4. Has dev/test/unit properties set up
5. You're gonna have to set up logging yourself
6. Has example Controller, Service and Repository tests
7. Health check monitoring at /actuator/health

#

1. Set up databases
    - Create database
    - Create tables
2. Change code according to your database
3. Build and run

#

- psql -U postgres
- pw: postgres
- \l = show list
- \d or \dt = show tables
- \c <db_name> = connect
