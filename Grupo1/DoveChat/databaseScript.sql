use IF4101_grupo01_dove_chat


create table Users(
 id_user int Primary key auto_increment,
 email varchar(200) not null
)

create table Room(
 id_room int primary key auto_increment,
 version int, 
 name varchar(50),
 room_owner int, foreign key(room_owner) references Users(id_user),
 room_admin int, foreign key(room_admin) references Users(id_user)
)

create table User_Room(
 id_user int, foreign key (id_user) references Users(id_user),
 id_room int, foreign key (id_room) references Room(id_room),
 constraint primaryKeyRoom primary key (id_user,id_room)
)

create table Message(
 id_message int primary key auto_increment,
 id_room int,
 ship_Date Date,
 text varchar(500),
 id_user int
) ENGINE = MYISAM;


create table Metrics(
 room_quantity int,
 user_quantity int,
 user_room_average int,
 last_message_date date,
 first_message_date date,
 most_active_user_message int,
 longest_message int,
 most_active_room int,
 last_created_room int
) ENGINE = MYISAM;


INSERT INTO Users (email) VALUES
('diego.ignacio.vega.rdz@gmailcom')
('meli8538@gmail.com'),
('josuead95@gmail.com'),
('melvin.astorga@gmail.com');

INSERT INTO Room (version, name, room_owner,  room_admin) 
VALUES
(0, 'Informática Empresarial',3 , 4), 
(0, 'Familia Infos',2 , 3), 
(0, 'Trip',1 , 2), 
(0, 'Lenguajes',2 , 1);

Insert INTO  User_Room (id_user,id_room) VALUES 
(1,1), (2,1),(3,1),(4,1)
,(3,2),(2,2),(4,2)
,(1,3),(3,3),(4,3),(2,3)
,(1,4),(3,4),(2,4);


Insert Into Message(ship_Date, id_room, text, id_user)
VALUES 
('2019-1-05', 1,'Hola Chicooos', 1),
('2019-1-05', 1,'Quería informarles acerca de un asunto', 1), 
('2019-1-05', 1,'Qué sería?', 2),
('2019-1-05', 1,'Es super importante, para todos los interesados en machine learning', 1),
('2019-2-04', 2,'Geeks', 2),
('2019-2-05', 2,'heey?', 2),
('2019-2-05', 2,'Alguien llega hoy al recinto?', 2),
('2019-2-05', 2,'Necesitas algo?', 4),
('2019-2-06', 2,'Infooooos', 2),
('2019-2-06', 2,'Dónde vamos hoy?', 3),
('2019-2-06', 3,'Pongan casaa, hacemos vaca para la comida', 3),
('2019-2-06', 3,'Ponemos una peli o algo', 4),
('2019-2-06', 3,'DE MIEDOOO', 2),
('2019-2-06', 3,'x2', 3),
('2019-5-01', 4,'Hola chicos', 1),
('2019-5-02', 4,'Quién va a consulta hoy?', 1),
('2019-5-03', 4,'Hoy no van a recibir lecciones', 3),
('2019-5-03', 4,'Chicos hoy vamos a hacer el laboratorio 3', 4);

