create table users(
   id bigserial primary key not null,
   first_name varchar(50) not null,
   last_name varchar(50) not null,
   login varchar(50) not null,
   password varchar not null
);