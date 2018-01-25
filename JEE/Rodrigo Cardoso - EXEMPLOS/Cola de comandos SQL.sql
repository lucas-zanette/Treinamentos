-- Criar banco de dados.
create database aula;

-- Apaga o banco de dados inteiro, com todas as tabelas.
drop database aula;

-- Criar uma tabela.
create table pessoa (

	codigo int(4) unsigned not null auto_increment,
    nome varchar(200),
    endereco varchar(200),
    email varchar(200),
    
    primary key (codigo)

);

-- Apagar uma tabela.
drop table pessoa;

-- Inserir um novo registro.
insert into pessoa (nome, endereco, email) 
values 
('Rodrigo', 'Rua do Rodrigo', 'ro@ro.com.br');

-- Consulta o conteúdo da tabela.
select * from pessoa;

select count(*), endereco from pessoa group by endereco;

-- Apaga registro da tabela.
delete from pessoa where codigo between 19 and 30;
delete from pessoa where codigo = 21;

-- Alterar um registro da tabela.
update pessoa set
	endereco = 'Rua da Fátima',
    email = 'fatima@hotfat.com'
where
	codigo = 1;
