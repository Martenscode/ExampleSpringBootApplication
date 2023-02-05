#
Spring Boot 2.7.8 <br>
Java 17 <br>
PostgreSQL (Used MyBatis instead of Hibernate) <br>

INFORMATION

0. Set active profile in VM options: -Dspring.profiles.active=<env>
1. Change <db_name> in .properties to your db name.
2. Has dev/test/unit properties set up
3. Swagger documentation at /swagger-ui.html
4. You're gonna have to set up logging yourself
5. Has example Controller, Service and Repository unit tests
6. Health check monitoring at /actuator/health
7. Has flyway migration implemented

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
