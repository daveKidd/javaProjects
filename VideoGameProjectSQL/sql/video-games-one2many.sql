drop database if exists video_games_one_to_many;
create database video_games_one_to_many;
use video_games_one_to_many;

create table console (
    console_id int primary key auto_increment,
    `name` varchar(50) not null
);

create table video_game (
    video_game_id int primary key auto_increment,
    title varchar(50) not null,
    price decimal(5,2) not null,
    release_date date not null,
    single_player bit default 0,
    console_id int not null,
    constraint fk_video_game_console_id
        foreign key (console_id)
        references console(console_id)
);

insert into console (`name`)
values 
	('PS5'),
	('Nintendo Switch'),
    ('PC');

insert into video_game (title, price, release_date, single_player,console_id)
values 
	('Horizon Zero Dawn', 20.00, '2017-07-17', 1, 1),
	('Ratchet and Clank: Rift Apart' , 40.00, '2021-06-11', 1, 1),
    ('Zelda Breath of the Wild' , 40.00, '2020-04-11', 1, 2),
    ('Mario Kart 8' , 40.00, '2019-02-11', 0, 2),
    ('Stray' , 20.00, '2022-07-11', 1,3),
    ('Overwatch' , 20.00, '2018-06-11', 0, 3),
	('Starcraft 2', 70.00, '2007-02-18', 0,3);