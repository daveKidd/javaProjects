use dont_wreck_my_house;

insert into province_state (province_state_name)
	select distinct host_state as state
	from all_reservations
	union    
	select distinct guest_state as state
	from all_reservations
	order by state;

select * from province_state;

insert into user (first_name, last_name, email, phone, province_state_id)
	select distinct host_first_name, host_last_name, host_email, host_phone, ps.province_state_id
	from all_reservations ar
	join province_state ps on ps.province_state_name = ar.host_state;

insert into user (first_name, last_name, email, phone, province_state_id)
	select distinct guest_first_name, guest_last_name, guest_email, guest_phone, ps.province_state_id
	from all_reservations ar
	join province_state ps on ps.province_state_name = ar.guest_state;

select * from user;

insert into location (user_id, address, city, postal_code, province_state_id, standard_rate, weekend_rate)
	select distinct u.user_id, host_address, host_city, host_postal_code, ps.province_state_id, standard_rate, weekend_rate
	from all_reservations ar
	join user u on u.email = ar.host_email 
	join province_state ps on ps.province_state_name = ar.host_state
	order by host_address, host_city, host_postal_code;

select * from location;
    
insert into reservation (location_id, guest_user_id, start_date, end_date, total)
	select l.location_id, u.user_id, start_date, end_date, total
	from all_reservations ar
	join user u on u.email = ar.guest_email
	join location l on l.address = ar.host_address and l.city = ar.host_city and l.postal_code = ar.host_postal_code;

select * from reservation;
