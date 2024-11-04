create database bdfilmes;

create table filmes (
id int not null auto_increment primary key,
nomeFilme varchar(300),
genero varchar(150),
duracao int,
dataCadastro date);

-------------------------------------------------------

INSERT INTO filmes (nomeFilme, genero, duracao, dataCadastro) VALUES
("Titanic", "Drama", 180 , "2024-11-01"),
("Os Vingadores", "Fantasia", 140 , "2024-11-01"),
("Procurando Nemo", "Animação", 110 , "2024-11-01"),
("Velozes & Furiosos 7", "Ação", 140 , "2024-11-01"),
("Curtindo a Vida Adoidado", "Comédia", 130 , "2024-11-02");

