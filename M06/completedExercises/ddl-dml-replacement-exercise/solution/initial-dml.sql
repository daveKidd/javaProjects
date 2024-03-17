use dont_wreck_my_house;

insert into province_state (province_state_id, province_state_name)
	values 
		(1, 'TX'),
        (2, 'FL'),
        (3, 'NC');

insert into user (first_name, last_name, email, phone, province_state_id)
	values
		('Kathlyn', 'Yearnes', 'eyearnes0@sfgate.com', '(806) 1783815', 1), -- 1
		('Ernie', 'Harley', 'charley4@apple.com', '(954) 7895760', 2), -- 2
		('Blake', 'Naismith', 'bnaismithhr@skyrock.com', '(915) 2180345', 1), -- 3
		('Deny', 'Lyness', 'dlynessy@icio.us', '(704) 1597211', 3), -- 4
		('Orelee', 'Scales', 'oscalespt@surveymonkey.com', '(915) 6765839', 1); -- 5

-- this is safer... but takes longer to write
set @location1_user_id = (select user_id from user where first_name = 'Kathlyn' and last_name = 'Yearnes');

insert into location (user_id, address, city, postal_code, province_state_id, standard_rate, weekend_rate)
	values
		(@location1_user_id, '3 Nova Trail', 'Amarillo', '79182', 1, 340, 425),
		(2, '1 Maple Wood Terrace', 'Orlando', '32825', 2, 176, 220);
    
insert into reservation (location_id, guest_user_id, start_date, end_date, total)
		values
			(1, 3, '2021-07-31', '2021-08-07', 2550),
			(1, 4, '2021-03-23', '2021-03-26', 1020),
			(2, 5, '2021-09-14', '2021-09-21', 1320);
