-- // create user table
-- Migration SQL that makes the change goes here.
CREATE TABLE Users(
  id SERIAL PRIMARY KEY ,
  username VARCHAR(255) NOT NULL ,
  password VARCHAR(255) NOT NULL
)

INSERT INTO users(username, password) VALUES ('test', 'password')


-- //@UNDO
-- SQL to undo the change goes here.
DROP TABLE Users;

