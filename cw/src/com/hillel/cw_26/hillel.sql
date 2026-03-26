# CREATE DATABASE IF NOT EXISTS hillel;
#
# CREATE TABLE users (
#     id INT PRIMARY KEY AUTO_INCREMENT,
#     name VARCHAR(100) NOT NULL,
#     email VARCHAR(150) NOT NULL UNIQUE
#     );

INSERT INTO users (name, email)
VALUES ('Alice Smith', 'alice@example.com');

select * from users;

select * from users where name = 'Alice Smith';
select * from users where id >= 5;

INSERT INTO users (name, email)
VALUES ('Alice Mist', 'alice@example.com');
INSERT INTO users (name, email)
VALUES ('Mist Alice', 'alice@example.com');

select * from users where name like '%Alice%'

TRUNCATE TABLE users;

ALTER TABLE users
    ADD COLUMN age INT,
    ADD COLUMN sex VARCHAR(1);

INSERT INTO users (name, email, age, sex)
VALUES
    ('User1', 'user1@example.com', 25, 'M'),
    ('User2', 'user2@example.com', 30, 'F'),
    ('User3', 'user3@example.com', 22, 'M'),
    ('User4', 'user4@example.com', 28, 'F'),
    ('User5', 'user5@example.com', 35, 'M'),
    ('User6', 'user6@example.com', 27, 'F'),
    ('User7', 'user7@example.com', 31, 'M'),
    ('User8', 'user8@example.com', 24, 'F'),
    ('User9', 'user9@example.com', 29, 'M'),
    ('User10', 'user10@example.com', 33, 'F'),
    ('User11', 'user11@example.com', 26, 'M'),
    ('User12', 'user12@example.com', 21, 'F'),
    ('User13', 'user13@example.com', 34, 'M'),
    ('User14', 'user14@example.com', 28, 'F'),
    ('User15', 'user15@example.com', 32, 'M');

delete from users where id > 0;

select count(sex) from users where sex = 'F';
select count(sex) from users where sex = 'M';


select avg(age) from users where sex = 'F';
select avg(age) from users where sex = 'M';

ALTER TABLE users
    ADD COLUMN salary INT default 10000;

UPDATE users
SET salary = CASE
                 WHEN age >= 20 AND age < 25 THEN salary * 1.5
                 WHEN age >= 25 AND age <= 30 THEN salary * 2
                 WHEN age > 30 THEN salary * 2.5
    END
WHERE age > 20;
