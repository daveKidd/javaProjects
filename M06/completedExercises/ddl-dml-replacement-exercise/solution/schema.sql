
drop database if exists dont_wreck_my_house;
create database dont_wreck_my_house;
use dont_wreck_my_house;

create table province_state (
	province_state_id int primary key auto_increment,
    province_state_name varchar(50) not null
);

create table user (
	user_id int primary key auto_increment,
    first_name varchar(25) not null,
    last_name varchar(25) not null,
    email varchar(255) not null,
    phone varchar(50) not null,
	province_state_id int not null,
    constraint fk_user_province_state_id
        foreign key (province_state_id)
        references province_state(province_state_id)    
);

create table location (
	location_id int primary key auto_increment,
	user_id int not null,
    address varchar(100) not null,
    city varchar(100) not null,
	postal_code varchar(20) not null,
	province_state_id int not null,
    standard_rate decimal(8, 2) not null,
	weekend_rate decimal(8, 2) not null,
    constraint fk_location_user_id
        foreign key (user_id)
        references user(user_id),
    constraint fk_location_province_state_id
        foreign key (province_state_id)
        references province_state(province_state_id)            
);

create table reservation (
	reservation_id int primary key auto_increment,
	location_id int not null,
    guest_user_id int not null,
    start_date date not null,
    end_date date not null,
    total decimal(8, 2) not null,
    constraint fk_reservation_location_id
        foreign key (location_id)
        references location(location_id),
    constraint fk_reservation_guest_user_id
        foreign key (guest_user_id)
        references user(user_id)    
);
