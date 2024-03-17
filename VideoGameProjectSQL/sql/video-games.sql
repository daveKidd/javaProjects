drop database if exists video_games;
create database video_games;
use video_games;

create table video_game (
    video_game_id int primary key auto_increment,
    title varchar(50) not null,
    console varchar(25) not null,
    price decimal(5,2) not null,
    release_date date not null,
    single_player bit default 0
);

insert into video_game (title, console, price, release_date, single_player)
values 
	('Ghost of Tsushima: Director''s Cut', 'PS5', 50.00, '2020-07-17', 1),
	('Ratchet and Clank: Rift Apart' ,'PS5', 40.00, '2021-06-11', 1),
	('Horizon Forbidden West', 'PS5', 70.00, '2022-02-18', 1);