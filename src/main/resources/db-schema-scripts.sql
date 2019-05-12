
-- The following is the script to create a database

create database hibernate_examples


-- The following is the script to create an Address table

create table address
(
    id bigint primary key auto_increment,
    street varchar(100),
    zipcode varchar(20),
    country varchar(50)
) AUTO_INCREMENT=1000000;

create table user
(
    id bigint primary key auto_increment,
    first_name varchar(100),
    last_name  varchar(100),
    name  varchar(100),
    password  varchar(100),
    email     varchar(150),
    address_id bigint,
    foreign key (address_id) references Address(id) on delete cascade
) auto_increment=1000000;