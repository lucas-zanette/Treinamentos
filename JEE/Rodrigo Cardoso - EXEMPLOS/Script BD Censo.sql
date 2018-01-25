create database censo;

create table pessoa (
	codigo int(4) unsigned not null auto_increment,
    nome varchar(200),
    endereco varchar(200),
    email varchar(200),
    
    primary key (codigo)
);

create table eletro (
	codigo int(4) unsigned not null auto_increment,
    nome varchar(200),
	qtd int(4),
    codPessoa int(4) unsigned not null,
    
    primary key (codigo)
);

create table pet (
	codigo int(4) unsigned not null auto_increment,
    nome varchar(200),
	especie varchar(200),
    raca varchar(200),
    codPessoa int(4) unsigned not null,
    
    primary key (codigo)
);
