CREATE DATABASE Orbis[B54524]_I_2019

USE [Orbis[B54524]]_I_2019]

CREATE TABLE Editorial(
id_editorial INTEGER IDENTITY(1,1) PRIMARY KEY,
nombre VARCHAR (50) NOT NULL,
direccion VARCHAR (50) NOT NULL,
telefono VARCHAR (9)
)
--DROP TABLE Editorial

CREATE TABLE Libro (
id_libro INTEGER IDENTITY (1,1) PRIMARY KEY,
titulo VARCHAR (50) NOT NULL,
ano SMALLINT NOT NULL,
precio FLOAT (10) NOT NULL,
id_editorial INTEGER FOREIGN KEY REFERENCES Editorial(id_editorial)
)
--DROP TABLE Libro

CREATE TABLE Autor (
id_autor INTEGER IDENTITY (1,1) PRIMARY KEY,
nombre_autor VARCHAR (40) NOT NULL,
apellidos_autor VARCHAR (40) NOT NULL
)
--DROP TABLE Autor

CREATE TABLE Libro_Autor(
id_libro INTEGER FOREIGN KEY REFERENCES Libro(id_libro),
id_autor INTEGER FOREIGN KEY REFERENCES Autor(id_autor),
PRIMARY KEY (id_libro, id_autor)
)
--DROP TABLE Libro_Autor

--INSERT INTO Editorial VALUES ('John Wiley', 'Cartago', '20156398')
--INSERT INTO Editorial VALUES ('Prentice Hall', 'San Jose', '25632158')
--INSERT INTO Editorial VALUES ('Addison Wesley', 'Heredia', '58752103')
--INSERT INTO Editorial VALUES ('McGraw Hill', 'Alajuela', '45632015')

--INSERT INTO Autor 
--VALUES ('Miguel', 'Cervantes')
--INSERT INTO Autor 
--VALUES ('Marcel', 'Proust')
--INSERT INTO Autor 
--VALUES ('Franz', 'Kafka')
--INSERT INTO Autor 
--VALUES ('Leon', 'Toistol')
--INSERT INTO Autor 
--VALUES ('Hernan', 'Melvine')

--INSERT INTO Libro 
--VALUES ('Moby Dick',1900,15000, 1)
--INSERT INTO Libro 
--VALUES ('Odisea',1850,35000, 2)
--INSERT INTO Libro 
--VALUES ('Hamlet',1710,10000.0, 1)

--SELECT * FROM Libro
--SELECT * FROM Autor

--INSERT INTO Libro_Autor 
--VALUES (1,2)
--INSERT INTO Libro_Autor 
--VALUES (1,4)
--INSERT INTO Libro_Autor 
--VALUES (3,3)