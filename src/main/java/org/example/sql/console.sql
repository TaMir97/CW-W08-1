create database store;

create table brand(
    brand_id serial primary key,
    brand_name varchar(50) not null,
    website varchar not null,
    description varchar not null
);

create table category(
  category_id serial primary key,
  category_name varchar(50) not null,
  description varchar not null
);

create table product(
    product_id serial primary key,
    product_name varchar(50) not null,
    created_date date,
    category_id int,
    foreign key (category_id) references category (category_id),
    brand_id int,
    foreign key (brand_id) references brand (brand_id)
);

create table users(
    user_id serial primary key,
    name varchar(50) not null,
    user_name varchar(50) unique not null,
    password varchar(50) not null,
    email varchar unique not null
);