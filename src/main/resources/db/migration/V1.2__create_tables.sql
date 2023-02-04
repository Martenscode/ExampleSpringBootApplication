-- db/migration/V1.2__create_tables.sql

CREATE TABLE IF NOT EXISTS examples (
  name VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL
);

