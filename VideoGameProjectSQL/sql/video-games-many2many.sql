drop database if exists video_games_many_to_many;
create database video_games_many_to_many;
use video_games_many_to_many;

create table console (
    console_id int primary key auto_increment,
    `name` varchar(50) not null
);

create table video_game (
    video_game_id int primary key auto_increment,
    title varchar(50) not null,
    price decimal(5,2) not null,
    release_date date not null,
    single_player bit default 0
);

create table video_game_console (
	video_game_id int not null,
    console_id int not null,
    constraint pk_video_game_console
		primary key (video_game_id, console_id),
	constraint fk_video_game_console_video_game_id
        foreign key (video_game_id)
        references video_game(video_game_id),
    constraint fk_video_game_console_console_id
        foreign key (console_id)
        references console(console_id)
);

insert into console (`name`)
values 
	('PS5'),
	('Nintendo Switch'),
    ('PC');

insert into video_game (title, price, release_date, single_player)
values 
	('Horizon Zero Dawn', 20.00, '2017-07-17', 1),
	('Ratchet and Clank: Rift Apart' , 40.00, '2021-06-11', 1),
    ('Zelda Breath of the Wild' , 40.00, '2020-04-11', 1),
    ('Mario Kart 8' , 40.00, '2019-02-11', 0),
    ('Stray' , 20.00, '2022-07-11', 1),
    ('Overwatch' , 20.00, '2018-06-11', 0),
	('Starcraft 2', 70.00, '2007-02-18', 0);
    
insert into video_game_console (video_game_id, console_id)
values 
	(1,1), -- Horizon on PS5 
	(1,3), -- Horizon on PC
    (2,1), -- Ratchet on PS5
    (3,2), -- Zelda on Switch
    (4,2), -- Mario Kart on Switch
    (5,1), -- Stray on PS5
	(5,2), -- Stray on Switch
    (5,3), -- Stray on PC
    (6,1), -- Overwatch on PS5
    (6,2), -- Overwatch on Switch
    (6,3), -- Overwatch on PC
    (7,3); -- Starcraft 2 on PC