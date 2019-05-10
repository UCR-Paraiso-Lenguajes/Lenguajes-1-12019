create database IF4101_grupo01_dove_chat

create table Users(
id_user int Primary key identity(1,1),
email varchar(320) not null)

create table Room(
id_room int, primary key identity,
version int, 
name varchar(50),
room_owner int, foreign key(room_owner) references Users(id_user),
room_admin int, foreign key(room_admin) references Users(id_user))


create table Message(
id_message int, primary key identity,
id_room int,
ship_Date Date,
text varchar(500)
id_user int)


create table User_Room
(id_user int, foreign key (id_user) references Users(id_user),
id_room int, foreign key (id_room) references Room(id_room)
constraint primaryKeyRoom primary key (id_user,id_room))

create table Metrics(
room_quantity int,
user_quantity int,
user_room_average int,
last_message_date date,
first_message_date date,
most_active	_user_message int,
longest_message int,
most_active_room int,
last_created_room int)

