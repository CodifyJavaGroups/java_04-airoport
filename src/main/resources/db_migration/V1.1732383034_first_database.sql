create table users(
    id bigserial primary key not null,
    login varchar(50) not null,
    password varchar not null,
    passport_id bigint references passports(id),
    passenger_id bigint references passengers(id),
    date_create_user date not null,
    date_update_user date default now()
);

create table roles(
    id bigserial primary key,
    title varchar(50) unique not null
);

create table m2m_users_roles(
    user_id bigint references users(id),
    role_id bigint references roles(id)
);

create table passports(
    id bigserial primary key,
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    user_passport_id varchar(9) unique not null,
    date_of_expiry date not null,
    date_of_birth date not null
);

create table passengers
(
    id bigserial primary key,
    passport_id bigint references passports(id),
    flight_id bigint references flights(id)
);

create table tickets(
    id bigserial primary key,
    class_of_service varchar(50) not null,
    seat_number varchar(5),
    passenger_id bigint references passengers(id) unique,
    flight_id bigint references flights(id)
);

create table flights(
    id bigserial primary key,
    status varchar(50) not null,
    place_of_departure int references airports(id),
    place_of_arrival int references  airports(id),
    departure_time date not null,
    arrival_time date not null
);

create table airports(
    id bigserial primary key,
    iata_code varchar(10) not null,
    location varchar(255) not null
);

create table airplanes(
    id bigserial primary key,
    model varchar(50) not null,
    manufacturer varchar(50) not null,
    capacity integer not null,
    ready_to_fly boolean not null
);


create table tasks_of_employees(
    id bigserial primary key,
    task text not null,
    employee_id bigint references employees(id)
);

create table employees(
    id bigserial primary key,
    position varchar(50) not null,
    salary decimal(10, 2) not null,
    user_id bigint references users(id)
);

