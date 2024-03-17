use dont_wreck_my_house;

select * from all_reservations;

select * from province_state;

select * from user;

select * from location;

select * from reservation;

select *
from reservation r
join location l on l.location_id = r.location_id
join user gu on gu.user_id = r.guest_user_id
join user lu on lu.user_id = l.user_id
join province_state lsp on lsp.province_state_id = l.province_state_id
join province_state gsp on gsp.province_state_id = gu.province_state_id
join province_state lusp on lusp.province_state_id = lu.province_state_id
order by lu.first_name, lu.last_name;
